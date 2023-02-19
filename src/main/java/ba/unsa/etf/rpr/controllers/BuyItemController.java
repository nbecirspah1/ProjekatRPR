package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.exceptions.ProjekatException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class BuyItemController {
    public SplitPane splitPaneID;

    @FXML
    public void initialize(){

        splitPaneID.getItems().add(ShopController.vBox);
    }


}
