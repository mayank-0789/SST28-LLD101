public class Lift {
    private String name;
    private int floor;
    private LiftStatus status;
    private boolean doorOpen;
    private double maxLoad;
    private double load;

    private static final double DEFAULT_MAX_LOAD = 680.0;

    public Lift(String name) {
        this(name, DEFAULT_MAX_LOAD);
    }

    public Lift(String name, double maxLoad) {
        this.name = name;
        this.maxLoad = maxLoad;
        this.floor = 0;
        this.status = LiftStatus.WAITING;
        this.load = 0;
        this.doorOpen = false;
    }

    public String getName() { return name; }
    public int getFloor() { return floor; }
    public LiftStatus getStatus() { return status; }
    public void setStatus(LiftStatus status) { this.status = status; }

    public void addLoad(double kg) {
        this.load += kg;
    }

    public void reduceLoad(double kg) {
        this.load = Math.max(0, this.load - kg);
    }

    public boolean isOverloaded() {
        return load > maxLoad;
    }

    public void goTo(int dest) {
        if (status == LiftStatus.OUT_OF_SERVICE) {
            System.out.println("Lift " + name + " is out of service, ignoring request.");
            return;
        }

        if (isOverloaded()) {
            System.out.println("Lift " + name + " overloaded! Please reduce weight.");
            openDoors();
            return;
        }

        closeDoors();

        if (dest > floor) {
            this.status = LiftStatus.MOVING_UP;
        } else {
            this.status = LiftStatus.MOVING_DOWN;
        }

        System.out.println("Lift " + name + " going " + status + " from " + floor + " -> " + dest);
        this.floor = dest;
        this.status = LiftStatus.WAITING;
        openDoors();
    }

    public void openDoors() {
        doorOpen = true;
        System.out.println("Lift " + name + ": doors open at floor " + floor);
    }

    public void closeDoors() {
        doorOpen = false;
        System.out.println("Lift " + name + ": doors closing");
    }

    public void emergencyHalt() {
        System.out.println("EMERGENCY: Lift " + name + " halted at floor " + floor);
        this.status = LiftStatus.WAITING;
        this.doorOpen = true;
    }
}
