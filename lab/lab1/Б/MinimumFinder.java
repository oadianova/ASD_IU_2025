package Б;

/* 3. Дан массив целых чисел. Минимальное количество элементов – 5 Вернуть
число, которое является суммой двух наименьших положительных чисел. */

import java.util.Scanner;

public class MinimumFinder {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Введите длинну массива: ");
        int arrayLength = input.nextInt();
        if (arrayLength < 5) {
            System.out.println("Длинна масива должна быть >=5");
            return;
        }
        int[] array = new int[arrayLength];
        inputArray(array);

        int foundSum = findSumOfMinimums(array);
        if (foundSum > 0) {
            System.out.println(findSumOfMinimums(array));
        } else {
            System.out.println("Нет двух положительных чисел");
        }
    }

    static int findSumOfMinimums(int[] array) {
        int firstMinimum = 0;
        int secondMinimum = 0;
        for (int j : array) {
            if (firstMinimum == 0 && j > 0) {
                firstMinimum = j;
                continue;
            }
            if (secondMinimum == 0 && j > 0) {
                secondMinimum = j;
                continue;
            }
            if (j < firstMinimum) {
                firstMinimum = j;
                continue;
            }
            if (j < secondMinimum) {
                secondMinimum = j;
            }
        }
        if (firstMinimum * secondMinimum == 0) {
            return 0;
        }
        return firstMinimum + secondMinimum;
    }

    static void inputArray(int[] array) {
        System.out.print("Введите массив: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
    }
}