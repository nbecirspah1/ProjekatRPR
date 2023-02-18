package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.KupacManager;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {
    public Button OKDugme;
    public TextField usernameID;
    public TextField imeID;
    public TextField prezimeID;
    public TextField passwordID;
    public Button buttonID;

    private KupacManager manager = new KupacManager();



    public void onButtonClick(ActionEvent actionEvent) {
        String ime = imeID.getText();
        String prezime = prezimeID.getText();
        String password = passwordID.getText();

    }
}
