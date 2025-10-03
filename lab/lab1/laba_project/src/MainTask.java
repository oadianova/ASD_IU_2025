import java.util.Scanner;

public class MainTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int arraySize = scanner.nextInt();

        int[] array = new int[arraySize];

        fillArray(array, arraySize, scanner);

        System.out.print("Итоговый массив: ");
        printArray(array);

        System.out.print("Введите число, индекс которого необходимо получить: ");
        int targetValue = scanner.nextInt();

        int iterativeResult = binarySearchIterative(array, arraySize, targetValue);
        int recursiveResult = binarySearchRecursive(array, arraySize, targetValue);

        System.out.println("Резукльтат итеративного поиска:");
        System.out.println(iterativeResult);
        System.out.println("Резукльтат рекурсивного поиска:");
        System.out.println(recursiveResult);
    }

    private static void fillArray(int[] array, int arraySize, Scanner scanner) {
        System.out.println("Введите " + arraySize + " целых чисел в порядке возрастания:");
        int i = 0;
        while (i < arraySize) {
            System.out.print("Введите число #" + (i + 1) + ": ");
            int currentValue = scanner.nextInt();
            if (i == 0 || currentValue > array[i - 1]) {
                array[i] = currentValue;
                i++;
            } else {
                System.out.println("Числа должны идти в порядке возрастания, попробуйте еще раз))");
            }
        }
    }

    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private static int binarySearchIterative(int[] array, int arraySize, int target) {
        int left = 0;
        int right = arraySize - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midValue = array[mid];

            if (midValue == target) {
                return mid;
            } else if (midValue > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    private static int binarySearchRecursive(int[] array, int arraySize, int target) {
        return recursive(array, target, 0, arraySize - 1);
    }

    private static int recursive(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            return recursive(array, target, left, mid - 1);
        } else {
            return recursive(array, target, mid + 1, right);
        }
    }
}
