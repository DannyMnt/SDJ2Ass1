package model;


import utility.observer.javaobserver.UnnamedPropertyChangeSubject;

import java.util.ArrayList;
import java.util.UUID;

public interface Model extends UnnamedPropertyChangeSubject
{

//    void reserveVinyl(String name, int id);
//
//    void borrowVinyl(String name, int id);


    ArrayList<Vinyl> getAllVinyls();
    Vinyl getVinyl(UUID id);
    void addVinyl(Vinyl vinyl);
    Vinyl removeVinyl(int number);

    public void changeState(String state, UUID uuid);


//    public void reserveVinyl(Vinyl vinyl);
//    public void borrowVinyl(Vinyl vinyl);
//    public void returnVinyl(Vinyl vinyl);
//    public void removeVinyl(Vinyl vinyl);
}
