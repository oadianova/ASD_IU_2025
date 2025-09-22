package Б;

/* 4. Дан массив целых чисел, представляющий двоичное число.
Пример, дан массив bi_arr = [1, 1, 0]. Этот массив в десятичной системе
выглядит так: arr = [1, 3, 6]. То есть:
• arr[0] = bi_arr[0] = 1 (основание 2) = 1 (основание 10),
• arr[1] = bi_arr[0] bi_arr[1] = 11 (основание 2) = 3 (основание 10),
• arr[2] = bi_arr[0] bi_arr[1] bi_arr[2] = 110 (основание 2) = 6 (основание 10)
Так же дано целое положительное число – n. Вернуть массив Boolean, где
true – число делится на N, false – нет.
Пусть n = 6, тогда для предыдущего примера результат должен выглядеть
так: [false, false, true].
Примечание. Делитель тоже необходимо ввести с клавиатуры. */

import java.util.Scanner;

public class DivisorChecker {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array = inputArray();
        System.out.print("Какой делитель проверить: ");
        int N = input.nextInt();
        printArray(checkDivisors(array, N));
    }

    static boolean[] checkDivisors(int[] array, int N) {
        boolean[] divisorsInfo = new boolean[array.length];
        int separateNumber = 0;
        for (int i = 0; i < array.length; i++) {
            separateNumber = (separateNumber << 1) + array[i];
            divisorsInfo[i] = (separateNumber % N == 0);
        }
        return divisorsInfo;
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

    static void printArray(boolean[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.print(array[array.length - 1] + "]");
    }
}