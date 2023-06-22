/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Entidades.Actividades;
import Entidades.Region;
import Entidades.Sede;
import Fcontroladores.FActividadesController;
import Fcontroladores.FRegionController;
import com.jfoenix.controls.JFXTextField;
import crud.CrudReg;
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
import com.jfoenix.controls.JFXButton;
import crud.CrudBitacora;
import funciones.Bitacora;
import java.sql.Timestamp;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableRow;
import static org.mariadb.jdbc.internal.com.send.authentication.ed25519.Utils.bit;
import verContro.DatosRegController;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class RegionController implements Initializable {

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
    private JFXTextField Filtro;
    @FXML
    private Button Create;
    @FXML
    private Button Read;
    @FXML
    private Button Dele;
    private navegacion nav= new navegacion();
    @FXML
    private TableColumn c0;
    @FXML
    private TableColumn c1;
    RegionController Rega;
    CrudReg funci= new CrudReg();
    Region region= new Region();
    Error mensaje= new Error();
    @FXML
    private TableColumn c2;
    private Bitacora bit;
    @FXML
    private JFXButton Update;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        c0.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
        c1.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        c2.setCellValueFactory(new PropertyValueFactory<>("acti"));
                     Tablew.setRowFactory(tv -> new TableRow<Region>() {
    @Override
    protected void updateItem(Region item, boolean empty) {
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
        Rega=this;
        
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
 Create.setOnAction(Go);
 Dele.setOnAction(delete);
 Update.setOnAction(Updates);
 Read.setOnAction(ver);
 }
 private EventHandler<ActionEvent> ver= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            if(Tablew.getSelectionModel().getSelectedItem()!=null){
            try {
             region=(Region)Tablew.getSelectionModel().getSelectedItem();
            Stage stage2=new Stage();
            FXMLLoader loader= new FXMLLoader();
            AnchorPane root;
            root = (AnchorPane)loader.load(getClass().getResource("/ver/DatosReg.fxml").openStream());
            DatosRegController buslig=(DatosRegController)loader.getController();
            buslig.Recibir(region);
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/Otros/fullpackstyling.css");
            stage2.setScene(scene);
            stage2.alwaysOnTopProperty();
            stage2.setResizable(false);
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.setTitle("Ver Region");
            stage2.show();
        } catch (IOException ex) {
            Logger.getLogger(RegionController.class.getName()).log(Level.SEVERE, null, ex);
        }
            }else{
                mensaje.Alerta("Debe selecioanr un elemento de la cadena");
            }
        }
 };
 private EventHandler<ActionEvent> Go= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            ventana(0,"Registar Region","","");
        }
 };
 private EventHandler<ActionEvent>Updates= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
           if(Tablew.getSelectionModel().getSelectedItem()!=null){
               region=(Region)Tablew.getSelectionModel().getSelectedItem();
               ventana(2,"Actualzar Region",region.getNombre(),region.getCodigo());
           } 
        }
 };
 private void ventana(int C,String titulo,String Nombre,String ID){
        try {
            Stage stage2=new Stage();
            FXMLLoader loader= new FXMLLoader();
            AnchorPane root;
            root = (AnchorPane)loader.load(getClass().getResource(nav.Rutas(1,4)).openStream());
            FRegionController buslig=(FRegionController)loader.getController();
            buslig.recibir_U(nav.retornarU(),"Registrar Region",Rega);
            if(C==2){
            buslig.RecibirD(Nombre,ID,C);
            }
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/Otros/fullpackstyling.css");
            stage2.setScene(scene);
            stage2.alwaysOnTopProperty();
            stage2.setResizable(false);
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.setTitle(titulo);
            stage2.show();
        } catch (IOException ex) {
            Logger.getLogger(RegionController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
 }
 private EventHandler<ActionEvent> delete= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            if (Tablew.getSelectionModel().getSelectedItem()!=null) {
                region=(Region)Tablew.getSelectionModel().getSelectedItem();
                String accion="";
                if(region.getActivo()==0){
                    accion="Habilitado";
                    mensaje.Info("Se ha habiltado la region "+region.getNombre());
                }else{
                    accion="Deshabilitado";
                    mensaje.Info("Se ha deshabilitado la region "+region.getNombre());
                }
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                String user=window.getTitle().replace("Sistema de Gestion de Actividades - Usuario: ", "");
                RegistarBitacora(user,"Ha "+accion+" la region "+region.getNombre());
                funci.Delete(region.getCodigo());
                Refresh();
            }
        }
 };
 public void Refresh(){
     Tablew.setItems(funci.getDatosBita());
     Tablew.refresh();
     filtro();
 }
 
     private void RegistarBitacora(String usuario,String Descripcion){
    
        CrudBitacora crudBi=new CrudBitacora();
        long now = System.currentTimeMillis();
        Timestamp sqlTimeDate=new Timestamp(now);
        bit=new Bitacora(usuario, sqlTimeDate, Descripcion);
        if(crudBi.RegistrarBITACORA(bit)){
            
        }else{mensaje.Alerta("Ha ocurrido un error al registrar acción en la bitacora");}
    }
     private void filtro(){
   FilteredList<Region> filteredData= new FilteredList<Region>(funci.getDatosBita(), b -> true);
   Filtro.textProperty().addListener((observable, oldValue, newValue) ->{
       filteredData.setPredicate(employee ->{
           if (newValue == null || newValue.isEmpty()){
               return true;
           }
           String lowerCaseFilter= newValue.toLowerCase();
           if(employee.getCodigo().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getNombre().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getActi().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else
               return false;
       });
   });
   SortedList<Region> sortedData= new SortedList<>(filteredData);
   sortedData.comparatorProperty().bind(Tablew.comparatorProperty());
   Tablew.setItems(sortedData);
   }
}
