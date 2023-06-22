/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fcontroladores;

import Entidades.DepSed;
import Entidades.Departamento;
import Entidades.Sede;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import controladores.DepSedController;
import crud.CrudBitacora;
import funciones.Bitacora;
import java.sql.Timestamp;
import Otros.Error;
import crud.CrudDep;
import crud.CrudDepSed;
import crud.CrudSed;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FDepSedController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private ComboBox sedes;
    @FXML
    private ComboBox departamento;
    @FXML
    private Button cancelar;
    @FXML
    private Button registrar;
    private String Texto,Usuario;
    DepSedController controlador2;
    private Bitacora bit;
    private Error mensaje= new Error();
    private CrudDep depa= new CrudDep();
    private CrudSed sede= new CrudSed();
    private DepSed DPS = new DepSed();
    private CrudDepSed funciones= new CrudDepSed();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sedes.getItems().add(null);
        sedes.setItems(sede.getDatos());
        departamento.getItems().add(null);
        departamento.setItems(depa.getDatosNombre());
        star();
    }    
    public void star(){
        registrar.setOnAction(Crear);
        cancelar.setOnAction(cancel);
    }
    public void Recibir(DepSedController controlador,String Usuar,String texto){
        controlador2=controlador;
        Usuario=Usuar;
        label.setText(texto);
    }
    private EventHandler<ActionEvent> Crear = new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
        boolean b=Comprobar();
        if(b==false){
            String sed[]=sedes.getSelectionModel().getSelectedItem().toString().split("-");        
            String dep[]=departamento.getSelectionModel().getSelectedItem().toString().split("-");
            DPS.setNombreD(dep[0]);
            DPS.setIdD(Integer.parseInt(dep[1]));
            DPS.setNombreS(sed[0]);
            DPS.setIdS(Integer.parseInt(sed[1]));
            boolean comprobar=funciones.Comprobar(DPS.getIdS(),DPS.getIdD());
            if(comprobar==false){
                funciones.Insert(DPS.Codigo(),DPS.getIdD(),DPS.getIdS());
                mensaje.Info("Se ha registrado el departamento-sede");
                controlador2.Refres();
                Node source = (Node) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
            }else{
                mensaje.Alerta("Este departamento Sede ya esta registrado");
            }
        }
        }
    };
    private EventHandler<ActionEvent> cancel= new EventHandler<ActionEvent>(){
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
    private boolean Comprobar(){
        boolean a=false;
        if(sedes.getSelectionModel().getSelectedItem()==null
           &&departamento.getSelectionModel().getSelectedItem()==null){
            mensaje.Alerta("Debe selecionar La sede y el departamento");
            a=true;
        }
        if(sedes.getSelectionModel().getSelectedItem()==null
           &&departamento.getSelectionModel().getSelectedItem()!=null){
            mensaje.Alerta("Debe seleccionar el departamento");
            a=true;
        }
        if(sedes.getSelectionModel().getSelectedItem()!=null
           &&departamento.getSelectionModel().getSelectedItem()==null){
            mensaje.Alerta("Debe seleccionar la sede");
            a=true;
        }
        return a;
    }
}
