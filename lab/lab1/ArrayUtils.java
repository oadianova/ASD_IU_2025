import java.util.Scanner;

class ArrayUtils {
	public static int[] scanIntArray(Scanner input) {
		System.out.println("Длинна массива: ");
		int[] array = new int[input.nextInt()];
		System.out.println("Массив: ");
		for (int i = 0; i < array.length; i++) {
			array[i] = input.nextInt();
		}
		return array;
	}
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.printf("%d ", array[i]);
		}
		System.out.println();
	}
	public static int recursiveImplementationOfBinarySearch(int[] array, int element) {
		return recursiveImplementationOfBinarySearch(array, element, 0, array.length);
	}
	public static int iterativeImplementationOfBinarySearch(int[] array, int element) {
		int i = 0, j = array.length;
		while (i < j) {
			int middle = (i + j) / 2;
			if (array[middle] < element) {
				i = middle + 1;
			} else if (array[middle] == element){
				return middle;
			} else {
				j = middle;
			}
		}
		return -1;
	}
	public static void shellSort(int[] array) {
		int gap = array.length / 2;
		while (gap > 1) {
			shellRound(array, gap);
			gap = gap / 2;
		}
		shellRound(array, 1);
	}
	private static int recursiveImplementationOfBinarySearch(int[] array, int element, int i, int j) {
		if (i >= j) {
			return -1;
		}
		int middle = (i + j) / 2;
		if (array[middle] < element) {
			return recursiveImplementationOfBinarySearch(array, element, middle + 1, j);
		} else if (array[middle] == element) {
			return middle;
		} else {
			return recursiveImplementationOfBinarySearch(array, element, i, middle);
		}
	}
	private static void shellRound(int[] array, int gap) {
		for (int i = gap; i < array.length; i++) {
			int key = array[i];
			int j = i;
			while (j - gap >= 0 && array[j - gap] > key) {
				array[j] = array[j - gap];
				j -= gap;
			}
			array[j] = key;
		}
	}
}
