import java.util.Scanner;

/*
 * Дан целочисленный массив. Верните число, частота встречи которого в
 * массиве равна его значению. Если таких чисел нет, вернуть «-1».
 * Если таких чисел несколько, вернуть наибольшее.
 */

class B1 {
	public static void main(String[] args) {
		int[] array;
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Введите массив чисел");
			array = ArrayUtils.scanIntArray(input);
		}
		System.out.printf("Ответ: %d\n", task(array));
	}
	private static int task(int[] input) {
		ArrayUtils.shellSort(input);
		int mostNumber = -1;
		int currentOccurences = 1;
		for (int i = 1; i < input.length; i++) {
			if (input[i - 1] == input[i]) {
				currentOccurences++;
			} else if (input[i - 1] == currentOccurences) {
				mostNumber = currentOccurences;
				currentOccurences = 1;
			} else {
				currentOccurences = 1;
			}
		}
		if (input[input.length - 1] == currentOccurences) {
			mostNumber = currentOccurences;
		}
		return mostNumber;
	}
}

