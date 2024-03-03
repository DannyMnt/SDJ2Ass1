package model;

public abstract class State {
    public abstract String getVinylStateName();
    public void toAvailable(Vinyl vinyl) {

    }

    public void toReserved(Vinyl vinyl) {

    }

    public void toBorrowed(Vinyl vinyl) {

    }

    public void toBorrowedAndReserved(Vinyl vinyl) {

    }

    public void toRemoved(Vinyl vinyl) {

    }

    public abstract String status();
}
