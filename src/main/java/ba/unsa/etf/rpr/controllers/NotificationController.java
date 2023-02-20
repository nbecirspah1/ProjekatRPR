package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.PlacanjeManager;
import ba.unsa.etf.rpr.business.SessionManager;
import ba.unsa.etf.rpr.domain.Placanje;
import ba.unsa.etf.rpr.exceptions.ProjekatException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class NotificationController {

    PlacanjeManager manager = new PlacanjeManager();
    public void DAClick(ActionEvent actionEvent) throws IOException, ProjekatException {
        LocalDate datumPlacanja = LocalDate.now();
        Date date = Date.from(datumPlacanja.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String nacinPlacanja = SessionManager.getInstance().getNacinPlacanja();
        int proizvodID = SessionManager.getInstance().getProizvod().getId();
        int kupacID = SessionManager.getInstance().getKupacId();
        Placanje placanje = new Placanje();
        placanje.setPaymentDate(date);
        placanje.setPaymentMethod(nacinPlacanja);
        placanje.setProizvodID(proizvodID);
        placanje.setKupacID(kupacID);
        manager.add(placanje);

        Node node = (Node) actionEvent.getSource();
        Stage stageOld = (Stage) node.getScene().getWindow();
        stageOld.close();

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/uspjesnaKupovina.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Pitanje");
        Image icon = new Image(getClass().getResourceAsStream("/img/logo.jpg"));
        stage.getIcons().add(icon);
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();

    }

    public void NEClick(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource();
        Stage stageOld = (Stage) node.getScene().getWindow();
        stageOld.close();

    }
}
