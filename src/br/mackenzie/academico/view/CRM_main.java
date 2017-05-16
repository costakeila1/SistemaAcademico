package br.mackenzie.academico.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CRM_main extends Application{
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GUI_Login.fxml"));
        
        Scene scene = new Scene(root);
        window.setTitle("CRM eduK");
        window.getIcons().add(new Image(getClass().getResourceAsStream("logo.png")));
        window.setScene(scene);
        window.show();
    }
}
