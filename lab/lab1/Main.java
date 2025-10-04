import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		int[] array;
		int number;
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Введите отсортированный массив");
			array = ArrayUtils.nextArray(input);
			System.out.print("Число: ");
			number = input.nextInt();
		}
		System.out.println("Рекурсивная реализация: ");
		printArrayIndexFormatted(ArrayUtils.recursiveImplementationOfBinarySearch(array, number));
		System.out.println("Реализация циклом: ");
		printArrayIndexFormatted(ArrayUtils.iterativeImplementationOfBinarySearch(array, number));
	}
	private static void printArrayIndexFormatted(int index) {
		if (index == -1) {
			System.out.println("Число не найдено");
		} else {
			System.out.printf("Номер числа в массиве: %d\n", index + 1);
		}
	}
}
