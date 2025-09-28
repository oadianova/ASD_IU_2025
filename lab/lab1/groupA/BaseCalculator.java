package groupA;

//Группа А. Алгоритмические задачи. Задача оценивается в 1 балл.
//1. Реализуйте метод, входными данными которого являются два числа N и M,
//где N – число в десятичной системе исчисления, а M – число в диапазоне от
//2 до 9, основание системы исчисления, в которое надо перевести исходное
//число. Метод должен возвращать строку с преобразованным значением.

import java.util.Scanner;

public class BaseCalculator {

    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scn.nextInt(), m = scn.nextInt();
        String ans = "";
        try {
            ans = toBase(n, m);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(ans);
    }

    public static String toBase(int number, int base) throws IllegalArgumentException {
        if (base < 2 || base > 9) throw new IllegalArgumentException("Incorrect base: base must be between 2 and 9");
        if (number < 0) throw new IllegalArgumentException("Number must be positive");
        StringBuilder result = new StringBuilder();
        while (number > 0) {
            result.insert(0, number % base);
            number /= base;
        }
        return result.toString();
    }
}
