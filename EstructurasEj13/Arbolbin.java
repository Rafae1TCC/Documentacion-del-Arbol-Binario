package EstructurasEj13;
//Codigo tomado de las listas dobles

public class Arbolbin {

    public Nodo raiz; // Inicio de la lista
    public Nodo fin;

    public Arbolbin() {
        this.raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void insertar(int elemento) {

        Nodo nuevo = new Nodo(elemento);
        boolean direccion = false; //true = izquierda, false = derecha

        if (raiz == null) {

            raiz = nuevo;

        } else {
            Nodo aux = raiz;
            Nodo ant = null;

            while (aux != null) {
                ant = aux;
                if (elemento < aux.getElemento()) {
                    aux = aux.izquierda;
                    direccion = true;
                } else {
                    aux = aux.derecha;
                    direccion = false;
                }
            }
            if (direccion) {
                ant.izquierda = nuevo;
            } else {
                ant.derecha = nuevo;
            }// else apartir del segundo elemento

        }
    }

    public boolean buscar(int num) {
        Nodo aux = raiz;
        int cont = 0;
        while (aux != null) {
            if (num == aux.getElemento()) {
                System.out.println("Numero de intentos: "+cont);
                return true;
            } else {
                cont++;
                if (num < aux.getElemento()) {
                    aux = aux.izquierda;
                } else {
                    aux = aux.derecha;
                }
            }
        }
        System.out.println("Numero de intentos: "+cont);
        return false;
    }

    public void mostrarPreOrder(Nodo aux) {

        if (aux != null) {

            System.out.println(" / " + aux.getElemento());
            mostrarPreOrder(aux.izquierda);
            mostrarPreOrder(aux.derecha);
        }
    }

    public void mostrarInOrder(Nodo aux) {
        if (aux != null) {
            mostrarInOrder(aux.izquierda);
            System.out.println(" / " + aux.getElemento());
            mostrarInOrder(aux.derecha);
        }
    }

    public void mostrarPostOrder(Nodo aux) {
        if (aux != null) {
            mostrarPostOrder(aux.izquierda);
            mostrarPostOrder(aux.derecha);
            System.out.println(" / " + aux.getElemento());

        }
    }

    public void mostrarPreOrderInvertido(Nodo aux) {
        if (aux != null) {
            mostrarPreOrderInvertido(aux.derecha);
            mostrarPreOrderInvertido(aux.izquierda);
            System.out.println(" / " + aux.getElemento());

        }
    }

    public void mostrarInOrderInvertido(Nodo aux) {
        if (aux != null) {
            mostrarInOrderInvertido(aux.derecha);
            System.out.println(" / " + aux.getElemento());
            mostrarInOrderInvertido(aux.izquierda);
        }
    }
    
    public void mostrarPostOrderInvertido(Nodo aux) {
        if (aux != null) {
            
            System.out.println(" / " + aux.getElemento());
            mostrarPostOrderInvertido(aux.derecha);
            mostrarPostOrderInvertido(aux.izquierda);
        }
    }
    
    public void eliminar(int elemento) {
        Nodo aux = raiz;
        Nodo ant = null;
        while (aux != null) { 
            if (aux.getElemento() == elemento) {  
                if (aux.izquierda == null && aux.derecha == null) { // Si el nodo no tiene hijos
                    if (ant.izquierda == aux) { 
                        ant.izquierda = null; 
                    } else {
                        ant.derecha = null; 
                    }
                } else if (aux.izquierda == null && aux.derecha != null) { // Si el nodo actual no tiene hijo izquierdo y si tiene hijo derecho
                    if (ant.izquierda == aux) { 
                        ant.izquierda = aux.derecha; 
                    } else {
                        ant.derecha = aux.derecha; 
                    }
                } else if (aux.izquierda != null && aux.derecha == null) { // Si el nodo actual tiene hijo izquierdo y no tiene hijo derecho
                    if (ant.izquierda == aux) {  
                        ant.izquierda = aux.izquierda; 
                    } else { 
                        ant.derecha = aux.izquierda;
                    }
                } else { // Si el nodo actual tiene dos hijos
                    Nodo aux2 = aux.derecha; 
                    Nodo ant2 = aux; 
                    while (aux2.izquierda != null) { 
                        ant2 = aux2; 
                        aux2 = aux2.izquierda; 
                    }
                    aux.elemento = aux2.elemento; // El elemento del nodo actual es igual al elemento del nodo auxiliar
                    if (ant2.izquierda== aux2) { 
                        ant2.izquierda = aux2.derecha;
                    } else { 
                        ant2.derecha = aux2.derecha; 
                        aux2.derecha=null;
                        aux2=null;
                    }
                }
                return; 
            }
            ant = aux; // El nodo anterior es igual al nodo actual
            if (elemento < aux.getElemento()) { 
                aux = aux.izquierda; 
            } else { 
                aux = aux.derecha; 
            }
        }
    }

    public boolean vacia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void eliminarArbol() { // Elimina todo el arbol

        raiz = null;

    }

}
