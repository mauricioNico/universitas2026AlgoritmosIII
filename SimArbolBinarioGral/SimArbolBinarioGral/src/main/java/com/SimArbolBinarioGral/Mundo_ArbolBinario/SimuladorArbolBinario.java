/**
 * ---------------------------------------------------------------------
 * $Id: SimuladorArbolBinario.java,v 1.0 2013/08/23 
 * Universidad Francisco de Paula Santander 
 * Programa Ingenieria de Sistemas
 *
 * Proyecto: SEED_UFPS
 * ----------------------------------------------------------------------
 */

package Mundo_ArbolBinario;

import Colecciones_SEED.ArbolBinario;
import Graficos.ArbolBinarioG;
import java.util.Iterator;

/**
 * Clase que conecta la capa de presentación del Simulador con las Estructuras de Datos.
 * @author Uriel Garcia - Yulieth Pabon
 * @version 1.0
 */

public class SimuladorArbolBinario {
    
    private ArbolBinario miArbolBin;
    
    public SimuladorArbolBinario(){
        this.miArbolBin = new ArbolBinario();
    }
    
    public ArbolBinarioG crearArbolBinarioGrafico(ArbolBinarioG n) {
        n.crearArbol(this.miArbolBin.getRaiz());
        return (n);
    }

    public int conocerAltura() {
        return this.miArbolBin.getAltura();
    }

    public int insertarDato(int dato, int padre, int lado) {
        if(this.miArbolBin.esta(dato))
            return -1; //Dato repetido
        if(!this.estaVacioArbol() && !this.miArbolBin.esta(padre))
            return -4;
        boolean ins = lado==0?this.miArbolBin.insertarHijoIzq(padre, dato):this.miArbolBin.insertarHijoDer(padre, dato);
        if(ins){
            if(this.miArbolBin.getAltura()>5){
                this.miArbolBin.eliminar(dato);
                return -2; //Supera la altura 5
            }
            return 0; //Insercion correcta
        }
        return -3; //No se pudo insertar
    }

    public boolean estaVacioArbol() {
        return (this.miArbolBin.esVacio());
    }

    public boolean eliminarDato(int dato) {
        return (this.miArbolBin.eliminar(dato));
    }

    public boolean estaDatoenArbol(int dato) {
        return (this.miArbolBin.esta(dato));
    }

    public int conocerPeso() {
        return (this.miArbolBin.getPeso());
    }

    public int contarHojas() {
        return (this.miArbolBin.contarHojas());
    }

    public String obtenerHojas() {
        Iterator<Integer> it = this.miArbolBin.getHojas();
        String cad = "";
        while(it.hasNext()){
            cad+= it.next().toString();
            if(it.hasNext())
                cad+=", ";
            else
                cad+=".";
        }        
        return (cad);
    }

    public void podarHojas() {
        this.miArbolBin.podar();
    }

    public String recorridoPreorden() {
        Iterator<Integer> it = this.miArbolBin.preOrden();
        String cad = "";
        int i=0;
        while(it.hasNext()){
            cad+= it.next().toString();
            if(it.hasNext())
                cad+=", ";
            else
                cad+=".";
            if(i==15){
                cad+="\n";
            }
            i++;
        }        
        return (cad);
    }
    
    public String recorridoInorden() {
        Iterator<Integer> it = this.miArbolBin.inOrden();
        String cad = "";
        int i=0;
        while(it.hasNext()){
            cad+= it.next().toString();
            if(it.hasNext())
                cad+=", ";
            else
                cad+=".";
            if(i==15){
                cad+="\n";
            }
            i++;
        }        
        return (cad);
    }
    
    public String recorridoPostorden() {
        Iterator<Integer> it = this.miArbolBin.postOrden();
        String cad = "";
        int i=0;
        while(it.hasNext()){
            cad+= it.next().toString();
            if(it.hasNext())
                cad+=", ";
            else
                cad+=".";
            if(i==15){
                cad+="\n";
            }
            i++;
        }        
        return (cad);
    }
    
    public String recorridoPorNiveles() {
        Iterator<Integer> it = this.miArbolBin.impNiveles();
        String cad = "";
        int i=0;
        while(it.hasNext()){
            cad+= it.next().toString();
            if(it.hasNext())
                cad+=", ";
            else
                cad+=".";
            if(i==15){
                cad+="\n";
            }
            i++;
        }        
        return (cad);
    }
    
}
