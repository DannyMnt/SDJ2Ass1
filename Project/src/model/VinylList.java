package model;

import java.util.ArrayList;

public class VinylList {
    private final ArrayList<Vinyl> vinyls;


    public VinylList(){
        this.vinyls = new ArrayList<Vinyl>();
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

    public Vinyl getVinyl(int index){
        return vinyls.get(index);
    }
}
