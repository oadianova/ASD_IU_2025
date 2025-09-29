package groupa;

import java.util.Scanner;

public class Eratosphen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество простых чисел:");
        int n = scanner.nextInt();

        int[] primes = findFirstNPrimes(n);

        System.out.println("Первые " + n + " простых чисел:");
        for (int i = 0; i < primes.length; i++) {
            System.out.print(primes[i] + " ");
        }
        System.out.println();

        scanner.close();
    }

    public static int[] findFirstNPrimes(int n) {
        if (n <= 0) {
            return new int[0];
        }

        if (n == 1) {
            return new int[]{2};
        }

        int maxSize = n * 20;
        boolean[] isPrime = new boolean[maxSize + 1];

        for (int i = 2; i <= maxSize; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= maxSize; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= maxSize; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int[] primes = new int[n];
        int count = 0;
        int number = 2;

        while (count < n && number <= maxSize) {
            if (isPrime[number]) {
                primes[count] = number;
                count++;
            }
            number++;
        }

        return primes;
    }
}