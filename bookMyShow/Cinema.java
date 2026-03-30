import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private String cinemaId;
    private String label;
    private String location;
    private List<Hall> halls;

    public Cinema(String cinemaId, String label, String location) {
        this.cinemaId = cinemaId;
        this.label = label;
        this.location = location;
        this.halls = new ArrayList<>();
    }

    public void addHall(Hall hall) { halls.add(hall); }
    public String getLabel() { return label; }
    public String getLocation() { return location; }
}
