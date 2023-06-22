/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verContro;

import Entidades.Region;
import crud.CrudBitacora;
import crud.CrudReg;
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
public class DatosRegController implements Initializable {

    @FXML
    private Label Reg;
    @FXML
    private Label Regist;
    @FXML
    private Label ModifPor;
    @FXML
    private Label FechaModi;
    @FXML
    private Label Sedes;
    @FXML
    private Label FechaR;
    CrudBitacora bit= new CrudBitacora();
    CrudReg Regiones= new CrudReg();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void Recibir(Region reg){
    Reg.setText(reg.getNombre());
    String texto=bit.GetAll("Ha registrado la region "+reg.getCodigo());
    String part[]=texto.split("-");
    Regist.setText(part[0]);
    FechaR.setText(part[1]);
    String texto1=bit.GetAll("Ha actualizado la region id"+reg.getCodigo());
    String part1[]=texto1.split("-");
    ModifPor.setText(part1[0]);
    FechaModi.setText(part1[1]);
    Sedes.setText(Regiones.MaxSep(reg.getCodigo()));
    }
}
