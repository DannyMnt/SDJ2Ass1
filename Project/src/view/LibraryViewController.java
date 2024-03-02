package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import viewmodel.LibraryViewModel;

public class LibraryViewController {
    private LibraryViewModel model;
    private Region root;
    private ViewHandler viewHandler;


    @FXML
    private GridPane gridPane;
    public LibraryViewController(){}

    public void init(ViewHandler viewHandler, LibraryViewModel model, Region root){
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;

        int numRows =2 ;
        int numCols =5;
        for (int row = 0; row < numRows; row++) {

            for (int col = 0; col < numCols; col++) {
                Label cell = new Label("Cell");

                // Add the cell to the GridPane
                gridPane.add(cell, col, row);

                // Add a listener to the cell
                cell.setOnMouseClicked(event -> {
                    System.out.println("Cell clicked!");
                });
            }
        }
    }

    public void reset(){

    }

    public Region getRoot() {
        return root;
    }
}
