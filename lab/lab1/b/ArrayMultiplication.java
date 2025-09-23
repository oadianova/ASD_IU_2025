package lab1.b;

/* 2. Пусть любое число – это массив его цифр слева направо.
Пример, число 1234 – это массив [1,2,3,4].
Дан массив целых чисел. Реализовать умножение двух чисел.
Пример, [1, 2, 3, 4] * [1, 1] = [1, 3, 5, 7, 4].
Результат – число, представленное массивом. */

import java.util.Scanner;

public class ArrayMultiplication {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int[] a = inputArray();
        int[] b = inputArray();
        printArray(multiplyArrays(a, b));
    }

    static int[] multiplyArrays(int[] firstArray, int[] secondArray) {
        int resultNumber = convertArrayToNumber(firstArray) * convertArrayToNumber(secondArray);
        return convertNumberToArray(resultNumber);
    }

    static int convertArrayToNumber(int[] array) {
        int number = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            number += array[i] * (int) Math.pow(10, array.length - i - 1);
        }
        return number;
    }

    static int[] convertNumberToArray(int number) {
        int arrayLength = ("" + number).length();
        int[] resultArray = new int[arrayLength];
        for (int i = arrayLength - 1; i >= 0; i--) {
            resultArray[i] = number % 10;
            number /= 10;
        }
        return resultArray;
    }

    static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length - 1] + "]");
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