/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import utiles.Rut;

/**
 *
 * @author folke
 */
public class Asignatura extends Docente{
    private String codigo;
    private String nombreAsignatura;
    private String docente;
    private Jornada jornada;
    private String horario;
    private String sala;
    
    public Asignatura(){
        codigo = "";
        nombreAsignatura = "";
        docente = "";
        jornada = Jornada.Diurna;
        horario = "";
        sala = "";
    }
    
    public Asignatura(Rut rutDocente, String nombreDocente, String titulo, Area area, Grado gradoAcademico){
        super(rutDocente, nombreDocente, titulo, area, gradoAcademico);
        codigo = "";
        nombreAsignatura = "";
        docente = "";
        jornada = Jornada.Diurna;
        horario = "";
        sala = "";
    }
    
    public Asignatura(String codigo, String nombreAsignatura, String docente, Jornada jornada, String horario, String sala){
        this.codigo = codigo;
        this.nombreAsignatura = nombreAsignatura;
        this.docente = docente;
        this.jornada = jornada;
        this.horario = horario;
        this.sala = sala;
    }   
    
    public Asignatura(String codigo, String nombreAsignatura, String docente, String jornada, String horario, String sala){
        this.codigo = codigo;
        this.nombreAsignatura = nombreAsignatura;
        this.docente = docente;
        this.jornada = Jornada.valueOf(jornada);
        this.horario = horario;
        this.sala = sala;
    }
    
    public Asignatura(String asignatura){
        String[] datos = asignatura.split(",");
        this.codigo = datos[0];
        this.nombreAsignatura = datos[1];
        this.docente = datos[2];
        this.jornada = Jornada.valueOf(datos[3]);
        this.horario = datos[4];
        this.sala = datos[5];
    }
    
    public Asignatura(Asignatura a){
        this.codigo = a.codigo;
        this.nombreAsignatura = a.nombreAsignatura;
        this.docente = a.docente;
        this.jornada = a.jornada;
        this.horario = a.horario;
        this.sala = a.sala;
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(codigo);
        s.append(",");
        s.append(nombreAsignatura);
        s.append(",");
        s.append(docente);
        s.append(",");
        s.append(jornada.toString());
        s.append(",");
        s.append(horario);
        s.append(",");
        s.append(sala);
        return s .toString();
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public Jornada getJornada() {
        return jornada;
    }

    public void setJornada(Jornada jornada) {
        this.jornada = jornada;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
    
    
}
