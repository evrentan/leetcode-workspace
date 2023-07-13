import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NThTribonacciNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number that will be used to calculate the related tribonacci number: ");
        int n = scanner.nextInt();

        scanner.close();

        NThTribonacciNumber nThTribonacciNumber = new NThTribonacciNumber();

        long startTribonacci = System.currentTimeMillis();
        System.out.println(nThTribonacciNumber.tribonacci(n));
        long endTribonacci = System.currentTimeMillis();
        nThTribonacciNumber.logMethodExecutionTime("tribonacci", startTribonacci, endTribonacci);

        long startTribonacciRecursion = System.currentTimeMillis();
        System.out.println(nThTribonacciNumber.tribonacciRecursion(n));
        long endTribonacciRecursion = System.currentTimeMillis();
        nThTribonacciNumber.logMethodExecutionTime("tribonacciRecursion", startTribonacciRecursion, endTribonacciRecursion);
    }

    private int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        List<Integer> tribonacciList = new ArrayList<>();
        tribonacciList.add(0);
        tribonacciList.add(1);
        tribonacciList.add(1);

        for (int i = 3; i <= n; i++) {
            tribonacciList.add(tribonacciList.get(i - 1) + tribonacciList.get(i - 2) + tribonacciList.get(i - 3));
        }

        return tribonacciList.get(n);
    }

    private int tribonacciRecursion(int n) {

        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        return this.tribonacciRecursion(n - 3) + this.tribonacciRecursion(n - 2) + this.tribonacciRecursion(n - 1);
    }

    private void logMethodExecutionTime(String methodName, long startTribonacciRecursion, long endTribonacciRecursion) {
        System.out.println(String.format("%s method execution time is %d.%d seconds", methodName, (endTribonacciRecursion - startTribonacciRecursion) / 1000, (endTribonacciRecursion - startTribonacciRecursion) % 1000));
    }
}