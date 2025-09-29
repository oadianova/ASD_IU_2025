package groupb;

import java.util.Scanner;

public class ArrayMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество цифр первого числа:");
        int n1 = scanner.nextInt();
        int[] num1 = new int[n1];
        System.out.println("Введите цифры первого числа (слева направо):");
        for (int i = 0; i < n1; i++) {
            num1[i] = scanner.nextInt();
        }

        System.out.println("Введите количество цифр второго числа:");
        int n2 = scanner.nextInt();
        int[] num2 = new int[n2];
        System.out.println("Введите цифры второго числа (слева направо):");
        for (int i = 0; i < n2; i++) {
            num2[i] = scanner.nextInt();
        }

        int[] result = multiplyArrays(num1, num2);

        System.out.print("Результат умножения: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        scanner.close();
    }

    public static int[] multiplyArrays(int[] num1, int[] num2) {
        int number1 = arrayToNumber(num1);
        int number2 = arrayToNumber(num2);
        int product = number1 * number2;

        return numberToArray(product);
    }

    private static int arrayToNumber(int[] arr) {
        int number = 0;
        for (int i = 0; i < arr.length; i++) {
            number = number * 10 + arr[i];
        }
        return number;
    }

    private static int[] numberToArray(int number) {
        if (number == 0) {
            return new int[]{0};
        }

        int temp = number;
        int length = 0;
        while (temp > 0) {
            temp /= 10;
            length++;
        }

        int[] result = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            result[i] = number % 10;
            number /= 10;
        }

        return result;
    }
}