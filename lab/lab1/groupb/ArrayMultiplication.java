//Пусть любое число – это массив его цифр слева направо. Пример, число
//1234 – это массив [1,2,3,4].
//Дан массив целых чисел. Реализовать умножение двух чисел.
//Пример, [1, 2, 3, 4] * [1, 1] = [1, 3, 5, 7, 4].
//Результат – число, представленное массивом.

package groupb;

import java.util.Scanner;
import functions.ArrayUtils;

public class ArrayMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] num1 = ArrayUtils.inputArrayFromUser(scanner, "для первого числа");
        int[] num2 = ArrayUtils.inputArrayFromUser(scanner, "для второго числа");

        int[] result = multiplyArrays(num1, num2);

        ArrayUtils.printArray(result, "Результат умножения");

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