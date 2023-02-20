package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.ProizvodManager;
import ba.unsa.etf.rpr.business.SessionManager;
import ba.unsa.etf.rpr.domain.Kategorija;
import ba.unsa.etf.rpr.domain.Proizvod;
import ba.unsa.etf.rpr.exceptions.ProjekatException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.*;
import java.util.List;

import static com.sun.tools.javac.tree.JCTree.Tag.POS;
import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class ShopController {


    public FlowPane flowPaneID;
    public Button naocaleButton;
    public ScrollPane scrollPaneID;
    public ChoiceBox choiceBoxID;
    private String kategorija="-";

    private String[] cijene = { "do 100 KM", "do 200 KM", "do 300 KM", "-"};
    private ProizvodManager manager = new ProizvodManager();
    private VBox vBox;

    @FXML
    public void initialize() throws ProjekatException {
        try {
            List<Proizvod> proizvodi = manager.getAll();
            dodavanjeProizvoda(proizvodi);
            choiceBoxID.getItems().addAll(cijene);

            choiceBoxID.setOnAction(event -> {

                String cijenaString = choiceBoxID.getValue().toString();
                //flowPaneID.getChildren().clear();
                if(cijenaString != "-"){
                    String rezultat = cijenaString.replace("do ", "");
                    rezultat = rezultat.replace(" KM", "");
                    int cijena = Integer.parseInt(rezultat);
                    System.out.println("CIjena je: " + cijena);
                    try{
                        List<Proizvod> proizvodi1 = manager.searchByPriceAndCategory(cijena, this.kategorija);
                        dodavanjeProizvoda(proizvodi1);

                    }catch (ProjekatException e){
                        new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
                    }
                }else{

                    try{
                        if(kategorija!="-") {
                            List<Proizvod> proizvodiList = manager.getByCategory(kategorija);
                            dodavanjeProizvoda(proizvodiList);
                        }

                    }catch(ProjekatException e){
                        new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();

                    }

                }
            });


        }catch(ProjekatException e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();

        }
    }

    public void onNaocaleClick(ActionEvent actionEvent) throws ProjekatException {
        try{
            choiceBoxID.setValue("-");
            dodavanjeProizvoda(manager.getByCategory("naocale"));
            this.kategorija = "naocale";

        }catch(ProjekatException e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();

        }

    }

    public void onKacigeClick(ActionEvent actionEvent) {
        try{
            choiceBoxID.setValue("-");
            dodavanjeProizvoda(manager.getByCategory("kaciga"));
            this.kategorija="kaciga";

        }catch(ProjekatException e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();

        }
    }

    public void onSveClick(ActionEvent actionEvent) {
        try{
            choiceBoxID.setValue("-");
            dodavanjeProizvoda(manager.getAll());

        }catch(ProjekatException e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();

        }
    }

    public void onSkijeClick(ActionEvent actionEvent) {
        try{
            choiceBoxID.setValue("-");
            dodavanjeProizvoda(manager.getByCategory("skije"));
            this.kategorija = "skije";

        }catch(ProjekatException e){
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();

        }
    }

    public void onPancericeClick(ActionEvent actionEvent) {
        try{
            choiceBoxID.setValue("-");
            dodavanjeProizvoda(manager.getByCategory("pancerice"));
            this.kategorija = "pancerice";
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

                vBox.setOnMouseClicked(event ->{
                    this.vBox = vBox;
                    SessionManager.getInstance().setProizvod(proizvod);

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/buyItem.fxml"));
                    Parent newRoot = null;
                    try {
                        newRoot = loader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    BuyItemController controller = loader.getController();
                    controller.secondVBOXID.getChildren().addAll(vBox.getChildren());
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    stage.setTitle("Buy item");
                    Image icon = new Image(getClass().getResourceAsStream("/img/logo.jpg"));
                    stage.getIcons().add(icon);
                    Scene currentScene = stage.getScene();
                    currentScene.setRoot(newRoot);
                });

            }catch(Exception e){
                new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();

            }
        }
    }


    public VBox getVBox() {
        return vBox;
    }

    public void onONamaClick(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/oNama.fxml"));
        Parent newRoot = null;
        try {
            newRoot = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        BuyItemController controller = loader.getController();
        controller.secondVBOXID.getChildren().addAll(vBox.getChildren());
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setTitle("Buy item");
        Image icon = new Image(getClass().getResourceAsStream("/img/logo.jpg"));
        stage.getIcons().add(icon);
        Scene currentScene = stage.getScene();
        currentScene.setRoot(newRoot);

    }
}