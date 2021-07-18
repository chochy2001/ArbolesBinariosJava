
/**
 *
 * @author Jorge Salgado Miranda
 * @version 1.0.0
 *
 */

public class Nodo {//Clase para poder crear un nodo
    
    int valor; //Valor del nodo
    //Como es un Arbol Binario, tiene dos nodos, izquierda y derecha
    Nodo izq;  //Nodo izquierda
    Nodo der;  //Nodo derecho

    //Creamos los diferentes tipos de constructores de los nodos

    public Nodo(){
        izq=der=null;
    } //Se inicializan los nodos tanto derecha como izquierda en null

    public Nodo(int data){// Constructor que recibe el valor para crear un nodo con valor
        this(data,null,null); //Se le asigna el valor al nodo en la variable valor
    }
    public Nodo(int data, Nodo lt, Nodo rt){//Constructor del nodo que recibe tanto el valor, como los nodos izquiero y derecho.
        //Se hacen las asignaciones de los valores hacia el nodo
        valor=data;
        izq = lt;
        der = rt;
    }
    
    public void setIzq(Nodo izq) { //Metodo que sirve para seleccionar el nodo izquierdo (Cambia el nodo al que apunda el izquierdo)
        this.izq = izq;
    }
    
    public void setDer(Nodo der) {//Metodo que sirve para seleccionar el nodo derecho (Cambia el nodo al que apunda el derecho)
        this.der = der;
    }
}
