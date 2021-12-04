package projectJava;

import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ACER
 */
public class Aplikasi2111016210010 {

    static String kode1, kode2, kode3, nama1, nama2, nama3;
    static int cek1, cek2, cek3;
    static double suhu1, suhu2, suhu3, rataSuhu1, rataSuhu2, rataSuhu3, detak1, rataDetak1, detak2, rataDetak2, detak3, rataDetak3, respirasi1, respirasi2, respirasi3, rataRespirasi1, rataRespirasi2, rataRespirasi3;
    static double tekanan1, tekanan2, tekanan3, rataTekanan1, rataTekanan2, rataTekanan3;

    public static void main(String[] args) {
        kode1 = "";
        kode2 = "";
        kode3 = "";
        nama1 = "";
        nama2 = "";
        nama3 = "";
        cek1 = 0;
        cek2 = 0;
        cek3 = 0;
        menu();
    }

    public static void menu() {
        cls();
        Scanner input = new Scanner(System.in);
        tulisln("Pencatatan Vital Sign - RS Idaman");
        tulisln("==================================");
        tulisln("1. Registrasi Pasien");
        tulisln("2. Input Vital Sign");
        tulisln("3. Laporan");
        tulisln("0. Keluar");
        tulis("Pilihan : ");
        int pilihan = input.nextInt();
        switch (pilihan) {
            case 1:
                registrasi();
                break;
            case 2:
                inputVitalSign();
                break;
            case 3:
                laporan();
                break;
            case 0:
                System.exit(0);
            default:
                tulisln("Angka yang anda input salah. Silakan coba lagi");
                lanjut();
                menu();
                break;
        }
    }

    static void registrasi() {
        Scanner input = new Scanner(System.in);
        cls();
        tulisln("Pencatatan Vital Sign - RS Idaman - Registrasi Pasein");
        if (!kode3.equals("")) {
            tulisln("Sudah penuh. Maaf cari rumah sakit lain saja");
        } else {
            tulis("Pasien ID : ");
            String kode = input.next();
            tulis("Name : ");
            String nama = input.next();
            if (kode1.equals("")) {
                kode1 = kode;
                nama1 = nama;
            } else if (kode2.equals("")) {
                kode2 = kode;
                nama2 = nama;
            } else if (kode3.equals("")) {
                kode3 = kode;
                nama3 = nama;
            }
            System.out.println("Registrasi sukses!");
        }

        lanjut();
        menu();
    }

    static void inputVitalSign() {
        int benar = 0, tekanan = 0, suhu = 0, detak = 0, respirasi = 0;
        String kode;
        boolean lanjut = true;
        Scanner input = new Scanner(System.in);
        tulisln("Pencatatan Vital Sign - RS Idaman - Pemeriksaan Pasien");
        do {
            tulis("Kode Pasien: ");
            kode = input.next();
            if (kode.equals(kode1)) {
                benar = cek1 < 3 ? 1 : 2;
                lanjut = false;
            } else if (kode.equals(kode2)) {
                benar = cek2 < 3 ? 1 : 2;
                lanjut = false;
            } else if (kode.equals(kode3)) {
                benar = cek3 < 3 ? 1 : 2;
                tulisln("Kode yang anda masukkan benar");
                tulisln("==============================");
                lanjut = false;
            } else {
                tulisln("Mohon maaf, kode yang anda masukkan salah, silakan dicoba lagi");
                tulisln("===============================================================");
            }
        } while (lanjut);

        if (benar == 1) {
            tulis("Blood Pressure : ");
            tekanan = input.nextInt();
            tulis("Heart Rate: ");
            detak = input.nextInt();
            tulis("SPO2: ");
            respirasi = input.nextInt();
            tulis("Temperature : ");
            suhu = input.nextInt();
        } else {
            tulisln("Mohon maaf, pasien " + kode + " sudah diperiksa 3x dalam sehari");
        }

        if (kode1.equals(kode) && cek1 < 3) {
            cek1++;
            suhu1 += suhu;
            tekanan1 += tekanan;
            detak1 += detak;
            respirasi1 += respirasi;
            rataSuhu1 = (double) suhu1 / cek1;
            rataTekanan1 = (double) tekanan1 / cek1;
            rataDetak1 = (double) detak1 / cek1;
            rataRespirasi1 = (double) respirasi1 / cek1;

        } else if (kode2.equals(kode) && cek2 < 3) {
            cek2++;
            suhu2 += suhu;
            tekanan2 += tekanan;
            detak2 += detak;
            respirasi2 += respirasi;
            rataSuhu2 = (double) suhu2 / cek2;
            rataTekanan2 = (double) tekanan2 / cek2;
            rataDetak2 = (double) detak2 / cek2;
            rataRespirasi2 = (double) respirasi2 / cek2;

        } else if (kode3.equals(kode) && cek3 < 3) {
            cek3++;
            suhu3 += suhu;
            tekanan3 += tekanan;
            detak3 += detak;
            respirasi3 += respirasi;
            rataSuhu3 = (double) suhu3 / cek3;
            rataTekanan3 = (double) tekanan3 / cek3;
            rataDetak3 = (double) detak3 / cek3;
            rataRespirasi3 = (double) respirasi3 / cek3;
        } 

        lanjut();
        menu();
    }

    static void laporan() {
        tulisln("Pencatatan Vital Sign - RS Idaman - Laporan Pasien");
        tulisln("Patient ID     Name     Check     Blood Pressure      Heart Rate        SPO2      Temperature ");
        tulisln("==================================================================================================");
        tulisln(kode1 + "\t   " + nama1 + "\t\t" + cek1 + "\t\t" + rataTekanan1 + "\t\t" + rataDetak1 + "\t\t" + rataRespirasi1 + "\t\t" + rataSuhu1);
        tulisln("==================================================================================================");
        tulisln(kode2 + "\t   " + nama2 + "\t\t" + cek2 + "\t\t" + rataTekanan2 + "\t\t" + rataDetak2 + "\t\t" + rataRespirasi2 + "\t\t" + rataSuhu2);
        tulisln("==================================================================================================");
        tulisln(kode3 + "\t   " + nama3 + "\t\t" + cek3 + "\t\t" + rataTekanan3 + "\t\t" + rataDetak3 + "\t\t" + rataRespirasi3 + "\t\t" + rataSuhu3);
        lanjut();
        menu();
    }

    static void tulisln(Object x) {
        System.out.println(x);
    }

    static void tulis(Object x) {
        System.out.print(x);
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
