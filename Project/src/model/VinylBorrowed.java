package model;

public class VinylBorrowed extends State{

    @Override
    public String getVinylStateName() {
        return "Borrowed";
    }

    @Override
    public void toReturn(Vinyl vinyl) {
        vinyl.setVinylState(new VinylAvailable());
    }

    @Override
    public void toReserve(Vinyl vinyl){
        vinyl.setVinylState(new VinylBorrowedAndReserved());
    }

    @Override
    public String status() {
        return "borrowed";
    }
}
