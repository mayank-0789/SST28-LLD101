import java.util.List;

public interface DispatchPolicy {
    Lift pickLift(List<Lift> lifts, int floor, Travel travel);
}
