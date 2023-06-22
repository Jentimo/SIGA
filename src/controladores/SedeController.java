/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Entidades.Sede;
import Entidades.Usuario;
import Fcontroladores.FActividadesController;
import Fcontroladores.FsedeController;
import com.jfoenix.controls.JFXTextField;
import crud.CrudSed;
import funciones.navegacion;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Otros.Error;
import crud.CrudBitacora;
import funciones.Bitacora;
import java.sql.Timestamp;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableRow;
import static org.mariadb.jdbc.internal.com.send.authentication.ed25519.Utils.bit;
import verContro.DatosSedeController;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class SedeController implements Initializable {

    @FXML
    private BorderPane fondo;
    @FXML
    private MenuBar Mymenu;
    @FXML
    private Menu User;
    @FXML
    private MenuItem MyUser;
    @FXML
    private MenuItem Reg;
    @FXML
    private Menu IVSS;
    @FXML
    private MenuItem Sed;
    @FXML
    private MenuItem Dep;
    @FXML
    private MenuItem DepSed;
    @FXML
    private Menu Service;
    @FXML
    private MenuItem Report;
    @FXML
    private MenuItem PC;
    @FXML
    private MenuItem Active;
    @FXML
    private MenuItem Bit;
    @FXML
    private TableView Tablew;
    @FXML
    private TableColumn c0;
    @FXML
    private TableColumn c1;
    @FXML
    private TableColumn c3;
    @FXML
    private JFXTextField Filtro;
    @FXML
    private Button Create;
    @FXML
    private Button Read;
    @FXML
    private Button Updte;
    @FXML
    private Button Dele;
    private navegacion nav= new navegacion();
    private CrudSed sede= new CrudSed();
    SedeController sedes;
    private Sede Seds= new Sede();
    private Error mensaje= new Error();
    @FXML
    private TableColumn c4;
    private Bitacora bit;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        sedes=this;
        c0.setCellValueFactory(new PropertyValueFactory<>("id"));
        c1.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        c3.setCellValueFactory(new PropertyValueFactory<>("Region"));
        c4.setCellValueFactory(new PropertyValueFactory<>("acti"));
             Tablew.setRowFactory(tv -> new TableRow<Sede>() {
    @Override
    protected void updateItem(Sede item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || item.getActi() == null)
            setStyle("");
        else if (item.getActi()=="NO")
            setStyle("-fx-background-color: #f26161;");

        else
            setStyle("");
    }
});
        Refresh();
        nave();
    }    
    private void nave(){
 MyUser.setOnAction(E->{
   Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,7, window,"Ingreso al modulo Usuario");});
 Reg.setOnAction(E->{
     Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,5, window,"Ingreso al modulo Region");});
 Sed.setOnAction(E->{
     Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,6, window,"Ingreso al modulo Sede");});
 Dep.setOnAction(E->{
     Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,3, window,"Ingreso al modulo Departamento");});
 DepSed.setOnAction(E->{
     Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,2, window,"Ingreso al modulo departamento/sede");});
 Report.setOnAction(E->{
     Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,10, window,"Ingreso al modulo Servicio");});
 PC.setOnAction(E->{
     Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,4, window,"Ingreso al modulo PC");});
 Active.setOnAction(E->{
     Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,8, window,"Ingreso al modulo actividad");});
 Bit.setOnAction(E->{
     Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,0, window,"Ingreso al modulo Bitacora");});
 Create.setOnAction(crear);
 Dele.setOnAction(Delete);
 Updte.setOnAction(Update);
 Read.setOnAction(ver);
 }
    public void Refresh(){
    Tablew.setItems(sede.getDatosBita());
    Tablew.refresh();
    filtro();
    }
    private EventHandler<ActionEvent> ver= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            if(Tablew.getSelectionModel().getSelectedItem()!=null){
                 try {
                Seds=(Sede)Tablew.getSelectionModel().getSelectedItem();
                     System.out.println(Seds.getNombre());
                Stage stage2=new Stage();
                FXMLLoader loader= new FXMLLoader();
                AnchorPane root;
                root = (AnchorPane)loader.load(getClass().getResource("/ver/DatosSede.fxml").openStream());
                DatosSedeController buslig=(DatosSedeController)loader.getController();
                buslig.recibir(Seds);
                Scene scene = new Scene(root);
                scene.getStylesheets().add("/Otros/fullpackstyling.css");
                stage2.setScene(scene);
                stage2.alwaysOnTopProperty();
                stage2.setResizable(false);
                stage2.initModality(Modality.APPLICATION_MODAL);
                stage2.setTitle("Ver Sede");
                stage2.show();
            } catch (IOException ex) {
                Logger.getLogger(SedeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else{
                mensaje.Alerta("Debe seleccionar una elemento de la tabla");
            }
        }
    };
    private void ventanas(String user, boolean a, Sede sede){
                try {
                Stage stage2=new Stage();
                FXMLLoader loader= new FXMLLoader();
                AnchorPane root;
                root = (AnchorPane)loader.load(getClass().getResource(nav.Rutas(1,7)).openStream());
                FsedeController buslig=(FsedeController)loader.getController();
                buslig.Recibir(user,"Registrar Sede",sedes);
                if(a==true){
                    String codigo= sede.getCodigo()+"-"+sede.getRegion();
                    buslig.RecibirD(sede.getNombre(), 2, sede.getId(), codigo);
                }
                Scene scene = new Scene(root);
                scene.getStylesheets().add("/Otros/fullpackstyling.css");
                stage2.setScene(scene);
                stage2.alwaysOnTopProperty();
                stage2.setResizable(false);
                stage2.initModality(Modality.APPLICATION_MODAL);
                stage2.setTitle("Registrar Sede");
                stage2.show();
            } catch (IOException ex) {
                Logger.getLogger(SedeController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private EventHandler<ActionEvent> crear= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            String user=window.getTitle().replace("Sistema de Gestion de Actividades - Usuario: ", "");
            boolean a=false;
            ventanas(user,a,Seds);
        } 
    };
    private EventHandler<ActionEvent>Update= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            if(Tablew.getSelectionModel().getSelectedItem()!=null){
                Seds=(Sede)Tablew.getSelectionModel().getSelectedItem();
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                String user=window.getTitle().replace("Sistema de Gestion de Actividades - Usuario: ", "");
                boolean a=true;
                ventanas(user,a,Seds);
            }else{
                mensaje.Alerta("Debe seleccionar un elemento de la tabla");
            }
        }
    };
    private EventHandler<ActionEvent> Delete= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
          if(Tablew.getSelectionModel().getSelectedItem()!=null){
              Seds=(Sede)Tablew.getSelectionModel().getSelectedItem();
              String Accion="";
              if(Seds.getActivo()==0){
              Accion="Habilitado";
              mensaje.Info("Se ha habilitado la sede "+Seds.getNombre());
              }else{
                  Accion="Deshabilitado";
                  mensaje.Info("Se ha deshabilitado la sede: "+Seds.getNombre());
              }
             Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                String user=window.getTitle().replace("Sistema de Gestion de Actividades - Usuario: ", "");
                RegistarBitacora(user,"Ha "+Accion+" la sede "+Seds.getNombre());
              sede.Delete(Seds.getId());
              Refresh();
          }
          else{
              mensaje.Alerta("Debe seleccionar la sede");
          }
        }    
    };
        private void filtro(){
   FilteredList<Sede> filteredData= new FilteredList<Sede>(sede.getDatosBita(), b -> true);
   Filtro.textProperty().addListener((observable, oldValue, newValue) ->{
       filteredData.setPredicate(employee ->{
           if (newValue == null || newValue.isEmpty()){
               return true;
           }
           String lowerCaseFilter= newValue.toLowerCase();
           if(employee.getRegion().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getNombre().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(String.valueOf(employee.getId()).toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getActi().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else
               return false;
       });
   });
   SortedList<Sede> sortedData= new SortedList<>(filteredData);
   sortedData.comparatorProperty().bind(Tablew.comparatorProperty());
   Tablew.setItems(sortedData);
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
