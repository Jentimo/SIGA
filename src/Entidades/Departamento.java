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
public class Departamento {
    String Nombre,acti;
    int id,activo;

    public Departamento(String Nombre, String acti, int id, int activo) {
        this.Nombre = Nombre;
        this.acti = acti;
        this.id = id;
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

    
    public Departamento(){
        Nombre="";
        id=0;
        activo=0;
        acti="";
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
