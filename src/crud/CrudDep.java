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
import Entidades.Departamento;
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
 * @author Usuario
 */
public class CrudDep {
    public void Insert(String Nombre){
     DBConexion conecta= new DBConexion();
    Connection log;
    String sql="Insert into departamento (nombre,activo) values(?,?);";
        try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.setString(1, Nombre);
            sentencia.setInt(2, 1);
            sentencia.execute();
            sentencia.close();
            conecta.Desconectar();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudDep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public void Update(String Nombre, int Dep){
     DBConexion conecta= new DBConexion();
    Connection log;
    String sql="Update departamento set nombre='"+Nombre+"' where id_dep="+Dep+";";
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
    public boolean Comprobar(String S){
       boolean comprobrar=true;
        DBConexion conecta = new DBConexion();    
       Connection log; 
       Statement sentencia;
        String oracion = "SELECT * FROM departamento;";
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
            Logger.getLogger(CrudDep.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Alerta ex) {
            Logger.getLogger(CrudDep.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comprobrar;
        
    }
   public void Update_AutoI(){
     DBConexion conecta= new DBConexion();
    Connection log;
    int max=0;
    max= MaxId();
    max++;    
    String sql="ALTER TABLE DEPARTAMENTO AUTO_INCREMENT="+max+";";
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
        public void Delete(int id){
         try {
             Departamento actividad = new Departamento();
             DBConexion conecta= new DBConexion();
             Connection log;
             String sql="select * from departamento where id_dep="+id+";";
             log=conecta.Conectar();
             PreparedStatement pst;
             ResultSet rs;
             pst = log.prepareStatement(sql);
             rs = pst.executeQuery(sql);
             if(rs.next()){
             actividad.setActivo(rs.getInt("activo"));
             if(actividad.getActivo()==0){
             String sql1="update departamento set activo=1 where id_dep="+id+"";
             PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql1);
            sentencia.executeUpdate();
            sentencia.close();
             }else{
             String sql1="update departamento set activo=0 where id_dep="+id+"";
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
        String sql="SELECT MAX(id_dep) as maximo from departamento;";
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
     Logger.getLogger(CrudDep.class.getName()).log(Level.SEVERE, null, ex);
    }catch (Alerta ex) {
            Alerta.Mensaje(ex.getMessage());
        }   
        return state;
    }
   
   public void Acomodar(){
    Connection log;  
    DBConexion conecta = new DBConexion();
    int state = -1;
    while(state==-1){
        try {
            log=conecta.Conectar();
            PreparedStatement pst;
            ResultSet rs;
            //Se usa el metodo MD5 para encriptar la contraseña
            String sql="update departament;";
            pst = log.prepareStatement(sql);
            rs = pst.executeQuery(sql);
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudDep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   };
    public ObservableList<Departamento>getDatosBita(){
        DBConexion conecta = new DBConexion();    
       Connection log;  
        ArrayList<Departamento> Buffer = new ArrayList<>();
        Departamento passe;
        ObservableList<Departamento> Parcial;
        Statement sentencia;
        String oracion = "SELECT * FROM departamento;";
        try {
            log=conecta.Conectar();
            sentencia = log.createStatement();
            ResultSet bloque = sentencia.executeQuery(oracion);
            while (bloque.next()) {
                   passe = new  Departamento();
                   passe.setId(bloque.getInt("id_dep"));
                   passe.setNombre(bloque.getString("nombre"));
                   passe.setActivo(bloque.getInt("activo"));
                   if(passe.getActivo()==0){
                       passe.setActi("NO");
                   }
                   else{
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
        Departamento passe;
        ObservableList<String> Parcial;
        Statement sentencia;
        String oracion = "SELECT * FROM departamento where activo=1;";
        try {
            log=conecta.Conectar();
            sentencia = log.createStatement();
            ResultSet bloque = sentencia.executeQuery(oracion);
            while (bloque.next()) {
                   passe = new  Departamento();
                   passe.setId(bloque.getInt("id_dep"));
                   passe.setNombre(bloque.getString("nombre"));
                   String texto=passe.getNombre()+"-"+passe.getId();
                   Buffer.add(texto);
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
