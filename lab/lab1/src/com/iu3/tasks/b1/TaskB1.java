//  1. Дан целочисленный массив. Верните число, частота встречи которого в
//  массиве равна его значению. Если таких чисел нет, вернуть «-1». Если
//  таких чисел несколько, вернуть наибольшее.

package com.iu3.tasks.b1;

import static com.iu3.utils.ArrayTools.*;

public class TaskB1 {
    public static void taskB1Example() {
        int[] array = fillArray();

        System.out.print(finder(array));
    }

    public static int finder(int[] arr) {
        int n = arr.length;
        ShellSort(arr);
        int max = Integer.MIN_VALUE;
        int m = arr[0];

        for (int i = 0; i < n; i++) {

            int k = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] == m) k++;
            }
            if (k == m && m > max) {
                max = m;
            }
            if (i + 1 == n) break;
            m = arr[i + 1];
        }
        return max;
    }
}
