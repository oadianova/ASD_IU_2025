package solutions;

import java.util.Scanner;

//Задание Б4
//Дан массив целых чисел, представляющий двоичное число.
//Пример, дан массив bi_arr = [1, 1, 0]. Этот массив в десятичной системе
//выглядит так: arr = [1, 3, 6]. То есть:
//• arr[0] = bi_arr[0] = 1 = 1 ,
//• arr[1] = bi_arr[0] bi_arr[1] =11 = 3 ,
//• arr[2] = bi_arr[0] bi_arr[1] bi_arr[2] =110 = 6
//Так же дано целое положительное число – n. Вернуть массив Boolean, где
//true – число делится на N, false – нет.
//Пусть n = 6, тогда для предыдущего примера результат должен выглядеть
//так: [false, false, true].
//Примечание. Делитель тоже необходимо ввести с клавиатуры.

public class TaskB4 {
    private final Scanner scanner;

    public TaskB4(Scanner externalScanner) {
        scanner = externalScanner;
    }

    private int getLengthFromConsole() {
        int length;
        while (true) {
            System.out.print("Введите количество элементов массива: ");
            length = scanner.nextInt();
            if (length < 0) {
                System.out.println("Некорректное значение для длины массива. Попробуйте снова.");
            } else break;
        }
        scanner.nextLine();
        return length;
    }

    private int[] getNumberArrayFromConsole(int capacity) {
        int[] inputArray = new int[capacity];
        System.out.println("Заполните массив числами 1 или 0");
        for (int i = 0; i < capacity; i++) {
            inputArray[i] = scanner.nextInt();
        }
        scanner.nextLine();
        return inputArray;
    }

    private int power(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        int result = base;
        for (int i = 1; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    private int[] transformToDecimal(int[] binaryArray) {
        int[] decimalArray = new int[binaryArray.length];
        for (int i = 0; i < decimalArray.length; i++) {
            for (int j = 0; j < i + 1; j++) {
                decimalArray[i] += power(2, i - j) * binaryArray[j];
            }
        }
        return decimalArray;
    }

    private boolean[] findMultiples(int[] decimalArray, int divider) {
        boolean[] result = new boolean[decimalArray.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = decimalArray[i] % divider == 0;
        }
        return result;
    }

    private void printBooleanArray(boolean[] booleans) {
        System.out.print("[");
        for (int i = 0; i < booleans.length - 1; i++) {
            if (booleans[i]) {
                System.out.print("true");
            } else {
                System.out.print("false");
            }
            System.out.print(", ");
        }
        if (booleans[booleans.length - 1]) {
            System.out.println("true]");
        } else {
            System.out.println("false]");
        }
    }

    public void start() {
        System.out.println("\n========Задание Б4========\n");
        int capacity = getLengthFromConsole();
        int[] binaryArray = getNumberArrayFromConsole(capacity);

        System.out.println("Введите число, которое будет использоваться как делитель:");
        int divider = scanner.nextInt();

        int[] decimalArray = transformToDecimal(binaryArray);

        boolean[] isMultipleOfDividerArray = findMultiples(decimalArray, divider);

        System.out.println("Результат работы:");
        printBooleanArray(isMultipleOfDividerArray);
    }
}
