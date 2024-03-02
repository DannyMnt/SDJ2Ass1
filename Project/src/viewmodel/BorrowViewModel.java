package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Model;

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

    public void reserve(){
        System.out.println("test");
        model.reserveVinyl(nameLabel, id);
    }
}
