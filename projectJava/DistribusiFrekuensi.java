package projectJava;

import java.util.*;

public class DistribusiFrekuensi {
    public static void main(String[] args) {
        System.out.println("===Aplikasi Distribusi Frekuensi===");
        int[] jumlahData = jumlahDataKelompok();
        int[] terkecilTerbesar = terkecilTerbesar(jumlahData);
        int jangkauan = rentang(terkecilTerbesar);
        int kelas = banyakKelas(jumlahData);
        int panjangKelas = panjangKelas(jangkauan, kelas);
        int[] ujungBawahKelas = intervalKelasBawah(terkecilTerbesar, kelas, panjangKelas);
        int[] ujungAtasKelas = intervalKelasAtas(ujungBawahKelas, kelas, panjangKelas);
        double[] batasKelasBawah = batasKelasBawah(ujungBawahKelas);
        double[] batasKelasAtas = batasKelasAtas(ujungAtasKelas);
        double[] nilaiTengahKelas = nilaiTengahKelas(batasKelasBawah, batasKelasAtas);
        int[] frekuensi = frekuensi(ujungBawahKelas, ujungAtasKelas, jumlahData);
        tabel(kelas, ujungBawahKelas, ujungAtasKelas, batasKelasBawah, batasKelasAtas, nilaiTengahKelas, frekuensi,
                jumlahData);
    }

    // mencari data
    private static int[] jumlahDataKelompok() {
        Scanner input = new Scanner(System.in);
        System.out.print("Tentukan jumlah n : ");
        int n = input.nextInt();
        return dataKelompok(n);
    }

    private static int[] dataKelompok(int n) {
        Scanner input = new Scanner(System.in);
        int[] arrayJumlah = new int[n];
        System.out.println("Jumlah data ada :" + n);
        for (int i = 0; i < arrayJumlah.length; i++) {
            System.out.print("Nilai " + (i + 1) + " : ");
            arrayJumlah[i] = input.nextInt();
        }
        printArray(arrayJumlah, "Data Kelompok : ");
        return arrayJumlah;
    }

    // mencari nilai terkecil dan terbesar
    private static int[] terkecilTerbesar(int[] array) {
        int[] arrayList = array;
        Arrays.sort(arrayList);
        int[] terkecilTerbesar = new int[2];
        terkecilTerbesar[0] = arrayList[0];
        terkecilTerbesar[1] = arrayList[arrayList.length - 1];
        printArray(arrayList, "Data terurut");
        printArray(terkecilTerbesar, "Terkecil dan Terbesar");
        return terkecilTerbesar;
    }

    // mencari rentang (r)
    private static int rentang(int[] array) {
        int rentang = array[1] - array[0];
        println("Rentang (r) : ", rentang);
        return rentang;
    }

    // mencari banyak kelas
    private static int banyakKelas(int[] jumlahData) {
        int banyakKelas = (int) (1 + (3.3 * Math.log10(jumlahData.length)));
        println("Banyak Kelas(K) : ", banyakKelas);
        return banyakKelas;
    }

    // mencari panjang kelas
    private static int panjangKelas(int rentang, int kelas) {
        int panjangKelas = 1 + rentang / kelas;
        println("Panjang Kelas(P) : ", panjangKelas);
        return panjangKelas;

    }

    // mencari ujung bawah kelas
    private static int[] intervalKelasBawah(int[] terkecilTerbesar, int banyakKelas, int panjangKelas) {
        // int[] arrayInterval = new int[terkecilTerbesar[1]];
        // // int j = 0;
        // // for (int i = terkecilTerbesar[0]; i <= terkecilTerbesar[1]; i++) {
        // // arrayInterval[j] = i;
        // // j++;
        // // }
        int[] ujungBawahKelas = new int[banyakKelas];
        for (int i = 0; i < ujungBawahKelas.length; i++) {
            if (i == 0) {
                ujungBawahKelas[i] = terkecilTerbesar[i];
            } else {
                ujungBawahKelas[i] = ujungBawahKelas[i - 1] + panjangKelas;
            }

        }
        printArray(ujungBawahKelas, "Ujung Bawah Kelas : ");
        return ujungBawahKelas;
    }

    // mencari ujung atas kelas
    private static int[] intervalKelasAtas(int[] ujungBawahKelas, int banyakKelas, int panjangKelas) {
        int[] ujungAtasKelas = new int[banyakKelas];
        for (int i = 0; i < ujungAtasKelas.length; i++) {
            ujungAtasKelas[i] = ujungBawahKelas[i] + panjangKelas - 1;
            // if (i == 0) {
            // ujungAtasKelas[i] = terkecilTerbesar[i] + panjangKelas;
            // } else {
            // ujungAtasKelas[i] = ujungAtasKelas[0] + panjangKelas;
            // }
        }
        printArray(ujungAtasKelas, "Ujung Atas Kelas : ");

        return ujungAtasKelas;
    }

    // mencari batas kelas bawah
    private static double[] batasKelasBawah(int[] ujungBawahKelas) {
        double[] batasKelasBawah = new double[ujungBawahKelas.length];
        for (int i = 0; i < ujungBawahKelas.length; i++) {
            batasKelasBawah[i] = ujungBawahKelas[i] - 0.5;
        }
        printArray(batasKelasBawah, "Batas Kelas Bawah : ");
        return batasKelasBawah;
    }

    // mencari batas kelas atas
    private static double[] batasKelasAtas(int[] ujungAtasKelas) {
        double[] batasKelasAtas = new double[ujungAtasKelas.length];
        for (int i = 0; i < ujungAtasKelas.length; i++) {
            batasKelasAtas[i] = ujungAtasKelas[i] + 0.5;
        }

        printArray(batasKelasAtas, "Batas Kelas Atas : ");
        return batasKelasAtas;
    }

    // mencari nilai tengah kelas
    private static double[] nilaiTengahKelas(double[] batasKelasBawah, double[] batasKelasAtas) {
        double[] tengahKelas = new double[batasKelasAtas.length];
        for (int i = 0; i < batasKelasAtas.length; i++) {
            tengahKelas[i] = (batasKelasBawah[i] + batasKelasAtas[i]) / 2;
        }
        printArray(tengahKelas, "Nilai Tengah Kelas : ");
        return tengahKelas;
    }

    // mencari frekuensi
    private static int[] frekuensi(int[] ujungBawahKelas, int[] ujungAtasKelas, int[] jumlahData) {
        int[] frekuensi = new int[ujungBawahKelas.length];
        for (int i = 0; i < ujungAtasKelas.length; i++) {
            int count = 0;
            for (int j = 0; j < jumlahData.length; j++) {
                if (jumlahData[j] >= ujungBawahKelas[i] && jumlahData[j] <= ujungAtasKelas[i]) {
                    count++;
                }
            }
            frekuensi[i] = count;
        }
        printArray(frekuensi, "frekuensi : ");
        return frekuensi;
    }

    // tabel
    private static void tabel(int kelas, int[] ujungBawahKelas, int[] ujungAtasKelas, double[] batasKelasBawah,
            double[] batasKelasAtas, double[] nilaiTengahKelas, int[] frekuensi, int[] jumlahData) {
        System.out.println("==================================================================================================");
        System.out.println("||\tInterval Kelas\t||\tBatas Kelas\t||\tNilai Tengah\t||\tFrekuensi\t||");
        for (int i = 0; i < kelas; i++) {
            System.out.println(
                    "||\t" + ujungBawahKelas[i] + " - " + ujungAtasKelas[i] + "\t\t||\t" + batasKelasBawah[i]
                            + " - " + batasKelasAtas[i] + "\t||\t" + nilaiTengahKelas[i] + "\t\t||\t\t"
                            + frekuensi[i] + "\t||");
        }
        System.out.println("==================================================================================================");
    }

    // print
    private static void printArray(int[] array, String message) {
        System.out.println(message + Arrays.toString(array));
    }

    private static void printArray(double[] array, String message) {
        System.out.println(message + Arrays.toString(array));
    }

    private static void println(String message, int tulis) {
        System.out.println(message + tulis);
    }

}
