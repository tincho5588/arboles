package classes;

public class Arbol {
	private Nodo raiz;

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

	private void addNodo(Nodo nuevo, Nodo raiz) {
		if (raiz == null) {
			this.setRaiz(nuevo);
		} else {
			if (nuevo.getDato() > raiz.getDato()) {
				if (raiz.getHijoDerecha() == null)
					raiz.setHijoDerecha(nuevo);
				else
					addNodo(nuevo, raiz.getHijoDerecha());
			} else if (nuevo.getDato() < raiz.getDato()) {
				if (raiz.getHijoIzquierda() == null)
					raiz.setHijoIzquierda(nuevo);
				else
					addNodo(nuevo, raiz.getHijoIzquierda());
			} else {
				System.out.println("Omitiendo nodo ya existente");
			}
		}
	}

	public void addNodo(int dato) {
		addNodo(new Nodo(dato), this.raiz);
	}

	private void inOrder(Nodo raiz) {
		// LLegue al final del arbol, quiebro
		if (raiz == null) {
			return;
		}
		inOrder(raiz.getHijoIzquierda());
		System.out.print("|" + raiz.getDato() + "|");
		inOrder(raiz.getHijoDerecha());
	}

	public void inOrder() {
		inOrder(this.raiz);
	}

	private void preOrder(Nodo raiz) {
		// LLegue al final del arbol, quiebro
		if (raiz == null) {
			return;
		}
		System.out.print("|" + raiz.getDato() + "|");
		preOrder(raiz.getHijoIzquierda());
		preOrder(raiz.getHijoDerecha());
	}

	public void preOrder() {
		preOrder(this.raiz);
	}

	private void postOrder(Nodo raiz) {
		// LLegue al final del arbol, quiebro
		if (raiz == null) {
			return;
		}
		postOrder(raiz.getHijoIzquierda());
		postOrder(raiz.getHijoDerecha());
		System.out.print("|" + raiz.getDato() + "|");
	}

	public void postOrder() {
		postOrder(this.raiz);
	}

	private void find(Nodo nodo, Nodo raiz, int piso) {
		// Llegue al final del arbol, o sea q el dato no esta
		if (raiz == null) {
			System.out.println("Dato " + nodo.getDato() + " no encontrado");
			return;
		}

		// Encontre el dato! lo muestro y corto la ejecucion
		if (nodo.getDato() == raiz.getDato()) {
			System.out.println("Dato: " + nodo.getDato() + " encontrado en el nivel: " + piso);
			return;
		}

		// En este nodo no esta, pasemos al siguiente!
		if (nodo.getDato() > raiz.getDato()) {
			find(nodo, raiz.getHijoDerecha(), ++piso);
		} else {
			find(nodo, raiz.getHijoIzquierda(), ++piso);
		}

	}

	public void find(int valor) {
		find(new Nodo(valor), this.raiz, 0);
	}
	
	private void getMax(Nodo raiz) {
		if(raiz == null) {
			System.out.println("El arbol esta vacio!");
			return;
		}
		
		if (raiz.getHijoDerecha() == null) {
			System.out.println("Valor maximo: " + raiz.getDato());
			return;
		}
		
		getMax(raiz.getHijoDerecha());
	}
	
	public void getMax() {
		getMax(this.raiz);
	}
	
	private void getMin(Nodo raiz) {
		if(raiz == null) {
			System.out.println("El arbol esta vacio!");
			return;
		}
		
		if (raiz.getHijoIzquierda() == null) {
			System.out.println("Valor minimo: " + raiz.getDato());
			return;
		}
		
		getMin(raiz.getHijoIzquierda());
	}
	
	public void getMin() {
		getMin(this.raiz);
	}
}
