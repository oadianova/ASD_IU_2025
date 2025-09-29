package groupA;

import java.util.Scanner;

//4. Дано целое число. Реализуйте метод, который находит N первых простых
//чисел. Используйте алгоритм «Решето Эратосфена».

public class SieveOfEratosthenes {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scn.nextInt();
        int[] primes = primeNumbers(length);
        printArray(primes);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(arr[arr.length - 1] + "\n");
    }

    public static int[] primeNumbers(int n) {
        int[] arr = new int[n];
        int lastNumber;
        if (n <= 20) {
            lastNumber = n * 5;
        } else {
            lastNumber = (int) Math.round(n * (Math.log(n) + Math.log(Math.log(n)) - 0.5));
        }
        int[] sieve = sieveFor(lastNumber);
        int numbersQuantity = 0;
        for (int i = 2; i < sieve.length & numbersQuantity < n; i++) {
            if (sieve[i] == 0) {
                arr[numbersQuantity] = i;
                numbersQuantity++;
            }
        }
        return arr;
    }

    public static int[] sieveFor(int n) {
        int[] sieve = new int[n];
        sieve[0] = 1;
        sieve[1] = 1;
        for (int i = 2; i * i < n; i++) {
            if (sieve[i] == 0) {
                for (int j = i * i; j < n; j += i) {
                    sieve[j] = 1;
                }
            }
        }
        return sieve; //0 for prime number
    }
}
