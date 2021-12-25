import java.util.Scanner;

public class soal2 {
    public static void main(String[] args) {
        Double GajiPokok, Tunjangan, Pajak, GajiBersih;
         Scanner input=new Scanner(System.in);
         //menampilkan output berapa gaji anda
         System.out.println("Masukkan nominal gaji pokok anda");
         System.out.println("Gaji Pokok = ");
         //menyimpan gaji pokok
         GajiPokok= input.nextDouble();
         //rumus tunjangan
         Tunjangan= (GajiPokok*20/100);
         //rumus pajak
         Pajak= (GajiPokok*15/100);
         //rumus gaji bersih
         GajiBersih= ((GajiPokok+Tunjangan)-Pajak);
         //print hasil
         System.out.println("Tunjangan = "+"Rp."+ Tunjangan);
         System.out.println("Pajak = "+"Rp."+ Pajak);
         System.out.println("Gaji Bersih = "+"Rp."+ GajiBersih);
    }
}
