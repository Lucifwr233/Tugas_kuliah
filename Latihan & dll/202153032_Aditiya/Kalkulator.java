import java.text.DecimalFormat;
import java.util.Scanner;

public class method {
       static Double bil1,bil2,jumlah;
       static Scanner input = new Scanner (System.in);
       
    public static void main(String[] args) {
        int pilihan;
        menu();
        
        System.out.println("    Silahkan pilih menu:   ");
        System.out.println("---------------------------");
        pilihan = input.nextInt();
        pilihan(pilihan);
        System.out.println("Hasil Penjumlahan :  ");
        decimal(jumlah);
    }
    
    static void menu (){
        System.out.println("------Menu Kalkulator------");
        System.out.println("                           ");
        System.out.println("      1.Penjumlahan        ");
        System.out.println("      2.Pengurangan        ");
        System.out.println("      3.Perkalian          ");
        System.out.println("      4.Pembagian          ");
        System.out.println("---------------------------");
    }
    static void pilihan (int pil){
        System.out.println("Masukkan angka 1 : ");
        bil1 = input.nextDouble();
        System.out.println("Masukkan angka 2 : ");
        bil2 = input.nextDouble();
        
        switch(pil){
           case 1:
               jumlah=penjumlahan (bil1,bil2);
               break;
           case 2:
               jumlah = pengurangan(bil1,bil2);
               break;
           case 3:
               jumlah = perkalian(bil1,bil2);
               break;
           case 4:
               jumlah = pembagian(bil1,bil2);
               break;
           default: 
                System.out.println("Masukkan pilihan dengan benar!");
        }
    }
    static double penjumlahan (double a, double b){
        //untuk penjumlahan
        double sum;
         sum = a+b;
          return sum;
    }
    static double pengurangan (double a, double b){
        //untuk pengurangan
        double sum;
         sum = a-b;
          return sum;
        }
    static double perkalian (double a, double b){
        //unruk perkalian
        double sum;
         sum = a*b;
          return sum;
        }
    static double pembagian (double a, double b){
        //untuk pembagian
        double sum;
         sum = a/b;
          return sum;
        }
    static void decimal (double bil){
    DecimalFormat numberFormat = new DecimalFormat("###,###.00");
        System.out.println(numberFormat.format(bil));
        
    }
    
}
