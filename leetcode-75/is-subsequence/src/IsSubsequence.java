import java.util.Arrays;
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

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] position = new int[sChars.length];

        Arrays.fill(position, -1);

        for (int i = 0; i < sChars.length; i++) {
            for (int j = 0; j <tChars.length; j++) {
                if (sChars[i] == tChars[j]) {
                    position[i] = j;
                    tChars[j] = 0;
                    break;
                }
            }
        }

        for (int i = 0; i < position.length; i++) {
            if (position[i] == -1)
                return false;
            for (int j = i + 1; j < position.length; j ++) {
                if (position[i] > position[j])
                    return false;
            }
        }

        return true;
    }
}