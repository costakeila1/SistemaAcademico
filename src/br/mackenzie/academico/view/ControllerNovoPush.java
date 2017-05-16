package br.mackenzie.academico.view;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class ControllerNovoPush implements Initializable {

    @FXML
    private JFXDatePicker dateToSend;

    @FXML
    private JFXTimePicker timeToSend;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

}
