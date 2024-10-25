package tp6;
import tp5.parte2.implementacionesdinamicas.*;
import tp5.parte2.interfaces.*;

public class EjerciciosDiccionarioMultiple {
	public static void main(String[] args) {
		DiccionarioMultipleTDA d = new DiccionarioMultipleDinamica();
        d.inicializarDiccionario();
        d.agregar(1, 1);
        d.agregar(2, 2);
        d.agregar(3, 3);
        d.agregar(4, 4);
        
        System.out.println("Punto A:");
        ListaEnlazada ejeA = mayoresQueN(d,2);
        ejeA.imprimir();
        System.out.println("Punto B:");
        ListaEnlazada ejeB = clavesPares(d);
        ejeB.imprimir();
    
    }
	
	/**
	 * a. Dado un diccionario múltiple y una clave del mismo devolver en una lista enlazada 
todas las claves que son mayores que un n dado.
	 * @param d
	 * @param n
	 * @return
	 */
	private static ListaEnlazada mayoresQueN(DiccionarioMultipleTDA d, int n) {
		ListaEnlazada listaClavesMayores = new ListaEnlazada();
		ConjuntoTDA claves = d.claves();
		if(!claves.conjuntoVacio()) {
			int clave = claves.elegir();
			if(clave > n) {
				listaClavesMayores.agregar(clave);
			}
			claves.sacar(clave);
		}
		return listaClavesMayores;
		
	}
	
	/***
	 * b. Dado un diccionario múltiple devolver en una lista enlazada todas las claves PARES
del mismo.
	 * @param d
	 * @return
	 */
	
	
	private static ListaEnlazada clavesPares(DiccionarioMultipleTDA d) {
		ListaEnlazada listaClavesPares = new ListaEnlazada();
		ConjuntoTDA claves = d.claves();
		if(!claves.conjuntoVacio()) {
			int clave = claves.elegir();
			if(clave % 2 == 0) {
				listaClavesPares.agregar(clave);
			}
			claves.sacar(clave);
		}
		return listaClavesPares;
	}
}
