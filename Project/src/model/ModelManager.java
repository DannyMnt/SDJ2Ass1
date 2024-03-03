package model;


import utility.observer.javaobserver.UnnamedPropertyChangeSubject;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.UUID;

public class ModelManager implements Model, UnnamedPropertyChangeSubject {
    private PropertyChangeSupport propertyChangeSupport;
    private VinylList vinylList;

    public ModelManager(ArrayList<Vinyl> vinyls){
        this.propertyChangeSupport = new PropertyChangeSupport(this);
        vinylList = new VinylList();
        createDummyData(vinyls);
    }
    @Override
    public void addListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    private void createDummyData(ArrayList<Vinyl> vinyls){
        for(Vinyl v : vinyls){
            vinylList.addVinyl(v);
        }
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
    public Vinyl getVinyl(UUID id) {
        return vinylList.getVinyl(id);
    }

    @Override
    public void addVinyl(Vinyl vinyl) {

    }

    @Override
    public Vinyl removeVinyl(int number) {
        return null;
    }

    @Override
    public void changeState(String oldState, String state, UUID uuid) {

        Vinyl vinyl = vinylList.getVinyl(uuid);
        switch (state) {
            case "reserve":
                propertyChangeSupport.firePropertyChange("reserve", oldState, state);
                break;
            case "borrow":
                propertyChangeSupport.firePropertyChange("borrow", oldState, state);
                break;
            case "return":
                propertyChangeSupport.firePropertyChange("return", oldState, state);
                break;
            case "remove":
                propertyChangeSupport.firePropertyChange("remove", oldState, state);
                break;

        }
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
