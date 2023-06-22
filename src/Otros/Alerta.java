/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Otros;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Usuario
 */
public class Alerta extends Exception {
        public Alerta(String mensaje) {
        super(mensaje);
    }
    
    public Alerta(Integer codigo) {
        super(codigo.toString());
    }
    public static void Mensaje(String numero) {
        Alert x = new Alert(Alert.AlertType.ERROR);
        Integer w = Integer.parseInt(numero);
        x.setTitle("ATENCION");
        x.setContentText(Textico(w));
        x.setGraphic(null);
        x.setHeaderText(null);
        ButtonType _Ok = new ButtonType("OK",ButtonBar.ButtonData.OK_DONE);  
        x.getButtonTypes().setAll(_Ok);
        x.showAndWait();        
    }    
private static String Textico(Integer numerito) {
        String palabras = "";
        switch(numerito) {
            case 0:
                palabras = "Coneccion Exitosa!";
                break;
            case 1:
                palabras = "Error al conectar a la Base de datos!";
                break;
            case 2:
                palabras = "Error: Datos Incorrectos";
                break;
            case 3:
                palabras = "Error al iniciar sesion";
                break;
            case 4:
                palabras = "Error en la Consulta SQL, revise la Base de Datos";
                break;  
            case 5:
                palabras = "Error en la Inserción SQL, revise la Base de Datos";
                break;
            case 6:
                palabras = "Error: Falta el Nombre del estudiante";
                break;  
            case 7:
                palabras = "Error: Falta la Edad del estudiante";
                break;                  
               
        }
        return palabras;
    }
}
