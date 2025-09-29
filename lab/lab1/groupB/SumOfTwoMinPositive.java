package groupB;

import java.util.Scanner;

//3. Дан массив целых чисел. Минимальное количество элементов – 5. Вернуть
//число, которое является суммой двух наименьших положительных чисел

public class SumOfTwoMinPositive {

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scn.nextInt();
        int[] arr = new int[length];
        inputArray(arr);
        try {
            System.out.println(sumOfTwoMinPositive(arr));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static int sumOfTwoMinPositive(int[] arr) throws IllegalArgumentException {
        if (arr.length < 5) {
            System.out.println("Length must be more than 5");
            return -1;
        }
//        int[] arrCopy = new int[arr.length];
//        copyArray(arr, arrCopy);
        insertionSort(arr);
        int i = 0;
        while (arr[i] <= 0) i++;
        try {
            return arr[i] + arr[i + 1];
        } catch (ArrayIndexOutOfBoundsException exception) {
            return 0;
        }
    }

    public static void inputArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }

//    public static void copyArray(int[] data, int[] copy) {
//        for (int i = 0; i < data.length; i++) {
//            try {
//                copy[i] = data[i];
//            } catch (ArrayIndexOutOfBoundsException exception) {
//                System.out.println("Index out of range");
//                return;
//            }
//        }
//    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                swap(arr, j - 1, j);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
