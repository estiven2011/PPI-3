package listasWonderP;

public class Nodo {

    private Object dato;
    private Nodo siguiente;
    private String[] datoTipoString;

    public Nodo(Object dato) {
        setDato(dato); 
        setSiguiente(null);
    }

    public Nodo() {
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public String[] getDatoTipoString() {
        return datoTipoString;
    }

    public void setDatoTipoString(String[] datoTipoString) {
        this.datoTipoString = datoTipoString;
    }
}
