package classes;

public class Nodo {
	private int dato;
	private Nodo hijoIzquierda, hijoDerecha;

	public Nodo(int dato) {
		this.dato = dato;
	}
	
	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public Nodo getHijoIzquierda() {
		return hijoIzquierda;
	}

	public void setHijoIzquierda(Nodo hijoIzquierda) {
		this.hijoIzquierda = hijoIzquierda;
	}

	public Nodo getHijoDerecha() {
		return hijoDerecha;
	}

	public void setHijoDerecha(Nodo hijoDerecha) {
		this.hijoDerecha = hijoDerecha;
	}
}
