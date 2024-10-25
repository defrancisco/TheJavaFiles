package tp5.parte1;


public class ListaDoble {

	    NodoDoble primero;
	    NodoDoble ultimo;

	    public ListaDoble() {
	        this.primero = null;
	        this.ultimo = null;
	    }

	    // Método para determinar la lista vacía
	    public boolean isEmpty() {
	        return primero == null;
	    }

	    // Método para agregar un elemento
	    public void add(int x) {
	        NodoDoble nuevo = new NodoDoble();
	        nuevo.setInfo(x);

	        if (isEmpty()) {
	            primero = nuevo;
	            ultimo = nuevo;
	        } else {
	            ultimo.setNext(nuevo);
	            nuevo.setPrev(ultimo);
	            ultimo = nuevo;
	        }
	    }

	    // Método para eliminar la primera ocurrencia de un valor
	    public void eliminar(int value) {
	        NodoDoble current = primero;

	        while (current != null) {
	            if (current.getInfo() == value) {
	                if (current == primero) {
	                    primero = current.getNext();
	                    if (primero != null) {
	                        primero.setPrev(null);
	                    } else {
	                        ultimo = null;
	                    }
	                } else if (current == ultimo) {
	                    ultimo = current.getPrev();
	                    if (ultimo != null) {
	                        ultimo.setNext(null);
	                    } else {
	                        primero = null;
	                    }
	                } else {
	                    current.getPrev().setNext(current.getNext());
	                    current.getNext().setPrev(current.getPrev());
	                }
	                return;
	            }
	            current = current.getNext();
	        }
	    }

	    // Método para buscar la primera ocurrencia de un valor
	    public NodoDoble existe(int value) {
	        NodoDoble current = primero;

	        while (current != null) {
	            if (current.getInfo() == value) {
	                return current;
	            }
	            current = current.getNext();
	        }
	        return null;
	    }

	    // Método para eliminar todas las ocurrencias de un valor
	    public void eliminarTodas(int value) {
	        NodoDoble current = primero;

	        while (current != null) {
	            NodoDoble next = current.getNext();
	            if (current.getInfo() == value) {
	                if (current == primero) {
	                    primero = current.getNext();
	                    if (primero != null) {
	                        primero.setPrev(null);
	                    } else {
	                        ultimo = null;
	                    }
	                } else if (current == ultimo) {
	                    ultimo = current.getPrev();
	                    if (ultimo != null) {
	                        ultimo.setNext(null);
	                    } else {
	                        primero = null;
	                    }
	                } else {
	                    current.getPrev().setNext(current.getNext());
	                    current.getNext().setPrev(current.getPrev());
	                }
	            }
	            current = next;
	        }
	    }

	    // Método para convertir a un solo String
	    public String toString() {
	        NodoDoble current = primero;
	        StringBuilder out = new StringBuilder();

	        while (current != null) {
	            out.append(" ").append(current.getInfo());
	            current = current.getNext();
	        }
	        return out.toString();
	    }
	

}
