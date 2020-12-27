package Cosmetics;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CosmeticsMain extends Application{
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Cosmetics.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Stock Management");
        stage.setScene(scene);
        stage.show();


    }
}
