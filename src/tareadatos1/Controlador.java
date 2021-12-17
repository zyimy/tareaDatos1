/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareadatos1;

import java.util.ArrayList;

/**
 *
 * @author zepeda
 */
public class Controlador<T> {
    
       private ArrayList<T>lista;
    
    public Controlador(){
        this.lista = new ArrayList<T>();
    }
    
    public void addLista(T t){
        this.lista.add(t);
    }
    
    public ArrayList<T> mostrarLista(){
        return this.lista;
    }
    
    public void setLista(ArrayList<T> listas){
        this.lista = listas;
    }

    @Override
    public String toString() {
        return "Controlador{" + "lista=" + lista + '}';
    }
    
    
}
