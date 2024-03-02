package model;

import java.util.ArrayList;

public class VinylList
{
  private ArrayList<Vinyl> vinyls;

  public VinylList(ArrayList<Vinyl> vinyls)
  {
    this.vinyls = vinyls;
  }

  public ArrayList<Vinyl> getVinyls() {
    return vinyls;
  }


  public void addVinyl(Vinyl vinyl){
    vinyls.add(vinyl);
  }


  public void removeVinyl(Vinyl vinyl){
    vinyls.remove(vinyl);
  }

  public Vinyl getVinyl(int index){
    return vinyls.get(index);
  }
}
