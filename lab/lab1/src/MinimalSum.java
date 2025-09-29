/* Группа Б. Задание 3
* Дан массив целых чисел. Минимальное количество элементов – 5 Вернуть
число, которое является суммой двух наименьших положительных чисел. */


public class MinimalSum {
    public static void main(String[] args){
        int size = Array.arraySize();
        if (size >= 5){
            int[] array = new int[size];
            Array.inputArray(array);
            Array.selectionSort(array);
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
