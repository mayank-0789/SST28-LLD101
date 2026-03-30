import java.util.List;

public class Screening {
    private String screeningId;
    private Film film;
    private Hall hall;
    private long startTime;
    private List<ScreeningChair> chairs;

    public Screening(String screeningId, Film film, Hall hall, long startTime, List<ScreeningChair> chairs) {
        this.screeningId = screeningId;
        this.film = film;
        this.hall = hall;
        this.startTime = startTime;
        this.chairs = chairs;
    }

    public String getScreeningId() { return screeningId; }
    public Film getFilm() { return film; }
    public List<ScreeningChair> getChairs() { return chairs; }
}
