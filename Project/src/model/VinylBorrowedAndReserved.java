package model;

public class VinylBorrowedAndReserved extends State{


    @Override
    public String getVinylStateName() {
        return "BorrowedAndReserved";
    }

    @Override
    public void toReserve(Vinyl vinyl){
        vinyl.setVinylState(new VinylReserved());
    }

    @Override
    public String status() {
        return "borrowedAndReserved";
    }
}
