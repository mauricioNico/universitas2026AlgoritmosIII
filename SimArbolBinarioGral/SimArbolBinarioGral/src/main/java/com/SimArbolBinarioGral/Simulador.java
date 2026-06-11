/**
 * ---------------------------------------------------------------------
 * $Id: Simulador.java,v 1.0 2013/08/23 
 * Universidad Francisco de Paula Santander 
 * Programa Ingenieria de Sistemas
 *
 * Proyecto: SEED_UFPS
 * ----------------------------------------------------------------------
 */

package comsimarbolbinariogral;

import Graficos.ArbolBinarioG;
import Mundo_ArbolBinario.SimuladorArbolBinario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 * Clase controlador del Vista.FXML donde se crean y manipulan los componente javafx de la Aplicacion.
 * @author Uriel Garcia - Yulieth Pabon
 * @version 1.0
 */

public class Simulador implements Initializable {
    
    @FXML   private Line    linea0, linea1,linea2,linea3,linea4,linea5,linea6,linea7,linea8,linea9,linea10,
                            linea11,linea12,linea13,linea14,linea15,linea16,linea17,linea18,linea19,
                            linea20, linea21,linea22,linea23,linea24,linea25,linea26,linea27,linea28,linea29,
                            linea30, linea31,linea32,linea33,linea34,linea35,linea36,linea37,linea38,linea39;
    @FXML   private Circle  raiz, nodo1,nodo2,nodo3,nodo4,nodo5,nodo6,nodo7,nodo8,nodo9,nodo10,nodo11,nodo12, nodo13,nodo14,nodo15, nodo16, nodo17, nodo18, nodo19,
                            nodo20, nodo21, nodo22, nodo23, nodo24, nodo25, nodo26, nodo27, nodo28, nodo29, nodo30, nodo31, nodo32, nodo33, nodo34, nodo35, nodo36, nodo37, nodo38, nodo39,
                            nodo40, nodo41, nodo42, nodo43, nodo44, nodo45, nodo46, nodo47, nodo48, nodo49, nodo50, nodo51, nodo52, nodo53, nodo54, nodo55, nodo56, nodo57, nodo58, nodo59,
                            nodo60, nodo61, nodo62, nodo63, nodo64, nodo65, nodo66, nodo67, nodo68, nodo69, nodo70, nodo71, nodo72, nodo73, nodo74, nodo75, nodo76, nodo77, nodo78, nodo79,
                            nodo80, nodo81, nodo82, nodo83, nodo84, nodo85, nodo86, nodo87, nodo88, nodo89, nodo90, nodo91, nodo92, nodo93, nodo94, nodo95, nodo96, nodo97, nodo98, nodo99, piv;
    @FXML   private Label   label0, label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12, label13,label14,label15, label16, label17, label18, label19,
                            label20, label21, label22, label23, label24, label25, label26, label27, label28, label29, label30, label31, label32, label33, label34, label35, label36, label37, label38, label39,
                            label40, label41, label42, label43, label44, label45, label46, label47, label48, label49, label50, label51, label52, label53, label54, label55, label56, label57, label58, label59,
                            label60, label61, label62, label63, label64, label65, label66, label67, label68, label69, label70, label71, label72, label73, label74, label75, label76, label77, label78, label79,
                            label80, label81, label82, label83, label84, label85, label86, label87, label88, label89, label90, label91, label92, label93, label94, label95, label96, label97, label98, label99, labelPiv;

    @FXML   private     TextField   txtIns, txtPadre, txtEli, txtBuscar;
    @FXML   private     ComboBox    txtLado;
    @FXML   private     ImageView   borde, borde2, borde3;
    @FXML   private     Label   nota,  msg;  
    @FXML   private     Timeline    lineaTiempo = new Timeline(); 
    @FXML   private     SimuladorArbolBinario    simulador;
    @FXML   private     Circle  nodos[];
    @FXML   private     Line    lineas[];
    @FXML   private     Label   labels[];
    @FXML   private     ArbolBinarioG abg;
    
    
    @FXML
    private void btIns() {    
        try{  
            //Validaciones..
            String val = txtIns.getText();
            String pad = txtPadre.getText();            
            
            if(val.isEmpty()){
                impNota("Debe ingresar el valor que desea Insertar!",1);
                return;
            }
            if(!this.simulador.estaVacioArbol() && pad.isEmpty()){
                impNota("Debe ingresar el Padre del nuevo Elemento!",1);
                return;
            }  
            if(!this.simulador.estaVacioArbol() && txtLado.getValue()==null){
                impNota("Debe seleccionar un Lado del Arbol!",1);
                return;
            }
            
            if(!esNumero(val)){
                impNota("Debe ingresar valores numerico!",1);
                return;
            }
            if(this.simulador==null){
                impNota("Debe crear primero una Arbol Binario!",1);
                return;
            }
            int dato = Integer.parseInt(val);             
            if(dato>=1000 || dato<=(-100)){
                impNota("El valor ingresado supera el rango permitido: -99 a 999!",1);
                return;
            }
            
            // Insercion del Elemento
            String lad = "Izquierdo";
            int padre = 0;
            if(txtLado.getValue()!=null)
                lad = txtLado.getValue().toString();
            if(!pad.isEmpty())
                if(!this.esNumero(val)){
                    impNota("Debe ingresar valores numerico!",1);
                    return;
                }else
                padre = Integer.parseInt(pad);
            int lado= lad.equalsIgnoreCase("Izquierdo")?0:1;
            int rta = this.simulador.insertarDato(dato,padre,lado);
            this.pintarTDA();
            if(rta==0){
                this.abg.animacion(0,dato,this.lineaTiempo);
                this.impNota("Dato insertado correctamente en el Arbol!", 0); //Insercion correcta
                txtIns.setText("");
                txtPadre.setText("");
            }                
            if(rta==-1){
                this.abg.animacion(0,dato,this.lineaTiempo);
                this.impNota("El dato ya se encuentra en el Arbol!", 1); //Insercion erronea
            }                
            if(rta==-2)
                this.impNota("La insercion supera la Altura del Arbol permitida (5)!", 1); //Insercion erroneo            
            if(rta==-3)
                this.impNota("No es posible insertar el elemento en el Arbol!",1); //Insercion erroneo
            if(rta==-4)
                this.impNota("No se puede insertar el Elemento. Verifique que el padre exista y no tenga Hijo "+lad+"!",1); //Insercion erroneo
            
        }catch(Exception e){
            this.impNota("No se puede insertar el Elemento!", 1);            
        }
        
    }
    
    @FXML
    private void btEli() {  
        try{
            String val = txtEli.getText();   
            txtEli.setText("");
            if(val.isEmpty()){
                impNota("Debe ingresar el valor a Eliminar del Arbol!",1);
                return;
            }        
            if(!esNumero(val)){
                impNota("Debe ingresar un valor numerico!",1);
                return;
            } 
            if(this.simulador==null){
                impNota("Debe crear primero una Arbol Binario!",1);
                return;
            }
            if(this.simulador.estaVacioArbol()){
                impNota("El Arbol Binario no posee elementos!",1);
                return;
            }
            
            //Eliminacion del Elemento
            int dato = Integer.parseInt(val);
            boolean rta = this.simulador.eliminarDato(dato);
            if(!rta){
                impNota("El elemento ingresado No existe en el Arbol!",1);
                return;
            }
            String layouts = this.abg.getLayoutsEliminar(dato);
            this.pintarTDA();            
            this.abg.animacionEliminar(layouts, dato, lineaTiempo, this.piv, this.labelPiv);
            impNota("Se ha eliminado el elemento '"+dato+"' del Arbol Binario!",0);                                        

        }catch(Exception e){
            this.impNota("No se puede eliminar el Elemento!", 1);            
        }        
    }

    @FXML
    private void btBuscar() {  
        try{
            String val = txtBuscar.getText();        
            txtBuscar.setText("");
            if(val.isEmpty()){
                impNota("Debe ingresar el valor a Buscar en el Arbol!",1);
                return;
            }        
            if(!esNumero(val)){
                impNota("Debe ingresar un valor numerico!",1);
                return;
            } 
            if(this.simulador==null){
                impNota("Debe crear primero una Arbol Binario!",1);
                return;
            }
            if(this.simulador.estaVacioArbol()){
                impNota("El Arbol Binario no posee elementos!",1);
                return;
            }

            //Busqueda del Dato
            int dato = Integer.parseInt(val); 
            boolean esta = this.simulador.estaDatoenArbol(dato);
            this.pintarTDA();            
            if(!esta)
                impNota("El elemento ingresado No existe en el Arbol!",1);
            else{
                this.abg.animacion(2, dato,this.lineaTiempo);
                impNota("El elemento ha sido encontrado: '"+dato+"'.",0);
            }
        }catch(Exception e){
            this.impNota("No se puede encontrar el Elemento!", 1); 
        }
    }
    
    @FXML
    private void btHojas() {  
        try{
            if(this.simulador==null){
                impNota("Debe crear primero una Arbol Binario!",1);
                return;
            }
            if(this.simulador.estaVacioArbol()){
                impNota("El Arbol Binario no posee elementos!",1);
                return;
            }
            
            //Calcular las hojas
            int numHojas =  this.simulador.contarHojas();
            if(numHojas==0){
                impNota("El Arbol Binario no posee elemetos Hoja!",1);
                return;
            }
            String cad =  "El Arbol Binario tiene "+numHojas+" Hojas.", cad2="Hojas del Arbol: ";
            String hojas = this.simulador.obtenerHojas();
            this.pintarTDA();
            msg.setText(cad2+hojas);
            msg.setVisible(true);
            impNota(cad,0);
            this.abg.animacion(3, 3,this.lineaTiempo);
            
        }catch(Exception e){
            this.impNota("No se pueden encontrar las Hojas!", 1); 
        }
    }
    
    @FXML
    private void btPodar() {  
        //Podar el Arbol..   
        try{
            if(this.simulador==null){
                impNota("Debe crear primero una Arbol Binario!",1);
                return;
            }
            if(this.simulador.estaVacioArbol()){
                impNota("El Arbol Binario no posee elementos!",1);
                return;
            }
            
            //podar arbol
            int num = this.simulador.contarHojas();
            if(num==0){
                impNota("El Arbol Binario no posee elemetos Hoja!",1);
                return;
            }            
            String cad =  "Hojas eliminadas: ";
            cad += this.simulador.obtenerHojas();
            this.simulador.podarHojas();            
            this.pintarTDA();
            msg.setText(cad);
            msg.setVisible(true);
            impNota(cad,0);
            this.abg.animacion(4, 4,this.lineaTiempo);
            this.impNota("El Arbol Binario ha sido podado!", 0);             
            
        }catch(Exception e){
            this.impNota("No se puede podar el Arbol!", 1); 
        }
        
    }
    
    @FXML
    private void btPreorden() {  
        try{
            if(this.simulador==null){
                impNota("Debe crear primero una Arbol Binario!",1);
                return;
            }
            if(this.simulador.estaVacioArbol()){
                impNota("El Arbol Binario no posee elementos!",1);
                return;
            }

            //calcular preorden
            String cad = "Recorrido en PreOrden: ";
            cad += this.simulador.recorridoPreorden();
            this.pintarTDA();
            msg.setLayoutY(425.0);
            msg.setText(cad);
            msg.setVisible(true);            
            this.abg.animacion(5, 5,this.lineaTiempo);
            this.impNota("Se esta recorriendo el Arbol en PreOrden!", 0);   
        }catch(Exception e){
            this.impNota("No se puede determinar el Recorrido!", 1); 
        }        
    }
    
    @FXML
    private void btInorden() {  
        try{
            if(this.simulador==null){
                impNota("Debe crear primero una Arbol Binario!",1);
                return;
            }
            if(this.simulador.estaVacioArbol()){
                impNota("El Arbol Binario no posee elementos!",1);
                return;
            }

            //calcular inorden
            String cad = "Recorrido en InOrden: ";
            cad += this.simulador.recorridoInorden();
            this.pintarTDA();
            msg.setLayoutY(425.0);
            msg.setText(cad);
            msg.setVisible(true);
            this.abg.animacion(6, 6,this.lineaTiempo);
            this.impNota("Se esta recorriendo el Arbol en InOrden!", 0);   
        }catch(Exception e){
            this.impNota("No se puede determinar el Recorrido!", 1); 
        }  
    }
    
    @FXML
    private void btPostorden() {  
        try{
            if(this.simulador==null){
                impNota("Debe crear primero una Arbol Binario!",1);
                return;
            }
            if(this.simulador.estaVacioArbol()){
                impNota("El Arbol Binario no posee elementos!",1);
                return;
            }

            //calcular preorden
            String cad = "Recorrido en PostOrden: ";
            cad += this.simulador.recorridoPostorden();
            this.pintarTDA();
            msg.setLayoutY(425.0);
            msg.setText(cad);
            msg.setVisible(true);
            this.abg.animacion(7,7,this.lineaTiempo);
            this.impNota("Se esta recorriendo el Arbol en PostOrden!", 0);   
        }catch(Exception e){
            this.impNota("No se puede determinar el Recorrido!", 1); 
        }  
    }
    
    @FXML
    private void btPorNiveles() {  
        try{
            if(this.simulador==null){
                impNota("Debe crear primero una Arbol Binario!",1);
                return;
            }
            if(this.simulador.estaVacioArbol()){
                impNota("El Arbol Binario no posee elementos!",1);
                return;
            }

            //calcular preorden
            String cad = "Recorrido por Niveles: ";
            cad += this.simulador.recorridoPorNiveles();
            this.pintarTDA();
            msg.setLayoutY(425.0);
            msg.setText(cad);
            msg.setVisible(true);
            this.abg.animacion(8,8,this.lineaTiempo);
            this.impNota("Se esta recorriendo el Arbol por Niveles!", 0);  
        }catch(Exception e){
            this.impNota("No se puede determinar el Recorrido!", 1); 
        }  
    }
    
    @FXML
    private void btPeso() {  
        //Peso del Arbol.. 
        try{
            if(this.simulador==null){
                impNota("Debe crear primero una Arbol Binario!",1);
                return;
            }
            int p = this.simulador.conocerPeso();
            this.pintarTDA();
            msg.setText("El peso del Arbol Binario es: "+p+" Elementos!");
            msg.setVisible(true);            
            this.impNota("Peso del Arbol determinado.", 0);             
        }catch(Exception e){
            this.impNota("No se puede determinar el Peso!", 1); 
        }
    }
    
    @FXML
    private void btAltura() {  
        //Altura..   
        try{
            if(this.simulador==null){
                impNota("Debe crear primero una Arbol Binario!",1);
                return;
            }
            int alt = this.simulador.conocerAltura();
            this.pintarTDA();
            msg.setText("La altura del Arbol Binario es: "+alt+"!");
            msg.setVisible(true);            
            this.impNota("Altura del Arbol determinada.", 0);  
        }catch(Exception e){
            this.impNota("No se puede determinar la Altura!", 1); 
        }
    }
    
    @FXML
    private void salir() {  
        System.exit(0);
    }
    
    
    
    private void cargarLineas() {        
        this.lineas = new Line[40];        
        this.lineas[0]= linea0;this.lineas[1]= linea1;this.lineas[2]= linea2;this.lineas[3]= linea3;this.lineas[4]= linea4;
        this.lineas[5]= linea5;this.lineas[6]= linea6;this.lineas[7]= linea7;this.lineas[8]= linea8;this.lineas[9]= linea9;
        this.lineas[10]= linea10;this.lineas[11]= linea11;this.lineas[12]= linea12;this.lineas[13]= linea13;this.lineas[14]= linea14;
        this.lineas[15]= linea15;this.lineas[16]= linea16;this.lineas[17]= linea17;this.lineas[18]= linea18;this.lineas[19]= linea19;
        this.lineas[20]= linea20;this.lineas[21]= linea21;this.lineas[22]= linea22;this.lineas[23]= linea23;this.lineas[24]= linea24;
        this.lineas[25]= linea25;this.lineas[26]= linea26;this.lineas[27]= linea27;this.lineas[28]= linea28;this.lineas[29]= linea29;
        this.lineas[30]= linea30;this.lineas[31]= linea31;this.lineas[32]= linea32;this.lineas[33]= linea33;this.lineas[34]= linea34;
        this.lineas[35]= linea35;this.lineas[36]= linea36;this.lineas[37]= linea37;this.lineas[38]= linea38;this.lineas[39]= linea39;        
        for(int i=0; i<this.lineas.length; i++)
            this.lineas[i].setVisible(false);        
    }
    
    private void cargarNodos() {
        //Creando la pila de circulos
        this.nodos = new Circle[100];        
        this.nodos[0]= raiz;this.nodos[1]= nodo1;this.nodos[2]= nodo2;this.nodos[3]= nodo3;this.nodos[4]= nodo4;
        this.nodos[5]= nodo5;this.nodos[6]= nodo6;this.nodos[7]= nodo7;this.nodos[8]= nodo8;this.nodos[9]= nodo9;
        this.nodos[10]= nodo10;this.nodos[11]= nodo11;this.nodos[12]= nodo12;this.nodos[13]= nodo13;this.nodos[14]= nodo14;
        this.nodos[15]= nodo15;this.nodos[16]= nodo16;this.nodos[17]= nodo17;this.nodos[18]= nodo18;this.nodos[19]= nodo19;
        this.nodos[20]= nodo20;this.nodos[21]= nodo21;this.nodos[22]= nodo22;this.nodos[23]= nodo23;this.nodos[24]= nodo24;
        this.nodos[25]= nodo25;this.nodos[26]= nodo26;this.nodos[27]= nodo27;this.nodos[28]= nodo28;this.nodos[29]= nodo29;
        this.nodos[30]= nodo30;this.nodos[31]= nodo31;this.nodos[32]= nodo32;this.nodos[33]= nodo33;this.nodos[34]= nodo34;
        this.nodos[35]= nodo35;this.nodos[36]= nodo36;this.nodos[37]= nodo37;this.nodos[38]= nodo38;this.nodos[39]= nodo39;
        this.nodos[40]= nodo40;this.nodos[41]= nodo41;this.nodos[42]= nodo42;this.nodos[43]= nodo43;this.nodos[44]= nodo44;
        this.nodos[45]= nodo45;this.nodos[46]= nodo46;this.nodos[47]= nodo47;this.nodos[48]= nodo48;this.nodos[49]= nodo49;
        this.nodos[50]= nodo50;this.nodos[51]= nodo51;this.nodos[52]= nodo52;this.nodos[53]= nodo53;this.nodos[54]= nodo54;
        this.nodos[55]= nodo55;this.nodos[56]= nodo56;this.nodos[57]= nodo57;this.nodos[58]= nodo58;this.nodos[59]= nodo59;
        this.nodos[60]= nodo60;this.nodos[61]= nodo61;this.nodos[62]= nodo62;this.nodos[63]= nodo63;this.nodos[64]= nodo64;
        this.nodos[65]= nodo65;this.nodos[66]= nodo66;this.nodos[67]= nodo67;this.nodos[68]= nodo68;this.nodos[69]= nodo69;
        this.nodos[70]= nodo70;this.nodos[71]= nodo71;this.nodos[72]= nodo72;this.nodos[73]= nodo73;this.nodos[74]= nodo74;
        this.nodos[75]= nodo75;this.nodos[76]= nodo76;this.nodos[77]= nodo77;this.nodos[78]= nodo78;this.nodos[79]= nodo79;
        this.nodos[80]= nodo80;this.nodos[81]= nodo81;this.nodos[82]= nodo82;this.nodos[83]= nodo83;this.nodos[84]= nodo84;
        this.nodos[85]= nodo85;this.nodos[86]= nodo86;this.nodos[87]= nodo87;this.nodos[88]= nodo88;this.nodos[89]= nodo89;
        this.nodos[90]= nodo90;this.nodos[91]= nodo91;this.nodos[92]= nodo92;this.nodos[93]= nodo93;this.nodos[94]= nodo94;
        this.nodos[95]= nodo95;this.nodos[96]= nodo96;this.nodos[97]= nodo97;this.nodos[98]= nodo98;this.nodos[99]= nodo99;                
        //Creando la pila de Labels
        this.labels = new Label[100];        
        this.labels[0]= label0;this.labels[1]= label1;this.labels[2]= label2;this.labels[3]= label3;this.labels[4]= label4;
        this.labels[5]= label5;this.labels[6]= label6;this.labels[7]= label7;this.labels[8]= label8;this.labels[9]= label9;
        this.labels[10]= label10;this.labels[11]= label11;this.labels[12]= label12;this.labels[13]= label13;this.labels[14]= label14;
        this.labels[15]= label15;this.labels[16]= label16;this.labels[17]= label17;this.labels[18]= label18;this.labels[19]= label19;
        this.labels[20]= label20;this.labels[21]= label21;this.labels[22]= label22;this.labels[23]= label23;this.labels[24]= label24;
        this.labels[25]= label25;this.labels[26]= label26;this.labels[27]= label27;this.labels[28]= label28;this.labels[29]= label29;
        this.labels[30]= label30;this.labels[31]= label31;this.labels[32]= label32;this.labels[33]= label33;this.labels[34]= label34;
        this.labels[35]= label35;this.labels[36]= label36;this.labels[37]= label37;this.labels[38]= label38;this.labels[39]= label39;
        this.labels[40]= label40;this.labels[41]= label41;this.labels[42]= label42;this.labels[43]= label43;this.labels[44]= label44;
        this.labels[45]= label45;this.labels[46]= label46;this.labels[47]= label47;this.labels[48]= label48;this.labels[49]= label49;
        this.labels[50]= label50;this.labels[51]= label51;this.labels[52]= label52;this.labels[53]= label53;this.labels[54]= label54;
        this.labels[55]= label55;this.labels[56]= label56;this.labels[57]= label57;this.labels[58]= label58;this.labels[59]= label59;
        this.labels[60]= label60;this.labels[61]= label61;this.labels[62]= label62;this.labels[63]= label63;this.labels[64]= label64;
        this.labels[65]= label65;this.labels[66]= label66;this.labels[67]= label67;this.labels[68]= label68;this.labels[69]= label69;
        this.labels[70]= label70;this.labels[71]= label71;this.labels[72]= label72;this.labels[73]= label73;this.labels[74]= label74;
        this.labels[75]= label75;this.labels[76]= label76;this.labels[77]= label77;this.labels[78]= label78;this.labels[79]= label79;
        this.labels[80]= label80;this.labels[81]= label81;this.labels[82]= label82;this.labels[83]= label83;this.labels[84]= label84;
        this.labels[85]= label85;this.labels[86]= label86;this.labels[87]= label87;this.labels[88]= label88;this.labels[89]= label89;
        this.labels[90]= label90;this.labels[91]= label91;this.labels[92]= label92;this.labels[93]= label93;this.labels[94]= label94;
        this.labels[95]= label95;this.labels[96]= label96;this.labels[97]= label97;this.labels[98]= label98;this.labels[99]= label99;        
        for(int i=0; i<100; i++){
            nodos[i].setVisible(false);
            nodos[i].setFill(Color.GREENYELLOW);
            nodos[i].setStroke(Color.GREEN);
            labels[i].setVisible(false);
        }
        this.msg.setLayoutY(450.0);
        this.msg.setVisible(false);        
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
    
    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        try{
        this.simulador = new SimuladorArbolBinario();
        this.lineaTiempo = new Timeline();
        this.abg = new ArbolBinarioG();
        this.pintarTDA();
        this.impNota("El Simulador para ArbolBinario<T> ha iniciado!",0);
        }catch(Exception e){
            this.impNota("El Simulador para ArbolBinario<T> no puede iniciar!",1);
        }
    }
    
    @FXML
    private void inicializar() {
        //Creando la pila de lineas
        this.cargarLineas();
        this.cargarNodos();
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
    private void pintarTDA(){
        try{
            this.inicializar();
            abg.cargarNodos(this.nodos);
            abg.cargarLabels(this.labels);
            abg.cargarLineas(this.lineas);
            abg = this.simulador.crearArbolBinarioGrafico(abg);
            abg.pintarArbol(this.simulador.conocerAltura());    
        }catch(Exception e){
            this.impNota("No se puede pintar la Estructura",1);
        }
    }
    
    
    
}