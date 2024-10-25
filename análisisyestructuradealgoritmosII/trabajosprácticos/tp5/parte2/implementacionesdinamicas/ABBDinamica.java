package tp5.parte2.implementacionesdinamicas;
import tp5.parte2.interfaces.*;
public class ABBDinamica implements ABBTDA{
	private class NodoABB{
		int info;
		ABBTDA hI;
		ABBTDA hD;
	}
	
	private NodoABB a;

	public void inicialziarArbol() {
		 a= null;
		
	}

	
	// metodos privados --------------------
	private int mayor(ABBTDA a) {
		if(a.hijoDer().arboloVacio()) {
			return a.raiz();
		}else {
			return mayor(a.hijoDer());
		}
	}
	
	private int menor(ABBTDA a) {
		if(a.hijoIzq().arboloVacio()) {
			return a.raiz();
		}else {
			return menor(a.hijoIzq());
		}
	}
	//--------------------------------------
	
	
	public void agregarElem(int x) {
		if(a == null) {
			a = new NodoABB();
			a.info = x;
			a.hI = new ABBDinamica();
			a.hI.inicialziarArbol();
			a.hD = new ABBDinamica();
			a.hD.inicialziarArbol();
		}else if(a.info > x) {
			a.hI.agregarElem(x);
		}else if(a.info < x) {
			a.hD.agregarElem(x);
		}else {
			;
		}
		
	}


	public void eliminarElem(int x) {
		if(a != null) {
			if(a.info == x && a.hI.arboloVacio() && a.hD.arboloVacio()) { //si no hay nada más que la raiz
				a = null;
			}else if (a.info == x && !a.hI.arboloVacio()) {
				int mayor = mayor(a.hI);
				a.info = mayor; //reemplazo con el mayor de los menores
				a.hI.eliminarElem(mayor);
			}else if(a.info == x && !a.hD.arboloVacio()) {
				int menor = menor(a.hD);
				a.info = menor; //reemplazo con el menor de los mayores
				a.hD.eliminarElem(menor);
			}
		}
		
	}

	public int raiz() {
		return a.info;
	}


	public ABBTDA hijoIzq() {
		return a.hI;
	}


	public ABBTDA hijoDer() {
		return a.hD;
	}


	public boolean arboloVacio() {
		return (a == null);
	}
	
}
