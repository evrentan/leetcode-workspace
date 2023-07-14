import java.util.Scanner;
import java.util.Stack;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your string: ");
        String s = scanner.next();

        scanner.close();

        ReverseVowelsOfAString reverseVowelsOfAString = new ReverseVowelsOfAString();
        System.out.println(reverseVowelsOfAString.reverseVowels(s));
    }

    private String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> characterStack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (this.isVowel(chars[i])) {
                characterStack.push(chars[i]);
                chars[i] = 0;
            }
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 0) {
                chars[i] = characterStack.pop();
            }
        }

        return String.valueOf(chars);
    }

    private boolean isVowel(char c) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};

        for (char v : vowels) {
            if (v == c) {
                return true;
            }
        }

        return false;
    }
}