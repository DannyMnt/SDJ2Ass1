package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewmodel.ViewModelFactory;

public class ViewHandler
{
    private ViewModelFactory viewModelFactory;
    private Stage primaryStage;
    private Scene currentScene;
    private ManageVinylViewController manageVinylViewController;
    private ListVinylViewController listExercisesViewController;

    public ViewHandler(ViewModelFactory viewModelFactory)
    {
        this.viewModelFactory = viewModelFactory;
    }

    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        this.currentScene = new Scene(new Region());
        openView("list");
    }

    public void openView(String id)
    {
        Region root = null;
        switch (id)
        {
            case "list":
                root = loadListView("ListVinylView.fxml");
                break;
            case "manage":
                root = loadManageView("ManageVinylView.fxml");
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

    private Region loadListView(String fxmlFile)
    {
        if (listExercisesViewController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                listExercisesViewController = loader.getController();
                listExercisesViewController
                        .init(this, viewModelFactory.getListVinylViewModel(), root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            listExercisesViewController.reset();
        }
        return listExercisesViewController.getRoot();
    }

    private Region loadManageView(String fxmlFile)
    {
        if (manageVinylViewController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                manageVinylViewController = loader.getController();
                manageVinylViewController
                        .init(this, viewModelFactory.getManageVinylViewModel(), root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            manageVinylViewController.reset();
        }
        return manageVinylViewController.getRoot();
    }
}
