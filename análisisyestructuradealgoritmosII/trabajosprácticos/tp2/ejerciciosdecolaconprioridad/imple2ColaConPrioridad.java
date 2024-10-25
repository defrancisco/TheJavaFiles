package tp2.ejerciciosdecolaconprioridad;

public class imple2ColaConPrioridad  implements  colaprioridadTDA{
    int[] elementos;
    int[] prioridades;
    int indice;

    @Override
    public void inicializarColaPrioridad() {
          indice = 0;
          elementos = new int[100];
          prioridades = new int[100];
    }

    @Override
    public void acolarPrioridad(int x, int prio) {
        // desplaza a derecha los elementos de la cola mientras
        // estos tengan mayor o igual prioridad que la de x
         int j = indice;
         for(; j >0 && prioridades[j-1] >= prio; j--){
             elementos[j] = elementos[j-1];
             prioridades[j] = prioridades[j-1];
         }
         elementos[j] = x;
         prioridades[j]= prio;
        indice++;

    }

    @Override
    public void desacolar() {
        indice--;

    }

    @Override
    public int primero() {
        return elementos[indice-1];
    }

    @Override
    public int prioridad() {
        return prioridades[indice-1];
    }

    @Override
    public boolean colaPrioridadVacia() {
        return false;
    }
}
