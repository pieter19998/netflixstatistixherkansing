package module;

public class Film
{
    private int filmId;
    private String filmName;
    private String language;
    private int ageGroup;
    private int runtime;
    private int recommended;

    public Film(int filmId, String filmName, String language, int ageGroup, int runtime, int recommended ) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.language = language;
        this.ageGroup = ageGroup;
        this.runtime = runtime;
        this.recommended = recommended;
    }

    public int getFilmId() {
        return filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public String getLanguage() {
        return language;
    }

    public int getAgeGroup() {
        return ageGroup;
    }

    public float getRuntime() {
        return runtime;
    }

    public int getRecommended() {
        return recommended;
    }

    @Override
    public String toString() {
        return
                "filmName= " + filmName + '\n' +
                "language= " + language + '\n' +
                "ageGroup= " + ageGroup + '\n' +
                "runtime= " + runtime + " minutes";
    }
}
