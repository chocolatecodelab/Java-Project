package projectJava;

import java.util.Scanner;

public class BarangTokoWithArray {
    static int harga[] = {10000, 20000, 3000, 11000, 15000};
    static int jumlah[] = new int[5];
    static int totalHarga[] = new int[5];
    static String barang[] = {"Beras", "Telor", "Indomie", "Gula", "Minyak"};
    static Scanner input;
    static String per[] = {"liter", "kg", "bungkus", "Gula", "Minyak" }; 

    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            jumlah[i] = 0;
            totalHarga[i] = 0;
        }
        
        daftarBarang();
    }

    // method utama
    public static void daftarBarang() {
        input = new Scanner(System.in);
        cls();
        tulisln("DAFTAR BARANG - TOKO 5 BAHAN POKOK");
        tulisln("=============================================");
        tulisln("Kode   Barang      Harga               Jumlah              Total Harga");
        for(int i = 0; i < 5; i++) {
        tulisln(i +"      "+ barang[i] + "   " + harga[i] + "/" + per[i] + "         "   + jumlah[i] + "                         " + totalHarga[i]);
        }
        tulisln("============================================================  " + totalHarga);
        
        tulisln("PILIH BARANG:");
        tulis("Kode Barang:");
        int kode = input.nextInt();
        tulis("Jumlah Barang:");
        int jumlah = input.nextInt();

        // switch (kode) {
        // case 1:
        //     jumlah1 += jumlah;
        //     totalHarga1 += (jumlah * harga1);
        //     totalHarga += totalHarga1;
        //     break;
        // case 2:
        //     jumlah2 += jumlah;
        //     totalHarga2 += (jumlah * harga2);
        //     totalHarga += totalHarga2;
        //     break;
        // case 3:
        //     jumlah3 += jumlah;
        //     totalHarga3 += (jumlah * harga3);
        //     totalHarga += totalHarga3;
        //     break;
        // case 4:
        //     jumlah4 += jumlah;
        //     totalHarga4 += (jumlah * harga4);
        //     totalHarga += totalHarga4;
        //     break;
        // case 5:
        //     jumlah5 += jumlah;
        //     totalHarga5 += (jumlah * harga5);
        //     totalHarga += totalHarga5;
        //     break;
        // default:
        //     break;
        // }

        tulis("Apakah ingin input barang lagi? (Y/N)");
        String jawab = input.next();
        if (jawab.equalsIgnoreCase("Y")) {
            daftarBarang();
        } else {
            pembelian();
        }
    }

    public static void pembelian() {
        cls();
        tulisln("DAFTAR BARANG - TOKO 5 BAHAN POKOK");
        tulisln("=============================================");
        tulisln("Kode   Barang      Harga               Jumlah");
        // if (jumlah1 != 0) {
        //     tulisln("1      Beras       Rp. 10.000/liter    " + jumlah1 + "                      " + totalHarga1);
        // }
        // if (jumlah2 != 0) {
        //     tulisln("2      Telor       Rp. 20.000/kg       " + jumlah2 + "                      " + totalHarga2);
        // }
        // if (jumlah3 != 0) {
        //     tulisln("3      Indomie     Rp.  3.000/bungkus  " + jumlah3 + "                      " + totalHarga3);
        // }
        // if (jumlah4 != 0) {
        //     tulisln("3      Indomie     Rp.  3.000/bungkus  " + jumlah4 + "                      " + totalHarga4);
        // }
        // if (jumlah5 != 0) {
        //     tulisln("3      Indomie     Rp.  3.000/bungkus  " + jumlah5 + "                      " + totalHarga5);
        // }

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
