package tp2.ejerciciosdecola;

public interface colaTDA {
    void inicializarCola();
    void acolar(int x); // cola inicializada
    void desacolar(); // cola inicializada y no vacía
    int primero(); // cola inicializada y no vacía
    boolean colaVacia(); // cola inicializada y no vacía

}
