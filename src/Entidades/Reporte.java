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
public class Reporte{
    int id_report, id_actividad, id_computador,id_sede,id_departamento;
    Date Fecha_i,Fecha_f;
    String Usuario,Texto,Actividad,Sede,Computador,departamento,depsed,fechai,fechaf;

    public Reporte(int id_report, int id_actividad, int id_computador, int id_sede, int id_departamento, Date Fecha_i, Date Fecha_f, String Usuario, String Texto, String Actividad, String Sede, String Computador, String departamento, String depsed, String fechai, String fechaf) {
        this.id_report = id_report;
        this.id_actividad = id_actividad;
        this.id_computador = id_computador;
        this.id_sede = id_sede;
        this.id_departamento = id_departamento;
        this.Fecha_i = Fecha_i;
        this.Fecha_f = Fecha_f;
        this.Usuario = Usuario;
        this.Texto = Texto;
        this.Actividad = Actividad;
        this.Sede = Sede;
        this.Computador = Computador;
        this.departamento = departamento;
        this.depsed = depsed;
        this.fechai = fechai;
        this.fechaf = fechaf;
    }

    
    public Reporte(){
        id_report = 0;
        id_actividad = 0;
        id_computador = 0;
        id_sede =0;
        id_departamento = 0;
        Fecha_i = null;
        Fecha_f = null;
        Usuario = "";
        Texto = "";
        Actividad = "";
        Sede = "";
        Computador = "";
        departamento = "";
        depsed = "";
        fechai="";
        fechaf="";
    }

    public String getFechai() {
        return fechai;
    }

    public void setFechai(String fechai) {
        this.fechai = fechai;
    }

    public String getFechaf() {
        return fechaf;
    }

    public void setFechaf(String fechaf) {
        this.fechaf = fechaf;
    }

    public int getId_sede() {
        return id_sede;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getDepsed() {
        return depsed;
    }

    public void setDepsed(String depsed) {
        this.depsed = depsed;
    }

    public String getActividad() {
        return Actividad;
    }

    public void setActividad(String Actividad) {
        this.Actividad = Actividad;
    }

    public String getSede() {
        return Sede;
    }

    public void setSede(String Sede) {
        this.Sede = Sede;
    }

    public String getComputador() {
        return Computador;
    }

    public void setComputador(String Computador) {
        this.Computador = Computador;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getId_report() {
        return id_report;
    }

    public void setId_report(int id_report) {
        this.id_report = id_report;
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public int getId_computador() {
        return id_computador;
    }

    public void setId_computador(int id_computador) {
        this.id_computador = id_computador;
    }

    public Date getFecha_i() {
        return Fecha_i;
    }

    public void setFecha_i(Date Fecha_i) {
        this.Fecha_i = Fecha_i;
    }

    public Date getFecha_f() {
        return Fecha_f;
    }

    public void setFecha_f(Date Fecha_f) {
        this.Fecha_f = Fecha_f;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        this.Texto = Texto;
    }
    
}
