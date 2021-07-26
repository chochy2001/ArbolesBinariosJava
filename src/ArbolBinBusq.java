import java.util.LinkedList;
import java.util.Queue;

public class ArbolBinBusq extends ArbolBin{


    public ArbolBinBusq() {
    }

    public ArbolBinBusq(int val) {
        super(val);
    }

    public ArbolBinBusq(Nodo root) {
        super(root);
    }

    public void eliminarNodo(Nodo nodoEliminar){

        Nodo rb = root;

        Queue<Nodo> queue = new LinkedList();
        if(rb!= null){
            queue.add(rb);
            while(!queue.isEmpty()){
                rb = (Nodo)queue.poll();
                System.out.println("Nodo visitado "+rb.valor);
                if(rb.izq!=null){
                    queue.add(rb.izq);
                }if(rb.der!=null){
                    queue.add(rb.der);
                }
                if(rb==nodoEliminar){
                    System.out.println("Nodo encontrado");
                    rb = null;
                }else if (rb.izq==nodoEliminar){
                    System.out.println("Nodo encontrado en hijo izquierdo");
                    rb.izq = null;
                }else if (rb.der==nodoEliminar){
                    System.out.println("Nodo encontrado en hijo derecho");
                    rb.der = null;
                }
            }
        }


    }

    public void add(Nodo padre, Nodo hijo, int valor){//Se cambio el nombre de lado por valor
        //Con base en si el valor es menor al padre, va del lado izquierda y viceversa
        if(valor<padre.valor){
            padre.setIzq(hijo);
        }else{
            padre.setDer(hijo);
        }

    }
}
