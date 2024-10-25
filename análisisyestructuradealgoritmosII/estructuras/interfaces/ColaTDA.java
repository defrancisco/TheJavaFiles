package análisisyestructuradealgoritmosII.estructuras.interfaces;

public interface ColaTDA {
	void inicializarCola( );
	void acolar(int x); //cola inicializada
	void desacolar( ); //cola inicializada y no vac�a
	int primero( ); //cola inicializada y no vac�a
	boolean colaVacia( ); //cola inicializada
}
