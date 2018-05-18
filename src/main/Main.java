package main;

import classes.Arbol;

public class Main {

	public static void main(String[] args) {
		Arbol arbolito = new Arbol();
		
		arbolito.addNodo(10);
		arbolito.addNodo(7);
		arbolito.addNodo(12);
		arbolito.addNodo(5);
		arbolito.addNodo(2);
		arbolito.addNodo(6);
		arbolito.addNodo(15);
		
		System.out.println("inOrder: ");
		arbolito.inOrder();
		System.out.println("\npreOrder: ");
		arbolito.preOrder();
		System.out.println("\npostOrder: ");
		arbolito.postOrder();
		System.out.println("\n");
		
		arbolito.find(15);
		arbolito.find(6);
		arbolito.find(7);
		arbolito.find(10);
		arbolito.find(30);
		
		arbolito.getMax();
		arbolito.getMin();
	}

}
