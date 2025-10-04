package solutions;

import java.util.Scanner;

//Задание Б3
//Дан массив целых чисел. Минимальное количество элементов – 5. Вернуть
//число, которое является суммой двух наименьших положительных чисел.

public class TaskB3 {

    public TaskB3(Scanner externalScanner) {
        scanner = externalScanner;
    }

    public void start() {
        System.out.println("\n========Задание Б3========\n");
        int capacity = ConsolePresets.getLengthFromConsole(scanner, 5);
        System.out.println("Заполните массив целыми числами");
        int[] inputArray = ConsolePresets.getNumberArrayFromConsole(capacity, scanner);

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

    private final Scanner scanner;

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
}
