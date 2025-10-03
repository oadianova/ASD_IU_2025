/* Группа Б. Задание 2П
Пусть любое число – это массив его цифр слева направо. Пример, число
1234 – это массив [1,2,3,4].
Дан массив целых чисел. Реализовать умножение двух чисел.
Пример, [1, 2, 3, 4] * [1, 1] = [1, 3, 5, 7, 4].
Результат – число, представленное массивом.*/

package lab1;

import java.lang.Math;


public class Multiplication {

    public static void main (String[] args) {
        int size1 = ArrayUtils.inputArraySize();
        int[] array1 = new int[size1];
        ArrayUtils.inputArray(array1);
        System.out.println(convertToNumber(array1));

        int size2 = ArrayUtils.inputArraySize();
        int[] array2 = new int[size2];
        ArrayUtils.inputArray(array2);
        System.out.println(convertToNumber(array2));

        long firstMultiplier = convertToNumber(array1);
        long secondMultiplier = convertToNumber(array2);
        long resultInteger = firstMultiplier * secondMultiplier;
        int[] result =  convertToArray(resultInteger);
        ArrayUtils.outputArray(result);
    }


    private static long convertToNumber(int[] array){
        long value = 0;
        for (int i = 0; i < array.length; i++){
            value +=  array[i] * Math.pow(10, array.length - 1 - i);
        }
        return value;
    }


    private static int[] convertToArray(long value) {
        char[] charResult = Long.toString(value).toCharArray();
        int[] result = new int[charResult.length];
        for (int i = 0; i < charResult.length; i++){
            result[i] = charResult[i] - '0';
        }

        return result;
    }


}
