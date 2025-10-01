/* Группа Б. Задание 3
* Дан массив целых чисел. Минимальное количество элементов – 5 Вернуть
число, которое является суммой двух наименьших положительных чисел. */

package lab1;

public class MinimalSum {
    public static void main(String[] args){
        int size = ArrayUtils.inputArraySize();
        if (size >= 5){
            int[] array = new int[size];
            ArrayUtils.inputArray(array);
            ArrayUtils.selectionSort(array);
            System.out.println(sumOfTwoNumbers(array));
        }

    }

    private static int sumOfTwoNumbers(int[] array){
        int counter = 0;
        int  sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0 && counter < 2) {
                sum += array[i];
                counter += 1;
            }
            if (counter == 2){
                return sum;
            }
        }
        return 0;
    }
}
