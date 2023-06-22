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
public class Computador {
    int Id_compu;
    String nombre,depsed,SEDE,DEP;

    public Computador(int Id_compu, String nombre, String depsed, String SEDE, String DEP) {
        this.Id_compu = Id_compu;
        this.nombre = nombre;
        this.depsed = depsed;
        this.SEDE = SEDE;
        this.DEP = DEP;
    }

    public String getSEDE() {
        return SEDE;
    }

    public void setSEDE(String SEDE) {
        this.SEDE = SEDE;
    }

    public String getDEP() {
        return DEP;
    }

    public void setDEP(String DEP) {
        this.DEP = DEP;
    }
   

    public String getDepsed() {
        return depsed;
    }

    public void setDepsed(String depsed) {
        this.depsed = depsed;
    }
    
   
    public Computador(){
        Id_compu=0;
        nombre="";
        depsed="";
        SEDE="";
        DEP="";
    }

    public int getId_compu() {
        return Id_compu;
    }

    public void setId_compu(int Id_compu) {
        this.Id_compu = Id_compu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
