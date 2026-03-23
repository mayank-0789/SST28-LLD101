package pen;

public class BottleRefillStrategy implements RefillStrategy {
    @Override
    public void refill() {
        System.out.println("Refilling ink from the bottle.");
    }
}
