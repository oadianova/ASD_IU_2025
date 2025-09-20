import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a num to search\n");
        var num = scanner.nextInt();
        int res = 0;
        int mid;
        int[] ar1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        var left = 0;
        var right = ar1.length - 1;
        while (left <= right)
        {
            mid = left + (right-left)/2;

            if(num>ar1[mid]){
                left = mid+1;
            }
            else if(num<ar1[mid]){
                right = mid-1;
            }
            else if(num==ar1[mid]){
                res = mid;
                break;
            }
        }
        System.out.print("Your number index: " + res);
    }
}
