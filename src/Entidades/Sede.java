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
public class Sede {
    int id,activo;
    String Region,Codigo,Nombre,acti;

    public Sede(int id, int activo, String Region, String Codigo, String Nombre, String acti) {
        this.id = id;
        this.activo = activo;
        this.Region = Region;
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.acti = acti;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public String getActi() {
        return acti;
    }

    public void setActi(String acti) {
        this.acti = acti;
    }

    
    public Sede(){
        id=0;
        Region="";
        Codigo="";
        Nombre="";
        activo=0;
        acti="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
}
