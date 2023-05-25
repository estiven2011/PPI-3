package Botones;

import javax.swing.JOptionPane;

import coneccionBD.Coneccion;
import coneccionBD.ObjProducto;

public class BtVentanaAdmin {

    public BtVentanaAdmin() {
    }

    public ObjProducto btBuscarProducto(String buscarXnombre) {

        ObjProducto objP = new ObjProducto();

        String nombreP = "";

        while (true) {
            try {
                nombreP = JOptionPane.showInputDialog("Ingrese el Nombre del Producto");

              
                
                if (nombreP.equals("")) {

                    JOptionPane.showMessageDialog(null, "El campo no puede estar vacio.");
                    continue;

                } else {

                    objP = new Coneccion().btBuscarp(nombreP);
                    break;
                }

            } catch (NullPointerException e) {
                break;
            }
        }

        return objP;

    }

    public ObjProducto btBuscarProducto() {

        String idP = "";
        ObjProducto objP = new ObjProducto();

        while (true) {
            try {
                idP = JOptionPane.showInputDialog("Ingrese el ID del Producto");

                if (idP.equals("")) {

                    JOptionPane.showMessageDialog(null, "El campo no puede estar vacio.");
                    continue;

                } else {
                    try {

                        objP = new Coneccion().btBuscarp(Integer.parseInt(idP));
                        break;

                    } catch (NumberFormatException e) {

                        JOptionPane.showMessageDialog(null, "Solo se permiten datos numericos." + e);
                        continue;
                    }
                }

            } catch (NullPointerException e) {
                break;
            }

        }
        return objP;

    }

    public boolean btAggProductos() {

        boolean respuesta = false;

        ObjProducto productoNuevo = new ObjProducto();
        String idP;

        String nombreProducto;
        String precio;
        String cantidad;

        try {

            while (true) {

                try {
                    idP = JOptionPane.showInputDialog(null, "Ingrese un ID unico para el producto.");
                    if (idP.equals("")) {

                        JOptionPane.showMessageDialog(null, "Debe ingresar un dato");
                        continue;
                    }

                    try {

                        int id = Integer.parseInt(idP);

                        ObjProducto objP = new Coneccion().btBuscarp(id);

                        if (objP.getNombreProducto() != null) {
                            JOptionPane.showMessageDialog(null, "Ya existe este ID");
                            continue;
                        } else {

                            productoNuevo.setIdProducto(id);
                            break;
                        }

                    } catch (NumberFormatException e) {

                        JOptionPane.showMessageDialog(null, "Solo se permiten datos numericos." + e);
                        continue;
                    }
                } catch (NullPointerException e) {
                    respuesta = false;
                    return respuesta;
                }
            }

            while (true) {

                nombreProducto = JOptionPane.showInputDialog(null, "Ingrese un NOMBRE unico para el producto.");

                if (nombreProducto == null) {

                    respuesta = false;
                    return respuesta;

                } else {

                    if (nombreProducto.equals("")) {

                        JOptionPane.showMessageDialog(null, "El campo no puede estar vacio.");
                        continue;

                    } else {

                        ObjProducto objP = new Coneccion().btBuscarp(nombreProducto);

                        if (objP.getIdProducto() == 0) {

                            productoNuevo.setNombreProducto(nombreProducto);
                            break;

                        } else {

                            JOptionPane.showMessageDialog(null, "Ya existe este NOMBRE");
                            continue;
                        }
                    }
                }
            }

            while (true) {

                try {
                    precio = JOptionPane.showInputDialog(null, "Ingrese el precio el producto.");

                    if (precio.equals("")) {

                        JOptionPane.showMessageDialog(null, "Debe ingresar un dato");
                        continue;
                    }

                    try {

                        productoNuevo.setPrecio(Float.parseFloat(precio));
                        break;

                    } catch (NumberFormatException e) {

                        JOptionPane.showMessageDialog(null, "Solo se permiten datos numericos." + e);
                        continue;
                    }
                } catch (NullPointerException e) {
                    respuesta = false;
                    return respuesta;
                }

            }

            while (true) {
                try {
                    cantidad = JOptionPane.showInputDialog(null, "Ingrese la cantidad del producto.");
                    if (cantidad.equals("")) {

                        JOptionPane.showMessageDialog(null, "Debe ingresar un dato");
                        continue;
                    }

                    try {

                        productoNuevo.setCantidad(Float.parseFloat(cantidad));

                        break;
                    } catch (NumberFormatException e) {

                        JOptionPane.showMessageDialog(null, "Solo se permiten datos numericos." + e);
                        continue;
                    }
                } catch (NullPointerException e) {
                    respuesta = false;
                    return respuesta;
                }
            }

            if (new Coneccion().btAggProductos(productoNuevo)) {
                respuesta = true;
            }

            return respuesta;

        } catch (NullPointerException e) {

            respuesta = false;
            return respuesta;
        }

    }

    public ObjProducto btEditarProductos(ObjProducto productoAeditar, String respuesta) {

        ObjProducto validarExistencia = null;
        int idNueva = 0;

        while (true) {

            switch (respuesta) {
                case "1": {

                    String idProducto = JOptionPane.showInputDialog(null, "ingrese el nuevo id.");

                    if (idProducto == null) {

                        return productoAeditar;

                    } else {
                        try {

                            idNueva = Integer.parseInt(idProducto);

                        } catch (NumberFormatException e) {

                            JOptionPane.showMessageDialog(null, "Solo datos numericos.");
                            continue;

                        }

                        validarExistencia = new Coneccion().btBuscarp(idNueva);

                        if (validarExistencia.getNombreProducto() != null) {
                            JOptionPane.showMessageDialog(null, "Ya existe este ID, dijite un ID diferente.");

                            continue;
                        } else {

                            productoAeditar.setIdAnterior(productoAeditar.getIdProducto());
                            productoAeditar.setIdProducto(idNueva);
                            new Coneccion().btEditarProductos(productoAeditar);
                            return productoAeditar;
                        }
                    }

                }
                case "2": {
                    try {
                        String nuevoNombreProducto = JOptionPane.showInputDialog(null, "Ingrese el NOMBRE NUEVO");
                        if (nuevoNombreProducto.equals("")) {
                            continue;
                        }
                        validarExistencia = new Coneccion().btBuscarp(nuevoNombreProducto);

                        if (validarExistencia.getNombreProducto() != null) {
                            
                            productoAeditar.setNombreProducto(nuevoNombreProducto);
                            productoAeditar.setIdAnterior(0);
                            new Coneccion().btEditarProductos(productoAeditar);
                            return productoAeditar;

                        } else {
                            
                            JOptionPane.showMessageDialog(null, "Ya existe este ID, dijite un ID diferente.");

                            continue;
                           
                        }

                    } catch (NullPointerException e) {

                        return productoAeditar;
                    }

                }
                case "3": {

                    while (true) {

                        String precio = JOptionPane.showInputDialog(null, "Ingrese el nuevo PRECIO del producto.");
                        if (precio == null) {
                            return productoAeditar;
                        } else {
                            try {

                                productoAeditar.setPrecio(Double.parseDouble(precio));
                                new Coneccion().btEditarProductos(productoAeditar);
                                return productoAeditar;

                            } catch (NumberFormatException e) {

                                JOptionPane.showMessageDialog(null, "Solo datos numericos.");
                                continue;

                            }
                        }

                    }

                }
                case "4": {

                    while (true) {

                        String cantidad = JOptionPane.showInputDialog(null, "Ingrese la nueva CANTIDAD de producto.");
                        if (cantidad == null) {
                            return productoAeditar;
                        } else {

                            try {
                                productoAeditar.setCantidad(Double.parseDouble(cantidad));
                                new Coneccion().btEditarProductos(productoAeditar);
                                return productoAeditar;

                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Solo datos numericos.");
                                continue;
                            }

                        }

                    }

                }
            }
        }
    }

}