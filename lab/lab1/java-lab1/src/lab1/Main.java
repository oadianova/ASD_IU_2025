package lab1;

import lab1.maintask.MainTask;
import lab1.groupb.frequency.Frequency;
import lab1.groupb.arraydigits.ArrayDigits;
import lab1.groupb.sumpositive.SumPositive;


public class Main {
    public static void main(String[] args){
        System.out.println("Chose running task:");
        System.out.println("[0] Main Task");
        System.out.println("[1] Group B - Frequency numbers");
        System.out.println("[2] Group B - Multiplication Array digits");
        System.out.println("[3] Group B - Sum two min positive");
        int chose = MainTask.getInt();
        switch (chose){
            case 0:
                MainTask.main();
                break;
            case 1:
                Frequency.main();
                break;
            case 2:
                ArrayDigits.main();
                break;
            case 3:
                SumPositive.main();
                break;
        }
    }
}
