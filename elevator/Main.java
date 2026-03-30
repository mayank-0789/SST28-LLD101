public class Main {
    public static void main(String[] args) {
        DispatchPolicy policy = new NearestLiftPolicy();
        LiftManager mgr = new LiftManager(policy);

        Lift liftA = new Lift("L1", 700.0);
        Lift liftB = new Lift("L2", 1000.0);
        Lift liftC = new Lift("L3");

        mgr.register(liftA);
        mgr.register(liftB);
        mgr.register(liftC);

        // take L3 offline for maintenance
        liftC.setStatus(LiftStatus.OUT_OF_SERVICE);

        // someone on floor 5 presses UP
        FloorButtons floor5 = new FloorButtons(5, mgr);
        floor5.callUp();

        // inside lift L1, try going to 10 while overloaded
        CabinControls cabinA = new CabinControls(liftA, mgr);
        liftA.addLoad(800.0);
        cabinA.selectFloor(10);

        // some passengers leave, retry
        liftA.reduceLoad(200.0);
        cabinA.selectFloor(10);

        // someone pulls the alarm
        cabinA.hitAlarm();
    }
}
