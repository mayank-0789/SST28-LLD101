public class FloorButtons {
    private int floor;
    private LiftManager mgr;

    public FloorButtons(int floor, LiftManager mgr) {
        this.floor = floor;
        this.mgr = mgr;
    }

    public void callUp() {
        mgr.callLift(floor, Travel.GOING_UP);
    }

    public void callDown() {
        mgr.callLift(floor, Travel.GOING_DOWN);
    }
}
