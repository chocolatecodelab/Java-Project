/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectJava;

import java.util.*;

/**
 *
 * @author Nazar
 */
public class FiniteState {

    static int stringInput;
    static String stringDiterima = "", q1 = "q1", q2 = "q2";
    static List<String> urutanTransisi = new ArrayList<String>();

    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
        System.out.println("Nama    : Muhammad Nazar Gunawan");
        System.out.println("NIM     : 2111016210010");
        System.out.println("Jurusan : Ilmu Komputer");
        System.out.println("");
        System.out.println("================================");
        System.out.println("=> State Awal : q1");
        System.out.println("=> Himpunan simbol input : {0,1}");
        System.out.println("=> Himpunan State : {q1,q2}");
        System.out.println("=> Himpunan State Akhir : {q1}");
        System.out.println("================================");
        finite(q1);

    }

    public static void finite(String q) {
        Scanner input = new Scanner(System.in);
        System.out.println("=> Pilih string : ");
        System.out.println("- 1");
        System.out.println("- 0");
        System.out.println("=> Masukkan : ");
        stringInput = input.nextInt();
        if (q.equals("q1")) {
            proses(stringInput);
        } else {
            proses2(stringInput);
        }

    }

    public static void proses(int stringInput) {
        switch (stringInput) {
            case 0 : 
                stringDiterima = stringDiterima.concat("0");
                System.out.println("==================");
                System.out.println("fungsi transisi(q1,0) = q1");
                System.out.println("==================");
                urutanTransisi.add("((q1,0),q1)");
                toAsk(q1);
                break;
            case 1 : 
                stringDiterima = stringDiterima.concat("1");
                System.out.println("==================");
                System.out.println("fungsi transisi(q1,1) = q2");
                System.out.println("==================");
                urutanTransisi.add("((q1,1),q2)");
                toAsk(q2);
            default :
                System.out.println("Error");
        }

    }

    public static void proses2(int stringInput) {
        switch (stringInput) {
            case 0 : {
                stringDiterima = stringDiterima.concat("0");
                System.out.println("==================");
                System.out.println("fungsi transisi(q2,0) = q1");
                System.out.println("==================");
                urutanTransisi.add("((q2,0)q1)");
                toAsk(q1);
            }
            case 1 : {
                stringDiterima = stringDiterima.concat("1");
                System.out.println("==================");
                System.out.println("fungsi transisi(q2,1) = q2");
                System.out.println("==================");
                urutanTransisi.add("((q2,1),q2)");
                toAsk(q2);
            }
            default :
                System.out.println("Error");
        }

    }

    public static void toAsk(String q) {
        Scanner input = new Scanner(System.in);
        System.out.println("=======================================");
        System.out.println("=> Apakah Anda ingin menambah panjang string ? ");
        System.out.println("1.Ya");
        System.out.println("2.Tidak");
        System.out.println("=> Masukkan : ");
        int pilihan = input.nextInt();
        System.out.println("=======================================");
        switch (pilihan) {
            case 1 :
                finite(q);
                break;
            case 2 :
                finish();
                break;
            default :
                toAsk(q);
        }
    }

    public static void finish() {
        System.out.println("===================================================");
        System.out.println("=> String : " + stringDiterima);
        System.out.println("=> Jumlah Panjang String : " + stringDiterima.length());
        System.out.println("=> Urutan fungsi Transisi : " + urutanTransisi);
        String charAkhir = stringDiterima.substring(stringDiterima.length() - 1);
        if (charAkhir.equals("1")) {
            System.out.println("=> Hasilnya : String tidak dikenali/diterima Finite Automation M");
        } else {
            System.out.println("=> Hasilnya : String dikenali/diterima Finite Automation M");
        }
        System.out.println("===================================================");
    }
}
