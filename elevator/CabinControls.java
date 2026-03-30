public class CabinControls {
    private Lift lift;
    private LiftManager mgr;

    public CabinControls(Lift lift, LiftManager mgr) {
        this.lift = lift;
        this.mgr = mgr;
    }

    public void selectFloor(int floor) {
        mgr.processFloorRequest(lift, floor);
    }

    public void holdOpen() {
        lift.openDoors();
    }

    public void forceClose() {
        lift.closeDoors();
    }

    public void hitAlarm() {
        mgr.activateEmergency();
    }
}
