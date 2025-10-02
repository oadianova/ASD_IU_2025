import java.util.Scanner;

public class BinaryPrefixDivisibility {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер двоичного массива: ");
        int size = scanner.nextInt();
        int[] binaryArray = new int[size];
        fillBinaryArray(binaryArray, size, scanner);

        System.out.print("Введите делитель n: ");
        int divisor = scanner.nextInt();

        boolean[] result = checkBinaryPrefixDivisibility(binaryArray, divisor);

        printBooleanArray(result, "Результат проверки делимости");
    }

    private static void fillBinaryArray(int[] array, int arraySize, Scanner scanner) {
        System.out.println("Введите " + arraySize + " двоичных цифр (0 или 1):");
        for (int i = 0; i < arraySize; i++) {
            System.out.print("Введите цифру #" + (i + 1) + ": ");
            int currentValue = scanner.nextInt();
            if (currentValue != 0 && currentValue != 1) {
                System.out.println("Цифра должна быть 0 или 1, попробуйте еще раз");
                i--;
                continue;
            }
            array[i] = currentValue;
        }
    }

    private static void printBooleanArray(boolean[] array, String message) {
        System.out.print(message + ": [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }


    private static boolean[] checkBinaryPrefixDivisibility(int[] binaryArray, int divisor) {
        boolean[] result = new boolean[binaryArray.length];
        int currentDecimal = 0;

        for (int i = 0; i < binaryArray.length; i++) {
            currentDecimal = (currentDecimal * 2 + binaryArray[i]);
            result[i] = (currentDecimal % divisor == 0);
        }

        return result;
    }
}
