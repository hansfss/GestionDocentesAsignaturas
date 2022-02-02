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
public class Rut {
     private int numero;
    private char dVerificador;
    

    public Rut(){
        this.numero=0;
        dVerificador='0';
    }
    
    public Rut(int r){
        numero= r;
        this.dVerificador= calcularDV();
    }
    
    public Rut(String r){
        String []datos;
        datos= r.split("-");  //error  si datos.length==0
        if (datos.length==0){
            //Error
            numero=0;
            this.dVerificador='0';
        }
        else{
            try{
                numero=Integer.parseInt(datos[0]);
                this.dVerificador= Character.toUpperCase(datos[1].charAt(0));
            }
            catch (NumberFormatException e){
                numero=0;
                this.dVerificador='0';
            }
        }
        
        if (!esValido()){
            numero=0;
            this.dVerificador='0';
        }      
    }
    
    
    public Rut(Rut r){
        this.numero=r.numero;
        this.dVerificador= r.dVerificador;
    }
    
    public boolean esValido(){
        return this.dVerificador== calcularDV();
    }
    
    public char calcularDV(){
        int num= numero; 
        int factor= 2;
        int suma=0;
        int digito;
        
        while (num>0){
            digito= num % 10;
            suma= suma + digito*factor;
            factor++;
            if (factor >7){
                factor=2;
            }
            num = num / 10;
        }
        int dv= 11 - suma % 11;
        
        char cDV;
        
        switch (dv){
            case 11: 
                cDV='0';
                break;
            case 10:
                cDV='K';
                break;
            default:    
                cDV= (char) (48 + dv);
        }
        return cDV;
    }
    
    public String toString(){
        return numero+"-"+dVerificador;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Rut && ((Rut)obj).numero==numero){
            return true;
        }
        return false;
    }
}
