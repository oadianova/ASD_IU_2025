package solutions;

import java.util.Scanner;

//Задание Б3
//Дан массив целых чисел. Минимальное количество элементов – 5. Вернуть
//число, которое является суммой двух наименьших положительных чисел.

public class TaskB3 {
    private final Scanner scanner;

    public TaskB3(Scanner externalScanner) {
        scanner = externalScanner;
    }

    private int getLengthFromConsole() {
        int length;
        while (true) {
            System.out.print("Введите количество элементов массива: ");
            length = scanner.nextInt();
            if (length < 5) {
                System.out.println("Некорректное значение для длины массива. Минимальное значение: 5. Попробуйте снова.");
            } else break;
        }
        scanner.nextLine();
        return length;
    }

    private int[] getNumberArrayFromConsole(int capacity) {
        int[] inputArray = new int[capacity];
        System.out.println("Заполните массив целыми числами");
        for (int i = 0; i < capacity; i++) {
            inputArray[i] = scanner.nextInt();
        }
        scanner.nextLine();
        return inputArray;
    }

    private int indexOfPositiveMinimum(int[] array) {
        int currentMinimumIndex = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                if (currentMinimumIndex == -1 || array[i] < array[currentMinimumIndex]) {
                    currentMinimumIndex = i;
                }
            }
        }

        return currentMinimumIndex;
    }

    public void start() {
        System.out.println("\n========Задание Б3========\n");
        int capacity = getLengthFromConsole();
        int[] inputArray = getNumberArrayFromConsole(capacity);

        try {
            int firstMinimumIndex = indexOfPositiveMinimum(inputArray);
            if (firstMinimumIndex < 0) {
                throw new Error("no first minimum");
            }
            int firstMinimumValue = inputArray[firstMinimumIndex];

            inputArray[firstMinimumIndex] = 0;
            int secondMinimumIndex = indexOfPositiveMinimum(inputArray);
            if (secondMinimumIndex < 0) {
                throw new Error("no second minimum");
            }
            int secondMinimumValue = inputArray[secondMinimumIndex];

            System.out.println("Сумма двух наименьших положительных чисел равна: " + (firstMinimumValue + secondMinimumValue));
        } catch (Error error) {
            switch (error.getMessage()) {
                case "no first minimum":
                    System.out.println("Недопустимый ввод: массив не содержит положительных чисел.\nЗавершение выполнения Б3");
                    break;
                case "no second minimum":
                    System.out.println("Недопустимый ввод: массив содержит только одно положительное число\nЗавершение выполнения Б3");
                    break;
            }
        }
    }
}
