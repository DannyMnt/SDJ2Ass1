package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Model;
import model.Vinyl;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.UUID;

public class ListVinylViewModel implements PropertyChangeListener {
    private Model model;
    private ViewModelState viewModelState;

    private ObservableList<SimpleVinylViewModel> list;
    private ObjectProperty<SimpleVinylViewModel> selectedVinylProperty;
    private StringProperty errorProperty;

    public ListVinylViewModel(Model model, ViewModelState viewModelState)
    {
        this.model = model;
        this.model.addListener(this);
        this.viewModelState = viewModelState;
        selectedVinylProperty = new SimpleObjectProperty<>();
        errorProperty = new SimpleStringProperty();
        list = FXCollections.observableArrayList();
        loadFromModel();
    }


    public void clear()
    {
        errorProperty.set(null);
        loadFromModel();
    }

    private void loadFromModel()
    {
        list.clear();
        ArrayList<Vinyl> vinyls = model.getAllVinyls();
        for (int i = 0; i < vinyls.size(); i++)
        {
            list.add(new SimpleVinylViewModel(vinyls.get(i)));
        }
    }

    public boolean open()
    {
        if(selectedVinylProperty.get() == null){
            errorProperty.set("Not selected vinyl!");
            return false;
        }
        return true;
    }

    public ObservableList<SimpleVinylViewModel> getAll()
    {
        return list;
    }

    public void setSelected(SimpleVinylViewModel vinylVm)
    {
        if(vinylVm == null) return;
        selectedVinylProperty.set(vinylVm);
        viewModelState.setId(UUID.fromString(vinylVm.getNumberPropertyProperty().getValue()));
        viewModelState.setState(vinylVm.getStatePropertyProperty().getValue());
    }

    public StringProperty getErrorProperty()
    {
        return errorProperty;
    }



    @Override public void propertyChange(PropertyChangeEvent event)
    {
//        // Alternative: call loadFromModel to load all
//        Platform.runLater(() -> {
//            switch (event.getPropertyName())
//            {
//                case "Add":
//                    addSimpleExercise((Exercise) event.getNewValue());
//                    break;
//                case "Remove":
//                    removeSimpleExercise((String) event.getOldValue());
//                    break;
//                case "Edit":
//                    removeSimpleExercise((String) event.getOldValue());
//                    addSimpleExercise((Exercise) event.getNewValue());
//                    break;
//            }
//        });
    }
}

