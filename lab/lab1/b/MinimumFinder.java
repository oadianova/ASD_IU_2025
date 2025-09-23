package lab1.b;

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
            System.out.println(foundSum);
        } else {
            System.out.println("Нет двух положительных чисел");
        }
    }

    static int findSumOfMinimums(int[] array) {
        int firstMinimum = -1;
        int secondMinimum = -1;
        for (int j : array) {
            if (j > 0) {
                if (firstMinimum == -1) {
                    firstMinimum = j;
                } else if (secondMinimum == -1) {
                    if (j > firstMinimum) {
                        secondMinimum = j;
                    } else {
                        secondMinimum = firstMinimum;
                        firstMinimum = j;
                    }
                } else {
                    if (j < firstMinimum) {
                        secondMinimum = firstMinimum;
                        firstMinimum = j;
                    } else if (j < secondMinimum) {
                        secondMinimum = j;
                    }
                }
            }
        }
        if (firstMinimum != -1 && secondMinimum != -1) {
            return firstMinimum + secondMinimum;
        } else return 0;
    }

    static void inputArray(int[] array) {
        System.out.print("Введите массив: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
    }
}