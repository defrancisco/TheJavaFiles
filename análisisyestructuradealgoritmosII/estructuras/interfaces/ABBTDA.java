package análisisyestructuradealgoritmosII.estructuras.interfaces;

public interface ABBTDA {
	void inicializarArbol();
	void agregarElem(int x); //�rbol inicializado
	void eliminarElem(int x); //�rbol inicializado
	int raiz(); //�rbol inicializado y no vac�o
	ABBTDA hijoIzq(); //�rbol inicializado y no vac�o
	ABBTDA hijoDer(); //�rbol inicializado y no vac�o
	boolean arbolVacio(); //�rbol inicializado
}
