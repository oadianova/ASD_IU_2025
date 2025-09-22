package Б;

/* 1. Дан целочисленный массив. Верните число, частота встречи которого в
массиве равна его значению. Если таких чисел нет, вернуть «-1». Если
таких чисел несколько, вернуть наибольшее. */

import java.util.Scanner;

public class FrequentNumberFinder {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Введите длинну массива: ");
        int arrayLength = input.nextInt();
        int[] array = new int[arrayLength];
        System.out.print("Введите массив: ");
        inputArray(array);
        System.out.println(findFrequentNumber(array));
    }

    static void inputArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = input.nextInt();
        }
    }

    static int findFrequentNumber(int[] array) {
        int temporaryAnswer = -1;
        int temporaryMaxFrequency = 0;
        for (int j : array) {
            int frequency = count(array, j);
            if (frequency == j) {
                if (frequency > temporaryMaxFrequency) {
                    temporaryAnswer = j;
                    temporaryMaxFrequency = frequency;
                }
            }
        }
        return temporaryAnswer;
    }

    static int count(int[] array, int number) {
        int count = 0;
        for (int j : array) {
            if (j == number) {
                count++;
            }
        }
        return count;
    }
}