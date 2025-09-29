import java.util.Scanner;

//Основное задание. Задание оценивается в 0 баллов, но является обязательным.
//Реализовать алгоритм бинарного поиска двумя способами.

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int arrayLength = scn.nextInt();
        int[] arr = new int[arrayLength];
        inputArray(arr);
        selectionSort(arr);
        printArray(arr);
        int elementToFind = scn.nextInt();
        int ans = binarySearchIterative(arr, elementToFind, 0, arrayLength - 1);
        System.out.println(ans);
        ans = binarySearchRecursive(arr, elementToFind, 0, arrayLength - 1);
        System.out.println(ans);
    }

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

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            swap(arr, i, min);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int binarySearchIterative(int[] arr, int key, int left, int right) {
        try {
            if (arr[right] == key) return right;
            if (arr[left] == key) return left;
            if (left >= right) return -1;
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Index out of range");
            return -1;
        }

        int mid = (left + right) / 2;
        while (left <= right) {
            if (arr[mid] == key) return mid;
            if (arr[mid] > key) right = mid - 1;
            else left = mid + 1;
            mid = (left + right) / 2;
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int key, int left, int right) {
        try {
            if (arr[right] == key) return right;
            if (arr[left] == key) return left;
            if (left >= right) return -1;
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Index out of range");
            return -1;
        }

        int mid = (left + right) / 2;
        if (arr[mid] > key) return binarySearchRecursive(arr, key, left, mid - 1);
        else if (arr[mid] < key) return binarySearchRecursive(arr, key, mid + 1, right);
        return mid;
    }
}
