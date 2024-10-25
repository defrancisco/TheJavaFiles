package tp2.ejerciciosdepila;

import java.util.Scanner;

public class ejercicios {

    public static void main(String[] args) {
        pilaTDA mipila = new imple1Pila();
        pilaTDA pila2 = new imple1Pila();
        mipila.inicializarPila();
        pila2.inicializarPila();
        mipila.apilar(1);
        mipila.apilar(2);
        mipila.apilar(3);
        mipila.apilar(1);
        mipila.apilar(3);
        mipila.apilar(4);


        System.out.println("Pila original:");
        imprimir(mipila);

        System.out.println("Ejercicio 3.a");
        pasarPilaA(mipila, pila2);

        System.out.println("Ejercicio 3.b");
        pilaTDA b = pasarPilaB(mipila);
        imprimir(b);
        System.out.println("Ejercicio 3.c");
        pilaTDA c = invertirPila(mipila);
        imprimir(c);
        
        System.out.println("Ejercicio 3.d");
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Ingrese un número para verificar si hay repeticiones: ");
			int nro = scanner.nextInt();
			boolean d = existeRepetidosEnPila(mipila, 1);
			System.out.println("El número " + nro + " tiene elementos repetidos: " + d);
		}
        
        System.out.println("Ejercicio 3.e");
        pilaTDA e = eliminarImpares(mipila);
        imprimir(e);

    }

    public static void imprimir(pilaTDA miPila) {
        System.out.println("Elementos de la pila:");
        pilaTDA aux = new imple1Pila();
        aux.inicializarPila();

        // Pasar elementos de miPila a aux y mostrarlos
        while (!miPila.pilaVacia()) {
            int elemento = miPila.tope();
            System.out.println(elemento);
            aux.apilar(elemento);
            miPila.desapilar();
        }

        // Restaurar los elementos a miPila
        while (!aux.pilaVacia()) {
            miPila.apilar(aux.tope());
            aux.desapilar();
        }
    }

    // Función para imprimir los elementos de una pila
    public static void imprimirPila(pilaTDA pila) {
        pilaTDA aux = new imple1Pila();
        aux.inicializarPila();

        // Copiar elementos de la pila a aux para imprimir sin modificar la pila original
        while (!pila.pilaVacia()) {
            System.out.print(pila.tope() + " ");
            aux.apilar(pila.tope());
            pila.desapilar();
        }

        // Restaurar la pila original
        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }

        System.out.println();
    }
    public static void pasarPilaA(pilaTDA original, pilaTDA destino) {
        // Vaciamos la pila original y apilamos sus elementos en la pila destino
        while (!original.pilaVacia()) {
            destino.apilar(original.tope());
            original.desapilar();
        }
    }

    public static pilaTDA pasarPilaB(pilaTDA original) {

        pilaTDA resp = new imple1Pila();
        pilaTDA aux = new imple1Pila();
        resp.inicializarPila();
        aux.inicializarPila();



        // Pasar elementos de la pila original a la pila auxiliar en orden inverso
        //1,2,3  = O
        //3,2,1 = A
        while (!original.pilaVacia()) {
            aux.apilar(original.tope());
            original.desapilar();
        }

        // Pasar elementos de la pila auxiliar a la pila de respuesta en el mismo orden
        while (!aux.pilaVacia()) {
            //1,2,3  = O
            //1,2,3  = A
            int elemento = aux.tope(); //1
            resp.apilar(elemento);//1
            original.apilar(elemento); //1 Restauramos la pila original
            aux.desapilar();//1
        }
        return resp;
    }

    public static pilaTDA invertirPila(pilaTDA orginial){
        pilaTDA resp = new imple1Pila();
        resp.inicializarPila();

        while(!orginial.pilaVacia()){
            resp.apilar(orginial.tope());
            orginial.desapilar();
        }
        return resp;

    }

    public static boolean existeRepetidosEnPila(pilaTDA pila, int x) {
        int contador = 0;
        pilaTDA aux = new imple1Pila();
        aux.inicializarPila();

        // Pasar elementos de la pila original a una pila auxiliar
        while (!pila.pilaVacia()) {
            int elem = pila.tope();
            if (elem == x) {
                contador++;
            }
            aux.apilar(elem);
            pila.desapilar();
        }

        // Restaurar los elementos a la pila original
        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }

        // Verificar si hay más de una ocurrencia del elemento dado
        return (contador > 1);
    }

    public static pilaTDA eliminarImpares(pilaTDA pila){
        pilaTDA aux = new imple1Pila();
        pilaTDA resp = new imple1Pila();
        aux.inicializarPila();
        resp.inicializarPila();

        while(!pila.pilaVacia()){
            int x = pila.tope();
            if(x % 2 != 0){
                aux.apilar(x);
            }
            pila.desapilar();
        }

        while(!aux.pilaVacia()){
            resp.apilar(aux.tope());
            aux.desapilar();
        }

        return resp;
    }




   /**
public static pilaTDA pasarPilaMedianteCola(pilaTDA original){
    pilaTDA resp = new imple1Pila();
    colaTDA colaaux = new imple1Cola();

    resp.inicializarPila();
    colaaux.inicializarCola();

    //P = 1,2,3
    //PAUX = 3,2,1 --> 1 - 2- 3
    //COLA = 3 ,2,1 --> 3 , 2,1
    while(!original.pilaVacia()){
     colaaux.acolar(original.tope());
     original.desapilar();
    }

 while(!colaaux.colaVacia()){
     resp.apilar(colaaux.primero());
     colaaux.desacolar;
 }
    return resp;
}
 **/



}
