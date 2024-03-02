package model;

public class VinylReserved extends State{



    @Override
    public void toBorrowed(Vinyl vinyl) {
        vinyl.setState(new VinylBorrowed());
    }

    @Override
    public String status() {
        return "reserved";
    }

}
