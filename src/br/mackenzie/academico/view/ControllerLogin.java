/**
 * FXML Controller class
 *
 * @author Keila
 */
package br.mackenzie.academico.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
//import eduk.CRM.model.InterfaceLogin;
///import eduk.CRM.model.Model;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.VBox;

public class ControllerLogin implements Initializable {

    //InterfaceLogin iLogin;

    public ControllerLogin() {
        //iLogin = (InterfaceLogin) Model.getInstance();
    }

    @FXML
    private VBox rootPane;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton login;

    @FXML
    private void makeLogin(ActionEvent event) throws IOException {
       // if (iLogin.makeLogin(username.getText(), password.getText())) {
       //     loadContainer();
       // }
    }

    @FXML
    private void loadContainer() throws IOException {
        VBox pane = FXMLLoader.load(getClass().getResource("GUI_Home.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        username.setOnKeyPressed(k -> {
            final KeyCombination TAB = new KeyCodeCombination(KeyCode.TAB);
            if (TAB.match(k)) {
                password.requestFocus();
            }
        });

        password.setOnKeyPressed(k -> {
            final KeyCombination BACKTAB = new KeyCodeCombination(KeyCode.TAB);
            if (BACKTAB.match(k)) {
                username.requestFocus();
            }
        });

        password.setOnKeyPressed(k -> {
            final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(k)) {
                login.fire();
            }
        });
    }
}
