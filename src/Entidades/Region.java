/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Usuario
 */
public class Region {
    String Nombre,Codigo,acti;
    int activo;

    public Region(String Nombre, String Codigo, String acti, int activo) {
        this.Nombre = Nombre;
        this.Codigo = Codigo;
        this.acti = acti;
        this.activo = activo;
    }

    public String getActi() {
        return acti;
    }

    public void setActi(String acti) {
        this.acti = acti;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

  
    public Region(){
        Nombre="";
        Codigo="";
        acti="";
        activo=0;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }
    
    
}
