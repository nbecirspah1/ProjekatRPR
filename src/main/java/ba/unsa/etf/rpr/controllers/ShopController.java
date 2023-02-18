package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ProizvodManager;
import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.ProjekatException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;


import java.io.*;
import java.util.List;

import static com.sun.tools.javac.tree.JCTree.Tag.POS;
import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class ShopController {


    public FlowPane flowPaneID;
    private ProizvodManager manager = new ProizvodManager();

    @FXML
    public void initialize() throws ProjekatException {
        try {
            List<Proizvod> proizvodi = manager.getAll();
            dodavanjeProizvoda(proizvodi);

        }catch(ProjekatException e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();

        }
    }

    public void onNaocaleClick(ActionEvent actionEvent) {

    }

    public void dodavanjeProizvoda(List<Proizvod> proizvodi){
        for (Proizvod proizvod : proizvodi) {
            try {
                ImageView imageView = new ImageView(new Image(new ByteArrayInputStream(proizvod.getSlika())));
                // System.out.println("OVO JE KAO KAO KAO SLIKA " + imageView);
                imageView.setFitWidth(400);
                imageView.setFitHeight(400);

                Label opis = new Label(proizvod.getOpis());
                opis.setAlignment(Pos.CENTER);
                opis.setId("opisID");

                Label cijena = new Label(String.format("%.2f KM", proizvod.getCijena()));
                cijena.setAlignment(Pos.CENTER);
                cijena.setId("cijenaID");

                VBox vBox = new VBox(imageView, opis, cijena);
                vBox.setAlignment(Pos.CENTER);
                vBox.setSpacing(10.0);
                vBox.setId("vBoxID");

                flowPaneID.getChildren().add(vBox);
            }catch(Exception e){
                new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();

            }
        }
    }
}