package model;

public class VinylAvailable extends State {


    @Override
    public void toBorrowed(Vinyl vinyl) {
        vinyl.setState(new VinylBorrowed());
    }

    @Override
    public void toReserved(Vinyl vinyl){
        vinyl.setState(new VinylReserved());
    }

    @Override
    public void toRemoved(Vinyl vinyl){
        vinyl.setRemoved();
    }

    @Override
    public String status() {
        return "available";
    }
}
