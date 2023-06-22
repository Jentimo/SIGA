/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fcontroladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import controladores.ReporteController;
import crud.CrudReporte;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import Otros.Error;
import crud.CrudActi;
import crud.CrudBitacora;
import crud.CrudComputador;
import funciones.Bitacora;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static org.mariadb.jdbc.internal.com.send.authentication.ed25519.Utils.bit;

/**
 * FXML Controller class
 *
 * @author Timaure
 */
public class FReporteController implements Initializable {

    @FXML
    private JFXButton search;
    @FXML
    private JFXDatePicker inicio;
    @FXML
    private JFXDatePicker ffinal;
    @FXML
    private ComboBox actividad;
    @FXML
    private JFXTextField codigo;
    @FXML
    private JFXTextField Ncomputador;
    @FXML
    private TextArea Descripcion;
    @FXML
    private JFXButton Cancelar;
    @FXML
    private JFXButton Registrar;
    Error mensaje= new Error();
    ReporteController controlador;
    private String Usuario;
    private CrudReporte funciones= new CrudReporte();
    private CrudActi actividades= new CrudActi();
    FReporteController controlador1;
    @FXML
    private JFXTextField depsed;
    private CrudComputador funciC= new CrudComputador();
    private Bitacora bit;
    private int Cr;
    @FXML
    private Label label1;
    private int id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        controlador1=this;
        Descripcion.setWrapText(true);
        ffinal.setValue(LocalDate.now());
      /*   ffinal.setDayCellFactory(param -> new DateCell() {
    private LocalDate now = LocalDate.now();
    @Override
    public void updateItem(LocalDate date, boolean empty) {
        super.updateItem(date, empty);
        if (date != null && !empty) {
            setDisable(date.compareTo(now) < 0);
        }
    }
}); */
          inicio.setDayCellFactory(param -> new DateCell() {
    private LocalDate now = LocalDate.now();
    @Override
    public void updateItem(LocalDate date, boolean empty) {
        super.updateItem(date, empty);
        if (date != null && !empty) {
            setDisable(date.compareTo(now) > 0);
        }
    }
}); 
          search.setOnAction(Make);
          codigo.setEditable(false);
          depsed.setEditable(false);
          actividad.setItems(actividades.getDatosString());
          Cancelar.setOnAction(cancelado);
          Registrar.setOnAction(regis);
          Ncomputador.setOnKeyPressed(numeros);
    }    
    public void recibir(ReporteController controler,String User){
        controlador=controler;
        Usuario=User;
    }
    private EventHandler<ActionEvent> Make= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            try {
                Stage stage2=new Stage();
                FXMLLoader loader= new FXMLLoader();
                AnchorPane root;
                root = (AnchorPane)loader.load(getClass().getResource("/formularios/GetDepSed.fxml").openStream());
                GetDepSedController buslig=(GetDepSedController)loader.getController();
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                String user=window.getTitle().replace("Sistema de Gestion de Actividades - Usuario: ", "");
                buslig.Recibir(controlador1);
                root.getStylesheets().add(getClass().getResource("/Otros/fullpackstyling.css").toString());
                Scene scene = new Scene(root);
                //scene.getStylesheets().add("/Otros/fullpackstyling.css");
                stage2.setScene(scene);
                stage2.alwaysOnTopProperty();
                stage2.setResizable(false);
                stage2.initModality(Modality.APPLICATION_MODAL);
                stage2.setTitle("Buscar Departamento Sede");
                stage2.show();
            } catch (IOException ex) {
                Logger.getLogger(FReporteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    private EventHandler<ActionEvent> regis= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            boolean b=Comprobrar();
            if(Cr==1){
                 if(b==true){
                String COMPU=codigo.getText()+Ncomputador.getText();
                boolean comproC=funciC.comprobrar(COMPU);
                if(comproC==false){
                    funciC.Insert(COMPU,codigo.getText());
                }
                String[] Partes=actividad.getSelectionModel().getSelectedItem().toString().split("-");
                
                funciones.Insert(funciC.GetId(COMPU), java.sql.Date.valueOf(inicio.getValue()),
                        java.sql.Date.valueOf(ffinal.getValue()),Descripcion.getText(), Usuario, Integer.parseInt(Partes[1]));
                mensaje.Info("Se ha Registrado el reporte");
                RegistarBitacora(Usuario,"Ha registrado el reporte de actividad numero= "+funciones.MaxId());
                controlador.Refresh();
            }
            }
            if(Cr==2){
                String COMPU=codigo.getText()+Ncomputador.getText();
                boolean comproC=funciC.comprobrar(COMPU);
                if(comproC==false){
                    funciC.Insert(COMPU,codigo.getText());
                }
                String[] Partes=actividad.getSelectionModel().getSelectedItem().toString().split("-");
                
                funciones.Update(funciC.GetId(COMPU),java.sql.Date.valueOf(inicio.getValue()),
                        java.sql.Date.valueOf(ffinal.getValue()),Descripcion.getText(),Integer.parseInt(Partes[1]), id);
                mensaje.Info("Se ha Actualizado el reporte");
                RegistarBitacora(Usuario,"Ha Actualizado el reporte de actividad numero= "+id);
                controlador.Refresh();
            }
            Node source = (Node) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
            
           
        }
    };
    private boolean Comprobrar(){
        boolean a=true;
        if(inicio.getValue()==null)a=false;
        if(ffinal.getValue()==null)a=false;
        if(actividad.getSelectionModel().getSelectedItem()==null)a=false;
        if(codigo.getText().isEmpty())a=false;
        if(Ncomputador.getText().isEmpty())a=false;
        if(Descripcion.getText().isEmpty())a=false;
        if(a==false)mensaje.Alerta("Debe ingresar todos los campos para el reporte");
        return a;
    }
    public void RecibirDepSed(String Codio){
    codigo.setText(Codio);
    depsed.setText(Codio);
    }
     private EventHandler<ActionEvent> cancelado= new EventHandler<ActionEvent>(){
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
    public void CRUD(int C){
        Cr=C;
    if(C==3){
    inicio.setEditable(false);
    ffinal.setEditable(false);
    actividad.setEditable(false);
    codigo.setEditable(false);
    Ncomputador.setEditable(false);
    Descripcion.setEditable(false);
    depsed.setEditable(false);
    search.setDisable(true);
    label1.setText("Ver Reporte");
    Registrar.setText("Volver");
    }
    if(C==2){
    label1.setText("Actualizar Reporte");
    Registrar.setText("Actualizar");
    }
    }
       public void visual(Date comienzo,Date finalizado, String acti,String Code,
               String number, String descripcion,int ID){
       inicio.setValue(comienzo.toLocalDate());
       ffinal.setValue(finalizado.toLocalDate());
       actividad.getSelectionModel().select(acti);
       codigo.setText(Code);
       Ncomputador.setText(number);
       Descripcion.setText(descripcion);
       depsed.setText(Code);
       id=ID;
       }
       
              private EventHandler<KeyEvent> numeros= new EventHandler<KeyEvent>(){
    @Override
        public void handle(KeyEvent event) {
                int c = event.getCharacter().charAt(0);
                if((!Character.isDigit(c))){
                    Toolkit.getDefaultToolkit().beep();
                    event.consume();}
    };
        };
           private EventHandler<KeyEvent>Numeros= new EventHandler<KeyEvent>(){
        @Override
        public void handle(KeyEvent event) {
             int c = event.getCharacter().charAt(0);
                if((!Character.isDigit(c))){
                    Toolkit.getDefaultToolkit().beep();
                    event.consume();
        }
    }
    };
}
