import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers: ");
        int count = scanner.nextInt();

        int[] nums = new int[count];
        System.out.println("Enter the integers:");
        for (int i = 0; i < count; i++)
            nums[i] = scanner.nextInt();

        System.out.print("Enter the number of that will find the kth largest element in the array: ");
        int k = scanner.nextInt();

        scanner.close();

        KthLargestElementInAnArray kthLargestElementInAnArray = new KthLargestElementInAnArray();
        System.out.println(kthLargestElementInAnArray.findKthLargest(nums, k));
    }

    private int findKthLargest(int[] nums, int k) {

        return Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).toList().get(k - 1);
    }
}