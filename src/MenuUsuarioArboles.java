import java.util.Scanner;

public class MenuUsuarioArboles {
    public static void main(String[] args) {
        System.out.println("Bienvenido al programa de arboles Binarios");
        Scanner teclado = new Scanner(System.in);
        short seleccion = teclado.nextShort();
        do {
            System.out.println("Que arbol te gustaria usar? \n1) Arbol Binario (Normal)\n2) Arbol Binario de Busqueda\n3) Arbol B\n0) Salir");
            switch (seleccion) {
                case 0:
                    System.out.println("Gracias por usar el programa\n Vuelve pronto");
                    seleccion = 0;
                    break;
                case 1:
                    System.out.println("Seleccionaste Arbol Binario (Normal) \n");
                    System.out.println("Tienes 8 opciones:");
                    short selecABN;
                    do{
                    System.out.println("1) Crear arbol\n2) Agregar Dato\n3) Eliminar dato\n4) Imprimir Arbol\n5) Notacion Prefija");
                    System.out.println("6) Notacion Infija\n7) Notación Postfija\n0) Salir");
                    selecABN= teclado.nextShort();
                    int valorArbol;

                    switch (selecABN){
                        case 0:
                            System.out.println("Gracias por usar el programa");
                            selecABN = 0;
                            break;
                        case 1:
                            System.out.println("Seleccionaste Crear Arbol");
                            ArbolBin nuevoArbol;
                            System.out.println("Que valor quieres que tenga la raiz?");
                            valorArbol = teclado.nextInt();
                            Nodo nodo1 = new Nodo(valorArbol);
                            nuevoArbol = new ArbolBin(nodo1);
                            System.out.println("Ya se creo el arbol binario con el valor "+ valorArbol + "De nodo");
                            break;
                        case 2:
                            System.out.println("Seleccionaste Agregar Dato");
                            System.out.println("Que dato te gustaria agregar al arbol?");
                            valorArbol = teclado.nextInt();
                            Nodo nuevoNodo = new Nodo(valorArbol);
                            System.out.println("De que lado te gustaria agregarlo?\n0) Izquierdo\n1) Derecho");
                            int lado = teclado.nextInt();
                            nuevoArbol.add(nodo1,nuevoNodo,lado);
                            break;
                        case 3:
                            System.out.println("Seleccionaste Eliminar Dato");
                            int valorEliminar = teclado.nextInt();
                            if(valorEliminar != nuevoNodo.valor){
                                System.out.println("El valor no se encuentra en el arbol");
                            }else{
                                nuevoArbol.eliminarNodo(nuevoNodo);
                                System.out.println("Dato Eliminado del arbol");
                            }
                            break;
                        case 4:
                            System.out.println("Seleccionaste Imprimir Arbol");
                            nuevoArbol.breadthFirst();
                            System.out.println("El arbol se termino de imprimir");
                            break;
                        case 5:
                            System.out.println("Seleccionaste Notacion Prefija");
                            break;
                        case 6:
                            System.out.println("Seleccionaste Notacion Infija");
                            break;
                        case 7:
                            System.out.println("Seleccionaste Notacion Postfija");
                            break;
                        default:
                            System.out.println("Selecciona una opcion valida");
                            break;
                     }
                    }while(selecABN != 0);

                    break;
                case 2:
                    System.out.println("Seleccionaste Arbol Binario de Busqueda");
                    System.out.println("Tienes 6 opciones:");
                    short selecABB;
                    do {
                        System.out.println("1) Crear arbol\n2) Agregar Dato\n3) Eliminar dato\n4) Buscar\n5) Imprimir Arbol (BFS)\n0) Salir");
                        selecABB = teclado.nextShort();
                        int valor;
                        switch(selecABB){
                            case 0:
                                System.out.println("Gracias por usar el programa.");
                                selecABB = 0;
                                break;
                            case 1:
                                System.out.println("Seleccionaste Crear Arbol Binario de Busqueda");
                                ArbolBinBusq arbolBinBusq;
                                System.out.println("Que valor quieres que tenga el nodo raiz");
                                valor = teclado.nextInt();
                                Nodo valorNodo = new Nodo(valor);
                                arbolBinBusq = new ArbolBinBusq(valorNodo);
                                System.out.println("Arbol binario de busqueda creado con exito "+ valor+": es el nodo raiz");
                                break;
                            case 2:
                                System.out.println("Seleccionaste Agregar Dato");
                                System.out.println("Que dato te gustaria agregar al arbol?");
                                valor = teclado.nextInt();
                                Nodo nuevoNodo = new Nodo(valor);
                                arbolBinBusq.add(valorNodo,nuevoNodo,valor);
                                System.out.println("El valor " + valor+ "Se agrego al arbol Binario de Busqueda");
                                break;
                            case 3:
                                System.out.println("Seleccionaste Eliminar Dato");
                                System.out.println("Que valor te gustaria eliminar?");
                                valor = teclado.nextInt();
                                arbolBinBusq.eliminarNodo(nuevoNodo);
                                break;
                            case 4:
                                System.out.println("Seleccionaste Buscar");
                                System.out.println("Que valor quieres buscar?");
                                valor = teclado.nextInt();
                                arbolBinBusq.buscarValor(valor);
                                break;
                            case 5:
                                System.out.println("Imprimir Arbol (BFS)");
                                arbolBinBusq.breadthFirst();
                                System.out.println("Se imprimio el arbol binario de busqueda completo");
                                break;
                            default:
                                System.out.println("Selecciona una opcion valida");
                                break;
                        }
                    }while(selecABB!=0);
                    break;
                    case 3:
                        System.out.println("Seleccionaste un Arbol B");
                        int valor;
                        do{
                            System.out.println("Que operaciones te gustaria realizar?");
                            System.out.println("1) Crear un Arbol\n 2) Agregar un valor\n 3) Buscar Valor\n 4) Imprimir Arbol\n 0) Salir");
                            seleccion = teclado.nextShort();
                            switch(seleccion){
                                case 0:
                                    System.out.println("Gracias por usar el programa");
                                    seleccion = 0;
                                    break;
                                case 1:
                                    System.out.println("Seleccionaste Crear un arbol");
                                    BTree arbolB;
                                    System.out.println("Que valor quieres que tenga el nodo raiz");
                                    valor = teclado.nextInt();
                                    BNode valorNodo = new BNode(valor);
                                    arbolB = new ArbolBinBusq(valorNodo);
                                    System.out.println("Arbol B creado con exito "+ valor+": es el nodo raiz");
                                    break;
                                case 2:
                                    System.out.println("Seleccionaste Agregar un valor");
                                    System.out.println("Que dato te gustaria agregar al arbol?");
                                    valor = teclado.nextInt();
                                    BNode nuevoNodo = new BNode(valor);
                                    arbolB.add(valorNodo,nuevoNodo,valor);
                                    System.out.println("El valor " + valor+ "Se agrego al arbol B");
                                    break;
                                case 3:
                                    System.out.println("Seleccionaste Buscar Valor");
                                    System.out.println("Que valor quieres buscar?");
                                    valor = teclado.nextInt();
                                    arbolB.find(valor);
                                    break;
                                case 4:
                                    System.out.println("Seleccionaste Imprimir Arbol");
                                    arbolB.mostrarArbol();
                                    System.out.println("Se termino de mostrar el arbol B");
                                    break;
                                default:
                                    System.out.println("Opcion invalida");
                                    break;
                            }
                        }while(seleccion != 0);
                        break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (seleccion != 0);
    }
}