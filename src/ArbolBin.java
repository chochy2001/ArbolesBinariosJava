
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Jorge Salgado Miranda
 * @version 1.0.0
 *
 */

public class ArbolBin { //Clase para crear la implementacion del arbol Binario
    Nodo root;//Creamos un nuevo nodo llamado raiz, del que vamos a partir para agregar las diferentes implementaciones

    //Creamos los distintos constructores del arbol binario
    public ArbolBin(){//Constructor vacio con su raiz inicializada en null
        root=null;
    }
    
    public ArbolBin(int val){
        //Constructor vacion con su raiz asignada a un nuevo nodo pasandole el valor que el usuario le asigne
        root=new Nodo(val);//Se crea un nuevo nodo con el valor que se le pasa y se asigna como raiz del arbol binario.
    }
    
    public ArbolBin(Nodo root){//Creamos un arbol binario pasandole un nodo que se comportara como la raiz del Arbol.
        this.root=root;
    }
    
    public void add(Nodo padre, Nodo hijo, int lado){// Método que nos sirve para agregar un nuevo nodo al arbol binario
        //Pasandole el nodo padre (Del cual se le asignara su hijo).
        // Nodo hijo (El cual tendra como padre el que previamente se haya asignado).
        // y el lado (Ya que como es un arbol binario solo tiene dos lados)

	if(lado==0) //Se toma en consideracion que el lado == 0 es el izquierdo y
	    // el derecho el cualquier otro lado (Pudiendo ser por conveniencia el 1)
            padre.setIzq(hijo);
	else
            padre.setDer(hijo);
    }
    
    protected void visit(Nodo n){//Metodo que sirve para imprimir el valor del nodo
        // (Le pasamos un nodo y nos devuelve su valor impreso con un espacio)
        System.out.println(n.valor+" ");
    }	
    
    public void breadthFirst(){//Método que nos sirve para la implementacion del algoritmo BFS
        // de recorrido sobre el arbol binario (BFS = Busqueda en anchura).

        Nodo r = root; //Se le asigna el nodo raiz a un nuevo nodo llamado r para realizar el recorrido.
        //Se hace esta asignacion por que con este nodo vamos a realizar el recorrido por el arbol binario.

	Queue<Nodo> queue = new LinkedList(); //Creamos una cola de nodos de un nuevo objeto de listas ligadas,
        // (Para poder llevando la cuenta de los nodos visitados y para poder ir desencolando los nodos y dando
        // lo valores del recorrido con los metodos antes mencionados).

	if(r!=null){//Si el nodo raiz es igual a nulo significa que el arbol esta vacio y no se haria nada
            queue.add(r);//Agregamos el valor de r a la cola de nodos
            while(!queue.isEmpty()){ //Mientras que la cola no este vacia
                r = (Nodo)queue.poll(); // Este metodo retira y remueve la cabeza de la cola y retorna null si la cola esta vacia.
		visit(r); //Imprime el valor del nodo r que previamente se retiro su valor y asigno a la variable r antes de ser eliminada.
		if(r.izq!=null)//Si su hijo izquierdo no esta vacio se agrega a la cola de nodos visitados del lado izquierdo
                    queue.add(r.izq);// Se agrega el valor del hijo izquierdo a la cola (Para despues desencolarlo e imprimir su valor).
		if(r.der!=null)
		queue.add(r.der);// Se agrega el valor del hijo derecho la cola (Para despues desencolarlo e imprimir su valor).
            }
    	}
    }


}
