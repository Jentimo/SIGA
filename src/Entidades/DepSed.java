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
public class DepSed {
    String Codigo,NombreS,NombreD,acti;
    int idS,IdD,activo;

    public DepSed(String Codigo, String NombreS, String NombreD, String acti, int idS, int IdD, int activo) {
        this.Codigo = Codigo;
        this.NombreS = NombreS;
        this.NombreD = NombreD;
        this.acti = acti;
        this.idS = idS;
        this.IdD = IdD;
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

    
    public DepSed(){
        Codigo="";
        NombreS="";
        NombreD="";
        idS=0;
        IdD=0;
        activo=0;
        acti="";
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombreS() {
        return NombreS;
    }

    public void setNombreS(String NombreS) {
        this.NombreS = NombreS;
    }

    public String getNombreD() {
        return NombreD;
    }

    public void setNombreD(String NombreD) {
        this.NombreD = NombreD;
    }

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public int getIdD() {
        return IdD;
    }

    public void setIdD(int IdD) {
        this.IdD = IdD;
    }
    public String Codigo(){
        String codigoS=this.getNombreS();
        String codigoD=this.getNombreD();
        String parts[]=codigoS.split(" ");
        String Aux="";
        String Aux2="";
        String Aux3="";
        String Aux4="";
        int x=parts.length;
        for(int y=0;y<x;y++){
            Aux=""+parts[y].charAt(0);
            Aux3=Aux3+Aux;
        }
        if(codigoD.contains(" ")){
            String partes[]=codigoD.split(" ");
            int y=partes.length;
            for(int w=0;w<y;w++){
                Aux2=""+partes[w].charAt(0);
                Aux4=Aux4+Aux2;
            }
        }else{
            Aux4=""+codigoD.charAt(0)+codigoD.charAt(1)+codigoD.charAt(2);
        }
        Aux3=Aux3+Aux4;
        return Aux3.toUpperCase();
    }
}
