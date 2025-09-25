//Реализовать алгоритм бинарного поиска двумя способами.

import java.util.Scanner;

public class BinarySearch {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("!Вводите элементы в порядке возрастания!");
        int[] array = ArrayMethods.newArray();
        ArrayMethods.printArray(array);

        System.out.print("Введите искомый элемент: ");
        int targetElement = scanner.nextInt();

        iterativeSearch(array, targetElement);
        iterativeSearch(array, targetElement);
    }

    private static void iterativeSearch(int[] array, int targetElement) {
        int left = 0;
        int right = array.length - 1;
        int index;

        while (left <= right) {
            index = left + (right - left) / 2;

            if (array[index] == targetElement) {
                System.out.println("Индекс искомого элемента: " + index + "\n");
                return;
            } else if (array[index] < targetElement) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        System.out.println("Искомый элемент не найден. \n");
    }

    private static void recursiveSearch(int[] array, int targetElement) {
        recursiveSearch(array, targetElement, 0, array.length - 1);
    }

    private static void recursiveSearch(int[] arr, int targetElement, int left, int right) {
        // Базовый случай: границы пересеклись
        if (left > right) {
            System.out.println("Искомый элемент не найден. \n");
            return;
        }

        int index = left + (right - left) / 2;

        if (arr[index] == targetElement) {
            System.out.println("Индекс искомого элемента: " + index + "\n");
        } else if (arr[index] < targetElement) {
            recursiveSearch(arr, targetElement, index + 1, right);
        } else {
            recursiveSearch(arr, targetElement, left, index - 1);
        }
    }
}
