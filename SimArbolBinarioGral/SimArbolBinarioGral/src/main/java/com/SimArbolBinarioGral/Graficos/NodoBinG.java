/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

/**
 *
 * @author usuario
 */
public class NodoBinG {
    
    private Circle c;
    private Label l;
    private int info;
    private NodoBinG izq;
    private NodoBinG der;

    /**
     *
     * @param info
     * @param c
     * @param l
     * @param izq
     * @param der
     */
    public NodoBinG(int info, Circle c, Label l, NodoBinG izq, NodoBinG der) {
        this.c = c;
        this.l = l;
        this.info = info;
        this.izq = izq;
        this.der = der;
    }

    /**
     *
     * @return
     */
    public Circle getC() {
        return c;
    }

    /**
     *
     * @param c
     */
    public void setC(Circle c) {
        this.c = c;
    }

    /**
     *
     * @return
     */
    public Label getL() {
        return l;
    }

    /**
     *
     * @param l
     */
    public void setL(Label l) {
        this.l = l;
    }

    /**
     *
     * @return
     */
    public int getInfo() {
        return info;
    }

    /**
     *
     * @param info
     */
    public void setInfo(int info) {
        this.info = info;
        this.l.setText(info+"");
    }

    /**
     *
     * @return
     */
    public NodoBinG getIzq() {
        return izq;
    }

    /**
     *
     * @param izq
     */
    public void setIzq(NodoBinG izq) {
        this.izq = izq;
    }

    /**
     *
     * @return
     */
    public NodoBinG getDer() {
        return der;
    }

    /**
     *
     * @param der
     */
    public void setDer(NodoBinG der) {
        this.der = der;
    }

    
    
    
    
}
