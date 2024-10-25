package ejercicio1;

public class ejerciciopráctico {


	public static void main(String[] args) {

		ABBTDA arbol = new ABB();
		arbol.InicializarArbol();
		
		arbol.AgregarElem(1);
		arbol.AgregarElem(12);
		arbol.AgregarElem(13);
		
		int nro = 12;
		ConjuntoTDA respuesta1 = ejercicio1(arbol, nro);
		System.out.println("Elementos mayores que " + nro + ": " + respuesta1);

	
		//Liste en pre order los elementos del árbol
		System.out.println("Elementos en pre-orden:");
		
	}
	//Consigna : devolver un conjunto de valores > a x 
	public static ConjuntoTDA ejercicio1(ABBTDA a, int nro) {
		ConjuntoTDA resp = new Conjunto();
		if(!a.ArbolVacio()) {
			if(a.Raiz() < nro) {
				resp.Agregar(a.Raiz());
			}
			ejercicio1(a.HijoIzq(), nro);
			ejercicio1(a.HijoDer(), nro);
		}
		return resp;
	}
	
	private static void preOrder(ABBTDA a) {
		System.out.println(a.Raiz());
		preOrder(a.HijoIzq());
		preOrder(a.HijoDer());
	}

}
