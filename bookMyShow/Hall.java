public class Hall {
    private String hallId;
    private String hallName;
    private Cinema cinema;

    public Hall(String hallId, String hallName, Cinema cinema) {
        this.hallId = hallId;
        this.hallName = hallName;
        this.cinema = cinema;
    }

    public String getHallId() { return hallId; }
}
