/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siga;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Timaure
 */
public class SIGA extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
         Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));      
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("BIENVENIDO");
        stage.getIcons().add(new Image("/imagenes/ivvv-removebg-preview.png"));
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
