import java.util.Scanner;

class B3 {
	private static int task(int[] array) {
		ArrayUtils.shellSort(array);
		int skipIndex = 0;
		for (; skipIndex < array.length; skipIndex++) {
			if (array[skipIndex] > 0) {
				break;
			}
		}
		if (skipIndex >= array.length - 1) {
			return -1;
		}
		return array[skipIndex] + array[skipIndex + 1];
	}
	public static void main(String[] args) {
		int[] array;
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Введите массив из 5 или более целых чисел");
			array = ArrayUtils.scanIntArray(input);
		} 
		int result = task(array);
		if (result < 0) {
			System.out.println("Ошибка, нет двух положительных чисел!");
		} else {
			System.out.printf("Ответ: %d\n", result);
		}
	}
}
