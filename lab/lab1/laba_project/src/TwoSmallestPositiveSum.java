import java.util.Scanner;

public class TwoSmallestPositiveSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива (минимум 5): ");
        int size = scanner.nextInt();

        if (size < 5) {
            System.out.println("Размер массива должен быть не менее 5");
            return;
        }

        int[] array = new int[size];
        fillArray(array, scanner);

        int result = sumOfTwoSmallestPositive(array);
        System.out.println("Сумма двух наименьших положительных чисел: " + result);
    }

    private static void fillArray(int[] array, Scanner scanner) {
        System.out.println("Введите " + array.length + " целых чисел:");
        for (int i = 0; i < array.length; i++) {
            System.out.print("Введите число #" + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
    }

    private static int sumOfTwoSmallestPositive(int[] array) {
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : array) {
            if (num > 0) {
                if (num < firstMin) {
                    secondMin = firstMin;
                    firstMin = num;
                } else if (num < secondMin) {
                    secondMin = num;
                }
            }
        }

        if (firstMin == Integer.MAX_VALUE || secondMin == Integer.MAX_VALUE) {
            return -1;
        }

        return firstMin + secondMin;
    }
}
