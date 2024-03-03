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
    private String reserveName;
    private String borrowName;
    public Vinyl(String title, String artist, String year){
        propertyChangeSupport = new PropertyChangeSupport(this);
        this.id = UUID.randomUUID();
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.isRemoved = false;
        setVinylState(new VinylAvailable());
    }

    public void setReserveName(String reserveName) {
        this.reserveName = reserveName;
    }

    public void setBorrowName(String borrowName) {
        this.borrowName = borrowName;
    }

    public String getReserveName() {
        return reserveName;
    }

    public String getBorrowName() {
        return borrowName;
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





    public void setVinylState(State vinylState) {
        if(!isRemoved){
            String oldState = String.valueOf(this.state);
            this.vinylState = vinylState;
            this.state = vinylState.getVinylStateName();
            propertyChangeSupport.firePropertyChange("state", oldState, this.state);
        }else{
            System.out.println("Cannot change state: vinyl is removed");
        }
    }

    public State getVinylState() {
        return vinylState;
    }

    public synchronized void borrowVinyl(){
        vinylState.toBorrow(this);
    }

    public synchronized void reserveVinyl(){
        vinylState.toReserve(this);
    }

    public synchronized void returnVinyl(){
        vinylState.toReturn(this);
    }

    public synchronized void removeVinyl(){
        vinylState.toRemove(this);
    }


    @Override public String toString()
    {
        return "Vinyl{" + "title='" + title + '\'' + ", artist='" + artist
            + '\'' + ", year=" + year + ", state=" + vinylState.status() + ", isRemoved="
            + isRemoved + '}';

    }
}
