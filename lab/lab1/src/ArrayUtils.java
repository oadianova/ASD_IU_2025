import java.util.Scanner;

public class ArrayUtils {
    public static int[] createIntArray(Scanner scanner, int position, int minLength) {
        int length;
        do {
            System.out.printf("Введите количество элементов в массиве №%d: ", position);
            length = scanner.nextShort();
            if (length < minLength) System.out.printf("Длина массива не может быть отрицательной или меньше %d\n", minLength);
        } while (length < minLength);
        int[] array = new int[length];
        fillArray(array, scanner);
        return array;
    };

    private static void fillArray(int[] array, Scanner scanner) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Введите элемент №%d: ", i + 1);
            array[i] = scanner.nextInt();
        }
    };

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.printf("%d ", num);
        }
        System.out.println();
    };

    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

}
