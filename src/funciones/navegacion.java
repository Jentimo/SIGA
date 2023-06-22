/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import Fcontroladores.FReporteController;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import Otros.Error;
import controladores.ActividadController;
import controladores.PCController;
import controladores.ReporteController;
import crud.CrudBitacora;
import java.sql.Timestamp;
import javafx.application.Platform;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import static org.mariadb.jdbc.internal.com.send.authentication.ed25519.Utils.bit;

/**
 *
 * @author Jose Timaure 
 * esta clase es para implementar el cargar todas las interfaces segun cada 
 * boton. La razon de no usar un solo controlador de navegacion y cargar las 
 * interfaces como hijo de la raiz, es porque se usa un borderPane, para que los 
 * elementos  de UI puedan ajustarse a las pantallas. 
 * 
 * al cargar las diferentes UI como Hijo del parent, se pierde esa funcionalidad 
 * del borderPane, por lo que se usara esta clase para poder pasar ir cambiando 
 * el stage 
 */
public class navegacion {
    Error mensaje= new Error();
    private Bitacora bit;
    boolean a=false;
    public static String Usuario=" hola";
    public String retornarU(){
    return Usuario;
    }
    //los parametros de esta funcion son la direccion del la UI a cargar,
    //El Stage y la descripcion para el registro de la bitacora
    public void naveg(Integer Carpeta,Integer UI,Stage window, String Des){
     Parent vistaUnoParent;
        try {
            FXMLLoader loader= new FXMLLoader();
            /*Se llama al metodo rutas para conseguir la ruta de la interfaz a cargar*/
            vistaUnoParent = loader.load(getClass().getResource(Rutas(Carpeta,UI)));
               /*creo el nuevo scene y le cargo el parent*/
                    Scene vistaUnoScene = new Scene(vistaUnoParent);
                    /*el stage que se estaba ejecutando se manda por parametro*/
                    /*Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    /*le paso el scene al stage*/
                    window.setScene(vistaUnoScene);
                    /*le pongo el titulo a la ventana usando el actual*/
                    window.setTitle(window.getTitle());
                    Usuario=(String) window.getUserData();
                    /*pongo para que no se pueda agrandar*/
                       String user=window.getTitle().replace("Sistema de Gestion de Actividades - Usuario: ", "");
                    window.setResizable(true);
                    window.setUserData(window.getUserData());
                    switch (UI){
                        case 10:
                            if(window.getWidth()>=862&&window.getHeight()>=570){
                            window.setWidth(window.getWidth());
                            window.setHeight(window.getHeight());
                            }else{
                            window.setWidth(862);
                            window.setHeight(570);}
                            break;
                        case 11:
                          if(window.getWidth()>=862&&window.getHeight()>=570){
                            window.setWidth(window.getWidth());
                            window.setHeight(window.getHeight());
                            }else{
                            window.setWidth(862);
                            window.setHeight(570);}
                            break;
                        default:
                            window.setWidth(window.getWidth());
                            window.setHeight(window.getHeight());
                            break;
                    }
                    //esta es una funciona para pedir cerrar la ventana
                    //Esto para evitar cerrar la ventana de forma accidental 
                    //La alerta es tipo confirmacion
                    window.setOnCloseRequest(event -> {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setHeaderText(null);
                        alert.setTitle("Confirmación");
                        alert.setContentText("¿Estas seguro de cerrar la ventana ?");
                        alert.showAndWait().ifPresent(response ->
                        {   if(response==ButtonType.CANCEL){
                                event.consume();}
                            if(response==ButtonType.OK){
                            if(!window.getTitle().equals("BIENVENIDO")){
                             mensaje.Info("Se ha cerrado sesion");
                            RegistarBitacora(Usuario,"Ha cerrado sesion");
                                Login(window);
                            event.consume();
                            }
                            }
                        }
                    );
                    
                    });
                                
                     // se muestra la interfaz y se registra la accion en la 
                     //bitacora 
                     RegistarBitacora(Usuario,Des);
                    window.show();
                    
        } catch (IOException ex) {
            Logger.getLogger(navegacion.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
    }
    
    public void Login(Stage window){
        try {
            FXMLLoader loader= new FXMLLoader();
            AnchorPane root;
            root = (AnchorPane)FXMLLoader.load(getClass().getResource("/siga/login.fxml"));
            /*creo el nuevo scene y le cargo el parent*/
            Scene vistaUnoScene = new Scene(root);
            /*el stage que se estaba ejecutando se manda por parametro*/
            /*le paso el scene al stage*/
            window.setScene(vistaUnoScene);
            /*le pongo el titulo a la ventana usando el actual*/
            window.setTitle("BIENVENIDO");
            /*pongo para que no se pueda agrandar*/
            window.setResizable(true);
            window.setWidth(625);
            window.setHeight(398);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(navegacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void new_window(Stage window, int x, int y, String Titutlo){
        try {
            Stage stage2=new Stage();
            FXMLLoader loader= new FXMLLoader();
            AnchorPane root;
            root = (AnchorPane)loader.load(getClass().getResource(Rutas(x,y)).openStream());
            String user=window.getTitle().replace("Sistema de Gestion de Actividades - Usuario: ", "");
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/Otros/fullpackstyling.css");
            stage2.setScene(scene);
            stage2.alwaysOnTopProperty();
            stage2.setResizable(false);
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.setTitle(Titutlo);
            stage2.show();
        } catch (IOException ex) {
            Logger.getLogger(navegacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    /*Este es un swicth para no tener que escribir todas las direcciones.*/
    public  String Rutas(Integer Carpeta, Integer Interfaz){
        String Folder="";
        String Ruta="";
        String UI="";
        /*el primer switch es para las carpetas, dentro de cada switch se encuentra
        otro switch para ir buscando las interfaces para cargar la ruta*/
        switch(Carpeta){
            case 0: Folder="/vistas/";
            switch(Interfaz){
                case 0: UI="Bitacora.fxml";
                break;
                case 1: UI="DepSed.fxml";
                break;
                case 2: UI="DepSed.fxml";
                break;
                case 3: UI="Departamento.fxml";
                break;
                case 4:UI="PC.fxml";
                break;
                case 5:UI="Region.fxml";
                break;
                case 6:UI="Sede.fxml";
                break;
                case 7:UI="Users.fxml";
                break;
                case 8: UI="actividad.fxml";
                break;
                case 9: UI="principal.fxml";
                break;
                case 10: UI="reporte.fxml";
                break;
                case 11: UI="Personal.fxml";
                break;
                case 12: UI="PersonalPC.fxml";
                break;
                case 13: UI="PrincipalPersonal.fxml";
                break;
                case 14: UI="actividadPersonal.fxml";
                break;
            }
            break;
            case 1: Folder="/formularios/";
            switch(Interfaz){
                case 0: UI="FActividades.fxml";
                break;
                case 1: UI="Fcomputador";
                break;
                case 2: UI="FDepSed.fxml";
                break;
                case 3: UI="FDepartamento.fxml";
                break;
                case 4: UI="FRegion.fxml";
                break;
                case 5: UI="FReporte.fxml";
                break;
                case 6: UI="FUsuario.fxml";
                break;
                case 7: UI="Fsede.fxml";
                break;
                case 8: UI="ReportsPara.fxml";
                break;
                case 9: UI="NewPass.fxml";
                break;
                case 10: UI="PreguntasCompleto.fxml";
                break;
                case 11: UI="PreguntasR.fxml";
                break;
            }
            break;
        }
        Ruta=Folder+UI;
        return Ruta;
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
