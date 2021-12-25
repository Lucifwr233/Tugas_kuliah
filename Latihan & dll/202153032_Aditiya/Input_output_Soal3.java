import java.util.Scanner;

public class soal3 {
     public static void main(String[] args) {
        int TotalHargaBarang, JumlahBarang, Diskon, JumlahBayar, HarAfterDiskon,PersentaseDiskon;
        Scanner input=new Scanner(System.in);
        System.out.println("Selamat anda mendapatkan diskon 5% tiap barang");
        System.out.println("Masukkan Nilai Nominal Pembelian = ");
        TotalHargaBarang= input.nextInt();
        //penentuan jumlah barang dan diskon
        System.out.println("Masukkan Jumlah Barang = ");
        JumlahBarang= input.nextInt();
        PersentaseDiskon= (int) (JumlahBarang*5);
        Diskon= (int) (0.05*TotalHargaBarang);
        HarAfterDiskon= TotalHargaBarang-Diskon*JumlahBarang;
        JumlahBayar= HarAfterDiskon;
        //print hasillllllll
            System.out.println("Harga Barang                = "+"Rp."+TotalHargaBarang);
            System.out.println("Jumlah Barang               = "+JumlahBarang);
            System.out.println("Diskon                      = "+PersentaseDiskon +"%");
            System.out.println("Total yang harus dibayar    = "+"Rp."+JumlahBayar*JumlahBarang);
                
    }
}
