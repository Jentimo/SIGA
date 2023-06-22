/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fcontroladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import controladores.UsersController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import Otros.Error;
import crud.CrudBitacora;
import crud.CrudUser;
import funciones.Bitacora;
import java.awt.Toolkit;
import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import Otros.Error;
import com.jfoenix.controls.JFXCheckBox;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FUsuarioController implements Initializable {

    @FXML
    private JFXTextField Cedula;
    @FXML
    private JFXTextField Nombre;
    @FXML
    private JFXComboBox<String> userType;
    @FXML
    private JFXButton Cancel;
    @FXML
    private JFXButton Go;
    private String Usuario;
    UsersController userController;
    Error mensaje= new Error();
    CrudUser usuarioFunciones= new CrudUser();
    private Bitacora bit;
    int Crud;
    int acceso;
    @FXML
    private JFXCheckBox Pass;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userType.getItems().add("Administrador");
        userType.getItems().add("Personal");
        Cedula.setOnKeyTyped(Caracteres);
        Go.setOnAction(Regis);
        Cancel.setOnAction(Cancelar);
        Pass.setVisible(false);
        Pass.setDisable(true);
    }    
    public void Recibir_Parametros(UsersController controlador,String User){
    userController=controlador;
    Usuario=User;
    }
    private EventHandler<KeyEvent> Caracteres = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
              int c = event.getCharacter().charAt(0);
                if((!Character.isDigit(c))){
                    Toolkit.getDefaultToolkit().beep();
                    event.consume();
                } 
        }
    };
    private EventHandler<ActionEvent>Regis= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
              if(Crud!=2){
                    if(Comprobar()){
                    String name=Nombre.getText();
                    String name2=name.replaceAll("\\s{2,}"," ");
                    if(userType.getValue().equals("Administrador")){
                        acceso=1;
                    }else{acceso=2;}
                    usuarioFunciones.Insert(Cedula.getText(), name2,Cedula.getText(), acceso);
                    RegistarBitacora(Usuario,"Ha registrado al usuario: "+Cedula.getText());
                    userController.Refresh();
                    mensaje.Info("Se ha  registrado un nuevo usuario");
                    Node source = (Node) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
                }
              }else{
                  if(Nombre.getText().length()!=0){
                        String name=Nombre.getText();
                    String name2=name.replaceAll("\\s{2,}"," ");
                    if(userType.getValue().equals("Administrador")){
                        acceso=1;
                    }else{acceso=2;}
                    usuarioFunciones.Update(Cedula.getText(), name2, acceso);
                    mensaje.Info("Se ha actualizado el Usuario");
                    RegistarBitacora(Usuario,"Ha actualizado al usuario: "+Cedula.getText());
                    if(Pass.isSelected()){
                        usuarioFunciones.UpdatePass(Cedula.getText(),Cedula.getText());
                        mensaje.Info("Se ha reiniciado la contraseña");
                        RegistarBitacora(Usuario,"Ha reiniciado la contraseña del usuario: "+Cedula.getText());
                    }
                    Node source = (Node) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
                  }else{
                      mensaje.Alerta("El nombre no puede quedar vacio");
                  }
              }               
        }
    
    };
    private EventHandler<ActionEvent>Cancelar= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
              Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        }
    
    };
    private boolean Comprobar(){
    boolean a =true;
    if(Nombre.getText().length()==0){a=false; mensaje.Alerta("El campo nombre no debe estar vacio");}
    if(Cedula.getText().length()<7){a=false; 
    mensaje.Alerta("Ingrese una Cedula de identidad con una longitud valida");}
    if(Cedula.getText().length()>=7){
    Pattern patter = Pattern.compile("^[0]");
    Matcher matcher = patter.matcher(Cedula.getText());
    /*if(matcher.matches()){a=false; mensaje.Alerta("Debe ingresar una cedula valida");}
    }*/
    if(matcher.find()){a=false;mensaje.Alerta("Debe ingresar una Cedula Valida");}
    }
    if(usuarioFunciones.ComprobarCedula(Cedula.getText())){
    a=false;
    mensaje.Alerta("Error! Esta Cedula ya esta registrada");
    }
    if(userType.getValue()==null){a=false; mensaje.Alerta("Debe seleccionar los privilegios del Usuario: Administrador o Personal");}
    return a;
    }
    public void Crud(int C){
    Crud=C;
    if(C==2){
    Cedula.setEditable(false);
    Pass.setDisable(false);
    Pass.setVisible(true);
    }
    }
    public void Recibir(String U,String nombre, String UT){
    Cedula.setText(U);
    Nombre.setText(nombre);
    userType.setValue(UT);
    
    }
    private void RegistarBitacora(String usuario,String Descripcion){
    
        CrudBitacora crudBi=new CrudBitacora();
        long now = System.currentTimeMillis();
        Timestamp sqlTimeDate=new Timestamp(now);
        bit=new Bitacora(usuario, sqlTimeDate, Descripcion);
        if(crudBi.RegistrarBITACORA(bit)){
            
        }else{mensaje.Alerta("Ha ocurrido un error al registrar acción en la bitacora");}
    }
}
