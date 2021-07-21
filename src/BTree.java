import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BTree {//Clase que nos sirve para hacer la implementacion de los arboles B
    
    int m;
    BNode root;
    
    public BTree( int m ){//Constructor del arbol B reciviendo un valor como parametro
        this.m = m;
        root = new BNode();//Se crea un nuevo nodo y se asigna como raiz del arbol B
        root.setM(m);//Se le asigna el valor de M dentro del NodoB
    }
    
    public void add( int n ){//Metodo que nos sirve para agregar un valor al arbol B
        if( find(n) ){//Si el numero se encuentra
            System.out.println("La clave ya existe en el árbol.");
        }
        else{
            BNode hoja = leafNode( root, n );//En el nodo hoja agregamos el valor ingresado
            addToNode( hoja, n);//Agregamos al nodo el valor hacia la hoja correspondiente
        }
    }
    
    private BNode leafNode( BNode nodo, int n ){//Metodo para con base en un valor, agregarlo a la hoja
        if( nodo.leaf ){//Si el nodo tiene nojas se regresa el nodo
            return nodo;
        }
        else{//Sino
            int i = 0;//Variable para recorrer el ciclo for
            for(; i < nodo.key.size() ; i++ ){//Se recorre con base al tamaño de llaves
                if( n < nodo.getKey(i) ){//Si el valor ingresado es menor al valor de la llave se aumenta su valor (Ya que estan ordenados de menos a mayor)
                    i++;//Se incrementa el valor de i antes de salir del ciclo
                    break;
                }
            }
            
            if( n < nodo.getKey(i-1) )//Si el valor ingresado es menor al valor en el indice actual de la llave
                i--;//Se decrementa en uno hasta que se encuentre
            
            return leafNode( nodo.getChild(i), n );//Agregamos el child con el valor de n
            
        }
    }
    
    private void addToNode( BNode nodo, int n ){//Agregar al nodo, recibimos el nodo y un valor entero
        if( nodo.key.size() < m - 1 )  {//con base en la cantidad de llaves en el nodo se compara con el valor de m menos 1
            System.out.println("nodo key size"+nodo.key.size()); //Se imprime el tamaño de las llaves
            insert( nodo, n );// Insertamos en el nodo el valor de n
        }
        else  //Si lo de arriba no se cumple (Significa que no hay espacios vacios en el nodo).
            divisionCelular( nodo, n ); //Se hace la division Celular
        
        
    }
    
    private void insert( BNode nodo, int n ){//Método insertar, se manda en valor del valor y el nodo en donde se quiere insertar el valor
        int i = 0;
        while( i < nodo.key.size()  && n > nodo.getKey(i) ){
            //Mientras el valor de i sea menor al tamaño de llaves en el nodo y en numero ingresado sea mayor a la clave en el nodo
            i++;//Se incrementa en valor de i para poder encontrar la posicion correcta para ingresar el nuevo valor
        }   
        nodo.key.add(i, n);//Se agrega el valor en el indice donde tiene que ir con ayuda del indice i determinado arriba
    }
    
    private void divisionCelular( BNode nodo, int n ){//Recibimos el nodo y el valor que queremos agregar
         
        int h = (m-1)/2;   //Se hace la resta de 1 y se divide entre 2 para poder determinar el valor donde m son los valores del nodo
        if( m % 2 != 0){ //Si m modulo 2 es diferente de cero
            insert(nodo,n);//Se inserta el nodo con el numero pasado al metodo
        }
        int medio = nodo.key.get(h);//Se determina el valor medio del arbol, con ayuda de h que es lo que esta en medio y se asigna a medio
            
        ArrayList<Integer> key1 = new ArrayList( nodo.key.subList( 0, h ) );
        //Se crea un nuevo arraylist de enteros llamado key 1 donde se inicializara con el valor de la sublista desde el principio del arbol hasta la mitad.
        ArrayList<Integer> key2 = new ArrayList( nodo.key.subList( h + 1 , 2*h + 1) );
        //Se crea un nuevo arraylista de enteros llamado key 2 donde se inicializara con el valor de la sublista desde el valor intermedio mas 1 hasta el doble de h más 1
        //Se crean 2 hijos de arraylist
        ArrayList<BNode> child1 = new ArrayList();//Se crean 2 hijos de arraylist
        ArrayList<BNode> child2 = new ArrayList();
        
        if( nodo == root ){//Si el nodo es igual a la raiz

            //Creamos 2 nuevos nodos
            BNode nuevoNodo1 = new BNode();
            BNode nuevoNodo2 = new BNode();
            nuevoNodo1.leaf = nuevoNodo2.leaf = nodo.leaf;//Duplicamos el valor del la hoja del nodo hacia los nuevos nodos

            //Le asignamos los nuevos valores de la key 1 y key 2 a los nuevos nodos
            nuevoNodo1.setKeys(key1);
            nuevoNodo2.setKeys(key2);
            nodo.key.clear();//Limpiamos los valores de las llaves del nodo
            nodo.key.add(medio);//Agregamos el valor medio en la clave del nodo
            
            if( m % 2 == 0 ){
                if( n < medio )
                    insert(nuevoNodo1, n);
                else
                    insert(nuevoNodo2, n);
            }
             
            if( !nodo.leaf ){//Si las hojas es diferente al nodo
                if( m % 2 != 0 ){//Si el modulo 2 es diferente de cero
                    child1 = new ArrayList( nodo.child.subList( 0, h+1 ) );//creamos un nuevo arraylist para guardar la primera mitad del nodo
                    child2 = new ArrayList( nodo.child.subList( h+1, m+1 ) );//creamos un nuevo arraylist para guardar la segunda mitad del nodo
                }
                else{//Si el modulo da como resultado 0
                    if( n < medio ){//Si el valor ingresado es menor al medio
                        child1 = new ArrayList( nodo.child.subList( 0, h+2 ) );//creamos un nuevo arraylist para guardar la primera mitad del nodo
                        child2 = new ArrayList( nodo.child.subList( h+2, m+1 ) );//creamos un nuevo arraylist para guardar la segunda mitad del nodo
                    }
                    if( n > medio ){//Si el valor ingresado en mayor al medio
                        child1 = new ArrayList( nodo.child.subList( 0, h+1 ) );//creamos un nuevo arraylist para guardar la primera mitad del nodo
                        child2 = new ArrayList( nodo.child.subList( h+1, m+1 ) );//creamos un nuevo arraylist para guardar la segunda mitad del nodo
                    }  
                }
                
                nuevoNodo1.setChildren( child1 );//El nuevo nodo le asignamos los valores del hijo 1
                nuevoNodo2.setChildren( child2 );//El nuevo nodo le asignamos los valores del hijo 2
                for( BNode i : nuevoNodo1.child )
                    i.parent = nuevoNodo1;//Recorremos todo el nodo con su hijo para pasarle los valores al parent del nuevoNodo2
                for( BNode i : nuevoNodo2.child )
                    i.parent = nuevoNodo2;//Recorremos todo el nodo con su hijo para pasarle los valores al parent del nuevoNodo2
                
            }
                
            nodo.child.clear();//Limpiamo todo el nodo (Ya que se le asignaron los valores a los nuevos nodos)
            nodo.child.add(nuevoNodo1);//Agregamos los valores de los nuevos nodos a los hijos del nodo
            nodo.child.add(nuevoNodo2);
            nuevoNodo1.parent = nuevoNodo2.parent = root;//Se hace la asignacion de la raiz hacia los nodos hijos nuevos
            // (Para que ambos tengan al mismo padre)
            nodo.leaf = false;//Ponemos que no son nodos hojas.
                        
        }
        else{//Si el nodo es diferente a la raiz
            
            BNode nuevoNodo = new BNode();//Creamos un nuevo nodoB
            nuevoNodo.leaf = nodo.leaf;//Le asignamos los valores de las hojas
            nuevoNodo.parent = nodo.parent;//Le asignamos los valores de sus padres

            int childIndex = nodo.getChildIndex();//Creamos una variable para poder acceder a la cantidad de indices que tiene el nodo.
            
            nodo.setKeys(key1);//Le asignamos las claves al nodo
            nuevoNodo.setKeys(key2);//Le asignamos las claves al nuevo nodo
            
            if( m % 2 == 0 ){//Asignamos los valores 1 y 1 en el nodo y nuevo nodo
                if( n < medio )
                    insert(nodo, n);
                else
                    insert(nuevoNodo, n);
            }
            
            if( !nodo.leaf ){//Si el nodo es distinto a la hoja
                if( m % 2 != 0 ){//Se hacen las asignaciones de nuevo a la sublista
                    child1 = new ArrayList( nodo.child.subList( 0, h+1 ) );
                    child2 = new ArrayList( nodo.child.subList( h+1, m+1 ) );
                }
                else{//Si es igual a 0
                    if( n < medio ){//Si es el valor menor al medio
                        child1 = new ArrayList(nodo.child.subList( 0, h+2 ));
                        child2 = new ArrayList(nodo.child.subList( h+2, m+1 ));
                    }
                    if( n > medio ){//Si es el valor mayor al medio
                        child1 = new ArrayList( nodo.child.subList( 0, h+1 ) );
                        child2 = new ArrayList( nodo.child.subList( h+1, m+1 ) );
                    }   
                }
                nodo.setChildren( child1 );//Le asignamos los valores del hijo al nodo.
                nuevoNodo.setChildren( child2 );//Le asignamos los valores del hijo 2 al nuevo nodo
                for( BNode i : nodo.child )
                    i.parent = nodo;
                for( BNode i : nuevoNodo.child )
                    i.parent = nuevoNodo;
            } 
            
            
            nodo.parent.child.add( childIndex + 1, nuevoNodo );
            
            addToNode( nodo.parent, medio );
            
        }
        
    }
    
    public void mostrarArbol(){
        if(root.child.isEmpty() && root.key.isEmpty()){//Si la raiz del arbol y las llaves estan vacias significa que esta vacio el arbol
            System.out.println("No hay elementos aun");//Se imprime que no hay elementos en el arbol
            return ;
        }
        Queue<BNode> nodos = new LinkedList<>();//Creamos una nueva lista ligada de colas de nodos B
        nodos.add(root);//Agregamos una raiz al nodo
        BNode parent=null;//Seleccionamos que no tenemos padres, ya que lo estamos creando desde cero el arbol
        while( !nodos.isEmpty() ){//Mientras que no este vacio la cola
            
            BNode v = nodos.poll();//Vamos a ir sacando los elementos de la misma y almacenandolos en la variable v que es un nodoB
            if(v.parent==null){//Si el padre esta vacio
                System.out.print("Nodo Raiz: ");
            }
            if(parent!=v.parent){//Si el padre es diferente al padre del nodo v
                System.out.print("\n\n\nNodo Padre: ");
                v.parent.mostrarLlaves();//Mostramos las llaves del padre.
                parent=v.parent;//Igualamos las llaves de los padres.
                System.out.print("\n\t\tNodos:");
            }
            System.out.print("\n\t\t");
            v.mostrarLlaves();//Mostramos las llaves el nodo v
            
            for( int i = 0 ; i < v.child.size() ; i ++ )
                nodos.add( v.child.get(i) );//Agregamos los nodos al arbol nodos, del nodoB v
        }
        System.out.println("\n");
    }
    
    public boolean find(int value){//Método que nos sirve para encontrar un determinado valor en el arbol
        if(root.child.isEmpty() && root.key.isEmpty()) return false;//Se hizo una simplificacion del codigo por redundancias y obviedades
        //Si el hijo de la raiz esta vacio y todos los valores contenido estan vacios retorna falso,
        // ya que el arbol B esta completamente vacio.
        return find(value,root);//Si el valor se encuentra se manda llamar al metodo find
        // pero con una sobreescritura del mismo, para hacerlo más completo
    }
    
    private boolean find(int v,BNode n){//Metodo que nos sirve para buscar un valor en un nodo en concreto
        if(n==null) return false;//Si el nodo esta vacio retornamos false, ya que no puede haber ningun valor en un arbol vacio.
        
        int i;
        
        if( n.getKey(0) > v )//Si el valor obtenido en el indice 0 es mayor al valor ingresado
            return find(v,n.getChild(0));//Retornamos el valor de la busqueda de nuevo con el valor a buscar y el hijo en el indice 0
        
        for(i=0;i<n.key.size()-1;i++){// Se hace un ciclo desde cero hasta el tamaño de las llaves menos 1 para saber donde colocarlo
            
            if(n.getKey(i)==v){//Si el valor se encuentra en el arbol regresas true
                return true;
            }
            
            if(n.getKey(i)<v && n.getKey(i+1)>v){ //Si la clave obtenida es menor al valor y la clave y mayor a la anterior
                return find(v,n.getChild(i+1));//Se sigue buscando el numero en el arbol
            }
            
        }
        
        if(n.getKey(i)==v){//Si el valor es igual a una de las llaves regresamos true
            return true;
        }
        else{
            if( n.getKey(i) < v)//Si la clave es menor al valor vamos hacia el hijo izquierdo.
                return find(v,n.getChild(i+1));
            else
                return find(v,n.getChild(i));//Si la clave es mayor al valor vamos hacia el hijo derecho.
        }
        
    }
    

    
}
