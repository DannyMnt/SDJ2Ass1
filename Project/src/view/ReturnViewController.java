package view;

import javafx.scene.layout.Region;
import viewmodel.LibraryViewModel;
import viewmodel.ReturnViewModel;

public class ReturnViewController {
    private ReturnViewModel model;
    private Region root;
    private ViewHandler viewHandler;
    public ReturnViewController(){}

    public void init(ViewHandler viewHandler, ReturnViewModel model, Region root){
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
