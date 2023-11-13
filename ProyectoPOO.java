public class ProyectoPOO{
  public static void main (String [] args){
    int a;
    float b;
    double c;
  }

}

public class Producto {
    private String codigo;
    private String nombre;
    private double valor;

    // Constructor
    public Producto(String codigo, String nombre, double valor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.valor = valor;
    }

    // Getters y setters (puedes generarlos automáticamente en muchos IDE)
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValor() {
        return valor;
    }

    // Otros métodos, si es necesario
}
  

public class BD{
// import java.sql.*;
// import java.util.LinkedList;


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

