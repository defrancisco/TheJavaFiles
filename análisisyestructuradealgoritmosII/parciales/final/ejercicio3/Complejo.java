package ejercicio3;

public class Complejo implements ComplejoTDA {
	private float real;
	private float imaginario;

	//CONSTRUCTOR DE NROS COMPLEJOS
	public Complejo(float real, float imaginaria) {
		// TODO Auto-generated method stub
		this.real = real;
		this.imaginario = imaginario;
	}

	//SETTERS
	public void setReal(float real) {
		this.real = real;
	}

	public void setImaginario(float imaginario) {
		this.imaginario = imaginario;
	}

	//GETTERS
	public float getReal() {
		return real;
	}
	public float getImaginario() {
		return imaginario;
	}
	
	//Método de Sumar
	static ComplejoTDA suma(ComplejoTDA c1, ComplejoTDA c2) {
		float nuevaReal = c1.getReal() + c2.getReal();
		float nuevaImaginario = c1.getImaginario() + c2.getImaginario();
		return new Complejo(nuevaReal, nuevaImaginario); //esto esta con error porque me falta la implementación ahora
	}
	
	
	//----------------------------------------------------------------
	public String toString() {
		return real + " + " + imaginario + "i";
	}
	
	
	//Ejerccio d
	public static void main(String[] args) {
		ComplejoTDA c1 = new Complejo(4,5);
		ComplejoTDA c2 = new Complejo(2,3);
		
		ComplejoTDA SUMA = ComplejoTDA.suma(c1, c2);
		System.out.println("La suma de " + c1 + " y " + c2 + " es " + SUMA);
	}
	
	
	

}
