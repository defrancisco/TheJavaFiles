package ejercicio1;

public class Conjunto implements ConjuntoTDA {
	
	private class Nodo{
		int info;
		Nodo sig;
	}
	
	private Nodo c;


	public void InicializarConjunto() {
		c = null;
	}


	public void Agregar(int x) {
		if(!this.Pertenece(x)) {
			Nodo nodo = new Nodo();
			nodo.info = x;
			nodo.sig = c;
			c = nodo;
		}
		
	}


	public int Elegir() {
		return c.info;
	}


	public boolean ConjuntoVacio() {
		return (c == null);
	}


	public void Sacar(int x) {
		if ( c != null) { // si el conjunto no es vacio
			if (c.info == x) { // si encontre mi nodo...
				c = c.sig; //lo reemplazo por el siguiente
			} else { //lo estamos buscando
				Nodo aux = c;
				while(aux.sig != null && aux.sig.info != x) {
					aux = aux.sig; //continuo sucando
				}
				//!!!!!!!!!!!!!!!!!!!!!
				if(aux.sig != null) { //no comprendo esta parte :(
					aux.sig = aux.sig.sig;
				}
			}
			
		}
		
	}


	public boolean Pertenece(int x) {
		Nodo aux = c;
		while(aux != null && aux.info != x) {
			aux = aux.sig;
		}
		return (aux != null);
	}

}
