/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fcontroladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import crud.CrudUser;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import Otros.Error;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class PreguntasRController implements Initializable {

    @FXML
    private JFXPasswordField P1;
    @FXML
    private JFXTextField T1;
    @FXML
    private JFXCheckBox ShowPass;
    private CrudUser usuarioFunciones= new CrudUser();
    @FXML
    private Label Label;
    @FXML
    private JFXButton Go;
    Error mensaje = new Error();
    int getRandomValue = (int) (Math.random()*(5-1)) + 1;
    String Usuario;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        star();
    }    
    public void star(){
    Label.setText(usuarioFunciones.retornarPregunta(getRandomValue));
    ShowPass.setOnAction(ShowPas);
    Go.setOnAction(Registrar);
    T1.setVisible(false);
    P1.requestFocus();
    T1.setOnKeyPressed(Key);
    P1.setOnKeyTyped(Key);
    }
    private EventHandler<ActionEvent>Registrar= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            GO(window);
        }
    };
    private EventHandler<KeyEvent> Key= new EventHandler<KeyEvent>(){
        @Override
        public void handle(KeyEvent event) {
             if(event.getCode().equals(KeyCode.ENTER)){
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                GO(window);
             }
        }  
    };
    private void GO(Stage window){
     if(T1.getText().isEmpty()&&P1.getText().isEmpty()){
             mensaje.Alerta("Debe responder la pregunta");
         }else{
             String respuesta="";
             if(ShowPass.isSelected())respuesta=T1.getText();
             else respuesta=P1.getText();
             if(usuarioFunciones.retornarCoincidenciaPreg(getRandomValue, respuesta, Usuario)){
                 try {
                     FXMLLoader loader= new FXMLLoader();
                      AnchorPane root;
                      root = (AnchorPane)loader.load(getClass().getResource("/formularios/NewPass.fxml"));
                     /*creo el nuevo scene y le cargo el parent*/
                    Scene vistaUnoScene = new Scene(root);
                    /*el stage que se estaba ejecutando se manda por parametro*/
                    /*le paso el scene al stage*/
                    window.setScene(vistaUnoScene);
                    /*le pongo el titulo a la ventana usando el actual*/
                    window.setTitle("Nueva Contraseña Usuario: "+Usuario);
                    /*pongo para que no se pueda agrandar*/
                    window.setResizable(true);
                    window.show();
                 } catch (IOException ex) {
                     Logger.getLogger(PreguntasRController.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
             }else{
                 mensaje.Alerta("Respuesta incorrecta");
             }
         }
    
    }
    public void Recibir_Usuario(String user){
    Usuario=user;
    }
     private EventHandler<ActionEvent> ShowPas= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            if(ShowPass.isSelected()){
             T1.setText(P1.getText());
             T1.setVisible(true);
             P1.setVisible(false);
             return;
            }else{
            P1.setText(T1.getText());
            P1.setVisible(true);
            T1.setVisible(false);
            }
        }
    };
}
