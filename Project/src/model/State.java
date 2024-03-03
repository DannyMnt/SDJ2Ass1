package model;

public abstract class State {
    public abstract String getVinylStateName();
    public void toReturn(Vinyl vinyl) {

    }

    public void toReserve(Vinyl vinyl) {

    }

    public void toBorrow(Vinyl vinyl) {

    }

    public void toRemove(Vinyl vinyl) {

    }

    public abstract String status();
}
