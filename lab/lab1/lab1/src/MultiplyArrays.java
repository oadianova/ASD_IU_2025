//2 Пусть любое число – это массив его цифр слева направо. Пример, число
//1234 – это массив [1,2,3,4].
//Дан массив целых чисел. Реализовать умножение двух чисел.
//Пример, [1, 2, 3, 4] * [1, 1] = [1, 3, 5, 7, 4].
//Результат – число, представленное массивом.

public class MultiplyArrays {
    public static void main(String[] args){
        int[] a = ArrayMethods.newArray();
        int[] b = ArrayMethods.newArray();
        ArrayMethods.printArray(multiplying(a,b));
    }

    private static int[] multiplying(int[] first, int[] second){
        return (numberToArray(arrayToNumber(first)*arrayToNumber(second)));
    }

    private static int arrayToNumber(int[] array){
        int number = 0;
        for(int i = 0; i < array.length; i++){
            number += array[i] * (int)Math.pow(10, array.length - 1 -i);
        }
        return number;
    }

    private static int[] numberToArray(int number){
        int length = String.valueOf(number).length();
        int[] array = new int[length];
        for(int i = length - 1; i >= 0; i--){
            array[i] = number % 10;
            number /= 10;
        }
        return array;
    }
}
