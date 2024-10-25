package tp5.parte2.implementacionesdinamicas;
import tp5.parte2.interfaces.*;
public class ColaDInamica implements ColaTDA {
	
	private class Nodo{
		int info;
		Nodo sig;
	}
	
	private Nodo primero;
	private Nodo ultimo;


	public void inicialziarCola() {
		primero = null;
		ultimo = null;
	}


	public void acolar(int x) {
		Nodo nuevo = new Nodo();
		nuevo.info = x;
		nuevo.sig = null;
		if(ultimo != null) {
			ultimo.sig = nuevo;
		}
		if (primero == null) {
			ultimo = nuevo;
		}
	}


	public void desacolar() {
		primero = primero.sig;
		if(primero == null) {
			ultimo = null;
		}
	}

	@Override
	public int primero() {
		return primero.info;
	}


	public boolean colaVacia() {
		return (ultimo == null);
	}

}
