package tests;

public class TestMain {
    public static void main(String[] args) {
        int x = 20, y = 30;
        System.out.println(sum(x, y));
        double arg1 = 20.4, arg2 = 4.5;
        System.out.println(getMaxValueOfTwo(arg1, arg2));
        prettyPrint("Hello", 2);

        int[] array = new int[10];
        int[] arr = {1, 5, 7, 4, 86, 7};
        for (int i = 0; i < array.length; i++) {
            array[i] = 10 * i + 2;
        }
        System.out.println(getEvenCount(arr));

    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static double getMaxValueOfTwo(double first, double second) {
        if (first > second) {
            return first;
        } else {
            return second;
        }
    }

    public static void prettyPrint(String s, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("****" + s + "****");
        }
    }

    public static int getEvenCount(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                k++;
            }
        }
        return k;
    }

}



