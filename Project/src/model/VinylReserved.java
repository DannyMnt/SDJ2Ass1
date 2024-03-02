package model;

public class VinylReserved extends State{


    public VinylReserved(){

    }
    @Override
    public void toBorrowed(StateContext context) {
        context.setState(new VinylBorrowed());
    }

    @Override
    public String status() {
        return "reserved";
    }

}
