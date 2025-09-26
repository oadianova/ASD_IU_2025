//1 Дан целочисленный массив. Верните число, частота встречи которого в
//массиве равна его значению. Если таких чисел нет, вернуть «-1». Если
//таких чисел несколько, вернуть наибольшее.

public class CountingElement {

    public static void main(String[] args){
        int answer = -1;

        int[] array = ArrayMethods.newArray();
        ArrayMethods.printArray(array);

        for(int i : array){
            if ((i == counter(i,array))&&(i>answer)){
                answer=i;
            }
        }
        System.out.print("Ответ: " + answer);
    }

    private static int counter(int element, int [] array){
        int count = 0;
        for (int j : array) {
            if (j == element) {
                count++;
            }
        }
        return count;
    }
}
