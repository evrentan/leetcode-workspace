import java.util.Scanner;

public class ReverseWordsInAString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string: ");
        String s = scanner.nextLine();

        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        System.out.println(reverseWordsInAString.reverseWords(s));
    }

    private String reverseWords(String s) {

        String[] strings = s.trim().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = strings.length - 1; i >= 0; i--) {
            if (i == strings.length - 1)
                stringBuilder.append(strings[i]);
            else
                stringBuilder.append(String.format(" %s", strings[i]));
        }

        return stringBuilder.toString();
    }
}