package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ProizvodManager;
import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.ProjekatException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
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
    public Button naocaleButton;
    public ScrollPane scrollPaneID;
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

    public void onNaocaleClick(ActionEvent actionEvent) throws ProjekatException {
        try{
            dodavanjeProizvoda(manager.getByCategory("naocale"));

        }catch(ProjekatException e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();

        }

    }

    public void onKacigeClick(ActionEvent actionEvent) {
        try{
            dodavanjeProizvoda(manager.getByCategory("kaciga"));

        }catch(ProjekatException e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();

        }
    }

    public void onSveClick(ActionEvent actionEvent) {
        try{
            dodavanjeProizvoda(manager.getAll());

        }catch(ProjekatException e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();

        }
    }

    public void onSkijeClick(ActionEvent actionEvent) {
        try{
            dodavanjeProizvoda(manager.getByCategory("skije"));

        }catch(ProjekatException e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();

        }
    }

    public void onPancericeClick(ActionEvent actionEvent) {
        try{
            dodavanjeProizvoda(manager.getByCategory("pancerice"));

        }catch(ProjekatException e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();

        }
    }
    public void dodavanjeProizvoda(List<Proizvod> proizvodi) {
        scrollPaneID.setVvalue(0.0);
        flowPaneID.getChildren().clear();
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

                vBox.setOnMouseEntered(event -> {
                    Image chartIcon = new Image(getClass().getResourceAsStream("/img/buy-icon.png"));
                    ImageView chartImageView = new ImageView(chartIcon);
                    chartImageView.setFitWidth(50);
                    chartImageView.setFitHeight(50);
                    vBox.getChildren().add(chartImageView);
                });

                vBox.setOnMouseExited(event -> {
                    vBox.getChildren().remove(vBox.getChildren().size() - 1);
                });


                flowPaneID.getChildren().add(vBox);
            }catch(Exception e){
                new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();

            }
        }
    }



}