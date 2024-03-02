package model;

public class VinylBorrowed extends State{
    public VinylBorrowed(){

    }

    @Override
    public void toAvailable(Vinyl vinyl) {
        vinyl.setState(new VinylAvailable());
    }

    @Override
    public void toBorrowedAndReserved(Vinyl vinyl){
        vinyl.setState(new VinylBorrowedAndReserved());
    }

    @Override
    public String status() {
        return "borrowed";
    }
}
