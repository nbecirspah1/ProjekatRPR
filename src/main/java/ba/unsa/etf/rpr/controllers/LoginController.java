package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.KupacManager;
import ba.unsa.etf.rpr.business.SessionManager;
import ba.unsa.etf.rpr.domain.Kupac;
import ba.unsa.etf.rpr.exceptions.ProjekatException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class LoginController {

    public TextField passwordID;
    public Button buttonID;
    public TextField emailID;

    private KupacManager manager = new KupacManager();



    public void onButtonClick(ActionEvent actionEvent) throws ProjekatException, IOException {
        String email = emailID.getText();
        String password = passwordID.getText();
        List<Kupac> kupac = manager.searchByEmail(email);
        if(kupac.isEmpty()){
            new Alert(Alert.AlertType.NONE, "Ne postoji account sa ovim emailom!", ButtonType.OK).show();

        }
        else if(!password.equals(kupac.get(0).getPassword())){
            new Alert(Alert.AlertType.NONE, "Šifra nije validna. Pokušajte ponovo.", ButtonType.OK).show();

        }
        else{
            SessionManager.getInstance().setKupacId(kupac.get(0).getId());
            Node node = (Node) actionEvent.getSource();
            Stage stageOld = (Stage) node.getScene().getWindow();
            stageOld.close();
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/shop.fxml"));
            stage.setTitle("Welcome!");
            Image icon = new Image(getClass().getResourceAsStream("/img/logo.jpg"));
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(true);
            stage.show();
        }
    }
}
