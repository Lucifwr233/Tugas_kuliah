import java.util.Scanner;

public class soal2 {
    public static void main(String[] args) {
        int jumlah, harga, barangdijumlah, diskon, total, bonus;
        String kode, nama;
        Scanner input=new Scanner(System.in);
        System.out.println("Masukan kode pelanggan anda : ");
        kode = input.nextLine();
        System.out.println("Masukan nama pelanggan : ");
        nama = input.nextLine();
        System.out.println("Masukan jumlah barang : ");
        jumlah = input.nextInt();
        System.out.println("Masukkan harga barang : ");
        harga = input.nextInt();
        barangdijumlah = harga * jumlah;
        diskon = (int) (barangdijumlah - 0.1 * barangdijumlah);
        total = diskon;
        System.out.println("Kode Pelanggan      = " + kode);
        System.out.println("Nama Pelanggan      = " + nama);
        System.out.println("Jumlah Barang       = " + jumlah);
        System.out.println("Harga Barang        = " + harga);
        System.out.println("Diskon 10%          = " + "Rp." + diskon);
        System.out.println("Total Pembelian     = " + "Rp." + diskon);
        if (total >= 50000) {
            System.out.println("Bonus               = " + "Total belanja anda melebihi Rp.50,000 " + "Anda mendapatkan bonus rumah idaman");
        } else {
            if (total < 50000) {
                System.out.println("Bonus           = " + "Total belanja anda kurang dari Rp.50,000 " + "Anda mendapatkan bonus Unit Mobil");
            } else {
                System.out.println("error");
            }
        }
    }
}
