package solutions;

import java.util.Scanner;

//Задание А1
//Реализуйте метод, входными данными которого являются два числа N и M,
//где N – число в десятичной системе исчисления, а M – число в диапазоне от
//2 до 9, основание системы исчисления, в которое надо перевести исходное
//число. Метод должен возвращать строку с преобразованным значением.
public class TaskA1 {

    public TaskA1(Scanner externalScanner) {
        scanner = externalScanner;
    }

    public void start() {
        System.out.println("\n========Задание А1========\n");

        System.out.print("Целое десятичное число: ");
        int m = scanner.nextInt();

        System.out.print("Основание: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Результат: " + convertDecimalToM(m, n));
    }

    private final Scanner scanner;

    private String convertDecimalToM(int decimal, int base) {
        String result = "";
        int modulo = 0;
        while (decimal > 0) {
            modulo = decimal % base;
            result = Integer.toString(modulo) + result;
            decimal /= base;
        }
        return result;
    }
}
