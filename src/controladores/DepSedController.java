/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Entidades.Actividades;
import Entidades.DepSed;
import Entidades.Sede;
import Fcontroladores.FActividadesController;
import Fcontroladores.FDepSedController;
import com.jfoenix.controls.JFXTextField;
import crud.CrudDepSed;
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
import java.sql.SQLException;
import java.sql.Timestamp;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableRow;
import static org.mariadb.jdbc.internal.com.send.authentication.ed25519.Utils.bit;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class DepSedController implements Initializable {

    @FXML
    private BorderPane fondo;
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
    private CrudDepSed depsed= new CrudDepSed();
    DepSedController controlador;
    Error mensaje= new Error();
    DepSed objeto= new DepSed();
    @FXML
    private TableColumn c3;
    private Bitacora bit;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        controlador=this;
        c0.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
        c1.setCellValueFactory(new PropertyValueFactory<>("NombreD"));
        c2.setCellValueFactory(new PropertyValueFactory<>("NombreS"));
        c3.setCellValueFactory(new PropertyValueFactory<>("acti"));
        Tablew.setRowFactory(tv -> new TableRow<DepSed>() {
            @Override
            protected void updateItem(DepSed item, boolean empty) {
                super.updateItem(item, empty);
                    if (item == null || item.getActi() == null)
                        setStyle("");
                    else if (item.getActi()=="NO")
                        setStyle("-fx-background-color: #f26161;");
                    else
                        setStyle("");
            }   
        });
        Refres();
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
 }
    private EventHandler<ActionEvent> crear = new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
          Ventanas(nav.retornarU());
        }
    };
    private void Ventanas(String user){
      try {
                Stage stage2=new Stage();
                FXMLLoader loader= new FXMLLoader();
                AnchorPane root;
                root = (AnchorPane)loader.load(getClass().getResource(nav.Rutas(1,2)).openStream());
                FDepSedController buslig=(FDepSedController)loader.getController();
                
                buslig.Recibir(controlador,user,"Registrar Departamento Sede");
                root.getStylesheets().add(getClass().getResource("/Otros/fullpackstyling.css").toString());
                Scene scene = new Scene(root);
                //scene.getStylesheets().add("/Otros/fullpackstyling.css");
                stage2.setScene(scene);
                stage2.alwaysOnTopProperty();
                stage2.setResizable(false);
                stage2.initModality(Modality.APPLICATION_MODAL);
                stage2.setTitle("Registrar Departamento Sede");
                stage2.show();
            } catch (IOException ex) {
                Logger.getLogger(DepSedController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
     private EventHandler<ActionEvent>Delete= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            if(Tablew.getSelectionModel().getSelectedItem()==null){
                mensaje.Alerta("Debe selecionar un objeto de la tabla");
            }
            else{
                String Sbitacora="";
                objeto=(DepSed)Tablew.getSelectionModel().getSelectedItem();
                String Codigo=objeto.Codigo();
                if(objeto.getActivo()==0){
                mensaje.Info("Se ha Habilitado el Departamento/Sede: "+objeto.Codigo());
                Sbitacora="Habilito";
                }
                else{
                mensaje.Info("Se ha deshabilitado el Departamento/Sede: "+objeto.Codigo());
                Sbitacora="Deshabilito";
                }
                try {
                    depsed.Delete(Codigo);
                } catch (SQLException ex) {
                    Logger.getLogger(DepSedController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                String user=window.getTitle().replace("Sistema de Gestion de Actividades - Usuario: ", "");
                RegistarBitacora(user,"Ha "+Sbitacora+" el departamento/sede "+Codigo);
                Refres();
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
    public void Refres(){
        Tablew.setItems(depsed.getDatosBita());
        Tablew.refresh();
        filtro();
    }
    /* c0.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
        c1.setCellValueFactory(new PropertyValueFactory<>("NombreD"));
        c2.setCellValueFactory(new PropertyValueFactory<>("NombreS"));
        c3.setCellValueFactory(new PropertyValueFactory<>("acti"));*/
    
private void filtro(){
   FilteredList<DepSed> filteredData= new FilteredList<DepSed>(depsed.getDatosBita(), b -> true);
   Filtro.textProperty().addListener((observable, oldValue, newValue) ->{
       filteredData.setPredicate(employee ->{
           if (newValue == null || newValue.isEmpty()){
               return true;
           }
           String lowerCaseFilter= newValue.toLowerCase();
           if(employee.getCodigo().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getNombreD().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getNombreS().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getActi().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else
               return false;
       });
   });
   SortedList<DepSed> sortedData= new SortedList<>(filteredData);
   sortedData.comparatorProperty().bind(Tablew.comparatorProperty());
   Tablew.setItems(sortedData);
   }
}
