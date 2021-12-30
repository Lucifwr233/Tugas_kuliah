import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Arrays;
public class mart {
        static Scanner input = new Scanner(System.in);
        static Scanner in = new Scanner(System.in);
        static Scanner inp = new Scanner (System.in);
    public static void main(String[] args) {
    intro();
    bagianutama();
    }
    
    //method intro
    static void intro (){
             System.out.println("Selamat Datang Di Toko Motor Andre ");
             System.out.println("==============================================");
    }
    //method penutup
    static void penutup(){
             System.out.println("Terima kasih");
    }
    //method bagian utama
    static void bagianutama(){
                boolean kondisi;
        
        kondisi = true;
        do {
            String jawab, pilihan, jawab2;
            int[] harga = new int[3];
            
            harga[0] = 9000000;
            harga[1] = 15000000;
            harga[2] = 6500000;
            int a, b, c;
            
            System.out.println("A  Motor Megapro  : Rp."+ harga[0]+"");
            System.out.println("B  Motor Vario    : Rp."+ harga[1]+ "");
            System.out.println("C  Motor Jupiter  : Rp."+ harga[2]+""); 
            System.out.println("Silahkan pilih A, B, C: ");
            pilihan = input.nextLine();
            if (pilihan.equals("A")) {
                System.out.println("Harga Motor Rp." + harga[0] + "");
            } else {
                if (pilihan.equals("B")) {
                    System.out.println("Harga Motor Rp." + harga[1] + "");
                } else {
                    if (pilihan.equals("C")) {
                        System.out.println("Harga Motor Rp." + harga[2] + "");
                    } else {
                        System.out.println("Maaf format masukan salah");
                    }
                }
            }
            System.out.println("Bagaimana anda akan membayar? cash/kredit:");
            jawab = input.nextLine();
            if (jawab.equals("kredit")) {
                System.out.println("Masukkan berapa bulan angsuran yang anda inginkan");
                int lamaangsuran, pembayaran, bunga, i, angsuran;
                
                lamaangsuran = input.nextInt();
                if (pilihan.equals("A")) {
                    System.out.println("=================================");
                    angsuran = (int) ((double) harga[0] / lamaangsuran);
                    for (i = 1; i <= lamaangsuran; i++) {
                        pembayaran = (int) (angsuran + (double) (harga[0] * 3) / 100);
                        System.out.println("Pembayaran bulan ke-" + i + " Rp. " + pembayaran + "");
                    }
                } else {
                    if (pilihan.equals("B")) {
                        System.out.println("=================================");
                        angsuran = (int) ((double) harga[1] / lamaangsuran);
                        for (i = 1; i <= lamaangsuran; i++) {
                            pembayaran = (int) (angsuran + (double) (harga[0] * 3) / 100);
                            System.out.println("Pembayaran bulan ke-" + i + " Rp. " + pembayaran + "");
                        }
                    } else {
                        if (pilihan.equals("C")) {
                            System.out.println("=================================");
                            angsuran = (int) ((double) harga[2] / lamaangsuran);
                            for (i = 1; i <= lamaangsuran; i++) {
                                pembayaran = (int) (angsuran + (double) (harga[0] * 3) / 100);
                                System.out.println("Pembayaran bulan ke-" + i + " Rp. " + pembayaran + "");
                            }
                        }
                    }
                }
            }else {
                if (jawab.equals("cash")) {
                } else {System.out.println("Maaf format masukan salah");}
            }
            System.out.println("Ada yang ingin dipesan lagi? y/n :");
            jawab2 = input.nextLine();
            if (jawab2.equals("y")) {
            } else {
                if (jawab2.equals("n")) {
                    kondisi = false;
                } else {
                    System.out.println("Maaf format yang anda masukkan salah");
                }
            }
        } while (kondisi);
            penutup();
    }
}
