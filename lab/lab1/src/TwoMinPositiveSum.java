/*
* Группа Б, задача 3.
* Дан массив целых чисел. Минимальное количество элементов – 5. Вернуть
* число, которое является суммой двух наименьших положительных чисел.
*/

import java.util.Scanner;

public class TwoMinPositiveSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Array.createIntArray(scanner, 1, 5);
        Array.bubbleSort(array);
        int result = findMinSum(array);
        if (result == Integer.MIN_VALUE) {
            System.out.println("Количество положительных элементов меньше двух");
        } else {
            System.out.printf("Сумма двух наименьших положительных чисел: %d", result);
        };
    };

    private static int findMinSum(int[] array) {
        int sum = 0;
        byte positiveCount = 0;
        for (int number: array) {
            if (number <= 0) continue;
            sum += number;
            positiveCount++;
            if (positiveCount == 2) break;
        };
        if (positiveCount < 2) return Integer.MIN_VALUE;
        return sum;
    }

}
