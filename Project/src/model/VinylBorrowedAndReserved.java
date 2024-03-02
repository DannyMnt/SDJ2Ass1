package model;

public class VinylBorrowedAndReserved extends State{

    public VinylBorrowedAndReserved(){

    }


    @Override
    public void toReserved(StateContext context){
        context.setState(new VinylReserved());
    }

    @Override
    public String status() {
        return "borrowedAndReserved";
    }
}
