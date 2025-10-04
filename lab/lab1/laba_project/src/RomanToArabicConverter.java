import java.util.Scanner;

public class RomanToArabicConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите римское число: ");
        String romanNumber = scanner.nextLine().toUpperCase();

        int result = convertRomanToArabic(romanNumber);
        System.out.println("Арабское представление: " + result);
    }

    private static int convertRomanToArabic(String roman) {
        if (roman.isEmpty()) {
            return 0;
        }

        int result = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            char currentChar = roman.charAt(i);
            int currentValue = getRomanValue(currentChar);

            if (currentValue == 0) {
                return 0;
            }

            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            prevValue = currentValue;
        }

        return result;
    }

    private static int getRomanValue(char romanChar) {
        return switch (romanChar) {
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
