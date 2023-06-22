/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verContro;

import Entidades.Actividades;
import Entidades.Departamento;
import crud.CrudBitacora;
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
public class DatosDepController implements Initializable {

    @FXML
    private Label ObjetoT;
    @FXML
    private Label Nombre;
    @FXML
    private Label RegistradoP;
    @FXML
    private Label FechaR;
    @FXML
    private Label LastU;
    @FXML
    private Label Uby;
    CrudBitacora bi= new CrudBitacora();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void RecibirDep(Departamento Dep){
    ObjetoT.setText("Departamento:");
    Nombre.setText(Dep.getNombre());
    String all=bi.GetAll("Ha registrado el departamento numero "+Dep.getId());
    String p1[]=all.split("-");
    RegistradoP.setText(p1[0]);
    FechaR.setText(p1[1]);
    String todo=bi.GetAll("Ha Actualizado el departamento numero "+Dep.getId());
    String p2[]=todo.split("-");
    Uby.setText(p2[0]);
    LastU.setText(p2[1]);
    }
       public void RecibirActi(Actividades Dep){
    ObjetoT.setText("Actividad:");
    Nombre.setText(Dep.getNombre());
    String all=bi.GetAll("Ha registrado la actividad  numero "+Dep.getId());
    String p1[]=all.split("-");
    RegistradoP.setText(p1[0]);
    FechaR.setText(p1[1]);
    String todo=bi.GetAll("Ha actualizado la actividad numero "+Dep.getId());
    String p2[]=todo.split("-");
    Uby.setText(p2[0]);
    LastU.setText(p2[1]);
    }
}
