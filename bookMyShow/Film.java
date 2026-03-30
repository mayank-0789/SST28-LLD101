public class Film {
    private String filmId;
    private String name;
    private String lang;

    public Film(String filmId, String name, String lang) {
        this.filmId = filmId;
        this.name = name;
        this.lang = lang;
    }

    public String getFilmId() { return filmId; }
    public String getName() { return name; }
}
