package tp5.parte2.implementacionesdinamicas;

import tp5.parte2.interfaces.*;
public class ColaConPrioridadDinamica implements ColaConPrioridadTDA {
	
	private class NodoPrioridad{
		int info;
		int prio;
		NodoPrioridad sig;
	}
	
	private NodoPrioridad mayorPrioridad;


	public void inicializarColaConPrioridad() {
		mayorPrioridad = null;
		
	}


	public void acolarConPrioridad(int x, int prio) {
		NodoPrioridad nuevo = new NodoPrioridad();
		nuevo.info = x;
		nuevo.prio = x;
		
		//CASO DE COMIENZO O MAYOR PRIO
		if(mayorPrioridad == null || prio > mayorPrioridad.prio) {
			nuevo.sig = mayorPrioridad;
			mayorPrioridad = nuevo;
		}else {
			NodoPrioridad aux = mayorPrioridad;
			while(aux.sig != null && aux.sig.prio >= prio) {
				aux= aux.sig;
			}
			nuevo.sig = aux.sig;
			aux.sig = nuevo;
		}
		
	}

	
	public void desacolar() {
		mayorPrioridad = mayorPrioridad.sig;
		
	}

	
	public int primero() {

		return mayorPrioridad.info;
	}

	
	public int prioridad() {

		return mayorPrioridad.prio;
	}

	
	public boolean colaConPrioridadVacia() {

		return (mayorPrioridad == null);
	}

}
