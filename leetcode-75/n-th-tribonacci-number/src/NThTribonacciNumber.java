import java.util.Scanner;

public class NThTribonacciNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number that will be used to calculate the related tribonacci number: ");
        int n = scanner.nextInt();

        scanner.close();

        NThTribonacciNumber nThTribonacciNumber = new NThTribonacciNumber();
        long start = System.currentTimeMillis();
        System.out.println(nThTribonacciNumber.tribonacci(n));
        long end = System.currentTimeMillis();
        System.out.println(String.format("Execution time is %d.%d seconds", (end - start) / 1000, (end - start) % 1000));
    }

    public int tribonacci(int n) {

        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        return this.tribonacci(n - 3) + this.tribonacci(n - 2) + this.tribonacci(n - 1);
    }
}