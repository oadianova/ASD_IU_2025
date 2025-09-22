package Б;

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
        int firstNumber = 0;
        int secondNumber = 0;
        int resultNumber;
        for (int i = firstArray.length - 1; i >= 0; i--) {
            firstNumber += firstArray[i] * (int) Math.pow(10, firstArray.length - i - 1);
        }
        for (int i = secondArray.length - 1; i >= 0; i--) {
            secondNumber += secondArray[i] * (int) Math.pow(10, secondArray.length - i - 1);
        }
        resultNumber = firstNumber * secondNumber;
        int resultNumberLength = ("" + resultNumber).length();
        int[] resultArray = new int[resultNumberLength];
        for (int i = resultNumberLength - 1; i >= 0; i--) {
            resultArray[i] = resultNumber % 10;
            resultNumber /= 10;
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