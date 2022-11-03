package org.example.Utill;

import java.util.Scanner;

public class ScannerUtil {
    public static int getAction() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter number: ");
            try {
                int n = scanner.nextInt();
                return n;
            } catch (RuntimeException e) {
                System.out.println("Hato kirildi. Son kiriting Mazgi.");
            }
        }

    }
    public static String getWord(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter word: ");
        try {
            return scanner.next();
        } catch (RuntimeException e) {
            System.out.println("Hato kirildi. so`z kiriting Mazgi.");
        }
        return null ;
    }
}
