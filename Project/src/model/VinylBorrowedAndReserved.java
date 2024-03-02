package model;

public class VinylBorrowedAndReserved extends State{

    public VinylBorrowedAndReserved(){

    }


    @Override
    public void toReserved(Vinyl vinyl){
        vinyl.setState(new VinylReserved());
    }

    @Override
    public String status() {
        return "borrowedAndReserved";
    }
}
