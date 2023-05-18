package coneccionBD;

public class ObjUsuario {


    private int idUsuario;
    private String nombre;
    private String cargo;
    private String correo;
    private String telefono;
    private String contrasena;

    @Override
    public String toString() {
        return "idUsuario= " + idUsuario + ", nombre =\n" + nombre + ", cargo =\n" + cargo + ", correo =\n" + correo
                + " telefono =\n" + telefono + " contrasena =\n" + contrasena ;
    }

    public ObjUsuario(){}
    
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
}
