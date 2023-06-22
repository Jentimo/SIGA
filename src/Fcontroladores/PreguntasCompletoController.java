/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fcontroladores;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tooltip;
import Otros.Error;
import com.jfoenix.controls.JFXButton;
import crud.CrudUser;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class PreguntasCompletoController implements Initializable {

    @FXML
    private JFXPasswordField R1;
    private Tooltip TP1;
    @FXML
    private JFXPasswordField R2;
    @FXML
    private JFXPasswordField R3;
    @FXML
    private JFXPasswordField R4;
    @FXML
    private JFXPasswordField R5;
    @FXML
    private JFXCheckBox ShowPass;
    @FXML
    private JFXTextField T1;
    @FXML
    private JFXTextField T2;
    @FXML
    private JFXTextField T3;
    @FXML
    private JFXTextField T4;
    @FXML
    private JFXTextField T5;
    Error mensaje= new Error();
    private CrudUser userfunciones= new CrudUser();
    @FXML
    private JFXButton Go;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        star();
    }    
    public void star(){
    ShowPass.setOnAction(ShowPas);
    Go.setOnAction(Registrar);
    T1.setVisible(false);
    T2.setVisible(false);
    T3.setVisible(false);
    T4.setVisible(false);
    T5.setVisible(false);
    R1.requestFocus();
    }
    private boolean Comprobar(){
        boolean a=true;
        if(T1.getText().isEmpty()&&R1.getText().isEmpty()){
            a=false; mensaje.Alerta("Debe Responder la primera pregunta");}
        if(T2.getText().isEmpty()&&R2.getText().isEmpty()){
            a=false; mensaje.Alerta("Debe Responder la segunda pregunta");}
        if(T3.getText().isEmpty()&&R3.getText().isEmpty()){
            a=false; mensaje.Alerta("Debe Responder la tercera pregunta");}
        if(T4.getText().isEmpty()&&R4.getText().isEmpty()){
            a=false; mensaje.Alerta("Debe Responder la cuarta pregunta");}
        if(T5.getText().isEmpty()&&R5.getText().isEmpty()){
            a=false; mensaje.Alerta("Debe Responder la quinta pregunta");}
        return a;
    }
    private EventHandler<ActionEvent>Registrar= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            if(Comprobar()){
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                String Cedula=window.getTitle().replace("Registro de Preguntas de Seguridad: ", "");

                if(ShowPass.isSelected()){
                    userfunciones.InsertPreguntas(Cedula,1, T3.getText());
                    userfunciones.InsertPreguntas(Cedula,2, T2.getText());
                    userfunciones.InsertPreguntas(Cedula,3, T4.getText());
                    userfunciones.InsertPreguntas(Cedula,4, T1.getText());
                    userfunciones.InsertPreguntas(Cedula,5, T5.getText());
                    mensaje.Info("Se Han Registrado las preguntas de recuperacion, Guarde las respuestas de forma segura");
                }else{
                    userfunciones.InsertPreguntas(Cedula,1, R3.getText());
                    userfunciones.InsertPreguntas(Cedula,2, R2.getText());
                    userfunciones.InsertPreguntas(Cedula,3, R4.getText());
                    userfunciones.InsertPreguntas(Cedula,4, R1.getText());
                    userfunciones.InsertPreguntas(Cedula,5, R5.getText());
                    mensaje.Info("Se Han Registrado las preguntas de recuperacion, Guarde las respuestas de forma segura");
                }
  
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
                    window.setTitle("Nueva Contraseña Usuario: "+Cedula);
                    /*pongo para que no se pueda agrandar*/
                    window.setResizable(true);
                    window.show();
                } catch (IOException ex) {
                    Logger.getLogger(PreguntasCompletoController.class.getName()).log(Level.SEVERE, null, ex);
                }
                   
            }
        }
    
    
    };
    private EventHandler<ActionEvent> ShowPas= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            if(ShowPass.isSelected()){
             T1.setText(R1.getText());
             T1.setVisible(true);
             R1.setVisible(false);
             T2.setText(R2.getText());
             T2.setVisible(true);
             R2.setVisible(false);
             T3.setText(R3.getText());
             T3.setVisible(true);
             R3.setVisible(false);
             T4.setText(R4.getText());
             T4.setVisible(true);
             R4.setVisible(false);
             T5.setText(R5.getText());
             T5.setVisible(true);
             R5.setVisible(false);
             return;
            }else{
            R1.setText(T1.getText());
            R1.setVisible(true);
            T1.setVisible(false);
            R2.setText(T2.getText());
            R2.setVisible(true);
            T2.setVisible(false);
            R3.setText(T3.getText());
            R3.setVisible(true);
            T3.setVisible(false);
            R4.setText(T4.getText());
            R4.setVisible(true);
            T4.setVisible(false);
            R5.setText(T5.getText());
            R5.setVisible(true);
            T5.setVisible(false);
            }
        }
    };
    
}
