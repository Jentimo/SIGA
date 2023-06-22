/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fcontroladores;

import BD.DBConexion;
import Otros.Alerta;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import crud.CrudSed;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import Otros.Error;
import crud.CrudDep;
import crud.CrudReg;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class ReportsParaController implements Initializable {

    @FXML
    private JFXComboBox SEDE;
    @FXML
    private CheckBox REGIONAL;
    @FXML
    private Spinner YEARS;
    @FXML
    private JFXComboBox<String> MONTHS;
    @FXML
    private JFXComboBox TRI;
    @FXML
    private CheckBox GENERAL;
    @FXML
    private CheckBox DEP;
    @FXML
    private JFXComboBox Depas;
    @FXML
    private JFXButton Cancelar;
    @FXML
    private JFXButton generar;
    @FXML
    private JFXComboBox<String> REPORTYPE;
    private CrudSed sedes= new CrudSed();
    private Error mensaje= new Error();
    private CrudDep departamento= new CrudDep();
    private CrudReg regis= new CrudReg();
    @FXML
    private JFXComboBox<String> regiones;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      REPORTYPE.getItems().add("");
      REPORTYPE.getItems().add("Mensual");
      REPORTYPE.getItems().add("Trimestral");
      REPORTYPE.getItems().add("Anual");
      REPORTYPE.setOnAction(TipoReporte);
      REGIONAL.setOnMouseClicked(SedReg);
      SEDE.setItems(sedes.getDatos());
      MONTHS.setItems(Meses());
      LocalDate now = LocalDate.now();
      YEARS.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(2010,now.getYear(),now.getYear()));
      GENERAL.setOnMouseClicked(Parametro);
      DEP.setOnMouseClicked(Parametro);
      TRI.setItems(Trimestre());
      Cancelar.setOnAction(cancelado);
      generar.setOnAction(GO);
      Depas.setItems(departamento.getDatosNombre());
      regiones.setItems(regis.getDatosNombre());
      Depas.setDisable(true);
      regiones.setDisable(true);
      MONTHS.setDisable(true);
      TRI.setDisable(true);
    }    
       private EventHandler<ActionEvent> TipoReporte= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
          if(REPORTYPE.getSelectionModel().getSelectedItem().equals("Mensual")){
          TRI.setDisable(true);
          MONTHS.setDisable(false);
          }
          if(REPORTYPE.getSelectionModel().getSelectedItem().equals("Trimestral")){
          MONTHS.setDisable(true);
          TRI.setDisable(false);
          }
          if(REPORTYPE.getSelectionModel().getSelectedItem().equals("Anual")){
          TRI.setDisable(true);
          MONTHS.setDisable(true);
          }
          if(REPORTYPE.getSelectionModel().getSelectedItem().equals("")){
          TRI.setDisable(true);
          MONTHS.setDisable(true);
          }
        } 
    };
       private EventHandler<MouseEvent> SedReg= new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event) {
          if(REGIONAL.isSelected()){
          SEDE.setDisable(true);
          regiones.setDisable(false);
          }
          if(!REGIONAL.isSelected()){
          SEDE.setDisable(false);
          regiones.setDisable(true);
          }
        }
       
       };
       private EventHandler<MouseEvent> Parametro= new EventHandler<MouseEvent>(){
        @Override
        public void handle(MouseEvent event) {
        if(event.getSource().equals(GENERAL)){
        GENERAL.setSelected(true);
        DEP.setSelected(false);
        Depas.setDisable(true);
        }
        if(event.getSource().equals(DEP)){
        Depas.setDisable(false);
        GENERAL.setSelected(false);
        DEP.setSelected(true);
        }
        }
       };
       private ObservableList<String> Meses(){
       List<String> a = new ArrayList<>();
        ObservableList<String> Parcial;
        a.add("Enero");
        a.add("Febrero");
        a.add("Marzo");
        a.add("Abril");
        a.add("Mayo");
        a.add("Junio");
        a.add("Julio");
        a.add("Agosto");
        a.add("Septiembre");
        a.add("Octubre");
        a.add("Noviembre");
        a.add("Diciembre");
        Parcial = FXCollections.observableList(a);
        return Parcial;
       }
       private int MesesN(String Mes){
       int N=0;
           switch (Mes) {
               case "Enero": N=1;
                   break;
               case "Febrero": N=2; 
                   break;
               case "Marzo": N=3;
                   break;
               case "Abril": N=4;
                   break;
               case "Mayo": N=5;
                   break;
               case "Junio": N=6;
                   break;
               case "Julio": N=7;
                   break;
               case "Agosto": N=8;
                   break;
               case "Septiembre": N=9;
                   break;
               case "Octubre": N=10;
                   break;
               case "Noviembre": N=11;
                    break;
               case "Diciembre": N=12;
                break;
               default:
                   throw new AssertionError();
           }
           return N;
       }
            private EventHandler<ActionEvent> cancelado= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
         Node source = (Node) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
        }
        
    };
    private void Make_Report(String TipoReporte, int SedReg, int GeDep){
        //string que contiene la ruta del folder 
        String folder="//src//Reportes//";
        String jsp="";
        //se crea el archivo Map para los parametros del Reporte 
         Map<String,Object>map= new HashMap<String,Object>();
         //se agrega el parametro logo 
         map.put("LOGO","\\src\\imagenes\\ivvv-removebg-preview.png");
         //parametro año
         map.put("ANIO",YEARS.getValue());
          /*
        estos if son para capturar los parametros Sede,Departamento o region, 
        cual sea el caso o partametro del reporte
        */
        if(SedReg==1){
            String [] aux=SEDE.getValue().toString().split("-");
           map.put("SEDE",aux[0]);
        }else{
            String [] aux=regiones.getValue().toString().split("-");
            map.put("REG",aux[0].toLowerCase());
        }
        if(GeDep!=1){
            String [] aux=Depas.getValue().toString().split("-");
            map.put("DEP",aux[0]);
        }
        //este swicth es para buscar el archivo jasper para el reporte
        //existen 12 reportes en total 
        //este swicth es para buscar el tipo de Reporte 
        //Mensual,Trimestral o Anual
        switch (TipoReporte) {
            case "Mensual":
                //este if es para ver si el reporte es por Sede o Region
                // si SedReg==1 -> Reporte por sede
                // si SedReg!=1 -> Reporte Regional
                if(SedReg==1){
                    //esta sentencia es para ver si es General o por Departamento
                    // Si GeDep==1 -> Reporte General de todos los departamentos 
                    // Si GeDep!=1 -> Es un reporte de un Departamento
                    if(GeDep==1){
                        jsp="ReporteMensual.jasper";
                    }
                    else{
                         jsp="MensulSedeDep.jasper";
                    }
                }
                else{
                    if(GeDep==1){
                        jsp="ReporteGeneralMensualRegional.jasper";
                    }
                    else{
                        jsp="MensualRegionDep.jasper";
                    }
                }
                map.put("MES",MesesN(MONTHS.getValue()));
                break;
            case "Trimestral":
                if(SedReg==1){
                    if(GeDep==1){
                        jsp="GeneralTrimestralSede.jasper";
                    }else{
                        jsp="TrimestralSedeDep.jasper";
                    }
                }else{
                    if(GeDep==1){
                        jsp="GeneralTrimestralRegion.jasper";
                    }else{
                        jsp="TrimestralRegionDep.jasper";
                    }
                }
                String [] aux=TriN(TRI.getValue().toString()).split("-");
                map.put("MES1",Integer.valueOf(aux[0]));
                map.put("MES2",Integer.valueOf(aux[1]));
                map.put("TRI",TRI.getValue());
                break;
            case "Anual":
                if(SedReg==1){
                    if(GeDep==1){
                        jsp="AnualSedeGeneral.jasper";
                    }else{
                        jsp="AnualSedeDep.jasper";
                    }
                }else{
                    if(GeDep==1){
                        jsp="AnualGeneralRegion.jasper";
                    }else{
                        jsp="AnualRegionalDep.jasper";
                    }
                }
                break;   
        }
        
        try {
            //String con la ruta definitava del archivo jasper
         String master=System.getProperty("user.dir")+folder+jsp;
         JasperPrint informe = null;
         DBConexion conecta= new DBConexion();
         informe=JasperFillManager.fillReport(master,map,conecta.Conectar());
         JasperViewer.viewReport(informe,false);
         conecta.Desconectar(); 
        } catch (Alerta | JRException ex) {
            Logger.getLogger(ReportsParaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
    }
    private EventHandler<ActionEvent>GO= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            boolean c=Comprobar();
            if(c==true){
                int SedReg,GegDep;
                if(REGIONAL.isSelected()){
                    SedReg=0;
                }else{
                    SedReg=1;
                }
                if(DEP.isSelected()){
                    GegDep=0;
                }else{
                GegDep=1;
                }
                Make_Report(REPORTYPE.getValue(),SedReg,GegDep); 
            }
        }
        
    };
           
       private boolean Comprobar(){
       boolean A=true;
       String ms="";
       if(REPORTYPE.getValue()==null || REPORTYPE.getValue().equals("")){
           A=false;
           mensaje.Alerta("Debe seleccionar el tipo de reporte");
       }
       if(SEDE.getValue()==null&& !REGIONAL.isSelected()){
       A=false;
       mensaje.Alerta("Debe eleccionar si es por Sede o Region");
       }
       if(REGIONAL.isSelected()&&regiones.getValue()==null){
       A=false;
       mensaje.Alerta("Debe seleccionar la region");
       }
       if(REPORTYPE.getValue().equals("Mensual")&&MONTHS.getValue()==null){
       A=false;
       mensaje.Alerta("Debe seleccionar el mes para el reporte mensual");
       }
       if(REPORTYPE.getValue().equals("Trimestral")&&TRI.getValue()==null){
       A=false;
       mensaje.Alerta("Debe seleccionar el trimestre para el reporte Trimestral");
       }
       if(!DEP.isSelected()&&!GENERAL.isSelected()){
       A=false;
       mensaje.Alerta("Debe seleccionar el parametro: General o por Departamento");
       }
       if(DEP.isSelected()&&Depas.getValue()==null){
       A=false;
       mensaje.Alerta("Debe ingresar el Departamento para el reporte por Departamento");
       }
       return A;
       }
             private ObservableList<String>Trimestre(){
       List<String> a = new ArrayList<>();
        ObservableList<String> Parcial;
        a.add("Enero-Marzo");
        a.add("Abril-Junio");
        a.add("Julio-Septiembre");
        a.add("Octubre-Diciembre");
        Parcial = FXCollections.observableList(a);
        return Parcial;
       }
      private String TriN(String Trime){
      String n="";
          switch (Trime) {
              case "Enero-Marzo":
                  n="1-3";
                  break;
              case "Abril-Junio":
                  n="4-6";
                  break;
              case "Julio-Septiembre":
                  n="7-9";
                  break;
              case "Octubre-Diciembre":
                  n="10-12";
                  break;
              default:
                  throw new AssertionError();
          }
      return n;
      }
}
