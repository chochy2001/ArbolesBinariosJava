public class PruebaArbolBin {

    public static void main(String[] args) {

        ArbolBinBusq arbolChochyBusq;
        Nodo n1 = new Nodo(1);
        Nodo n2 = new Nodo(2);
        Nodo n3 = new Nodo(3);
        Nodo n4 = new Nodo(4);
        Nodo n6 = new Nodo(6);
        Nodo n7 = new Nodo(7);
        Nodo n8 = new Nodo(8);
        Nodo n9 = new Nodo(9);
        Nodo n10 = new Nodo(10);
        Nodo n11 = new Nodo(11);
        Nodo n12 = new Nodo(12);
        Nodo n5 = new Nodo(5,n3,n8);

        arbolChochyBusq = new ArbolBinBusq(n5);

        //Padre / hijo / valor
        arbolChochyBusq.add(n3,n1,1);
        arbolChochyBusq.add(n3,n4,4);

        arbolChochyBusq.add(n8,n6,6);
        arbolChochyBusq.add(n8,n9,9);

        arbolChochyBusq.add(n1,n2,2);

        arbolChochyBusq.add(n6,n7,7);

        arbolChochyBusq.add(n9,n10,10);

        arbolChochyBusq.add(n10,n11,11);

        arbolChochyBusq.add(n11,n12,12);

        arbolChochyBusq.breadthFirst();



    }
}
