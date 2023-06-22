package crud;

import BD.DBConexion;
import Entidades.Actividades;
import Entidades.DepSed;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Usuario
 */
public class CrudDepSed {
    public void Insert(String nombre,int idD, int idS){
    DBConexion conecta= new DBConexion();
    Connection log;
    String sql="Insert into depsed(id_dep_sed,id_dep,id_sed,activo) values (?,?,?,?);";
        try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.setString(1,nombre);
            sentencia.setInt(2, idD);
            sentencia.setInt(3, idS);
            sentencia.setInt(4, 1);
            sentencia.executeUpdate();
            sentencia.close();
            conecta.Desconectar();
        } catch (Alerta ex) {
            Logger.getLogger(CrudActi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CrudDepSed.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    public boolean Comprobar(int IDS, int IDP){
    boolean a=false;
    DBConexion conecta= new DBConexion();
    Connection log;
    String sql="Select * from depsed where id_sed="+IDS+" AND id_dep="+IDP+";";
        try {
            log=conecta.Conectar();
            ResultSet rs;
            PreparedStatement pst;
            pst = log.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            a = rs.next();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudDepSed.class.getName()).log(Level.SEVERE, null, ex);
        }
    return a;
    }
    
    public void Update(String nombre,int idD, int idS) throws SQLException{
    DBConexion conecta= new DBConexion();
    Connection log;
    String sql="Update depsed set  "
            + "id_dep="+idD+", id_sed="+idS+" where id_dep_sed='"+nombre+"';";
        try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.executeUpdate();
            sentencia.close();
            conecta.Desconectar();
        } catch (Alerta ex) {
            Logger.getLogger(CrudActi.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
         public void Delete(String nombre) throws SQLException{
         try {
             DepSed actividad = new DepSed();
             DBConexion conecta= new DBConexion();
             Connection log;
             String sql="select * from  depsed where id_dep_sed='"+nombre+"';";
             log=conecta.Conectar();
             PreparedStatement pst;
             ResultSet rs;
             pst = log.prepareStatement(sql);
             rs = pst.executeQuery(sql);
             if(rs.next()){
             actividad.setActivo(rs.getInt("activo"));
             if(actividad.getActivo()==0){
             String sql1="update depsed set activo=1 where id_dep_sed='"+nombre+"';";
             PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql1);
            sentencia.executeUpdate();
            sentencia.close();
             }else{
             String sql1="update depsed set activo=0 where id_dep_sed='"+nombre+"';";
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
        public ObservableList<DepSed>getDatosBita(){
        DBConexion conecta = new DBConexion();    
       Connection log;  
        ArrayList<DepSed> Buffer = new ArrayList<>();
        DepSed passe;
        ObservableList<DepSed> Parcial;
        Statement sentencia;
        String oracion = "SELECT * FROM depsed;";
        try {
            log=conecta.Conectar();
            sentencia = log.createStatement();
            ResultSet bloque = sentencia.executeQuery(oracion);
            while (bloque.next()) {
                   passe = new  DepSed();
                   passe.setIdD(bloque.getInt("id_dep"));
                   passe.setIdS(bloque.getInt("id_sed"));
                   passe.setCodigo(bloque.getString("id_dep_sed"));
                   passe.setActivo(bloque.getInt("activo"));
                   if(passe.getActivo()==0){
                       passe.setActi("NO");
                   }
                   else{
                       passe.setActi("SI");
                   }
                    String sql="Select * from departamento where id_dep="+passe.getIdD()+";";
                    PreparedStatement pst;
                    ResultSet rs;
                    pst = log.prepareStatement(sql);
                    rs = pst.executeQuery(sql);
                    if(rs.next()){
                        passe.setNombreD(rs.getString("nombre"));
                    }
                    rs.close();
                    pst.close();
                    String sql1="Select * from sede where id_sede='"+passe.getIdS()+"';";
                    PreparedStatement pst1;
                    ResultSet rs1;
                    pst1 = log.prepareStatement(sql1);
                    rs1 = pst1.executeQuery(sql1);
                    if(rs1.next()){
                        passe.setNombreS(rs1.getString("nombre"));
                    }
                    rs1.close();
                    pst1.close();
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
        public ObservableList<DepSed>getDatosBitaActi(){
        DBConexion conecta = new DBConexion();    
       Connection log;  
        ArrayList<DepSed> Buffer = new ArrayList<>();
        DepSed passe;
        ObservableList<DepSed> Parcial;
        Statement sentencia;
        String oracion = "SELECT * FROM depsed where activo=1;";
        try {
            log=conecta.Conectar();
            sentencia = log.createStatement();
            ResultSet bloque = sentencia.executeQuery(oracion);
            while (bloque.next()) {
                   passe = new  DepSed();
                   passe.setIdD(bloque.getInt("id_dep"));
                   passe.setIdS(bloque.getInt("id_sed"));
                   passe.setCodigo(bloque.getString("id_dep_sed"));
                   passe.setActivo(bloque.getInt("activo"));
                   if(passe.getActivo()==0){
                       passe.setActi("NO");
                   }
                   else{
                       passe.setActi("SI");
                   }
                    String sql="Select * from departamento where id_dep="+passe.getIdD()+";";
                    PreparedStatement pst;
                    ResultSet rs;
                    pst = log.prepareStatement(sql);
                    rs = pst.executeQuery(sql);
                    if(rs.next()){
                        passe.setNombreD(rs.getString("nombre"));
                    }
                    rs.close();
                    pst.close();
                    String sql1="Select * from sede where id_sede='"+passe.getIdS()+"';";
                    PreparedStatement pst1;
                    ResultSet rs1;
                    pst1 = log.prepareStatement(sql1);
                    rs1 = pst1.executeQuery(sql1);
                    if(rs1.next()){
                        passe.setNombreS(rs1.getString("nombre"));
                    }
                    rs1.close();
                    pst1.close();
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
