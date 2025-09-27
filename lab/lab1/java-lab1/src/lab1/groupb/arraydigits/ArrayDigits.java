/*
2.  Пусть любое число – это массив его цифр слева направо.
Пример, число 1234 – это массив [1,2,3,4].
Дан массив целых чисел. Реализовать умножение двух чисел.
Пример, [1, 2, 3, 4] * [1, 1] = [1, 3, 5, 7, 4].
Результат – число, представленное массивом.
*/
package lab1.groupb.arraydigits;

import lab1.maintask.MainTask;

public class ArrayDigits {
    public static void main() {
        int firstInt = -1, secondInt = -1;
        while (firstInt < 0) {
            System.out.print("Input first number: ");
            firstInt = MainTask.getInt();
        }
        while (secondInt < 0) {
            System.out.print("Input second number: ");
            secondInt = MainTask.getInt();
        }

        byte[] firstNumber = new byte[10], secondNumber = new byte[10];
        if (!intToArrayDigits(firstNumber, firstInt)) {
            System.out.println("Error convert first number");
            return;
        }
        if (!intToArrayDigits(secondNumber, secondInt)) {
            System.out.println("Error convert second number");
            return;
        }

        byte[] answerNumber = new byte[10];
        if (!multiplicationByteArray(firstNumber, secondNumber, answerNumber)) {
            System.out.println(("Error Multiplication Byte Array"));
            return;
        }

        byte[] cleanFirstNumber = new byte[cleanLenByteArray(firstNumber)];
        byte[] cleanSecondNumber = new byte[cleanLenByteArray(secondNumber)];
        byte[] cleanAnswerNumber = new byte[cleanLenByteArray(answerNumber)];
        cleanByteArray(firstNumber, cleanFirstNumber);
        cleanByteArray(secondNumber, cleanSecondNumber);
        cleanByteArray(answerNumber, cleanAnswerNumber);

        printByteArrayFormat(cleanFirstNumber);
        System.out.print(" * ");
        printByteArrayFormat(cleanSecondNumber);
        System.out.print(" = ");
        printByteArrayFormat(cleanAnswerNumber);
        System.out.println();

    }

    public static boolean intToArrayDigits(byte[] array, int number) {
        if (number < 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            array[array.length - 1 - i] = (byte) (number % 10);
            number /= 10;
        }
        return number==0;
    }

    public static boolean multiplicationByteArray(byte[] firstNumber, byte[] secondNumber, byte[] answerNumber) {
        for (int i = 0; i < answerNumber.length; i++) {
            answerNumber[i] = 0;
        }
        for (int i = secondNumber.length - 1; i >= 0; i--) {
            if (secondNumber[i] == 0) {
                continue;
            }
            for (int j = firstNumber.length - 1; j >= 0; j--) {
                if (firstNumber[j] == 0) {
                    continue;
                }
                int index = answerNumber.length + (i - secondNumber.length) + (j - firstNumber.length) + 1;
                if (index <= 0) {
                    System.out.println("Error: len array for answer is to low");
                    return false;
                }
                answerNumber[index] += (byte) (firstNumber[j] * secondNumber[i]);
                answerNumber[index - 1] += (byte) (answerNumber[index] / 10);
                answerNumber[index] = (byte) (answerNumber[index] % 10);

            }
        }
        return true;
    }

    public static void printByteArray(byte[] array) {
        for (byte element : array) {
            System.out.print((int) element + " ");
        }
        System.out.println();
    }
    public static void printByteArrayFormat(byte[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print((int) array[i]);
            if (i != array.length-1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static int cleanLenByteArray(byte[] array) {
        int count = 0;
        for (byte elem : array) {
            if (elem == 0) {
                count++;
            } else {
                break;
            }
        }
        return array.length - count;
    }

    public static void cleanByteArray(byte[] arrayToClean, byte[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = arrayToClean.length - 1 - i;
            if (j < 0) {
                System.out.println("Error: length arrayToClean");
                return;
            }
            array[array.length - i - 1] = arrayToClean[j];
        }
    }
}
