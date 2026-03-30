import java.util.List;

public class HoldManager {
    private final long holdTimeoutMs;

    public HoldManager(long holdTimeoutMs) {
        this.holdTimeoutMs = holdTimeoutMs;
    }

    public synchronized boolean holdChairs(List<ScreeningChair> chairs, Customer customer) {
        for (ScreeningChair sc : chairs) {
            if (sc.getState() == ChairState.RESERVED) {
                return false;
            }
            if (sc.getState() == ChairState.HELD
                    && !sc.isHoldExpired()
                    && !sc.getHeldBy().equals(customer.getEmailId())) {
                return false;
            }
        }

        long expiry = System.currentTimeMillis() + holdTimeoutMs;
        for (ScreeningChair sc : chairs) {
            sc.hold(customer.getEmailId(), expiry);
        }
        return true;
    }

    public synchronized void releaseChairs(List<ScreeningChair> chairs) {
        for (ScreeningChair sc : chairs) {
            if (sc.getState() == ChairState.HELD) {
                sc.release();
            }
        }
    }
}
