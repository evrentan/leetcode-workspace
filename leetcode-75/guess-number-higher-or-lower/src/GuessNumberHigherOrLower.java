import java.util.Scanner;

public class GuessNumberHigherOrLower {

    private static final int PICKED_NUMBER = 6;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the max number (must be greater than 1): ");
        int n = scanner.nextInt();

        scanner.close();

        GuessNumberHigherOrLower guessNumberHigherOrLower = new GuessNumberHigherOrLower();

        System.out.println(guessNumberHigherOrLower.guessNumber(n));
    }

    private int guessNumber(int n) {
       int leftPosition = 1;
       int rightPosition = n;

       while (leftPosition <= rightPosition) {
           int midPosition = leftPosition + (rightPosition - leftPosition) / 2;
           int result = this.guess(midPosition);

           if (result == 0)
               return midPosition;
           else if (result == -1)
               rightPosition = midPosition - 1;
           else
               leftPosition = midPosition + 1;
       }

       return 0;
    }

    private int guess(int num) {
        return Integer.compare(PICKED_NUMBER, num);
    }
}