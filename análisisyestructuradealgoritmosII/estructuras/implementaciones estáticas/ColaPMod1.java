package impleLocal;

import tdaLocal.ColaPModTDA;

public class ColaPMod1 implements ColaPModTDA {

	private class Elemento {
		int valor;
		int prioridad;
	}

	private Elemento[] elementos;
	private int indice;
	private int sumaP;
	
	public int sumaPrioridades() {
		return sumaP;
	}
	
	public void inicializarCola() {
		indice = 0;
		elementos = new Elemento[100];
		sumaP = 0;
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
		sumaP += prioridad; //sumaP = sumaP + prioridad;
	}

	public void desacolar() {
		//elementos[indice - 1] = null;
		sumaP -= elementos[indice-1].prioridad;
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

