import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Arrays;

public class Aplikasi {
        static String jumlah,hoetank,hariapa;
        static Scanner in = new Scanner(System.in);
        static Scanner inp = new Scanner (System.in);
    public static void main(String[] args) {
         int pilihan;
        System.out.println("----Selamat Datang di Aplikasi Ajaib----");
        System.out.println(" ");
           menuutama();
           pilihan = inp.nextInt();
           pilihan(pilihan);
            

}
    static void menuutama (){
        //menampilkan menu
        System.out.println("Silahkan pilih menu dibawah ini: ");
        System.out.println("- Ketik 1 Untuk Menghitung Angsuran Hoetank Anda");
        System.out.println("- Ketik 2 Jika anda lupa Hari Apa Kemarin");
        System.out.print(">");  
        
}
   static void pilihan (int pil){
        //pilihan menu
        switch(pil){
            case 1 : 
                System.out.println("Anda memilih menu 1 ");
                System.out.println("");
                hoetank();
                break;
            case 2 :
                System.out.println("Anda memilih menu 2");
                System.out.println("");
                hariapa();
                break;
            default :
                System.out.println("Invalid Input!");
        }
   }
     static void hoetank(){
       //if User memilih menu 1
    int pinjaman, lamaAngsuran, bunga, angsuran, pembayaran;
    System.out.print("Masukkan besar pinjaman        : ");
    pinjaman = inp.nextInt();

    System.out.print("Masukkan lama angsuran (bulan) : ");
    lamaAngsuran = inp.nextInt();

    angsuran = pinjaman/lamaAngsuran;

    System.out.println("\n==============================\n");
    
    for(int i=0; i<lamaAngsuran; i++){
      pembayaran = angsuran + (pinjaman * 1 / 100);
      System.out.print("Pembayaran bulan ke-"+(i+1)+" = Rp");
      decimal(pembayaran);
      pinjaman = pinjaman-angsuran;
    }
    System.out.println("\n==============================\n");
   }
   static void hariapa(){
     //if user memilih menu 2
    String hari;
    System.out.println("\n==============================\n");
    System.out.print("Masukkan hari : ");
    hari = in.nextLine();
    
    hari = hari.substring(0,1).toUpperCase() + hari.substring(1).toLowerCase();
    String[] array = {"Senin","Selasa","Rabu","Kamis","Jumat","Sabtu","Minggu"};
    
    int index = Arrays.asList(array).indexOf(hari);
    String indexharikemarin = "";
    if(index == 0){
      indexharikemarin = array[6];
    }else{
      indexharikemarin = array[index - 1];
    }
    
    String harikemarin = indexharikemarin;
    System.out.println("\nKemarin adalah hari " + "'" + harikemarin + "'");
    System.out.println("\n==============================\n");
    }
    static void decimal (double bil){
      //decimal format
    DecimalFormat numberFormat = new DecimalFormat("###,###.00");
        System.out.println(numberFormat.format(bil));
        
    }

}
