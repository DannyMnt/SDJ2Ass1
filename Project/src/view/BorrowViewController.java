package view;

import javafx.scene.layout.Region;
import viewmodel.BorrowViewModel;
import viewmodel.LibraryViewModel;

public class BorrowViewController {
    private BorrowViewModel model;
    private Region root;
    private ViewHandler viewHandler;
    public BorrowViewController(){}

    public void init(ViewHandler viewHandler, BorrowViewModel model, Region root){
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;
    }

    public void reset(){

    }

    public Region getRoot() {
        return root;
    }
}
