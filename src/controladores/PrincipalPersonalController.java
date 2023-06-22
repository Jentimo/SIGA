/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import funciones.navegacion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Timaure
 */
public class PrincipalPersonalController implements Initializable {

    @FXML
    private BorderPane fondo;
    @FXML
    private MenuBar Mymenu;
    @FXML
    private Menu Service;
    @FXML
    private MenuItem Report;
    @FXML
    private MenuItem PC;
    @FXML
    private MenuItem Active;
    private navegacion nav= new navegacion();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nave();
    }    
    private void nave(){
 Report.setOnAction(E->{
     Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,11, window,"Ingreso al modulo Servicio");});
 PC.setOnAction(E->{
     Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,12, window,"Ingreso al modulo PC");});
 Active.setOnAction(E->{
     Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,14, window,"Ingreso al modulo actividad");});
 }
}
