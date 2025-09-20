//  Основное задание. Задание оценивается в 0 баллов, но является обязательным.
//  Реализовать алгоритм бинарного поиска двумя способами.

package com.iu3.tasks.a0;

import java.util.Scanner;
import static com.iu3.utils.ArrayTools.fillArray;
import static com.iu3.utils.ArrayTools.printArray;

public class BinarySearch {

    private static final Scanner scanner = new Scanner(System.in);

    public static void binarySearchExample() {

        // 1. Заполнение массива
        int[] array = fillArray();

        // 2. Вывод массива
        System.out.println("Введённый массив:");
        printArray(array);

        // 3. Ввод искомого элемента
        System.out.print("Введите число для поиска: ");
        int target = scanner.nextInt();

        // 4. Итеративный бинарный поиск
        int resultIterative = binarySearchIterative(array, target);
        if (resultIterative != -1) {
            System.out.println("Итеративный поиск: элемент найден на позиции " + resultIterative);
        } else {
            System.out.println("Итеративный поиск: элемент не найден");
        }

        // 5. Рекурсивный бинарный поиск
        int resultRecursive = binarySearchRecursive(array, target, 0, array.length - 1);
        if (resultRecursive != -1) {
            System.out.println("Рекурсивный поиск: элемент найден на позиции " + resultRecursive);
        } else {
            System.out.println("Рекурсивный поиск: элемент не найден");
        }

        scanner.close();
    }




    /**
     * Итеративная реализация бинарного поиска
     */
    public static int binarySearchIterative(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; // элемент найден
            } else if (array[mid] < target) {
                left = mid + 1; // ищем в правой половине
            } else {
                right = mid - 1; // ищем в левой половине
            }
        }

        return -1; // элемент не найден
    }

    /**
     * Рекурсивная реализация бинарного поиска
     */

    public static int binarySearchRecursive(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1; // базовый случай: элемент не найден
        }

        int mid = left + (right - left) / 2;

        if (array[mid] == target) {
            return mid; // элемент найден
        } else if (array[mid] < target) {
            return binarySearchRecursive(array, target, mid + 1, right); // правая половина
        } else {
            return binarySearchRecursive(array, target, left, mid - 1); // левая половина
        }
    }
}