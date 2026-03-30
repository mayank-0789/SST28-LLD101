import java.util.List;

public class NearestLiftPolicy implements DispatchPolicy {

    @Override
    public Lift pickLift(List<Lift> lifts, int floor, Travel travel) {
        Lift best = null;
        int closest = Integer.MAX_VALUE;

        for (Lift l : lifts) {
            if (l.getStatus() == LiftStatus.OUT_OF_SERVICE) continue;

            int gap = Math.abs(l.getFloor() - floor);

            boolean eligible = false;

            if (l.getStatus() == LiftStatus.WAITING) {
                eligible = true;
            } else if (l.getStatus() == LiftStatus.MOVING_UP
                    && travel == Travel.GOING_UP
                    && l.getFloor() <= floor) {
                eligible = true;
            } else if (l.getStatus() == LiftStatus.MOVING_DOWN
                    && travel == Travel.GOING_DOWN
                    && l.getFloor() >= floor) {
                eligible = true;
            }

            if (eligible && gap < closest) {
                closest = gap;
                best = l;
            }
        }

        return best;
    }
}
