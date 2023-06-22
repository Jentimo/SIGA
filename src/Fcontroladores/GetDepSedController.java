/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fcontroladores;

import Entidades.DepSed;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import crud.CrudDepSed;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import Otros.Error;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Timaure
 */
public class GetDepSedController implements Initializable {

    @FXML
    private TableView Tablew;
    @FXML
    private TableColumn C0;
    @FXML
    private TableColumn C1;
    @FXML
    private TableColumn C2;
    @FXML
    private JFXButton take;
    @FXML
    private JFXButton cancel;
    @FXML
    private JFXTextField filter;
    private CrudDepSed funci= new CrudDepSed();
    private Error mensaje= new Error();
    private DepSed objeto= new DepSed();
    FReporteController controlador;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        C0.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
        C1.setCellValueFactory(new PropertyValueFactory<>("NombreD"));
        C2.setCellValueFactory(new PropertyValueFactory<>("NombreS"));
        Tablew.setItems(funci.getDatosBitaActi());
        Tablew.refresh();
        filtro();
        take.setOnAction(llevar);
        cancel.setOnAction(cancelado);
    }    
    private EventHandler<ActionEvent> llevar= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
           if(Tablew.getSelectionModel().getSelectedItem()==null){
               mensaje.Alerta("Debe Selecionar un elemento de la tabla");
           }
           else{
               objeto=(DepSed)Tablew.getSelectionModel().getSelectedItem();
               controlador.RecibirDepSed(objeto.Codigo());
               Node source = (Node) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
           }
        }
    
    };
    private EventHandler<ActionEvent> cancelado= new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
         Node source = (Node) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
        }
        
    };
    public void Recibir(FReporteController controla){
    controlador=controla;
    }
    private void filtro(){
   FilteredList<DepSed> filteredData= new FilteredList<DepSed>(funci.getDatosBitaActi(), b -> true);
   filter.textProperty().addListener((observable, oldValue, newValue) ->{
       filteredData.setPredicate(employee ->{
           if (newValue == null || newValue.isEmpty()){
               return true;
           }
           String lowerCaseFilter= newValue.toLowerCase();
           if(employee.getCodigo().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getNombreS().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else if(employee.getNombreD().toLowerCase().indexOf(lowerCaseFilter)!=-1){return true;}
           else
               return false;
       });
   });
   SortedList<DepSed> sortedData= new SortedList<>(filteredData);
   sortedData.comparatorProperty().bind(Tablew.comparatorProperty());
   Tablew.setItems(sortedData);
   }
}
