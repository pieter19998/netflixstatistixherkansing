package module;

public class Episode {
    private int episodeId;
    private int episodeNumber;
    private int seasonNumber;
    private  String  episodeName;
    private int runtime;


    public Episode(int episodeId, int episodeNumber, int seasonNumber, String episodeName, int runtime ) {
        this.episodeId = episodeId;
        this.episodeNumber = episodeNumber;
        this.seasonNumber = seasonNumber;
        this.episodeName = episodeName;
        this.runtime = runtime;
    }

    public int getEpisodeId() {
        return episodeId;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public float getRuntime() {
        return runtime;
    }

    @Override
    public String toString() {
        return
                "episodeId= " + episodeId + "\n" +
                "episodeNumber= " + episodeNumber + "\n" +
                "seasonNumber= " + seasonNumber + "\n" +
                "episodeName= " + episodeName + "\n" +
                "runtime= " + runtime;
    }
}
