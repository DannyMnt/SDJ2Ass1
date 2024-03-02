package model;

public class VinylAvailable extends State {

    public VinylAvailable(){

    }


    @Override
    public void toBorrowed(StateContext context) {
        context.setState(new VinylBorrowed());
    }

    @Override
    public void toReserved(StateContext context){
        context.setState(new VinylReserved());
    }

    @Override
    public void toRemoved(StateContext context){
        context.setRemoved();
    }

    @Override
    public String status() {
        return "available";
    }
}
