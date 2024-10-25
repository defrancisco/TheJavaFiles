package tp2.ejerciciosdecolaconprioridad;

public class impl1ColaConPrioridad  implements colaprioridadTDA{
    public  class Elemento{
        int valor;
        int prioridad;
    }

    public Elemento[] elementos;
    private int indice;
    @Override
    public void inicializarColaPrioridad() {
        indice = 0;
        elementos = new Elemento[100];

    }

    @Override
    public void acolarPrioridad(int x, int prio) {
        int j = indice;
        for(;j >0 && elementos[j-1].prioridad >= prio;j--){
            elementos[j] = elementos[j-1];
        }
        elementos[j] = new Elemento();
        elementos[j].valor = x;
        elementos[j].prioridad = prio;
        indice++;


    }

    @Override
    public boolean colaPrioridadVacia() {

        return (indice==0);
    }

    @Override
    public void desacolar() {
        indice--;

    }

    @Override
    public int primero() {
        return elementos[indice-1].valor;
    }

    @Override
    public int prioridad() {
        return elementos[indice-1].prioridad;
    }
}
