package groupb;

import java.util.Scanner;

public class TwoSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество элементов массива:");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Введите целевую сумму:");
        int target = scanner.nextInt();

        int[] result = findTwoSum(array, target);

        if (result[0] != -1) {
            System.out.println("Индексы: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("Пары не найдено");
        }

        scanner.close();
    }

    public static int[] findTwoSum(int[] array, int target) {
        // Сложность O(n log n) - сортировка + два указателя, при n = натуральному числу, log(n)<n^2
        int[] sortedArray = copyArray(array);
        sortArray(sortedArray);

        int left = 0;
        int right = sortedArray.length - 1;

        while (left < right) {
            int sum = sortedArray[left] + sortedArray[right];

            if (sum == target) {
                return findOriginalIndices(array, sortedArray[left], sortedArray[right]);
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    private static int[] copyArray(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    private static void sortArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static int[] findOriginalIndices(int[] original, int value1, int value2) {
        int index1 = -1;
        int index2 = -1;

        for (int i = 0; i < original.length; i++) {
            if (index1 == -1 && original[i] == value1) {
                index1 = i;
            } else if (index2 == -1 && original[i] == value2) {
                index2 = i;
            }
        }

        if (index1 == -1 || index2 == -1) {
            for (int i = 0; i < original.length; i++) {
                if (index1 == -1 && original[i] == value2) {
                    index1 = i;
                } else if (index2 == -1 && original[i] == value1) {
                    index2 = i;
                }
            }
        }

        return new int[]{index1, index2};
    }
}