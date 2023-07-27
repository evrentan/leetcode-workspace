import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the integer array: ");
        int size = scanner.nextInt();

        int[] nums = new int[size];
        System.out.println("Enter the integers:");
        for (int i = 0; i < size; i++)
            nums[i] = scanner.nextInt();

        scanner.close();

        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        System.out.print(Arrays.stream(productOfArrayExceptSelf.productExceptSelf(nums)).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }

    private int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] leftResult = new int[length];
        int[] rightResult = new int[length];
        int[] result = new int[length];

        leftResult[0] = 1;
        for (int i = 1; i < length; i++) {
            leftResult[i] = leftResult[i - 1] * nums[i - 1];
        }

        rightResult[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            rightResult[i] = rightResult[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < length; i++)
            result[i] = leftResult[i] * rightResult[i];

        return result;
    }
}