/*
* Группа Б, задача 3.
* Дан массив целых чисел. Минимальное количество элементов – 5. Вернуть
* число, которое является суммой двух наименьших положительных чисел.
*/

import java.util.Scanner;

public class TwoMinPositiveSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = createIntArray(scanner);
        bubbleSort(array);
        System.out.printf("Сумма двух наименьших положительных чисел: %d", sum(array));
    }

    private static int[] createIntArray(Scanner scanner) {
        short length;
        do {
            System.out.print("Введите количество элементов в массиве: ");
            length = scanner.nextShort();
            if (length < 5) System.out.println("Длина массива не может быть меньше пяти.");
        } while (length < 5);
        int[] array = new int[length];
        fillArray(array, scanner);
        return array;
    }

    private static void fillArray(int[] array, Scanner scanner) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Введите элемент №%d: ", i + 1);
            array[i] = scanner.nextInt();
        }
    }

    private static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static int sum(int[] array) {
        int sum = 0;
        byte positiveCount = 0;
        for (int number: array) {
            if (number <= 0) continue;
            sum += number;
            positiveCount++;
            if (positiveCount == 2) break;
        }
        return sum;
    }

}
