package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.ProjekatException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class BuyItemController {


    public HBox HBoxID;
    public VBox firstVBoxID;
    public VBox secondVBOXID;

    private ShopController shopController;

    private Proizvod proizvod;

   /* public BuyItemController(ShopController shopController) {
        this.shopController = shopController;
    }

    @FXML
    public void initialize(){
        HBoxID.getChildren().addAll(shopController.getVBox());
    }*/

    public void onBackClick(ActionEvent actionEvent) throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("/fxml/shop.fxml"));

        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setTitle("Buy item");
        Image icon = new Image(getClass().getResourceAsStream("/img/logo.jpg"));
        stage.getIcons().add(icon);
        Scene currentScene = stage.getScene();
        currentScene.setRoot(newRoot);
    }

    public void setProizvodID(Proizvod proizvod) {
        this.proizvod = proizvod;
    }
}
