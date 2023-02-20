package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ONamaController {
    public void onBackClick(ActionEvent actionEvent) throws IOException {
        Parent newRoot = FXMLLoader.load(getClass().getResource("/fxml/shop.fxml"));

        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setTitle("Shop");
        Image icon = new Image(getClass().getResourceAsStream("/img/logo.jpg"));
        stage.getIcons().add(icon);
        Scene currentScene = stage.getScene();
        currentScene.setRoot(newRoot);
    }

    public void onFbButtonClick(ActionEvent actionEvent) throws IOException, URISyntaxException {
        URI uri = new URI("https://c2.etf.unsa.ba/course/index.php?categoryid=20");

        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();

            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(uri);
            }
        }
    }

    public void onIgButtonClick(ActionEvent actionEvent) throws IOException, URISyntaxException {
        URI uri = new URI("https://zamger.etf.unsa.ba/");

        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();

            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                desktop.browse(uri);
            }
        }
    }
}
