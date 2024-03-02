package model;


import utility.observer.javaobserver.NamedPropertyChangeSubject;

import java.util.ArrayList;

public interface Model extends NamedPropertyChangeSubject
{

//    void reserveVinyl(String name, int id);
//
//    void borrowVinyl(String name, int id);


    ArrayList<Vinyl> getAllVinyls();
    Vinyl getVinyl(int number);
    void addVinyl(Vinyl vinyl);
    Vinyl removeVinyl(int number);


//    public void reserveVinyl(Vinyl vinyl);
//    public void borrowVinyl(Vinyl vinyl);
//    public void returnVinyl(Vinyl vinyl);
//    public void removeVinyl(Vinyl vinyl);
}
