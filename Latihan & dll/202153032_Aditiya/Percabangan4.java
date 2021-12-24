import java.util.Scanner;

    public static void main(String[] args) {
        int HargaBarang1, HargaBarang2, HargaBarang3, Total, Potongan, HargaAkhir;
        Scanner input=new Scanner(System.in);
        System.out.println("Masukkan Harga Barang 1 ");
        HargaBarang1 = input.nextInt();
        System.out.println("Masukkan Harga Barang 2 ");
        HargaBarang2 = input.nextInt();
        System.out.println("Masukkan Harga Barang 3 ");
        HargaBarang3 = input.nextInt();
        Total = HargaBarang1+HargaBarang2+HargaBarang3;
        if (Total>100000) {
            System.out.println("Total belanja anda melebihi Rp.100.000");
            System.out.println("Anda mendapatkan diskon 10%");
            Potongan = (int) (Total*0.1);
            HargaAkhir = Total-Potongan;
        }
        else { HargaAkhir = Total;
        System.out.println("Total harga barang anda tidak memenuhi syarat mendapatkan diskon");
        System.out.println("Anda tidak mendapatkan diskon");
    }
    
        System.out.println("Rp." + HargaAkhir);
        }
}
