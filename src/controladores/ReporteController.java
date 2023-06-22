/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import BD.DBConexion;
import Fcontroladores.FActividadesController;
import Fcontroladores.FReporteController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import crud.CrudReporte;
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
import Entidades.Reporte;
import Otros.Alerta;
import com.jfoenix.controls.JFXComboBox;
import crud.CrudSed;
import funciones.Loggin;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import static jdk.nashorn.internal.objects.NativeRegExp.source;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class ReporteController implements Initializable {

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
    private Button Make_Report;
    private navegacion nav= new navegacion();
    ReporteController controlador1;
    private CrudReporte funciones= new CrudReporte();
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
    @FXML
    private TableColumn c5;
    @FXML
    private TableColumn c6;
    @FXML
    private TableColumn c7;
    @FXML
    private JFXButton Update;
    private Error mensaje= new Error();
    private Reporte entidad= new Reporte();
    @FXML
    private MenuItem ReportA;
    @FXML
    private JFXComboBox SEDES;
    private CrudSed funcionesSed=new CrudSed();
    public int Administrador;
    @FXML
    private ImageView ImaUser;
    @FXML
    private ImageView ImgIvss;
    @FXML
    private ImageView ImgBit;
    private Loggin log = new Loggin(); 
    @FXML
    String Usuario;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        controlador1=this;
        /*System.out.println(nav.retornarU());*/
        c0.setCellValueFactory(new PropertyValueFactory<>("id_report"));
        c1.setCellValueFactory(new PropertyValueFactory<>("fechai"));
        c2.setCellValueFactory(new PropertyValueFactory<>("fechaf"));
        c3.setCellValueFactory(new PropertyValueFactory<>("Computador"));
        c4.setCellValueFactory(new PropertyValueFactory<>("departamento"));
        c5.setCellValueFactory(new PropertyValueFactory<>("Sede"));
        c6.setCellValueFactory(new PropertyValueFactory<>("Actividad"));
        c7.setCellValueFactory(new PropertyValueFactory<>("Usuario"));
        Refresh();
        SEDES.setItems(funcionesSed.getDatos());
        SEDES.getItems().add("");
        TableItems();
        acceso();

    }    
   private int Comprobar(){
       int compro=0;
       compro=log.Type(nav.retornarU());
       return compro;
   }
    public void acceso(){
    if (Comprobar()==2) {
    Personal();
    }else{
    Admin();
    }
    
    }
    public void Admin(){
            ImaUser.setImage(new Image("/imagenes/usuario.png"));
            ImgIvss.setImage(new Image("/imagenes/hospital.png"));
            ImgBit.setImage(new Image("/imagenes/libro-abierto.png"));
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
  Bit.setOnAction(E->{
     Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,0, window,"Ingreso al modulo Bitacora");});
  Report.setOnAction(E->{
     Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,10, window,"Ingreso al modulo Servicio");});
 PC.setOnAction(E->{
     Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,4, window,"Ingreso al modulo PC");});
 Active.setOnAction(E->{
     Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,8, window,"Ingreso al modulo actividad");});
 Create.setOnAction(registrar);
 Read.setOnAction(Reading);
 Update.setOnAction(Updates);
 ReportA.setOnAction(Reporte);
 Make_Report.setOnAction(REPORTES);
 SEDES.setOnAction(tablewData);
 }
    public void Personal(){
    Report.setOnAction(E->{
     Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,11, window,"Ingreso al modulo Servicio");});
 PC.setOnAction(E->{
     Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,12, window,"Ingreso al modulo PC");});
 Active.setOnAction(E->{
     Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,14, window,"Ingreso al modulo actividad");});
 Create.setOnAction(registrar);
 Read.setOnAction(Reading);
 Update.setOnAction(Updates);
 ReportA.setOnAction(Reporte);
 Make_Report.setOnAction(REPORTES);
 SEDES.setOnAction(tablewData);
    }
    private EventHandler<ActionEvent> registrar= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            try {
                Stage stage2=new Stage();
                FXMLLoader loader= new FXMLLoader();
                AnchorPane root;
                root = (AnchorPane)loader.load(getClass().getResource(nav.Rutas(1,5)).openStream());
                FReporteController buslig=(FReporteController)loader.getController();
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                String user=window.getTitle().replace("Sistema de Gestion de Actividades - Usuario: ", "");
                root.getStylesheets().add(getClass().getResource("/Otros/fullpackstyling.css").toString());
                buslig.recibir(controlador1, user);
                buslig.CRUD(1);
                Scene scene = new Scene(root);
                stage2.setScene(scene);
                stage2.alwaysOnTopProperty();
                stage2.setResizable(false);
                stage2.initModality(Modality.APPLICATION_MODAL);
                stage2.setTitle("Registrar Reporte");
                stage2.show();
            } catch (IOException ex) {
                Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    };
        private EventHandler<ActionEvent>REPORTES= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            try {
                Stage stage2=new Stage();
                FXMLLoader loader= new FXMLLoader();
                AnchorPane root;
                root = (AnchorPane)loader.load(getClass().getResource(nav.Rutas(1,8)).openStream());
               // FReporteController buslig=(FReporteController)loader.getController();
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                String user=window.getTitle().replace("Sistema de Gestion de Actividades - Usuario: ", "");
                root.getStylesheets().add(getClass().getResource("/Otros/fullpackstyling.css").toString());
                //buslig.recibir(controlador1, user);
                //buslig.CRUD(1);
                Scene scene = new Scene(root);
                stage2.setScene(scene);
                stage2.setResizable(false);
                stage2.setTitle("Reporte");
                stage2.show();
            } catch (IOException ex) {
                Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    };
    private EventHandler<ActionEvent> Reading= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
         if(Tablew.getSelectionModel().getSelectedItem()==null){
             mensaje.Alerta("Debe seleccionar un elemento de la tabla");
         }else{
             entidad=(Reporte)Tablew.getSelectionModel().getSelectedItem();
             String Combo=entidad.getActividad()+"-"+entidad.getId_actividad();
             String numbers=entidad.getComputador().replaceAll("[^\\d]", " ");
             numbers=numbers.trim();
             numbers=numbers.replaceAll(" +"," ");
               try {
                Stage stage2=new Stage();
                FXMLLoader loader= new FXMLLoader();
                AnchorPane root;
                root = (AnchorPane)loader.load(getClass().getResource(nav.Rutas(1,5)).openStream());
                FReporteController buslig=(FReporteController)loader.getController();
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                String user=window.getTitle().replace("Sistema de Gestion de Actividades - Usuario: ", "");
                root.getStylesheets().add(getClass().getResource("/Otros/fullpackstyling.css").toString());
                buslig.recibir(controlador1, user);
                buslig.CRUD(3);
                buslig.visual(entidad.getFecha_i(),entidad.getFecha_f(),
                        Combo,entidad.getDepsed(),numbers,entidad.getTexto(),entidad.getId_report());
                Scene scene = new Scene(root);
                stage2.setScene(scene);
                stage2.alwaysOnTopProperty();
                stage2.setResizable(false);
                stage2.initModality(Modality.APPLICATION_MODAL);
                stage2.setTitle("Ver Reporte");
                stage2.show();
            } catch (IOException ex) {
                Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
            }
             
         }
        }
    
    };
    private EventHandler<ActionEvent> Updates= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
         if(Tablew.getSelectionModel().getSelectedItem()==null){
             mensaje.Alerta("Debe seleccionar un elemento de la tabla");
         }else{
             entidad=(Reporte)Tablew.getSelectionModel().getSelectedItem();
             String Combo=entidad.getActividad()+"-"+entidad.getId_actividad();
             String numbers=entidad.getComputador().replaceAll("[^\\d]", " ");
             numbers=numbers.trim();
             numbers=numbers.replaceAll(" +"," ");
               try {
                Stage stage2=new Stage();
                FXMLLoader loader= new FXMLLoader();
                AnchorPane root;
                root = (AnchorPane)loader.load(getClass().getResource(nav.Rutas(1,5)).openStream());
                FReporteController buslig=(FReporteController)loader.getController();
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                String user=window.getTitle().replace("Sistema de Gestion de Actividades - Usuario: ", "");
                root.getStylesheets().add(getClass().getResource("/Otros/fullpackstyling.css").toString());
                buslig.recibir(controlador1, user);
                buslig.CRUD(2);
                buslig.visual(entidad.getFecha_i(),entidad.getFecha_f(),
                        Combo,entidad.getDepsed(),numbers,entidad.getTexto(),entidad.getId_report());
                Scene scene = new Scene(root);
                stage2.setScene(scene);
                stage2.alwaysOnTopProperty();
                stage2.setResizable(false);
                stage2.initModality(Modality.APPLICATION_MODAL);
                stage2.setTitle("Actualizar Reporte");
                stage2.show();
            } catch (IOException ex) {
                Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
            }
             
         }
        }
    
    };
    public  void Refresh(){
    Tablew.setItems(funciones.getDatosBita());
    Tablew.refresh();
    filtro();
    }
    private EventHandler<ActionEvent> tablewData= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            TableItems();
        }
    };
    private void TableItems(){
    String Sede=(String) SEDES.getValue();
            if(Sede==null||Sede.equals("")){
                    /*for(int x=0;x<Tablew.getItems().size();x++){
                    Tablew.getItems().remove(x);
                    }*/
                Refresh();
            }
          else{
               /* for(int x=0;x<Tablew.getItems().size();x++){
                    Tablew.getItems().remove(x);
                    }*/
              String[] Sed=Sede.split("-");
              Tablew.setItems(funciones.getDatosSede(Integer.valueOf(Sed[1])));
              Tablew.refresh();
              filtro2(Integer.valueOf(Sed[1]));
          }
            System.out.println(Sede);
    }
       private void filtro2(int id){
   FilteredList<Reporte> filteredData= new FilteredList<Reporte>(funciones.getDatosSede(id), b -> true);
   Filtro.textProperty().addListener((observable, oldValue, newValue) ->{
       filteredData.setPredicate(employee ->{
           if (newValue == null || newValue.isEmpty()){
               return true;
           }
           String lowerCaseFilter= newValue.toLowerCase();
           if(employee.getDepartamento().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(String.valueOf(employee.getId_report()).indexOf(lowerCaseFilter)!=-1){return true;}
           else if(String.valueOf(employee.getFecha_i()).indexOf(lowerCaseFilter)!=-1){return true;}
           else if(String.valueOf(employee.getFecha_f()).indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getComputador().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getSede().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getActividad().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getUsuario().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else
               return false;
       });
   });
   SortedList<Reporte> sortedData= new SortedList<>(filteredData);
   sortedData.comparatorProperty().bind(Tablew.comparatorProperty());
   Tablew.setItems(sortedData);
   }
   private void filtro(){
   FilteredList<Reporte> filteredData= new FilteredList<Reporte>(funciones.getDatosBita(), b -> true);
   Filtro.textProperty().addListener((observable, oldValue, newValue) ->{
       filteredData.setPredicate(employee ->{
           if (newValue == null || newValue.isEmpty()){
               return true;
           }
           String lowerCaseFilter= newValue.toLowerCase();
           if(employee.getDepartamento().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(String.valueOf(employee.getId_report()).indexOf(lowerCaseFilter)!=-1){return true;}
           else if(String.valueOf(employee.getFecha_i()).indexOf(lowerCaseFilter)!=-1){return true;}
           else if(String.valueOf(employee.getFecha_f()).indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getComputador().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getSede().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getActividad().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getUsuario().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else
               return false;
       });
   });
   SortedList<Reporte> sortedData= new SortedList<>(filteredData);
   sortedData.comparatorProperty().bind(Tablew.comparatorProperty());
   Tablew.setItems(sortedData);
   }
   private EventHandler<ActionEvent>Reporte= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            if(Tablew.getSelectionModel().getSelectedItem()==null){
             mensaje.Alerta("Debe seleccionar un elemento de la tabla");
         }else{
                try {
                    entidad=(Reporte)Tablew.getSelectionModel().getSelectedItem();
                    // DIRECCION DEL PUNTO JASPER, OSEA CUANDO YA EL REPORTE ESTA COMPILADO
                    String master=System.getProperty("user.dir")+"//src//Reportes//RActividad.jasper";
                    JasperPrint informe = null;
                    Map<String,Object>map= new HashMap<String,Object>();
                    map.put("IDReport", entidad.getId_report());
                    map.put("LOGO","\\src\\imagenes\\ivvv-removebg-preview.png");
                    DBConexion conecta= new DBConexion();
                    informe=JasperFillManager.fillReport(master,map,conecta.Conectar());
                    JasperViewer.viewReport(informe,false);
                    conecta.Desconectar();
                } catch (Alerta | JRException ex) {
                    Logger.getLogger(ReporteController.class.getName()).log(Level.SEVERE, null, ex);
                }
                 }
          
        }
   
   };

     /*      private void filtro(){
     FilteredList<Destinos> filteredData = new FilteredList<>(funci.getDatosDrivers(), b -> true);
		Filtrar.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(employee -> {								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCaseFilter = newValue.toLowerCase();
				if (employee.getCodigoDestino().indexOf(lowerCaseFilter)!=-1 ) {
					return true;
				}
                                if(employee.getNombreEstado().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
                                if(employee.getNombreCiudad().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
                                else  
				    	 return false; 
			});
		}); 
		SortedList<Destinos> sortedData = new SortedList<>(filteredData);
		sortedData.comparatorProperty().bind(Tabla.comparatorProperty());
		Tabla.setItems(sortedData); 
    }*/
       
}
