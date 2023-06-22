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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import Otros.Error;
import crud.CrudUser;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class NewPassController implements Initializable {

    @FXML
    private JFXPasswordField P1;
    @FXML
    private JFXPasswordField P2;
    @FXML
    private JFXTextField T1;
    @FXML
    private JFXTextField T2;
    @FXML
    private JFXCheckBox ShowPass;
    @FXML
    private JFXButton Go;
    private Error mensaje= new Error();
    CrudUser usarioFunciones= new CrudUser();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Star();
    }    
    public void Star(){
    ShowPass.setOnAction(ShowPas);
    Go.setOnAction(Registrar);
    T1.setVisible(false);
    T2.setVisible(false);
    P1.requestFocus();
    T1.setOnKeyTyped(nav);
    T2.setOnKeyTyped(nav);
    P1.setOnKeyTyped(nav);
    P2.setOnKeyTyped(nav);
    }
    private EventHandler<ActionEvent> Registrar= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            if(Actualizar(window)){
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            }
        }
    };
    private EventHandler<KeyEvent> nav= new EventHandler<KeyEvent>(){
        @Override
        public void handle(KeyEvent event) {
            if(event.getSource().equals(T1)){
                if(event.getCode().equals(KeyCode.ENTER)){
                T2.requestFocus();
                }
            }
            if(event.getSource().equals(T2)){
                if(event.getCode().equals(KeyCode.ENTER)){
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    if(Actualizar(window)){
                        Node source = (Node) event.getSource();
                        Stage stage = (Stage) source.getScene().getWindow();
                        stage.close();
                    }
                }
            }
            if(event.getSource().equals(P1)){
                if(event.getCode().equals(KeyCode.ENTER)){
                    P2.requestFocus();
                }
            }
            if(event.getSource().equals(P2)){
                if(event.getCode().equals(KeyCode.ENTER)){
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    if(Actualizar(window)){
                        Node source = (Node) event.getSource();
                        Stage stage = (Stage) source.getScene().getWindow();
                        stage.close();
                    }
                }
            }
        }
    };
    private boolean Actualizar(Stage window){
        boolean actualizar=false;
        if(Comprobar2()){
                String clave="";
                if(ShowPass.isSelected()){
                    clave=T1.getText();
                }else{
                    clave=P1.getText();
                }
                String Usuario=window.getTitle().replace("Nueva Contraseña Usuario: ", "");
                usarioFunciones.UpdatePass(Usuario,clave);
                mensaje.Info("Se ha Actualizado la contraseña");
                actualizar=true;
            }
        return actualizar;    
    }
    private boolean Comprobar2(){
        boolean a =false;
        if(comprobar1()){
            if(ShowPass.isSelected()){
            if(T1.getText().equals(T2.getText())){
            a=true;
            }else{mensaje.Alerta("Las claves no coinciden");}
        }else{
            if(P1.getText().equals(P2.getText())){
            a=true;
            }else{mensaje.Alerta("Las claves no coinciden");}
        }
    }
    return a;
    }
    private boolean comprobar1(){
    boolean a=true;
    if(ShowPass.isSelected()){
        if(T1.getText().isEmpty())a=false;
        if(T2.getText().isEmpty())a=false;
        if(a==false)mensaje.Alerta("Debe Ingresar las contraseñas en los campos");
    }else{
        if(P1.getText().isEmpty())a=false;
        if(P2.getText().isEmpty())a=false;
        if(a==false)mensaje.Alerta("Debe Ingresar las contraseñas en los campos");
    }
    return a;
    }
    private EventHandler<ActionEvent> ShowPas= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            if(ShowPass.isSelected()){
             T1.setText(P1.getText());
             T1.setVisible(true);
             P1.setVisible(false);
             T2.setText(P2.getText());
             T2.setVisible(true);
             P2.setVisible(false);
             return;
            }else{
            P1.setText(T1.getText());
            P1.setVisible(true);
            T1.setVisible(false);
            P2.setText(T2.getText());
            P2.setVisible(true);
            T2.setVisible(false);
            }
        }
    
    };
   
    
}
