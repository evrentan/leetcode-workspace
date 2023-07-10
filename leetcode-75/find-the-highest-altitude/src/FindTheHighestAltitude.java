import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindTheHighestAltitude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of points that the biker goes on the road trip: ");
        int points = scanner.nextInt();

        int[] gain = new int[points];
        System.out.println("Enter the gains that the biker has during the road trip at the points:");
        for (int i = 0; i < points; i++)
            gain[i] = scanner.nextInt();

        FindTheHighestAltitude findTheHighestAltitude = new FindTheHighestAltitude();
        System.out.println(findTheHighestAltitude.largestAltitude(gain));
    }

    public int largestAltitude(int[] gain) {
        List<Integer> altitudes = new ArrayList<>();

        altitudes.add(0);
        for (int i = 0; i < gain.length; i++)
            altitudes.add(altitudes.get(i) + gain[i]);

        return altitudes.stream().mapToInt(v -> v).max().orElse(0);
    }
}