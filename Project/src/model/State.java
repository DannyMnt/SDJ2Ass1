package model;

public abstract class State {
    public void toAvailable(StateContext context) {

    }

    public void toReserved(StateContext context) {

    }

    public void toBorrowed(StateContext context) {

    }

    public void toBorrowedAndReserved(StateContext context) {

    }

    public void toRemoved(StateContext context) {

    }

    public abstract String status();
}
