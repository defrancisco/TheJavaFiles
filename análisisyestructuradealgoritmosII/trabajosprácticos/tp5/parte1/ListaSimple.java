package tp5.parte1;



public class ListaSimple {
	Nodo primero;
	Nodo ultimo;
	public ListaSimple() {
		this.primero = new Nodo();
	}
	
	public void add(int x) {
		Nodo nuevo = new Nodo();
		nuevo.setInfo(x);
		
		Nodo pivote = new Nodo();
		pivote = this.primero;
		while(pivote.getNext() != null) {
			pivote = pivote.getNext();
		}
		pivote.setNext(nuevo);
	}
	
	public String toString() {
		Nodo pivote;
		String out = "";
		pivote = primero.getNext();
		while(pivote != null) {
			out = out + " " + pivote.getInfo();
			pivote = pivote.getNext();
		}
		return out;
	}
	public Nodo existe(int value) {
		Nodo pivote;
		pivote = primero.getNext();
		while (pivote != null) {
			if(pivote.getInfo() == value) {
				return pivote;
			}
			pivote = pivote.getNext();
		}
		return null;
	}
	
	public void eliminar(int value) {
		Nodo prev;
		Nodo pivote;
		
		prev = this.primero;
		pivote = prev.getNext();
		while((pivote != null) && (pivote.getInfo() != value)) {
			prev = pivote;
			pivote = prev.getNext();
		}
		if(pivote != null) {
			prev.setNext(pivote.getNext());
		}
	}
	
}
