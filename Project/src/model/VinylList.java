package model;

import java.util.ArrayList;

public class VinylList {
    private ArrayList<Vinyl> vinyls;

    public VinylList(){
        this.vinyls = new ArrayList<Vinyl>();
    }

    public VinylList(ArrayList<Vinyl> vinyls){
        this.vinyls = vinyls;
    }

    public ArrayList<Vinyl> getVinyls() {
        return vinyls;
    }

    public void addVinyl(Vinyl vinyl){
        this.vinyls.add(vinyl);
    }

    public void removeVinyl(Vinyl vinyl){
        this.vinyls.remove(vinyl);
    }

    public void removeVinyl(int index){
        this.vinyls.remove(index);
    }
}
