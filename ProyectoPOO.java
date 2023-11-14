////Clase principal que inicia la aplicación JavaFX.
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
public class ProyectoPOO{
  public static void main (String [] args){
    launch(args);
  }
@Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.setTitle("Sistema de Gestión de Ventas");
        primaryStage.show();
    }
}


//Controlador principal que gestiona la ventana principal.
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
public class MainController {
    @FXML
    private Button addProductButton;

    // Métodos y lógica para la ventana principal
}




//Clase que representa un producto.
//import java.time.LocalDate;
public class Producto {
    private String codigo;
    private String nombre;
    private int cantidad;
    private String tipo;
    private double precio_unitario_costo;
    private double precio_unitario_venta;
    private int stock;
    private LocalDate fechaDeCaducidad;

    // Constructor
    public Producto(String codigo, String nombre, double valor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.precio_unitario_costo = precio_unitario_costo;
        this.precio_unitario_venta = precio_unitario_venta;
        this.stock = stock;
        this.fechaDeCaducidad = fechaDeCaducidad;
        
    }

    // Getters y setters (puedes generarlos automáticamente en muchos IDE)
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public double getPrecio_unitario_costo() {
         return precio_unitario_costo;
    }
    
    public double getPrecio_unitario_venta() {
         return precio_unitario_venta;
    }
    
    public int getStock() {
         return stock;
    }
    
    public LocalDate getFechaDeCaducidad(){
         return fechaDeCaducidad;
    }

    // Otros métodos, si es necesario
}



//Controlador para la ventana de gestión de productos.
//import javafx.fxml.FXML;
//import javafx.scene.control.TableView;
public class ProductController {
    @FXML
    private TableView<Product> productTable;

    // Métodos y lógica para la gestión de productos
}

//Clase que encapsula la lógica del escáner de código de barras.
public class BarcodeScanner {
    // Lógica para la lectura de códigos de barras
}



//falta diseñar mejor esta clase BD
// import java.sql.*;
// import java.util.LinkedList;
public class BD{
        // Crear la LinkedList de Elementos
        LinkedList<Producto> listaProductos = new LinkedList<>();

        // Código ingresado por el usuario
        String codigoIngresado = "ABC123";  // Reemplaza esto con el código ingresado por el usuario

        // Conexión a la base de datos (ejemplo con JDBC)
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tu_base_de_datos", "usuario", "contraseña")) {
            // Consulta SQL para obtener elementos según el código ingresado
            String sql = "SELECT codigo, nombre, valor FROM elementos WHERE codigo = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, codigoIngresado);
                
                // Ejecutar la consulta
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Procesar los resultados y añadir elementos a la LinkedList
                    while (resultSet.next()) {
                        String codigo = resultSet.getString("codigo");
                        String nombre = resultSet.getString("nombre");
                        double valor = resultSet.getDouble("valor");

                        // Crear un nuevo objeto Elemento y añadirlo a la LinkedList
                        Producto nuevoProducto = new Producto(codigo, nombre, valor);
                        listaProductos.add(nuevoProducto);
                    }
                }
            }

            // Imprimir la LinkedList
            System.out.println("Lista de Productos:");
            for (Producto producto : listaProductos) { 
                System.out.println("Código: " + producto.getCodigo() + ", Nombre: " + producto.getNombre() + ", Valor: " + producto.getValor());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }  
}





public class ticket{

  
}

