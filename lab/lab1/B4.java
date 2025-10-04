import java.util.Scanner;

/*
 * Дан массив целых чисел, представляющий двоичное число.
 * Пример, дан массив bi_arr = [1, 1, 0]. Этот массив в десятичной системе
 * выглядит так: arr = [1, 3, 6]. То есть:
 * - 1 в двоичной системе счисления = 1 в десятичной
 * - 11 в двоичной системе счисления = 3 в десятичной
 * - 110 в двоичной системе счисления = 6 в десятичной
 * Так же дано целое положительное число – n.
 * Вернуть массив Boolean, где true – число делится на N, false – нет.
 * Пусть n = 6, тогда для предыдущего примера результат должен выглядеть так: [false, false, true]
 */

class B4 {
	public static void main(String[] args) {
		int[] bitArray;
		int divisor;
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Введите массив из 0 и 1");
			bitArray = ArrayUtils.scanIntArray(input);
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
	private static boolean[] task(int[] bitArray, int divisor) {
		int accumilator = 0;
		boolean[] resultArray = new boolean[bitArray.length];
		for (int i = 0; i < bitArray.length; i++) {
			accumilator = accumilator * 2 + bitArray[i];
			resultArray[i] = accumilator % divisor == 0;
		}
		return resultArray;
	}
}
