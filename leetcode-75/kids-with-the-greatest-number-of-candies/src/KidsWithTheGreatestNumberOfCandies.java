import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KidsWithTheGreatestNumberOfCandies {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of kids: ");
        int kids = scanner.nextInt();

        int[] candies = new int[kids];
        System.out.println("Enter the number of candies that each kid has:");
        for (int i = 0; i < kids; i++)
            candies[i] = scanner.nextInt();

        System.out.print("Enter the number of extra candie(s): ");
        int extraCandies = scanner.nextInt();

        scanner.close();

        KidsWithTheGreatestNumberOfCandies kidsWithTheGreatestNumberOfCandies = new KidsWithTheGreatestNumberOfCandies();

        System.out.println(kidsWithTheGreatestNumberOfCandies.kidsWithCandies(candies, extraCandies));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> hasGreatestNumberOfCandies = new ArrayList<>();

        for (int i = 0; i < candies.length; i++) {
            Boolean check = true;
            for (int j = 0; j < candies.length; j++) {
                if (j == i) continue;
                if (candies[i] + extraCandies < candies[j])
                    check = false;
            }
            hasGreatestNumberOfCandies.add(check);
        }

        return hasGreatestNumberOfCandies;
    }
}