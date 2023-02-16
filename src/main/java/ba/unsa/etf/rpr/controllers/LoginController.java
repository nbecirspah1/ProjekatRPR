package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {
    public Button OKDugme;
    public TextField usernameID;

    public void nekaAkcija(ActionEvent actionEvent) {
        usernameID.setText("Neki tekst");
    }
}
