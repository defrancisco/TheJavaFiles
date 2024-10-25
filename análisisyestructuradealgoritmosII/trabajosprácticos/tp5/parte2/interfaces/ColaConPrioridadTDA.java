package tp5.parte2.interfaces;

public interface ColaConPrioridadTDA {
	void inicializarColaConPrioridad();
	void acolarConPrioridad(int x, int prio);
	void desacolar();
	int primero();
	int prioridad();
	boolean colaConPrioridadVacia();
}
