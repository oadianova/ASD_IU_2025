/*
 * Обязательное задание.
 * Реализовать алгоритм бинарного поиска двумя способами.
 */

import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = ArrayUtils.createIntArray(scanner, 1, 1);

        ArrayUtils.bubbleSort(array);
        System.out.print("Упорядоченный массив: ");
        ArrayUtils.printArray(array);

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
