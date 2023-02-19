package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.KupacManager;
import ba.unsa.etf.rpr.business.SessionManager;
import ba.unsa.etf.rpr.domain.Kupac;
import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.ProjekatException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.management.Notification;
import java.io.IOException;
import java.time.Duration;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class BuyItemController {


    public HBox HBoxID;
    public VBox firstVBoxID;
    public VBox secondVBOXID;
    public Label imeField;
    public Label prezimeField;
    public Label adresaField;
    public Label brojTelField;
    public Label iznosLabel;
    public CheckBox checkBoxGotovina;
    public CheckBox checkBoxKartica;
    KupacManager manager = new KupacManager();
    @FXML
    public void initialize() throws ProjekatException {
        int id = SessionManager.getInstance().getKupacId();
        System.out.println("Ovo je id:" + id);
        System.out.println("Ovo je proizvod" + SessionManager.getInstance().getProizvod().getOpis());
        try{
            Kupac k = manager.getByID(id);
            imeField.setText(k.getName());
            prezimeField.setText(k.getSurname());
            adresaField.setText(k.getAdress());
            brojTelField.setText(k.getPhoneNumber());
            iznosLabel.setText(Double.toString(SessionManager.getInstance().getProizvod().getCijena()) + " KM");


        }catch(ProjekatException e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();

        }


    }
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


    public void onKarticaClicked(ActionEvent actionEvent) {
        if (checkBoxGotovina.isSelected()) {
            checkBoxGotovina.setSelected(false);
        }
    }

    public void onGotovinaClicked(ActionEvent actionEvent) {
        if (checkBoxKartica.isSelected()){
            checkBoxKartica.setSelected(false);
        }
    }

    public void onKupiClicked(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/uspjesnaKupovina.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Uspješna kupovina");
        Image icon = new Image(getClass().getResourceAsStream("/img/logo.jpg"));
        stage.getIcons().add(icon);
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();


    }
}
