/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class Usuario {
    String Cedula,Nombre,Acti,Acceso,Fecha;
    int activo;
    Date ulti_acces;
    public Usuario(){
    Cedula="";
    Nombre="";
    Acti="";
    ulti_acces=null;
    Acceso="";
    Fecha="";
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public Usuario(String Cedula, String Nombre, String Acti, String Acceso, String Fecha, int activo, Date ulti_acces) {
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Acti = Acti;
        this.Acceso = Acceso;
        this.Fecha = Fecha;
        this.activo = activo;
        this.ulti_acces = ulti_acces;
    }

   

    public String getAcceso() {
        return Acceso;
    }

    public void setAcceso(String Acceso) {
        this.Acceso = Acceso;
    }
    
    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getActi() {
        return Acti;
    }

    public void setActi(String Acti) {
        this.Acti = Acti;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
        SetActivos();
    }

    public Date getUlti_acces() {
        return ulti_acces;
    }

    public void setUlti_acces(Date ulti_acces) {
        this.ulti_acces = ulti_acces;
    }
    private void SetActivos(){
    if(this.activo==0){
    this.Acti="NO";
    }
    if(this.activo==1){
    this.Acti="SI";
    }
    }
    
}
