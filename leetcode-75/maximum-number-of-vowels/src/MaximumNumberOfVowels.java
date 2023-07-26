import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaximumNumberOfVowels {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your string: ");
        String s = scanner.next();
        System.out.print("Enter the substring length: ");
        int k = scanner.nextInt();

        scanner.close();

        MaximumNumberOfVowels maximumNumberOfVowels = new MaximumNumberOfVowels();
        System.out.print(maximumNumberOfVowels.maxVowels(s, k));
    }

    private int maxVowels(String s, int k) {
        final List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");

        char[] chars = s.toCharArray();

        int partialSum = 0;

        for (int i = 0; i < k; i++) {
            if (vowels.contains(String.valueOf(chars[i])))
                partialSum++;
        }

        int maxVowels = partialSum;

        for (int i = k; i < chars.length; i++) {
            if (vowels.contains(String.valueOf(chars[i - k])))
                partialSum--;
            if (vowels.contains(String.valueOf(chars[i])))
                partialSum++;

            if (partialSum > maxVowels)
                maxVowels = partialSum;
        }

        return maxVowels;
    }
}