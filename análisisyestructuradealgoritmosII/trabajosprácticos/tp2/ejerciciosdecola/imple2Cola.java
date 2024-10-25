package tp2.ejerciciosdecola;

public class imple2Cola implements colaTDA{
    public int[] arr;
    public int indice;
    @Override
    public void inicializarCola() {
        arr = new int[100];
        indice = 0;

    }

    @Override
    public void acolar(int x) {
        arr[indice] = x;
        indice++;

    }

    @Override
    public void desacolar() {
        for(int i = 0; i < indice -1; i++){
            arr[i] = arr[i+1];
        }
        indice--;

    }

    @Override
    public int primero() {
        return arr[0];
    }

    @Override
    public boolean colaVacia() {
        return (indice == 0);
    }
}
