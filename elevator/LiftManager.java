import java.util.ArrayList;
import java.util.List;

public class LiftManager {
    private List<Lift> lifts;
    private DispatchPolicy policy;

    public LiftManager(DispatchPolicy policy) {
        this.lifts = new ArrayList<>();
        this.policy = policy;
    }

    public void register(Lift lift) {
        lifts.add(lift);
    }

    public synchronized void callLift(int floor, Travel travel) {
        System.out.println(">> Floor " + floor + " requested a lift (" + travel + ")");
        Lift chosen = policy.pickLift(lifts, floor, travel);

        if (chosen == null) {
            System.out.println("No lift available right now.");
            return;
        }

        System.out.println("Dispatching lift " + chosen.getName() + " to floor " + floor);
        chosen.goTo(floor);
    }

    public synchronized void processFloorRequest(Lift lift, int dest) {
        System.out.println(">> Lift " + lift.getName() + " cabin: floor " + dest + " pressed");
        lift.goTo(dest);
    }

    public synchronized void activateEmergency() {
        System.out.println("!! ALARM TRIGGERED - stopping all lifts !!");
        for (Lift l : lifts) {
            l.emergencyHalt();
        }
    }

    public synchronized void handleBlackout() {
        System.out.println("!! POWER FAILURE - returning lifts to ground !!");
        for (Lift l : lifts) {
            if (l.getStatus() == LiftStatus.OUT_OF_SERVICE) continue;
            l.goTo(0);
            l.openDoors();
            l.setStatus(LiftStatus.OUT_OF_SERVICE);
        }
    }
}
