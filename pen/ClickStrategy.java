package pen;

public class ClickStrategy implements OpenCloseStrategy {
    @Override
    public void open() {
        System.out.println("Clicking the button to open.");
    }

    @Override
    public void close() {
        System.out.println("Clicking the button to close.");
    }
}
