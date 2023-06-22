/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verContro;

import Entidades.Usuario;
import crud.CrudBitacora;
import crud.CrudReporte;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class DatosUserController implements Initializable {

    @FXML
    private Label Usuario;
    @FXML
    private Label Registrado;
    @FXML
    private Label fechaRegstro;
    @FXML
    private Label reportes;
    @FXML
    private Label ultimaModificacion;
    @FXML
    private Label nivel;
    @FXML
    private Label modificadoPor;
    CrudBitacora bita= new CrudBitacora();
    CrudReporte repor= new CrudReporte();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Star();
    }    
    public void Recibir(Usuario user){
    Usuario.setText("Usuario: "+user.getNombre());
    nivel.setText(user.getAcceso());
    String texto=bita.GetAll("Ha registrado al usuario: "+user.getCedula());
    String part[]=texto.split("-");
    fechaRegstro.setText(part[1]);
    Registrado.setText(part[0]);
    String texto1=bita.GetAll("Ha actualizado al usuario: "+user.getCedula());
    String part1[]=texto1.split("-");
    ultimaModificacion.setText(part1[1]);
    modificadoPor.setText(part1[0]);
    reportes.setText(String.valueOf(repor.MaxRe(user.getCedula())));
    }
    public void Star(){
    
    }
}
