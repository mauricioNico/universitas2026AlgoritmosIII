/**
 * ---------------------------------------------------------------------
 * $Id: Simulador.java,v 1.0 2013/08/23 
 * Universidad Francisco de Paula Santander 
 * Programa Ingenieria de Sistemas
 *
 * Proyecto: SEED_UFPS
 * ----------------------------------------------------------------------
 */


package com.simlistadoble;

import Mundo_ListaDoble.SimuladorListaD;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * Clase controlador del Vista.FXML donde se crean y manipulan los componente javafx de la Aplicacion.
 * @author Uriel Garcia - Yulieth Pabon
 * @version 1.0
 */

public class Simulador implements Initializable {
    
    @FXML   private     ImageView   nodo0, nodo1, nodo2, nodo3, nodo4, nodo5, nodo6, nodo7, nodo8, nodo9, nodo10, nodo11, nodo12, nodo13, nodo14, nodoNull, nodoNull0, piv, borde, borde2, borde3;
    @FXML   private     Label       p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14;
    @FXML   private     TextField   txtIns, txtEli, txtEdit1, txtEdit2;    
    @FXML   private     Label       label0, label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13, label14, labelNull, labelCab,  nota, labelPiv, msg;       
    @FXML   private     Timeline    lineaTiempo; 
    @FXML   private     ImageView   imgs[];
    @FXML   private     Label       labels[], posic[];
    @FXML   private     SimuladorListaD simulador;

    
    @FXML
    private void btInsIni(ActionEvent event){        
        try{
            String val = txtIns.getText();        
            txtIns.setText("");
            if(val.isEmpty()){
                impNota("Debe ingresar el valor a Insertar en la Lista!",1);
                return;
            }        
            if(!esNumero(val)){
                impNota("Debe ingresar un valor numerico!",1);
                return;
            } 
            if(this.simulador==null){
                impNota("No se puede insertar el Elemento!",1);
                return;
            }
            if(this.simulador.conocerTamanio()>=15){
                impNota("La Lista no puede crear mas Elementos!",1);
                return;
            }
            int dato = Integer.parseInt(val);
            if(dato>=1000 || dato<=-100){
                impNota("El valor ingresado supera el rango permitido: -99 a 999!",1);
                return;
            } 
            
            //Realizar la insercion
            boolean rta = this.simulador.insertarAlInicio(dato);
            if(!rta){
                impNota("El elemento ingresado '"+dato+"' ya se encuentra en la Lista",1);                        
                return;
            }
            this.pintarTDA();
            this.animacion(0, 0, dato);
            impNota("Se ha insertado el elemento '"+dato+"' al Inicio de la Lista!",0);                        
            
        }catch(Exception e){
            impNota("No se puede insertar el Elemento!",1);
        }
    }
    
    @FXML
    private void btInsFin(ActionEvent event){        
        try{
            String val = txtIns.getText();        
            txtIns.setText("");
            if(val.isEmpty()){
                impNota("Debe ingresar el valor a Insertar en la Lista!",1);
                return;
            }        
            if(!esNumero(val)){
                impNota("Debe ingresar un valor numerico!",1);
                return;
            } 
            if(this.simulador==null){
                impNota("No se puede insertar el Elemento!",1);
                return;
            }
            if(this.simulador.conocerTamanio()>=15){
                impNota("La Lista no puede crear mas Elementos!",1);
                return;
            }
            int dato = Integer.parseInt(val);
            if(dato>=1000 || dato<=-100){
                impNota("El valor ingresado supera el rango permitido: -99 a 999!",1);
                return;
            } 
            
            //Realizar la insercion
            boolean rta = this.simulador.insertarAlFinal(dato);
            if(!rta){
                impNota("El elemento ingresado '"+dato+"' ya se encuentra en la Lista",1);                        
                return;
            }
            this.pintarTDA();
            int posi = this.simulador.obtenerIndice(dato);
            this.animacion(1,posi, dato);
            impNota("Se ha insertado el elemento '"+dato+"' al Final de la Lista!",0);                        
            
        }catch(Exception e){
            impNota("No se puede insertar el Elemento!",1);
        }
    }
    
    @FXML
    private void btInsOrdenado(ActionEvent event){        
        try{
            String val = txtIns.getText();        
            txtIns.setText("");
            if(val.isEmpty()){
                impNota("Debe ingresar el valor a Insertar en la Lista!",1);
                return;
            }        
            if(!esNumero(val)){
                impNota("Debe ingresar un valor numerico!",1);
                return;
            } 
            if(this.simulador==null){
                impNota("No se puede insertar el Elemento!",1);
                return;
            }
            if(this.simulador.conocerTamanio()>=15){
                impNota("La Lista no puede crear mas Elementos!",1);
                return;
            }
            int dato = Integer.parseInt(val);
            if(dato>=1000 || dato<=-100){
                impNota("El valor ingresado supera el rango permitido!",1);
                return;
            } 
            
            //Realizar la insercion
            boolean rta = this.simulador.insertarOrdenado(dato);
            if(!rta){
                impNota("El elemento ingresado '"+dato+"' ya se encuentra en la Lista",1);                        
                return;
            }
            this.pintarTDA();
            int posi = this.simulador.obtenerIndice(dato);
            this.animacion(2, posi, dato);
            impNota("Se ha insertado Ordenadamente el elemento '"+dato+"' en la Lista!",0);                        
            
        }catch(Exception e){
            impNota("No se puede insertar el Elemento!",1);
        }
    }
    
    @FXML
    private void btEli(ActionEvent event){
        try{
            String val = txtEli.getText();        
            txtEli.setText("");
            if(val.isEmpty()){
                impNota("Debe ingresar el valor a Eliminar en la Lista!",1);
                return;
            }        
            if(!esNumero(val)){
                impNota("Debe ingresar un valor numerico!",1);
                return;
            } 
            if(this.simulador==null){
                impNota("No se puede eliminar el Elemento!",1);
                return;
            }
            if(this.simulador.estaVaciaLista()){
                impNota("La lista no posee elementos!",1);
                return;
            }
            int dato = Integer.parseInt(val);
            
            //Realizacion de la Eliminacion 
            
            int posi = this.simulador.obtenerIndice(dato);
            int rta = this.simulador.eliminarDato(dato);
            if(rta==-1){
                impNota("El elemento ingresado no se encuetra en la Lista!",1);            
                return;
            }
            this.pintarTDA(); 
            this.animacion(3, posi, rta);
            impNota("El elemento '"+rta+"' ha sido eliminado correctamente!",0);
            
        }catch(Exception e){
            impNota("No se puede eliminar el Elemento!",1);
        }
    }
    
    @FXML
    private void btEdit(ActionEvent event){        
        try{
            String cad1 = txtEdit1.getText();
            String cad2 = txtEdit2.getText();
            txtEdit1.setText("");
            txtEdit2.setText("");
            if(cad1.isEmpty()){
                impNota("Debe ingresar la posicion del Elemento!",1);
                return;
            }   
            if(cad2.isEmpty()){
                impNota("Debe ingresar el nuevo valor del Elemento!",1);
                return;
            }
            if(!esNumero(cad1) || !esNumero(cad2)){
                impNota("Debe ingresar valores numericos!",1);
                return;
            }
            if(this.simulador==null){
                impNota("No se puede editar el Elemento!",1);
                txtEli.setText("");
                return;
            }
            int posi = Integer.parseInt(cad1); 
            int dato = Integer.parseInt(cad2);
            
            if(posi>=this.simulador.conocerTamanio() || posi<0){
                impNota("La posicion indicada No es Valida!",1);
                return;
            }
            if(dato>=1000 || dato<=-100){
                impNota("El valor ingresado supera el rango permitido: -99 a 999!",1);
                return;
            } 
            
            //Realizacion de la edicion
            boolean rta = this.simulador.cambiarDato(posi, dato);
            if(!rta){
                impNota("El nuevo dato ingresado ya existe en la Lista!",1);            
                return;
            }            
            this.pintarTDA();  
            this.animacion(4, posi,dato);
            impNota("Se ha editado el elemento en la posicion '"+posi+"' de la Lista!",0);            

        }catch(Exception e){
            impNota("No se puede editar el Elemento",1);
        }        
    }    
    
    @FXML
    private void btTam(ActionEvent event){
        try{   
            if(this.simulador==null){
                impNota("No se puede determinar el tamaño!",1);
                return;
            } 
            msg.setVisible(true);            
            msg.setText("Tamaño de la Lista: "+this.simulador.conocerTamanio()+" Elementos!");
            this.impNota("Se ha determinado el Tamaño de la Lista", 0);
        }catch(Exception e){
            impNota("No se puede determinar el tamaño!",1);
            msg.setVisible(false);
        }
    }
    
    @FXML
    private void btReset(ActionEvent event){
        try{
            //Realizacion del vaciado
            this.simulador.vaciarLista();
            this.pintarTDA();
            impNota("Se ha reiniciado la Lista!",0);
        }catch(Exception e){
            impNota("No se puede reiniciar la Estructura!",1);
        }
        
    }
    
    @FXML
    private void salir(ActionEvent event){
        System.exit(0);
    }    
    
    
    @FXML
    private void inicializar(){ 
        //cargar el vector de labels
        this.label0.setVisible(false);this.label1.setVisible(false);this.label2.setVisible(false);
        this.label3.setVisible(false);this.label4.setVisible(false);this.label5.setVisible(false);
        this.label6.setVisible(false);this.label7.setVisible(false);this.label8.setVisible(false);
        this.label9.setVisible(false);this.label10.setVisible(false);this.label11.setVisible(false);
        this.label12.setVisible(false);this.label13.setVisible(false);this.label14.setVisible(false);
        this.labels[0]=label0;this.labels[1]=label1;this.labels[2]=label2;
        this.labels[3]=label3;this.labels[4]=label4;this.labels[5]=label5;
        this.labels[6]=label6;this.labels[7]=label7;this.labels[8]=label8;
        this.labels[9]=label9;this.labels[10]=label10;this.labels[11]=label11;
        this.labels[12]=label12;this.labels[13]=label13;this.labels[14]=label14;
        //cargar el vector de posiciones
        this.p0.setVisible(false);this.p1.setVisible(false);this.p2.setVisible(false);
        this.p3.setVisible(false);this.p4.setVisible(false);this.p5.setVisible(false);
        this.p6.setVisible(false);this.p7.setVisible(false);this.p8.setVisible(false);
        this.p9.setVisible(false);this.p10.setVisible(false);this.p11.setVisible(false);
        this.p12.setVisible(false);this.p13.setVisible(false);this.p14.setVisible(false);
        this.posic[0]=p0;this.posic[1]=p1;this.posic[2]=p2;
        this.posic[3]=p3;this.posic[4]=p4;this.posic[5]=p5;
        this.posic[6]=p6;this.posic[7]=p7;this.posic[8]=p8;
        this.posic[9]=p9;this.posic[10]=p10;this.posic[11]=p11;
        this.posic[12]=p12;this.posic[13]=p13;this.posic[14]=p14;
        //cargar las imagenes
        this.nodo0.setVisible(false);this.nodo1.setVisible(false);this.nodo2.setVisible(false);
        this.nodo3.setVisible(false);this.nodo4.setVisible(false);this.nodo5.setVisible(false);
        this.nodo6.setVisible(false);this.nodo7.setVisible(false);this.nodo8.setVisible(false);
        this.nodo9.setVisible(false);this.nodo10.setVisible(false);this.nodo11.setVisible(false);
        this.nodo12.setVisible(false);this.nodo13.setVisible(false);this.nodo14.setVisible(false);
        this.imgs[0]=nodo0;this.imgs[1]=nodo1;this.imgs[2]=nodo2;
        this.imgs[3]=nodo3;this.imgs[4]=nodo4;this.imgs[5]=nodo5;
        this.imgs[6]=nodo6;this.imgs[7]=nodo7;this.imgs[8]=nodo8;
        this.imgs[9]=nodo9;this.imgs[10]=nodo10;this.imgs[11]=nodo11;
        this.imgs[12]=nodo12;this.imgs[13]=nodo13;this.imgs[14]=nodo14;
        //hacer invisible el mensaje
        msg.setVisible(false);
        this.nodoNull.setVisible(false);
        this.nodoNull0.setVisible(false);
        this.labelNull.setVisible(false);
        this.piv.setVisible(false);
        this.labelPiv.setVisible(false);
    }
    
    @FXML
    private void impNota(String nota, int tipo){
        String cab = "";
        if(tipo==0){
            cab="Exito, ";
            this.nota.setTextFill(Color.BLACK);
            this.borde.setImage(borde2.getImage());
        }            
        if(tipo==1){
            cab="Error, ";
            this.nota.setTextFill(Color.BLACK);
            this.borde.setImage(borde3.getImage());
        }
        this.nota.setVisible(true);
        this.nota.setText(cab+nota);
    }
    
    @FXML
    private boolean esNumero(String val){
        try{
            Integer.parseInt(val);
        }catch(Exception e){
            return (false);
        }
        return (true);
    }

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            impNota("El Simulador para Lista Doble ha iniciado!",0);
            this.simulador = new SimuladorListaD();
            this.lineaTiempo = new Timeline();
            this.imgs = new ImageView[15];
            this.labels = new Label[15];
            this.posic = new Label[15];
            this.pintarTDA();
        }catch(Exception e){
            impNota("El Simulador para Lista Doble no puede iniciar!",1);
        }
    }

    @FXML
    private void pintarTDA(){
        this.inicializar();
        double lx = 170.0, lx2= 170.0;
        this.labelCab.setLayoutX(lx);
        Object lista[] = this.simulador.pasarAVector();
        for(int i=0; lista!=null && i<lista.length && i<15 ; i++){
            int val = (int)lista[i];
            this.imgs[i].setLayoutX(lx);
            this.imgs[i].setVisible(true);
            this.posic[i].setLayoutX(lx2);
            this.posic[i].setVisible(true);
            this.labels[i].setLayoutX(lx2);
            this.labels[i].setText(val+"");
            this.labels[i].setVisible(true);
            lx = lx + 40.0;
            lx2 = lx2 + 40.0;
        }
        if(lx==170.0){
            this.nodoNull0.setLayoutX(lx);
            this.nodoNull0.setVisible(true); 
        }else{
            this.nodoNull.setLayoutX(lx);
            this.nodoNull.setVisible(true); 
        }
        this.labelNull.setText("<Null>");
        this.labelNull.setLayoutX(lx);
        this.labelNull.setVisible(true);
           
    }
    
    @FXML
    private void animacion(int tipo, int posi, int val){

        lineaTiempo = new Timeline();
        lineaTiempo.stop();
        lineaTiempo.setCycleCount(1); 
        KeyFrame f1=null,f11=null,f2=null,f22=null,f3=null,f33=null,f4=null,f44=null,
                f5=null, f55=null, f6=null, f66=null;
        double durac = 2000;
        switch(tipo){
            //Añadir al inicio
            case 0 :
                piv.setLayoutX(170.0);
                piv.setLayoutY(337.0);
                labelPiv.setLayoutX(170.0);
                labelPiv.setLayoutY(348.0);
                labelPiv.setText(val+"");
                //Mover en X
                f1 = new KeyFrame(Duration.ZERO, new KeyValue(piv.translateXProperty(),0));
                f11 = new KeyFrame(Duration.ZERO, new KeyValue(labelPiv.translateXProperty(),0));
                f2 = new KeyFrame(new Duration(durac), new KeyValue(piv.translateXProperty(),0));
                f22 = new KeyFrame(new Duration(durac), new KeyValue(labelPiv.translateXProperty(),0));
                //Mover en Y
                f3 = new KeyFrame(Duration.ZERO, new KeyValue(piv.translateYProperty(),0));
                f33 = new KeyFrame(new Duration(durac), new KeyValue(piv.translateYProperty(),-70));
                f4 = new KeyFrame(Duration.ZERO, new KeyValue(labelPiv.translateYProperty(),0));
                f44 = new KeyFrame(new Duration(durac), new KeyValue(labelPiv.translateYProperty(),-70));
               //Volver Invisible
                f5 = new KeyFrame(new Duration(durac), new KeyValue(piv.visibleProperty(),true));
                f55 = new KeyFrame(new Duration(durac+500), new KeyValue(piv.visibleProperty(),false));
                f6 = new KeyFrame(new Duration(durac), new KeyValue(labelPiv.visibleProperty(),true));
                f66 = new KeyFrame(new Duration(durac+500), new KeyValue(labelPiv.visibleProperty(),false));
                break;
                
                //Añadir al Final
            case 1 :
                piv.setLayoutX(170.0);
                piv.setLayoutY(337.0);
                labelPiv.setLayoutX(170.0);
                labelPiv.setLayoutY(348.0);
                labelPiv.setText(val+"");
                double xposi = (imgs[posi].getLayoutX())-170.0;
                //Mover en X
                f1 = new KeyFrame(Duration.ZERO, new KeyValue(piv.translateXProperty(),0));
                f11 = new KeyFrame(Duration.ZERO, new KeyValue(labelPiv.translateXProperty(),0));
                f2 = new KeyFrame(new Duration(durac), new KeyValue(piv.translateXProperty(),xposi));
                f22 = new KeyFrame(new Duration(durac), new KeyValue(labelPiv.translateXProperty(),xposi));
                //Mover en Y
                f3 = new KeyFrame(Duration.ZERO, new KeyValue(piv.translateYProperty(),0));
                f33 = new KeyFrame(new Duration(durac), new KeyValue(piv.translateYProperty(),-70.0));
                f4 = new KeyFrame(Duration.ZERO, new KeyValue(labelPiv.translateYProperty(),0));
                f44 = new KeyFrame(new Duration(durac), new KeyValue(labelPiv.translateYProperty(),-70.0));
                //Invisible
                f5 = new KeyFrame(new Duration(durac), new KeyValue(piv.visibleProperty(),true));
                f55 = new KeyFrame(new Duration(durac+500), new KeyValue(piv.visibleProperty(),false));
                f6 = new KeyFrame(new Duration(durac), new KeyValue(labelPiv.visibleProperty(),true));
                f66 = new KeyFrame(new Duration(durac+500), new KeyValue(labelPiv.visibleProperty(),false));
                break;
                
         //Añadir Ordenado
            case 2 :
                piv.setLayoutX(170.0);
                piv.setLayoutY(337.0);
                labelPiv.setLayoutX(170.0);
                labelPiv.setLayoutY(348.0);
                labelPiv.setText(val+"");
                double xposi2 = (imgs[posi].getLayoutX())-170.0;
                //Mover en X
                f1 = new KeyFrame(Duration.ZERO, new KeyValue(piv.translateXProperty(),0));
                f11 = new KeyFrame(Duration.ZERO, new KeyValue(labelPiv.translateXProperty(),0));
                f2 = new KeyFrame(new Duration(durac), new KeyValue(piv.translateXProperty(),xposi2));
                f22 = new KeyFrame(new Duration(durac), new KeyValue(labelPiv.translateXProperty(),xposi2));
                //Mover en Y
                f3 = new KeyFrame(Duration.ZERO, new KeyValue(piv.translateYProperty(),0));
                f33 = new KeyFrame(new Duration(durac), new KeyValue(piv.translateYProperty(),-70.0));
                f4 = new KeyFrame(Duration.ZERO, new KeyValue(labelPiv.translateYProperty(),0));
                f44 = new KeyFrame(new Duration(durac), new KeyValue(labelPiv.translateYProperty(),-70.0));
                //Invisible
                f5 = new KeyFrame(new Duration(durac), new KeyValue(piv.visibleProperty(),true));
                f55 = new KeyFrame(new Duration(durac+500), new KeyValue(piv.visibleProperty(),false));
                f6 = new KeyFrame(new Duration(durac), new KeyValue(labelPiv.visibleProperty(),true));
                f66 = new KeyFrame(new Duration(durac+500), new KeyValue(labelPiv.visibleProperty(),false));
                break;
                
                //Eliminar
            case 3 :
                piv.setLayoutX(imgs[posi].getLayoutX());
                piv.setLayoutY(imgs[posi].getLayoutY());
                labelPiv.setLayoutX(labels[posi].getLayoutX());
                labelPiv.setLayoutY(labels[posi].getLayoutY());
                labelPiv.setText(val+"");     
                //Mover en X
                f1 = new KeyFrame(Duration.ZERO, new KeyValue(piv.translateXProperty(),0));
                f11 = new KeyFrame(Duration.ZERO, new KeyValue(labelPiv.translateXProperty(),0));
                f2 = new KeyFrame(new Duration(durac), new KeyValue(piv.translateXProperty(),-(imgs[posi].getLayoutX()-170.0)));
                f22 = new KeyFrame(new Duration(durac), new KeyValue(labelPiv.translateXProperty(),-(imgs[posi].getLayoutX()-170)));
                //Mover en Y
                f3 = new KeyFrame(Duration.ZERO, new KeyValue(piv.translateYProperty(),0));
                f33 = new KeyFrame(new Duration(durac), new KeyValue(piv.translateYProperty(),70.0));
                f4 = new KeyFrame(Duration.ZERO, new KeyValue(labelPiv.translateYProperty(),0));
                f44 = new KeyFrame(new Duration(durac), new KeyValue(labelPiv.translateYProperty(),70.0));
                //Mover
                f5 = new KeyFrame(new Duration(durac), new KeyValue(piv.visibleProperty(),true));
                f55 = new KeyFrame(new Duration(durac+500), new KeyValue(piv.visibleProperty(),false));
                f6 = new KeyFrame(new Duration(durac), new KeyValue(labelPiv.visibleProperty(),true));
                f66 = new KeyFrame(new Duration(durac+500), new KeyValue(labelPiv.visibleProperty(),false));
                break;
                //Editar
            case 4 :
                piv.setLayoutX(170.0);
                piv.setLayoutY(337.0);
                labelPiv.setLayoutX(170.0);
                labelPiv.setLayoutY(348.0);
                labelPiv.setText(val+"");
                //Mover en X
                f1 = new KeyFrame(Duration.ZERO, new KeyValue(piv.translateXProperty(),0));
                f11 = new KeyFrame(Duration.ZERO, new KeyValue(labelPiv.translateXProperty(),0));
                f2 = new KeyFrame(new Duration(durac), new KeyValue(piv.translateXProperty(),(imgs[posi].getLayoutX()-170)));
                f22 = new KeyFrame(new Duration(durac), new KeyValue(labelPiv.translateXProperty(),(imgs[posi].getLayoutX()-170)));
                // Mover en Y
                f3 = new KeyFrame(Duration.ZERO, new KeyValue(piv.translateYProperty(),0));
                f33 = new KeyFrame(new Duration(durac), new KeyValue(piv.translateYProperty(),-70));
                f4 = new KeyFrame(Duration.ZERO, new KeyValue(labelPiv.translateYProperty(),0));
                f44 = new KeyFrame(new Duration(durac), new KeyValue(labelPiv.translateYProperty(),-70));
                //Invisible
                f5 = new KeyFrame(new Duration(durac), new KeyValue(piv.visibleProperty(),true));
                f55 = new KeyFrame(new Duration(durac+500), new KeyValue(piv.visibleProperty(),false));
                f6 = new KeyFrame(new Duration(durac), new KeyValue(labelPiv.visibleProperty(),true));
                f66 = new KeyFrame(new Duration(durac+500), new KeyValue(labelPiv.visibleProperty(),false));
                break;
        }
        piv.setVisible(true);
        labelPiv.setVisible(true);
        lineaTiempo.getKeyFrames().addAll(f1,f11,f2,f22,f3,f33,f4,f44,f5,f55,f6,f66);
        lineaTiempo.play();
    }
 
}
