/*
* Группа Б, задача 1
* Дан целочисленный массив. Верните число, частота встречи которого в
* массиве равна его значению. Если таких чисел нет, вернуть «-1». Если
* таких чисел несколько, вернуть наибольшее.
*/

import java.util.Scanner;

public class FrequentElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = createIntArray(scanner);
        bubbleSort(array);

        int count = 1;
        int maxValue = -1;

        for (int i = 1; i < array.length; i++) {
            if (array[i-1] != array[i]) {
                if (count == array[i-1]) {
                    maxValue = array[i-1];
                }
                count = 0;
            }
            count++;
        }

        System.out.println(maxValue);
    }

    private static void bubbleSort(int[] array) {
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

    private static int[] createIntArray(Scanner scanner) {
        short length;
        do {
            System.out.print("Введите количество элементов в массиве: ");
            length = scanner.nextShort();
            if (length < 1) System.out.println("Длина массива не может быть отрицательной или равна нулю.");
        } while (length < 1);
        int[] array = new int[length];
        fillArray(array, scanner);
        return array;
    }

    private static void fillArray(int[] array, Scanner scanner) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Введите элемент №%d: ", i + 1);
            array[i] = scanner.nextInt();
        }
    }

}
