/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

/**
 *
 * @author folke
 */
public class Nombre {
    private String nombres;
    private String paterno;
    private String materno;
    
    public Nombre(){
        this.nombres=null;
        this.paterno=null;
        this.materno=null;
    }
    public Nombre(String nombres, String paterno){
        this.nombres= nombres;
        this.paterno= paterno;
        this.materno= null;
    }
    
    public Nombre(String nombres, String paterno, String materno){
        this.nombres= nombres;
        this.paterno= paterno;
        this.materno= materno;
    }
    
    public Nombre(Nombre n){
        this.nombres= n.nombres ;
        this.paterno= n.paterno;
        this.materno= n.materno;
    }
    
    public void setNombres(String n){
        nombres= n;
    }
    
    public String getNombres(){
        return this.nombres;
    }
    
    public void setPaterno(String n){
        this.paterno= n;
    }
    
    public String getPaterno(){
        return paterno;
    }
    
    public void setMaterno(String materno){
        this.materno= materno;
    }
    public String getMaterno(){
        return materno;
    }
    
    public String toString(){
        String s=nombres + "," + paterno + "," + materno;
        return s;
    }
    
    public String toSave(String archivo){
        String s= nombres+","+paterno+","+materno;
        return s;
    }
    
    public boolean equals(Nombre nom){
        if (nombres.equals(nom.nombres)  && 
            paterno.equals(nom.paterno)  &&
            materno.equals(nom.materno)){
            return true;
        }
        return false;
    }
}
