import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Dota2Senate {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string of Dota2 senate representing each senator's party belonging:");
        String senate = scanner.nextLine();

        scanner.close();

        Dota2Senate dota2Senate = new Dota2Senate();
        System.out.println(dota2Senate.predictPartyVictory(senate));
    }

    private String predictPartyVictory(String senate) {

        char[] chars = senate.toCharArray();
        int length = chars.length;

        Queue<Integer> radiants = new LinkedList<>();
        Queue<Integer> dires = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            char ch = chars[i];

            if (ch == 'R')
                radiants.add(i);
            else
                dires.add(i);
        }

        while (!radiants.isEmpty() && !dires.isEmpty()) {
            int radiantPosition = radiants.poll();
            int direPosition = dires.poll();

            if (radiantPosition < direPosition)
                radiants.add(radiantPosition + length);
            else
                dires.add(direPosition + length);
        }

        return radiants.isEmpty() ? "Dire" : "Radiant";
    }
}