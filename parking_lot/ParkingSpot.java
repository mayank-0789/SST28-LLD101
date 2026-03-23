package parking_lot;

public class ParkingSpot {
    private String id;
    private SlotType type;
    private boolean occupied;
    private int floor;
    private double x, y;

    public ParkingSpot(String id, SlotType type, int floor, double x, double y) {
        this.id = id;
        this.type = type;
        this.floor = floor;
        this.x = x;
        this.y = y;
        this.occupied = false;
    }

    public String getId() { return id; }
    public SlotType getType() { return type; }
    public boolean isOccupied() { return occupied; }
    public void occupy() { this.occupied = true; }
    public void vacate() { this.occupied = false; }
    public int getFloor() { return floor; }

    public double distanceFrom(Gate gate) {
        double dx = this.x - gate.getX();
        double dy = this.y - gate.getY();
        double dz = (this.floor - gate.getFloor()) * 10.0;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}
