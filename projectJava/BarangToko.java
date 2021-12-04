package projectJava;

import java.util.Scanner;

public class BarangToko {
    static int harga1 = 10000;
    static int harga2 = 20000;
    static int harga3 = 3000;
    static int harga4 = 11000;
    static int harga5 = 15000;
    static int jumlah1, jumlah2, jumlah3, jumlah4, jumlah5;
    static int totalHarga = 0, totalHarga1 = 0, totalHarga2 = 0, totalHarga3 = 0, totalHarga4 = 0, totalHarga5 = 0;
    static Scanner input;

    public static void main(String[] args) {
        jumlah1 = 0;
        jumlah2 = 0;
        jumlah3 = 0;
        jumlah4 = 0;
        jumlah5 = 0;

        daftarBarang();
    }

    // method utama
    public static void daftarBarang() {
        boolean loop = true;
        input = new Scanner(System.in);
        cls();
        while (loop) {
            tulisln("DAFTAR BARANG - TOKO 5 BAHAN POKOK");
            tulisln("=============================================");
            tulisln("Kode   Barang      Harga               Jumlah              Total Harga");
            tulisln("1      Beras       Rp. 10.000/liter    " + jumlah1 + "                      " + totalHarga1);
            tulisln("2      Telor       Rp. 20.000/kg       " + jumlah2 + "                      " + totalHarga2);
            tulisln("3      Indomie     Rp.  3.000/bungkus  " + jumlah3 + "                      " + totalHarga3);
            tulisln("4      Gula        Rp. 11.000/kg       " + jumlah4 + "                      " + totalHarga4);
            tulisln("5      Minyak      Rp. 15.000/liter    " + jumlah5 + "                      " + totalHarga5);
            tulisln("============================================================  " + totalHarga);
            tulisln("PILIH BARANG:");
            tulis("Kode Barang:");
            int kode = input.nextInt();
            tulis("Jumlah Barang:");
            int jumlah = input.nextInt();

            switch (kode) {
            case 1:
                jumlah1 += jumlah;
                totalHarga1 += (jumlah * harga1);
                totalHarga += totalHarga1;
                break;
            case 2:
                jumlah2 += jumlah;
                totalHarga2 += (jumlah * harga2);
                totalHarga += totalHarga2;
                break;
            case 3:
                jumlah3 += jumlah;
                totalHarga3 += (jumlah * harga3);
                totalHarga += totalHarga3;
                break;
            case 4:
                jumlah4 += jumlah;
                totalHarga4 += (jumlah * harga4);
                totalHarga += totalHarga4;
                break;
            case 5:
                jumlah5 += jumlah;
                totalHarga5 += (jumlah * harga5);
                totalHarga += totalHarga5;
                break;
            default:
                break;
            }
            daftarBarang();
        }

    }

    public static void pembelian() {
        cls();
        tulisln("DAFTAR BARANG - TOKO 5 BAHAN POKOK");
        tulisln("=============================================");
        tulisln("Kode   Barang      Harga               Jumlah");
        if (jumlah1 != 0) {
            tulisln("1      Beras       Rp. 10.000/liter    " + jumlah1 + "                      " + totalHarga1);
        }
        if (jumlah2 != 0) {
            tulisln("2      Telor       Rp. 20.000/kg       " + jumlah2 + "                      " + totalHarga2);
        }
        if (jumlah3 != 0) {
            tulisln("3      Indomie     Rp.  3.000/bungkus  " + jumlah3 + "                      " + totalHarga3);
        }
        if (jumlah4 != 0) {
            tulisln("3      Indomie     Rp.  3.000/bungkus  " + jumlah4 + "                      " + totalHarga4);
        }
        if (jumlah5 != 0) {
            tulisln("3      Indomie     Rp.  3.000/bungkus  " + jumlah5 + "                      " + totalHarga5);
        }

        tulisln("=============================================");
        tulisln("Total Harga: " + totalHarga);
    }

    // method pendukung
    public static void tulis(Object x) {
        System.out.print(x);
    }

    public static void tulisln(Object x) {
        System.out.println(x);
    }

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void lanjut() {
        tulis("Press any key to continue . . . ");
        try {
            System.in.read();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
