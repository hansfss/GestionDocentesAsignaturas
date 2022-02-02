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
public class Lista<T> {
    private Nodo<T> lista;
    
    public Lista(){
        lista = null;  
    }
    
    public boolean add(T e){
        Nodo<T> p;
        p = new Nodo(e);
        p.setLink(lista);
        lista = p;
        return true;
    }
    
    public boolean addLast(T e){
        Nodo<T> p, q, t;
        p = new Nodo(e);
        
        if (lista == null){
            lista = p;
        }
        else{
            t = lista;
            q = t;
            while(t != null){
                q = t;
                t = t.getLink();
            }
            q.setLink(p);
        }
        return true;    
    }
    
    public boolean remove(T e){
        boolean encontrado = false;
        Nodo<T> q, t;
        t = lista;
        q = t;    
    
        while (t != null && !encontrado){
            if (t.getInfo().equals(e) && q == t){ 
                encontrado = true;
                lista = q.getLink();
                t = null;
            }    
            else if (t.getInfo().equals(e)){
                encontrado = true;
                q.setLink(t.getLink());
                t = null;
            }
            else{
                q = t;
                t = t.getLink();
            }
        }
        return encontrado;
    }
    
    public void removeAll(T e){
        Nodo<T> q, t;
        t = lista;
        q = t;    
        int i = 0;
        
        while (t != null){
            if (t.getInfo().equals(e) && q == t){
                lista = q.getLink();
                t = lista;
                i++;
            }
            else if (t.getInfo().equals(e)){
                q.setLink(t.getLink());
                t = q;
                i++;
            }
            else{
                q = t;
                t = t.getLink();
            }
        }
        System.out.println(i);
    }
    
    public String toString(){
        StringBuilder s = new StringBuilder();
        Nodo<T> p;
        p = lista;
        while (p != null){
            s.append(p.toString());
            p = p.getLink();
        }
        
        return s.toString();
    }
}
