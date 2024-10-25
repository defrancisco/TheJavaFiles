package impleLocal;

import tdaLocal.ColaPModTDA;

public class ColaPMod2 implements ColaPModTDA {

	private class Elemento {
		int valor;
		int prioridad;
	}

	private Elemento[] elementos;
	private int indice;

	public int sumaPrioridades() {
		int suma = 0;
		for (int i = 0; i<indice; i++) {
			suma += elementos[i].prioridad;
		}
		return suma;
	}
	
	public void inicializarCola() {
		indice = 0;
		elementos = new Elemento[100];
	}

	public void acolarPrioridad(int x, int prioridad) {
		int j = indice;
		//desplaza a derecha los elementos de la cola mientras
		//estos tengan mayor o igual prioridad que la de x
		while (j > 0 && elementos[j-1].prioridad >= prioridad) {
			elementos[j] = elementos[j-1];
			j--;
		}
		elementos[j] = new Elemento();
		elementos[j].valor = x;
		elementos[j].prioridad = prioridad;
		indice++;
	}

	public void desacolar() {
		//elementos[indice - 1] = null;
		indice --;
	}

	public int primero() {
		return elementos[indice-1].valor;
	}

	public int prioridad() {
		return elementos[indice-1].prioridad;
	}

	public boolean colaVacia() {
		return (indice == 0);
	}
}

