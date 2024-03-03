package viewmodel;

import javafx.beans.property.*;
import model.Vinyl;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ManageVinylViewModel implements PropertyChangeListener {
    private ViewModelState viewModelState;
    private StringProperty errorProperty;
    private StringProperty headerProperty;


    private StringProperty numberProperty;
    private StringProperty titleProperty;
    private StringProperty artistProperty;
    private StringProperty yearProperty;
    private StringProperty stateProperty;
    private StringProperty nameProperty;



    private Model model;

    public ManageVinylViewModel(Model model, ViewModelState viewModelState)
    {
        this.model = model;
        this.viewModelState = viewModelState;
        errorProperty = new SimpleStringProperty();
        headerProperty = new SimpleStringProperty("Change vinyl");
        titleProperty = new SimpleStringProperty();
        artistProperty = new SimpleStringProperty();
        yearProperty = new SimpleStringProperty();
        stateProperty = new SimpleStringProperty();
        numberProperty = new SimpleStringProperty();
        model.addListener(this);
    }

    public void reset()
    {
        errorProperty.set(null);
        Vinyl vinyl = model.getVinyl(viewModelState.getId());
        titleProperty.set(vinyl.getTitle());
        artistProperty.set(vinyl.getArtist());
        yearProperty.set(vinyl.getYear());
        stateProperty.set(vinyl.getVinylState().status());

        if(viewModelState.getState().equals("reserved")){

        } else if(viewModelState.getState().equals("borrowed")){

        } else{

        }

    }


    public StringProperty getErrorProperty() {
        return errorProperty;
    }



    public StringProperty getHeaderProperty() {
        return headerProperty;
    }



    public StringProperty getNumberProperty() {
        return numberProperty;
    }



    public StringProperty getTitleProperty() {
        return titleProperty;
    }


    public StringProperty getArtistProperty() {
        return artistProperty;
    }


    public StringProperty getYearProperty() {
        return yearProperty;
    }



    public StringProperty getStateProperty() {
        return stateProperty;
    }

    public StringProperty getNameProperty() {
        return nameProperty;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("state")){
            String newState = (String) evt.getNewValue();
            stateProperty.set(newState);
        }
    }
}
