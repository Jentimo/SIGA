/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Entidades.Actividades;
import Entidades.Usuario;
import Fcontroladores.FActividadesController;
import Fcontroladores.FUsuarioController;
import com.jfoenix.controls.JFXTextField;
import crud.CrudUser;
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
import verContro.DatosUserController;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class UsersController implements Initializable {

    @FXML
    private MenuBar Mymenu;
    @FXML
    private Menu User;
    @FXML
    private MenuItem MyUser;
    @FXML
    private Menu IVSS;
    @FXML
    private MenuItem Sed;
    @FXML
    private MenuItem Dep;
    @FXML
    private MenuItem DepSed;
    @FXML
    private MenuItem Reg;
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
    private Button Updte;
    @FXML
    private Button Dele;
    private navegacion nav= new navegacion();
    @FXML
    private TableColumn c0;
    @FXML
    private TableColumn c1;
    @FXML
    private TableColumn c2;
    @FXML
    private TableColumn c3;
    @FXML
    private TableColumn c4;
    private CrudUser funcionesU= new CrudUser();
    UsersController controlador;
    Error mensaje= new Error();
    private Bitacora bit;
    Usuario usuario= new Usuario();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       c0.setCellValueFactory(new PropertyValueFactory<>("Cedula"));
       c1.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
       c2.setCellValueFactory(new PropertyValueFactory<>("Acceso"));
       c3.setCellValueFactory(new PropertyValueFactory<>("Acti"));
       c4.setCellValueFactory(new PropertyValueFactory<>("Fecha"));
       Tablew.setRowFactory(tv -> new TableRow<Usuario>() {
    @Override
    protected void updateItem(Usuario item, boolean empty) {
        super.updateItem(item, empty);
        if (item == null || item.getActi() == null)
            setStyle("");
        else if (item.getActi()=="NO")
            setStyle("-fx-background-color:#f26161;");
        else
            setStyle("");
    }
});
        nave();
        Refresh();
        controlador=this;
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
 Create.setOnAction(registrarUsuario);
 Dele.setOnAction(Activo);
 Updte.setOnAction(ActualizarU);
 Read.setOnAction(ver);
 }
    public void Refresh(){
   
    
    Tablew.setItems(funcionesU.getDatosBita());
    Tablew.refresh();
    filtro();
    }
    private void Ventanas(String Titulo, String user, int C, Usuario usuario){
        try {
            Stage stage2=new Stage();
            FXMLLoader loader= new FXMLLoader();
            AnchorPane root;
            root = (AnchorPane)loader.load(getClass().getResource(nav.Rutas(1,6)).openStream());
            FUsuarioController buslig=(FUsuarioController)loader.getController();
            buslig.Recibir_Parametros(controlador, user);
            if(C==2){
            buslig.Crud(2);
            buslig.Recibir(usuario.getCedula(), usuario.getNombre(),usuario.getAcceso());
            }
            root.getStylesheets().add(getClass().getResource("/Otros/fullpackstyling.css").toString());
            Scene scene = new Scene(root);
            stage2.setScene(scene);
            stage2.alwaysOnTopProperty();
            stage2.setResizable(false);
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.setTitle(Titulo);
            stage2.show(); 
            } catch (IOException ex) {
                Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    private EventHandler<ActionEvent> ver= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
         if(Tablew.getSelectionModel().getSelectedItem()!=null){
         try {
             usuario=(Usuario)Tablew.getSelectionModel().getSelectedItem();
            Stage stage2=new Stage();
            FXMLLoader loader= new FXMLLoader();
            AnchorPane root;
            root = (AnchorPane)loader.load(getClass().getResource("/ver/DatosUser.fxml").openStream());
            DatosUserController buslig=(DatosUserController)loader.getController();
            buslig.Recibir(usuario);
            root.getStylesheets().add(getClass().getResource("/Otros/fullpackstyling.css").toString());
            Scene scene = new Scene(root);
            stage2.setScene(scene);
            stage2.alwaysOnTopProperty();
            stage2.setResizable(false);
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.setTitle("Ver Sede");
            stage2.show(); 
            } catch (IOException ex) {
                Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            }
         }else{
             mensaje.Alerta("Debe seleccionar un elemento de la tabla");
         }
        }    
    };
    private EventHandler<ActionEvent> registrarUsuario= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            String user=window.getTitle().replace("Sistema de Gestion de Actividades - Usuario: ", "");
            Ventanas("Registrar Usuario",user,0,usuario);
        }
    };
        private EventHandler<ActionEvent> ActualizarU= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
          if(Tablew.getSelectionModel().getSelectedItem()!=null){
                usuario=(Usuario)Tablew.getSelectionModel().getSelectedItem();
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                String user=window.getTitle().replace("Sistema de Gestion de Actividades - Usuario: ", "");
                Ventanas("Actualizar Usuario",user,2,usuario);
          }else{
              mensaje.Alerta("Debe seleccionar un elemento de la tabla");
          }
        }
    };
    private EventHandler<ActionEvent> Activo= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            if(Tablew.getSelectionModel().getSelectedItem()==null){
               mensaje.Alerta("Debe selecionar un Usuario");
            }else{
                usuario=(Usuario)Tablew.getSelectionModel().getSelectedItem();
                String accion="";
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                String user=window.getTitle().replace("Sistema de Gestion de Actividades - Usuario: ", "");
                if(usuario.getActivo()==0){
                mensaje.Info("se ha habilitado al usuario" + usuario.getCedula());
                accion="habiliado";
                }else{
                mensaje.Info("Se ha deshabilitado al usuario "+usuario.getCedula());
                accion="deshabilitado";
                }
                RegistarBitacora(user,"Ha "+accion+ " al usuario "+usuario.getCedula());
                funcionesU.Delete(usuario.getCedula());
                Refresh();
            }
        }
    };
    
       private void filtro(){
   FilteredList<Usuario> filteredData= new FilteredList<Usuario>(funcionesU.getDatosBita(), b -> true);
   Filtro.textProperty().addListener((observable, oldValue, newValue) ->{
       filteredData.setPredicate(employee ->{
           if (newValue == null || newValue.isEmpty()){
               return true;
           }
           String lowerCaseFilter= newValue.toLowerCase();
           if(employee.getCedula().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getNombre().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getAcceso().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getActi().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getFecha().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else
               return false;
       });
   });
   SortedList<Usuario> sortedData= new SortedList<>(filteredData);
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
