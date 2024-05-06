package EstructurasEj13;

import java.util.Random;
import java.util.Scanner;

//Ejercicio 13
//Cabrera Contreras Rafael Tonathiu
//Arboles
public class main {

    public static void main(String[] args) {

        int opcion;

        Scanner lector = new Scanner(System.in);
        System.out.println("Ejercicio 1 arboles");
        Arbolbin nums = new Arbolbin();
        Random aleatorio = new Random();
        int num, total;
        do {

            menu();

            opcion = Integer.parseInt(lector.nextLine());
            switch (opcion) {
                case 1:
                    System.out.println("Num: ");
                    nums.insertar(Integer.parseInt(lector.nextLine()));
                    break;
                case 2:
                    System.out.println("Cantidad de elementos a insertar: ");
                    total = Integer.parseInt(lector.nextLine());
                    for (int i = 1; i <= total; i++) {
                        num = aleatorio.nextInt(1000 + 1) + 1;
                        nums.insertar(num);
                    }
                    break;
                case 3:
                    if (nums.vacia()) {
                        System.out.println("No hay elementos");
                    } else {
                        System.out.println("Pre Order: ");
                        nums.mostrarPreOrder(nums.raiz);
                    }
                    
                    
                    break;
                case 4:
                    if (nums.vacia()) {
                        System.out.println("No hay elementos");
                    } else {
                        System.out.println("Pre Order Invertido: ");
                        nums.mostrarPreOrderInvertido(nums.raiz);
                    }
                    
                    
                    break;
                case 5:
                    if (nums.vacia()) {
                        System.out.println("No hay elementos");
                    } else {
                        System.out.println("In Order: ");
                        nums.mostrarInOrder(nums.raiz);
                    }
                    break;
                case 6:
                if (nums.vacia()) {
                    System.out.println("No hay elementos");
                } else {
                    System.out.println("In Order: ");
                    nums.mostrarInOrderInvertido(nums.raiz);
                }
                    break;
                case 7:
                   if (nums.vacia()) {
                        System.out.println("No hay elementos");
                    } else {
                        System.out.println("Post Order: ");
                        nums.mostrarPostOrder(nums.raiz);
                    }
                    break;
                case 8:
                    if (nums.vacia()) {
                        System.out.println("No hay elementos");
                    } else {
                        System.out.println("Post Order: ");
                        nums.mostrarPostOrderInvertido(nums.raiz);
                    }
                    break;
                case 9:
                if (nums.vacia()) {
                    System.out.println("No hay elementos");
                } else {
                    System.out.println("Buscar elemento: ");
                    num = Integer.parseInt(lector.nextLine());
                    if (nums.buscar(num)) {
                        System.out.println("El elemento si se encuentra en el arbol.");
                    } else {
                        System.out.println("El elemento no se encuentra en el arbol.");
                    }
                }
                    break;
                case 10:

                if (nums.vacia()) {
                    System.out.println("No hay elementos");
                } else {
                    
                    System.out.println("Ingrese el numero que desea eliminar");
                    num = Integer.parseInt(lector.nextLine());
                    if(!nums.buscar(num)){
                        System.out.println("No existe el elemento");
                    }else{
                        nums.eliminar(nums.raiz, num, null);
                    }
                    
                }

                    break;
                case 11:
                    nums.eliminarArbol();
                    break;        
            }
        } while (opcion != 9);

    }

    public static void menu() {

        System.out.println("\nArboles binarios");
        System.out.println("1: Insertar");
        System.out.println("2: Insertar elementos aleatorios");
        System.out.println("3: Mostrar Pre Order");
        System.out.println("4: Mostrar Pre Order Invertido");
        System.out.println("5: Mostrar In Order");
        System.out.println("6: Mostrar In Order Invertido");
        System.out.println("7: Mostrar Post Order");
        System.out.println("8: Mostrar Post Order Invertido");
        System.out.println("9: Buscar elemento");
        System.out.println("10: Eliminar elemento");
        System.out.println("11: Eliminar arbol");
        System.out.println("");

    }

}
