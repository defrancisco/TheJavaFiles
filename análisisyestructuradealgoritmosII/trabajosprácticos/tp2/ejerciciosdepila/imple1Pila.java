package tp2.ejerciciosdepila;

public class imple1Pila implements pilaTDA{
    public int[] arr;
    public int indice;
    @Override
    public void inicializarPila() {
        arr = new int[100];
        indice = 0;

    }

    @Override
    //1,2,3 +4 1,2,3,4
    public void apilar(int x) {
        arr[indice] = x;
        indice++;

    }
    @Override
    public void desapilar(){
        indice--;
    }

    @Override
    public int tope() {
        return arr[indice-1];
    }

    @Override
    public boolean pilaVacia() {
        return (indice == 0);
    }
}
