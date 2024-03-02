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
    @FXML private Button borrowBtn;
    @FXML private Button returnBtn;
    @FXML private Button removeBtn;

    public BorrowViewController() {
    }

    public void init(ViewHandler viewHandler, BorrowViewModel model, Region root) {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;

        nameLabel.textProperty().bindBidirectional(model.getNameLabel());
        reserveName.textProperty().bindBidirectional(model.getReserveLabel());
        borrowName.textProperty().bindBidirectional(model.getBorrowLabel());
    }

    public void reset() {
        nameLabel.setText(null);
    }

    public Region getRoot() {
        return root;
    }

    public void closeBtn() {
        viewHandler.openView("library");
        reset();
    }

    public void reserveBtn() {
        reserveName.setText(nameLabel.getText());
        reserveBtn.setDisable(true);
        model.reserveVinyl();
        reset();
    }

    public void borrowBtn() {
        if(nameLabel.getText().equals(reserveName.getText())) {
            borrowBtn.setDisable(true);
            reserveBtn.setDisable(false);
            returnBtn.setDisable(false);
            borrowName.setText(reserveName.getText());
            reserveName.setText(null);
            reset();
        }
    }

    public void returnBtn() {
        if(nameLabel.getText().equals(borrowName.getText())) {
            returnBtn.setDisable(true);
            borrowName.setText(null);
            borrowBtn.setDisable(false);
            reset();
        }
    }

    public void removeBtn() {
        removeBtn.setDisable(true);
        reserveBtn.setDisable(true);
        if(reserveName.getText() == null)
            borrowBtn.setDisable(true);
    }
}
