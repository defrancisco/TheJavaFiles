package ejercicio1;

public class ABB implements ABBTDA {
	
	private class NodoABB {
		int info;
		ABBTDA hijoIzq;
		ABBTDA hijoDer;
	}
	
	private NodoABB a;


	public void InicializarArbol() {
		a = null;
	}


	public int Raiz() {
		return a.info;
	}


	public ABBTDA HijoIzq() {
		return a.hijoIzq;
	}


	public ABBTDA HijoDer() {
		return a.hijoDer;
	}


	public boolean ArbolVacio() {
		return (a == null);
	}

	//métodos privados
	private int mayor(ABBTDA a) {
		if (a.HijoDer() .ArbolVacio()) {
			return a.Raiz(); 
		}
		else {
			return mayor(a.HijoDer()); 
		}
	}
	
	private int menor(ABBTDA a) {
		if(a.HijoIzq().ArbolVacio()) {
			return a.Raiz();
		}
		else {
			return menor(a.HijoIzq());
		}
	}
	
	
	
	public void AgregarElem(int x) {
		if(a ==null) { // hago el árbol desde cero
			//raíz
			a = new NodoABB();
			a.info = x;
			//izq
			a.hijoIzq = new ABB();
			a.hijoIzq.InicializarArbol();
			//der
			a.hijoDer = new ABB();
			a.hijoDer.InicializarArbol();
		} else if (a.info > x){
			a.hijoIzq.AgregarElem(x); //árbol izquierdo
		}else if(a.info < x) {
			a.hijoDer.AgregarElem(x); //árbol derecho
		}
		else;
	}


	public void EliminarElem(int x) {
		if(a != null) {
			//si es una hoja
			if (a.info == x && a.hijoIzq.ArbolVacio() && a.hijoDer.ArbolVacio()) {
				a = null;
			}else if (a.info == x && !a.hijoIzq.ArbolVacio()) {
				//busco el mayor de los menores
				int mayor = mayor(a.hijoIzq);
				//reemplazo la info
				a.info = mayor;
				//reemplazo con el mayor de los menores
				a.hijoIzq.EliminarElem(mayor);
			}else if (a.info == x && a.hijoDer.ArbolVacio()) {
				//busco el menor de los mayores
				int menor = menor(a.hijoDer);
				//reemplazo la info
				a.info = menor;
				//reemplazo con el menor de los mayores
				a.hijoDer.EliminarElem(menor);
			}else if (a.info < x){
				//sigo buscando a la derecha
				a.hijoDer.EliminarElem(x);
			}else {
				//sigo buscando a la izquierda
				a.hijoIzq.EliminarElem(x);
			}
		}
		
	}
	
	
}
