package tp6;

public class ListaEnlazada {
    public class Nodo {
        int valor;
        Nodo siguiente;
    }
    
    private Nodo cabeza;
    
    public ListaEnlazada() {
        cabeza = null;
    }
    
    public void agregar(int valor) {
        Nodo nuevo = new Nodo();
        nuevo.valor = valor;
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }
    
    public void imprimir() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.println(actual.valor);
            actual = actual.siguiente;
        }
    }
}

