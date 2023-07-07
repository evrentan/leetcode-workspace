import java.util.Scanner;

public class CanPlaceFlowers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the plots on the flowerbed: ");
        int totalPlots = scanner.nextInt();

        int[] flowerbed = new int[totalPlots];
        System.out.println("Enter the plots' status on the flowerbed (1 for not empty, 0 for empty):");
        for (int i = 0; i < totalPlots; i++)
            flowerbed[i] = scanner.nextInt();

        System.out.print("Enter the number of flowers to be planted: ");
        int flowersToBePlanted = scanner.nextInt();

        scanner.close();

        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();

        System.out.println(canPlaceFlowers.canPlaceFlowers(flowerbed, flowersToBePlanted));
    }

    private boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return validatePlottedFlowers(flowerbed);

        if (flowerbed.length == 1 && flowerbed[0] == 0)
            return true;
        if (flowerbed.length == 1 && flowerbed[0] == 1)
            return false;

        int plottedFlowers = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) continue;
            if (flowerbed[i] == 0) {
                plottedFlowers = getPlottedFlowers(flowerbed, plottedFlowers, i);
            }

            if (n == plottedFlowers) break;
        }

        return n == plottedFlowers;
    }

    private boolean validatePlottedFlowers(int[] flowerbed) {
        if (flowerbed.length == 1)
            return true;
        else {
            for (int i = 0; i < flowerbed.length - 1; i++)
                if (flowerbed[i] == 1 && flowerbed[i + 1] == 1)
                    return false;
        }

        return true;
    }

    private int getPlottedFlowers(int[] flowerbed, int plottedFlowers, int i) {
        if (i == 0) {
            if (flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                plottedFlowers++;
            }
        } else if (i == flowerbed.length - 1) {
            if (flowerbed[i - 1] == 0) {
                flowerbed[i] = 1;
                plottedFlowers++;
            }
        } else if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
            flowerbed[i] = 1;
            plottedFlowers++;
        }
        return plottedFlowers;
    }
}