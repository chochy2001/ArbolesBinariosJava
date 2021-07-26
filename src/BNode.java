import java.util.ArrayList;

public class BNode {//Clase que nos servira para hacer el nodo de un Arbol B
    static int m;
    ArrayList<Integer> key;
    ArrayList<BNode> child;
    BNode parent;
    boolean leaf;

    //No confundir con nodo binario. Ya que los arboles B pueden tener muchos hijos y muchas claves por nodo.

    public BNode() {//Creamos el constructor del nodo B
        key = new ArrayList();//De clave se le asigna un arraylist (Ya que puede tener muchas claves).
        child = new ArrayList(); //De child o hijos tambien un arraylist. (Ya que puede tener muchos hijos)
        leaf = true;//Se marca leaf como true para que tenga hojas abajo
        parent = null;//No se inicializa con un parent, ya que se asignará despues
    }
    
    public int getKey( int i ){//Metodo que nos sirve para obtener la llave.
        return this.key.get(i);//Se usa el metodo .get de la clase de ArrayList para obtener el valor de la key.
    }
    
    public BNode getChild( int i ){//Metodo que nos sirve para obtener el valor del hijo.
        try{//Usamos manejo de excepciones
            this.child.get(i);//Intentamos objeter el hijo del valor que nos pasaron y si no se puede mandamos la excepcion
        }catch(Exception e){//Mostramos la excepcion
            return null;
        }
        return this.child.get(i);//Si si se puedo obtener el hijo lo retornamos
    }

    public int getChildIndex(){//Metodo que nos sirve para obtener el indice de los hijos
        if( parent == null ){//Si el padre esta vacio no hacemos nada
            return -1;
        }
        else{//Sino
            BNode padre = parent;//Asignamos el valor de parent a un nuevo nodo llamado padre
            for( int i = 0 ; i < padre.child.size() ; i++ ){//Hacemos un recorrido desde que comienza la lista,
                // hasta el tamaño de ella, para asegurarnos de recorrerla completamente para recorrerla toda
                if( padre.child.get(i) == this )
                    //Si el valor que estamos buscando es igual al valor de hijo
                    // entonces regresamos el valor del indice
                    return i;
            }
            return -1;//Si no se encontro no regresamos nada (solo el -1 que indica error).
        }
    }

    public void setM( int m ){//Metodo para poder asignarle el valor a M.
        BNode.m = m;//Se cambia la asignacion del valor, ya que como es estatico no se puede hacer de la manera
        //this.m = m;
    }
    
    public void setKeys( ArrayList<Integer> list ){//Metodo que nos sirve para poder asignar los valores de las llaves de los nodos.
        this.key = list;
    }
    
    public void setChildren( ArrayList<BNode> list  ){//Metodo que nos sirve para poder asignar los valores de los hijos de los nodos.
        this.child = list;
    }
    

    public void mostrarLlaves(){//Metodo que nos ayuda a mostrar las llaves.
        for( int i = 0 ; i < key.size() ; i++ )//Recorremos la lista de llaves con base en su tamaño.
            System.out.print( key.get(i) + " " );//Mostramos los valores de las llaves para mostrarlas al usuario.
    }
   
    
    
    
}
