/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Entidades.Actividades;
import Entidades.Departamento;
import Fcontroladores.FActividadesController;
import Fcontroladores.FDepartamentoController;
import com.jfoenix.controls.JFXTextField;
import crud.CrudBitacora;
import crud.CrudDep;
import funciones.Bitacora;
import funciones.navegacion;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
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
import java.sql.SQLException;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableRow;
import verContro.DatosDepController;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class DepartamentoController implements Initializable {

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
    private TableColumn C0;
    @FXML
    private TableColumn C1;
    @FXML
    private JFXTextField Filtro;
    @FXML
    private Button Create;
    @FXML
    private Button Updte;
    @FXML
    private Button Dele;
    private navegacion nav= new navegacion();
    private CrudDep dep= new CrudDep();
    DepartamentoController Depa;
    private Departamento dpt = new Departamento();
    private Bitacora bit;
    private Error mensaje= new Error();
    @FXML
    private TableColumn C2;
    @FXML
    private JFXButton Create1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Depa=this;
        C0.setCellValueFactory(new PropertyValueFactory<>("id"));
        C1.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        C2.setCellValueFactory(new PropertyValueFactory<>("acti"));
                     Tablew.setRowFactory(tv -> new TableRow<Departamento>() {
    @Override
    protected void updateItem(Departamento item, boolean empty) {
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
 Create.setOnAction(creates);
 Dele.setOnAction(Delete);
 Updte.setOnAction(Update);
 Create1.setOnAction(ver);
 }
    private EventHandler<ActionEvent> Update= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
         if(Tablew.getSelectionModel().getSelectedItem()!=null){
               try {
                dpt=(Departamento)Tablew.getSelectionModel().getSelectedItem();
                Stage stage2=new Stage();
                FXMLLoader loader= new FXMLLoader();
                AnchorPane root;
                root = (AnchorPane)loader.load(getClass().getResource(nav.Rutas(1,3)).openStream());
                FDepartamentoController buslig=(FDepartamentoController)loader.getController();
                buslig.RecibirU(nav.retornarU());
                buslig.Controlador(Depa);
                buslig.RecibirDatos(dpt.getId(),2,dpt.getNombre());
                Scene scene = new Scene(root);
                scene.getStylesheets().add("/Otros/fullpackstyling.css");
                stage2.setScene(scene);
                stage2.alwaysOnTopProperty();
                stage2.setResizable(false);
                stage2.initModality(Modality.APPLICATION_MODAL);
                stage2.setTitle("Actualizar Departamento");
                stage2.show();
            } catch (IOException ex) {
                Logger.getLogger(DepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
            }
         }else{
             mensaje.Alerta("Debe Selecionar un elemento de la tabla ");
         }   
        }
    };
    private EventHandler<ActionEvent> creates= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            try {
                Stage stage2=new Stage();
                FXMLLoader loader= new FXMLLoader();
                AnchorPane root;
                root = (AnchorPane)loader.load(getClass().getResource(nav.Rutas(1,3)).openStream());
                FDepartamentoController buslig=(FDepartamentoController)loader.getController();
                buslig.RecibirU(nav.retornarU());
                buslig.Controlador(Depa);
                buslig.Prueba();
                Scene scene = new Scene(root);
                scene.getStylesheets().add("/Otros/fullpackstyling.css");
                stage2.setScene(scene);
                stage2.alwaysOnTopProperty();
                stage2.setResizable(false);
                stage2.initModality(Modality.APPLICATION_MODAL);
                stage2.setTitle("Registrar Departamento");
                stage2.show();
            } catch (IOException ex) {
                Logger.getLogger(DepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };
    private EventHandler<ActionEvent> ver= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            if(Tablew.getSelectionModel().getSelectedItem()!=null){
                dpt=(Departamento)Tablew.getSelectionModel().getSelectedItem();
                  try {
                Stage stage2=new Stage();
                FXMLLoader loader= new FXMLLoader();
                AnchorPane root;
                root = (AnchorPane)loader.load(getClass().getResource("/ver/DatosDep.fxml").openStream());
                DatosDepController buslig=(DatosDepController)loader.getController();
                buslig.RecibirDep(dpt);
                Scene scene = new Scene(root);
                scene.getStylesheets().add("/Otros/fullpackstyling.css");
                stage2.setScene(scene);
                stage2.alwaysOnTopProperty();
                stage2.setResizable(false);
                stage2.initModality(Modality.APPLICATION_MODAL);
                stage2.setTitle("Ver Departamento");
                stage2.show();
            } catch (IOException ex) {
                Logger.getLogger(DepartamentoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else{
                mensaje.Alerta("Debe seleccionar un elemento de la tabla");
            }
        }    
    };
     private EventHandler<ActionEvent> Delete= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
        if(Tablew.getSelectionModel().getSelectedItem()!=null){
            dpt=(Departamento)Tablew.getSelectionModel().getSelectedItem();
            String accion="";
            if(dpt.getActivo()==0){
            accion="Habilito";
            mensaje.Info("Se ha habilitado el departamento "+dpt.getNombre());
            }else{
            accion="Deshabilito";
            mensaje.Info("Se ha deshabilitado del departamento "+dpt.getNombre());
            }
            RegistarBitacora(nav.retornarU(),"Ha "+accion+" el departamento "+dpt.getNombre());
            dep.Delete(dpt.getId());
            Refresh();
        }else{
            mensaje.Alerta("Debe selecionar un elemento de la tabla");
        }
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
    public void Refresh(){
    Tablew.setItems(dep.getDatosBita());
            Tablew.refresh();
            filtro();
    }
       private void filtro(){
   FilteredList<Departamento> filteredData= new FilteredList<Departamento>(dep.getDatosBita(), b -> true);
   Filtro.textProperty().addListener((observable, oldValue, newValue) ->{
       filteredData.setPredicate(employee ->{
           if (newValue == null || newValue.isEmpty()){
               return true;
           }
           String lowerCaseFilter= newValue.toLowerCase();
           if(String.valueOf(employee.getId()).indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getNombre().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getActi().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else
               return false;
       });
   });
   SortedList<Departamento> sortedData= new SortedList<>(filteredData);
   sortedData.comparatorProperty().bind(Tablew.comparatorProperty());
   Tablew.setItems(sortedData);
   }
}
