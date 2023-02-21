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
import javafx.scene.control.*;
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
    public Button buyButton;
    public Label errorLabel;
    public ChoiceBox choiceBoxID;

    private String[] velicine = { "XS", "S", "M", "L", "XL", "XXL"};

    KupacManager manager = new KupacManager();
    private int i=0;

    /**
     * initialize metoda
     * @throws ProjekatException
     */
    @FXML
    public void initialize() throws ProjekatException {
        errorLabel.setText("");
        choiceBoxID.getItems().addAll(velicine);

        /**
         * setOnAction metoda za choiceBoxID, pomocu settera za atribut velicina u
         * SessionManager klasu postavljamo vrijednost atributa velicina na izabranu vrijednost
         */
        choiceBoxID.setOnAction(event -> {
            errorLabel.setText("");
            String velicina = choiceBoxID.getValue().toString();
            SessionManager.getInstance().setVelicina(velicina);
        });


        int id = SessionManager.getInstance().getKupacId();
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

    /**
     * onBackCLick metoda koja se poziva kada kliknemo na dugme za
     * povratak na prethodni prozor
     * @param actionEvent
     * @throws IOException
     */
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

    /**
     * onAction metoda ukoliko odaberemo karticni nacin placanja
     * @param actionEvent
     */
    public void onKarticaClicked(ActionEvent actionEvent) {
        if (checkBoxGotovina.isSelected()) {
            checkBoxGotovina.setSelected(false);
        }
        errorLabel.setText("");
        SessionManager.getInstance().setNacinPlacanja("karticno placanje");
    }

    /**
     *onAction metoda ukoliko odaberemo gotovinski nacin placanja
     * @param actionEvent
     */
    public void onGotovinaClicked(ActionEvent actionEvent) {
        if (checkBoxKartica.isSelected()){
            checkBoxKartica.setSelected(false);
        }
        errorLabel.setText("");
        SessionManager.getInstance().setNacinPlacanja("gotovina");


    }


    public void onKupiClicked(ActionEvent actionEvent) throws IOException {
        if(!checkBoxKartica.isSelected() && !checkBoxGotovina.isSelected()){
            if(errorLabel.getText() == ""){
                errorLabel.setText("Niste odabrali način plaćanja");
            }
        }
        else if(choiceBoxID.getValue() == null){
            errorLabel.setText("Niste odabrali veličinu");
        }
        else{

            Parent root = FXMLLoader.load(getClass().getResource("/fxml/notification.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Uspješna kupovina");
            Image icon = new Image(getClass().getResourceAsStream("/img/logo.jpg"));
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
            stage.setResizable(false);
            stage.show();

        }


    }
}
