/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import BD.DBConexion;
import Otros.Alerta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static jdk.nashorn.tools.ShellFunctions.input;
import Otros.Error;

/**
 *
 * @author Timaure
 */
public class Loggin {
    
    //funcion para buscar login
    public boolean FirtsLog(String Usuario){
    Connection log;
    DBConexion conecta = new DBConexion();
    boolean state = false;
        try {
            log=conecta.Conectar();
            PreparedStatement pst;
            ResultSet rs;
            String sql="Select * from recuperar where cedula="+Usuario+";";
           pst = log.prepareStatement(sql);
         rs = pst.executeQuery(sql);
         state=rs.next();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(Loggin.class.getName()).log(Level.SEVERE, null, ex);
        }
   return state;
            }
        public int Type(String Usuario){
    Connection log;
    DBConexion conecta = new DBConexion();
    int state = 0;
        try {
            log=conecta.Conectar();
            PreparedStatement pst;
            ResultSet rs;
            String sql="Select * from usuario where cedula="+Usuario+";";
           pst = log.prepareStatement(sql);
         rs = pst.executeQuery(sql);
        if(rs.next()){
            state=rs.getInt("id_acceso");
        }
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(Loggin.class.getName()).log(Level.SEVERE, null, ex);
        }
   return state;
            }
    
     public int login(String Usuario, String Contraseña) throws Alerta{
    Connection log;  
    DBConexion conecta = new DBConexion();
    int state = -1;
    try{
    log=conecta.Conectar();
     PreparedStatement pst;
        ResultSet rs;
        //Se usa el metodo MD5 para encriptar la contraseña 
        String sql="SELECT * FROM usuario WHERE CEDULA='"+Usuario+"' AND CLAVE='"+getMD5(Contraseña)+"';";
        pst = log.prepareStatement(sql);
//        pst.setString(1, Usuario);
//        pst.setString(2, Contraseña);
         rs = pst.executeQuery(sql);
        if(rs.next()){
        int ativo=rs.getInt("activo");
        if(ativo==1){
         state=1;
        Error mensaje= new Error();
        mensaje.Info("Bienvenido "+rs.getString("nombre"));
        }else{
         Error mensaje= new Error();
        mensaje.Alerta("El Usuario se encuentra inactivo, Contacte con su administrador");
        }
       
        }else{
        state=0;
        }
        rs.close();
        pst.close();
        conecta.Desconectar();
    }catch(SQLException ex){
    Alerta.Mensaje("1");
//Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
    }catch (Alerta ex) {
            Alerta.Mensaje(ex.getMessage());
        }   
        return state;
    }
     //funcion MD5 para encriptar la contraseña
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
