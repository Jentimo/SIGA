/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import java.sql.Timestamp;

/**
 *
 * @author Windows Turbo (LTSB)
 */
public class Bitacora {
   private int idbitacora;
   private String Usuario;
   private Timestamp fecha_hor;
   private String descripcion,fechaformateada;

    public Bitacora() {
    }

    public Bitacora(String Usuario, Timestamp fecha_hor, String descripcion) {
   
        this.Usuario = Usuario;
        this.fecha_hor = fecha_hor;
        this.descripcion = descripcion;
    }

    public String getFechaformateada() {
        return fechaformateada;
    }

    public void setFechaformateada(String fechaformateada) {
        this.fechaformateada = fechaformateada;
    }
    
    

    public int getIdbitacora() {
        return idbitacora;
    }

    public void setIdbitacora(int idbitacora) {
        this.idbitacora = idbitacora;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public Timestamp getFecha_hor() {
        return fecha_hor;
    }

    public void setFecha_hor(Timestamp fecha_hor) {
        this.fecha_hor = fecha_hor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
   

}
