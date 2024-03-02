package model;

public class Vinyl {
    private String title;
    private String artist;
    private int year;
    private StateContext context;


    public Vinyl(String title, String artist, int year){
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.context = new StateContext();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}
