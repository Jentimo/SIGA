/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Otros.Alerta;

/**
 *
 * @author Usuario
 */
public class DBConexion {
    private final String Usuario ="root";
    private final String Contraseña = "";
     protected Connection linea = null;
    private static DBConexion conecto;
    private static String url;
    
    public DBConexion(){
        url = "jdbc:mariadb://localhost:3306/siga";
    }
    
    public static DBConexion getInstance(){
    if(conecto==null){
    conecto = new DBConexion();
    }
    return conecto;
    }
    
 public Connection Conectar() throws Alerta {
        try{
            linea = DriverManager.getConnection(url,Usuario,Contraseña); 
        }
        catch(SQLException ex){
            throw new Alerta(1);
        }
        return linea;
    }
   public void Desconectar() throws Alerta {
        if(linea != null){
            try {
                if(!linea.isClosed()){
                    linea.close();
                }
            } catch (SQLException ex) {
                throw new Alerta(3);
            }
        }
    }  
   
   } 
