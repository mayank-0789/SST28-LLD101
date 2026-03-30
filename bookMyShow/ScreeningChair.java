public class ScreeningChair {
    private String id;
    private Chair chair;
    private ChairState state;
    private String heldBy;
    private long holdExpiry;

    public ScreeningChair(String id, Chair chair) {
        this.id = id;
        this.chair = chair;
        this.state = ChairState.FREE;
    }

    public Chair getChair() { return chair; }
    public ChairState getState() { return state; }
    public String getHeldBy() { return heldBy; }

    public boolean isHoldExpired() {
        return state == ChairState.HELD && System.currentTimeMillis() > holdExpiry;
    }

    public void hold(String customerEmail, long expiry) {
        this.state = ChairState.HELD;
        this.heldBy = customerEmail;
        this.holdExpiry = expiry;
    }

    public void release() {
        this.state = ChairState.FREE;
        this.heldBy = null;
        this.holdExpiry = 0;
    }

    public void reserve() {
        this.state = ChairState.RESERVED;
    }
}
