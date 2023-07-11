import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class SingleNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers: ");
        int count = scanner.nextInt();

        int[] nums = new int[count];
        System.out.println("Enter the integers:");
        for (int i = 0; i < count; i++)
            nums[i] = scanner.nextInt();

        scanner.close();

        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(nums));

    }

    private int singleNumber(int[] nums) {
        AtomicInteger singleNumber = new AtomicInteger();
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int tempCount = integerHashMap.getOrDefault(nums[i], 0);
            integerHashMap.put(nums[i], ++tempCount);
        }

        integerHashMap.forEach((key, value) -> {
            if (value == 1)
                singleNumber.set(key);
        });

        return singleNumber.get();
    }
}