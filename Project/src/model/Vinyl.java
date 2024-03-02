package model;

public class Vinyl {
    private String title;
    private String artist;
<<<<<<< Updated upstream
    private int year;

    private State state;

    private boolean isRemoved;
=======
    private String year;
    private StateContext context;
>>>>>>> Stashed changes

    private String number;
    private String state;


    public Vinyl(String title, String artist, String year, String number){
        this.number = number;
        this.title = title;
        this.artist = artist;
        this.year = year;
<<<<<<< Updated upstream
        this.state = new VinylAvailable();
        this.isRemoved = false;
    }

=======
        this.context = new StateContext();
        this.state = "Available";
    }


>>>>>>> Stashed changes
    public String getTitle() {
        return title;
    }

<<<<<<< Updated upstream

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
=======
    public String getArtist() {
        return artist;
    }
    public String getState() {
        return state;
    }

    public String getYear() {
        return year;
    }

    public String getNumber() {
        return number;
>>>>>>> Stashed changes
    }
}
