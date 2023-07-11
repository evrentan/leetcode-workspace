import java.util.*;

public class FindTheDifferenceOfTwoArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("*****************First List*****************");
        System.out.print("Enter the number of integers for the first list: ");
        int countFirstList = scanner.nextInt();
        int[] nums1 = new int[countFirstList];
        System.out.println("Enter the integers of the first list:");
        for (int i = 0; i < countFirstList; i++)
            nums1[i] = scanner.nextInt();

        System.out.println("*****************Second List*****************");
        System.out.print("Enter the number of integers for the second list: ");
        int countSecondList = scanner.nextInt();
        int[] nums2 = new int[countSecondList];
        System.out.println("Enter the integers of the second list:");
        for (int i = 0; i < countSecondList; i++)
            nums2[i] = scanner.nextInt();

        scanner.close();

        FindTheDifferenceOfTwoArrays findTheDifferenceOfTwoArrays = new FindTheDifferenceOfTwoArrays();
        System.out.println(findTheDifferenceOfTwoArrays.findDifference(nums1, nums2));
    }

    private List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> distinctIntegers =  new ArrayList<>();
        Set<Integer> distinctIntegersNums1 = new HashSet<>();
        Set<Integer> distinctIntegersNums2 = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            int finalI = i;
            if (Arrays.stream(nums2).noneMatch(n -> n == nums1[finalI]))
                distinctIntegersNums1.add(nums1[i]);
        }
        distinctIntegers.add(distinctIntegersNums1.stream().toList());

        for (int i = 0; i < nums2.length; i++) {
            int finalI = i;
            if (Arrays.stream(nums1).noneMatch(n -> n == nums2[finalI]))
                distinctIntegersNums2.add(nums2[i]);
        }
        distinctIntegers.add(distinctIntegersNums2.stream().toList());

        return distinctIntegers;
    }
}