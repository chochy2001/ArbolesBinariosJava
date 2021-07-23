/**
 *
 * @author Jorge Salgado Miranda
 * @version 1.0.0
 */

public class Pruebas {
    
    public static void main(String args[]){
        /*ArbolBin arbol;
        
        Nodo n7 = new Nodo(7);
        Nodo n9 = new Nodo(9);
        Nodo n1 = new Nodo(1,n7,n9);
        Nodo n15 = new Nodo(15);
        Nodo n8 = new Nodo(8);
        Nodo n4 = new Nodo(4);
        Nodo n2 = new Nodo(2);
        Nodo n16 = new Nodo(16);
        Nodo n3 = new Nodo(3);

        //lado == 0 izquierdo 1 == derecho
        arbol = new ArbolBin(n1);
        arbol.add(n7,n15,0);
        arbol.add(n7,n8,1);
        arbol.add(n9,n4,0);
        arbol.add(n9,n2,1);
        arbol.add(n15,n16,1);
        arbol.add(n8,n3,0);
        arbol.breadthFirst();*/

        //Creando la implementacion de otro arbol con otros valores.
        ArbolBin arbolChochy;
        //Creamos los nodos
        Nodo n5 = new Nodo(5);
        Nodo n13 = new Nodo(13);
        Nodo n10 = new Nodo(10,n5,n13);//Asignamos los valores de los hijos del nodo padre n10
        Nodo n2 = new Nodo(2);
        Nodo n1 = new Nodo(1);
        Nodo n20 = new Nodo(20);
        Nodo n100 = new Nodo(100);
        Nodo n500 = new Nodo(500);
        Nodo n4 = new Nodo(4);
        Nodo n8 = new Nodo(8);
        Nodo n3 = new Nodo(3);

        arbolChochy = new ArbolBin(n10);//Inicializamos al nodo padre como el nodo 10 que ya tiene a sus hijos n5 y n13
        arbolChochy.add(n5,n2,0);
        arbolChochy.add(n5,n4,1);
        arbolChochy.add(n2,n1,0);
        arbolChochy.add(n2,n20,1);
        arbolChochy.add(n4,n100,0);
        arbolChochy.add(n4,n500,1);
        arbolChochy.add(n13,n8,0);
        arbolChochy.add(n13,n3,1);
/*
        System.out.println("Impresion del arbol por BFS");
        arbolChochy.breadthFirst();

        System.out.println("Eliminamos el nodo 500");
        arbolChochy.eliminarNodo(n500);
        System.out.println("Recorrido BFS");
        arbolChochy.breadthFirst();

        System.out.println("Eliminamos el nodo 100");
        arbolChochy.eliminarNodo(n100);
        System.out.println("Recorrido BFS");
        arbolChochy.breadthFirst();

        System.out.println("Eliminamos el nodo 4");
        arbolChochy.eliminarNodo(n4);
        System.out.println("Recorrido BFS");
        arbolChochy.breadthFirst();

        System.out.println("Eliminamos el nodo 20");
        arbolChochy.eliminarNodo(n20);
        System.out.println("Recorrido BFS");
        arbolChochy.breadthFirst();

        System.out.println("Eliminamos el nodo 3");
        arbolChochy.eliminarNodo(n3);
        System.out.println("Recorrido BFS");
        arbolChochy.breadthFirst();*/


        System.out.println("Comenzando la busqueda de valores");

        arbolChochy.buscarValor(5);
        arbolChochy.buscarValor(10);
        arbolChochy.buscarValor(123);
        arbolChochy.buscarValor(1);

    
    }
}
