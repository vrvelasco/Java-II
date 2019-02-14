package remijan.m.class2.example;

public class Sales {
    protected Integer id;
    protected String genre;
    protected String artist;
    protected Integer downloadCount;
    protected Double pricePerDownload;

    public Sales(Integer id, String genre, String artist, Integer downloadCount, Double pricePerDownload) {
        this.id = id;
        this.genre = genre;
        this.artist = artist;
        this.downloadCount = downloadCount;
        this.pricePerDownload = pricePerDownload;
    }

    public Integer getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public String getArtist() {
        return artist;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public Double getPricePerDownload() {
        return pricePerDownload;
    }
    
    
}
