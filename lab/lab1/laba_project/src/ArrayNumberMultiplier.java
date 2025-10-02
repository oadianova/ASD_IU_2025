import java.util.Scanner;

public class ArrayNumberMultiplier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество цифр первого числа: ");
        int size1 = scanner.nextInt();
        int[] number1 = new int[size1];
        fillDigitsArray(number1, size1, scanner);

        System.out.print("Введите количество цифр второго числа: ");
        int size2 = scanner.nextInt();
        int[] number2 = new int[size2];
        fillDigitsArray(number2, size2, scanner);

        int[] result = multiplyArrayNumbers(number1, number2);

        printArray(result);
    }


    private static void fillDigitsArray(int[] array, int arraySize, Scanner scanner) {
        System.out.println("Введите " + arraySize + " цифр (от 0 до 9):");
        for (int i = 0; i < arraySize; i++) {
            System.out.print("Введите цифру #" + (i + 1) + ": ");
            int currentValue = scanner.nextInt();
            if (currentValue < 0 || currentValue > 9) {
                System.out.println("Цифра должна быть от 0 до 9, попробуйте еще раз");
                i--;
                continue;
            }
            array[i] = currentValue;
        }
    }

    private static void printArray(int[] array) {
        System.out.print("Результат умножения" + ": [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private static int[] multiplyArrayNumbers(int[] num1, int[] num2) {
        int len1 = num1.length;
        int len2 = num2.length;

        int[] result = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = len2 - 1; j >= 0; j--) {
                int product = num1[i] * num2[j] + result[i + j + 1] + carry;
                result[i + j + 1] = product % 10;
                carry = product / 10;
            }
            result[i] += carry;
        }

        return removeLeadingZeros(result);
    }

    private static int[] removeLeadingZeros(int[] number) {
        int firstNonZero = 0;
        while (firstNonZero < number.length && number[firstNonZero] == 0) {
            firstNonZero++;
        }

        if (firstNonZero == number.length) {
            return new int[]{0};
        }

        int[] result = new int[number.length - firstNonZero];
        for (int i = 0; i < result.length; i++) {
            result[i] = number[firstNonZero + i];
        }

        return result;
    }
}
