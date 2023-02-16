package ba.unsa.etf.rpr.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SignupController {
    @FXML
    private SimpleStringProperty txtFieldImeID;
    @FXML
    private SimpleStringProperty txtFieldPrezimeID;
    @FXML
    private SimpleStringProperty txtFieldAdresa;
    @FXML
    private SimpleStringProperty txtFieldBrTelID;
    @FXML
    private SimpleStringProperty txtFieldSifraID;

    public SignupController(){
        txtFieldImeID = new SimpleStringProperty("");
        txtFieldPrezimeID = new SimpleStringProperty("");
        txtFieldAdresa = new SimpleStringProperty("");
        txtFieldBrTelID = new SimpleStringProperty("");
        txtFieldSifraID = new SimpleStringProperty("");

    }

    public SimpleStringProperty txtFieldImeIDProperty() {
        return txtFieldImeID;
    }
    public String getTxtFieldImeID() {
        return txtFieldImeID.get();
    }
    public SimpleStringProperty txtFieldPrezimeIDProperty() {
        return txtFieldPrezimeID;
    }
    public String getTxtFieldPrezimeID() {
        return txtFieldPrezimeID.get();
    }

    public SimpleStringProperty txtFieldAdresaProperty() {
        return txtFieldAdresa;
    }
    public String getTxtFieldAdresa() {
        return txtFieldAdresa.get();
    }
    public SimpleStringProperty txtFieldBrTelIDProperty() {
        return txtFieldBrTelID;
    }
    public String getTxtFieldBrTelID() {
        return txtFieldBrTelID.get();
    }
    public SimpleStringProperty txtFieldSifraIDProperty() {
        return txtFieldSifraID;
    }
    public String getTxtFieldSifraID() {
        return txtFieldSifraID.get();
    }

}
