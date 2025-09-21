//  2. Пусть любое число – это массив его цифр слева направо. Пример, число
//  1234 – это массив [1,2,3,4].
//  Дан массив целых чисел. Реализовать умножение двух чисел.
//  Пример, [1, 2, 3, 4] * [1, 1] = [1, 3, 5, 7, 4].
//  Результат – число, представленное массивом.

package com.iu3.tasks.b2;

import java.util.Arrays;

import static com.iu3.utils.ArrayTools.fillArray;

public class TaskB2 {
    public static void taskB2Example() {
        int[] arr1 = fillArray();
        int[] arr2 = fillArray();

        int c = arrayToNumber(arr1) * arrayToNumber(arr2);
        int[] arr3 = numberToArray(c);
        System.out.println(Arrays.toString(arr3));
    }

    public static int[] numberToArray(int n) {
        char[] chars = Integer.toString(n).toCharArray();
        int[] result = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            result[i] = chars[i] - '0';
        }

        return result;
    }


    public static int arrayToNumber(int[] arr) {
        int result = 0;

        for (int digit : arr) {
            result = result * 10 + digit;
        }

        return result;
    }
}
