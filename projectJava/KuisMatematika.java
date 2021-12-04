package projectJava;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class KuisMatematika {

    static Scanner input = new Scanner(System.in);
    static String username = "", password = "";

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        int pilih1;
        boolean lanjutMenu = true;
        while (lanjutMenu) {
            println("=== Selamat Datang di Game Quiz Matematika ===");
            println("1. Daftar");
            println("2. Login");
            println("3. Keluar");
            print("Pilih : ");
            pilih1 = input.nextInt();
            switch (pilih1) {
                case 1:
                    if (!username.equalsIgnoreCase("") && (!password.equalsIgnoreCase(""))) {
                        println("Anda sudah mendaftar, silakan login");
                    } else {
                        username = daftar("username");
                        password = daftar("password");
                        println("Selamat, pendaftaran telah berhasil!!!");
                        println("======================================");
                    }
                    break;
                case 2:
                    if (username.equalsIgnoreCase("") && password.equalsIgnoreCase("")) {
                        println("Mohon maaf, silakan daftar terlebih dahulu");
                        println("==========================================");
                    } else {
                        login(username, password);
                    }
                    break;
                case 3:
                    exit();
                    System.exit(0);
                    break;
                default:
                    println("Mohon maaf, input yang anda masukkan salah");
                    println("==========================================");
            }
        }
    }

    static void println(Object x) {
        System.out.println(x);
    }

    static void print(Object x) {
        System.out.print(x);
    }

    static String daftar(String bahanPendaftaran) {
        print("Masukkan " + bahanPendaftaran + " : ");
        bahanPendaftaran = input.next();
        return bahanPendaftaran;

    }

    static void login(String username, String password) {
        boolean loop = true;
        String userLogin, passLogin;
        while (loop) {
            print("Masukkan Username : ");
            userLogin = input.next();
            print("Masukkan Password : ");
            passLogin = input.next();
            if (username.equalsIgnoreCase(userLogin) && (password.equalsIgnoreCase(passLogin))) {
                loop = false;
                println("Selamat, login anda berhasil!!!");
                println("===============================");
                level();
            } else {
                println("Mohon maaf, username atau password salah");
                println("=========================================");
            }
        }

    }

    static void level() {
        int pilih;
        println("Welcome, " + username);
        do {
            println("======= QUIZ MATEMATIKA =======");
            println("=====Pilih Level Kesulitan=====");
            println("1. Easy");
            println("2. Medium");
            println("3. Hard");
            println("===============================");
            println("0. Log Out");
            print("Pilihan Saya : ");
            pilih = input.nextInt();
            switch (pilih) {
                case 1:
                    easy();
                    break;
                case 2:
                    medium();
                    break;
                case 3:
                    hard();
                    break;
                case 0:
                    menu();
                default:
                    println("Mohon maaf silakan input ulang");
                    println("==============================");
            }
        } while (pilih > 3 || pilih < 1);

    }

    static void easy() {
        String operasi = "";
        int live = 3, bilangan1 = 0, bilangan2 = 0, jawab = 0, stage = 1, hasil2 = 0, skor = 0;
        double hasil = 0, jawab1 = 0;
        println("====== Anda Bermain di level Easy ========");
        while (live > 0 && stage < 6) {
            println("======================================");
            println("Skor Anda : " + skor);
            println("Anda memiliki " + live + " nyawa");
            println("Stage " + stage + " : ");
            println("======================================");
            switch (stage) {
                case 1:
                    operasi = " + ";
                    bilangan1 = (int) (Math.random() * 10);
                    bilangan2 = (int) (Math.random() * 10);
                    hasil = bilangan1 + bilangan2;
                    break;
                case 2:
                    operasi = " - ";
                    bilangan1 = (int) (Math.random() * 100);
                    bilangan2 = (int) (Math.random() * 100);
                    hasil = bilangan1 - bilangan2;
                    break;
                case 3:
                    operasi = " + ";
                    bilangan1 = (int) (Math.random() * 1000);
                    bilangan2 = (int) (Math.random() * 1000);
                    hasil = bilangan1 + bilangan2;
                    break;
                case 4:
                    operasi = " * ";
                    bilangan1 = (int) (Math.random() * 100);
                    bilangan2 = (int) (Math.random() * 100);
                    hasil = bilangan1 * bilangan2;
                    break;
                case 5:
                    operasi = " / ";
                    do {
                        bilangan1 = (int) (Math.random() * 100);
                        bilangan2 = (int) (Math.random() * 10);
                    } while (bilangan1 <= 10 || bilangan2 == 0 || bilangan1 % 2 != 0 || bilangan2 % 2 != 0);
                    hasil = bilangan1 / bilangan2;
            }
            println("Berapakah " + bilangan1 + operasi + bilangan2 + " ?");
            print("Jawaban Saya : ");

            if (stage == 5) {
                jawab1 = input.nextDouble();
            } else {
                jawab = input.nextInt();
            }
            if (hasil == jawab || hasil == jawab1) {
                skor += 10;
                stage++;
                println("Selamat Anda mendapatkan skor " + skor);
            } else {
                println("Maaf, jawaban anda salah");
                println("========================");
                live--;
            }
        }
        if (live < 1) {
            println("Maaf, anda gagal dalam menyelesaikan quiz ini");
            println("=============================================");
            ulang(1);
        } else {
            println("Selamat anda telah menyelesaikan quiz level Easy");
            println("==================================================");
            ulang(1);
        }
    }

    static void medium() {
        String bangunDatar = "", bahan1 = "", bahan2 = "", cari = "";
        int live = 3, bilangan1 = 0, bilangan2 = 0, jawab, stage = 1, skor = 0;
        double hasil = 0;
        println("====== Anda Bermain di level Medium ========");
        while (live > 0 && stage < 6) {
            println("======================================");
            println("Skor Anda : " + skor);
            println("Anda memiliki " + live + " nyawa");
            println("Stage " + stage + " : ");
            println("======================================");
            switch (stage) {
                case 1:
                    bangunDatar = " belah ketupat ";
                    bahan1 = " diagonal 1";
                    bahan2 = " diagonal 2";
                    cari = "luas";
                    bilangan1 = (int) (Math.random() * 100);
                    bilangan2 = (int) (Math.random() * 100);
                    hasil = (double) 0.5 * bilangan1 * bilangan2;
                    break;
                case 2:
                    bangunDatar = " persegi panjang ";
                    bahan1 = "panjang";
                    bahan2 = "lebar";
                    cari = "luas";
                    bilangan1 = (int) (Math.random() * 100);
                    bilangan2 = (int) (Math.random() * 100);
                    hasil = bilangan1 * bilangan2;
                    break;
                case 3:
                    bangunDatar = " Jajar genjang ";
                    bahan1 = "panjang";
                    bahan2 = "lebar";
                    cari = " keliling ";
                    bilangan1 = (int) (Math.random() * 100);
                    bilangan2 = (int) (Math.random() * 100);
                    hasil = (double) 2 * (bilangan1 + bilangan2);
                    break;
                case 4:
                    bangunDatar = " Layang-layang ";
                    bahan1 = "diagonal 1";
                    bahan2 = "diagonal 2";
                    cari = "luas";
                    bilangan1 = (int) (Math.random() * 100);
                    bilangan2 = (int) (Math.random() * 100);
                    hasil = (double) 0.5 * bilangan1 * bilangan2;
                    break;
                case 5:
                    bangunDatar = " trapesium ";
                    bahan1 = "jumlah rusuk sejajar";
                    bahan2 = "tinggi";
                    cari = " luas ";
                    bilangan1 = (int) (Math.random() * 100);
                    bilangan2 = (int) (Math.random() * 10);
                    hasil = (double) 0.5 * bilangan1 * bilangan2;
                default:
            }
            println("Sebuah " + bangunDatar + " memiliki " + bahan1 + " = " + bilangan1 + " cm dan " + bahan2 + " = " + bilangan2 + " cm. Hitunglah " + cari + bangunDatar + "tersebut!");
            print("Jawaban Saya :");
            jawab = input.nextInt();
            if (hasil == jawab) {
                skor += 20;
                stage++;
                println("Selamat Anda mendapatkan skor " + skor);
            } else {
                println("Maaf, jawaban anda salah");
                println("========================");
                live--;
            }
        }
        if (live < 1) {
            println("Maaf, anda gagal dalam menyelesaikan quiz ini");
            println("==============================================");
            ulang(2);
        } else {
            println("Selamat anda telah menyelesaikan quiz level Medium");
            println("===================================================");
            ulang(2);
        }
    }

    static void hard() {
        Scanner nilai = new Scanner(System.in);
        String tipe = "", operasi1 = " + ", operasi2 = " - ", hasil = "";
        int live = 3, bilangan1 = 0, bilangan2 = 0, campuran = 0, stage = 1, skor = 0;
        println("====== Anda Bermain di level Hard ========");
        while (live > 0 && stage < 6) {
            String pangkat4 = "x^4", pangkat3 = "x^3", pangkat2 = "x^2";
            println("======================================");
            println("Skor Anda : " + skor);
            println("Anda memiliki " + live + " nyawa");
            println("Stage " + stage + " : ");
            println("Sederhanakan ke bilangan yang paling sederhana!");
            println("======================================");
            switch (stage) {
                case 1:
                    tipe = "turunan";
                    bilangan1 = (int) (Math.random() * 100);
                    bilangan2 = (int) (Math.random() * 100);
                    break;
                case 2:
                    tipe = "turunan";
                    bilangan1 = (int) (Math.random() * 100);
                    bilangan2 = (int) (Math.random() * 100);
                    break;
                case 3:
                    tipe = "integral";
                    bilangan1 = (int) (Math.random() * 100);
                    bilangan2 = (int) (Math.random() * 100);
                    break;
                case 4:
                    tipe = "integral";
                    bilangan1 = (int) (Math.random() * 100);
                    bilangan2 = (int) (Math.random() * 100);
                    campuran = bilangan1 + bilangan2;
                    break;
                case 5:
                    tipe = "turunan";
                    bilangan1 = (int) (Math.random() * 100);
                    bilangan2 = (int) (Math.random() * 100);
                    hasil = bilangan1 + "x" + operasi2;
                default:
            }
            if (stage <= 3) {
                println("Berapakah " + tipe + " dari " + bilangan1 + pangkat2 + operasi1 + bilangan2 + "x ?");
            } else if (stage == 4) {
                println("Berapakah " + tipe + " dari " + bilangan1 + pangkat3 + operasi2 + bilangan2 + pangkat2 + operasi1 + campuran + "x ?");
            } else {
                println("Berapakah " + tipe + " kedua dari " + bilangan1 + pangkat3 + operasi1 + bilangan2 + pangkat2 + "?");
            }
            if (tipe.equalsIgnoreCase("integral")) {
                if (stage == 3) {
                    if (bilangan1 % 3 == 0) {
                        bilangan1 = bilangan1 / 3;
                    } else {
                        pangkat3 = "x^3/3";
                    }
                    if (bilangan2 % 2 == 0) {
                        bilangan2 = bilangan2 / 2;
                    } else {
                        pangkat2 = "x^2/2";
                    }
                    hasil = bilangan1 + pangkat3 + operasi1 + bilangan2 + pangkat2;
                }

                if (stage == 4) {
                    if (bilangan1 % 4 == 0) {
                        bilangan1 = bilangan1 / 4;
                    } else {
                        pangkat4 = "x^4/4";
                    }
                    if (bilangan2 % 3 == 0) {
                        bilangan2 = bilangan2 / 3;
                    } else {
                        pangkat3 = "x^3/3";
                    }
                    if ((bilangan1 + bilangan2) % 2 == 0) {
                        campuran = campuran / 2;
                    } else {
                        pangkat2 = "x^2/2";
                    }
                    hasil = bilangan1 + pangkat4 + operasi2 + bilangan2 + pangkat3 + operasi1 + campuran + pangkat2;
                }
            }

            if (tipe.equalsIgnoreCase("turunan")) {
                if (stage == 5) {
                    bilangan1 = (bilangan1 * 3) * 2;
                    bilangan2 = bilangan2 * 2;
                    hasil = bilangan1 + "x" + operasi1 + bilangan2;
                } else {
                    bilangan1 = bilangan1 * 2;
                    hasil = bilangan1 + "x" + operasi1 + bilangan2;
                }

            }
            print("Jawaban saya : ");
            String jawab = nilai.nextLine();
            if (jawab.equalsIgnoreCase(hasil)) {
                skor += 30;
                stage++;
                println("Selamat Anda mendapatkan skor " + skor);
            } else {
                println("Maaf, jawaban anda salah");
                println("=========================");
                live--;
            }
        }
        if (live < 1) {
            println("Maaf, anda gagal dalam menyelesaikan quiz ini");
            println("==============================================");
            ulang(3);
        } else {
            println("Selamat anda telah menyelesaikan quiz level Hard");
            println("=================================================");
            ulang(3);
        }
    }

    static void ulang(int main) {
        int pilihan;
        println("Apakah anda ingin mengulang? (1.Ya 2.Tidak)");
        do {
            print("Pilihan saya : ");
            pilihan = input.nextInt();
            if (pilihan == 1) {
                switch (main) {
                    case 1:
                        easy();
                        break;
                    case 2:
                        medium();
                        break;
                    case 3:
                        hard();
                        break;
                    default:
                }
            } else {
                level();
            }
        } while (pilihan > 0 || pilihan <= 2);

    }

    static void exit() {
        println("Apakah anda yakin ingin keluar? (1.Ya 2.Tidak)");
        print("Pilihan saya : ");
        int pilihan = input.nextInt();
        switch (pilihan) {
            case 1:
                println("Terimakasih, sampai jumpa lagi");
                println("==============================");
                break;
            case 2:
                menu();
                break;
            default:
                println("Mohon maaf, pilihan yang anda masukkan salah, silakan coba lagi");
                println("===============================================================");
                exit();
        }

    }

}
