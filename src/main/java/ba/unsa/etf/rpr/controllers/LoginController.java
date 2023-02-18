package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.KupacManager;
import ba.unsa.etf.rpr.exceptions.ProjekatException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class LoginController {

    public TextField passwordID;
    public Button buttonID;
    public TextField emailID;

    private KupacManager manager = new KupacManager();



    public void onButtonClick(ActionEvent actionEvent) throws ProjekatException, IOException {
        String email = emailID.getText();
        String password = passwordID.getText();

        if(manager.searchByEmail(email).isEmpty()){
            new Alert(Alert.AlertType.NONE, "Ne postoji account sa ovim emailom!", ButtonType.OK).show();

        }
        else{
            Parent newRoot = FXMLLoader.load(getClass().getResource("/fxml/shop.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Online shop");
            Image icon = new Image(getClass().getResourceAsStream("/img/logo.jpg"));
            stage.getIcons().add(icon);
            Scene scene = new Scene(newRoot, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        }
    }
}
