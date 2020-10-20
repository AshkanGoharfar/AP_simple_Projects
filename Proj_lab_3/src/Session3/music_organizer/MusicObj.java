package Session3.music_organizer;

public class MusicObj {
    private String MusicName;
    private String artist;
    private String releasedDate;

    public MusicObj(String MusicName, String artist, String releasedDate) {
        this.MusicName = MusicName;
        this.artist = artist;
        this.releasedDate = releasedDate;
    }

    /**
     * Return the music name.
     *
     * @return MusicName name of the music.
     */
    public String getMusicName() {
        return MusicName;
    }

    /**
     * Set name of the music.
     */
    public void setMusicName(String MusicName) {
        this.MusicName = MusicName;
    }

    /**
     * Return the artis.
     *
     * @return artist.
     */
    public String getartist() {
        return artist;
    }

    /**
     * set the artist.
     */
    public void setartist(String artist) {
        this.artist = artist;
    }

    /**
     * Return released day.
     *
     * @return releasedDay.
     */
    public String getreleasedDate() {
        return releasedDate;
    }

    /**
     * Set released day.
     */
    public void setreleasedDate(String releasedDate) {
        this.releasedDate = releasedDate;
    }

    /**
     * We need to overwrite the String method because we are going to use this method in a different way.
     *
     * @return The number of files in the collection.
     */
    @Override
    public String toString() {
        return "Music{" +
                "MusicName='" + MusicName + '\'' +
                ", artist='" + artist + '\'' +
                ", releasedDate='" + releasedDate + '\'' +
                '}';
    }
}
