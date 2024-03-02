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

    public synchronized void borrowVinyl(){
        state.toBorrowed(this);
    }

    public synchronized void reserveVinyl(){
        state.toReserved(this);
    }

    public synchronized void returnVinyl(){
        state.toAvailable(this);
    }

    public synchronized void removeVinyl(){
        state.toRemoved(this);
    }

    public synchronized void borrowAndReserveVinyl(){
        state.toBorrowedAndReserved(this);
    }

    @Override public String toString()
    {
        return "Vinyl{" + "title='" + title + '\'' + ", artist='" + artist
            + '\'' + ", year=" + year + ", state=" + state.status() + ", isRemoved="
            + isRemoved + '}';
    }
}
