package pen;

public class TubeRefillStrategy implements RefillStrategy {
    @Override
    public void refill() {
        System.out.println("Replacing the ink tube.");
    }
}
