package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.KupacManager;
import ba.unsa.etf.rpr.business.SessionManager;
import ba.unsa.etf.rpr.domain.Kupac;
import ba.unsa.etf.rpr.exceptions.ProjekatException;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class SignupController {
    public PasswordField txtFieldSifraID;
    public TextField txtFieldBrTelID;
    public TextField txtFieldPrezimeID;
    public TextField txtFieldImeID;
    public TextField txtFieldAdresa;
    public TextField txtFieldEmail;
    public Label errorLabel;
    private KupacManager manager = new KupacManager();

    @FXML
    void initialize(){
        txtFieldImeID.getStyleClass().add("poljeJeIspravno");
        txtFieldImeID.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (n.toString() == null || n.toString().length() <= 2 || !n.toString().matches("^[a-zA-Z]+$")) {
                    txtFieldImeID.getStyleClass().removeAll("poljeJeIspravno");
                    txtFieldImeID.getStyleClass().add("poljeNijeIspravno");

                } else {
                    txtFieldImeID.getStyleClass().removeAll("poljeNijeIspravno");
                    txtFieldImeID.getStyleClass().add("poljeJeIspravno");


                }


            }
        });


    }


    public void actionSubmit(ActionEvent actionEvent) throws ProjekatException {



        String ime = txtFieldImeID.getText();
        String prezime = txtFieldPrezimeID.getText();
        String adresa = txtFieldAdresa.getText();
        String brojTel = txtFieldBrTelID.getText();
        String sifra = txtFieldSifraID.getText();
        String email = txtFieldEmail.getText();

            Kupac kupac = new Kupac();
            kupac.setName(ime);
            kupac.setSurname(prezime);
            kupac.setAdress(adresa);
            kupac.setPhoneNumber(brojTel);
            kupac.setPassword(sifra);
            kupac.setEmail(email);
            try {
                manager.add(kupac);
                SessionManager.getInstance().setKupacId(kupac.getId());
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

            }catch(ProjekatException | IOException e){
                new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();

            }
    }
}
