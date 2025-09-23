package groupB;

//1. Дан целочисленный массив. Верните число, частота встречи которого в
//массиве равна его значению. Если таких чисел нет, вернуть «-1». Если
//таких чисел несколько, вернуть наибольшее.

import java.util.Scanner;

public class ValueFrequencyCount {

    public static Scanner scn = new Scanner(System.in);

    public static void inputArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int i = left, j = right;
        int pivot = arr[(left + right) / 2];

        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        quickSort(arr, left, j);
        quickSort(arr, i, right);

    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void copyArray(int[] data, int[] copy) {
        for (int i = 0; i < data.length; i++) {
            try {
                copy[i] = data[i];
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("Index out of range");
                return;
            }
        }
    }

    public static int countValueFrequency(int[] arr) {
        int length = arr.length;
        int[] arrCopy = new int[length];
        copyArray(arr, arrCopy);
        quickSort(arrCopy);
        int count = 1;
        for (int i = length - 1; i > 1; i--) {
            if (arrCopy[i - 1] == arrCopy[i]) count++;
            else if (count == arrCopy[i]) return count;
            else count = 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int length = scn.nextInt();
        int[] arr = new int[length];
        inputArray(arr);
        System.out.println(countValueFrequency(arr));
    }
}
