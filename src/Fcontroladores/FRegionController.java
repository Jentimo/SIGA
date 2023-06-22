/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fcontroladores;

import com.jfoenix.controls.JFXTextField;
import controladores.RegionController;
import crud.CrudBitacora;
import funciones.Bitacora;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import Otros.Error;
import crud.CrudReg;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FRegionController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private JFXTextField text;
    @FXML
    private Button cancel;
    @FXML
    private Button go;
    private String Usuario,Texto;
    RegionController Reg;
    private Bitacora bit;
    private Error mensaje= new Error();
    private CrudReg funci= new CrudReg();
    int Crud;
    String ID;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        go.setOnAction(Gogo);
    }    
    public void recibir_U(String U,String Text,RegionController Control){
        Usuario=U;
        label.setText(Text);
        Reg=Control;
        
    }
    private EventHandler<ActionEvent> Gogo= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            boolean a=false;
            if(text.getText().length()==0){
                mensaje.Alerta("Debe Ingresar la region");
            }
            else{
               if(Crud==2){
                    String compro=text.getText();
                    compro.replaceAll("\\s","");
                    if(funci.Comprobar(compro.toLowerCase())){
                        a=true;
                    funci.Update(text.getText().toUpperCase(),ID);
               mensaje.Info("Se ha actualizado la region");
               RegistarBitacora(Usuario,"Ha actualizado la region id"+ID);
               Reg.Refresh();
                    }else{
                        a=false;
                    mensaje.Alerta("Los datos a actualizar se encuentran dentro del sistema");
                    }
               
               }else{
                   String compro=text.getText();
                    compro.replaceAll("\\s","");
                    if(funci.Comprobar(compro.toLowerCase())){
                        a=true;
                     funci.Inert(text.getText().toUpperCase(),Codigo(text.getText()));
                         mensaje.Info("Se ha registrado la region");
                        RegistarBitacora(Usuario,"Ha registrado la region "+Codigo(text.getText()));
                        Reg.Refresh();
                    }else{
                    a=false;
                    mensaje.Alerta("La region ya se encuentra registrada");
                    }
              
               }
               if(a==true){
               Node source = (Node) event.getSource();
               Stage stage = (Stage) source.getScene().getWindow();
               stage.close();
               }
               
            }
        }
    };
    private EventHandler<ActionEvent> cancelar= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            Node source = (Node) event.getSource();
               Stage stage = (Stage) source.getScene().getWindow();
               stage.close();
        }
        
    };
    public void RecibirD(String texto, String id, int Cr){
    text.setText(texto);
    ID=id;
    Crud=Cr;
    }
    private String Codigo(String Code){
        String Codigo="";
        Codigo=Code;
        String Aux;
        if(Codigo.contains(" ")){
            String name2=Codigo.replaceAll("\\s{2,}"," ");
            Codigo=name2;
            String [] part;
            part=Codigo.split(" ");
            Aux=""+part[0].charAt(0)+part[1].charAt(0)+part[1].charAt(1);
            Codigo=Aux.toUpperCase();
        }else{
            Aux=""+Codigo.charAt(0)+Codigo.charAt(1)+Codigo.charAt(2);
            Codigo=Aux.toUpperCase();
        }
        return Codigo;
    
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
