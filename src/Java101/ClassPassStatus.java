package Java101;

import java.util.Scanner;

public class ClassPassStatus {
    public static void main(String[] args) {
        int mat, fizik, kimya, turkce, tarih, muzik;
        Scanner input = new Scanner(System.in);
        System.out.println("Matematik notunuzu giriniz: ");
        mat = input.nextInt();
        System.out.println("Fizik notunuzu giriniz: ");
        fizik = input.nextInt();
        System.out.println("Kimya notunuzu giriniz: ");
        kimya = input.nextInt();
        System.out.println("Türkçe notunuzu giriniz: ");
        turkce = input.nextInt();
        System.out.println("Tarih notunuzu giriniz: ");
        tarih = input.nextInt();
        System.out.println("Müzik notunuzu giriniz: ");
        muzik = input.nextInt();

        int toplam = (mat + fizik + kimya + turkce + tarih + muzik);
        double ortalama = toplam / 6.0;
        System.out.println("Ortalamanız: " + ortalama);
        if (ortalama >= 55) {
            System.out.println("Sınıfı geçti");
        } else {
            System.out.println("Sınıfta kaldı");
        }
    }
}
