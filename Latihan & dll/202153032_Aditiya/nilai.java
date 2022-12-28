import static java.awt.Component.CENTER_ALIGNMENT;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

    String koneksi="jdbc:mysql://localhost:3306/dbkisikisi";
    String user = "root";
    String pass = "";
    Connection connection;
    Statement statement;
    
//prosedure hitung
    private String hitung(String... utm){    
        for (int i = 0; i < utm.length; i++){
                if(utm[i].isEmpty()){
                    utm[i] = "0";
                }
        }
        double t1=0,t2=0;
        for (int i = 0; i < utm.length; i++) {
            double cv = Double.valueOf(utm[i]);
            switch (i) {
                case 0:
                    t1 = cv * 0.4;
                    break;
                case 1:
                    t2 = cv * 0.6;
                    break;
                default:
                    break;
            }
        }
        double jumlah = t1+t2;
        double as = Math.round(jumlah); //dibulatkan
        String cvJumlah = indexOF(as);
        return cvJumlah;
    }
    
//prosedure jumlah
    public String indexOF(double b){
        String hsl;
        if(b %1 == 0){
            hsl = String.valueOf(b).substring(0,String.valueOf(b).lastIndexOf("."));
        }else{
            hsl = String.valueOf(b);
        }
        return hsl;
    }
    
//prosedure nilaihuruf
    private String calAbjad(String jumlah){
        String nilai = "";
        double b = Double.valueOf(jumlah);
        if(b <= 100 && b >= 90){
            nilai = "A";
        }else if(b <= 89 && b >= 70){
            nilai = "B";
        }else if(b <= 69){
            nilai = "C";
        }
        return nilai;
    }
    
//prosedure bersih
        private void bersih(){
        txkode.setText("");
        txnama.setText("");
        txuts.setText("");
        txuas.setText("");
        txangka.setText("");
        txhuruf.setText("");
        txkode.requestFocus();
        txkode.setEnabled(true);
        optbaru.setSelected(true);
        optedit.setSelected(false);
        cmdhapus.setEnabled(false);
        cmdsimpan.setEnabled(false);
        txangka.setVisible(false);
        txhuruf.setVisible(false);
        texthuruf.setVisible(false);
        textangka.setVisible(false);
        
        try{
            String sql="select * from tb_nilai";
            ResultSet rs=statement.executeQuery(sql);
            final String[] headers={"Kode","Nama","Uts","Uas","Angka","Huruf"};
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
        catch(Exception DBException){
            System.err.println("Error : " + DBException);
        }
        
    }
    
//KELUAR
    private void btnkeluarMouseClicked(java.awt.event.MouseEvent evt) {                                       
        System.exit(0);
    }                                      

//FORM WINDOW OPENED
    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String koneksi="jdbc:mysql://localhost:3306/dbkisikisi";
            Connection connection=DriverManager.getConnection(koneksi, user, pass);
            statement = connection.createStatement();
        }
        catch(Exception DBException){
            JOptionPane.showMessageDialog(this,"Koneksi Gagal", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error : "+ DBException);
        }
        bersih();
    }                                 

//OPT BARU CLICK
    private void optbaruMouseClicked(java.awt.event.MouseEvent evt) {                                     
        bersih();
    }                                    

//KODE KEY RELEASED
    private void txkodeKeyReleased(java.awt.event.KeyEvent evt) {                                   
        if (txkode.getText().equals("")){
            cmdsimpan.setEnabled(false);
        }else{
            cmdsimpan.setEnabled(true);
        }
    }                                  

//KODE FOCUS LOST
    private void txkodeFocusLost(java.awt.event.FocusEvent evt) {                                 
                try{
            String sql="select * from tb_nilai where kode= '" + txkode.getText() + "'";
            ResultSet rs=statement.executeQuery(sql);
            rs.last();
            int n= rs.getRow();
            if (n>0){
                JOptionPane.showMessageDialog(this, "Kode ('" +txkode.getText()+"')"+ " sudah ada, silahkan ganti !", "Peringatan", JOptionPane.WARNING_MESSAGE);
                bersih();
            }
        }
        catch(Exception DBException){
            JOptionPane.showMessageDialog(this,"Koneksi Gagal", "Error",JOptionPane.ERROR_MESSAGE);
        bersih();
        }
    }                                

//CMD HAPUS
    private void cmdhapusMouseClicked(java.awt.event.MouseEvent evt) {                                      
        if (cmdhapus.isEnabled()==false){
            return;
        }
        try{
            String sql="delete from tb_nilai where kode='" + txkode.getText() + "'";
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Hapus data berhasil", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception DBException){
           JOptionPane.showMessageDialog(this, "Hapus data gagal", "Error", JOptionPane.ERROR_MESSAGE);
           System.err.println("Error : " + DBException);
        }
        bersih();
    }                                     

//OPT EDIT
    private void opteditMouseClicked(java.awt.event.MouseEvent evt) {                                     
        if(grdnilai.getRowCount()<1){
            JOptionPane.showMessageDialog(this, "Tidak ada data untuk diedit !", "Peringatan", JOptionPane.WARNING_MESSAGE);
        bersih();
        }
    }                                    

//CMD SIMPAN
    private void cmdsimpanMouseClicked(java.awt.event.MouseEvent evt) {                                       
        String uts = txuts.getText();
        String uas = txuas.getText();
        String[] data = {uts, uas};
            
        String jml = hitung(data);
        txangka.setText(hitung(data));
        txhuruf.setText(calAbjad(jml));
        
        if(cmdsimpan.isEnabled()==false){
            return;
        }
        
        try{
            String sql;
            if(optbaru.isSelected()){
                sql="insert into tb_nilai values('";
                sql+=txkode.getText()+"','";
                sql+=txnama.getText()+"','";
                sql+=txuts.getText()+"','";
                sql+=txuas.getText()+"','";
                sql+=txangka.getText()+"','";
                sql+=txhuruf.getText()+"')";
            }
            else{
                sql="update tb_nilai set nama='";
                sql+=txnama.getText()+"',nilaiuts='";
                sql+=txuts.getText()+"',nilaiuas='";
                sql+=txuas.getText()+"',nilaiangka='";
                sql+=txangka.getText()+"',nilaihuruf='";
                sql+=txhuruf.getText()+"' ";
                sql+="where kode='"+txkode.getText()+"'";
            }
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Simpan / Update Data Berhasil",
                        "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception DBException){
            JOptionPane.showMessageDialog(this, "Simpan / Update Data Gagal",
                   "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error : " + DBException);
        }
        bersih();        
    }                                      

//GRD NILAI
    private void grdnilaiMouseClicked(java.awt.event.MouseEvent evt) {                                      
        if(optedit.isSelected()){
        txkode.setText(grdnilai.getValueAt(grdnilai.getSelectedRow(), 0).toString());
        txnama.setText(grdnilai.getValueAt(grdnilai.getSelectedRow(), 1).toString());
        txuts.setText(grdnilai.getValueAt(grdnilai.getSelectedRow(), 2).toString());
        txuas.setText(grdnilai.getValueAt(grdnilai.getSelectedRow(), 3).toString());
        txangka.setText(grdnilai.getValueAt(grdnilai.getSelectedRow(),4).toString());
        txhuruf.setText(grdnilai.getValueAt(grdnilai.getSelectedRow(),5).toString());
        }
        //txkode.setEnabled(false);
        cmdhapus.setEnabled(true);
        cmdsimpan.setEnabled(true);
    }  
