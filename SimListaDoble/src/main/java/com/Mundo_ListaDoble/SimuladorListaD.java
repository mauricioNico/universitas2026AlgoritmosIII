/**
 * ---------------------------------------------------------------------
 * $Id: SimuladorListaD.java,v 1.0 2013/08/23 
 * Universidad Francisco de Paula Santander 
 * Programa Ingenieria de Sistemas
 *
 * Proyecto: SEED_UFPS
 * ----------------------------------------------------------------------
 */

package Mundo_ListaDoble;

import Colecciones_SEED.ListaD;

/**
 * Clase que conecta la capa de presentación del Simulador con las Estructuras de Datos.
 * @author Uriel Garcia - Yulieth Pabon
 * @version 1.0
 */

public class SimuladorListaD {
    
    private ListaD<Integer> miLista;
    
    
    public SimuladorListaD(){
        this.miLista = new ListaD<Integer>();
    }
    
    public Object[] pasarAVector(){
        return (this.miLista.aVector());
    }
    
    public boolean insertarAlInicio(int dato){        
        if(this.miLista.esta(dato))
            return (false);
        this.miLista.insertarAlInicio(dato);
        return (true);
    }
    
    public boolean insertarAlFinal(int dato){
        if(this.miLista.esta(dato))
            return (false);
        this.miLista.insertarAlFinal(dato);
        return (true);
    }
    
    public boolean insertarOrdenado(int dato){
        if(this.miLista.esta(dato))
            return (false);
        this.miLista.insertarOrdenado(dato);
        return (true);
    }
    
    public boolean estaVaciaLista(){
        return (this.miLista.esVacia());
    }
    
    public int eliminarDato(int dato){
        int pos = this.miLista.getIndice(dato);
        if(pos==-1)
            return (pos);
        return ((int) this.miLista.eliminar(pos));
    }
    
    public void vaciarLista(){
        this.miLista.vaciar();
    }
    
    
    public boolean cambiarDato(int pos, int dato){
        if(this.miLista.esta(dato))
            return (false);
        this.miLista.set(pos, dato);
        return (true);
    }
    
    public int conocerTamanio(){
        return (this.miLista.getTamanio());
    }

    public int obtenerIndice(int dato) {
        return (this.miLista.getIndice(dato));
    }
}
