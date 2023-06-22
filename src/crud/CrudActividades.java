/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;
import Otros.Alerta;
import Otros.Error;
import BD.DBConexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Timaure
 */
public class CrudActividades {
    
    public void Insert(int id_compu,Date Fecha,String Descrip,
            String Cedula,int Actividad) throws SQLException{
    DBConexion conecta= new DBConexion();
    Connection log;
    String sql="Insert into servicio(id_compu,Fecha_H,descrip,id_Usuario,id_actividad) values (?,?,?,?,?);";
        try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.setInt(1, id_compu);
            sentencia.setDate(2, Fecha);
            sentencia.setString(3, Descrip);
            sentencia.setString(4,Cedula);
            sentencia.setInt(5,Actividad);
            sentencia.executeUpdate();
            sentencia.close();
            conecta.Desconectar();
        } catch (Alerta ex) {
            Logger.getLogger(CrudActividades.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }

    public void Update(int id_report,int id_compu,Date Fecha,String Descrip,
            String Cedula,int Actividad){
         DBConexion conecta= new DBConexion();
            Connection log;
            String sql="Update servicio set values id_compu='"+id_compu+", Fecha_H='"+Fecha+"'"
                    + "descrip='"+Descrip+"', id_Usuario='"+Cedula+"'"
                    + "id_actividad='"+Actividad+"' where id_report='"+id_report+"';";
        try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.executeUpdate();
            sentencia.close();
            conecta.Desconectar();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Delete(int id_report){
            DBConexion conecta= new DBConexion();
            Connection log;
            String sql="Delete from servicio where id_report='"+id_report+"';";
            try {
            log=conecta.Conectar();
            PreparedStatement sentencia;
            sentencia=log.prepareStatement(sql);
            sentencia.executeUpdate();
            sentencia.close();
            conecta.Desconectar();
        } catch (Alerta | SQLException ex) {
            Logger.getLogger(CrudActividades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
