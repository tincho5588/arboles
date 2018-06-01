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

	private void deleteNodo(int valor, Nodo raiz, Nodo padre) {
		// El arbol esta vacio
		if (raiz == null && padre == null) {
			System.out.println("Arbol vacio! Inserte un dato primero");
			return;
		}
		
		// Llegue al final del arbol
		if (raiz.getHijoDerecha() == null && raiz.getHijoIzquierda() == null
				&& raiz.getDato() != valor) {
			return;
		}

		// Encontre el dato!
		if (valor == raiz.getDato()) {
			if (raiz.getHijoDerecha() == null && raiz.getHijoIzquierda() == null) {
				// No tiene hijos
				if (padre.getHijoDerecha().equals(raiz)) {
					padre.setHijoDerecha(null);
				} else {
					padre.setHijoIzquierda(null);
				}
				return;
			} else {
				if (raiz.getHijoDerecha() != null && raiz.getHijoIzquierda() == null) {
					// tiene un hijo a la derecha
					if (padre.getHijoDerecha().equals(raiz)) {
						padre.setHijoDerecha(raiz.getHijoDerecha());
					} else {
						padre.setHijoIzquierda(raiz.getHijoDerecha());
					}
					return;
				} else if (raiz.getHijoIzquierda() != null && raiz.getHijoDerecha() == null) {
					// tiene un hijo a la izquierda
					if (padre.getHijoDerecha().equals(raiz)) {
						padre.setHijoDerecha(raiz.getHijoIzquierda());
					} else {
						padre.setHijoIzquierda(raiz.getHijoIzquierda());
					}
					return;
				} else {
					// Tiene 2 hijos
					Nodo reemplazo = getMin(raiz.getHijoDerecha());
					raiz.setDato(reemplazo.getDato());
					deleteNodo(reemplazo.getDato(), raiz.getHijoDerecha(), raiz);
				}
			}
		}

		// En este nodo no esta, pasemos al siguiente!
		if (valor > raiz.getDato()) {
			deleteNodo(valor, raiz.getHijoDerecha(), raiz);
		} else {
			deleteNodo(valor, raiz.getHijoIzquierda(), raiz);
		}
	}

	public void deleteNodo(int valor) {
		deleteNodo(valor, this.raiz, null);
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

	private void find(int valor, Nodo raiz, int piso) {
		// Llegue al final del arbol, o sea q el dato no esta
		if (raiz == null) {
			System.out.println("Dato " + valor + " no encontrado");
			return;
		}

		// Encontre el dato! lo muestro y corto la ejecucion
		if (valor == raiz.getDato()) {
			System.out.println("Dato: " + valor + " encontrado en el nivel: " + piso);
			return;
		}

		// En este nodo no esta, pasemos al siguiente!
		if (valor > raiz.getDato()) {
			find(valor, raiz.getHijoDerecha(), ++piso);
		} else {
			find(valor, raiz.getHijoIzquierda(), ++piso);
		}
	}

	public void find(int valor) {
		find(valor, this.raiz, 0);
	}

	private void getMax(Nodo raiz) {
		if (raiz == null) {
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

	private Nodo getMin(Nodo raiz) {
		if (raiz == null) {
			System.out.println("El arbol esta vacio!");
			return null;
		}

		if (raiz.getHijoIzquierda() == null) {
			System.out.println("Valor minimo: " + raiz.getDato());
			return raiz;
		}

		return getMin(raiz.getHijoIzquierda());
	}

	public Nodo getMin() {
		return getMin(this.raiz);
	}
}
