package model;


import utility.observer.javaobserver.UnnamedPropertyChangeSubject;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class ModelManager implements Model, UnnamedPropertyChangeSubject {
    private PropertyChangeSupport propertyChangeSupport;
    private VinylList vinylList;

    public ModelManager(){
        this.propertyChangeSupport = new PropertyChangeSupport(this);
        vinylList = new VinylList();
        createDummyData();
    }
    @Override
    public void addListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    private void createDummyData(){
        vinylList.addVinyl(new Vinyl("fwefwe", "Billie Ellish", "2000", "1"));
        vinylList.addVinyl(new Vinyl("fwefwe", "Billie Ellish", "2000", "1"));
        vinylList.addVinyl(new Vinyl("fwefwe", "Billie Ellish", "2000", "1"));
        vinylList.addVinyl(new Vinyl("fwefwe", "Billie Ellish", "2000", "1"));
        vinylList.addVinyl(new Vinyl("fwefwe", "Billie Ellish", "2000", "1"));
        vinylList.addVinyl(new Vinyl("fwefwe", "Billie Ellish", "2000", "1"));
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener( listener);
    }

    @Override
    public ArrayList<Vinyl> getAllVinyls() {
        return vinylList.getVinyls();
    }

    @Override
    public Vinyl getVinyl(int number) {
        return vinylList.getVinyl(number);
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
