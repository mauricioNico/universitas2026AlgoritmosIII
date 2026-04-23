package tp_poo.personas;

public class DNI {
    private String numero;
    private String tramite;

    public DNI(String numero, String tramite) {
        this.numero = numero;
        this.tramite = tramite;
    }

    public String getNumero() {
        return numero;
    }
    public String getTramite() {
        return tramite;
    }
}
