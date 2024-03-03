package model;

public class VinylAvailable extends State {
    @Override
    public String getVinylStateName() {
        return "Available";
    }

    @Override
    public void toBorrowed(Vinyl vinyl) {
        vinyl.setVinylState(new VinylBorrowed());
    }

    @Override
    public void toReserved(Vinyl vinyl){
        vinyl.setVinylState(new VinylReserved());
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
