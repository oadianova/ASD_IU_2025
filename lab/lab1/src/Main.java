import java.util.Scanner;

import solutions.*;

public class Main
{
    public void main()
    {
        Scanner scanner = new Scanner(System.in);

        Task0 task0 = new Task0(scanner);
        TaskA1 taskA1 = new TaskA1(scanner);
        TaskA2 taskA2 = new TaskA2(scanner);
        TaskA3 taskA3 = new TaskA3(scanner);
        TaskB3 taskB3 = new TaskB3(scanner);
        TaskB4 taskB4 = new TaskB4(scanner);

        task0.start();
        taskA1.start();
        taskA2.start();
        taskA3.start();
        taskB3.start();
        taskB4.start();

        scanner.close();
    }
}