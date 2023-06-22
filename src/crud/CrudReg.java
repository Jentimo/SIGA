/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import BD.DBConexion;
import Entidades.Actividades;
import Entidades.Region;
import Otros.Alerta;
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
 * @author Usuario
 */
public class CrudReg {
    public void Inert(String Nombre,String Codigo){
        DBConexion conecta= new DBConexion();
        Connection log;
        String sql="Insert into region(id_region,nombre,activo) values (?,?,?);";
        try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.setString(1,Codigo);
            sentencia.setString(2,Nombre);
            sentencia.setInt(3, 1);
            sentencia.executeUpdate();
            sentencia.close();
            conecta.Desconectar();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudReg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Update(String Nombre,String Codigo){
        DBConexion conecta= new DBConexion();
        Connection log;
        String sql="Update region set nombre='"+Nombre+"' where id_region='"+Codigo+"';";
        try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.executeUpdate();
            sentencia.close();
            conecta.Desconectar();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudReg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         public String MaxSep(String id){
    Connection log;  
    DBConexion conecta = new DBConexion();
    String state = "";
    try{
        log=conecta.Conectar();
        PreparedStatement pst;
        ResultSet rs;
        //Se usa el metodo MD5 para encriptar la contraseña 
        String sql="SELECT COUNT(sede.id_sede)"
                + " as maximo, region.nombre "
                + "from sede JOIN region on sede.id_region=region.id_region "
                + "where sede.id_region='"+id+"' GROUP by region.id_region";
        pst = log.prepareStatement(sql);
        rs = pst.executeQuery(sql);
        if(rs.next()){
            state= rs.getString("maximo");
        }
        rs.close();
        pst.close();
        conecta.Desconectar();
    }catch(SQLException ex){
    Alerta.Mensaje("1");
     Logger.getLogger(CrudDep.class.getName()).log(Level.SEVERE, null, ex);
    }catch (Alerta ex) {
            Alerta.Mensaje(ex.getMessage());
        }   
        return state;
    }
         public boolean Comprobar(String S){
       boolean comprobrar=true;
        DBConexion conecta = new DBConexion();    
       Connection log; 
       Statement sentencia;
        String oracion = "SELECT * FROM region;";
        try {
            log=conecta.Conectar();
            sentencia = log.createStatement();
            ResultSet bloque = sentencia.executeQuery(oracion);
            while(bloque.next()){
                String nombre=bloque.getString("nombre");
                nombre.replaceAll("\\s","");
                if(S.equals(nombre.toLowerCase())){comprobrar=false;}
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudReg.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Alerta ex) {
            Logger.getLogger(CrudReg.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comprobrar;
        
    }
   public void Delete(String id) {
         try {
             Region actividad = new Region();
             DBConexion conecta= new DBConexion();
             Connection log;
             String sql="SELECT * from region where id_region='"+id+"';";
             log=conecta.Conectar();
             PreparedStatement pst;
             ResultSet rs;
             pst = log.prepareStatement(sql);
             rs = pst.executeQuery(sql);
             if(rs.next()){
             actividad.setActivo(rs.getInt("activo"));
             if(actividad.getActivo()==0){
             String sql1="update region set activo=1 where id_region='"+id+"';";
             PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql1);
            sentencia.executeUpdate();
            sentencia.close();
             }else{
             String sql1="update region set activo=0 where id_region='"+id+"';";
             PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql1);
            sentencia.executeUpdate();
            sentencia.close();
             }
             }
             rs.close();
        pst.close();
         } catch (Alerta ex) {
             Logger.getLogger(CrudActi.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
            Logger.getLogger(CrudReg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            public ObservableList<Region>getDatosBita(){
        DBConexion conecta = new DBConexion();    
       Connection log;  
        ArrayList<Region> Buffer = new ArrayList<>();
        Region passe;
        ObservableList<Region> Parcial;
        Statement sentencia;
        String oracion = "SELECT * FROM region;";
        try {
            log=conecta.Conectar();
            sentencia = log.createStatement();
            ResultSet bloque = sentencia.executeQuery(oracion);
            while (bloque.next()) {
                   passe = new  Region();
                   passe.setCodigo(bloque.getString("id_region").toUpperCase());
                   passe.setNombre(bloque.getString("nombre"));
                   passe.setActivo(bloque.getInt("activo"));
                   if(passe.getActivo()==0){
                       passe.setActi("NO");
                   }else{
                       passe.setActi("SI");
                   }
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
       public ObservableList<String>getDatosNombre(){
        DBConexion conecta = new DBConexion();    
       Connection log;  
        ArrayList<String> Buffer = new ArrayList<>();
        Region passe;
        ObservableList<String> Parcial;
        Statement sentencia;
        String oracion = "SELECT * FROM region where activo=1;";
        try {
            log=conecta.Conectar();
            sentencia = log.createStatement();
            ResultSet bloque = sentencia.executeQuery(oracion);
            while (bloque.next()) {
                   passe = new  Region();
                   passe.setCodigo(bloque.getString("id_region").toUpperCase());
                   passe.setNombre(bloque.getString("nombre"));
                   String choice=passe.getCodigo()+"-"+passe.getNombre();
                   Buffer.add(choice);
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
