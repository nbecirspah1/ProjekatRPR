package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.SessionManager;
import ba.unsa.etf.rpr.domain.Proizvod;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class BuyItemController {


    public HBox HBoxID;
    public VBox firstVBoxID;
    public VBox secondVBOXID;




    public void onBackClick(ActionEvent actionEvent) throws IOException {
        SessionManager.getInstance().setProizvod(null);
        Parent newRoot = FXMLLoader.load(getClass().getResource("/fxml/shop.fxml"));

        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setTitle("Buy item");
        Image icon = new Image(getClass().getResourceAsStream("/img/logo.jpg"));
        stage.getIcons().add(icon);
        Scene currentScene = stage.getScene();
        currentScene.setRoot(newRoot);
    }


}
