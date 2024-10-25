package tp2.ejerciciosdepila;

public class imple2Pila implements pilaTDA{
    /**
     * Cuando agregamos un nuevo elemento a la pila, en evez
     * de hacerlo en la posición señalada por la variable que me indica la cantidad
     * de elementos, se guarda en la primera posición
     *  //1,2,3 +4 | 4,1,2,3
     */
    public int[] arr;
    public int indice;
    @Override
    public void inicializarPila() {
        arr = new int[100];
        indice = 0;

    }

    @Override
    public void apilar(int x) {
        for(int i = indice-1; i >=0; i--){
            arr[i+1] = arr[i];
        arr[0] = x;
        indice++;
        }

    }

    @Override
    public void desapilar() {
        for(int i = 0; i<indice; i++){
            arr[i]= arr[i+1];
        indice--;
        }
    }

    @Override
    public int tope() {
        return arr[0];
    }

    @Override
    public boolean pilaVacia() {
        return (indice==0);
    }
}
