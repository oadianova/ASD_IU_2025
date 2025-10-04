package solutions;

import java.util.Scanner;

//Задание А3
//Изограмма – это слово, в котором нет повторяющихся букв,
//последовательных или непоследовательных. Реализуйте функцию, которая
//определяет, является ли строка, изограммой. Пустая строка является
//изограммой.
public class TaskA3 {
    public TaskA3(Scanner externalScanner) {
        scanner = externalScanner;
    }

    public void start() {
        System.out.println("\n========Задание А3========\n");

        System.out.println("Введите строку: ");
        String inputString = scanner.nextLine();

        if (isIsogram(inputString)) {
            System.out.println(" = Введённая строка - изограмма");
        } else {
            System.out.println(" = Введённая строка не является изограммой");
        }
    }

    private final Scanner scanner;

    private boolean isIsogram(String word) {
        int index = 0;
        for (int i = 0; i < word.length() - 1; i++) {
            index = word.indexOf(word.charAt(i), i + 1);
            if (index != -1) return false;
        }
        return true;
    }
}
