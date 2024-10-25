package ejercicio1;

public interface ABBTDA {
	void InicializarArbol(); //sin precondiciones
	int Raiz(); // árbol inicialziado y no vacío
	ABBTDA HijoIzq(); // árbol inicialziado y no vacío
	ABBTDA HijoDer(); // árbol inicialziado y no vacío
	boolean ArbolVacio(); // árbol inicialziado 
	void AgregarElem(int x); // árbol inicialziado 
	void EliminarElem(int x); // árbol inicialziado 
}
