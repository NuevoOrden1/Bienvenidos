/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bodegaapp;

//import view.bodegaFXML;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jesus Diego
 */
public class BodegaApp extends Application{

    private static Scene scene;
    @Override
    public void start(Stage primaryStage) {
        try {
            String fxmlPath = "/view/bodegaFXML.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root =loader.load();
            
            Scene scene = new Scene(root, 1200, 800);
       
            primaryStage.setScene(scene);
            primaryStage.setResizable(true);
            primaryStage.show();            
        } catch (IOException ex) {
            Logger.getLogger(BodegaApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void setRoot(String fxml){
        try {
            scene.setRoot(loadFXML(fxml));
        } catch (IOException e) {
            e.printStackTrace();
    }
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BodegaApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch();
    }
    
}
