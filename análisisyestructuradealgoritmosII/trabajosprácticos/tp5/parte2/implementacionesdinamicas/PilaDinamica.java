package tp5.parte2.implementacionesdinamicas;
import tp5.parte2.interfaces.*;
public class PilaDinamica implements PilaTDA {
	private class Nodo{
		int info;
		Nodo sig;
	}
	
	private Nodo primero;

	public void inicializarPila() {
		primero = null;
	}


	public void apilar(int x) {
		Nodo nuevo = new Nodo();
		nuevo.info = x;
		nuevo.sig = primero;
		primero = nuevo;
	}


	public void desapilar() {
		primero = primero.sig;
	}


	public int tope() {
		return primero.info;
	}


	public boolean pilaVacia() {
		return (primero == null);
	}

}
