/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Calendario;

/**
 * FXML Controller class
 *
 * @author Jesus Diego
 */
public class BodegaFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private Button btnAñadirCarrito;
    @FXML private Button btnConsultarProducto;
    @FXML private Button btnEmitirBoleta;
    @FXML private TextField tfCodigo;
    @FXML private TextField tfNombreProducto;
    @FXML private TextField tfCantidad;
    @FXML private TextField tfTipo;
    @FXML private TextField tfPrecioUnitarioCosto;
    @FXML private TextField tfPrecioUnitarioVenta;
    @FXML private TextField tfStock;
    @FXML private TextField tfLote;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML private void accionAñadirACarrito(){
        
    }
    
    @FXML private void accionConsultarProducto(){
        
    }
    
    // METODO PARA BOTON DE EMITIR BOLETA EN PRIMERA INTERFAZ    
    @FXML private void accionEmitirBoletaVenta() throws IOException{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/boletaFXML.fxml"));
            Parent root = loader.load();
        
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
