package pen;

public class Main {
    public static void main(String[] args) {
        Pen myBallpointPen = PenFactory.createPen(PenType.BALLPOINT, "Blue", MechanismType.CLICK);
        Pen myFountainPen = PenFactory.createPen(PenType.INK, "Black", MechanismType.CAP);
        Pen myMarkerPen = PenFactory.createPen(PenType.MARKER, "Red", MechanismType.CAP);

        try {
            myBallpointPen.write();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();

        try {
            myBallpointPen.start();
            myBallpointPen.write();
            myBallpointPen.stop();

            System.out.println("---");

            myFountainPen.start();
            myFountainPen.write();
            myFountainPen.refill("Green");
            myFountainPen.write();
            myFountainPen.stop();

            System.out.println("---");

            myMarkerPen.start();
            myMarkerPen.write();
            myMarkerPen.stop();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
