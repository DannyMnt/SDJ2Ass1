package viewmodel;

import javafx.application.Platform;
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
    private BooleanProperty reserveButton;
    private BooleanProperty borrowButton;
    private BooleanProperty returnButton;
    private BooleanProperty removeButton;
    private StringProperty reserveName;
    private StringProperty borrowName;
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
        reserveButton = new SimpleBooleanProperty(false);
        borrowButton = new SimpleBooleanProperty(false);
        returnButton = new SimpleBooleanProperty(true);
        removeButton = new SimpleBooleanProperty(false);
        reserveName = new SimpleStringProperty();
        borrowName = new SimpleStringProperty();
        nameProperty = new SimpleStringProperty();
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
        viewModelState.setState(vinyl.getVinylState().status());
//        nameProperty.set(null);
        refresh();
    }

    public void refresh(){
        if(viewModelState.getState().equals("reserved")){
            reserveButton.set(true);
            reserveName.setValue(nameProperty.getValue());
        } else if(viewModelState.getState().equals("borrowed")){
            if(nameProperty.getValue().equals(reserveName.getValue())){
                returnButton.set(false);
                reserveButton.set(false);
                borrowName.setValue(nameProperty.getValue());
                reserveName.setValue(null);
            }

        }
        else if(viewModelState.getState().equals("borrowedAndReserved")){
            reserveButton.set(true);
        }
        else if(viewModelState.getState().equals("removed")){
            reserveButton.set(true);
            if(reserveName.getValue() == null)
                borrowButton.set(true);
        }
    }

    public BooleanProperty getReserveButtonProperty(){
        return reserveButton;
    }

    public StringProperty getReserveNameProperty(){
        return reserveName;
    }

    public StringProperty getBorrowNameProperty(){
        return borrowName;
    }

    public BooleanProperty getBorrowButtonProperty(){
        return borrowButton;
    }

    public BooleanProperty getReturnButtonProperty(){
        return returnButton;
    }

    public BooleanProperty getRemoveButtonProperty(){
        return removeButton;
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
        Platform.runLater(()-> refresh());
    }

    public void changeStage(String state) {
        Vinyl vinyl = model.getVinyl(viewModelState.getId());
        String oldState = viewModelState.getState();
        switch (state){
            case "reserve":
                vinyl.reserveVinyl();
                model.changeState(oldState, state, viewModelState.getId());
                break;
            case "borrow":
                vinyl.borrowVinyl();
                model.changeState(oldState, state, viewModelState.getId());
                break;
            case "return":
                vinyl.returnVinyl();
                model.changeState(oldState, state, viewModelState.getId());
                break;
            case "remove":
                vinyl.removeVinyl();
                model.changeState(oldState, state, viewModelState.getId());
                break;
        }
    }
}
