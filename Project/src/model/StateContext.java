package model;

public class StateContext {

    private State currentState;
    private boolean isRemoved;
    public StateContext(){
        this.currentState = new VinylAvailable();
        this.isRemoved = false;
    }

    public synchronized void toAvailable(StateContext context){
        currentState.toAvailable(this);
    }
    public synchronized void toReserved(StateContext context){
        currentState.toReserved(this);
    }

    public synchronized void toBorrowed(StateContext context){
        currentState.toBorrowed(this);
    }

    public synchronized void toBorrowedAndReserved(StateContext context){
        currentState.toBorrowedAndReserved(this);
    }
    public synchronized void toRemoved(StateContext context){
        currentState.toRemoved(this);
    }

    public synchronized void setState(State state){
        this.currentState = state;
    }

    public synchronized void setRemoved() {
        this.isRemoved = false;
    }
}
