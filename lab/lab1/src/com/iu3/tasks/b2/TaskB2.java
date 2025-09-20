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
