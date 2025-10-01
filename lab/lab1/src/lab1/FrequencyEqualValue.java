/* Группа Б Задача 1
* Дан целочисленный массив. Верните число, частота встречи которого в
массиве равна его значению. Если таких чисел нет, вернуть «-1». Если
таких чисел несколько, вернуть наибольшее. */

package lab1;

public class FrequencyEqualValue {

    public static void main(String[] args){
        int size = ArrayUtils.inputArraySize();
        int[] array = new int[size];
        ArrayUtils.inputArray(array);
        ArrayUtils.selectionSort(array);
        System.out.println(maxNumber(array));

    }

    private static int maxNumber(int[] array){
        int maxValue = -1;
        for (int i = 0; i < array.length; i++) {
            if (equalValues(array, array[i]) &&  array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }


    private static boolean equalValues(int[] array, int number){
        int amount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number){
                amount += 1;
            }
        }
        return (amount == number);
    }
}
