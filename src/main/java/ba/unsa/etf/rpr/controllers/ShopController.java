package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ProizvodManager;
import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.ProjekatException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;


import java.io.*;
import java.util.List;

public class ShopController {


    public FlowPane flowPaneID;
    private ProizvodManager manager = new ProizvodManager();

    @FXML
    public void initialize() throws ProjekatException {
        try {
            List<Proizvod> proizvodi = manager.getAll();
            for (Proizvod proizvod : proizvodi) {
                try {
                    ImageView imageView = new ImageView(new Image(new ByteArrayInputStream(proizvod.getSlika())));
                   // System.out.println("OVO JE KAO KAO KAO SLIKA " + imageView);
                    imageView.setFitWidth(200);
                    imageView.setFitHeight(200);
                    flowPaneID.getChildren().add(imageView);
                }catch(Exception e){
                    new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();

                }
            }
        }catch(ProjekatException e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();

        }
    }
}