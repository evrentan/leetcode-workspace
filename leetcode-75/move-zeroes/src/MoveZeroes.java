import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MoveZeroes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of the integer array: ");
        int arraySize = scanner.nextInt();

        int[] nums = new int[arraySize];
        System.out.println("Enter the numbers: ");
        for (int i = 0; i < arraySize; i++)
            nums[i] = scanner.nextInt();

        scanner.close();

        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);

        System.out.println(Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
    }

    private void moveZeroes(int[] nums) {
        if (nums.length == 1) return;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int x = nums[i];
                for (int j = i-1; j >= 0; j--) {
                    int a = nums[j];
                    if (a == 0) {
                        nums[j] = x;
                        nums[j + 1] = a;
                    }
                }
            }
        }
    }
}