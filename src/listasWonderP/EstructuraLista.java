package listasWonderP;

import javax.swing.*;

public class EstructuraLista {

    Nodo cabeza = new Nodo();
    Nodo cola = new Nodo();

    public EstructuraLista(){
        cabeza = null;
        cola = null;
    }

    public void insertarAlFinal(Object obj, String[] vector){

        Nodo nodoNuevo = new Nodo(obj);
        nodoNuevo.setDatoTipoString(vector);

        //JOptionPane.showMessageDialog(null, nodoNuevo.dato);

        if(cabeza == null){
            cabeza = nodoNuevo;
            cabeza.setSiguiente(null);
            cola = nodoNuevo;
            //JOptionPane.showMessageDialog(null, "la lista estaba vacia y se agrego como primer y unico elemento");
            //JOptionPane.showMessageDialog(null, cabeza.dato +" ");
            /* if(cola.siguiente == null){
                System.out.println(cola +"es null el siguiente");
            } */
        }else{
            //JOptionPane.showMessageDialog(null, "La lista ya contenia datos");
            //JOptionPane.showMessageDialog(null, cabeza.dato+" ");
            cola.setSiguiente(nodoNuevo);
            nodoNuevo.setSiguiente(null);
            cola = nodoNuevo;
            
            
            //JOptionPane.showMessageDialog(null, cabeza.dato + "\n " + cola.dato+"");
        }
    }

    public void insertarAlInicio(Object obj, String[] vector){

         Nodo nuevoNodo = new Nodo(obj);
         nuevoNodo.setDatoTipoString(vector);

         if(cabeza == null){

            cabeza = nuevoNodo;
            cabeza.setSiguiente(null);
            cola = nuevoNodo;
          
        }else{
            nuevoNodo.setSiguiente(cabeza);
            cabeza = nuevoNodo;
        }


    }

    public void buscarDato(){

        Nodo aux = cabeza;
        boolean bandera  =  false;

        if(aux == null){
            JOptionPane.showMessageDialog(null, "lista vacia");
        }else{
            Object datoAbuscar = JOptionPane.showInputDialog(null, "ingrese el dato a buscar");
            while(aux != null & bandera != true ){
                if(aux.getDato().equals(datoAbuscar)){
                    datoAbuscar = aux.getDato();
                    JOptionPane.showMessageDialog(null, "se encontro el dato solicitado" + datoAbuscar);
                    bandera = true;
                }
                aux = aux.getSiguiente();
            }
            if(bandera == false){
                JOptionPane.showMessageDialog(null,"No se encontro un nodo con el dato ingresado");
            }
        }
    }

    public void imprimirLista(){

        Nodo aux = cabeza;


        if (aux == null){
            JOptionPane.showMessageDialog(null, "lista vacia");
        }else{
            String x = "";
            while(aux != null){
                //JOptionPane.showMessageDialog(null, "" + aux.dato);
                x += aux.getDato() + "\n";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, x);
        }   
    }

    public int obtenerTamanoLista(){

        Nodo aux = cabeza;


        if (aux == null){
            return 0;
        }else{
            int x = 0;
            while(aux != null){
                //JOptionPane.showMessageDialog(null, "" + aux.dato);
                x += 1;
                aux = aux.getSiguiente();
            }
            return x;
        }

    }

    public Nodo obtenerDatoEnPosicionDada(int posicion){
        Nodo aux = cabeza;


        if (aux == null){
            return null;
        }else{
            int x = 0;
            Nodo obj = null;
            while(aux != null && x != posicion){
                //JOptionPane.showMessageDialog(null, "" + aux.dato);
                x += 1;
                obj = aux;
                aux = aux.getSiguiente();
            }
            
            return obj ;
        }

    }
}

