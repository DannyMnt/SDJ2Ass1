package model;

public class VinylRemoved extends State {
    @Override
    public String getVinylStateName() {
        return "Removed";
    }

    @Override
    public String status() {
        return "removed";
    }
}
