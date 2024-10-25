package tp5.parte2.implementacionesdinamicas;
import tp5.parte2.interfaces.*;
public class DiccionarioSimpleDinamica implements DiccionarioSimpleTDA {

	private class NodoClave{
		int clave;
		int valor;
		NodoClave sigClave;
	}
	private NodoClave origen;
	
	public void inicializarDiccionario() {
		origen = null;
	}


	private NodoClave Clave2NodoClave(int clave) {
		NodoClave aux = origen;
		while(aux != null && aux.clave != clave) {
			aux = aux.sigClave;
		}
		return aux;
	}
	public void agregar(int clave, int valor) {
		NodoClave nc = Clave2NodoClave(clave);
		if(nc == null) {
			nc = new NodoClave();
			nc.clave = clave;
			nc.sigClave = origen;
			origen = nc;
		}
		nc.valor = valor;
		
	}


	public void eliminar(int clave) {
		if(origen != null) {
			origen = origen.sigClave;
		}else {
			NodoClave aux = origen;
			while(aux.sigClave != null && aux.sigClave.clave != clave) {
				aux = aux.sigClave;
			}
			if(aux.sigClave != null) {
				aux.sigClave = aux.sigClave.sigClave;
			}
		}
	}


	public int recuperar(int clave) {
		NodoClave  n = Clave2NodoClave(clave);
		return n.valor;
	}


	public ConjuntoTDA claves() {
		ConjuntoTDA c = new ConjuntoDinamica();
		c.inicializarConjunto();;
		
		NodoClave aux = origen;
		while(aux != null) {
			c.agregar(aux.clave);
			aux = aux.sigClave;
		}
		return c;
	}
	

}
