import java.util.Scanner;

class B4 {
	private static boolean[] task(int[] bitArray, int divisor) {
		int accumilator = 0;
		boolean[] resultArray = new boolean[bitArray.length];
		for (int i = 0; i < bitArray.length; i++) {
			accumilator = accumilator * 2 + bitArray[i];
			resultArray[i] = accumilator % divisor == 0;
		}
		return resultArray;
	}
	public static void main(String[] args) {
		int[] bitArray;
		int divisor;
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Введите массив из 0 и 1");
			bitArray = ArrayUtils.nextArray(input);
			System.out.print("Введите не нулевое число: ");
			divisor = input.nextInt();
		}
		boolean[] booleanArray = task(bitArray, divisor);
		System.out.println("Результат:");
		for (int i = 0; i < booleanArray.length; i++) {
			if (booleanArray[i]) {
				System.out.print("true ");
			} else {
				System.out.print("false ");
			}
		}
		System.out.println();
	}
}
