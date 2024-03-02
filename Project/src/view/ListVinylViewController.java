package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import viewmodel.ListVinylViewModel;
import viewmodel.SimpleVinylViewModel;



public class ListVinylViewController {
    @FXML
    TableView<SimpleVinylViewModel> vinylsTable;

    @FXML
    TableColumn<SimpleVinylViewModel, String> numberColumn;

    @FXML
    TableColumn<SimpleVinylViewModel, String> titleColumn;

    @FXML
    TableColumn<SimpleVinylViewModel, String> artistColumn;
    @FXML
    TableColumn<SimpleVinylViewModel, String> yearColumn;
    @FXML  TableColumn<SimpleVinylViewModel, String> stateColumn;

    @FXML
    Label errorLabel;

    private ViewHandler viewHandler;

    private ListVinylViewModel viewModel;
    private Region root;

    public void init(ViewHandler viewHandler, ListVinylViewModel viewModel, Region root){
        this.viewHandler = viewHandler;
        this.viewModel = viewModel;
        this.root = root;

        numberColumn.setCellValueFactory(
                cellData -> cellData.getValue().getNumberPropertyProperty());
        titleColumn.setCellValueFactory(
                cellData -> cellData.getValue().getTitlePropertyProperty());
        artistColumn.setCellValueFactory(
                cellData -> cellData.getValue().getArtistPropertyProperty());
        yearColumn.setCellValueFactory(
                cellData -> cellData.getValue().getYearPropertyProperty());
        stateColumn.setCellValueFactory(
                cellData -> cellData.getValue().getStatePropertyProperty());




        vinylsTable.setItems(viewModel.getAll());

        vinylsTable.getSelectionModel().selectedItemProperty()
                .addListener((obs, oldVal, newVal) -> viewModel.setSelected(newVal));

        errorLabel.textProperty().bind(viewModel.getErrorProperty());
    }
    public void reset()
    {
        viewModel.clear();
        vinylsTable.getSelectionModel().clearSelection();
    }

    public Region getRoot()
    {
        return root;
    }

    @FXML private void open()
    {
        if(viewModel.open()){
        viewHandler.openView("manage");
        }

    }


}
