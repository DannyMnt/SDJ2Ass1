package model;

public class VinylReserved extends State{


    public VinylReserved(){

    }
    @Override
    public void toBorrowed(Vinyl vinyl) {
        vinyl.setState(new VinylBorrowed());
    }

    @Override
    public String status() {
        return "reserved";
    }

}
