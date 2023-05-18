package GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;

import Botones.BtVentanaAdmin;
import coneccionBD.Coneccion;
import coneccionBD.ObjProducto;
import coneccionBD.ObjUsuario;
import listasWonderP.EstructuraLista;

public class VentanaAdmin extends JFrame {

    private JButton btEditarP = new JButton("Editar Producto");
    private JButton btEliminarP = new JButton("Eliminar Producto");
    private DefaultTableModel tm = new DefaultTableModel();
    private JScrollPane jsp;
    private String[] colum = { "ID", "NOMBRE", "PRECIO", "CANTIDAD" };
    private JTable tablaP = new JTable();
    private JTable tabla;
    private String[][] matriz;
    private EstructuraLista lista;
    private JLabel bgHuella;
    private JButton btProductos;
    private JPanel panel = new JPanel();
    private JPanel panelPed = new JPanel();
    private JPanel panelG = new JPanel();
    private JButton btPedidos;
    private JButton btBuscarPed;
    private JButton btGestionarU = new JButton("Gestionar Usuarios");
    private JButton btCerrarA = new JButton("Cerrar Sesion");

    public VentanaAdmin() {

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);
        this.setLayout(null);
        /*
         * son CONSTANTES EN UN FRAME.
         * JFrame.NORMAL: Inicializa el JFrame en estado Normal
         * JFrame.ICONIFIED: Inicializa el JFrame en estado Minimizado.
         * JFrame.MAXIMIZED_HORIZ: Inicializa el JFrame en estado Maximizado
         * Horizontalmente
         * JFrame.MAXIMIZED_VERT: Inicializa el JFrame en estado Maximizado
         * Verticalmente
         * JFrame.MAXIMIZED_BOTH: Inicializa el JFrame en estado Maximizado en ambos
         * sentidos
         */
        this.setTitle("Admin.Wonder"); // damos titulo personalizado a la pantalla
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setIconImage(new ImageIcon(getClass().getResource("/image/logo.png")).getImage());
        this.iniciarComponentesAdmin();
    }

    public void iniciarComponentesAdmin() {

        /*
         * int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
         * int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
         */

        JLabel labelogoAdmin = new JLabel();
        labelogoAdmin.setIcon(new ImageIcon(getClass().getResource("/image/logo.png")));
        labelogoAdmin.setVisible(true);
        labelogoAdmin.setBounds((java.awt.Toolkit.getDefaultToolkit().getScreenSize().width) - 300, 10, 240, 160);
        add(labelogoAdmin);

        JLabel Admin = new JLabel();
        Admin.setIcon(new ImageIcon(getClass().getResource("/image/Admin.png")));
        Admin.setVisible(true);
        Admin.setBounds(60, 30, 250, 150);
        add(Admin);

        btPedidos = new JButton("PEDIDOS");
        btPedidos.setBounds(350, 80, 240, 100);
        btPedidos.setVisible(true);
        btPedidos.addActionListener((event) -> {
            accion_btPed();
        });
        panelPed();
        add(panelPed);
        panelPed.setVisible(false);

        add(btPedidos);

        btProductos = new JButton("PRODUCTOS");
        btProductos.setBounds((java.awt.Toolkit.getDefaultToolkit().getScreenSize().width) - 650, 80, 240, 100);
        btProductos.addActionListener((event) -> {
            accion_btP();
        });
        panel();
        panel.setVisible(false);
        add(panel);

        add(btProductos);

        ObjUsuario usuarioObj = Loguin.getObjUsuario();

        JLabel infoUsuario = new JLabel("DATOS DE USUARIO");
        infoUsuario.setVisible(true);
        infoUsuario.setBounds(0, 185, 250, 50);
        add(infoUsuario);
        infoUsuario.setFont(new Font("Comic Sans MS", 6 , 20 ));
        infoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        infoUsuario.setBorder(BorderFactory.createLineBorder(new Color(49, 175, 180)));

        JLabel usuario = new JLabel("USUARIO");
        usuario.setVisible(true);
        usuario.setBorder(BorderFactory.createLineBorder(new Color(49, 175, 180)));
        usuario.setBounds(0, 250, 250, 20);
        add(usuario);

        JLabel nombreUsuario = new JLabel(usuarioObj.getNombre());
        nombreUsuario.setVisible(true);
        nombreUsuario.setBounds(50, 270, 250, 100);
        add(nombreUsuario);

        JLabel idUsuario = new JLabel("ID USUARIO:");
        idUsuario.setVisible(true);
        idUsuario.setBounds(30, 350, 250, 50);
        add(idUsuario);

        JLabel numeroId = new JLabel(usuarioObj.getIdUsuario()+"");
        numeroId.setVisible(true);
        numeroId.setBounds(50, 370, 250, 100);
        add(numeroId);

        JLabel cargoUsuario = new JLabel("CARGO:");
        cargoUsuario.setVisible(true);
        cargoUsuario.setBounds(30, 450, 250, 100);
        add(cargoUsuario);

        JLabel cargo = new JLabel(usuarioObj.getCargo());
        cargo.setVisible(true);
        cargo.setBounds(50, 470, 250, 100);
        add(cargo);

        JLabel emailUsuario = new JLabel("E-mail USUARIO:");
        emailUsuario.setVisible(true);
        emailUsuario.setBounds(30, 550, 250, 100);
        add(emailUsuario);

        JLabel email = new JLabel(usuarioObj.getCorreo());
        email.setVisible(true);
        email.setBounds(50, 570, 250, 100);
        add(email);

        btGestionarU.setBounds(50, 650, 150, 50);
        btGestionarU.setVisible(true);
        btGestionarU.addActionListener((event) -> {
            accion_btgu();
        });
        panelG.setVisible(false);
        add(panelG);
        add(btGestionarU);

        btCerrarA.setBounds(50, 750, 150, 50);
        btCerrarA.setVisible(true);
        btCerrarA.addActionListener((event) -> {
            dispose();
            Loguin loguin = new Loguin();
            loguin.setVisible(true);
        });
        add(btCerrarA);

        bgHuella = new JLabel();
        bgHuella.setIcon(new ImageIcon(getClass().getResource("/image/huellaR.png")));
        
        bgHuella.setBounds(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width/4, java.awt.Toolkit.getDefaultToolkit().getScreenSize().height/3, 700,400);
        add(bgHuella);
        
        bgHuella.setVisible(true);

    }

    public void accion_btgu() {

        btGestionarU.setBackground(new java.awt.Color(49, 175, 180));
        btProductos.setBackground(new JButton().getBackground());

        btPedidos.setBackground(new JButton().getBackground());
        bgHuella.setVisible(false);

        panelPed.setVisible(false);
        panel.setVisible(false);

        btEditarP.setEnabled(false);
        btEliminarP.setEnabled(false);

       
        panelG.setBounds(280, 200, 1100, 600);
        panelG.setLayout(null);

        String[][] dataPG = {
                { "Stiven Manuel Osorno WonderP", "1211858", "AUXILIAR ADMINISTRATIVO", "E-mailUSUARIO@correo.co" } };
        String[] columG = { "NOMBRE", "ID", "CARGO", "CORREO ELECTRONICO" };

        JTable tablaG = new JTable(dataPG, columG);
        tablaG.setBounds(10, 10, 8, 575);
        tablaG.setVisible(true);
        panelG.add(tablaG);

        JScrollPane jsp = new JScrollPane(tablaG);
        jsp.setBounds(10, 10, 850, 575);
        panelG.add(jsp);

        JLabel lbGestionG = new JLabel("Gestionar Usuarios:");
        lbGestionG.setBounds(900, 0, 300, 80);
        lbGestionG.setVisible(true);
        panelG.add(lbGestionG);

        JButton btBuscarG = new JButton("Buscar Usuario");
        btBuscarG.setBounds(890, 100, 150, 80);
        btBuscarG.setVisible(true);
        panelG.add(btBuscarG);

        JButton btAggG = new JButton("Agregar Usuario");
        btAggG.setBounds(890, 200, 150, 80);
        btAggG.setVisible(true);
        panelG.add(btAggG);

        JButton btEditarG = new JButton("Editar Usuario");
        btEditarG.setBounds(890, 300, 150, 80);
        btEditarG.setVisible(true);
        btEditarG.setEnabled(false);
        panelG.add(btEditarG);

        JButton btEliminarG = new JButton("Eliminar Usuario");
        btEliminarG.setBounds(890, 400, 150, 80);
        btEliminarG.setVisible(true);
        btEliminarG.setEnabled(false);
        panelG.add(btEliminarG);

        panelG.setBackground(new java.awt.Color(49, 175, 180));
        panelG.setVisible(true);
    }

    // ______________________________________________________________________________________

    public void accion_btPed() {

        btProductos.setBackground(new JButton().getBackground());
        btPedidos.setBackground(new java.awt.Color(49, 175, 180));
        bgHuella.setVisible(false);
        btGestionarU.setBackground(new JButton().getBackground());
        panelPed.setVisible(true);
        panel.setVisible(false);
        btEditarP.setEnabled(false);
        btEliminarP.setEnabled(false);
    }

    public void accion_btP() {

        btPedidos.setBackground(new JButton().getBackground());
        btProductos.setBackground(new java.awt.Color(49, 175, 180));
        bgHuella.setVisible(false);
        btGestionarU.setBackground(new JButton().getBackground());

        panelPed.setVisible(false);        
        panelG.setVisible(false);

        panel.setVisible(true);

        lista = new Coneccion().registrosProductos();
        matriz = new String[lista.obtenerTamanoLista()][4];

        for (int i = 0; i < lista.obtenerTamanoLista(); i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = lista.obtenerDatoEnPosicionDada(i + 1).getDatoTipoString()[j];

            }

        }

        tm.setDataVector(matriz, colum);
        tablaP.setModel(tm);

        tablaP.setBackground(new ColorUIResource(234, 242, 248));
        
        btEditarP.setEnabled(false);
        btEditarP.setEnabled(false);

    }
    // __________________________________________________________________________________________________

    public void panel() {

        panel.setBounds(280, 200, 1100, 600);
        panel.setLayout(null);

        tablaP.setBounds(10, 10, 8, 575);

        tablaP.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
                btEditarP.setEnabled(true);
                btEliminarP.setEnabled(true);

            }

        });
        tablaP.setVisible(true);

        panel.add(tablaP);

        jsp = new JScrollPane(tablaP);
        jsp.setBounds(10, 10, 850, 575);
        panel.add(jsp);

        JLabel lbGestionP = new JLabel("Gestionar productos:");
        lbGestionP.setBounds(900, 0, 300, 80);
        lbGestionP.setVisible(true);
        panel.add(lbGestionP);

        JButton btBuscarP = new JButton("Buscar Producto");
        btBuscarP.setBounds(890, 100, 150, 80);
        btBuscarP.addActionListener((event) -> {


            try {
                
            String respuesta = JOptionPane.showInputDialog(null,
                    "Elija:\n1 - Para buscar por ID de producto\n2 - Para buscar por NOMBRE de producto");
            switch (respuesta) {

                case "1": {

                    ObjProducto objP = new BtVentanaAdmin().btBuscarProducto();
                    if (objP.getNombreProducto() == null | objP.getIdProducto() == 0) {
                        JOptionPane.showMessageDialog(null, "no existe un producto con este id");
                    } else {
                        
                        accion_btP();
                        int posicion = new Coneccion().posicionEnLaTabla(objP.getIdProducto());
                        tablaP.addRowSelectionInterval(posicion,posicion);
                        btEliminarP.setEnabled(true);
                        btEditarP.setEnabled(true); 
                    }
                    break;
                }
                case "2": {
                    
                    ObjProducto objP = new BtVentanaAdmin().btBuscarProducto("Buscar por NOMBRE");
                    if (objP.getIdProducto() == 0) {
                       
                        JOptionPane.showMessageDialog(null, "no existe un producto con este NOMBRE");
                    } else {
                      
                        accion_btP();
                        int posicion = new Coneccion().posicionEnLaTabla(objP.getIdProducto());
                        tablaP.addRowSelectionInterval(posicion,posicion);
                     
                        btEditarP.setEnabled(true); 
                    }
                    break;

                }
            }

        } catch (NullPointerException e) {
                
        }

        });

        btBuscarP.setVisible(true);
        panel.add(btBuscarP);

        JButton btAggP = new JButton("Agregar Producto");
        btAggP.setBounds(890, 200, 150, 80);
        btAggP.setVisible(true);
        btAggP.addActionListener((event) -> {

            if (new BtVentanaAdmin().btAggProductos()) {
                accion_btP();
                btEliminarP.setEnabled(false);
                btEditarP.setEnabled(false);
            }

        });
        panel.add(btAggP);

        btEditarP.setBounds(890, 300, 150, 80);
        btEditarP.setVisible(true);
        btEditarP.setEnabled(false);
        btEditarP.addActionListener((event)->{
            int row = tablaP.getSelectedRow();


            ObjProducto productoAeditar = new ObjProducto();
            
            productoAeditar.setIdProducto(Integer.parseInt(tablaP.getValueAt(row, 0).toString()));
            productoAeditar.setNombreProducto(tablaP.getValueAt(row, 1).toString());
            productoAeditar.setPrecio(Float.parseFloat(tablaP.getValueAt(row, 2).toString()));
            productoAeditar.setCantidad(Float.parseFloat(tablaP.getValueAt(row, 3).toString()));

            String respuesta;
            ObjProducto objProducto = new ObjProducto();

            while(true ){


                respuesta = JOptionPane.showInputDialog(null, "¿Que DATO desea EDITAR del producto?\n"
                                + productoAeditar.toString() + "\n1 - ID\n2 - NOMBRE\n3 - PRECIO\n4 - CANTIDAD");
    
                if(respuesta == null){
    
                    break;
    
                }else{
    
                    if (respuesta.equals("")){
    
                        JOptionPane.showMessageDialog(null, "campo vacio.");
                        continue;
    
                    }else{
    
                        if(respuesta.equals("1")|respuesta.equals("2")|respuesta.equals("3")|respuesta.equals("4") ){
                            
                            objProducto = new BtVentanaAdmin().btEditarProductos(productoAeditar, respuesta);
                            accion_btP();
                            String editarMas = JOptionPane.showOptionDialog(null,"Se EDITO correctamente.\nDesea EDITAR mas datos del producto ","EDITAR producto ?",0,3,null,null,null)+"";
                                                 
                            if (editarMas.equals("0")) {

                                continue;
                                
                            }else{

                                break;

                            }
   
                        }else{

                            break;
                        }
    
                    }
                }
            }
           
            accion_btP();
            tablaP.addRowSelectionInterval(new Coneccion().posicionEnLaTabla(objProducto.getIdProducto()),new Coneccion().posicionEnLaTabla(objProducto.getIdProducto()));
            btEliminarP.setEnabled(true);
            btEditarP.setEnabled(true);


        });
        panel.add(btEditarP);

        btEliminarP.setBounds(890, 400, 150, 80);
        btEliminarP.setVisible(true);
        btEliminarP.addActionListener((event)->{
            
           
            int row = tablaP.getSelectedRow();


            ObjProducto productoAEliminar = new ObjProducto();
           
            productoAEliminar.setIdProducto(Integer.parseInt(tablaP.getValueAt(row, 0).toString()));
            productoAEliminar.setNombreProducto(tablaP.getValueAt(row, 1).toString());
            productoAEliminar.setPrecio(Float.parseFloat(tablaP.getValueAt(row, 2).toString()));
            productoAEliminar.setCantidad(Float.parseFloat(tablaP.getValueAt(row, 3).toString()));

            int confirmacion = JOptionPane.showOptionDialog(null, "Esta seguro que desea ELIMINAR el producto:\n" + productoAEliminar.toString(),"PRECAUCION.",0,2,null,null,null);
 
            if(confirmacion == 0){

                if(new Coneccion().eliminarProducto(productoAEliminar)){

                    accion_btP();

                    JOptionPane.showMessageDialog(null, "SE ELIMINO CORRECTAMENTE EL PRODUCTO.");

                    
                    tablaP.addRowSelectionInterval(new Coneccion().posicionEnLaTabla(productoAEliminar.getIdProducto()),new Coneccion().posicionEnLaTabla(productoAEliminar.getIdProducto()));
                    
                    btEliminarP.setEnabled(true);
                    btEditarP.setEnabled(true);

                }
            }
            

        });
        btEliminarP.setEnabled(false);
        panel.add(btEliminarP);

        panel.setBackground(new java.awt.Color(49, 175, 180));
        panel.setVisible(true);
    }

    public void panelPed() {

        panelPed.setBounds(280, 200, 1100, 600);
        panelPed.setLayout(null);

        String[][] data = {

                { "1231321", "Kundan Kumar Jha", "kr33#73-33", "EN REPARTO", "QR" },
                { "2136818", "Anand Jha", "CL99#60-14", "ENTREGADO", "TRANSFERENCIA" },
                { "Id", "Kundan Kumar Jha", "4031", "CANCELADO", "CONTADO" },
                { "Id", "Anand Jha", "6014", "IT", "TARJETA" },
                { "1231321", "Kundan Kumar Jha", "kr33#73-33", "EN REPARTO", "QR" },
                { "2136818", "Anand Jha", "CL99#60-14", "ENTREGADO", "TRANSFERENCIA" },
                { "Id", "Kundan Kumar Jha", "4031", "CANCELADO", "CONTADO" },
                { "Id", "Anand Jha", "6014", "IT", "TARJETA" },
                { "1231321", "Kundan Kumar Jha", "kr33#73-33", "EN REPARTO", "QR" },
                { "2136818", "Anand Jha", "CL99#60-14", "ENTREGADO", "TRANSFERENCIA" },
                { "Id", "Kundan Kumar Jha", "4031", "CANCELADO", "CONTADO" },
                { "Id", "Anand Jha", "6014", "IT", "TARJETA" },
                { "1231321", "Kundan Kumar Jha", "kr33#73-33", "EN REPARTO", "QR" },
                { "2136818", "Anand Jha", "CL99#60-14", "ENTREGADO", "TRANSFERENCIA" },
                { "Id", "Kundan Kumar Jha", "4031", "CANCELADO", "CONTADO" },
                { "Id", "Anand Jha", "6014", "IT", "TARJETA" },
                { "1231321", "Kundan Kumar Jha", "kr33#73-33", "EN REPARTO", "QR" },
                { "2136818", "Anand Jha", "CL99#60-14", "ENTREGADO", "TRANSFERENCIA" },
                { "Id", "Kundan Kumar Jha", "4031", "CANCELADO", "CONTADO" },
                { "Id", "Anand Jha", "6014", "IT", "TARJETA" },
                { "1231321", "Kundan Kumar Jha", "kr33#73-33", "EN REPARTO", "QR" },
                { "2136818", "Anand Jha", "CL99#60-14", "ENTREGADO", "TRANSFERENCIA" },
                { "Id", "Kundan Kumar Jha", "4031", "CANCELADO", "CONTADO" },
                { "Id", "Anand Jha", "6014", "IT", "TARJETA" },
                { "1231321", "Kundan Kumar Jha", "kr33#73-33", "EN REPARTO", "QR" },
                { "2136818", "Anand Jha", "CL99#60-14", "ENTREGADO", "TRANSFERENCIA" },
                { "Id", "Kundan Kumar Jha", "4031", "CANCELADO", "CONTADO" },
                { "Id", "Anand Jha", "6014", "IT", "TARJETA" },
                { "1231321", "Kundan Kumar Jha", "kr33#73-33", "EN REPARTO", "QR" },
                { "2136818", "Anand Jha", "CL99#60-14", "ENTREGADO", "TRANSFERENCIA" },
                { "Id", "Kundan Kumar Jha", "4031", "CANCELADO", "CONTADO" },
                { "Id", "Anand Jha", "6014", "IT", "TARJETA" },
                { "1231321", "Kundan Kumar Jha", "kr33#73-33", "EN REPARTO", "QR" },
                { "2136818", "Anand Jha", "CL99#60-14", "ENTREGADO", "TRANSFERENCIA" },
                { "Id", "Kundan Kumar Jha", "4031", "CANCELADO", "CONTADO" },
                { "Id", "Anand Jha", "6014", "IT", "TARJETA" },
                { "1231321", "Kundan Kumar Jha", "kr33#73-33", "EN REPARTO", "QR" },
                { "2136818", "Anand Jha", "CL99#60-14", "ENTREGADO", "TRANSFERENCIA" },
                { "Id", "Kundan Kumar Jha", "4031", "CANCELADO", "CONTADO" },
                { "Id", "Anand Jha", "6014", "IT", "TARJETA" },
                { "1231321", "Kundan Kumar Jha", "kr33#73-33", "EN REPARTO", "QR" },
                { "2136818", "Anand Jha", "CL99#60-14", "ENTREGADO", "TRANSFERENCIA" },
                { "Id", "Anand Jha", "6014", "IT", "TARJETA" },

        };

        String[] columnNames = { "ID", "Name Cliente", "Direccion", "Estado Entrega", "Medio de Pago" };

        tabla = new JTable(data, columnNames);
        tabla.setBounds(10, 10, 900, 575);
        tabla.setVisible(true);
        panelPed.add(tabla);
        JScrollPane sp = new JScrollPane(tabla);
        sp.setBounds(10, 10, 900, 575);
        panelPed.add(sp);
        panelPed.setVisible(true);

        JButton btAggPed = new JButton("Agregar Pedido");
        btAggPed.setBounds(930, 200, 150, 80);
        btAggPed.setVisible(true);
        panelPed.add(btAggPed);

        btBuscarPed = new JButton("Buscar Pedido");
        btBuscarPed.setBounds(930, 350, 150, 80);
        btBuscarPed.setVisible(true);
        panelPed.add(btBuscarPed);

        panelPed.setBackground(new java.awt.Color(49, 175, 180));
        add(panelPed);

    }

}
