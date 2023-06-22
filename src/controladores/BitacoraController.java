/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import crud.CrudBitacora;
import funciones.Bitacora;
import funciones.navegacion;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import Otros.Error;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class BitacoraController implements Initializable {

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
    private Menu Bit;
    @FXML
    private TableView Tablew;
    @FXML
    private TableColumn C0;
    @FXML
    private TableColumn C1;
    @FXML
    private TableColumn C3;
    @FXML
    private JFXTextField Filtro;
    @FXML
    private Button Create;
    @FXML
    private Button Dele;
    public navegacion nav= new navegacion();
    public CrudBitacora bitacora= new CrudBitacora();
    @FXML
    private TableColumn C2;
    @FXML
    private JFXButton Respaldo;
    @FXML
    private JFXButton Restaurar;
    private Bitacora bit;
    private Error mensaje= new Error();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        C0.setCellValueFactory(new PropertyValueFactory<>("idbitacora"));
            C1.setCellValueFactory(new PropertyValueFactory<>("Usuario"));
            C2.setCellValueFactory(new PropertyValueFactory<>("fechaformateada"));
            C3.setCellValueFactory(new PropertyValueFactory<>("Descripcion"));
            Tablew.setItems(bitacora.getDatosBita());
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
 Respaldo.setOnAction(respaldo);
 Restaurar.setOnAction(restaurar);
 }
    private EventHandler<ActionEvent> respaldo= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            try {
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                String user=window.getTitle().replace("Sistema de Gestion de Actividades - Usuario: ", "");
                RegistarBitacora(user,"realizo respaldo de la base de datos");
      Process p = Runtime
            .getRuntime()
            .exec("C:\\xampp\\mysql\\bin\\mysqldump -u root siga");
      InputStream is = p.getInputStream();
      FileOutputStream fos = new FileOutputStream("siga.sql");
      byte[] buffer = new byte[1000];

      int leido = is.read(buffer);
      while (leido > 0) {
         fos.write(buffer, 0, leido);
         leido = is.read(buffer);
      }

      fos.close();
      mensaje.Info("Se ha respaldado la base de datos");
   } catch (Exception e) {
      e.printStackTrace();
   }
        }
    };
    private EventHandler<ActionEvent> restaurar= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            try {
      Process p = Runtime
            .getRuntime()
            .exec("C:\\xampp\\mysql\\bin\\mysql -u root  siga");

      OutputStream os = p.getOutputStream();
      FileInputStream fis = new FileInputStream("siga.sql");
      byte[] buffer = new byte[1000];

      int leido = fis.read(buffer);
      while (leido > 0) {
         os.write(buffer, 0, leido);
         leido = fis.read(buffer);
      }

      os.flush();
      os.close();
      fis.close();
      mensaje.Info("Se ha restaurado la base de Datos");
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                String user=window.getTitle().replace("Sistema de Gestion de Actividades - Usuario: ", "");
                RegistarBitacora(user,"realizo la restauracion de la base de datos");
   } catch (Exception e) {
      e.printStackTrace();
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
}
