package solutions;

import java.util.Scanner;

public class ConsoleArrayPresets {
    public static int getLength(Scanner scanner, int minimumValue) {
        int length;
        while (true) {
            System.out.print("Введите количество элементов массива: ");
            length = scanner.nextInt();
            if (length < minimumValue) {
                System.out.println("Некорректное значение для длины массива. Минимальное возможное значение: " + minimumValue);
                System.out.println("Попробуйте снова");
            } else break;
        }
        scanner.nextLine();
        return length;
    }

    public static int[] getNumberArray(int capacity, Scanner scanner) {
        int[] inputArray = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            inputArray[i] = scanner.nextInt();
        }
        scanner.nextLine();
        return inputArray;
    }
}
