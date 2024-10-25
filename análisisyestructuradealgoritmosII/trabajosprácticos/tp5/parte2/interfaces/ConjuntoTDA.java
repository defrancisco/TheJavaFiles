package tp5.parte2.interfaces;

public interface ConjuntoTDA {
	void inicializarConjunto();
	void agregar(int x);
	void sacar(int x);
	int elegir();
	boolean pertenece(int x);
	boolean conjuntoVacio();
}
