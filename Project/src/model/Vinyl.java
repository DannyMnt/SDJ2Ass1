package model;

import java.beans.PropertyChangeSupport;
import java.util.UUID;

public class Vinyl {
    private String title;
    private String artist;
    private String year;
    private State vinylState;
    private String state = "Available";
    private boolean isRemoved;
    private UUID id;
    private PropertyChangeSupport propertyChangeSupport;
    public Vinyl(String title, String artist, String year){
        propertyChangeSupport = new PropertyChangeSupport(this);
        this.id = UUID.randomUUID();
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.isRemoved = false;
        setVinylState(new VinylAvailable());
    }


    public String getState() {
        return state;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getYear() {
        return year;
    }

    public boolean isRemoved() {
        return isRemoved;
    }

    public void setRemoved() {
        isRemoved = false;
    }

    public void setVinylState(State vinylState) {
        String oldState = String.valueOf(this.state);
        this.vinylState = vinylState;
        this.state = vinylState.getVinylStateName();
        propertyChangeSupport.firePropertyChange("state", oldState, this.state);
    }

    public State getVinylState() {
        return vinylState;
    }

    public synchronized void borrowVinyl(){
        vinylState.toBorrowed(this);
    }

    public synchronized void reserveVinyl(){
        vinylState.toReserved(this);
    }

    public synchronized void returnVinyl(){
        vinylState.toAvailable(this);
    }

    public synchronized void removeVinyl(){
        vinylState.toRemoved(this);
    }

    public synchronized void borrowAndReserveVinyl(){
        vinylState.toBorrowedAndReserved(this);
    }

    @Override public String toString()
    {
        return "Vinyl{" + "title='" + title + '\'' + ", artist='" + artist
            + '\'' + ", year=" + year + ", state=" + vinylState.status() + ", isRemoved="
            + isRemoved + '}';

    }
}
