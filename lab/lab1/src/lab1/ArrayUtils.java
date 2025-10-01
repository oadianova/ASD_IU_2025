package lab1;

import java.util.Scanner;

public class ArrayUtils {

    private static Scanner scanner = new Scanner(System.in);

    
    public static int inputArraySize() {
        System.out.println("Введите количество чисел в массиве");
        int size = scanner.nextInt();
        return size;
    }


    public static int[] inputArray(int[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите элементы массива");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void outputArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println(" ");
    }

   public static void selectionSort(int[] array){
        int minIndex, temp;
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
     }
   }

