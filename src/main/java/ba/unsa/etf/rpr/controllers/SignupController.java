package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.KupacManager;
import ba.unsa.etf.rpr.domain.Kupac;
import ba.unsa.etf.rpr.exceptions.ProjekatException;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class SignupController {
    public TextField txtFieldSifraID;
    public TextField txtFieldBrTelID;
    public TextField txtFieldPrezimeID;
    public TextField txtFieldImeID;
    public TextField txtFieldAdresa;
    private KupacManager manager = new KupacManager();


    public void actionSubmit(ActionEvent actionEvent) throws ProjekatException {
        String ime = txtFieldImeID.getText();
        String prezime = txtFieldPrezimeID.getText();
        String adresa = txtFieldAdresa.getText();
        String brojTel = txtFieldBrTelID.getText();
        String sifra = txtFieldSifraID.getText();


            Kupac kupac = new Kupac();
            kupac.setName(ime);
            kupac.setSurname(prezime);
            kupac.setAdress(adresa);
            kupac.setPhoneNumber(brojTel);
            kupac.setPassword(sifra);
            try {
                manager.add(kupac);

            }catch(ProjekatException e){
                new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();

            }
    }
}
