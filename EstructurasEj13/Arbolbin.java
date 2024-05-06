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
    
    public void eliminar(Nodo aux, int elemento, Nodo anterior) {
        //caso 1 hay un solo nodo
        
        
        
        if (elemento == aux.getElemento()) {
            //Entra solamente cuando el elemento ya coincidio
            if (raiz.izquierda == null && raiz.derecha == null) { //caso 1 raiz tiene 1 solo hijo
                eliminarArbol();
            } else {
                //caso 2 el noodo no tiene hijos
                if(aux.izquierda == null && aux.derecha == null){
                    if(anterior.izquierda!=null&&elemento == anterior.izquierda.getElemento()){
                        anterior.izquierda=null;
                    }else{
                        anterior.derecha=null;
                    }
                }
                //caso 3 el nodo tiene hijos
                if(aux.izquierda != null || aux.derecha !=null){
                    if(anterior.izquierda!=null&&anterior.derecha==null){
                        aux.izquierda=anterior.izquierda;
                    }else{
                        aux.derecha=anterior.derecha;
                    }
                }
            }
        //Else del primer if    
        } else {
            
            if (elemento < aux.getElemento()) {
                eliminar(aux.izquierda,elemento, aux);
            } else {
                eliminar(aux.derecha,elemento, aux);
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
