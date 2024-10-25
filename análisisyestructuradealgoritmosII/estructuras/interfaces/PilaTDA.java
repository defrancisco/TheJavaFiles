package análisisyestructuradealgoritmosII.estructuras.interfaces;

public interface PilaTDA {
	void inicializarPila( );
	void apilar(int x); //pila inicializada
	void desapilar( ); //pila inicializada y no vac�a
	int tope( ); //pila inicializada y no vac�a
	boolean pilaVacia( ); //pila inicializada
}
