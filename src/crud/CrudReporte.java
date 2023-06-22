/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import BD.DBConexion;
import Entidades.Actividades;
import Entidades.Reporte;
import Otros.Alerta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Usuario
 */
public class CrudReporte {
    
    public void Insert(int id_compu,Date fechai, Date fechaf,
        String texto, String Usuario, int actividad){
    DBConexion conecta= new DBConexion();
    Connection log;
    String sql="Insert into servicio(id_compu,Fecha_i,Fecha_f,descrip,id_Usuario,id_actividad)"
            + "values(?,?,?,?,?,?);";
        try {
            log=conecta.Conectar();
             PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.setInt(1,id_compu);
            sentencia.setDate(2, fechai);
            sentencia.setDate(3, fechaf);
            sentencia.setString(4,texto);
            sentencia.setString(5,Usuario);
            sentencia.setInt(6, actividad);
            sentencia.executeUpdate();
            sentencia.close();
            conecta.Desconectar();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudReporte.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public void Delete(int id_report){
    DBConexion conecta= new DBConexion();
    Connection log;
    String sql="Delete from servicio where id_report="+id_report+";";
        try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.executeUpdate();
            sentencia.close();
            conecta.Desconectar();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Update(int id_compu,Date fechai, Date fechaf,
        String texto, int actividad, int id_report){
        DBConexion conecta= new DBConexion();
    Connection log;
    
    String sql="Update servicio set id_compu="+id_compu+","
            + "Fecha_i='"+fechai+"', Fecha_f='"+fechaf+"',descrip='"+texto+"',"
            + "id_actividad="+actividad+" where id_report="+id_report+";";
        System.out.println(sql);
        System.out.println(fechai);
        System.out.println(fechaf);
        try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.executeUpdate();
            sentencia.close();
            conecta.Desconectar();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
         public ObservableList<Reporte>getDatosBita(){
        DBConexion conecta = new DBConexion();    
       Connection log;  
        ArrayList<Reporte> Buffer = new ArrayList<>();
        Reporte passe;
        ObservableList<Reporte> Parcial;
        Statement sentencia;
        String oracion = 
 "SELECT servicio.id_report as ID, computador.nombre, servicio.Fecha_i as inicio, servicio.fecha_f finalizado, servicio.descrip as Descripcion,\n" +
"servicio.id_Usuario as usuario, actividad.nombre as Actividad,actividad.id_actividad as IDActi,depsed.id_dep_sed as DepSed, sede.nombre as Sede, departamento.nombre as Departamento \n" +
"FROM departamento, actividad,servicio INNER JOIN computador on servicio.id_compu=computador.id_compu\n" +
"INNER JOIN depsed on computador.id_sed_dep=depsed.id_dep_sed\n" +
"INNER JOIN sede on depsed.id_sed=sede.id_sede\n" +
"WHERE departamento.id_dep=depsed.id_dep AND servicio.id_actividad=actividad.id_actividad;";
        try {
            log=conecta.Conectar();
            sentencia = log.createStatement();
            ResultSet bloque = sentencia.executeQuery(oracion);
            while (bloque.next()) {
                   passe = new  Reporte();
                   passe.setActividad(bloque.getString("Actividad"));
                   passe.setId_report(bloque.getInt("ID"));
                   passe.setComputador(bloque.getString("nombre"));
                   passe.setFecha_i(bloque.getDate("inicio"));
                   passe.setFecha_f(bloque.getDate("finalizado"));
                   passe.setTexto(bloque.getString("Descripcion"));
                   passe.setUsuario(bloque.getString("usuario"));
                   passe.setDepartamento(bloque.getString("Departamento"));
                   passe.setSede(bloque.getString("Sede"));
                   passe.setDepsed(bloque.getString("DepSed"));
                   passe.setId_actividad(bloque.getInt("IDActi"));
                    SimpleDateFormat simdat=new SimpleDateFormat("dd-MM-yyyy");                     
                   passe.setFechai(simdat.format(passe.getFecha_i()));
                   passe.setFechaf(simdat.format(passe.getFecha_f()));
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
          public ObservableList<Reporte>getDatosSede(int Sede){
        DBConexion conecta = new DBConexion();    
       Connection log;  
        ArrayList<Reporte> Buffer = new ArrayList<>();
        Reporte passe;
        ObservableList<Reporte> Parcial;
        Statement sentencia;
        String oracion = 
 "SELECT servicio.id_report as ID, computador.nombre, servicio.Fecha_i as inicio, servicio.fecha_f finalizado, servicio.descrip as Descripcion,\n" +
"servicio.id_Usuario as usuario, actividad.nombre as Actividad,actividad.id_actividad as IDActi,depsed.id_dep_sed as DepSed, sede.nombre as Sede, departamento.nombre as Departamento \n" +
"FROM departamento, actividad,servicio INNER JOIN computador on servicio.id_compu=computador.id_compu\n" +
"INNER JOIN depsed on computador.id_sed_dep=depsed.id_dep_sed\n" +
"INNER JOIN sede on depsed.id_sed=sede.id_sede\n" +
"WHERE departamento.id_dep=depsed.id_dep AND servicio.id_actividad=actividad.id_actividad AND sede.id_sede="+Sede+";";
        try {
            log=conecta.Conectar();
            sentencia = log.createStatement();
            ResultSet bloque = sentencia.executeQuery(oracion);
            while (bloque.next()) {
                 passe = new  Reporte();
                passe.setActividad(bloque.getString("Actividad"));
                   passe.setId_report(bloque.getInt("ID"));
                   passe.setComputador(bloque.getString("nombre"));
                   passe.setFecha_i(bloque.getDate("inicio"));
                   passe.setFecha_f(bloque.getDate("finalizado"));
                   passe.setTexto(bloque.getString("Descripcion"));
                   passe.setUsuario(bloque.getString("usuario"));
                   passe.setDepartamento(bloque.getString("Departamento"));
                   passe.setSede(bloque.getString("Sede"));
                   passe.setDepsed(bloque.getString("DepSed"));
                   passe.setId_actividad(bloque.getInt("IDActi"));
                   SimpleDateFormat simdat=new SimpleDateFormat("dd-MM-yyyy");                     
                   passe.setFechai(simdat.format(passe.getFecha_i()));
                   passe.setFechaf(simdat.format(passe.getFecha_f()));
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
             public int MaxId(){
    Connection log;  
    DBConexion conecta = new DBConexion();
    int state = -1;
    try{
        log=conecta.Conectar();
        PreparedStatement pst;
        ResultSet rs;
        //Se usa el metodo MD5 para encriptar la contraseña 
        String sql="SELECT MAX(id_report) as maximo from servicio;";
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
    public int MaxRe(String Cedula){
    Connection log;  
    DBConexion conecta = new DBConexion();
    int state = 0;
    try{
        log=conecta.Conectar();
        PreparedStatement pst;
        ResultSet rs;
        //Se usa el metodo MD5 para encriptar la contraseña 
        String sql="SELECT COUNT(id_Usuario) as maximo from servicio where id_Usuario='"+Cedula+"';";
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
}
