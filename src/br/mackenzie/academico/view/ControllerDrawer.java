package br.mackenzie.academico.view;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;

public class ControllerDrawer implements Initializable {

    @FXML
    private JFXButton newPush;
    @FXML
    private JFXButton scheduledPush;
    @FXML
    private JFXButton sentPush;
    @FXML
    private JFXButton exit;

    @FXML
    private void loadContainer(ActionEvent event) throws IOException {
        JFXButton button = (JFXButton) event.getSource();
        switch (button.getText()) {
            case "Nova Notificação":
                Pane pane = FXMLLoader.load(getClass().getResource("GUI_NewPush.fxml"));
                ControllerHome.mainPane.getChildren().setAll(pane);
                break;
        }

    }
    
    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
