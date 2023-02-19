package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class NotificationController {
    public void DAClick(ActionEvent actionEvent) throws IOException {
        Node node = (Node) actionEvent.getSource();
        Stage stageOld = (Stage) node.getScene().getWindow();
        stageOld.close();

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/uspjesnaKupovina.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Uspješna kupovina");
        Image icon = new Image(getClass().getResourceAsStream("/img/logo.jpg"));
        stage.getIcons().add(icon);
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();

    }

    public void NEClick(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage stageOld = (Stage) node.getScene().getWindow();
        stageOld.close();

    }
}
