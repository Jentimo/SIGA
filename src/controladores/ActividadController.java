/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Entidades.Actividades;
import Entidades.Reporte;
import Entidades.Sede;
import Fcontroladores.FActividadesController;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import crud.CrudActi;
import java.sql.SQLException;
import Otros.Error;
import com.jfoenix.controls.JFXButton;
import crud.CrudBitacora;
import funciones.Bitacora;
import funciones.Loggin;
import java.sql.Timestamp;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableRow;
import static org.mariadb.jdbc.internal.com.send.authentication.ed25519.Utils.bit;
import verContro.DatosDepController;
/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class ActividadController implements Initializable {

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
    public navegacion nav= new navegacion();
    private CrudActi acti= new CrudActi();
    Actividades activ;
    Error mensaje= new Error();
    private Bitacora bit;
    ActividadController Acti;
     private boolean b=false;
    @FXML
    private TableColumn C2;
    @FXML
    private JFXButton Create1;
    String Usuario;
    Loggin log = new Loggin();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            //Inicio el controlador para pasarlo al formulario
            Acti=this;
            //agrego las propiedades a las celdas de que elementos del Objeto va a mostrar
            C0.setCellValueFactory(new PropertyValueFactory<>("id"));
            C1.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
            C2.setCellValueFactory(new PropertyValueFactory<>("acti"));
            //Esta es una propiedad de la la fila de la tabla donde en base a su valor, el CSS de este cambia 
            Tablew.setRowFactory(tv -> new TableRow<Actividades>() {
              @Override
              protected void updateItem(Actividades item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || item.getActi() == null)
                  setStyle("");
                //esta setencia es por la eliminacion logica de este sistema, ya que si el objeto no se encuentra activo, la fila tendra
                //un color rojo de fondo 
                else if (item.getActi()=="NO")
                  setStyle("-fx-background-color: #f26161;");
                else
                  setStyle("");
              }
            });
            /*
            se llaman a las funciones 
            Actualizar para colocar datos en el Tablew View
            y nave que es la funciones para navergar por las vistas dentro del sistema
            */
            actualizar();
          Direccion();
    }    
    /*Por medio de expresiones Lamba, se asigna los enventos a cada una de los items del menuItem.
    En estos eventos, se llama a la funcion naveg de la Clase Navegacion al cual se le pasa un int que representa la ruta para buscar el 
    FXML a cargar, el Stage Actual de Programa y una descripcion para registrar en la Bitacora*/
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
 /*se asignan los eventos a los botones */
 Create.setOnAction(creates);
 Dele.setOnAction(Delete);
  Updte.setOnAction(Update);
  Create1.setOnAction(read);
 }
     private int Comprobar(){
       int compro=0;
       compro=log.Type(nav.retornarU());
       return compro;
   }
    private void Direccion(){
    if(Comprobar()==2){
       Personal(); 
    }else{
        nave();
    }
    }
    private void Personal(){
     Create.setOnAction(creates);
     Create1.setOnAction(read);
      Report.setOnAction(E->{
     Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,11, window,"Ingreso al modulo Servicio");});
 PC.setOnAction(E->{
     Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,12, window,"Ingreso al modulo PC");});
 Active.setOnAction(E->{
     Stage window = (Stage)Mymenu.getScene().getWindow();
          nav.naveg(0,14, window,"Ingreso al modulo actividad");});
    }
 //funcion para crear la ventana y mostarla
    private void Ventana( int C,String Titulo, Actividades activ){
     try {
                    Stage stage2=new Stage();
                    FXMLLoader loader= new FXMLLoader();
                    AnchorPane root;
                    root = (AnchorPane)loader.load(getClass().getResource(nav.Rutas(1,0)).openStream());
                    FActividadesController buslig=(FActividadesController)loader.getController();
                    buslig.recibir_U(nav.retornarU());
                    if(C==2){
                    buslig.Recibir(2,activ.getNombre(),activ.getActivo(),activ.getId());
                    }
                    buslig.recibirStage(Acti);    
                    root.getStylesheets().add(getClass().getResource("/Otros/fullpackstyling.css").toString());
                    Scene scene = new Scene(root);
                    stage2.setScene(scene);
                    stage2.alwaysOnTopProperty();
                    stage2.setResizable(false);
                    stage2.initModality(Modality.APPLICATION_MODAL);
                    stage2.setTitle(Titulo);
                    stage2.show();
                } catch (IOException ex) {
                    Logger.getLogger(ActividadController.class.getName()).log(Level.SEVERE, null, ex);
                }
    
    }
    private EventHandler<ActionEvent> creates= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            Ventana(0,"Registar Actividad",activ);
        }
    };
    private EventHandler<ActionEvent> Update= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            if(Tablew.getSelectionModel().getSelectedItem()!=null){
                 activ=(Actividades)Tablew.getSelectionModel().getSelectedItem();
                Ventana(2,"Actualizar Actividad",activ);
            }else{
            mensaje.Alerta("Debe Seleccionar un elemento de la tabla");
            }
        }
    };
   
    private EventHandler<ActionEvent> read= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            if(Tablew.getSelectionModel().getSelectedItem()!=null){
                activ=(Actividades)Tablew.getSelectionModel().getSelectedItem();
               try {
                    Stage stage2=new Stage();
                    FXMLLoader loader= new FXMLLoader();
                    AnchorPane root;
                    root = (AnchorPane)loader.load(getClass().getResource("/ver/DatosDep.fxml").openStream());
                    DatosDepController buslig=(DatosDepController)loader.getController();
                    buslig.RecibirActi(activ);
                    root.getStylesheets().add(getClass().getResource("/Otros/fullpackstyling.css").toString());
                    Scene scene = new Scene(root);
                    stage2.setScene(scene);
                    stage2.alwaysOnTopProperty();
                    stage2.setResizable(false);
                    stage2.initModality(Modality.APPLICATION_MODAL);
                    stage2.setTitle("Ver Activdad");
                    stage2.show();
                } catch (IOException ex) {
                    Logger.getLogger(ActividadController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    };
    //evento para Habilitar y deshabilitar el elemento de la tabla
    private EventHandler<ActionEvent> Delete= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
          //compruebo que se haya seleccionado un elemento de la tabla 
        if(Tablew.getSelectionModel().getSelectedItem()!=null){
          //capturo el objeto de la tabla
            activ=(Actividades)Tablew.getSelectionModel().getSelectedItem();
            try {
                String accion="";
                if(activ.getActivo()==0){
                mensaje.Info("se ha habilitado la actividad" + activ.getNombre());
                accion="habiliado";
                }else{
                mensaje.Info("Se ha deshabilitado la actividad "+activ.getNombre());
                accion="deshabilitado";
                }
                RegistarBitacora(nav.retornarU(),"Ha "+accion+ "la actividad "+activ.getNombre());
                acti.Delete(activ.getId());
                actualizar();
            } catch (SQLException ex) {
                Logger.getLogger(ActividadController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    
    };
    //funcion para registrar la bitacora
    private void RegistarBitacora(String usuario,String Descripcion){
    
        CrudBitacora crudBi=new CrudBitacora();
        long now = System.currentTimeMillis();
        Timestamp sqlTimeDate=new Timestamp(now);
        bit=new Bitacora(usuario, sqlTimeDate, Descripcion);
        if(crudBi.RegistrarBITACORA(bit)){
            
        }else{mensaje.Alerta("Ha ocurrido un error al registrar acción en la bitacora");}
          
    
    }
    public void recibir(boolean a){
        b=a;
    }
    public void actualizar(){
    //if(b==true){
    Tablew.setItems(acti.getDatosBita());
                Tablew.refresh();
                filtro();
   // }
    }
    //filtro para buscar elementos en la tabla mediante el TEXTfield
    /*funciona agarrando todos los datos y poniendolos en un Filtered List
    se comparan los datos que se van ingresando en el Texfield y sec compara con un elemento de la TablewView

    despues de eso se compara y solo muestran los datos que coincidan con la comparacion hecha*/
    private void filtro(){
   FilteredList<Actividades> filteredData= new FilteredList<Actividades>(acti.getDatosBita(), b -> true);
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
   SortedList<Actividades> sortedData= new SortedList<>(filteredData);
   sortedData.comparatorProperty().bind(Tablew.comparatorProperty());
   Tablew.setItems(sortedData);
   }
}
