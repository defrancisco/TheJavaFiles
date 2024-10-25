package ejercicio3;
public interface ComplejoTDA {
	/*
	 * NRO COMPLEJO : a+bi ---> a es parte real | b es parte imaginaria
	 */
	 //Crear Complejo(float real, float imaginaria); // Sin precondiciones. 
	/*JUSTFICACIÓN: eligo que el método " Crear " sea void ya que esaria creando en sí el método
	 * pero como lo necesito  en constructor lo comento
	 */
	void setReal(float real);
	/*JUSTIFICACIÓN: de un nro complejo ya creado se usa un "." y se pasa por parámetro un nro de
	 * la parte real que vamos a pisar de ese nro complejo
	 */
	void setImaginario(float imaginario);
	/*JUSTIFICACIÓN: de un nro complejo ya creado se usa un "." y se pasa por parámetro un nro de
	 * la parte imaginaria que vamos a pisar de ese nro complejo
	 */
	float getReal();
	/*JUSTIFICACIÓN: de un nro complejo ya creado se usa un "." y se obteniene la parte real del mismo
	 */
	float getImaginario();
	/*JUSTIFICACIÓN: de un nro complejo ya creado se usa un "." y y se obteniene la parte imaginaria
	 *del mismo
	 */
	
	
	//Método de Sumar
	static ComplejoTDA suma(ComplejoTDA c1, ComplejoTDA c2) {
		float nuevaReal = c1.getReal() + c2.getReal();
		float nuevaImaginario = c1.getImaginario() + c2.getImaginario();
		return new Complejo(nuevaReal, nuevaImaginario); //esto esta con error porque me falta la implementación ahora
	}
}
