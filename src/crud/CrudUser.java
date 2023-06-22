/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
import Otros.Alerta;
import Otros.Error;
import BD.DBConexion;
import Entidades.Usuario;
import funciones.Loggin;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author Timaure
 */
public class CrudUser {
    
    public void Insert(String Cedula,String Nombre,String Clave,
    int acceso){
        DBConexion conecta= new DBConexion();
    Connection log;
    String sql="Insert into usuario(cedula,nombre,clave,id_acceso,activo) values(?,?,?,?,?);";
        try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.setString(1,Cedula);
            sentencia.setString(2,Nombre);
            sentencia.setString(3,getMD5(Clave));
            sentencia.setInt(4, acceso);
            sentencia.setInt(5,1);
            sentencia.execute();
            sentencia.close();
            conecta.Desconectar();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudUser.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }

   public void InsertPreguntas(String Cedula, int preguntas, String Respuesta){
        DBConexion conecta= new DBConexion();
    Connection log;
    String sql="Insert into recuperar(cedula,id_pregunta,respuesta) values(?,?,?);";
        try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.setString(1,Cedula);
            sentencia.setInt(2,preguntas);
            sentencia.setString(3,getMD5(Respuesta));
            sentencia.execute();
            sentencia.close();
            conecta.Desconectar();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudUser.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
   public String retornarPregunta(int ID_pregunta){
   String Pregunta="";
   Connection log;
    DBConexion conecta = new DBConexion();
        try {
            log=conecta.Conectar();
            PreparedStatement pst;
            ResultSet rs;
            String sql="Select * from preguntas where id_pregunta="+ID_pregunta+";";
           pst = log.prepareStatement(sql);
         rs = pst.executeQuery(sql);
         if(rs.next()){
             Pregunta=rs.getString("pregunta");
         }
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(Loggin.class.getName()).log(Level.SEVERE, null, ex);
        }
   return Pregunta;
   }
public boolean retornarCoincidenciaPreg(int ID_pregunta, String respuesta, String Usuario){
  boolean state=false;
   Connection log;
    DBConexion conecta = new DBConexion();
        try {
            log=conecta.Conectar();
            PreparedStatement pst;
            ResultSet rs;
            String sql="Select * from recuperar where id_pregunta="+ID_pregunta+" and cedula='"+Usuario+"' and respuesta='"+getMD5(respuesta)+"';";
           pst = log.prepareStatement(sql);
         rs = pst.executeQuery(sql);
         state=rs.next();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(Loggin.class.getName()).log(Level.SEVERE, null, ex);
        }
   return state;
   }


public void Update(String Cedula,String Nombre,
    int acceso){
        DBConexion conecta= new DBConexion();
    Connection log;
    String sql="update usuario set  nombre='"+Nombre+"',id_acceso="+acceso+" where cedula="+Cedula+";";
        try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.execute();
            sentencia.close();
            conecta.Desconectar();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudUser.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
public void UpdatePass(String Cedula,String Pass){
        DBConexion conecta= new DBConexion();
    Connection log;
    String sql="update usuario set  clave='"+getMD5(Pass)+"' where cedula="+Cedula+";";
        try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.execute();
            sentencia.close();
            conecta.Desconectar();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudUser.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }

        public void Delete(String id){
         try {
             Usuario actividad = new Usuario();
             DBConexion conecta= new DBConexion();
             Connection log;
             String sql="select * from usuario where cedula="+id+";";
             log=conecta.Conectar();
             PreparedStatement pst;
             ResultSet rs;
             pst = log.prepareStatement(sql);
             rs = pst.executeQuery(sql);
             if(rs.next()){
             actividad.setActivo(rs.getInt("activo"));
             if(actividad.getActivo()==0){
             String sql1="update usuario set activo=1 where cedula="+id+"";
             PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql1);
            sentencia.executeUpdate();
            sentencia.close();
             }else{
             String sql1="update usuario set activo=0 where cedula="+id+"";
             PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql1);
            sentencia.executeUpdate();
            sentencia.close();
             }
             }
             rs.close();
        pst.close();
         } catch (Alerta | SQLException ex) {
             Logger.getLogger(CrudUser.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
        
            public ObservableList<Usuario>getDatosBita(){
        DBConexion conecta = new DBConexion();    
       Connection log;  
        ArrayList<Usuario> Buffer = new ArrayList<>();
        Usuario passe;
        ObservableList<Usuario> Parcial;
        Statement sentencia;
        String oracion = "SELECT usuario.cedula as Cedula,"
                + " usuario.nombre as Nombre, "
                + "acceso.tipo as Acceso, usuario.activo "
                + "as Activo FROM usuario INNER JOIN acceso on usuario.id_acceso=acceso.id_acceso;";
        try {
            log=conecta.Conectar();
            sentencia = log.createStatement();
            ResultSet bloque = sentencia.executeQuery(oracion);
            while (bloque.next()) {
                   passe = new  Usuario();
                   passe.setCedula(bloque.getString("Cedula"));
                   passe.setNombre(bloque.getString("Nombre"));
                   passe.setAcceso(bloque.getString("Acceso"));
                   passe.setActivo(bloque.getInt("Activo"));
                    String sql="SELECT  bitacora.Fecha_h as inicio_sesion FROM bitacora WHERE bitacora.Usuario="+passe.getCedula()+" AND bitacora.descr='Inicio Sesion' \n" +
"ORDER BY inicio_sesion  DESC LIMIT 1;";
                    PreparedStatement pst;
                    ResultSet rs;
                    pst = log.prepareStatement(sql);
                    rs = pst.executeQuery(sql);
                    if(rs.next()){
                         Timestamp timestamp = rs.getTimestamp("inicio_sesion");
                SimpleDateFormat simdat=new SimpleDateFormat("dd-MM-yyyy hh:mm a");
                passe.setFecha(simdat.format(timestamp));
                    }else{
                    passe.setFecha("");
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
            public boolean ComprobarCedula(String Usuario){
    Connection log;
    DBConexion conecta = new DBConexion();
    boolean state = false;
        try {
            log=conecta.Conectar();
            PreparedStatement pst;
            ResultSet rs;
            String sql="Select * from usuario where cedula="+Usuario+";";
           pst = log.prepareStatement(sql);
         rs = pst.executeQuery(sql);
         state=rs.next();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(Loggin.class.getName()).log(Level.SEVERE, null, ex);
        }
   return state;
            }
 public boolean ComprobarCedulaActivo(String Usuario){
    Connection log;
    DBConexion conecta = new DBConexion();
    boolean state = false;
        try {
            log=conecta.Conectar();
            PreparedStatement pst;
            ResultSet rs;
            String sql="Select * from usuario where cedula="+Usuario+" and activo=1;";
           pst = log.prepareStatement(sql);
         rs = pst.executeQuery(sql);
         state=rs.next();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(Loggin.class.getName()).log(Level.SEVERE, null, ex);
        }
   return state;
            }
  public static String getMD5(String input) {
 try {
 MessageDigest md = MessageDigest.getInstance("MD5");
 byte[] messageDigest = md.digest(input.getBytes());
 BigInteger number = new BigInteger(1, messageDigest);
 String hashtext = number.toString(16);

 while (hashtext.length() < 32) {
 hashtext = "0" + hashtext;
 }
 return hashtext;
 }
 catch (NoSuchAlgorithmException e) { throw new RuntimeException(e);}
 }
}
