package EstructurasEj13;

class Nodo{
        int elemento;
        Nodo izquierda;
        Nodo derecha;

    public Nodo(int elemento) {
        this.elemento = elemento;
        this.izquierda = null;
        this.derecha = null;
    }

    public int getElemento() {
        return elemento;
    }
        
        
}
