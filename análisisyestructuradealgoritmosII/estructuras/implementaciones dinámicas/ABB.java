  package impleLocal;

import tdaLocal.ABBTDA;

public class ABB implements ABBTDA {
	private class NodoABB {
		int info;
		ABBTDA hI;
		ABBTDA hD;
	} 
	private NodoABB a;

	public void inicializarArbol(){
		a = null;
	}

	public int raiz(){
		return a.info;
	}

	public boolean arbolVacio(){
		return (a == null);
	}

	public ABBTDA hijoDer(){
		return a.hD;
	}

	public ABBTDA hijoIzq(){
		return a.hI;
	}

	private int mayor(ABBTDA a){
		if (a.hijoDer().arbolVacio())
			return a.raiz(); //llegamos
		else
			return mayor(a.hijoDer()); //no llegamos todav�a
	}

	private int menor(ABBTDA a){
		if (a.hijoIzq().arbolVacio())
			return a.raiz(); //llegamos
		else
			return menor(a.hijoIzq()); //no llegamos todav�a
	}

	 
	public void agregarElem(int x){
		if (a == null) { //caso de �rbol vac�o
			a = new NodoABB();
			a.info = x;
			a.hI = new ABB();
			a.hI.inicializarArbol();
			a.hD = new ABB();
			a.hD.inicializarArbol();
		} else if (a.info > x) //caso de �rbol izquierdo
			a.hI.agregarElem(x);
		else if (a.info < x) //caso de �rbol derecho
			a.hD.agregarElem(x);
		else //lo encontr� a x
			;//no tengo que hacer nada
	}

	public void eliminarElem(int x){
		if (a != null) { //verificaci�n de �rbol no vac�o
			if (a.info == x && a.hI.arbolVacio() && a.hD.arbolVacio()) { //es una hoja
				a = null;
			} else if (a.info == x && !a.hI.arbolVacio()) {
				int mayor = mayor(a.hI);
				a.info = mayor; //reemplazamos con el mayor de los menores
				a.hI.eliminarElem(mayor);
			} else if (a.info == x && a.hI.arbolVacio()) { //!a.hD.arbolVacio()
				int menor = menor(a.hD);
				a.info = menor; //reemplazamos con el menor de los mayores
				a.hD.eliminarElem(menor);
			} else if (a.info < x) { //seguimos buscando por los mayores (derecha)
				a.hD.eliminarElem(x);
			} else { //a.info > x
				a.hI.eliminarElem(x); //seguimos buscando por los menores (izquierda)
			}
		} else //no lo encontr� a x
			; //no tengo que hacer nada
	}
} 
