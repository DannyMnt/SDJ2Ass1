package model;

public class VinylAvailable extends State {
    @Override
    public String getVinylStateName() {
        return "Available";
    }

    @Override
    public void toBorrow(Vinyl vinyl) {
        vinyl.setVinylState(new VinylBorrowed());
    }

    @Override
    public void toReserve(Vinyl vinyl){
        vinyl.setVinylState(new VinylReserved());
    }

    @Override
    public void toRemove(Vinyl vinyl){
        vinyl.setVinylState(new VinylRemoved());
    }

    @Override
    public String status() {
        return "available";
    }
}
