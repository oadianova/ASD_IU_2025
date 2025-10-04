package solutions;

import java.util.Scanner;

//Задание А2.
//Реализуйте перевод из римских чисел в арабские.
public class TaskA2 {

    public TaskA2(Scanner externalScanner) {
        scanner = externalScanner;
    }

    public void start() {
        System.out.println("\n========Задание А2========\n");

        System.out.print("Введите римское число: ");
        String roman = "";
        roman = scanner.nextLine().toUpperCase();

        System.out.println("Десятичное значение: " + romanStringToArabicNumber(roman));
    }

    private final Scanner scanner;

    private int romanStringToArabicNumber(String roman) {
        int result = 0;
        int localMaximum = 0;
        int currentValue = 0;
        for (int i = roman.length() - 1; i >= 0; i--) {
            currentValue = getIntegerFromRomanCharacter(roman.charAt(i));

            if (currentValue >= localMaximum) {
                localMaximum = currentValue;
                result += currentValue;
            } else {
                result -= currentValue;
            }
        }
        return result;
    }

    private int getIntegerFromRomanCharacter(char roman) {
        return switch (roman) {
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
