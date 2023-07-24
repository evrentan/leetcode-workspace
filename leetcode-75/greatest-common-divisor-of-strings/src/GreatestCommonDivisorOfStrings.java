import java.util.Scanner;

public class GreatestCommonDivisorOfStrings {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first string:");
        String str1 = scanner.nextLine();
        System.out.println("Enter the second string:");
        String str2 = scanner.nextLine();

        scanner.close();

        GreatestCommonDivisorOfStrings greatestCommonDivisorOfStrings = new GreatestCommonDivisorOfStrings();
        System.out.println(greatestCommonDivisorOfStrings.gcdOfStrings(str1, str2));
    }

    private String gcdOfStrings(String str1, String str2) {

        if (str1.length() < str2.length())
            return gcdOfStrings(str2, str1);

        if (str2.isEmpty())
            return str1;

        if (str1.startsWith(str2))
            return gcdOfStrings(str1.substring(str2.length()), str2);

        return "";
    }
}