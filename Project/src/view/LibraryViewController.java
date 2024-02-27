package view;

import javafx.scene.layout.Region;
import viewmodel.LibraryViewModel;

public class LibraryViewController {
    private LibraryViewModel model;
    private Region root;
    private ViewHandler viewHandler;
    public LibraryViewController(){}

    public void init(ViewHandler viewHandler, LibraryViewModel model, Region root){
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
