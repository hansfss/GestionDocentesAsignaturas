/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaGenericaLLS;

/**
 *
 * @author folke
 */
public class Nodo<T> {
    private T info;
    private Nodo<T> link;
    
    public Nodo(){
        info = null;
        link = null;
    }
    public Nodo(T e){
        info = e;
        link = null;
    }
    public Nodo(Nodo<T> nodo){
        this.info = nodo.info;
        this.link = nodo.link;
    }
    public String toString(){
        return info.toString() + "->";
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo<T> getLink() {
        return link;
    }

    public void setLink(Nodo<T> link) {
        this.link = link;
    }
}
