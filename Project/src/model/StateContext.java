package model;

public class StateContext {

    private State currentState;
    private boolean isRemoved;
    public StateContext(){
        this.currentState = new VinylAvailable();
        this.isRemoved = false;
    }

    public void toAvailable(StateContext context){
        currentState.toAvailable(this);
    }
    public  void toReserved(StateContext context){
        currentState.toReserved(this);
    }

    public  void toBorrowed(StateContext context){
        currentState.toBorrowed(this);
    }

    public  void toBorrowedAndReserved(StateContext context){
        currentState.toBorrowedAndReserved(this);
    }
    public  void toRemoved(StateContext context){
        currentState.toRemoved(this);
    }

    public void setState(State state){
        this.currentState = state;
    }

    public void setRemoved() {
        this.isRemoved = false;
    }
}
