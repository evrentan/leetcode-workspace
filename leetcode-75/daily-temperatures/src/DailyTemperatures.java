import java.util.Arrays;
import java.util.Scanner;

public class DailyTemperatures {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of days: ");
        int days = scanner.nextInt();

        int[] temperatures = new int[days];
        System.out.println("Enter the temperatures of each corresponding day:");
        for (int i = 0; i < days; i++)
            temperatures[i] = scanner.nextInt();

        scanner.close();
        
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(temperatures)));
    }

    private int[] dailyTemperatures(int[] temperatures) {

        int temperaturesLength = temperatures.length;

        int[] answerArray = new int[temperaturesLength];

        for (int i = 0; i < temperaturesLength; i++) {
            int dayDifference = 0;
            int checkBiggerTemperature = 0;
            for (int j = i + 1; j < temperaturesLength; j++) {
                if (temperatures[j] <= temperatures[i])
                    dayDifference++;
                else if (temperatures[j] > temperatures[i]) {
                    dayDifference++;
                    checkBiggerTemperature++;
                    break;
                }
            }
            answerArray[i] = checkBiggerTemperature == 0 ? 0 : dayDifference;
        }

        return answerArray;
    }
}