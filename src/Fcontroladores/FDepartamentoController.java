/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fcontroladores;

import com.jfoenix.controls.JFXTextField;
import controladores.DepartamentoController;
import crud.CrudDep;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
public class FDepartamentoController implements Initializable {

    @FXML
    private JFXTextField texto;
    @FXML
    private Button regis;
    DepartamentoController dep;
    private String Usuario;
    private Error mensaje= new Error();
    private CrudDep depa= new CrudDep();
    private Bitacora bit;
    int Crud;
    int Id;
    String Departamento;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Star();
    }    
    public void Star() {
    regis.setOnAction(Regis);
    }
    public void Controlador(DepartamentoController a){
        dep=a;
    }
    public void RecibirDatos(int ID, int CRUD, String NOMBRE){
    Id=ID;
    Crud=CRUD;
    texto.setText(NOMBRE);
    }
    public void RecibirU(String Usa){
        Usuario=Usa;
    }
    private EventHandler<ActionEvent>Regis= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            if(Crud==2){
                if(texto.getText().length()!=0){
                    String compro=texto.getText();
                    compro.replaceAll("\\s","");
                    if(depa.Comprobar(compro.toLowerCase())){
                     depa.Update(texto.getText(), Id);
                    mensaje.Info("Se ha actualizado el Departamento");
                    String U="Ha Actualizado el departamento numero "+Id;
                    RegistarBitacora(Usuario,U);
                    dep.Refresh();
                    Node source = (Node) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
                    }else{
                    mensaje.Alerta("Los datos a actualizar ya estan dentro del sistema");
                    }
                   
                }else{
                    mensaje.Alerta("Debe ingresar el nombre del departamento");
                }
            }else{
            if(texto.getText().length()!=0){
                String compro=texto.getText();
                    compro.replaceAll("\\s","");
                    if(depa.Comprobar(compro.toLowerCase())){
                    depa.Insert(texto.getText());
                    mensaje.Info("Se ha registrado el departamento  "+texto.getText());
                    String U="Ha registrado el departamento numero "+depa.MaxId();
                    RegistarBitacora(Usuario,U);
                    dep.Refresh();
                    Node source = (Node) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
                    }else{
                    mensaje.Alerta("El departamento ya se encuentra registrado");
                    }
                 
             }else{
                 mensaje.Alerta("Debe Ingresar el nombre del repartamento");    
             }     
            }
            
        }
    
    };
    public void Prueba(){
        System.out.println("Esto se ejecuta");
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
