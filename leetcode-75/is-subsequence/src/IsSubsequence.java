import java.util.Scanner;

public class IsSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first string: ");
        String s = scanner.nextLine();
        System.out.println("Enter the second string: ");
        String t = scanner.nextLine();

        scanner.close();

        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence(s, t));
    }

    public boolean isSubsequence(String s, String t) {

        int sCheck = 0;
        int tCheck = 0;

        while (sCheck < s.length() && tCheck < t.length()) {
            if (s.charAt(sCheck) == t.charAt(tCheck))
                sCheck++;

            tCheck++;
        }

        return sCheck == s.length();
    }
}