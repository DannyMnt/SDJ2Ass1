package model;

import utility.observer.javaobserver.NamedPropertyChangeSubject;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ModelManager implements Model, NamedPropertyChangeSubject {
    private PropertyChangeSupport propertyChangeSupport;
    private VinylList vinylList;

    public ModelManager(){
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }
    @Override
    public void addListener(String propertyName, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    @Override
    public void removeListener(String propertyName, PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
    }

    @Override
    public ArrayList<Vinyl> getAllVinyls() {
        return null;
    }

    @Override
    public Vinyl getVinyl(int number) {
        return null;
    }

    @Override
    public void addVinyl(Vinyl vinyl) {

    }

    @Override
    public Vinyl removeVinyl(int number) {
        return null;
    }


//    @Override
//    public void reserveVinyl(String name, int id) {
//        vinylList.getVinyl(id).setReserveName(name);
//    }
//
//    @Override
//    public void borrowVinyl(String name, int id) {
//        vinylList.getVinyl(id).setBorrowName(name);
//    }

//
//    @Override
//    public void reserveVinyl(Vinyl vinyl) {
//
//    }
//
//    @Override
//    public void borrowVinyl(Vinyl vinyl) {
//
//    }
//
//    @Override
//    public void returnVinyl(Vinyl vinyl) {
//
//    }
//
//    @Override
//    public void removeVinyl(Vinyl vinyl) {
//
//    }
}
