import java.util.Scanner;

public class FindPivotIndex {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers: ");
        int count = scanner.nextInt();

        int[] nums = new int[count];
        System.out.println("Enter the integers:");
        for (int i = 0; i < count; i++)
            nums[i] = scanner.nextInt();

        scanner.close();

        FindPivotIndex findTheHighestAltitude = new FindPivotIndex();
        System.out.println(findTheHighestAltitude.pivotIndex(nums));
    }

    private int pivotIndex(int[] nums) {
        int size = nums.length;
        int totalSum = 0;
        for (int i = 0; i < size; i++)
            totalSum += nums[i];

        int leftSum = 0;
        for(int i = 0; i < size; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum)
                return i;

            leftSum += nums[i];
        }

        return -1;
    }
}