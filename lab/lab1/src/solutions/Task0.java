package solutions;

import java.util.Scanner;

//Основное задание:
//Реализовать алгоритм бинарного поиска двумя способами.
public class Task0 {

    public Task0(Scanner externalScanner) {
        scanner = externalScanner;
    }

    public void start() {
        System.out.println("========Задание 0========\n");
        int capacity = ConsoleArrayPresets.getLength(scanner, 1);
        System.out.println("Заполните массив целыми числами по возрастанию");
        int[] inputArray = ConsoleArrayPresets.getNumberArray(capacity, scanner);

        System.out.print("Массив заполнен. Введите число, которое необходимо найти: ");
        int target = scanner.nextInt();
        System.out.println("Все входные данные введены. Начало бинарного поиска");

        System.out.println("Реализация через рекурсию:");
        int resultIndex = binarySearchRecursion(inputArray, target, 0, capacity - 1);

        if (resultIndex >= 0) {
            System.out.println(" * Индекс искомого числа = " + resultIndex);
        } else {
            System.out.println(" * Программа не нашла искомого числа в заданном массиве");
        }

        System.out.println("Реализация через цикл:");
        resultIndex = binarySearchLoop(inputArray, target, 0, capacity - 1);

        if (resultIndex >= 0) {
            System.out.println(" # Индекс искомого числа = " + resultIndex);
        } else {
            System.out.println(" # Программа не нашла искомого числа в заданном массиве");
        }
    }

    private final Scanner scanner;

    private int binarySearchRecursion(int[] array, int target, int begin, int end) {
        int medium = begin + (end - begin) / 2;

        if (array[medium] == target) return medium;
        else if (begin == end) return -1;
        else if (array[medium] > target && medium != begin) //medium != begin добавлено потому, что если len = 2,
        //то medium == begin, и значение end становится < beg
        {
            return binarySearchRecursion(array, target, begin, medium - 1);
        } else if (array[medium] < target) {
            return binarySearchRecursion(array, target, medium + 1, end);
        }
        return -1;
    }

    private int binarySearchLoop(int[] array, int target, int begin, int end) {
        int medium = 0;
        while (begin < end) {
            medium = begin + (end - begin) / 2;
            if (array[medium] > target && medium != begin) {
                end = medium - 1;
            } else if (array[medium] < target) {
                begin = medium + 1;
            } else break;
        }

        medium = begin + (end - begin) / 2; //повторный расчёт, так как ответ определяется по medium, и когда
        //происходит последний условный переход, условие в цикле нарушается,
        //и в переменной medium остаётся старое значение
        if (array[medium] == target) return medium;
        else return -1;
    }
}
