import java.util.HashMap;
import java.util.Map;

public class FixedBucketPolicy implements ThrottlePolicy {

    private static class Bucket {
        int count;
        long start;

        Bucket(long start) {
            this.count = 0;
            this.start = start;
        }
    }

    private final Map<String, Bucket> tracker = new HashMap<>();
    private final long intervalMs;
    private final int limit;

    public FixedBucketPolicy(long intervalMs, int limit) {
        this.intervalMs = intervalMs;
        this.limit = limit;
    }

    @Override
    public boolean allowRequest(String callerId) {
        long now = System.currentTimeMillis();

        tracker.putIfAbsent(callerId, new Bucket(now));
        Bucket b = tracker.get(callerId);

        if (now - b.start > intervalMs) {
            b.start = now;
            b.count = 0;
        }

        if (b.count < limit) {
            b.count++;
            return true;
        }

        return false;
    }
}
