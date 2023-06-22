/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siga;

import Fcontroladores.FDepSedController;
import Fcontroladores.PreguntasRController;
import Otros.Alerta;
import com.jfoenix.controls.JFXTextField;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import Otros.Error;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import controladores.ReporteController;
import crud.CrudBitacora;
import crud.CrudUser;
import funciones.Bitacora;
import funciones.Loggin;
import funciones.User;
import funciones.navegacion;
import java.sql.Timestamp;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;


/**
 *
 * @author Timaure
 */
public class SIGAController implements Initializable {
    
    private Label label;
    @FXML
    private Button loggin;
    //private Button exit;
    @FXML
    private JFXTextField User;
    @FXML
    private JFXPasswordField Pass;
    private Error mensaje= new Error();
    public Loggin log= new Loggin();
    private CrudUser user= new CrudUser();
    private Bitacora bit;
     navegacion nav= new navegacion();
    @FXML
    private ImageView ivss;
    @FXML
    private ImageView icon;
    @FXML
    private JFXCheckBox ShowPass;
    String pass;
    @FXML
    private Label Label1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ivss.setImage(new Image("/imagenes/ivvv-removebg-preview.png"));
        icon.setImage(new Image("/imagenes/usuario.png"));
        start();
        
    }    
    //funcion donde se asignan todos los eventos a los botones 
    public void start(){
        loggin.setOnAction(Log);
        User.setOnKeyPressed(FocusGO);
        Pass.setOnKeyPressed(FocusGO);
        ShowPass.setOnAction(ShowPas);
        User.requestFocus();
        Pass.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(ShowPass.isSelected()){
                String g = Pass.getText();
                Label1.setText(g);
                Pass.end();
                }
            }
        });
    }
    
    //evento de Login
    private EventHandler<ActionEvent>Log= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            LogIn(window);
        }
    };
    private EventHandler<KeyEvent>FocusGO= new EventHandler<KeyEvent>(){
        @Override
        public void handle(KeyEvent event) {
           if(event.getSource().equals(User)){
               if(event.getCode().equals(KeyCode.ENTER)){
                   if(User.getText().length()==0){
                       event.consume();
                   }else{Pass.requestFocus();}
               }
           }
           if(event.getSource().equals(Pass)){
               if(event.getCode().equals(KeyCode.ENTER)){
                   if(Pass.getText().length()==0||Pass.getPromptText().length()==0){
                       event.consume();
                   }else{
                     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                     LogIn(window);
                   }
               }
           }
        }
    };
 
    private EventHandler<ActionEvent> ShowPas= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            if(ShowPass.isSelected()){
              Label1.setText(Pass.getText());
            }else{
            Label1.setText("");
            }
        }
    };
       @FXML
    private void ForgotPass(MouseEvent event) {
        if(User.getText().isEmpty()){
                mensaje.Alerta("Debe ingresar un Usuario");
            }else{
                if(user.ComprobarCedulaActivo(User.getText())){
                    try {
                        Stage stage2=new Stage();
                        FXMLLoader loader= new FXMLLoader();
                        AnchorPane root;
                        root = (AnchorPane)loader.load(getClass().getResource(nav.Rutas(1,11)).openStream());
                        PreguntasRController buslig=(PreguntasRController)loader.getController();
                        buslig.Recibir_Usuario(User.getText());
                        root.getStylesheets().add(getClass().getResource("/Otros/fullpackstyling.css").toString());
                        Scene scene = new Scene(root);
                        //scene.getStylesheets().add("/Otros/fullpackstyling.css");
                        stage2.setScene(scene);
                        stage2.alwaysOnTopProperty();
                        stage2.setResizable(false);
                        stage2.initModality(Modality.APPLICATION_MODAL);
                        stage2.setTitle("Preguntas de Recuperacion");
                        stage2.show();
                    } catch (IOException ex) {
                        Logger.getLogger(SIGAController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    mensaje.Alerta("Este Usuario no se encuentra registrado o esta inactivo, contacte con su administrador");
                }
            }
    }
  
    private void LogIn(Stage window){
     /*
            Se llama al metodo comprobar para verificar que los TextFields no 
            esten vacios.
            */
            if(comprobar()){
                //se capturan los datos de los textfield en las varibles 
            //U para Usuario 
            //P para contraseña
            //Se crea una variable llamada state para almacenar el resultado de la busqueda en 
            //la base de datos
            String U= User.getText();
            String P=Pass.getText();
            int state = 0;
                try {
                /*se llama a la funcion que buscara en la BD el usuario y la contraseña
                    si la variable state es distinta a -1, eso significa que hay 
                    conexion a la base de datos.
                    por lo que si la variable es igual a 1, hubo una coincidencia 
                    por el contrario si es igual a 0, no hubo coincidencias*/
                    
                    state=log.login(U, P);
                } catch (Alerta ex) {
                    Logger.getLogger(SIGAController.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(state!=-1){
                    if(state==1){
                        if(!log.FirtsLog(U)){
                        window.setTitle("Sistema de Gestion de Actividades - Usuario: "+U);
                        nav.new_window(window,1,10, "Registro de Preguntas de Seguridad: "+U);
                        }else{

                        /*capturo la pantalla actual y le coloco un titutlo
                        donde se pasara el Usuario como parametro 
                        esto, con el fin de poder agarrar el Usuario e ir 
                        ingresandolo en la bitacora cada vez que hace o realiza
                        una accion*/
                        window.setTitle("Sistema de Gestion de Actividades - Usuario: "+U);
                        /*llamamosa la funcion naveg donde pasaremos 4 parametros 
                        numero de folder//numero de interfaz/Stage Actual/
                        descripcion de la accion para la bitacora*/
                        /*se lama a la funcion Type para ver si el usuario es administrador 
                        o Peronal
                        si es igual a 1 es administrador
                        si*/
                        window.setUserData(U);
                        if(log.Type(U)==1){
                           nav.naveg(0,9, window,"Inicio Sesion");
                        }else{
                             nav.naveg(0,13, window,"Inicio Sesion");
                        }
                     
                        }
                        
                    }
                    else{
                        mensaje.Alerta("Usuario o Contraseña Invalida");
                    }
                }
                else{
                    mensaje.Alerta("¡Error al conectar al servidor!");
                }
            }
    
    }
    //funcion para comprobar que los campos no esten vacios y mandar un mensaje 
    //en caso de que si. 
    private boolean comprobar(){
    boolean b=false;
    if(User.getText().length()==0&&Pass.getText().length()==0){
    b=false;
    mensaje.Alerta("Ingrese Usuario y contraseña");
    }
    if(User.getText().length()!=0&&Pass.getText().length()==0){
    b=false;
    mensaje.Alerta("Ingrese contraseña");
    }
    if(User.getText().length()==0&&Pass.getText().length()!=0){
    b=false;
    mensaje.Alerta("Ingrese Ususario");
    }
     if(User.getText().length()!=0&&Pass.getText().length()!=0){
    b=true;
    }
    return b;
    }

    
}
