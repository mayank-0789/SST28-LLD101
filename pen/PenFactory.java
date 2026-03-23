package pen;

public class PenFactory {
    public static Pen createPen(PenType type, String color, MechanismType mechanism) {
        WriteStrategy writeStrategy;
        RefillStrategy refillStrategy;

        switch (type) {
            case BALLPOINT:
                writeStrategy = new BallpointWriteStrategy();
                refillStrategy = new TubeRefillStrategy();
                break;
            case GEL:
                writeStrategy = new GelWriteStrategy();
                refillStrategy = new TubeRefillStrategy();
                break;
            case INK:
                writeStrategy = new InkWriteStrategy();
                refillStrategy = new BottleRefillStrategy();
                break;
            case MARKER:
                writeStrategy = new MarkerWriteStrategy();
                refillStrategy = new TubeRefillStrategy();
                break;
            default:
                throw new IllegalArgumentException("Unsupported pen type: " + type);
        }

        OpenCloseStrategy openCloseStrategy;
        switch (mechanism) {
            case CAP:
                openCloseStrategy = new CapStrategy();
                break;
            case CLICK:
                openCloseStrategy = new ClickStrategy();
                break;
            default:
                throw new IllegalArgumentException("Unsupported mechanism: " + mechanism);
        }

        return new Pen(color, writeStrategy, refillStrategy, openCloseStrategy);
    }
}
