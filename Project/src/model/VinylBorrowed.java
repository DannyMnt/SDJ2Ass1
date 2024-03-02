package model;

public class VinylBorrowed extends State{
    public VinylBorrowed(){

    }

    @Override
    public void toAvailable(StateContext context) {
        context.setState(new VinylAvailable());
    }

    @Override
    public void toBorrowedAndReserved(StateContext context){
        context.setState(new VinylBorrowedAndReserved());
    }

    @Override
    public String status() {
        return "borrowed";
    }
}
