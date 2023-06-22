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
public class Actividades {
    private Integer id,activo;
    private String Nombre,acti;
    
    public Actividades(Integer id, Integer activo, String Nombre, String acti) {
        this.id = id;
        this.activo = activo;
        this.Nombre = Nombre;
        this.acti = acti;
    }
    
    public Actividades(){
        Nombre="";
        id=0;
        activo=0;
        acti="";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public String getActi() {
        return acti;
    }

    public void setActi(String acti) {
        this.acti = acti;
    }
    
}
