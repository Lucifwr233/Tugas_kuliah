import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

String koneksi="jdbc:mysql://localhost/dbkisikisi";
    String user="root";
    String pass="";
    Connection connection;
    Statement statement;
    
    private void bersih()
    {
        txtkode.setText("");
        txtnama.setText("");
        txtuts.setText("");
        txtuas.setText("");
        txtangka.setText("");
        txthuruf.setText("");
        txtkode.requestFocus();
        txtkode.setEnabled(true);
        optbaru.setSelected(true);
        optedit.setSelected(false);
        cmdhapus.setEnabled(false);
        cmdsimpan.setEnabled(false);
        try{
            String sql = "select * from tb_nilai";
            ResultSet rs = statement.executeQuery(sql);           
            final String[] headers={"Kode Pelajaran","Nama Pelajaran","Nilai UTS","Nilai UAS","Nilai Angka","Nilai Huruf"};            
            rs.last();
            int n=rs.getRow();            
            Object[][] data=new Object[n][6];
            int p=0;
            rs.beforeFirst();
            while (rs.next()){  
                data[p][0]=rs.getString(1);
                data[p][1]=rs.getString(2);
                data[p][2]=rs.getString(3);
                data[p][3]=rs.getString(4);
                data[p][4]=rs.getString(5);
                data[p][5]=rs.getString(6);
                p++;
            }
            grdnilai.setModel(new javax.swing.table.DefaultTableModel(data,headers));
            grdnilai.setAlignmentX(CENTER_ALIGNMENT);
        }
        catch (Exception DBException)
        {
            System.err.println("Error : " + DBException);
        }
    }
    
    
    private void txtkodeFocusLost(java.awt.event.FocusEvent evt) {                                  
        try
        {
            String sql = "select * from tb_nilai where kode='" + txtkode.getText() + "'";
            ResultSet rs = statement.executeQuery(sql);
            rs.last();
            int n=rs.getRow();
            if (n>0)
            {
                JOptionPane.showMessageDialog(this, "kode ('" + txtkode.getText() + "')"
                    + " sudah ada, Silahkan Ganti..!!",
                    "Peringatan",JOptionPane.WARNING_MESSAGE);
                bersih();
            }
        }
        catch(Exception DBException)
        {
            JOptionPane.showMessageDialog(this, "Koneksi Gagal 2",
                "Error",JOptionPane.ERROR_MESSAGE);
            bersih();
        }
        // TODO add your handling code here:
    }                                 

    private void txtkodeKeyReleased(java.awt.event.KeyEvent evt) {                                    
        if (txtkode.getText().equals(""))
        {
            cmdsimpan.setEnabled(false);
        }
        else
        {
            cmdsimpan.setEnabled(true);
        }
        // TODO add your handling code here:
    }                                   

    private void cmdhapusMouseClicked(java.awt.event.MouseEvent evt) {                                      
        if (cmdhapus.isEnabled()==false)
        {
            return;
        }
        try
        {
            String sql="delete from tb_nilai where kode='" + txtkode.getText() +"'";
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Hapus Data Berhasil",
                "Informasi",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception DBException)
        {
            JOptionPane.showMessageDialog(this, "Hapus Data Gagal",
                "Error",JOptionPane.ERROR_MESSAGE);
            System.err.println("Error : " + DBException);
        }
        bersih();
        // TODO add your handling code here:
    }                                     

    private void cmdsimpanMouseClicked(java.awt.event.MouseEvent evt) {                                       
        int uts, uas, angka, huruf;
        uts=Integer.parseInt(txtuts.getText());
        uas=Integer.parseInt(txtuas.getText());
        angka= (uts*30/100)+(uas*70/100);
        txtangka.setText(String.valueOf(angka+""));
            if (angka < 25)
            {
                txthuruf.setText("E");
            }
            if (angka >= 25 && angka < 55)
            {
                txthuruf.setText("D");
            }
            if (angka >= 55 && angka < 75)
            {
                txthuruf.setText("C");
            }
            if (angka >= 75 && angka <= 90)
            {
                txthuruf.setText("B");
            }
            if (angka > 90)
            {
                txthuruf.setText("A");
            }
            
        if (cmdsimpan.isEnabled()==false)
        {
            return;
        }
        try
        {
            String sql;
            if(optbaru.isSelected())
            {
                sql="insert into tb_nilai values('";
                sql+=txtkode.getText()+"','";
                sql+=txtnama.getText()+"','";
                sql+=txtuts.getText()+"','";
                sql+=txtuas.getText()+"','";
                sql+=txtangka.getText()+"','";
                sql+=txthuruf.getText()+"')";
            }
            else
            {
                sql="update tb_nilai set nama='";
                sql+=txtnama.getText()+"',nilaiuts='";
                sql+=txtuts.getText()+"',nilaiuas='";
                sql+=txtuas.getText()+"',nilaiangka='";
                sql+=txtangka.getText()+"',nilaihuruf='";
                sql+=txthuruf.getText()+"' ";
                sql+="where kode='" + txtkode.getText()+"'";
            }
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Simpan / Update Data Berhasil",
                "Informasi",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception DBException)
        {
            JOptionPane.showMessageDialog(this, "Simpan / Update Data Gagal",
                "Error",JOptionPane.ERROR_MESSAGE);
            System.err.println("Error : " + DBException);
        }
        bersih();
        // TODO add your handling code here:
    }                                      

    private void optbaruMouseClicked(java.awt.event.MouseEvent evt) {                                     
        bersih();
        // TODO add your handling code here:
    }                                    

    private void opteditMouseClicked(java.awt.event.MouseEvent evt) {                                     
        if(grdnilai.getRowCount()<1)
        {
            JOptionPane.showMessageDialog(this, "Tidak ada data untuk diedit..!!",
                "Peringatan",JOptionPane.WARNING_MESSAGE);
            bersih();
        }
        // TODO add your handling code here:
    }                                    

    private void grdnilaiMouseClicked(java.awt.event.MouseEvent evt) {                                      
        if (optedit.isSelected())
        {
            txtkode.setText(grdnilai.getValueAt(grdnilai.getSelectedRow(),0).toString());
            txtnama.setText(grdnilai.getValueAt(grdnilai.getSelectedRow(),1).toString());
            txtuts.setText(grdnilai.getValueAt(grdnilai.getSelectedRow(),2).toString());
            txtuas.setText(grdnilai.getValueAt(grdnilai.getSelectedRow(),3).toString());
            txtangka.setText(grdnilai.getValueAt(grdnilai.getSelectedRow(),4).toString());
            txthuruf.setText(grdnilai.getValueAt(grdnilai.getSelectedRow(),5).toString());
        }
        txtkode.setEnabled(false);
        cmdhapus.setEnabled(true);
        cmdsimpan.setEnabled(true);
        // TODO add your handling code here:
    }                                     

    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi="jdbc:mysql://localhost/dbkisikisi";
            connection=DriverManager.getConnection(koneksi,user,pass);
            statement=connection.createStatement();
        }
        catch(Exception DBException)
        {
            JOptionPane.showMessageDialog(this, "Koneksi Gagal 1",
                    "Error",JOptionPane.ERROR_MESSAGE);
            System.err.println("Error : " + DBException);
        }
        bersih();
