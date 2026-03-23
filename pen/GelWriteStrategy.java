package pen;

public class GelWriteStrategy implements WriteStrategy {
    @Override
    public void write() {
        System.out.println("Writing with smooth gel ink.");
    }
}
