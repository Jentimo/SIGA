package crud;
import Otros.Alerta;
import Otros.Error;
import BD.DBConexion;
import Entidades.Actividades;
import Entidades.Departamento;
import Entidades.Sede;
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Usuario
 */
public class CrudSed {
    public void Insert(String Reg,String Nombre){
        DBConexion conecta= new DBConexion();
            Connection log;
            String sql="Insert into sede (id_region,nombre,activo) values(?,?,?);";
        try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.setString(1,Reg);
            sentencia.setString(2,Nombre);
            sentencia.setInt(3, 1);
            sentencia.execute();
            sentencia.close();
            conecta.Desconectar();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudSed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Update(String Reg,String Nombre, int ID){
        DBConexion conecta= new DBConexion();
            Connection log;
            String sql="Update sede set id_region= '"+Reg+"', nombre='"+Nombre+"' where id_sede="+ID+";";
        try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.execute();
            sentencia.close();
            conecta.Desconectar();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudSed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        public void Delete(int id){
         try {
             Sede actividad = new Sede();
             DBConexion conecta= new DBConexion();
             Connection log;
             String sql="select * from sede where id_sede="+id+";";
             log=conecta.Conectar();
             PreparedStatement pst;
             ResultSet rs;
             pst = log.prepareStatement(sql);
             rs = pst.executeQuery(sql);
             if(rs.next()){
             actividad.setActivo(rs.getInt("activo"));
             if(actividad.getActivo()==0){
             String sql1="update sede set activo=1 where id_sede="+id+"";
             PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql1);
            sentencia.executeUpdate();
            sentencia.close();
             }else{
             String sql1="update sede set activo=0 where id_sede="+id+"";
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
    public void Update_AutoI(){
     DBConexion conecta= new DBConexion();
    Connection log;
    int max=0;
    max= MaxId();
    max++;    
    String sql="ALTER TABLE sede AUTO_INCREMENT="+max+";";
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
        String sql="SELECT MAX(id_sede) as maximo from sede;";
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
     Logger.getLogger(CrudSed.class.getName()).log(Level.SEVERE, null, ex);
    }catch (Alerta ex) {
            Alerta.Mensaje(ex.getMessage());
        }   
        return state;
    }
         public int MaxDep(int id){
    Connection log;  
    DBConexion conecta = new DBConexion();
    int state = 0;
    try{
        log=conecta.Conectar();
        PreparedStatement pst;
        ResultSet rs;
        //Se usa el metodo MD5 para encriptar la contraseña 
        String sql="SELECT COUNT(depsed.id_sed) as total,"
                + " sede.nombre "
                + "FROM depsed JOIN sede on depsed.id_sed=sede.id_sede"
                + " WHERE depsed.id_sed="+id+" AND depsed.activo=1 "
                + "GROUP BY depsed.id_sed;";
        pst = log.prepareStatement(sql);
        rs = pst.executeQuery(sql);
        if(rs.next()){
            state= rs.getInt("total");
            System.out.println(state);
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
    public boolean Comprobar(String S, String id_reg){
       boolean comprobrar=true;
        DBConexion conecta = new DBConexion();    
       Connection log; 
       Statement sentencia;
        String oracion = "SELECT * FROM sede;";
        try {
            log=conecta.Conectar();
            sentencia = log.createStatement();
            ResultSet bloque = sentencia.executeQuery(oracion);
            while(bloque.next()){
                String nombre=bloque.getString("nombre");
                String reg=bloque.getString("id_region");
                nombre.replaceAll("\\s","");
                if(S.equals(nombre.toLowerCase())&&id_reg.equals(reg)){comprobrar=false;}
            }
        } catch (SQLException ex) {
            Logger.getLogger(CrudSed.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Alerta ex) {
            Logger.getLogger(CrudSed.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comprobrar;
        
    }
             public ObservableList<Sede>getDatosBita(){
        DBConexion conecta = new DBConexion();    
       Connection log;  
        ArrayList<Sede> Buffer = new ArrayList<>();
        Sede passe;
        ObservableList<Sede> Parcial;
        Statement sentencia;
        String oracion = "SELECT * FROM sede;";
        try {
            log=conecta.Conectar();
            sentencia = log.createStatement();
            ResultSet bloque = sentencia.executeQuery(oracion);
            while (bloque.next()) {
                passe = new  Sede();
                passe.setCodigo(bloque.getString("id_region"));
                passe.setNombre(bloque.getString("nombre"));
                passe.setId(bloque.getInt("id_sede"));
                passe.setActivo(bloque.getInt("activo"));
                if(passe.getActivo()==0){
                    passe.setActi("NO");
                }else{
                    passe.setActi("SI");
                }
                String sql="Select* from region where id_region='"+passe.getCodigo()+"';";
                PreparedStatement pst;
                ResultSet rs;
                pst = log.prepareStatement(sql);
                rs = pst.executeQuery(sql);
                if(rs.next()){
                    passe.setRegion(rs.getString("nombre"));
                }
                rs.close();
                pst.close();
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
       public ObservableList<String>getDatos(){
        DBConexion conecta = new DBConexion();    
       Connection log;  
        ArrayList<String> Buffer = new ArrayList<>();
        Sede passe;
        ObservableList<String> Parcial;
        Statement sentencia;
        String oracion = "SELECT * FROM sede where activo=1;";
        try {
            log=conecta.Conectar();
            sentencia = log.createStatement();
            ResultSet bloque = sentencia.executeQuery(oracion);
            while (bloque.next()) {
                passe = new  Sede();
                passe.setCodigo(bloque.getString("id_region"));
                passe.setNombre(bloque.getString("nombre"));
                passe.setId(bloque.getInt("id_sede"));
                String sql="Select* from region where id_region='"+passe.getCodigo()+"';";
                PreparedStatement pst;
                ResultSet rs;
                pst = log.prepareStatement(sql);
                rs = pst.executeQuery(sql);
                if(rs.next()){
                    passe.setRegion(rs.getString("nombre"));
                }
                rs.close();
                pst.close();
                String Texto=passe.getNombre()+"-"+passe.getId();
                   Buffer.add(Texto);
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
