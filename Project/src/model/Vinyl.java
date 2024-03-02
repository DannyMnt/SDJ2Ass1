package model;

public class Vinyl {
    private String title;
    private String artist;
    private int year;

    private State state;

    private boolean isRemoved;


    public Vinyl(String title, String artist, int year){
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.state = new VinylAvailable();
        this.isRemoved = false;
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

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setRemoved() {
        isRemoved = false;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void borrowVinyl(){
        state.toBorrowed(this);
    }

    public void reserveVinyl(){
        state.toReserved(this);
    }

    public void returnVinyl(){
        state.toAvailable(this);
    }

    public void removeVinyl(){
        state.toRemoved(this);
    }

    public void toBorrowedAndReserved(){
        state.toBorrowedAndReserved(this);
    }
}
