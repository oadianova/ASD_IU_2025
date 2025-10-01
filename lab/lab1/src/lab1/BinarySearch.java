/* Основное задание. Реализовать алгоритм бинарного поиска двумя способами. */

package lab1;

import java.util.Scanner;


public class BinarySearch {

    public static void main(String[] args){

        int size = ArrayUtils.inputArraySize();
        int[] array = new int[size];
        ArrayUtils.inputArray(array);
        ArrayUtils.outputArray(array);
        ArrayUtils.selectionSort(array);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число, которое нужно будет найти");
        int targetValue = scanner.nextInt();

        System.out.println("Итеративный поиск");
        System.out.println(iterative(array, targetValue, 0, array.length - 1));

        System.out.println("Рекурсивный поиск");
        System.out.println(recursion(array, targetValue, 0, array.length - 1));
    }

    private static int iterative(int[] array, int targetValue, int left, int right) {
        int targetIndex = -1;
        int middle;

        while (left <= right) {
            middle = (left + right) / 2;
            if (array[middle] == targetValue) {
                targetIndex = middle;
                break;
            } else if (array[middle] > targetValue) {
                right = middle - 1;
            } else {
                left = middle + 1;

            }
        }
        return targetIndex;
    }


    private static int recursion(int[] array, int targetValue, int left, int right){
        int middle;
        middle = (left + right) / 2;

        if (left == right) {
            return (array[left] == targetValue) ? left : -1;
        }
        if (left > right) {
            return  -1;
        }

        if (array[middle] > targetValue){
            return recursion(array, targetValue, left, middle - 1);
        } else if (array[middle] < targetValue) {
            return recursion(array, targetValue, middle + 1, right);
        }

        return middle;
    }
}

