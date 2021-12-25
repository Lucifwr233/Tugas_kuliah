import java.util.Scanner;

public class soal1 {
    public static void main(String[] args) {
        //mendeklarasi variabel
        
        Double fahrenheit, celcius, reamur;
        //membuat scanner baru
        Scanner input=new Scanner(System.in);
        //menampilkan output berapa suhu dalam fahrenheit
        System.out.println("Masukkan derajat Fahrenheit yang ingin dikonversikan: ");
        //menyimpan fahrenheit
        fahrenheit= input.nextDouble();
        //rumus konversi fahrenheit to celcius
        celcius= (fahrenheit-32)* 5/9;
        //rumus konversi fahrenheit to reamur
        reamur= (fahrenheit-32)/2.25;
        //print hasil
        System.out.println("Suhu (dalam °F) = " + fahrenheit);
        System.out.println("Konversi dalam °C = " + celcius);
        System.out.println("Konversi dalam °R = " + reamur);
    }
    
}
