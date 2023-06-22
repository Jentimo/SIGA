/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import BD.DBConexion;
import Entidades.Actividades;
import Otros.Alerta;
import java.sql.Connection;
import java.sql.Date;
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
public class CrudActi {
     public void Insert(String nombre) throws SQLException{
    DBConexion conecta= new DBConexion();
    Connection log;
    String sql="Insert into actividad(nombre,activo) values (?,?);";
        try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.setString(1,nombre);
            sentencia.setInt(2,1);
            sentencia.executeUpdate();
            sentencia.close();
            conecta.Desconectar();
        } catch (Alerta ex) {
            Logger.getLogger(CrudActi.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
      public void Update(String nombre,int id, int activo) {
    DBConexion conecta= new DBConexion();
    Connection log;
    String sql="update actividad set  nombre='"+nombre+"', activo="+activo+" where id_actividad="+id+";";
        try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.executeUpdate();
            sentencia.close();
            conecta.Desconectar();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudActi.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
        public void Delete(int id) throws SQLException{
         try {
             Actividades actividad = new Actividades();
             DBConexion conecta= new DBConexion();
             Connection log;
             String sql="select * from  actividad where id_actividad="+id+";";
             log=conecta.Conectar();
             PreparedStatement pst;
             ResultSet rs;
             pst = log.prepareStatement(sql);
             rs = pst.executeQuery(sql);
             if(rs.next()){
             actividad.setActivo(rs.getInt("activo"));
             if(actividad.getActivo()==0){
             String sql1="update actividad set activo=1 where id_actividad="+id+"";
             PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql1);
            sentencia.executeUpdate();
            sentencia.close();
             }else{
             String sql1="update actividad set activo=0 where id_actividad="+id+"";
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
         }
    }
        
        public void Update_AutoI(){
     DBConexion conecta= new DBConexion();
    Connection log;
    int max=0;
    max= MaxId();
    max++;    
    String sql="ALTER TABLE actividad AUTO_INCREMENT="+max+";";
        try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.execute();
            sentencia.close();
            conecta.Desconectar();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudDep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
        
        
        
   public int MaxId(){
    Connection log;  
    DBConexion conecta = new DBConexion();
    int state = -1;
    try{
        log=conecta.Conectar();
        PreparedStatement pst;
        ResultSet rs;
        //Se usa el metodo MD5 para encriptar la contraseña 
        String sql="SELECT MAX(id_actividad) as maximo from actividad;";
        pst = log.prepareStatement(sql);
        rs = pst.executeQuery(sql);
        if(rs.next()){
            state= rs.getInt("maximo");
        }
        rs.close();
        pst.close();
        conecta.Desconectar();
    }catch(SQLException ex){
    Alerta.Mensaje("1");
     Logger.getLogger(CrudActi.class.getName()).log(Level.SEVERE, null, ex);
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
        String oracion = "SELECT * FROM actividad;";
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
            Logger.getLogger(CrudActi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Alerta ex) {
            Logger.getLogger(CrudActi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comprobrar;
        
    }
        public ObservableList<Actividades>getDatosBita(){
        DBConexion conecta = new DBConexion();    
       Connection log;  
        ArrayList<Actividades> Buffer = new ArrayList<>();
        Actividades passe;
        ObservableList<Actividades> Parcial;
        Statement sentencia;
        String oracion = "SELECT * FROM actividad;";
        try {
            log=conecta.Conectar();
            sentencia = log.createStatement();
            ResultSet bloque = sentencia.executeQuery(oracion);
            while (bloque.next()) {
                   passe = new  Actividades();
                   passe.setId(bloque.getInt("id_actividad"));
                   passe.setNombre(bloque.getString("nombre"));
                   passe.setActivo(bloque.getInt("activo"));
                   if(passe.getActivo()==0){
                       passe.setActi("NO");
                   }else{passe.setActi("SI");}
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
                public ObservableList<String>getDatosString(){
        DBConexion conecta = new DBConexion();    
       Connection log;  
        ArrayList<String> Buffer = new ArrayList<>();
        Actividades passe;
        ObservableList<String> Parcial;
        Statement sentencia;
        String oracion = "SELECT * FROM actividad where activo=1;";
        try {
            log=conecta.Conectar();
            sentencia = log.createStatement();
            ResultSet bloque = sentencia.executeQuery(oracion);
            while (bloque.next()) {
                   passe = new  Actividades();
                   passe.setId(bloque.getInt("id_actividad"));
                   passe.setNombre(bloque.getString("nombre"));
                   String acti=passe.getNombre()+"-"+passe.getId().toString();
                   Buffer.add(acti);
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
