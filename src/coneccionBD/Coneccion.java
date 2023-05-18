package coneccionBD;

import java.sql.*;

//import java.util.ArrayList;

import javax.swing.JOptionPane;

import listasWonderP.EstructuraLista;

public class Coneccion {

    private ResultSet resultSet;
    private PreparedStatement statement;
    private Connection conn;
    private String url = "jdbc:mysql://localhost:3306/wonderpetsbd"; 
    private String user = "root";
    private String password = "1234";

    public Coneccion() {

        try {
            
            //Class.forName("com.microsoft.sqlserver.jdbc");
            //Class.forName("com.mysql.jdbc.Driver");
        
            conn = DriverManager.getConnection(url, user, password);
            
        } catch (SQLException  /* | ClassNotFoundException */  e) {

            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos"+"\n"+e);
        }
    } 

    public ObjUsuario btIniciar(ObjUsuario objUsuario) {

        String correo = objUsuario.getCorreo();
        String contrasena  = objUsuario.getContrasena();

        try {

            statement = conn.prepareStatement("SELECT * FROM usuarios WHERE correo = ? AND contrasena = ?");
            statement.setString(1,correo);
            statement.setString(2, contrasena);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Procesar los resultados correo

                objUsuario.setIdUsuario(resultSet.getInt("cedulaUsuario"));
                objUsuario.setNombre(resultSet.getString("nombreUsuario"));
                objUsuario.setCargo(resultSet.getString("cargo"));
                objUsuario.setTelefono(resultSet.getString("telefono"));
            }


        } catch (SQLException | java.lang.NullPointerException e) {
            
            JOptionPane.showMessageDialog(null, e + "\n Base de datos wonderpetsbd no encontrada.");
        }

        return objUsuario;

    }

    // DEBE SER CON LISTAS, PILAS O COLAS.
    /* public ArrayList<String[]> registrosProductos(){
        ArrayList<String[]> a = new ArrayList<String[]>();
        try {
            statement = conn.prepareStatement("SELECT * FROM productos");
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                // Procesar los resultados correo
                String[] s = {resultSet.getInt("idProducto")+"",resultSet.getString("nombreProducto"),resultSet.getDouble("precio")+"",resultSet.getDouble("cantidad")+""};
                a.add(s);
            }

            conn.close();

        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
        return a;

    } */
    public EstructuraLista registrosProductos(){
        EstructuraLista a = new EstructuraLista();
        try {
            statement = conn.prepareStatement("SELECT * FROM productos");
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                // Procesar los resultados correo
                String[] s = {resultSet.getInt("idProducto")+"",resultSet.getString("nombreProducto"),resultSet.getDouble("precio")+"",resultSet.getDouble("cantidad")+""};
                a.insertarAlFinal(null,s);
            }

        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
        return a;

    }

    public ObjProducto btBuscarp(String nombreP){

        ObjProducto objP = new ObjProducto();
        objP.setNombreProducto(nombreP);

        try{
            
            statement = conn.prepareStatement("SELECT * FROM productos WHERE nombreProducto = ?");
            statement.setString(1,objP.getNombreProducto());
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                
                objP.setIdProducto(resultSet.getInt("idProducto"));
                objP.setPrecio(resultSet.getDouble("precio"));
                objP.setCantidad(resultSet.getInt("cantidad"));
            }
            
            /* if(objP.nombreProducto == null){
                JOptionPane.showMessageDialog(null, "no existe un producto con este id" );
                new BtVentanaAdmin().btBuscarProducto(); 
            }else{
                JOptionPane.showMessageDialog(null, objP.toString() );

            } */

        }catch(SQLException e){

            JOptionPane.showMessageDialog(null, "Error BD "+ "\n" + e);
            return objP;

        }
        return objP;

    }

    public ObjProducto btBuscarp(int idP){

        ObjProducto objP = new ObjProducto();
        objP.setIdProducto(idP);

        try{
            
            statement = conn.prepareStatement("SELECT * FROM productos WHERE idProducto = ?");
            statement.setInt(1,idP);
            resultSet = statement.executeQuery();


            while(resultSet.next()){
                
                objP.setNombreProducto(resultSet.getString("nombreProducto"));
                objP.setPrecio(resultSet.getDouble("precio"));
                objP.setCantidad(resultSet.getInt("cantidad"));
            }
            
            /* if(objP.nombreProducto == null){
                JOptionPane.showMessageDialog(null, "no existe un producto con este id" );
                new BtVentanaAdmin().btBuscarProducto(); 
            }else{
                JOptionPane.showMessageDialog(null, objP.toString() );

            } */

        }catch(SQLException e){

            JOptionPane.showMessageDialog(null, "Error BD "+ "\n" + e);
            return objP;

        }
        return objP;

    }

    public boolean btAggProductos(ObjProducto productoAgg){

        boolean resultado;
        
        try{
            
            statement = conn.prepareStatement("INSERT INTO `productos` (`IdProducto`, `nombreProducto`, `precio`, `cantidad`) VALUES (?,?,?,?)");
            statement.setInt(1,productoAgg.getIdProducto());
            statement.setString(2,productoAgg.getNombreProducto().toUpperCase());
            statement.setDouble(3, productoAgg.getPrecio());
            statement.setDouble(4, productoAgg.getCantidad());
            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, " se envio");

            resultado = true;

        }catch(SQLException e){

            JOptionPane.showMessageDialog(null, "No se pudo guardar el producto" + "\n" + e + " ");
            resultado = false;

        }
        
        return resultado;

    }

    public boolean btEditarProductos(ObjProducto productoAeditar){

        boolean resultado = false;
        
        try{

            if(productoAeditar.getIdAnterior() == 0 ){

                statement = conn.prepareStatement("DELETE FROM `productos` WHERE idProducto = ?");
                statement.setInt(1,productoAeditar.getIdProducto());
                /* statement.setString(2,productoAeditar.getNombreProducto().toUpperCase());
                statement.setDouble(3, productoAeditar.getPrecio());
                statement.setDouble(4, productoAeditar.getCantidad()); */
                statement.executeUpdate();
            }else{
                
                statement = conn.prepareStatement("DELETE FROM `productos` WHERE idProducto = ?");
                statement.setInt(1,productoAeditar.getIdAnterior());
                /* statement.setString(2,productoAeditar.getNombreProducto().toUpperCase());
                statement.setDouble(3, productoAeditar.getPrecio());
                statement.setDouble(4, productoAeditar.getCantidad()); */
                statement.executeUpdate();
            }
            

            statement = conn.prepareStatement("INSERT INTO `productos` (`idProducto`, `nombreProducto`, `precio`, `cantidad`) VALUES (?,?,?,?);");
            statement.setInt(1,productoAeditar.getIdProducto());
            statement.setString(2,productoAeditar.getNombreProducto().toUpperCase());
            statement.setDouble(3, productoAeditar.getPrecio());
            statement.setDouble(4, productoAeditar.getCantidad());
            statement.executeUpdate();

            //JOptionPane.showMessageDialog(null, " SE ELIMINO.");

            resultado = true;

        }catch(SQLException e){

            JOptionPane.showMessageDialog(null, "No se pudo EDITAR el producto" + "\n" + e + " ");
            resultado = false;

        }
        
        return resultado;

    }

    public boolean eliminarProducto(ObjProducto productoAeditar){

        boolean resultado = false;
        
        try{

           

            statement = conn.prepareStatement("DELETE FROM `productos` WHERE idProducto = ?");
            statement.setInt(1,productoAeditar.getIdProducto());
            /* statement.setString(2,productoAeditar.getNombreProducto().toUpperCase());
            statement.setDouble(3, productoAeditar.getPrecio());
            statement.setDouble(4, productoAeditar.getCantidad()); */
            statement.executeUpdate();

            resultado = true;

        }catch(SQLException e){

            JOptionPane.showMessageDialog(null, "No se pudo ELIMINAR el producto" + "\n" + e + " ");
            resultado = false;

        }
        
        return resultado;

    }

    public int posicionEnLaTabla(int idP){

        ObjProducto objP = new ObjProducto();
        objP.setIdProducto(idP);
        int i = -1;

        try{
            
            statement = conn.prepareStatement("SELECT * FROM productos");
            
            resultSet = statement.executeQuery();

            
            
            while(resultSet.next()){
                
                objP.setNombreProducto(resultSet.getString("nombreProducto"));
                objP.setPrecio(resultSet.getDouble("precio"));
                objP.setCantidad(resultSet.getInt("cantidad"));
                //JOptionPane.showMessageDialog(null, i);
                i++;
                if(resultSet.getInt("idProducto") == idP){
                    break;
                }
                
            }
            
            /* if(objP.nombreProducto == null){
                JOptionPane.showMessageDialog(null, "no existe un producto con este id" );
                new BtVentanaAdmin().btBuscarProducto(); 
            }else{
                JOptionPane.showMessageDialog(null, objP.toString() );

            } */

        }catch(SQLException e){

            JOptionPane.showMessageDialog(null, "Error BD "+ "\n" + e);
            return -1;

        }
        return i;
    }

}
