import java.util.Scanner;

public class IsogramChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите слово для проверки на изограмму: ");
        String word = scanner.nextLine();

        boolean result = isIsogram(word);

        if (result) {
            System.out.println("Слово '" + word + "' является изограммой");
        } else {
            System.out.println("Слово '" + word + "' не является изограммой");
        }

    }

    public static boolean isIsogram(String str) {
        if (str == null) {
            return false;
        }

        if (str.isEmpty()) {
            return true;
        }

        String lowerCaseStr = str.toLowerCase();

        for (int i = 0; i < lowerCaseStr.length(); i++) {
            char currentChar = lowerCaseStr.charAt(i);

            for (int j = i + 1; j < lowerCaseStr.length(); j++) {
                if (currentChar == lowerCaseStr.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

}
