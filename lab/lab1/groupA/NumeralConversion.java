package groupA;

import java.util.Scanner;

//2. Реализуйте перевод из римских чисел в арабские.

public class NumeralConversion {
    public static Scanner scn = new Scanner(System.in);

    static int convertDigit(char digit) {
        return switch (digit) {
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
    public static int romeToArabic(String number) {
        int result = 0;
        int prevArabic = 0;

        for (int i = number.length() - 1; i >= 0; i--) {
            char currentRome = number.charAt(i);
            int currentArabic = convertDigit(currentRome);
            if (currentArabic < prevArabic) {
                result -= currentArabic;
            } else {
                result += currentArabic;
            }
            prevArabic = currentArabic;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(romeToArabic(scn.next()));
    }
}
