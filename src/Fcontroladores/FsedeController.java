/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fcontroladores;

import Entidades.Region;
import com.jfoenix.controls.JFXTextField;
import controladores.SedeController;
import crud.CrudReg;
import crud.CrudSed;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import Otros.Error;
import crud.CrudBitacora;
import funciones.Bitacora;
import java.sql.Timestamp;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FsedeController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private ChoiceBox regiones;
    @FXML
    private JFXTextField text;
    @FXML
    private Button cancel;
    @FXML
    private Button regis;
    SedeController Sede;
    private String Usuario;
    private CrudSed funci= new CrudSed();
    private CrudReg funcir= new CrudReg();
    private Error mensaje= new Error();
    private Region region= new Region();
    private Bitacora bit;
    int Crud;
    private int id;
            /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        regiones.getItems().add(null);
        regiones.setItems(funcir.getDatosNombre());
        regis.setOnAction(create);
        cancel.setOnAction(dele);
    }    
    public void Recibir(String usuario,String Texto,SedeController Controller){
        Usuario=usuario;
        label.setText(Texto);
        Sede=Controller;
    }
    public void RecibirD(String nombre, int C,int Id,String Regiones) {
    text.setText(nombre);
    Crud=C;
    regiones.setValue(Regiones);
    id=Id;
    }
    private EventHandler<ActionEvent> create= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            if(text.getText().length()!=0&&regiones.getSelectionModel().getSelectedItem()!=null){
                boolean a=false;
                if(Crud==2){
                    String Codigo=(String) regiones.getSelectionModel().getSelectedItem();
                    String [] part;
                    part=Codigo.split("-");
                     String compro=text.getText();
                    compro.replaceAll("\\s","");
                    if(funci.Comprobar(compro.toLowerCase(),part[0])){
                        a=true;
                        funci.Update(part[0],text.getText(),id);
                        RegistarBitacora(Usuario,"Ha actualizado la sede  "+id);
                        mensaje.Info("Se ha actualizado la sede");
                    }else{
                        mensaje.Alerta("Los datos a actualizar ya se encuentran dentro del Sistema");
                    }
                    
                    
                }else{
                    String Codigo=(String) regiones.getSelectionModel().getSelectedItem();
                    String [] part;
                    part=Codigo.split("-");
                    String compro=text.getText();
                    compro.replaceAll("\\s","");
                    if(funci.Comprobar(compro.toLowerCase(),part[0])){
                        a=true;
                        funci.Insert(part[0],text.getText());
                        mensaje.Info("Se ha registrado la sede "+text.getText());
                        RegistarBitacora(Usuario,"Registro la sede numero "+funci.MaxId());
                    }else{
                        mensaje.Alerta("Error! La sede:"+text.getText()+" region: "+part[1]+" ya se encuentra"
                                + "dentro del sistema");
                    }
                    
                }
                if(a==true){
                Sede.Refresh();
                Node source = (Node) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
                }
                
            }else{
                mensaje.Alerta("Debe seleccionar la region e ingresar el nombre de la sede");
            }
        }
    
    };
    private EventHandler<ActionEvent> dele= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
             Node source = (Node) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
        }
    };
     private void RegistarBitacora(String usuario,String Descripcion){
    
        CrudBitacora crudBi=new CrudBitacora();
        long now = System.currentTimeMillis();
        Timestamp sqlTimeDate=new Timestamp(now);
        bit=new Bitacora(usuario, sqlTimeDate, Descripcion);
        if(crudBi.RegistrarBITACORA(bit)){
            
        }else{mensaje.Alerta("Ha ocurrido un error al registrar acción en la bitacora");}
          
    
    }
}
