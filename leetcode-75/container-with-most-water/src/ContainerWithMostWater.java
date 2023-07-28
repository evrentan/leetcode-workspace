import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContainerWithMostWater {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the integer array: ");
        int size = scanner.nextInt();

        System.out.println("Enter integers to form the container:");
        int[] height = new int[size];

        for (int i = 0; i < size; i++)
            height[i] = scanner.nextInt();

        scanner.close();

        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

        containerWithMostWater.executeMaxAreaMethod(height);

        System.out.println("*********************");

        containerWithMostWater.executeMaxAreaWithListMethod(height);

        System.out.println("*********************");

        containerWithMostWater.executeMaxAreaWithLoopMethod(height);
    }

    private void executeMaxAreaMethod(int[] height) {
        long startMaxArea = System.currentTimeMillis();
        System.out.println(this.maxArea(height));
        long endMaxArea = System.currentTimeMillis();
        System.out.println(String.format("Execution time of maxArea method is %d.%d seconds", (endMaxArea - startMaxArea) / 1000, (endMaxArea - startMaxArea) % 1000));
    }

    private void executeMaxAreaWithListMethod(int[] height) {
        long startMaxAreaWithList = System.currentTimeMillis();
        System.out.println(this.maxAreaWithList(height));
        long endMaxAreaWithList = System.currentTimeMillis();
        System.out.println(String.format("Execution time of maxAreaWithList method is %d.%d seconds", (endMaxAreaWithList - startMaxAreaWithList) / 1000, (endMaxAreaWithList - startMaxAreaWithList) % 1000));
    }

    private void executeMaxAreaWithLoopMethod(int[] height) {
        long startMaxAreaWithLoop = System.currentTimeMillis();
        System.out.println(this.maxAreaWithLoop(height));
        long endMaxAreaWithLoop = System.currentTimeMillis();
        System.out.println(String.format("Execution time of maxAreaWithList method is %d.%d seconds", (endMaxAreaWithLoop - startMaxAreaWithLoop) / 1000, (endMaxAreaWithLoop - startMaxAreaWithLoop) % 1000));
    }

    private int maxArea(int[] height) {

        int leftPosition = 0;
        int rightPosition = height.length - 1;
        int maxArea = 1;

        while (leftPosition < rightPosition) {
            int tempArea = (rightPosition - leftPosition) * Math.min(height[leftPosition], height[rightPosition]);

            maxArea = Math.max(maxArea, tempArea);

            if (height[leftPosition] < height[rightPosition])
                leftPosition++;
            else
                rightPosition--;
        }

        return maxArea;
    }

    private int maxAreaWithList(int[] height) {

        int leftPosition = 0;
        int rightPosition = height.length - 1;
        List<Integer> maxAreaList = new ArrayList<>();

        while (leftPosition < rightPosition) {
            int tempArea = (rightPosition - leftPosition) * Math.min(height[leftPosition], height[rightPosition]);

            maxAreaList.add(tempArea);

            if (height[leftPosition] < height[rightPosition])
                leftPosition++;
            else
                rightPosition--;
        }

        return maxAreaList.stream().mapToInt(i -> i).max().orElse(1);
    }

    private int maxAreaWithLoop(int[] height) {
        int heightLength = height.length;

        List<Integer> areaList = new ArrayList<>();

        for (int i = 0; i < heightLength - 1; i++) {
            for (int j = i + 1; j < heightLength; j++) {
                int tempHeight = Math.min(height[i], height[j]);
                areaList.add(tempHeight * (j - i));
            }
        }

        return areaList.stream().mapToInt(i -> i).max().orElse(1);
    }
}