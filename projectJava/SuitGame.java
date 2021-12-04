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
public class SuitGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean kondisiMenu = true, validasi = true, pemilih;
        int pilihan, pilih, live = 3, skor = 0;
        double computer;
        String username, password, equalUsername = "", rolePlayer = "", roleComputer, hasil = "",
                equalPassword = "", nama, nim;
        System.out.println("Selamat Datang di Suit Game");
        while (kondisiMenu) {
            System.out.println("1. Daftar");
            System.out.println("2. Login");
            System.out.print("pilih : ");
            pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan username : ");
                    equalUsername = input.next();
                    System.out.print("Masukkan Password : ");
                    equalPassword = input.next();
                    System.out.println("Pendaftaran telah berhasil silakan login");
                    break;
                case 2:
                    if (equalUsername.equalsIgnoreCase("") && (equalPassword.equalsIgnoreCase(""))) {
                        System.out.println("Anda belum mendaftar");
                        break;
                    } else {
                        while (validasi) {
                            System.out.print("Masukkan username : ");
                            username = input.next();
                            System.out.print("Masukkan Password : ");
                            password = input.next();

                            if (username.equalsIgnoreCase(equalUsername) && (password.equalsIgnoreCase(equalPassword))) {
                                System.out.println("Selamat, Anda telah login!");
                                System.out.println("Nama :" + username);
                                System.out.println("NIM : " + password);
                                kondisiMenu = false;
                                validasi = false;
                                System.out.println("===SUIT (GUNTING BATU KERTAS)=== ");
                                System.out.println("1.Main");
                                System.out.println("2.Tentang");
                                System.out.println("3.Keluar");
                                System.out.print("Pilih Menu : ");
                                pilih = input.nextInt();
                                switch (pilih) {
                                    case 1:
                                        System.out.println("Role : ");
                                        System.out.println("Gunting vs kertas = Gunting Menang");
                                        System.out.println("Kertas vs Batu = Kertas Menang");
                                        System.out.println("Batu vs Gunting = Batu Menang");
                                        while (live > 0) {
                                            System.out.println("You have " + live + "  life ");
                                            System.out.println("You have " + skor + " skor");
                                            if (skor > 40) {
                                                System.out.println("Wah pro Suit Game nih");
                                            } else if (skor > 90) {
                                                System.out.println("gelaa seh udah raja Suit Game ini");
                                            } else if (skor > 140) {
                                                System.out.println("Udah lo melebihi Raja Suit Game, Suhu!!!");
                                            } 
                                            
                                            pemilih = true;
                                            while (pemilih) {
                                                System.out.println("==============================");
                                                System.out.println("1.Gunting 2.Batu 3.Kertas");
                                                System.out.print("Silakan pilih (1-3) : ");

                                                pilih = input.nextInt();
                                                switch (pilih) {
                                                    case 1:
                                                        rolePlayer = "Gunting";
                                                        pemilih = false;
                                                        break;
                                                    case 2:
                                                        rolePlayer = "Batu";
                                                        pemilih = false;
                                                        break;
                                                    case 3:
                                                        rolePlayer = "Kertas";
                                                        pemilih = false;
                                                        break;
                                                    default:
                                                        System.out.println("Mohon maaf, role yang anda masukkan salah");
                                                }
                                            }

                                            if (pilih >= 1 && pilih <= 3) {
                                                computer = Math.random();
                                                if (computer < 0.34) {
                                                    roleComputer = "Gunting";
                                                } else if (computer > 0.34 && computer < 0.67) {
                                                    roleComputer = "Kertas";
                                                } else {
                                                    roleComputer = "Batu";
                                                }

                                                if (rolePlayer.equalsIgnoreCase(roleComputer)) {
                                                    hasil = "Seri";
                                                } else if (rolePlayer.equalsIgnoreCase("Gunting")) {
                                                    hasil = roleComputer.equals("Kertas") ? "Menang!" : "Kalah!";
                                                } else if (rolePlayer.equalsIgnoreCase("Kertas")) {
                                                    hasil = roleComputer.equals("Gunting") ? "Kalah!" : "Menang!";
                                                } else if (rolePlayer.equalsIgnoreCase("Batu")) {
                                                    hasil = roleComputer.equals("Kertas") ? "Kalah!" : "Menang!";
                                                }

                                                if (hasil.equalsIgnoreCase("Kalah!")) {
                                                    live--;
                                                } else if (hasil.equalsIgnoreCase("Menang!")) {
                                                    skor += 10;
                                                }

                                                System.out.println("Player memilih " + rolePlayer + " dan Computer memilih " + roleComputer + ", maka hasilnya adalah player " + hasil);
                                            }

                                        }
                                        break;
                                    case 2:
                                        System.out.println("===Tentang===");
                                        System.out.println("Permainan suit adalah permainan tradisional yang dilakukan oleh dua orang \ndengan cara mengadu jari untuk menentukan siapa yang menang.\nBiasanya dalam permainan anak-anak, pemenang suit dapat lebih dulu bermain atau terbebas dari menjaga.");
                                        break;
                                    case 3:
                                        System.out.println("===Keluar===");
                                        System.out.println("Terimakasih, Sampai jumpa kembali");
                                        break;
                                    default:
                                        System.out.println("Mohon maaf, nomor yang anda input salah");
                                }
                            } else {
                                System.out.println("username atau password yang anda masukkan salah");
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Input yang anda masukkan salah, mohon masukkan kembali");
                    break;
            }
        }

    }
}
