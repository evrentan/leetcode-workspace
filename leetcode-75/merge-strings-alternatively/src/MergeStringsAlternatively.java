import java.util.Scanner;

public class MergeStringsAlternatively {
    public static void main(String[] args) {
        System.out.println("Input two strings to be merged:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("First string: ");
        String word1 = scanner.nextLine();
        System.out.print("Second string: ");
        String word2 = scanner.nextLine();
        scanner.close();

        System.out.println(word1 + word2);

        MergeStringsAlternatively mergeStringsAlternatively = new MergeStringsAlternatively();
        System.out.println(mergeStringsAlternatively.mergeAlternately(word1, word2));
    }

    private String mergeAlternately(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        StringBuilder mergedString = new StringBuilder();

        int length1 = word1.length();
        int length2 = word2.length();
        int word1Counter = 0;
        int word2Counter = 0;

        for (int i = 0, j = 0; i < length1 && j < length2; i++, j++) {
            mergedString.append(chars1[i]).append(chars2[j]);
            word1Counter++;
            word2Counter++;
        }

        if (length1 > length2) {
            for (int i = word1Counter; i < length1; i++)
                mergedString.append(chars1[i]);
        } else if (length2 > length1) {
            for (int i = word2Counter; i < length2; i++)
                mergedString.append(chars2[i]);
        }

        return mergedString.toString();
    }
}