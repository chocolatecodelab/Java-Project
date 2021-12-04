package projectJava;


import java.util.Scanner;
public class mainBilangan {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        System.out.println("******");
        System.out.println("Main Bilangan v2.2.a");
        System.out.println("******");
        System.out.println("");
        
        int a,b,bilFav,danger;
        System.out.print("Masukkan bilangan bulat pertama: ");
        a = io.nextInt();
        System.out.print("Masukkan bilangan bulat kedua: ");
        b = io.nextInt();
        System.out.print("Masukkan bilangan bulat favorit: ");
        bilFav = io.nextInt();
        System.out.print("Masukkan bilangan bulat terlarang: ");
        danger = io.nextInt();

        int i;
        System.out.println("");
        System.out.printf("Konfigurasi bilangan:");
        System.out.println("");
        i = a;
        
        if(a <= b) {
            while( i <= b ) {
                if (i == danger) {
                    i++;
                    continue;
                } 
		System.out.print(i);
                if (i == bilFav && bilFav % 2 == 0) {
                    System.out.println(" - bilangan favorit adalah bilangan genap");
                } else if (i == bilFav && bilFav % 2 == 1) {
                    System.out.println(" - bilangan favorit adalah bilangan ganjil");
                } else {
                    System.out.println("");
                }
                i++;
            }
        } else if (a >= b) {
            while(i >= b ) {
                if (i == danger) {
                    continue;
                    
                } 
                System.out.print(i);
                if (i == bilFav && bilFav % 2 == 0) {
                    System.out.println(" - bilangan favorit adalah bilangan genap");
                } else if (i == bilFav && bilFav % 2 == 1) {
                    System.out.println(" - bilangan favorit adalah bilangan ganjil");
                } else {
                    System.out.println("");
                }
                i--;
            }
        }
        
        System.out.println("");
        System.out.print("Terima kasih, anda telah bermain dengan bilangan " + a + ", " + b + ", " + bilFav+ ", dan " + danger + ".");
            }
        }
