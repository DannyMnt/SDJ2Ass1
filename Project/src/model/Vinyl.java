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

}
