package tp5.parte1;



public class Ejercicio1 {
	    Nodo primero;

	    public Ejercicio1() {
	        this.primero = new Nodo();
	    }

	    public void add(int x) {
	        Nodo nuevo = new Nodo();
	        nuevo.setInfo(x);
	        
	        Nodo pivote = this.primero;
	        while (pivote.getNext() != null) {
	            pivote = pivote.getNext();
	        }
	        pivote.setNext(nuevo);
	    }

	    public void insert(int index, int value) {
	        if (index < 0) return;

	        Nodo nuevo = new Nodo();
	        nuevo.setInfo(value);
	        
	        Nodo pivote = this.primero;
	        int contador = 0;

	        while (pivote != null && contador < index) {
	            pivote = pivote.getNext();
	            contador++;
	        }

	        if (pivote != null) {
	            nuevo.setNext(pivote.getNext());
	            pivote.setNext(nuevo);
	        }
	    }

	    public void remove(int index) {
	        if (index < 0) return;

	        Nodo prev = this.primero;
	        Nodo pivote = prev.getNext();
	        int contador = 0;

	        while (pivote != null && contador < index) {
	            prev = pivote;
	            pivote = pivote.getNext();
	            contador++;
	        }

	        if (pivote != null) {
	            prev.setNext(pivote.getNext());
	        }
	    }

	    public int get(int index) {
	        if (index < 0) return -1; // o lanzar una excepción

	        Nodo pivote = this.primero.getNext();
	        int contador = 0;

	        while (pivote != null && contador < index) {
	            pivote = pivote.getNext();
	            contador++;
	        }

	        if (pivote != null) {
	            return pivote.getInfo();
	        } else {
	            return -1; // o lanzar una excepción
	        }
	    }

	    public int size() {
	        Nodo pivote = this.primero.getNext();
	        int contador = 0;

	        while (pivote != null) {
	            contador++;
	            pivote = pivote.getNext();
	        }

	        return contador;
	    }

	    public boolean isEmpty() {
	        return this.primero.getNext() == null;
	    }

	    public String toString() {
	        Nodo pivote = primero.getNext();
	        StringBuilder out = new StringBuilder();
	        
	        while (pivote != null) {
	            out.append(" ").append(pivote.getInfo());
	            pivote = pivote.getNext();
	        }
	        return out.toString();
	    }

	    public Nodo existe(int value) {
	        Nodo pivote = primero.getNext();
	        
	        while (pivote != null) {
	            if (pivote.getInfo() == value) {
	                return pivote;
	            }
	            pivote = pivote.getNext();
	        }
	        return null;
	    }

	    public void eliminar(int value) {
	        Nodo prev = this.primero;
	        Nodo pivote = prev.getNext();
	        
	        while (pivote != null && pivote.getInfo() != value) {
	            prev = pivote;
	            pivote = prev.getNext();
	        }
	        if (pivote != null) {
	            prev.setNext(pivote.getNext());
	        }
	    }
	

}
