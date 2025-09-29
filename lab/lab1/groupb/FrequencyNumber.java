package groupb;

import java.util.Scanner;

public class FrequencyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество элементов массива:");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int result = findFrequencyNumber(array);
        System.out.println("Результат: " + result);

        scanner.close();
    }

    public static int findFrequencyNumber(int[] array) {
        int maxNumber = -1;

        for (int i = 0; i < array.length; i++) {
            int frequency = 0;

            for (int j = 0; j < array.length; j++) {
                if (array[j] == array[i]) {
                    frequency++;
                }
            }

            if (array[i] == frequency) {
                if (array[i] > maxNumber) {
                    maxNumber = array[i];
                }
            }
        }

        return maxNumber;
    }
}