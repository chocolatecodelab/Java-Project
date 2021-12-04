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
public class ForFor {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        int angka;
//        System.out.print("silakan masukkan : ");
//        angka = input.nextInt();
//        for (int i = angka; i > 0; i--) {
//            if (i % 2 != 0) {
//                System.out.print("=");
//            } else if (i % 2 == 0) {
//                System.out.print("-");
//            }
//        }
    int pilihan;
    boolean kondisi = true;
    while(kondisi ) {
        System.out.println("apakah anda ingin bermain lagi ? (1. Yes, 2. No )");
        System.out.print("Pilihan saya : ");
        pilihan = input.nextInt();
        if(pilihan == 2) {
        kondisi = false;
        } 
    }
        System.out.println("Sampai jumpa lagi ");

    }
}
