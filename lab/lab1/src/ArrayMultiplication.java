/*
* Группа Б, задача 2.
* Пусть любое число – это массив его цифр слева направо. Пример, число
* 1234 – это массив [1,2,3,4].
* Дан массив целых чисел. Реализовать умножение двух чисел.
* Пример, [1, 2, 3, 4] * [1, 1] = [1, 3, 5, 7, 4].
* Результат – число, представленное массивом.
*/

import java.util.Scanner;

public class ArrayMultiplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrA = createIntArray(scanner, 1);
        int[] arrB = createIntArray(scanner, 2);

        int firstNumber = arrayToNumber(arrA);
        int secondNumber = arrayToNumber(arrB);

        int[] resultArray = numberToArray(firstNumber * secondNumber);
        System.out.print("Результат: ");
        printArray(resultArray);
    };

    private static int[] createIntArray(Scanner scanner, int position) {
        short length;
        do {
            System.out.printf("Введите количество элементов в массиве №%d: ", position);
            length = scanner.nextShort();
            if (length < 1) System.out.println("Длина массива не может быть отрицательной или равна нулю.");
        } while (length < 1);
        int[] array = new int[length];
        fillArray(array, scanner);
        return array;
    };

    private static void fillArray(int[] array, Scanner scanner) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Введите элемент №%d: ", i + 1);
            array[i] = scanner.nextInt();
        }
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.printf("%d ", num);
        }
        System.out.println();
    }

    private static int arrayToNumber(int[] arr) {
        int result = 0;
        for (int digit: arr) {
            result = result * 10 + digit;
        }
        return result;
    }

    private static int[] numberToArray(int number) {
        char[] stringNumber = Integer.toString(number).toCharArray();
        int[] arr = new int[stringNumber.length];
        for (int i = 0; i < stringNumber.length; i++) {
            arr[i] = stringNumber[i] - '0';
        }
        return arr;
    }

}
