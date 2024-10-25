package tp5.parte1;

public class Nodo {
	private int info;
	private Nodo next;


	public Nodo() {
		
		this.next = null;
	}
	
	public void setInfo(int value) {
		this.info = value;
	}
	
	public int getInfo() {
		return this.info;
	}
	public void setNext(Nodo next) {
		this.next = next;
	}
	public Nodo getNext() {
		return this.next;
	}
	
}

