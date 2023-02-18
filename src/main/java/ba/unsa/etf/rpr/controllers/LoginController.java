package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.KupacManager;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {

    public TextField passwordID;
    public Button buttonID;
    public TextField emailID;

    private KupacManager manager = new KupacManager();



    public void onButtonClick(ActionEvent actionEvent) {
        String ime = emailID.getText();
        String password = passwordID.getText();

    }
}
