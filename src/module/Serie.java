package module;

public class Serie {

    private int serieId;
    private String serieName;
    private int amountOfSeasons;
    private int ageGroup;
    private String language;

    public Serie(String serieName, int amountOfSeasons, int ageGroup, String language, int serieId) {
        this.serieName = serieName;
        this.amountOfSeasons = amountOfSeasons;
        this.ageGroup = ageGroup;
        this.language = language;
        this.serieId = serieId;
    }

    public int getSerieId() {
        return serieId;
    }

    public void setSerieId(int serieId) {
        this.serieId = serieId;
    }

    public String getSerieName() {
        return serieName;
    }

    public void setSerieName(String serieName) {
        this.serieName = serieName;
    }

    public int getAmountOfSeasons() {
        return amountOfSeasons;
    }

    public void setAmountOfSeasons(int amountOfSeasons) {
        this.amountOfSeasons = amountOfSeasons;
    }

    public int getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(int ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return
                "serieName= " + serieName + "\n" +
                        "amountOfSeasons= " + amountOfSeasons + "\n" +
                        "ageGroup= " + ageGroup + "\n" +
                        "language= " + language;
    }
}
