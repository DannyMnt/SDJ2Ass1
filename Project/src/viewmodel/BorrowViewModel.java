package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;
import model.Vinyl;

public class BorrowViewModel {
    private Model model;
    private StringProperty nameLabel;
    private StringProperty reserveLabel;
    private StringProperty borrowLabel;
    public BorrowViewModel(Model model){
        this.model = model;
        this.nameLabel = new SimpleStringProperty();
        this.reserveLabel = new SimpleStringProperty();
        this.borrowLabel = new SimpleStringProperty();
    }

    public StringProperty getNameLabel() {
        return nameLabel;
    }

    public StringProperty getReserveLabel(){
        return reserveLabel;
    }

    public StringProperty getBorrowLabel(){
        return borrowLabel;
    }

    public void reserveVinyl(){
        System.out.println("test");
//        model.reserveVinyl(nameLabel, id);
    }

    public void borrowVinyl(){

    }

    public void returnVinyl(){

    }

    public void removeVinyl(){
        model.
    }
}
