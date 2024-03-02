package viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Vinyl;

public class SimpleVinylViewModel {
    private StringProperty numberProperty;
    private StringProperty titleProperty;
    private StringProperty artistProperty;
    private StringProperty yearProperty;
    private StringProperty stateProperty;

    public SimpleVinylViewModel(Vinyl vinyl) {
        this.numberProperty = new SimpleStringProperty(vinyl.getNumber());
        this.titleProperty = new SimpleStringProperty(vinyl.getTitle());
        this.artistProperty = new SimpleStringProperty(vinyl.getArtist());
        this.yearProperty = new SimpleStringProperty(vinyl.getYear());
        this.stateProperty = new SimpleStringProperty(vinyl.getState());

        System.out.println(titleProperty.getValue());
    }



    public StringProperty getNumberPropertyProperty() {
        return numberProperty;
    }


    public StringProperty getTitlePropertyProperty() {
        return titleProperty;
    }



    public StringProperty getArtistPropertyProperty() {
        return artistProperty;
    }


    public StringProperty getYearPropertyProperty() {
        return yearProperty;
    }



    public StringProperty getStatePropertyProperty() {
        return stateProperty;
    }
}
