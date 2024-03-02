package view;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import viewmodel.BorrowViewModel;


public class BorrowViewController {
    private BorrowViewModel model;
    private Region root;
    private ViewHandler viewHandler;

    @FXML
    private TextField nameLabel;
    @FXML private Label reserveName;
    @FXML private Label borrowName;
    @FXML private Button reserveBtn;

    public BorrowViewController() {
    }

    public void init(ViewHandler viewHandler, BorrowViewModel model, Region root) {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;

        nameLabel.textProperty().bindBidirectional(model.getNameLabel());
        reserveName.textProperty().bindBidirectional(model.getReserveLabel());
        borrowName.textProperty().bindBidirectional(model.getReserveLabel());
    }

    public void reset() {
        nameLabel.setText("");
    }

    public Region getRoot() {
        return root;
    }

    public void closeBtn() {
        viewHandler.openView("library");
        reset();
    }

    public void reserveBtn() {
        if(reserveName.getText().equals("")) {
            reserveName.setText(nameLabel.getText());
            model.reserve();
            reserveBtn.setDisable(true);
            reset();
        }
    }

    public void borrowBtn() {

    }

    public void returnBtn() {

    }
}
