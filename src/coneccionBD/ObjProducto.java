package coneccionBD;

public class ObjProducto {

    private int idProducto;
    private int idAnterior;
    private String nombreProducto;
    private double precio;
    private double cantidad;
    

    public ObjProducto(){}

    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public double getCantidad() {
        return cantidad;
    }
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "idProducto=" + idProducto + "\n nombreProducto=" + nombreProducto + "\n precio=" + precio
                + "\n cantidad=" + cantidad;
    }

    public int getIdAnterior() {
        return idAnterior;
    }

    public void setIdAnterior(int idAnterior) {
        this.idAnterior = idAnterior;
    } 
    
}
