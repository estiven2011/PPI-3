package GUI;

import java.awt.Desktop;
import java.awt.Image;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;

import coneccionBD.Coneccion;
import coneccionBD.ObjUsuario;

public class Loguin extends JFrame {

    static ObjUsuario obj = null;

    Desktop link;
    private JTextField usuario;
    ImageIcon icon;
    Image image;


    public Loguin() { // Constructor del la clase Loguin

        
        iniciarComponentes();

    }

    private void iniciarComponentes() {

        setSize(340, 700);// Establecemos el tamaño de la pantalla.
        setLayout(null);

        setTitle("Wonder"); // damos titulo personalizado a la pantalla
        setDefaultCloseOperation(EXIT_ON_CLOSE);// usamos la constante para el comportamientos del boton "cerrar"
                                                     // de las ventanas

        setResizable(false);// deshabilitamos la opcion de maximizar la pantalla
        /*
         * ImageIcon Image = new ImageIcon("image/logo.png");//creamo un objeto de tipo
         * ImagenIcon con la ruta de la imagen que queremos usar
         * Image image = Image.getImage();//utilizamos getImage() de ImageIcon para
         * convertir Image a un tipo Image y se guarda en la variable image
         * this.setIconImage(image);//se pasa la imagen en una variable de tipo Image.
         */

        // lo de arriba es lo mismo que la siguiente instruccion.
        

        //setIconImage(new ImageIcon("image/logo.png").getImage());// se pasa la imagen en una variable de tipo Image
                                                                      // y setIconImage() la establece como imagen icono
                                                                      // de la ventana.
        
        icon = new ImageIcon(getClass().getResource("/image/logo.png"));

        //icon = new ImageIcon("image/logo.png");
        image = icon.getImage();

        setIconImage(image);
        /*
         * JPanel entorno = new JPanel();
         * entorno.setLayout(getLayout());
         * entorno.setVisible(true);
         */

        JLabel labelogo = new JLabel();
        labelogo.setIcon(new ImageIcon(getClass().getResource("/image/logo.png")));
        labelogo.setVisible(true);
        labelogo.setBounds(40, 10, 250, 150);
        add(labelogo);

        JLabel texInicie = new JLabel("INICIE SU SESION.");
        texInicie.setVisible(true);
        texInicie.setBounds(120, 160, 300, 150);
        add(texInicie);

        JLabel texUsuario = new JLabel("USUARIO:");
        texUsuario.setVisible(true);
        texUsuario.setBounds(135, 195, 250, 200);
        add(texUsuario);

        usuario = new JTextField();
        usuario.setVisible(true);
        usuario.setBounds(10, 310, 300, 30);
        add(usuario);

        JLabel texPass = new JLabel("CONTRASEÑA:");
        texPass.setVisible(true);
        texPass.setBounds(125, 290, 250, 150);
        add(texPass);

        JPasswordField pass = new JPasswordField();
        pass.setVisible(true);
        pass.setBounds(10, 380, 300, 30);
        add(pass);

        JButton btIniciar = new JButton("INICIAR");
        btIniciar.setVisible(true);
        btIniciar.setBounds(10, 450, 300, 50);
        btIniciar.addActionListener((event) -> {
            // Aquí es donde se ejecuta la acción del botón
            ObjUsuario objUsuario = new ObjUsuario();

            objUsuario.setCorreo(usuario.getText());

            char[] contra = pass.getPassword();
            String c = new String(contra);

            objUsuario.setContrasena(c);

            if (!(usuario.getText().equals("")) & !(c.equals(""))) {

                obj = new Coneccion().btIniciar(objUsuario);

                if(obj.getIdUsuario() == 0){

                    JOptionPane.showMessageDialog(null, "El usuario NO EXISTE");

                }else{

                    if ( objUsuario.getCargo().equals("Administrador")){

                        new VentanaAdmin().setVisible(true);
                        setVisible(false);
    
                    }else{
    
                        if (objUsuario.getCargo().equals("Repartidor")) {
    
                            new Repartidor().setVisible(true);
                            setVisible(false);
    
                        }
                    } 
                    
                }             
            }else{
                
                JOptionPane.showMessageDialog(null, "Ningun campo NO puede estar vacio");
            }
    
        });

        add(btIniciar);

        JButton btAcercade = new JButton("Acerca de...");
        btAcercade.setVisible(true);
        btAcercade.setBounds(10, 550, 300, 50);
        btAcercade.addActionListener((event) -> {
            JOptionPane.showMessageDialog(btAcercade,
                    "Se abrira un LINK donde encontrara toda\nla informacion sobre WonderPets");
            abrirlink();
        });
        add(btAcercade);
    }

    private Desktop abrirlink() {
        link = Desktop.getDesktop();
        try {
            link.browse(new URI(
                    "https://docs.google.com/document/d/1qYJ2diUtQClkHvJvs2sftcotPwD6ikw4YYrjtrF7Ets/edit?usp=sharing"));
        } catch (IOException e) {

            e.printStackTrace();
        } catch (URISyntaxException e) {

            e.printStackTrace();
        }
        return link;
    }

    public static ObjUsuario getObjUsuario() {

        return obj;
    }

}
