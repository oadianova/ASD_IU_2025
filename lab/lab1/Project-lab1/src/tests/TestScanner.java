package tests;

import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) {
        System.out.println("input int >> " + getInt());
        System.out.println("input line >> \"" + getLine() + "\"");
    }
    public static String getLine(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine(); // Чтение строки
    }
    public static int getInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt(); // Чтение целого числа
    }

}

