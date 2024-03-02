package model;

import java.util.ArrayList;
import java.util.UUID;

public class VinylList {
    private final ArrayList<Vinyl> vinyls;


    public VinylList(){
        this.vinyls = new ArrayList<>();
    }


    public ArrayList<Vinyl> getVinyls(){
        return vinyls;
    }

    public void addVinyl(Vinyl vinyl){
        vinyls.add(vinyl);
    }

    public void removeVinyl(int index){
        vinyls.remove(index);
    }

    public Vinyl getVinyl(UUID id){
        return vinyls.stream().filter(vinyl -> vinyl.getId().equals(id)).findFirst().orElse(null);
    }
}
