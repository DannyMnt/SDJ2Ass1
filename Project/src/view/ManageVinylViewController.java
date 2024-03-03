package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewmodel.ManageVinylViewModel;

public class ManageVinylViewController
{
    @FXML private Label headerLabel;
    @FXML private TextField titleLabel;
    @FXML private TextField artistLabel;
    @FXML private TextField yearLabel;

    @FXML private Label errorLabel;
    @FXML private TextField nameLabel;
    @FXML private Button cancelButton;
    @FXML private Label reserveName;
    @FXML private Label borrowName;
    @FXML private Button reserveButton;
    @FXML private Button borrowButton;
    @FXML private Button returnButton;
    @FXML private Button removeButton;


    private Region root;
    private ViewHandler viewHandler;
    private ManageVinylViewModel viewModel;
    public ManageVinylViewController(){}

    public void init(ViewHandler viewHandler, ManageVinylViewModel manageVinylViewModel, Region root)
    {
        this.viewHandler = viewHandler;
        this.viewModel = manageVinylViewModel;
        this.root = root;

        errorLabel.textProperty().bind(viewModel.getErrorProperty());
        headerLabel.textProperty().bind(viewModel.getHeaderProperty());
        titleLabel.textProperty().bind(viewModel.getTitleProperty());
        artistLabel.textProperty().bind(viewModel.getArtistProperty());
        yearLabel.textProperty().bind(viewModel.getYearProperty());

        reserveButton.disableProperty().bind(viewModel.getReserveButtonProperty());
        borrowButton.disableProperty().bind(viewModel.getBorrowButtonProperty());
        returnButton.disableProperty().bind(viewModel.getReturnButtonProperty());
        removeButton.disableProperty().bind(viewModel.getRemoveButtonProperty());
        reserveName.textProperty().bind(viewModel.getReserveNameProperty());
        borrowName.textProperty().bind(viewModel.getBorrowNameProperty());
        nameLabel.textProperty().bindBidirectional(viewModel.getNameProperty());

        reset();
    }
    public void reset()
    {
        viewModel.reset();
    }

    @FXML private void submitButton()
    {
//        boolean ok = viewModel.accept();
//        if (ok)
//            viewHandler.openView("list");
    }

    @FXML private void onCancel()
    {
        viewHandler.openView("list");
        reset();
    }

    public Region getRoot()
    {
        return root;
    }

    @FXML private void onEnter(ActionEvent actionEvent)
    {
//        if (actionEvent.getTarget() == sessionField)
//        {
//            numberField.requestFocus();
//        }
//        else if (actionEvent.getTarget() == numberField)
//        {
//            topicField.requestFocus();
//        }
//        else if (actionEvent.getTarget() == topicField)
//        {
//            submitButton.requestFocus();
//        }
    }

    @FXML public void onReserve(){
//        reserveName.setText(nameLabel.getText());
//        reserveButton.setDisable(true);
        viewModel.changeStage("reserve");
        reset();
    }
    @FXML public void onBorrow(){
        viewModel.changeStage("borrow");
        reset();

//        if(nameLabel.getText().equals(reserveName.getText())) {
//            borrowButton.setDisable(true);
//            reserveButton.setDisable(false);
//            returnButton.setDisable(false);
//            borrowName.setText(reserveName.getText());
//            reserveName.setText(null);
//            reset();
//        }
    }
    @FXML public void onReturn(){
//        if(nameLabel.getText().equals(borrowName.getText())) {
//            returnButton.setDisable(true);
//            borrowName.setText(null);
//            borrowButton.setDisable(false);
//            reset();
//        }

        viewModel.changeStage("return");
        reset();
    }
    @FXML public void onRemove(){
//        removeButton.setDisable(true);
//        reserveButton.setDisable(true);
//        if(reserveName.getText() == null)
//            borrowButton.setDisable(true);
        viewModel.changeStage("remove");
        reset();

    }
}
