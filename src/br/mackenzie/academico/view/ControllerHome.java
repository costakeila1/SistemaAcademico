package br.mackenzie.academico.view;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ControllerHome implements Initializable {

    @FXML
    private JFXHamburger menuHamburguer;

    @FXML
    private JFXDrawer menuDrawer;
    
    @FXML
    private Pane mPane;
    
    public static Pane mainPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        mainPane = mPane;
        
        try {
            VBox drawerContent = FXMLLoader.load(getClass().getResource("GUI_DrawerContent.fxml"));
            menuDrawer.setSidePane(drawerContent);
        } catch (IOException ex) {
            Logger.getLogger(ControllerHome.class.getName()).log(Level.SEVERE, null, ex);
        }

        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(menuHamburguer);
        transition.setRate(-1);
        menuHamburguer.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();

            if (menuDrawer.isShown()) {
                menuDrawer.close();
            } else {
                menuDrawer.open();
            }
        });
    }
}
