/**
 * ---------------------------------------------------------------------
 * $Id: SimListaDoble.java,v 1.0 2013/08/23 
 * Universidad Francisco de Paula Santander 
 * Programa Ingenieria de Sistemas
 *
 * Proyecto: SEED_UFPS
 * ----------------------------------------------------------------------
 */

package com.simlistadoble;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal que despliega la aplicación en una Interfaz para interaccion con el Estudiante.
 * @author Uriel Garcia - Yulieth Pabon
 * @version 1.0
 */

public class SimListaDoble extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/simlistadoble/Vista.fxml"));
        stage.setTitle("SEED UFPS");
        stage.setResizable(false);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(SimListaDoble.class.getResource("/com/simlistadoble/estilo.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}