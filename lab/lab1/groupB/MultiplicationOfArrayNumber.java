package groupB;

import java.util.Scanner;

//2. Пусть любое число – это массив его цифр слева направо. Пример, число
//1234 – это массив [1,2,3,4].
//Дан массив целых чисел. Реализовать умножение двух чисел.
//Пример, [1, 2, 3, 4] * [1, 1] = [1, 3, 5, 7, 4].

public class MultiplicationOfArrayNumber {
    public static Scanner scn = new Scanner(System.in);

    public static void inputArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[arr.length - 1] + "\n");
    }

    public static int arrayToInt(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result * 10 + arr[i];
        }
        return result;
    }


    public static int[] intToArray(int number) {
        if (number == 0) {
            return new int[] {0};
        }

        int length = 0;
        int tmp = number;
        while (tmp > 0) {
            length++;
            tmp /= 10;
        }

        int[] result = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            result[i] = number % 10;
            number /= 10;
        }

        return result;
    }


    public static int[] multiplyArrays(int[] number1, int[] number2) {
        return intToArray(arrayToInt(number1) * arrayToInt(number2));
    }


    public static void main(String[] args) {
        int length1 = scn.nextInt();
        int[] number1 = new int[length1];
        inputArray(number1);

        int length2 = scn.nextInt();
        int[] number2 = new int[length2];
        inputArray(number2);

        int[] mult = multiplyArrays(number1, number2);
        printArray(mult);
    }
}
