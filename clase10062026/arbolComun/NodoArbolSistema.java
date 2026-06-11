package arbolComun;
import java.util.List;
import java.util.ArrayList;
public class NodoArbolSistema {
    private String nombre;
    private boolean esCarpeta;
    private NodoArbolSistema padre;
    private List<NodoArbolSistema> hijos;
//constructor
    public NodoArbolSistema(String nombre, boolean esCarpeta) {
        this.nombre = nombre;
        this.esCarpeta = esCarpeta;
        this.hijos = new ArrayList<>();
    }
    //setters y getters
    public String getNombre() {
        return nombre;
    }
    public boolean esCarpeta() {
        return esCarpeta;
    }
    public NodoArbolSistema getPadre() {
        return padre;
    }
    public List<NodoArbolSistema> getHijos() {
        return hijos;
    }
    public void setPadre(NodoArbolSistema padre) {
        this.padre = padre;
    }
   public void agregarHijo(NodoArbolSistema hijo) {

    if(!esCarpeta) {
        throw new IllegalStateException(
                "No se pueden agregar hijos a un archivo");
    }

    hijo.setPadre(this);

    hijos.add(hijo);
}
  public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEsCarpeta(boolean esCarpeta) {
        this.esCarpeta = esCarpeta;
    }   
}
