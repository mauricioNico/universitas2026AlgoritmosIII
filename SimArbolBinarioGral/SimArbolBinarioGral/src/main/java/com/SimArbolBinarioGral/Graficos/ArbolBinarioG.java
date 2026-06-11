/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import Colecciones_SEED.Cola;
import Colecciones_SEED.ListaCD;
import Colecciones_SEED.NodoBin;
import Colecciones_SEED.Pila;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;
/**
 *
 * @author usuario
 */
public class ArbolBinarioG {
    
    private NodoBinG raiz;
    private Pila<Circle> pila;
    private Pila<Label> lab;
    private Pila<Line> lin;

    /**
     *
     */
    public ArbolBinarioG() {
        this.raiz = null;
        pila = new Pila();
        lab = new Pila();
        lin = new Pila();
    }

    /**
     *
     * @return
     */
    public NodoBinG getRaiz() {
        return raiz;
    }

    /**
     *
     * @return
     */
    public Pila<Circle> getPila() {
        return pila;
    }

    /**
     *
     * @param pila
     */
    public void setPila(Pila<Circle> pila) {
        this.pila = pila;
    }

    /**
     *
     * @return
     */
    public Pila<Label> getLab() {
        return lab;
    }

    /**
     *
     * @param lab
     */
    public void setLab(Pila<Label> lab) {
        this.lab = lab;
    }

    /**
     *
     * @return
     */
    public Pila<Line> getLin() {
        return lin;
    }

    /**
     *
     * @param lin
     */
    public void setLin(Pila<Line> lin) {
        this.lin = lin;
    }

    /**
     *
     * @param raiz
     */
    public void setRaiz(NodoBinG raiz){
        this.raiz = raiz;
    }

    /**
     *
     * @param raiz
     */
    public void crearArbol(NodoBin raiz) {
        this.setRaiz(crear(raiz));        
    }
    
    private NodoBinG crear(NodoBin r) {
        if(r==null)
            return (null);
        else
        {
            NodoBinG aux=new NodoBinG((int) r.getInfo(), this.pila.desapilar(), this.lab.desapilar(), crear(r.getIzq()), crear(r.getDer()));
            return (aux);
        }
    }

    /**
     *
     * @param nodos
     */
    public void cargarNodos(Circle[] nodos) {
        for(int i=0; i<nodos.length; i++)
            this.pila.apilar(nodos[i]);
    }

    /**
     *
     * @param labels
     */
    public void cargarLabels(Label[] labels) {
        for(int i=0; i<labels.length; i++)
            this.lab.apilar(labels[i]);
    }

    /**
     *
     * @param lineas
     */
    public void cargarLineas(Line[] lineas) {
        for(int i=0; i<lineas.length; i++)
            this.lin.apilar(lineas[i]);
    }

    /**
     *
     * @param alt
     */
    public void pintarArbol(int alt){
        if(this.raiz==null){
            Circle c = this.pila.desapilar();
            Label l = this.lab.desapilar();   
            c.setLayoutX(512.0);
            c.setLayoutY(195.0);
            l.setLayoutX(501.0);
            l.setLayoutY(189.0);
            c.setFill(Color.GRAY);
            c.setStroke(Color.BLACK);
            l.setText("Null");            
            c.setVisible(true);
            l.setVisible(true);
            return;
        }
        int ajuste = 0;
        switch(alt){
            case 0: ajuste = 0; break;
            case 1: ajuste = 1; break;
            case 2: ajuste = 2; break;
            case 3: ajuste = 4; break;
            case 4: ajuste = 8; break;
            case 5: ajuste = 16;break;
            case 6: ajuste = 32;break;
            case 7: ajuste = 64;break;
        }
        this.pinta(raiz,null,ajuste);
        this.reajustarColores();
    }

    private void pinta(NodoBinG r, NodoBinG padre, int ajuste) {        
        Line l;        
        ajuste = ajuste/2;
        if(r==null){
            return;
        }        
        r.getC().setVisible(true);
        r.getL().setText(r.getInfo()+"");
        r.getL().setVisible(true);        
        if(padre==null){
            r.getC().setLayoutX(512.0);
            r.getC().setLayoutY(195.0);
            r.getL().setLayoutX(501.0);
            r.getL().setLayoutY(189.0);
            r.getC().setVisible(true);
            r.getL().setText(r.getInfo()+"");
            r.getL().setVisible(true);
        }
        if(r.getIzq()!=null){
            r.getIzq().getC().setLayoutX(r.getC().getLayoutX()-(15*ajuste));
            r.getIzq().getC().setLayoutY(r.getC().getLayoutY()+50.0);
            r.getIzq().getL().setLayoutX(r.getL().getLayoutX()-(15*ajuste));
            r.getIzq().getL().setLayoutY(r.getL().getLayoutY()+50.0);
            r.getIzq().getC().setVisible(true);
            r.getIzq().getL().setText(r.getInfo()+"");
            r.getIzq().getL().setVisible(true);            
            l = lin.desapilar();            
            l.setLayoutX(r.getC().getLayoutX());
            l.setLayoutY(r.getC().getLayoutY());
            l.setStartX(0.0);
            l.setEndX(-(15*ajuste));
            l.setStartY(0.0);
            l.setEndY(50.0);
            l.setVisible(true);
            
        }
        if(r.getDer()!=null){
            r.getDer().getC().setLayoutX(r.getC().getLayoutX()+(15*ajuste));
            r.getDer().getC().setLayoutY(r.getC().getLayoutY()+50.0);
            r.getDer().getL().setLayoutX(r.getL().getLayoutX()+(15*ajuste));
            r.getDer().getL().setLayoutY(r.getL().getLayoutY()+50.0);
            r.getDer().getC().setVisible(true);
            r.getDer().getL().setText(r.getInfo()+"");
            r.getDer().getL().setVisible(true);
            l = this.lin.desapilar();                        
            l.setLayoutX(r.getC().getLayoutX());
            l.setLayoutY(r.getC().getLayoutY());
            l.setStartX(0.0);
            l.setEndX((15*ajuste));
            l.setStartY(0.0);
            l.setEndY(50.0);
            l.setVisible(true);            
        }
        pinta(r.getIzq(),r,ajuste);
        pinta(r.getDer(),r,ajuste);
    }

    /**
     *
     * @param i 
     * @param dato
     * @param tl  
     */
    public void animacion(int i, int dato, Timeline tl) {
        this.reajustarColores();
        tl = new Timeline();
        tl.setCycleCount(1);
        tl.getKeyFrames().removeAll();
        switch(i){
            //Insertar 0
            case 0:
                this.pintarInsertado(dato, tl);
                break;
            //Eliminar 1
            case 1:
                this.pintarEliminado(dato, tl);
                break;
            //Buscar 2
            case 2:
                this.buscarG(dato, tl);
                break;
            //Hojas 3
            case 3:
                this.getHojas();
                break;
            //Podar 4
            case 4:
                this.getHojas();
                break;
            // preorden 5
            case 5:
                this.preOrden(tl);
                break;
            // inorden 6
            case 6:
                this.inOrden(tl);
                break;
            //postorden 7
            case 7:
                this.postOrden(tl);
                break;
            //niveles 8
            case 8:
                this.impNiveles(tl);
                break;
        }
    }
    
    /**
     *
     * @param dato
     * @param tl
     */
    public void pintarInsertado(int dato, Timeline tl){
        double durac = 0;
        NodoBinG n = this.buscar(this.raiz, dato);
        if(n!=null){
            tl.getKeyFrames().setAll(
            new KeyFrame(new Duration(durac), new KeyValue(n.getC().strokeProperty(),Color.GREEN)),
            new KeyFrame(new Duration((durac+1000)), new KeyValue(n.getC().strokeProperty(),Color.RED)),
            new KeyFrame(new Duration(durac), new KeyValue(n.getC().fillProperty(),Color.GREENYELLOW)),
            new KeyFrame(new Duration((durac+1000)), new KeyValue(n.getC().fillProperty(),Color.BEIGE)));
            tl.play();
        }
    }
    
    private NodoBinG buscar(NodoBinG r, int x){
        if (r==null)
            return (null);
        if(r.getInfo()==x)
            return (r);
        else
        {
            NodoBinG aux=(r.getIzq()==null)?null:buscar(r.getIzq(),x);
            if(aux!=null)
                return (aux);
            else
                return (r.getDer()==null)?null:buscar(r.getDer(),x);
        }
    }
    
    /**
     *
     * @param x
     * @param tl
     * @return
     */
    public boolean buscarG(int x, Timeline tl){
        ListaCD<NodoBinG> l=new ListaCD<NodoBinG>();
        boolean rta = this.buscarG(raiz, x, l);
        int durac = 0;
        for(int i=0; i<l.getTamanio(); i++){
            NodoBinG n = l.get(i);
            tl.getKeyFrames().addAll(new KeyFrame(new Duration(durac), new KeyValue(n.getC().strokeProperty(),Color.GREEN)),
            new KeyFrame(new Duration((durac+1000)), new KeyValue(n.getC().strokeProperty(),Color.RED)));
            tl.getKeyFrames().addAll(new KeyFrame(new Duration(durac), new KeyValue(n.getC().fillProperty(),Color.GREENYELLOW)),
            new KeyFrame(new Duration((durac+1000)), new KeyValue(n.getC().fillProperty(),Color.BEIGE)));
            durac+=1000;
        }
        tl.play();
        return (rta);
    }
    
    private boolean buscarG(NodoBinG r, int x, ListaCD<NodoBinG> l){
        if (r==null)
            return (false);
        l.insertarAlFinal(r);
        if(r.getInfo()==x)
            return (true);
        else
        {
            boolean tmp = (r.getIzq()==null)?false:buscarG(r.getIzq(),x,l);
            if(tmp)
                return (true);
            else
                return (r.getDer()==null)?false:buscarG(r.getDer(),x,l);
        }
    }
    
    /**
     *
     */
    public void getHojas(){
        getHojas(raiz);
    }
    
    private void getHojas(NodoBinG r){
        if (r!=null){
            if(this.esHoja(r)){
                r.getC().setFill(Color.BEIGE);
                r.getC().setStroke(Color.RED);
            }
            getHojas(r.getIzq());
            getHojas(r.getDer());
        }
    }
    
    private boolean esHoja(NodoBinG x){
        return (x!=null && x.getIzq()==null && x.getDer()==null);
    }
    
    /**
     *
     * @param tl
     */
    public void preOrden(Timeline tl){
        int durac =0;
        ListaCD<NodoBinG> l=new ListaCD<NodoBinG>();
         preOrden(this.getRaiz(),l);
        for(int i=0; i<l.getTamanio(); i++){
            NodoBinG n = l.get(i);
            tl.getKeyFrames().addAll(new KeyFrame(new Duration(durac), new KeyValue(n.getC().strokeProperty(),Color.GREEN)),
            new KeyFrame(new Duration((durac+1000)), new KeyValue(n.getC().strokeProperty(),Color.RED)));
            tl.getKeyFrames().addAll(new KeyFrame(new Duration(durac), new KeyValue(n.getC().fillProperty(),Color.GREENYELLOW)),
            new KeyFrame(new Duration((durac+1000)), new KeyValue(n.getC().fillProperty(),Color.BEIGE)));
            durac+=1000;
        }
        tl.play();
    }

    private void  preOrden(NodoBinG r, ListaCD<NodoBinG> l){
        if(r!=null){
            l.insertarAlFinal(r);
            preOrden(r.getIzq(), l);
            preOrden(r.getDer(), l);
        }
    }
    
    /**
     *
     * @param tl
     */
    public void inOrden(Timeline tl){
        int durac =0;
        ListaCD<NodoBinG> l=new ListaCD<NodoBinG>();
         inOrden(this.getRaiz(),l);
        for(int i=0; i<l.getTamanio(); i++){
            NodoBinG n = l.get(i);
            tl.getKeyFrames().addAll(new KeyFrame(new Duration(durac), new KeyValue(n.getC().strokeProperty(),Color.GREEN)),
            new KeyFrame(new Duration((durac+1000)), new KeyValue(n.getC().strokeProperty(),Color.RED)));
            tl.getKeyFrames().addAll(new KeyFrame(new Duration(durac), new KeyValue(n.getC().fillProperty(),Color.GREENYELLOW)),
            new KeyFrame(new Duration((durac+1000)), new KeyValue(n.getC().fillProperty(),Color.BEIGE)));
            durac+=1000;
        }
        tl.play();
    }

    private void  inOrden(NodoBinG r, ListaCD<NodoBinG> l){
        if(r!=null){
            inOrden(r.getIzq(), l);
            l.insertarAlFinal(r);
            inOrden(r.getDer(), l);
        }
    }

   
    /**
     *
     * @param tl
     */
    public void postOrden(Timeline tl){
        int durac =0;
        ListaCD<NodoBinG> l=new ListaCD<NodoBinG>();
         postOrden(this.getRaiz(),l);
        for(int i=0; i<l.getTamanio(); i++){
            NodoBinG n = l.get(i);
            tl.getKeyFrames().addAll(new KeyFrame(new Duration(durac), new KeyValue(n.getC().strokeProperty(),Color.GREEN)),
            new KeyFrame(new Duration((durac+1000)), new KeyValue(n.getC().strokeProperty(),Color.RED)));
            tl.getKeyFrames().addAll(new KeyFrame(new Duration(durac), new KeyValue(n.getC().fillProperty(),Color.GREENYELLOW)),
            new KeyFrame(new Duration((durac+1000)), new KeyValue(n.getC().fillProperty(),Color.BEIGE)));
            durac+=1000;
        }
        tl.play();
    }
    
    private void postOrden(NodoBinG r, ListaCD<NodoBinG> l){
        if(r!=null){
            postOrden(r.getIzq(), l);
            postOrden(r.getDer(), l);
            l.insertarAlFinal(r);
        }
    }
    
    /**
     *
     * @param tl
     */
    public void impNiveles(Timeline tl){
        int durac =0;
        ListaCD<NodoBinG> l=new ListaCD<NodoBinG>();
        this.impNiveles(l);
        for(int i=0; i<l.getTamanio(); i++){
            NodoBinG n = l.get(i);
            tl.getKeyFrames().addAll(new KeyFrame(new Duration(durac), new KeyValue(n.getC().strokeProperty(),Color.GREEN)),
            new KeyFrame(new Duration((durac+1000)), new KeyValue(n.getC().strokeProperty(),Color.RED)));
            tl.getKeyFrames().addAll(new KeyFrame(new Duration(durac), new KeyValue(n.getC().fillProperty(),Color.GREENYELLOW)),
            new KeyFrame(new Duration((durac+1000)), new KeyValue(n.getC().fillProperty(),Color.BEIGE)));
            durac+=1000;
        }
        tl.play();
    }
    
    
    private void impNiveles(ListaCD<NodoBinG> l){        
        if(!this.esVacio()){
            Cola<NodoBinG> c=new Cola<>();
            c.enColar(this.getRaiz());
            NodoBinG x;
                while(!c.esVacia()){
                    x=c.deColar();
                    l.insertarAlFinal(x);
                    if(x.getIzq()!=null)
                    c.enColar(x.getIzq());
                    if(x.getDer()!=null)
                    c.enColar(x.getDer());
                }
        }
    }

    /**
     *
     * @return
     */
    public boolean esVacio(){
        return(this.raiz==null);
    }
    
        
    /**
     *
     */
    public void reajustarColores(){
        this.reajustarColores(raiz);
    }
    
    private void reajustarColores(NodoBinG r){
        if(r==null){
            return;
        }
        r.getC().setFill(Color.GREENYELLOW);
        r.getC().setStroke(Color.GREEN);
        reajustarColores(r.getIzq());
        reajustarColores(r.getDer());
    }

    
    /**
     *
     */
    public void invisibles(){
       this.invisibles(raiz);
   }

    private void invisibles(NodoBinG r) {
        if(r==null){
            return;
        }
        r.getC().setFill(Color.GREENYELLOW);  
        r.getC().setStroke(Color.GREEN);
        r.getC().setVisible(false);
        r.getL().setVisible(false); 
        invisibles(r.getIzq());
        invisibles(r.getDer());
    }

    private void pintarEliminado(int dato, Timeline tl) {        
    }

    /**
     *
     * @param dato
     * @return
     */
    public String getLayoutsEliminar(int dato) {
        NodoBinG n = this.buscar(raiz, dato);
        double lx1=0, lx2=0, lx3=0, lx4=0;
        if(n!=null){            
            lx1 = n.getC().getLayoutX();
            lx2 = n.getC().getLayoutY();
            lx3 = n.getL().getLayoutX();
            lx4 = n.getL().getLayoutY();
        }        
        return (lx1+"_"+lx2+"_"+lx3+"_"+lx4);
    }

    /**
     *
     * @param layouts
     * @param dato
     * @param tl
     * @param c
     * @param l
     */
    public void animacionEliminar(String layouts, int dato, Timeline tl, Circle c, Label l) {
        tl = new Timeline();
        tl.setCycleCount(1);
        tl.getKeyFrames().removeAll();
        String v[] = layouts.split("_");
        c.setLayoutX(Double.parseDouble(v[0]));
        c.setLayoutY(Double.parseDouble(v[1]));
        l.setLayoutX(Double.parseDouble(v[2]));
        l.setLayoutY(Double.parseDouble(v[3]));
        l.setText(dato+"");
        c.setVisible(true);
        l.setVisible(true);
        
        tl.getKeyFrames().addAll(new KeyFrame(new Duration(0), new KeyValue(c.strokeProperty(),Color.GREEN)),
        new KeyFrame(new Duration(2000), new KeyValue(c.strokeProperty(),Color.RED)));
        tl.getKeyFrames().addAll(new KeyFrame(new Duration(0), new KeyValue(c.fillProperty(),Color.GREENYELLOW)),
        new KeyFrame(new Duration(2000), new KeyValue(c.fillProperty(),Color.BEIGE)));            
        tl.getKeyFrames().addAll(new KeyFrame(new Duration(0), new KeyValue(c.translateYProperty(),0)),
        new KeyFrame(new Duration(3000), new KeyValue(c.translateYProperty(),400-c.getLayoutY())));            
        tl.getKeyFrames().addAll(new KeyFrame(new Duration(0), new KeyValue(l.translateYProperty(),0)),
        new KeyFrame(new Duration(3000), new KeyValue(l.translateYProperty(),394-l.getLayoutY())));            
        tl.getKeyFrames().addAll(new KeyFrame(new Duration(2000), new KeyValue(c.visibleProperty(),true)),
        new KeyFrame(new Duration(3000), new KeyValue(c.visibleProperty(),false)));            
        tl.getKeyFrames().addAll(new KeyFrame(new Duration(2000), new KeyValue(l.visibleProperty(),true)),
        new KeyFrame(new Duration(3000), new KeyValue(l.visibleProperty(),false)));                  
        
        tl.play();
    }
    
}
