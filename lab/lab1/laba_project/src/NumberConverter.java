import java.util.Scanner;

public class NumberConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число в десятичной системе: ");
        int decimalNumber = scanner.nextInt();

        System.out.print("Введите основание системы счисления (2-9): ");
        int base = scanner.nextInt();

        String convertedNumber = convertNumber(decimalNumber, base);
        System.out.println("Число " + decimalNumber + " в системе счисления с основанием " + base + ":");
        System.out.println(convertedNumber);
    }

    private static String convertNumber(int decimalNumber, int base) {
        if (base < 2 || base > 9) {
            return "Оснвание должно быть от 2 до 9";
        }

        if (decimalNumber == 0) {
            return "0";
        }

        String result = "";
        int number = Math.abs(decimalNumber);

        while (number > 0) {
            int remainder = number % base;
            result = remainder + result;
            number = number / base;
        }

        if (decimalNumber < 0) {
            result = "-" + result;
        }

        return result;
    }
}
