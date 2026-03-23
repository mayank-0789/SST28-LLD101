package pen;

public class Pen {
    private String color;
    private boolean isOpen;
    private WriteStrategy writeStrategy;
    private RefillStrategy refillStrategy;
    private OpenCloseStrategy openCloseStrategy;

    public Pen(String color, WriteStrategy writeStrategy, RefillStrategy refillStrategy, OpenCloseStrategy openCloseStrategy) {
        this.color = color;
        this.writeStrategy = writeStrategy;
        this.refillStrategy = refillStrategy;
        this.openCloseStrategy = openCloseStrategy;
        this.isOpen = false;
    }

    public void start() {
        openCloseStrategy.open();
        this.isOpen = true;
    }

    public void stop() {
        openCloseStrategy.close();
        this.isOpen = false;
    }

    public void write() throws Exception {
        if (!isOpen) {
            throw new Exception("Pen is closed. Call start() first.");
        }
        System.out.print("[" + color.toUpperCase() + "] ");
        writeStrategy.write();
    }

    public void refill(String newColor) {
        refillStrategy.refill();
        this.color = newColor;
        System.out.println("Ink color is now " + newColor + ".");
    }
}
