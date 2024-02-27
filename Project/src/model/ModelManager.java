package model;

import utility.observer.javaobserver.NamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManager implements Model, NamedPropertyChangeSubject {
    private PropertyChangeSupport propertyChangeSupport;

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
}
