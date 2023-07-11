import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers: ");
        int count = scanner.nextInt();

        int[] arr = new int[count];
        System.out.println("Enter the integers:");
        for (int i = 0; i < count; i++)
            arr[i] = scanner.nextInt();

        scanner.close();

        UniqueNumberOfOccurrences uniqueNumberOfOccurrences = new UniqueNumberOfOccurrences();
        System.out.println(uniqueNumberOfOccurrences.uniqueOccurrences(arr));
    }

    private boolean uniqueOccurrences(int[] arr) {

        AtomicBoolean hasUniqueOccurences = new AtomicBoolean(true);

        HashMap<Integer, Integer> integerHashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int count = integerHashMap.containsKey(arr[i]) ? integerHashMap.get(arr[i]) : 0;
            integerHashMap.put(arr[i], ++count);
        }

        Map<Integer, Long> occurenceMap = integerHashMap.values().stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        occurenceMap.forEach((key, value) -> {
            if (value > 1)
                hasUniqueOccurences.set(false);
        });

        return hasUniqueOccurences.get();
    }
}