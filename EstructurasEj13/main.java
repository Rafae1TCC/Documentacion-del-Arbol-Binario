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
                    if (nums.vacia()) {
                        System.out.println("No hay elementos");
                    } else {
                        System.out.println("Pre Order: ");
                        nums.mostrarPreOrder(nums.raiz);
                    }
                    break;
                case 3:
                    if (nums.vacia()) {
                        System.out.println("No hay elementos");
                    } else {
                        System.out.println("In Order: ");
                        nums.mostrarInOrder(nums.raiz);
                    }
                    break;
                case 4:
                    if (nums.vacia()) {
                        System.out.println("No hay elementos");
                    } else {
                        System.out.println("Post Order: ");
                        nums.mostrarPostOrder(nums.raiz);
                    }
                    break;
                case 5:
                    if (nums.vacia()) {
                        System.out.println("No hay elementos");
                    } else {
                        System.out.println("Pre Order Invertido: ");
                        nums.mostrarPreOrderInvertido(nums.raiz);
                    }
                    break;
                case 6:
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
                case 7:
                    System.out.println("Cantidad de elementos: ");
                    total = Integer.parseInt(lector.nextLine());
                    for (int i = 1; i <= total; i++) {
                        num = aleatorio.nextInt(100 + 1) + 1;
                        nums.insertar(num);
                    }
                    break;
                case 8:
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
                case 9:
                    nums.eliminarArbol();
                    break;
            }
        } while (opcion != 9);

    }

    public static void menu() {

        System.out.println("\nArboles binarios");
        System.out.println("1: Insertar");
        System.out.println("2: Mostrar Pre Order");
        System.out.println("3: Mostrar In Order");
        System.out.println("4: Mostrar Post Order");
        System.out.println("5: Mostrar Pre Order Invertido");
        System.out.println("6: Buscar elemento");
        System.out.println("7: Insertar elementos aleatorios");
        System.out.println("8: Eliminar elemento");
        System.out.println("9: Buscar elemento");
        System.out.println("");

    }

    public static void burbuja() {
        int contFor = 0;
        int contInt = 0;
        //int vec[]={14,8,3,20,40,16,19,4,50,80};
        int vec[] = {80, 50, 4, 19, 16, 40, 20, 3, 8, 14};
        System.out.print("Vector sin ordenar: ");
        for (int i = 0; i < vec.length; i++) {
            System.out.print(vec[i] + " ");
        }
        //Ordenamiento
        for (int i = 0; i < vec.length - 1; i++) {
            for (int j = 0; j < (vec.length - 1 - i); j++) {
                contFor++;
                if (vec[j] > vec[j + 1]) {
                    int aux = vec[j];
                    vec[j] = vec[j + 1];
                    vec[j + 1] = aux;
                    contInt++;
                }
            }
        }
        System.out.print("\nVector ordenado: ");
        for (int i = 0; i < vec.length; i++) {
            System.out.print(vec[i] + " ");
        }
        System.out.println("\nConteo Intentos: " + contInt);
        System.out.println("\nConteo For: " + contFor);
    }

}
