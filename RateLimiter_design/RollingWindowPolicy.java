import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class RollingWindowPolicy implements ThrottlePolicy {
    private final Map<String, Queue<Long>> tracker = new HashMap<>();
    private final long intervalMs;
    private final int limit;

    public RollingWindowPolicy(long intervalMs, int limit) {
        this.intervalMs = intervalMs;
        this.limit = limit;
    }

    @Override
    public boolean allowRequest(String callerId) {
        long now = System.currentTimeMillis();

        tracker.putIfAbsent(callerId, new LinkedList<>());
        Queue<Long> history = tracker.get(callerId);

        while (!history.isEmpty() && now - history.peek() > intervalMs) {
            history.poll();
        }

        if (history.size() < limit) {
            history.offer(now);
            return true;
        }

        return false;
    }
}
