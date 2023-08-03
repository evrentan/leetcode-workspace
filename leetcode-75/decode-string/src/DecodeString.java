import java.util.Scanner;
import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your encoded string:");
        String s = scanner.nextLine();

        scanner.close();

        DecodeString decodeString = new DecodeString();
        System.out.print(decodeString.decodeString(s));
    }

    private String decodeString(String s) {
        char[] chars = s.toCharArray();

        Stack<Integer> numberStack = new Stack<>();
        Stack<StringBuilder> stringBuilderStack = new Stack<>();

        StringBuilder currentString = new StringBuilder();
        int num = 0;

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                numberStack.push(num);
                stringBuilderStack.push(currentString);
                currentString = new StringBuilder();
                num = 0;
            } else if (ch == ']') {
                StringBuilder tempString = currentString;
                currentString = stringBuilderStack.pop();
                int repeat = numberStack.pop();
                for (int j = 0; j < repeat; j++)
                    currentString.append(tempString);
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}