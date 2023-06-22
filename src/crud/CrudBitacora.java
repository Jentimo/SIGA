/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import Otros.Alerta;
import BD.DBConexion;
import funciones.Bitacora;


import java.sql.Connection;
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
 * @author 
 */
public class CrudBitacora extends DBConexion{
    
    
     public boolean RegistrarBITACORA(Bitacora em){
    
        PreparedStatement ps=null;
        
        
        String sql= "INSERT INTO bitacora (Usuario, Fecha_h, descr) VALUES (?,?,?);";
        
        
        try {
            Connection con= Conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, em.getUsuario());
            ps.setTimestamp(2, em.getFecha_hor());
            ps.setString(3, em.getDescripcion());
            ps.execute();
            con.close();
            return true;
        } catch (SQLException | Alerta ex) {
            Logger.getLogger(CrudBitacora.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
        
        
    }
         public String GetAll(String descrip){
     String all = null;
     Connection log;  
    DBConexion conecta = new DBConexion();
    try{
        log=conecta.Conectar();
        PreparedStatement pst;
        ResultSet rs;
        String sql="SELECT usuario.nombre as nombre, "
                + "bitacora.Usuario, "
                + "bitacora.Fecha_h "
                + "FROM usuario JOIN bitacora on usuario.cedula=bitacora.Usuario"
                + " WHERE bitacora.descr like '"+descrip+"' "
                + "GROUP BY bitacora.Usuario ;";
        pst = log.prepareStatement(sql);
        rs = pst.executeQuery(sql);
        if(rs.next()){
           SimpleDateFormat simdat=new SimpleDateFormat("dd/MM/yyyy"); 
           String fecha=simdat.format(rs.getDate("fecha_h"));
           all=rs.getString("nombre")+"-"+fecha;
           
        }else{
        all=" "+"-"+" ";
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
     return all;
     }
     public ObservableList<Bitacora>getDatosBita(){
        DBConexion conecta = new DBConexion();    
       Connection log;  
        ArrayList<Bitacora> Buffer = new ArrayList<>();
        Bitacora passe;
        ObservableList<Bitacora> Parcial;
        Statement sentencia;
        String oracion = "SELECT * FROM bitacora;";
        try {
            log=conecta.Conectar();
            sentencia = log.createStatement();
            ResultSet bloque = sentencia.executeQuery(oracion);
            while (bloque.next()) {
                   passe = new Bitacora();
                
                   passe.setIdbitacora(bloque.getInt("idBit"));
                   passe.setUsuario(bloque.getString("Usuario"));
                Timestamp timestamp = bloque.getTimestamp("Fecha_h");
                SimpleDateFormat simdat=new SimpleDateFormat("dd-MM-yyyy hh:mm a");
                
//                 passe.setFecha_hor(bloque.getTimestamp("fecha_hor"));
                   passe.setFechaformateada(simdat.format(timestamp));
                   passe.setDescripcion(bloque.getString("descr"));
                   
                   Buffer.add(passe);
               }
         sentencia.close();
         conecta.Desconectar();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudBitacora.class.getName()).log(Level.SEVERE, null, ex);
        }
            Parcial = FXCollections.observableList(Buffer);
        return Parcial;
}
     
     

    
}
