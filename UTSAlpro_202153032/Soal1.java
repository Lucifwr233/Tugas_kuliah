import java.util.Scanner;

public class soal1 {
    public static void main(String[] args) {
        String pilihan, pilihan1, pilihan2;
        Scanner input=new Scanner(System.in);
            System.out.println("----------------------------------------");
            System.out.println("            " + "Menu Makanan" +"            ");
            System.out.println("----------------------------------------");
            System.out.println("           " + "1. Paket Hemat 1" + "           ");
            System.out.println("           " + "2. Paket Hemat 2" + "           ");
            System.out.println("Silahkan masukan pilihan anda: ");
            pilihan = input.nextLine();
            if (pilihan.equals("1")) {
                System.out.println("Paket hemat 1 berisi nasi, telor, air putih");
              } else {
                if (pilihan.equals("2")) {
                    System.out.println("Paket hemat 2 berisi nasi, ayam, es teh");
                } else {
                    System.out.println("Mohon maaf, hanya ada 2 pilihan paket hemat");
                    System.out.println("Silahkan masukan pilihan nomor paket hemat yang benar!");
                }
            }
    }
}
