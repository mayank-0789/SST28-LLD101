package pen;

public class InkWriteStrategy implements WriteStrategy {
    @Override
    public void write() {
        System.out.println("Writing with fountain pen nib.");
    }
}
