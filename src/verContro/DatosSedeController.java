/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verContro;

import Entidades.Sede;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import crud.CrudSed;
import crud.CrudBitacora;
/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class DatosSedeController implements Initializable {

    @FXML
    private Label Sede;
    @FXML
    private Label Registrado;
    @FXML
    private Label fechaRegstro;
    @FXML
    private Label occidente;
    @FXML
    private Label ultimaModificacion;
    @FXML
    private Label depActi;
    @FXML
    private Label modificadoPor;
    Sede sede=null;
    CrudSed funS= new CrudSed();
    CrudBitacora bita= new CrudBitacora();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        star();
    }    
    public void recibir(Sede seds){
    sede=seds;
    Sede.setText(seds.getNombre());
    occidente.setText(seds.getRegion());
    if(seds.getNombre().length()!=0){
    String Registro=bita.GetAll("Registro la sede numero "+seds.getId());
    String Parts []=Registro.split("-");
    Registrado.setText(Parts[0]);
    fechaRegstro.setText(Parts[1]);
    String Modificado=bita.GetAll("Ha actualizado la sede  "+seds.getId());
    String P[]=Modificado.split("-");
    ultimaModificacion.setText(P[1]);
    modificadoPor.setText(P[0]);
    depActi.setText(String.valueOf(funS.MaxDep(seds.getId())));
    }
    }
    public void star(){
    if(sede!=null){
            Sede.setText(sede.getNombre());
    occidente.setText(sede.getRegion());
    
    }
    
    }
}
