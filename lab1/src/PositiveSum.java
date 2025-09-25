//3 Дан массив целых чисел. Минимальное количество элементов – 5 Вернуть
//число, которое является суммой двух наименьших положительных чисел.

import java.util.Scanner;

public class PositiveSum {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[]args){
        System.out.print("Введите количество элементов: ");
        int length = scanner.nextInt();
        if (length<5){
            System.out.println("Требуется 5 элементов или больше!");
            main(args);
        }
        int[] array = ArrayMethods.newArray(length);

        if(sum(array) == -1){
            System.out.print("Не нашлось двух положительных чисел");
        } else {
            System.out.print("Сумма: " + sum(array));
        }
    }

    private static int sum(int[] array){
        int first = 0;
        int second = 0;

        for(int i:array){
            if(i > first){
                second = first;
                first = i;
            }else if(i > second){
                second = i;
            }
        }
        if (second == 0){
            return -1;
        }
        return (first+second);
    }
}
