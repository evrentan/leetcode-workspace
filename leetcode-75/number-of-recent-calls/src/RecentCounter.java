import java.util.Iterator;
import java.util.LinkedList;

public class RecentCounter {

    private static final int TIME_FRAME = 3000;

    private LinkedList<Integer> call;

    public RecentCounter() {
        call = new LinkedList<>();
    }

    public int ping(int t) {
        this.call.add(t);

        int rangeStart = t - TIME_FRAME;

        Iterator<Integer> iterator = this.call.iterator();

        int count = 0;
        while (iterator.hasNext()) {
            int current = iterator.next();

            if (current >= rangeStart && current <= t)
                count++;
            else if (current > t)
                break;
        }

        return count;
    }
}
