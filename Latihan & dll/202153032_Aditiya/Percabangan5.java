import java.util.Scanner;

public class Soal5 {
    public static void main(String[] args) {
        int nilai;
        String nilaihuruf;
    Scanner input = new Scanner (System.in);
        System.out.println("Masukkan nilai anda: ");
        nilai=input.nextInt();
    if ((nilai>=86 && nilai<=100)){
        System.out.println("A"+ " 'Sangat baik'");
    }else if (nilai>=76 && nilai<=86){
        System.out.println("B"+ " 'Baik'");
    }else{
    if (nilai>=66 && nilai<=76){ 
         System.out.println("C"+ " 'Cukup'");
    }else{
      if ((nilai>=46 && nilai<=66)){
          System.out.println("D"+ " 'Kurang'");
    }else if (nilai>=0 && nilai<=46){
          System.out.println("E"+ " 'Sangat kurang'");
    }
    }
    }
    }
}
