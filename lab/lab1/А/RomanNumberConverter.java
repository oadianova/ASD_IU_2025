package А;

/* 2. Реализуйте перевод из римских чисел в арабские. */

import java.util.Scanner;

public class RomanNumberConverter {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        String romanNumber = input.next();
        System.out.println(convert(romanNumber));
    }

    static int convert(String romanNumber) {
        int previousValue = 0;
        int counter = 0;
        for (int i = 0; i < romanNumber.length(); i++) {
            int currentValue = convertSymbol(romanNumber.charAt(i));
            if (currentValue >= previousValue) {
                counter += currentValue - previousValue * 2;
            } else {
                counter += currentValue;
            }
            previousValue = currentValue;
        }
        return counter;
    }

    static int convertSymbol(char symbol) {
        return switch (symbol) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}