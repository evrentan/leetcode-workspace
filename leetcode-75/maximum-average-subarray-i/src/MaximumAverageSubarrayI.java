import java.util.Scanner;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers: ");
        int count = scanner.nextInt();

        int[] nums = new int[count];
        System.out.println("Enter the integers:");
        for (int i = 0; i < count; i++)
            nums[i] = scanner.nextInt();

        System.out.print("Enter the integer: ");
        int k = scanner.nextInt();

        scanner.close();

        MaximumAverageSubarrayI maximumAverageSubarrayI = new MaximumAverageSubarrayI();
        System.out.println(maximumAverageSubarrayI.findMaxAverage(nums, k));
    }

    private double findMaxAverage(int[] nums, int k) {
        int partialSum = 0;

        for (int i = 0; i < k; i ++)
            partialSum+= nums[i];

        double maxAverage = (double) partialSum / k;

        for (int i = k; i < nums.length; i++) {
            partialSum += nums[i] - nums[i - k];
            double tempAverage = (double) partialSum / k;
            if (tempAverage > maxAverage)
                maxAverage = tempAverage;
        }

        return maxAverage;
    }
}