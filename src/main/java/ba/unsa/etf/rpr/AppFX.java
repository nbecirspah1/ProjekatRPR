package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

/**
 * Hello world!
 *
 */
public class AppFX extends Application
{
    public static void main( String[] args )
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/welcome.fxml"));
        primaryStage.setTitle("Welcome!");
        Image icon = new Image(getClass().getResourceAsStream("/img/logo.jpg"));
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.setResizable(true);
        primaryStage.show();
    }
}
