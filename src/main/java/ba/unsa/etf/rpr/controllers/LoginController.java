package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.AppFX;
import ba.unsa.etf.rpr.business.KupacManager;
import ba.unsa.etf.rpr.business.SessionManager;
import ba.unsa.etf.rpr.domain.Kupac;
import ba.unsa.etf.rpr.exceptions.ProjekatException;
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
import java.util.List;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class LoginController {

    public PasswordField passwordID;
    public Button buttonID;
    public TextField emailID;
    public Label errorEmail;
    public Label errorPassword;

    private KupacManager manager = new KupacManager();

    @FXML
    void initialize(){
        errorEmail.setText("");
        errorPassword.setText("");
        emailID.getStyleClass().add("poljeJeIspravno");
        passwordID.getStyleClass().add("poljeJeIspravno");


        emailID.textProperty().addListener((observable, oldValue, newValue) ->{
            errorEmail.setText("");
            errorPassword.setText("");

            if ( newValue.length() < 8  || !newValue.toString().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                emailID.getStyleClass().removeAll("poljeJeIspravno");
                emailID.getStyleClass().add("poljeNijeIspravno");

            } else {
                emailID.getStyleClass().removeAll("poljeNijeIspravno");
                emailID.getStyleClass().add("poljeJeIspravno");


            }
        });

        passwordID.textProperty().addListener((observable, oldValue, newValue) ->{
            errorEmail.setText("");
            errorPassword.setText("");

             //   errorLabel.setText("");

                if ( newValue.length() < 8) {
                    passwordID.getStyleClass().removeAll("poljeJeIspravno");
                    passwordID.getStyleClass().add("poljeNijeIspravno");

                } else {
                    passwordID.getStyleClass().removeAll("poljeNijeIspravno");
                    passwordID.getStyleClass().add("poljeJeIspravno");


                }



        });
    }


    /**
     *
     * @param actionEvent
     * @throws ProjekatException
     * @throws IOException
     */
    public void onButtonClick(ActionEvent actionEvent) throws ProjekatException, IOException {
        String email = emailID.getText();
        String password = passwordID.getText();
        List<Kupac> kupac = manager.searchByEmail(email);
        if(kupac.isEmpty()){
           // new Alert(Alert.AlertType.NONE, "Ne postoji account sa ovim emailom!", ButtonType.OK).show();
            errorEmail.setText("Ne postoji account sa ovim emailom!");
        }
        else if(!password.equals(kupac.get(0).getPassword())){
            //new Alert(Alert.AlertType.NONE, "Šifra nije validna. Pokušajte ponovo.", ButtonType.OK).show();
            errorPassword.setText("Šifra nije validna. Pokušajte ponovo.");
        }
        else{
            SessionManager.getInstance().setKupacId(kupac.get(0).getId());
            Stage s = AppFX.getPrimaryStage();
            s.close();
            Node node1 = (Node) actionEvent.getSource();
            Stage stageOld = (Stage) node1.getScene().getWindow();
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
