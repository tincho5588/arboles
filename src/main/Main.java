package main;

import java.util.Scanner;

import classes.Arbol;

public class Main {

	public static void main(String[] args) {
		Arbol arbolito = new Arbol();
		Scanner scan = new Scanner(System.in);
		int opt;

		do {
			System.out.println("Ingrese una opcion: ");
			System.out.println("1 - Cargar valor.");
			System.out.println("2 - Mostrar el arbol preOrder");
			System.out.println("3 - Mostrar el arbol inOrder");
			System.out.println("4 - Mostrar el arbol postOrder");
			System.out.println("5 - Buscar un valor");
			System.out.println("6 - Mostrar el valor minimo");
			System.out.println("7 - Mostrar el valor maximo");
			System.out.println("8 - Eliminar un nodo");
			System.out.println("0 - Salir");
			opt = scan.nextInt();
			switch (opt) {
			case 1:
				System.out.println("Ingrese un numero: ");
				arbolito.addNodo(scan.nextInt());
				break;
			case 2:
				arbolito.preOrder();
				break;
			case 3:
				arbolito.inOrder();
				break;
			case 4:
				arbolito.postOrder();
				break;
			case 5:
				System.out.println("Ingrese un numero: ");
				arbolito.find(scan.nextInt());
				break;
			case 6:
				arbolito.getMin();
				break;
			case 7:
				arbolito.getMax();
				break;
			case 8:
				System.out.println("Ingrese un numero: ");
				arbolito.deleteNodo(scan.nextInt());
				break;
			case 0:
				System.out.println("Gracias por volar con nosotros!");
				break;
			default:
				System.out.println("Opcion invalida, ingrese una opcion valida");
			}
		} while (opt > 0);
	}

}
