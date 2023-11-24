/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import model.Calendario;

/**
 * FXML Controller class
 *
 * @author Jesus Diego
 */
    
public class BoletaFXMLController implements Initializable {
    @FXML private Text txtFecha;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                Calendario cal = new Calendario();
                txtFecha.setText(cal.toString());
    }    
    
}
