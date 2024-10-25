package tp2.ejerciciosdecolaconprioridad;

public interface colaprioridadTDA {
    void inicializarColaPrioridad();
    void acolarPrioridad(int x, int prio); //cola inicializada
    void desacolar(); //cola inicializada y no vacía
    int primero(); //cola inicializada y no vacía
    int prioridad(); //cola inicializada y no vacía
    // me da el elemento con la prioridad más alta
    boolean colaPrioridadVacia(); //cola inicializada
}
