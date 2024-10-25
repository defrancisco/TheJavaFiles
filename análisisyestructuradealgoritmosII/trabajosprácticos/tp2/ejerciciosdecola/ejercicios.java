package tp2.ejerciciosdecola;

import tp2.ejerciciosdepila.imple1Pila;
import tp2.ejerciciosdepila.pilaTDA;

public class ejercicios {
    public static void main(String[] args) {
        colaTDA micola = new imple1Cola();
        micola.inicializarCola();
        micola.acolar(1);
        micola.acolar(2);
        micola.acolar(3);
        micola.acolar(4);
        micola.acolar(5);

        colaTDA micola2 = new imple1Cola();
        micola2.inicializarCola();
        micola2.acolar(1);
        micola2.acolar(2);
        micola2.acolar(3);
        micola2.acolar(4);
        micola2.acolar(5);

        System.out.println("Cola original:");
        mostrarCola(micola);
        System.out.println("Ejercicio 6.a");
        colaTDA a = pasarCola(micola);
        System.out.println("Cola original:");
        mostrarCola(a);
        System.out.println("Ejercicio 6.b");
        colaTDA b = invertirColaConPilas(micola);
        System.out.println("Cola invertida con pilas:");
        mostrarCola(b);
        System.out.println("Ejercicio 6.c");
        colaTDA c = invertirColaSinPilas(micola);
        System.out.println("Cola invertida con pilas:" + c);
        System.out.println("Ejercicio 6.d");




    }
    public static void mostrarCola(colaTDA cola) {
        colaTDA colaAux = new imple1Cola();
        colaAux.inicializarCola();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            cola.desacolar();
            colaAux.acolar(elemento);
            System.out.print(elemento + " ");
        }

        while (!colaAux.colaVacia()) {
            cola.acolar(colaAux.primero());
            colaAux.desacolar();
        }

        System.out.println();
    }

    public static colaTDA pasarCola(colaTDA orginal){
        colaTDA destino = new imple1Cola();
        destino.inicializarCola();

        while(!orginal.colaVacia()){
            destino.acolar(orginal.primero());
            orginal.desacolar();
        }
        return destino;
    }



    public static colaTDA invertirColaConPilas(colaTDA original){
        pilaTDA pilaaux = new imple1Pila();
        pilaaux.inicializarPila();

        colaTDA invertida = new imple1Cola();
        invertida.inicializarCola();

        while (!original.colaVacia()){ //1,2,3 =Co
            pilaaux.apilar(original.primero());//1,2,3 = Paux
            original.desacolar();
        }
        while(!pilaaux.pilaVacia()){
            //original.acolar(pilaaux.tope());
            invertida.acolar(pilaaux.tope()); //3,2,1
            pilaaux.desapilar();
        }

        return invertida;//3,2,1

    }

    public static colaTDA invertirColaSinPilas(colaTDA original){ //REVISAR
        colaTDA colaInvertida = new imple1Cola();
        colaInvertida.inicializarCola();

        while (!original.colaVacia()) { //1,2,3
            colaInvertida.acolar(original.primero());//1.2.3
            original.desacolar();
        }

        return colaInvertida;
    }


    /**
     * Razonamiento
     * @param c1
     * @param c2
     * @return
     * Pasa los elementos de la cola original.
     * Mientras ambas colas (la original y la auxiliar) no estén vacías, desacola un elemento de cada cola y compáralos.
     * Si los elementos son iguales, continúa desacolando elementos. Si son diferentes, las colas no coinciden en su final.
     * Si una de las colas se vacía antes que la otra, significa que sus longitudes no son iguales y no pueden coincidir en el final.
     */
    public static boolean coincidenFinalesDeColas(colaTDA c1, colaTDA c2){
        colaTDA aux1 = new imple1Cola();
        colaTDA aux2 = new imple1Cola();

        aux1.inicializarCola();
        aux2.inicializarCola();
        //C1 = 1,2,3,4,5
        //C2 = 5,346,4,5
        //debo realizar "copias" de ambas colas
        while(!c1.colaVacia()){
            aux1.acolar(c1.primero());
            c1.desacolar();
        }

        while(!c2.colaVacia()){
            aux2.acolar(c2.primero());
            c2.desacolar();
        }

        int final1 = 0;
        int final2 = 0;


        while(!aux1.colaVacia() && !aux2.colaVacia()){
            final1 = aux1.primero();
            final2 = aux2.primero();
            aux1.desacolar();
            aux2.desacolar();
        }
        //aca verifico si coinciden
        return final1 == final2;

    }


}
