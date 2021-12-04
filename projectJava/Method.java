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
public class Method {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        int bilangan1, bilangan2;
        println("Selamat datang di program matematika");
        println("Masukkan nilai 1 : ");
        bilangan1 = input.nextInt();
        println("Masukkan nilai 2");
        bilangan2 = input.nextInt();
        operasi(bilangan1, bilangan2);

    }

    static void operasi(int bilangan1, int bilangan2) {
        int pilihan, hasil = 0;
        println("Pilih Menu :");
        println("1. Penjumlahan");
        println("2. Pengurangan");
        print("pilihan saya : ");
        pilihan = input.nextInt();

        switch (pilihan) {
            case 1:
                hasil = penjumlahan(bilangan1, bilangan2);
                break;
            case 2:
                hasil = pengurangan(bilangan1, bilangan2);
                break;
            default:
                println("silakan input kembali");
        }

        hasilProses(hasil);

    }

    static void hasilProses(int hasil) {
        println("====================");
        println(hasil);
    }

    static int penjumlahan(int bilangan1, int bilangan2) {
        int hasil = bilangan1 + bilangan2;
        return hasil;
    }

    static int pengurangan(int bilangan1, int bilangan2) {
        int hasil = bilangan1 - bilangan2;
        return hasil;
    }

    static void println(Object x) {
        System.out.println(x);
    }

    static void print(Object x) {
        System.out.print(x);
    }
}
