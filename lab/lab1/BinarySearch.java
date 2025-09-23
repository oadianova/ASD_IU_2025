package lab1;

/* Реализовать алгоритм бинарного поиска двумя способами. */

import java.util.Scanner;

public class BinarySearch {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array = inputArray();
        System.out.print("Какое число нужно найти: ");
        int target = input.nextInt();
        bubbleSort(array);
        int firstResult = binarySearch(array, target);
        int secondResult = recursiveBinarySearch(array, target);
        System.out.println("Результат бинарного поиска I способом: " + (firstResult == -1 ? "не найдено" : firstResult));
        System.out.println("Результат бинарного поиска II способом: " + (secondResult == -1 ? "не найдено" : secondResult));
    }

    static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) return mid;
            if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    static int recursiveBinarySearch(int[] array, int target, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        if (array[mid] > target) return recursiveBinarySearch(array, target, left, mid - 1);
        else if (array[mid] < target) return recursiveBinarySearch(array, target, mid + 1, right);
        return mid;
    }

    static int recursiveBinarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        return recursiveBinarySearch(array, target, left, right);
    }

    static int[] inputArray() {
        System.out.print("Введите длинну массива: ");
        int arrayLength = input.nextInt();
        int[] array = new int[arrayLength];
        System.out.print("Введите массив: ");
        for (int i = 0; i < arrayLength; i++) {
            array[i] = input.nextInt();
        }
        return array;
    }
}