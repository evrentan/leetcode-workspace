import java.util.Arrays;
import java.util.Scanner;

public class CountingBits {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the integer that will be used to calculate number of 1's in its binary representation: ");
        int n = scanner.nextInt();

        scanner.close();

        CountingBits countingBits = new CountingBits();
        System.out.println(Arrays.toString(countingBits.countBits(n)));
    }

    public int[] countBits(int n) {
        int[] integerArray = new int[n + 1];
        for (int i = 0; i < n + 1; i++)
            integerArray[i] = i;

        int[] bitCountArray = new int[n + 1];

        for (int i = 0; i < n + 1; i++)
            bitCountArray[i] = Integer.bitCount(integerArray[i]);

        return bitCountArray;
    }
}