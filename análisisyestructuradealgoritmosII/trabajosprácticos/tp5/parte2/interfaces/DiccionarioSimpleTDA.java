package tp5.parte2.interfaces;

public interface DiccionarioSimpleTDA {
	void inicializarDiccionario();
	void agregar(int clave, int valor);
	void eliminar(int clave);
	int recuperar(int clave);
	ConjuntoTDA claves();
}
