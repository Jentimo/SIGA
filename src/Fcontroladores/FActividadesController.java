/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fcontroladores;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import Otros.Error;
import controladores.ActividadController;
import crud.CrudActi;
import crud.CrudBitacora;
import funciones.Bitacora;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import static org.mariadb.jdbc.internal.com.send.authentication.ed25519.Utils.bit;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FActividadesController implements Initializable {

    @FXML
    private JFXTextField Texto;
    @FXML
    private Button registrar;
    private Error mensaje= new Error();
    String User;
    private CrudActi acti= new CrudActi();
    private Bitacora bit;
    ActividadController Acti2;
    private int Crud,Id,ACTIVO;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        star();
    }    
  public void star(){
  registrar.setOnAction(registr);
  Texto.setOnKeyPressed(go);
  }
private EventHandler<ActionEvent> registr= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
           if(Funcion()==true){
           Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
           }
        }
};
private EventHandler<KeyEvent> go= new EventHandler<KeyEvent>(){
        @Override
        public void handle(KeyEvent event) {
          if(event.getCode().equals(KeyCode.ENTER)){
          if(Funcion()==true){
           Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
           }
          }
   
        }
};
private boolean Funcion(){
    boolean a=false;
            if(Texto.getText().length()==0){
                mensaje.Alerta("Debe ingresar el nombre de la actividad");
                a=false;
            }
            else{
                a=true;
                String Texto1="";
                if(Crud==2){
                    String compro=Texto.getText();
                    compro.replaceAll("\\s","");
                    if(acti.Comprobar(compro.toLowerCase())){
                     acti.Update(Texto.getText(), Id, ACTIVO);
                    mensaje.Info("Se ha actualizado la actividad correctamente");
                     Texto1="Ha actualizado la actividad numero "+Id;
                    }else{
                    a=false;
                    mensaje.Alerta("La informacion a actualizar ya esta registrada dentro del sistema");
                    }
                   
                }else{
                    String compro=Texto.getText();
                    compro.replaceAll("\\s","");
                    if(acti.Comprobar(compro.toLowerCase())){
                    try {
                    acti.Insert(Texto.getText());
                    mensaje.Info("Se ha agregado la actividad correctamente");
                    Texto1="Ha registrado la actividad  numero "+acti.MaxId();          
                    } catch (SQLException ex) {
                    Logger.getLogger(FActividadesController.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }else{
                        a=false;
                    mensaje.Alerta("La actividad que desea ingresar ya se encuentra registrada");
                    }
                    
                }
                if(a==true){
                RegistarBitacora(User,Texto1);
                    Acti2.actualizar();
                }
                     
            }
            return a;
}
public void recibir_U(String Usuario){
User=Usuario;
}
public void recibirStage(ActividadController Acti){
         Acti2 = Acti;
}
public void Recibir(int c, String Text, int Activo, int ID){
Crud=c;
Texto.setText(Text);
Id=ID;
ACTIVO=Activo;
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
