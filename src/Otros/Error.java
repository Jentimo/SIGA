/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;

import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;

/**
 *
 * @author Usuario
 */
public class Error {
        public void Info(String cadena) {
        Alert x = new Alert(Alert.AlertType.INFORMATION);
        DialogPane dialogPane = x.getDialogPane();
       dialogPane.getStylesheets().add(
        getClass().getResource("fullpackstyling.css").toExternalForm());
        dialogPane.getStyleClass().add("fullpackstyling");
        x.setTitle("felicitaciones");
        x.setContentText(cadena);
        x.setHeaderText(null);
        
        x.showAndWait();        
    } 
public void Alerta(String cadena) {
        Alert x = new Alert(Alert.AlertType.ERROR);
        DialogPane dialogPane = x.getDialogPane();
         dialogPane.getStylesheets().add(
        getClass().getResource("fullpackstyling.css").toExternalForm());
        dialogPane.getStyleClass().add("fullpackstyling");
        x.setTitle("Alerta!!");
        x.setContentText(cadena);
        x.setHeaderText(null);
        x.showAndWait();        
    } 
}