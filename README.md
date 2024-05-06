# Arbol Binario en Java
Este es un manual informativo para entender los comportamientos del Arbol binario y comprender los metodos que hacen que funcione.
## Indice
         
* [Nodo](https://github.com/Rafae1TCC/Documentacion-del-Arbol-Binario?tab=readme-ov-file#nodo)
* [Arbol binario](https://github.com/Rafae1TCC/Documentacion-del-Arbol-Binario?tab=readme-ov-file#arbol-binario)
  * [Insertar](https://github.com/Rafae1TCC/Documentacion-del-Arbol-Binario?tab=readme-ov-file#insertar)
  * [Insertar elementos aleatorios](https://github.com/Rafae1TCC/Documentacion-del-Arbol-Binario?tab=readme-ov-file#insertar-elementos-aleatorios)
  * [Buscar elementos](https://github.com/Rafae1TCC/Documentacion-del-Arbol-Binario?tab=readme-ov-file#buscar-elementos)
  * [Mostrar Pre Order](https://github.com/Rafae1TCC/Documentacion-del-Arbol-Binario?tab=readme-ov-file#mostrar-pre-oder)
  * [Mostrar Pre Order Invertido](https://github.com/Rafae1TCC/Documentacion-del-Arbol-Binario?tab=readme-ov-file#mostrar-pre-order-invertido)
  * [Mostrar In Order](https://github.com/Rafae1TCC/Documentacion-del-Arbol-Binario?tab=readme-ov-file#mostrar-in-order)
  * [Mostrar In Order Invertido](https://github.com/Rafae1TCC/Documentacion-del-Arbol-Binario?tab=readme-ov-file#mostrar-in-order-invertido)
  * [Mostrar Post Order](https://github.com/Rafae1TCC/Documentacion-del-Arbol-Binario?tab=readme-ov-file#mostrar-post-order)
  * [Mostrar Post Order Invertido](https://github.com/Rafae1TCC/Documentacion-del-Arbol-Binario?tab=readme-ov-file#mostrar-post-order-invertido)
  * [Eliminar elemento](https://github.com/Rafae1TCC/Documentacion-del-Arbol-Binario?tab=readme-ov-file#eliminar-elemento)
  * [Eliminar Arbol](https://github.com/Rafae1TCC/Documentacion-del-Arbol-Binario?tab=readme-ov-file#eliminar-arbol)
## Nodo
Para comenzar con la explicacion primero tenemos que entender lo que es un nodo. 
Un nodo es la posicion en donde se almacenara la informacion dentro del arbol. 
En los arboles los nodos pueden tener sus propias ranas a la izquierda o derecha y asi es como el arbol se va haciendo mas grande y es capaz de alamacenar informacion en cada nodo.


Para poder nosotros crear estas ramas necesitamos declarar 3 variables importantes:

* Int elemento: Esta variable es donde se almacena el valor numerico del elemento que deseamos guardar
* Nodo izquierda: En esta variable estamos creando un objeto de tipo nodo donde se determinara si el Nodo tiene una raiz a la izquierda
* Nodo izquierda: En esta variable estamos creando un objeto de tipo nodo donde se determinara si el Nodo tiene una raiz a la derecha
~~~
class Nodo{
        int elemento;
        Nodo izquierda;
        Nodo derecha;
}
~~~
Ahora dentro del nodo debemos agregar el cosntructor. 
El constructor nos sirve para inicializar el Nodo y determinar que dato se debe almacenar en elemento. 
La izquierda y derecha permanecen en null para posteriormente determinanr si tienen una rama a la izquierda o derecha
~~~
class Nodo{
        int elemento;
        Nodo izquierda;
        Nodo derecha;

public Nodo(int elemento) {
        this.elemento = elemento;
        this.izquierda = null;
        this.derecha = null;
    }

}
~~~
Por ultimo, agregamos al nodo el metodo getElemento() para poder recuperar el numero almacenadao en el elemento y el nodo nos queda de la siguiente forma:
~~~
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
~~~
# Arbol Binario
Un árbol binario es un árbol en el que ningún nodo puede tener más de dos subárboles. 
En un árbol binario cada nodo puede tener cero, uno o dos hijos (subárboles). 
Se conoce el nodo de la izquierda como hijo izquierdo y el nodo de la derecha como hijo derecho.
## Insertar
El metodo insertar nos sirve para insertar un nodo nuevo en el arbol y agregarle al nodo el valor enviado como parametro(elemento).
Como este arbol almacena numeros, podemos determinar la direccion del nodo dependiendo del valor de la raiz (elemento principal del arbol).
Si el valor es menor que la raiz, direccion sese envia a la izquierda y si el valor es mayor se envia a la derecha con un valor booleano (1 y 0 respectivamente)
~~~
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
~~~
## Insertar elementos aleatorios
Esta funcion permite al usuario insertar la cantidad de elementos que desee al arbol con un maximo de 1000.
Hace uso de un simple ciclo for para insertar cada uno de los elementos que va generando el objeto Rand "aleatorio"
~~~
System.out.println("Cantidad de elementos a insertar: ");
                    total = Integer.parseInt(lector.nextLine());

                    for (int i = 1; i <= total; i++) {
                        num = aleatorio.nextInt(1000 + 1) + 1;
                        nums.insertar(num);
                    }
~~~
## Buscar elementos
Para poder buscar elementros dentro del arbol debemos recorrer por cada elemento del arbol. 
Para hacer esto podemos hacer uso del mismo metodo que usamos anteriormente para determinar la direccion, 
solamente que ahora se envia el Nodo auxiliar a izquierda o derecha para que vaya avanzando por las ramas del arbol
Si el metodo encuentra el elemento, le imprime al usuario cuantas busquedas realizo antes de encontrar el elemento y
retorna un true para confirmar que el numero efectivamente existe dentro del arbol.
En caso de que el elemento no exista en el arbol, se le imprime al usuario la cantidad de busquedas que realizo el
metodo antes de confirmar que el elemento no puede existir dentro del arbol.
~~~
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
~~~
## Mostrar Pre Order
Pre order es uno de los 3 ordenes en los que podemos mostrar un arbol binario, este orden recorre el arbol desde la raiz a la izquierda y por ultimo la derecha.
Si tenemos como raiz un 2, en la rama derecha un 3 y en la rama izquierda un 1, el arbol se muestra en pantalla de esta forma: 2,1,3.
## Mostrar Pre Order Invertido
Pre order invertido es un metodo que imprime un pre order pero comienza desde la derecha, luego la izquierda y por ultimo la raiz. 
Por lo tanto, si ingresas 2, 3 y 1 e imprimes el pre order invertido el resultado en pantalla es: 3,1,2.
## Mostrar In Order
In order es uno de los 3 ordenes en los que podemos mostrar un arbol binario, este orden recorre en el orden numerico correcto.
Si tenemos como raiz un 2, en la rama derecha un 3 y en la rama izquierda un 1, el arbol se muestra en pantalla de esta forma: 1,2,3.
## Mostrar In Order Invertido
In order invertido es un metodo que imprime un in order pero comienza desde la derecha a a la raiz y por ultimo la izquierda. 
Por lo tanto, si ingresas 2, 3 y 1 e imprimes el in order invertido el resultado en pantalla es: 3,2,1.
## Mostrar Post Order
Pre order es uno de los 3 ordenes en los que podemos mostrar un arbol binario, este orden recorre el arbol desde la izquierda a la derecha y por ultimo la raiz.
Si tenemos como raiz un 2, en la rama derecha un 3 y en la rama izquierda un 1, el arbol se muestra en pantalla de esta forma: 1,3,2.
## Mostrar Post Order Invertido
Pre order invertido es un metodo que imprime un post order pero comienza desde la raiz a la derecha y por ultimo la izquierda. 
Por lo tanto, si ingresas 2, 3 y 1 e imprimes el pre order invertido el resultado en pantalla es: 2,3,1.
##Eliminar elemento
Para eliminar el elemento deseado primero debemos buscar el elemento dentro del arbol. 
Para eso hacemos uso de este if que siga la misma logica de los metodos de busqueda anteriores y una llamada recursiva al metodo.
~~~
if (elemento == aux.getElemento()) {
} else {  
  if (elemento < aux.getElemento()) {
    eliminar(aux.izquierda,elemento, aux);
  } else {
    eliminar(aux.derecha,elemento, aux);
  }
~~~
Si el elemento existe dentro del arbol hay 3 casos distintos que determinan la manera en la que se elimina el elemento.
* Caso #1: Existe un unico nodo
En este caso realmente no se debe hacer una busqueda porque el unico elemento que existe dentro dentro del arbol coincide con el elemento que se desea eliminar,
por lo tanto simplemente se llama a la funcion eliminar arbol.
~~~
if (raiz.izquierda == null && raiz.derecha == null) { //caso 1 raiz no tiene hijos
                eliminarArbol();
~~~
* Caso #2: El nodo encontrado no tiene hijos.
En este caso el arbol contiene al menos un nodo mas, el algoritmo de busqueda encontro al elemento que se desea eliminar y el nodo no tiene otra ramificacion a la izquierda ni a la derecha.
Hacemos uso de un Nodo anterior para poder cortar la conexion del nodo anterior con el ultimo y se envia a nulo, eliminando el elemento.
~~~
if(aux.izquierda == null && aux.derecha == null){
                    if(anterior.izquierda!=null&&elemento == anterior.izquierda.getElemento()){
                        anterior.izquierda=null;
                    }else{
                        anterior.derecha=null;
                    }
                }
~~~
* Caso #3: El nodo encontrado si tiene hijos.
En este caso el arbol contiene al menos un nodo mas, el algoritmo de busqueda encontro al elemento que se desea eliminar y el nodo tiene otra ramificacion a la izquierda o a la derecha.
Hacemos uso de un Nodo anterior para poder cortar la conexion del nodo anterior con el ultimo y se envia a nulo, eliminando el elemento.
~~~
if(aux.izquierda != null || aux.derecha !=null){
                    if(anterior.izquierda!=null&&anterior.derecha==null){
                        aux.izquierda=anterior.izquierda;
                    }else{
                        aux.derecha=anterior.derecha;
                    }
                }
~~~
##Eliminar arbol
Este metodo envia la raiz a nulo, por lo que todos los nodos almacenados en el arbol desaparecen; eliminando el arbol por completo.
~~~
public void eliminarArbol() { // Elimina todo el arbol`

        raiz = null;

    }
~~~
