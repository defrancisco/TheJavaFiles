package tp5.parte2.interfaces;

public interface ABBTDA {
	void inicialziarArbol();
	void agregarElem(int x);
	void eliminarElem(int x);
	int raiz();
	ABBTDA hijoIzq();
	ABBTDA hijoDer();
	boolean arboloVacio();
}
