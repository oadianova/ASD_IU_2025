import java.util.Scanner;


class B1 {
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
	public static void main(String[] args) {
		int[] array;
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Введите массив чисел");
			array = ArrayUtils.scanIntArray(input);
		}
		System.out.printf("Ответ: %d\n", task(array));
	}
}

