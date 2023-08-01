import java.util.Scanner;

public class MaxNumberOfKSumPairs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the integer array: ");
        int size = scanner.nextInt();

        int[] nums = new int[size];
        System.out.println("Enter the integers");
        for (int i = 0; i < size; i++)
            nums[i] = scanner.nextInt();

        System.out.print("Enter the number that will be calculated to find the sums: ");
        int k = scanner.nextInt();

        scanner.close();

        MaxNumberOfKSumPairs maxNumberOfKSumPairs = new MaxNumberOfKSumPairs();

        maxNumberOfKSumPairs.executeMaxOperationsMethod(nums, k);

        System.out.println("*********************");

        maxNumberOfKSumPairs.executeMaxOperationsWithLoopMethod(nums, k);
    }

    private void executeMaxOperationsMethod(int[] nums, int k) {
        long starMaxOperations = System.currentTimeMillis();
        System.out.println(this.maxOperationsWithLoop(nums, k));
        long endMaxOperations = System.currentTimeMillis();
        System.out.println(String.format("Execution time of maxOperations method is %d.%d seconds", (endMaxOperations - starMaxOperations) / 1000, (endMaxOperations - starMaxOperations) % 1000));
    }

    private void executeMaxOperationsWithLoopMethod(int[] nums, int k) {
        long starMaxOperationsWithLoop = System.currentTimeMillis();
        System.out.println(this.maxOperationsWithLoop(nums, k));
        long endMaxOperationsWithLoop = System.currentTimeMillis();
        System.out.println(String.format("Execution time of maxOperationsWithLoop method is %d.%d seconds", (endMaxOperationsWithLoop - starMaxOperationsWithLoop) / 1000, (endMaxOperationsWithLoop - starMaxOperationsWithLoop) % 1000));
    }

    private int maxOperations(int[] nums, int k) {


        return 0;
    }

    private int maxOperationsWithLoop(int[] nums, int k) {

        int length = nums.length;

        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] != 0 && nums[j] != 0 && (nums[i] + nums[j]) == k) {
                    nums[i] = 0;
                    nums[j] = 0;
                    count++;
                }
            }
        }

        return count;
    }
}