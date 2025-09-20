/*
 * Обязательное задание.
 * Реализовать алгоритм бинарного поиска двумя способами.
 */

import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short length;
        do {
            System.out.print("Введите количество элементов в массиве: ");
            length = scanner.nextShort();
            if (length < 1) System.out.println("Длина массива не может быть отрицательной или равна нулю.");
        } while (length < 1);

        int[] array = new int[length];
        fillArray(array, scanner);

        bubbleSort(array);
        System.out.print("Упорядоченный массив: ");
        printArray(array);

        System.out.print("Введите элемент, индекс которого хотите найти: ");
        int searchValue = scanner.nextInt();

        System.out.printf(
                "Результат нерекурсивного поиска: %d\n",
                searchWithoutRecursion(array, searchValue, 0, array.length - 1)
        );
        System.out.printf(
                "Результат рекурсивного поиска: %d",
                searchWithRecursion(array, searchValue, 0, array.length - 1)
        );
    }

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

    private static int searchWithoutRecursion(int[] array, int searchValue, int left, int right) {
        int index = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (array[middle] < searchValue) {
                left = middle + 1;
            } else if (array[middle] > searchValue) {
                right = middle - 1;
            } else if (array[middle] == searchValue) {
                index = middle;
                break;
            }
        }
        return index;
    }

    private static int searchWithRecursion(int[] array, int searchValue, int left, int right) {
        if (left > right) return -1;
        if (left == right) {
            return (array[left] == searchValue) ? left : -1;
        }
        int middle = left + (right - left) / 2;
        if (searchValue > array[middle]) {
            return searchWithRecursion(array, searchValue, middle + 1, right);
        } else if (array[middle] > searchValue) {
            return searchWithRecursion(array, searchValue, left, middle - 1);
        }
        return middle;
    }

}
