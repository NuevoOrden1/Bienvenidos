
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
//clases y metodos relacionados con la gestion de base de datos JDBC
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * FXML Controller class
 *
 * @author LosMosqueteros
 */
public class BodegaFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private Button btnAñadirCarrito;
    @FXML private Button btnBuscarProducto;
    @FXML private Button btnEmitirBoleta;
    @FXML private TextField tfCodigo;
    @FXML private TextField tfNombreProducto;
    @FXML private TextField tfCantidad; //esto no es un dato de base.
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
    
    @FXML private void accionBuscarProducto(){
          String codigoIngresado = tfCodigo.getText();//tfCodigoTextField.getText();

    // Validar si el campo está vacío o no es un número
    if (codigoIngresado.isEmpty() || !esNumeroValido(codigoIngresado)) {
        mostrarAlerta("Entrada inválida", "Ingrese un número válido antes de buscar.");
        return; // Salir del método si la entrada no es válida
    }

    // Configuración de la conexión a SQLite
    String url = "jdbc:sqlite:/home/alan/NetBeansProjects/bodegaApp/productosPrueba.db";

    try (Connection connection = DriverManager.getConnection(url)) {
        // Consulta SQL para obtener todos los campos del producto según el ID ingresado
        String sql = "SELECT * FROM productos WHERE id_productos = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Convertir la entrada a un entero y establecer el valor del parámetro
            int id = Integer.parseInt(codigoIngresado);
            preparedStatement.setInt(1, id);

            // Ejecutar la consulta
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Procesar el resultado y autocompletar los campos
                    //codigoBarrasTextField.setText(resultSet.getString("codigo_barras"));
                    tfTipo.setText(resultSet.getString("tipo"));
                    tfStock.setText(Integer.toString(resultSet.getInt("stock_unidades")));
                    tfNombreProducto.setText(resultSet.getString("nombre"));
                    //descripcionTextField.setText(resultSet.getString("descripcion"));
                    tfPrecioUnitarioCosto.setText(Double.toString(resultSet.getDouble("precio_unitario_costo")));
                    tfLote.setText(resultSet.getString("fecha_de_caducidad"));
                    tfPrecioUnitarioVenta.setText(Double.toString(resultSet.getDouble("precio_unitario_venta")));
                } else {
                    // Limpiar todos los campos si no se encuentra el producto
                    limpiarCampos();

                    // Mostrar un mensaje de alerta
                    mostrarAlerta("Producto no encontrado", "El producto con ID " + id + " no fue encontrado.");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
      }
        
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
    
    
    private void limpiarCampos() {
    
    tfCodigo.clear(); //errores: tfCodigoTextField.clear();
    tfStock.clear();
    tfTipo.clear();
    tfNombreProducto.clear();
    
    tfPrecioUnitarioCosto.clear();
    tfLote.clear();
    tfPrecioUnitarioVenta.clear();
    }
    
    private void mostrarAlerta(String titulo, String contenido) {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle(titulo);
    alert.setHeaderText(null);
    alert.setContentText(contenido);
    alert.showAndWait();
    }

    private boolean esNumeroValido(String texto) {
    try {
        Integer.parseInt(texto);
        return true;
    } catch (NumberFormatException e) {
        return false;
      }
    }
    
    
    
}
