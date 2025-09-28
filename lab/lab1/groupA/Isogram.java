package groupA;

//3. Изограмма – это слово, в котором нет повторяющихся букв,
//последовательных или непоследовательных. Реализуйте функцию, которая
//определяет, является ли строка, изограммой. Пустая строка является
//изограммой.

import java.util.Scanner;

public class Isogram {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(isIsogram(scn.next()));
    }

    public static boolean isIsogram(String str) {
        char[] letters = str.toLowerCase().toCharArray();
        quickSort(letters);
        return !twoSameLetters(letters);
    }

    public static boolean twoSameLetters(char[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) return true;
        }
        return false;
    }

    public static void quickSort(char[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(char[] arr, int left, int right) {
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

    public static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
