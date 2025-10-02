import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		int[] array;
		int number, index;
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Введите отсортированный массив");
			array = ArrayUtils.nextArray(input);
			System.out.print("Число: ");
			number = input.nextInt();
		}
		index = ArrayUtils.indexOf(array, number);
		if (index == -1) {
			System.out.println("Число не найдено");
		} else {
			System.out.printf("Номер числа в массиве: %d\n", index + 1);
		}
	}
}
