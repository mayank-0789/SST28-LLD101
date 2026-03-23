package pen;

public class MarkerWriteStrategy implements WriteStrategy {
    @Override
    public void write() {
        System.out.println("Writing with thick marker tip.");
    }
}
