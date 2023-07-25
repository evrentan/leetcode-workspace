import java.util.Scanner;
import java.util.Stack;

public class RemovingStarsFromAString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your string which contains stars: ");
        String s = scanner.nextLine();

        scanner.close();

        RemovingStarsFromAString removingStarsFromAString = new RemovingStarsFromAString();
        System.out.println(removingStarsFromAString.removeStars(s));
    }

    private String removeStars(String s) {
        char[] chars = s.toCharArray();
        Stack<String> stringStack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '*' && !stringStack.empty())
                stringStack.pop();
            else
                stringStack.push(String.valueOf(chars[i]));
        }

        return String.join("", stringStack);
    }
}