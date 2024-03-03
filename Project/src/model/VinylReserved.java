package model;

public class VinylReserved extends State{


    @Override
    public String getVinylStateName() {
        return "Reserved";
    }

    @Override
    public void toBorrowed(Vinyl vinyl) {
        vinyl.setVinylState(new VinylBorrowed());
    }

    @Override
    public String status() {
        return "reserved";
    }

}
