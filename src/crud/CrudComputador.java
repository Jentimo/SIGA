/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
import Otros.Alerta;
import Otros.Error;
import BD.DBConexion;
import Entidades.Actividades;
import Entidades.Computador;
import static funciones.Loggin.getMD5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Timaure
 */
public class CrudComputador {
    
    public void Insert(String Nombre, String DepSed){
        DBConexion conecta= new DBConexion();
            Connection log;
            String sql="INSERT INTO COMPUTADOR (ID_SED_DEP, NOMBRE) VALUES (?,?);";
        try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.setString(1, DepSed);
            sentencia.setString(2, Nombre);
            sentencia.executeUpdate();
            sentencia.close();
            conecta.Desconectar();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudComputador.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    public void delete(int Id) throws SQLException{
        DBConexion conecta= new DBConexion();
            Connection log;
            String sql="DELETE FROM COMPUTADOR WHERE ID_COMPU='"+Id+"';";
        try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.execute();
        } catch (Alerta ex) {
            Logger.getLogger(CrudComputador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void UPDATE(int ID, String Nombre, String DepSed) throws SQLException{
        DBConexion conecta= new DBConexion();
            Connection log;
            String sql="UPDATE COMPUTADOR SET VALUES ID_DEP_SED='"+DepSed+"', NOMBRE='"+Nombre+"' WHERE ID_COMPU='"+ID+"';";
        try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.execute();
        } catch (Alerta ex) {
            Logger.getLogger(CrudComputador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean comprobrar(String Nombre){
         Connection log;
            DBConexion conecta = new DBConexion();
            boolean a = false;
            
        try {
            log=conecta.Conectar();
            PreparedStatement pst;
            ResultSet rs;
            String sql="select * from computador where nombre='"+Nombre+"'";
            pst = log.prepareStatement(sql);
rs = pst.executeQuery(sql);
a=rs.next();
rs.close();
pst.close();
conecta.Desconectar();


        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudComputador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
}
      public int GetId(String Nombre){
         Connection log;
            DBConexion conecta = new DBConexion();
            int  a = 0;
            
        try {
            log=conecta.Conectar();
            PreparedStatement pst;
            ResultSet rs;
            String sql="select * from computador where nombre='"+Nombre+"'";
            pst = log.prepareStatement(sql);
rs = pst.executeQuery(sql);
if(rs.next()){
a=rs.getInt("id_compu");
}
rs.close();
pst.close();
conecta.Desconectar();


        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudComputador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
}  
              public ObservableList<Computador>getDatosBita(){
        DBConexion conecta = new DBConexion();    
       Connection log;  
        ArrayList<Computador> Buffer = new ArrayList<>();
        Computador passe;
        ObservableList<Computador> Parcial;
        Statement sentencia;
        String oracion = "SELECT computador.id_compu,"
                + " computador.id_sed_dep,"
                + " computador.nombre, "
                + "departamento.nombre as departamento, "
                + "sede.nombre as sede from departamento,"
                + " computador INNER join depsed on computador.id_sed_dep=depsed.id_dep_sed "
                + "INNER JOIN sede on depsed.id_sed=sede.id_sede "
                + "where depsed.id_dep=departamento.id_dep;";
        try {
            log=conecta.Conectar();
            sentencia = log.createStatement();
            ResultSet bloque = sentencia.executeQuery(oracion);
            while (bloque.next()) {
                   passe = new  Computador();
                  passe.setDepsed(bloque.getString("id_sed_dep"));
                  passe.setId_compu(bloque.getInt("id_compu"));
                  passe.setNombre(bloque.getString("nombre"));
                  passe.setDEP(bloque.getString("departamento"));
                  passe.setSEDE(bloque.getString("sede"));
                   Buffer.add(passe);
               }
         sentencia.close();
         conecta.Desconectar();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudActi.class.getName()).log(Level.SEVERE, null, ex);
        }
            Parcial = FXCollections.observableList(Buffer);
        return Parcial;
}
}
