// Основное задание.
// Задание оценивается в 0 баллов, но является обязательным.
// Реализовать алгоритм бинарного поиска двумя способами.

package lab1.maintask;

import java.util.Scanner;

public class MainTask {
    public static void main() {
        int lenArray = getLenArray();
        System.out.println("Input int array: ");
        int[] array = new int[lenArray];
        getIntArray(array, lenArray);
        bubbleSortIntArray(array);
        System.out.println("Sorted array:");
        printIntArray(array);
        
        System.out.print("Input number for first find method: ");
        int inputFirstFindNumber = getInt();
        int indexFirstFind = firstBinaryFind(array, inputFirstFindNumber);
        System.out.println(indexFirstFind);

        System.out.print("Input number for second find method: ");
        int inputSecondFindNumber = getInt();
        int indexSecondFind = secondBinaryFind(array, inputSecondFindNumber);
        System.out.println(indexSecondFind);
    }


    public static int getInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt(); // Чтение целого числа
    }

    public static int getLenArray() {
        int inputLen = 0;
        while (inputLen <= 0 || inputLen>1000) {
            System.out.print("Input length array: ");
            inputLen=getInt();
        }
        return inputLen;
    }

    public static void getIntArray(int[] array, int lenArray) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < lenArray; i++) {
            array[i] = scanner.nextInt(); // Чтение целого числа
        }

    }

    public static void printIntArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void bubbleSortIntArray(int[] array) {
        for (int pass = 1; pass < array.length; pass++) {
            for (int i = 0; i < array.length - pass; i++) {
                if (array[i] > array[i + 1]) {
                    swapInt(array, i, i + 1);
                }
            }
        }
    }

    public static void swapInt(int[] array, int a, int b) {
        if (a < 0 || array.length <= a) return;
        if (b < 0 || array.length <= b) return;
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    //-------------------------------------------
    public static int firstBinaryFind(int[] array, int number) {
        if (array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        while (right - left > 1) {
            int center = (left + right) / 2;
            System.out.println(left + " " + center + " " + right);
            if (array[center] <= number) {
                left = center;
            } else {
                right = center;
            }
        }
        if (array[left] == number) {
            return left;
        } else if (array[right] == number) {
            return right;
        } else {
            return -1;
        }
    }

    public static int secondBinaryFind(int[] array, int number) {
        if (array.length == 0) {
            return -1;
        }
        int left = 0, right = array.length - 1;
        int center = left + (right - left) / 2;
        while (center != left) {
            System.out.println(left + " " + center + " " + right);
            if (array[center] <= number) {
                left = center;
            } else {
                right = center;
            }
            center = left + (right - left) / 2;
        }
        if (array[left] == number) {
            return left;
        } else if (array[right] == number) {
            return right;
        } else {
            return -1;
        }
    }
}

// 1 3 9 2 5
// 1 2 3 5 9
