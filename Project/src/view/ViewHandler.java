package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewmodel.ViewModelFactory;

public class ViewHandler
{
    private Scene currentScene;
    private Stage primaryStage;
    private ViewModelFactory viewModelFactory;
    private LibraryViewController libraryViewController;
    private BorrowViewController borrowViewController;

    public ViewHandler(ViewModelFactory viewModelFactory)
    {
        this.viewModelFactory = viewModelFactory;
        currentScene = new Scene(new Region());
    }

    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        openView("borrow");
    }

    public void openView(String id)
    {
        Region root = null;
        switch (id)
        {
            case "library":
                root = loadLibraryView("libraryFXML.fxml");
                break;
            case "borrow":
                root = loadBorrowView("borrowFXML.fxml");
                break;
        }
        currentScene.setRoot(root);
        String title = "";
        if (root.getUserData() != null)
        {
            title += root.getUserData();
        }
        primaryStage.setTitle(title);
        primaryStage.setScene(currentScene);
        primaryStage.setWidth(root.getPrefWidth());
        primaryStage.setHeight(root.getPrefHeight());
        primaryStage.show();
    }

    public void closeView()
    {
        primaryStage.close();
    }

    private Region loadLibraryView(String fxmlFile)
    {
        if (libraryViewController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                libraryViewController = loader.getController();
                libraryViewController.init(this, viewModelFactory.getLibraryViewModel(), root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            libraryViewController.reset();
        }
        return libraryViewController.getRoot();
    }
    private Region loadBorrowView(String fxmlFile) {
        if (borrowViewController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                borrowViewController = loader.getController();
                borrowViewController.init(this, viewModelFactory.getBorrowViewModel(), root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            borrowViewController.reset();
        }
        return borrowViewController.getRoot();
    }
}