import java.util.Scanner;

public class HouseRobber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of houses: ");
        int count = scanner.nextInt();

        int[] nums = new int[count];
        System.out.println("Enter the amount of money of each house:");
        for (int i = 0; i < count; i++)
            nums[i] = scanner.nextInt();

        scanner.close();

        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(nums));
    }

    private int rob(int[] nums) {
        int numsLength = nums.length;

        if (numsLength == 1)
            return nums[0];

        int robbedAmount = 0;
        int notRobbedAmount = 0;

        for (int i = 0; i < numsLength; i++) {
            int currentRobbedAmount = notRobbedAmount + nums[i];
            int currentNotRobbedAmount = Math.max(robbedAmount, notRobbedAmount);

            robbedAmount = currentRobbedAmount;
            notRobbedAmount = currentNotRobbedAmount;
        }

        return Math.max(robbedAmount, notRobbedAmount);
    }
}