/*
* Группа Б, задача 1
* Дан целочисленный массив. Верните число, частота встречи которого в
* массиве равна его значению. Если таких чисел нет, вернуть «-1». Если
* таких чисел несколько, вернуть наибольшее.
*/

import java.util.Scanner;

public class FrequentElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Array.createIntArray(scanner, 1, 1);
        Array.bubbleSort(array);

        int count = 1;
        int maxValue = -1;

        for (int i = 1; i < array.length; i++) {
            if (array[i-1] != array[i]) {
                if (count == array[i - 1]) {
                    maxValue = array[i - 1];
                }
                count = 0;
            };
            count++;
        };

        if (count == array[array.length - 1]) {
            maxValue = array[array.length - 1];
        };

        System.out.println(maxValue);
    };

}
