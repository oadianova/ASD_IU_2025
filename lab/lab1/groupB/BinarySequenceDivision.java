package groupB;

//4. Дан массив целых чисел, представляющий двоичное число.
//Пример, дан массив bi_arr = [1, 1, 0]. Этот массив в десятичной системе
//выглядит так: arr = [1, 3, 6]. То есть:
//• arr[0] = bi_arr[0] = 1! = 1"#,
//• arr[1] = bi_arr[0] bi_arr[1] =11! = 3"#,
//• arr[2] = bi_arr[0] bi_arr[1] bi_arr[2] =110! = 6"#
//10
//Так же дано целое положительное число – n. Вернуть массив Boolean, где
//true – число делится на N, false – нет.
//Пусть n = 6, тогда для предыдущего примера результат должен выглядеть
//так: [false, false, true].
//Примечание. Делитель тоже необходимо ввести с клавиатуры

import java.util.Scanner;

public class BinarySequenceDivision {

    public static Scanner scn = new Scanner(System.in);

    public static void inputArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[arr.length - 1] + "\n");
    }

    public static void printArray(boolean[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[arr.length - 1] + "\n");
    }

    public static int binarySequenceToDecimalNumber(int[] sequence, int start, int end) throws IllegalArgumentException {
        int result = 0;
        if (end >= sequence.length) {
            end = sequence.length - 1;
        }
        if (start < 0) {
            start = 0;
        }
        result += sequence[end];
        int power = 2;
        for (int i = end - 1; i >= start; i--) {
            if (sequence[i] != 0 && sequence[i] != 1) throw new IllegalArgumentException("Sequence is not binary");
            result += sequence[i] * power;
            power *= 2;
        }
        return result;
    }

    public static boolean[] checkBinarySequenceDivision(int[] sequence, int divisor) throws IllegalArgumentException {
        int length = sequence.length;
        boolean[] result = new boolean[length];
        int[] decimalSequence = new int[length];
        for (int i = 0; i < length; i++) {
            decimalSequence[i] = binarySequenceToDecimalNumber(sequence, 0, i);
            result[i] = (decimalSequence[i] % divisor == 0);
        }
        printArray(decimalSequence);
        return result;
    }


    public static void main(String[] args) {
        int length = scn.nextInt();
        int[] binarySequence = new int[length];
        inputArray(binarySequence);
        int divisor = scn.nextInt();
        printArray(checkBinarySequenceDivision(binarySequence, divisor));
    }
}
