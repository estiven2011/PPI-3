package GUI;

import javax.swing.*;



public class Repartidor extends JFrame {
    
    public Repartidor(){
        setSize(1000, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        setTitle("Repartidor.Wonder"); // damos titulo personalizado a la pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setIconImage(new ImageIcon("image/deliveryIcono.png").getImage());
        
        JLabel labelogoRepartidor = new JLabel();
        labelogoRepartidor.setIcon(new ImageIcon("image/logoAdmin.png"));
        labelogoRepartidor.setVisible(true);
        labelogoRepartidor.setBounds((java.awt.Toolkit.getDefaultToolkit().getScreenSize().width) - 330, 10, 250, 150);
        add(labelogoRepartidor);

        JLabel delivery = new JLabel();
        delivery.setIcon(new ImageIcon("image/deliveryR.png"));
        delivery.setVisible(true);
        delivery.setBounds(50, 10, 250, 150);
        add(delivery);

        JLabel r = new JLabel("REPARTIDOR");
        r.setVisible(true);
        r.setBounds(650, 10, 250, 150);
        add(r);

        JLabel infoUsuarioD = new JLabel("DATOS DE USUARIO");
        infoUsuarioD.setVisible(true);
        infoUsuarioD.setBounds(65, 185, 250, 100);
        add(infoUsuarioD);

        JLabel usuarioD = new JLabel("NOMBRE USUARIO:");
        usuarioD.setVisible(true);
        usuarioD.setBounds(30, 250, 250, 100);
        add(usuarioD);

        JLabel nombreUsuarioD = new JLabel("Manuel WonderP");
        nombreUsuarioD.setVisible(true);
        nombreUsuarioD.setBounds(50, 270, 250, 100);
        add(nombreUsuarioD);

        JLabel idUsuarioD = new JLabel("ID USUARIO:");
        idUsuarioD.setVisible(true);
        idUsuarioD.setBounds(30, 350, 250, 100);
        add(idUsuarioD);

        JLabel numeroIdD = new JLabel("1211858");
        numeroIdD.setVisible(true);
        numeroIdD.setBounds(110, 370, 250, 100);
        add(numeroIdD);

        JLabel cargoUsuarioD = new JLabel("CARGO:");
        cargoUsuarioD.setVisible(true);
        cargoUsuarioD.setBounds(30, 450, 250, 100);
        add(cargoUsuarioD);

        JLabel cargoD = new JLabel("REPARTIDOR");
        cargoD.setVisible(true);
        cargoD.setBounds(50, 470, 250, 100);
        add(cargoD);

        JLabel emailUsuarioD = new JLabel("E-mail USUARIO:");
        emailUsuarioD.setVisible(true);
        emailUsuarioD.setBounds(30, 550, 250, 100);
        add(emailUsuarioD);

        JLabel emailD = new JLabel("E-mailREPARTIDOR@correo.co");
        emailD.setVisible(true);
        emailD.setBounds(50, 570, 250, 100);
        add(emailD);
            
            String[][] dataR =
            {{ "1231321", "Kundan Kumar Jha", "kr33#73-33", "EN REPARTO", "QR" },
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
            { "Id", "Anand Jha", "6014", "IT", "TARJETA" },};
            String[] columR = {"ID", "Name Cliente", "Direccion", "Estado Entrega", "Medio de Pago"};
            
            JTable tablaR = new JTable(dataR,columR);
            tablaR.setBounds(280, 200,800, 600);
            tablaR.setVisible(true);
            add(tablaR);
            
            JScrollPane jsp = new JScrollPane(tablaR);
            jsp.setBounds(280, 200,800, 600);
            add(jsp);
            
            JLabel lbGestionR = new JLabel("Selecciona un pedido y realizalo");
            lbGestionR.setBounds(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width- 330, 310, 400, 80);
            lbGestionR.setVisible(true);
            add(lbGestionR);
            
            JButton btBuscarR = new JButton("Realizar pedido");
            btBuscarR.setBounds(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width- 300, 410, 150, 80);
            btBuscarR.setVisible(true);
            add(btBuscarR);

            JLabel lbTotalR = new JLabel("Total pedidos realizados en el dia:");
            lbTotalR.setBounds(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width - 330, 510 ,250, 150);
            lbTotalR.setVisible(true);
            add(lbTotalR);
            
            JLabel lbTotal = new JLabel("5");
            lbTotal.setBounds(java.awt.Toolkit.getDefaultToolkit().getScreenSize().width - 230, 610 ,250, 150);
            lbTotal.setVisible(true);
            add(lbTotal);

            JButton btCerrarS = new JButton("Cerrar Sesion");
            btCerrarS.setBounds(50, 705, 150, 80);
            btCerrarS.setVisible(true);
            btCerrarS.addActionListener((event)->{
                dispose();
                Loguin loguin = new Loguin();
                loguin.setVisible(true);
            });
            add(btCerrarS);
    }

}
