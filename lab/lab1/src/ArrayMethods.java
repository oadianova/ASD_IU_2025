import java.util.Scanner;

public class ArrayMethods {
    private static final Scanner scanner = new Scanner(System.in);

    public static int[] newArray(){
        System.out.print("Введите количество элементов массива:");
        int length = scanner.nextInt();

        if (length<=0){
            System.out.println("Некорректное количество элементов!");
            return newArray();
        }
        int[] array = new int[length];
        System.out.println("Введите " + length + " элементов (целых чисел):");

        for (int i =0; i < length; i++){
            System.out.print("Введите " + (i + 1) + "-й элемент:");
            array[i] = scanner.nextInt();
        }

        return array;
    }

    public static int[] newArray(int length){
        int[] array = new int[length];
        System.out.println("Введите " + length + " элементов (целых чисел):");

        for (int i =0; i < length; i++){
            System.out.print("Введите " + (i + 1) + "-й элемент:");
            array[i] = scanner.nextInt();
        }

        return array;
    }

    public static void printArray(int[] array){
        System.out.print("Ваш массив: ");

        for (int i =0; i < array.length; i++) {
            if (i + 1 < array.length) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.println(array[i] + ".");
            }
        }
    }
}
