/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import utiles.Nombre;
import utiles.Rut;

/**
 *
 * @author folkesson
 */
public class Docente {
    private Rut rutDocente;
    private String nombreDocente;
    private String titulo;
    private Area area;
    private Grado gradoAcademico;
    
    public Docente(){
        rutDocente = new Rut();
        nombreDocente = "";
        titulo = "";
        area = Area.Programacion;
        gradoAcademico = null;
    }
    
    public Docente(Rut rutDocente, String nombreDocente, String titulo, Area area, Grado gradoAcademico){
        this.rutDocente = new Rut(rutDocente);
        this.nombreDocente = nombreDocente;
        this.titulo = "licenciatura";
        this.area = area;
        this.gradoAcademico = gradoAcademico;
    }
    
    public Docente(Rut rutDocente, String nombreDocente, String titulo, String area, String gradoAcademico){
        this.rutDocente = new Rut(rutDocente);
        this.nombreDocente = nombreDocente;
        this.titulo = titulo;
        this.area = Area.valueOf(area);
        this.gradoAcademico = Grado.valueOf(gradoAcademico);
    }
    
    public Docente(String rutDocente, String nombreDocente, String titulo, String area, String gradoAcademico){
        this.rutDocente = new Rut(rutDocente);
        this.nombreDocente = nombreDocente;
        this.titulo = titulo;
        this.area = Area.valueOf(area);
        this.gradoAcademico = Grado.valueOf(gradoAcademico);
    }
    
    public Docente(String docentes){
        String[] datos = docentes.split(",");
        this.rutDocente = new Rut(datos[0]);
        this.nombreDocente = datos[1];
        this.titulo = datos[2];
        this.area = Area.valueOf(datos[3]);
        this.gradoAcademico = Grado.valueOf(datos[4]);
    }
    
    public Docente(Docente d){
        this.rutDocente = d.rutDocente;
        this.nombreDocente = d.nombreDocente;
        this.titulo = d.titulo;
        this.area = d.area;
        this.gradoAcademico = d.gradoAcademico;
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(rutDocente.toString());
        s.append(",");
        s.append(nombreDocente);
        s.append(",");
        s.append(titulo);
        s.append(",");
        s.append(area.toString());
        s.append(",");
        s.append(gradoAcademico.toString());
        return s.toString();
    }
    
    public boolean toSave(String archivo){
        boolean estaOk = false;
        try{
            FileWriter f = new FileWriter(archivo, true);
            PrintWriter p = new PrintWriter(f);
            p.println(this.toString());
            p.close();
            f.close();
            estaOk = true;
        }
        catch(IOException ex){
            estaOk = false;
        }
        
        
        return estaOk;
    }

    public Rut getRutDocente() {
        return rutDocente;
    }

    public void setRutDocente(Rut rutDocente) {
        this.rutDocente = rutDocente;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Grado getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(Grado gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }
    
    
}
