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

        int result1 = iterativeSearch(array, targetElement);
        int result2 = recursiveSearch(array, targetElement);

        System.out.println("Результат метода итераций: " + (result1 == -1 ? "Элемент не найден" : result1));
        System.out.println("Результат метода рекурсии: " + (result2 == -1 ? "Элемент не найден" : result2));
    }

    private static int iterativeSearch(int[] array, int targetElement) {
        int left = 0;
        int right = array.length - 1;
        int index;

        while (left <= right) {
            index = left + (right - left) / 2;

            if (array[index] == targetElement) {
                return index;
            } else if (array[index] < targetElement) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        return -1;
    }

    private static int recursiveSearch(int[] array, int targetElement) {
        return (recursiveSearch(array, targetElement, 0, array.length - 1));
    }

    private static int recursiveSearch(int[] arr, int targetElement, int left, int right) {
        // Базовый случай: границы пересеклись
        if (left > right) {
            return -1;
        }

        int index = left + (right - left) / 2;

        if (arr[index] == targetElement) {
            return index;
        } else if (arr[index] < targetElement) {
            recursiveSearch(arr, targetElement, index + 1, right);
        } else {
            recursiveSearch(arr, targetElement, left, index - 1);
        }
        return -1;
    }
}
