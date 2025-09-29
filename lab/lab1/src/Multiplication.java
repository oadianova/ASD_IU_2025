/* Группа Б. Задание 2П
Пусть любое число – это массив его цифр слева направо. Пример, число
1234 – это массив [1,2,3,4].
Дан массив целых чисел. Реализовать умножение двух чисел.
Пример, [1, 2, 3, 4] * [1, 1] = [1, 3, 5, 7, 4].
Результат – число, представленное массивом.*/


import java.lang.Math;


public class Multiplication {

    public static void main (String[] args) {
        int size1 = Array.arraySize();
        int[] array1 = new int[size1];
        Array.inputArray(array1);
        System.out.println(convertToNumber(array1));

        int size2 = Array.arraySize();
        int[] array2 = new int[size2];
        Array.inputArray(array2);
        System.out.println(convertToNumber(array2));

        int firstMultiplier = convertToNumber(array1);
        int secondMultiplier = convertToNumber(array2);
        int resultInteger = firstMultiplier * secondMultiplier;
        int[] result =  convertToArray(resultInteger);
        Array.outputArray(result);
    }


    private static int convertToNumber(int[] array){
        int value = 0;
        for (int i = 0; i < array.length; i++){
            value +=  array[i] * Math.pow(10, array.length - 1 - i);
        }
        return value;
    }


    private static int[] convertToArray(int value) {
        char[] charResult = Integer.toString(value).toCharArray();
        int[] result = new int[charResult.length];
        for (int i = 0; i < charResult.length; i++){
            result[i] = charResult[i] - '0';
        }

        return result;
    }


}
