package groupa;

import java.util.Scanner;

public class RomanToArabic {
    public static void main(String[] args) {
        int[] resolve = {1, 5, 10, 50, 100, 500, 1000};
        String roma = "IVXLCDM";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type a romanian num to convert: ");
        String rom_num = scanner.nextLine();
        int res = 0;
        for(int i = rom_num.length()-1; i>=0; i--){
            char cur_char = rom_num.charAt(i);
            int cur_num = resolve[roma.indexOf(cur_char)];
            if((i != rom_num.length()-1)){
                char prev_char = rom_num.charAt(i+1);
                int prev_num = resolve[roma.indexOf(prev_char)];
                if(cur_num >= prev_num){
                    res += cur_num;
                }
                else{
                    res -= cur_num;
                }
            }
            else{
                res += cur_num;
            }
        }
        scanner.close();
        System.out.println("Your converted num: " + res);
    }
}