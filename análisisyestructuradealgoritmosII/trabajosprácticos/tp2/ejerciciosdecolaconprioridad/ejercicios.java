package tp2.ejerciciosdecolaconprioridad;



public class ejercicios {
    public static void main(String[] args) {
        colaprioridadTDA colaP1 = new impl1ColaConPrioridad();
        colaP1.inicializarColaPrioridad();
        colaprioridadTDA colaP2 = new impl1ColaConPrioridad();
        colaP2.inicializarColaPrioridad();

        colaP1.acolarPrioridad(2,8);
        colaP1.acolarPrioridad(7,3);
        colaP1.acolarPrioridad(1,10);

        colaP2.acolarPrioridad(1,1);
        colaP2.acolarPrioridad(5,6);
        colaP2.acolarPrioridad(4,9);

        System.out.println("Cola Con Proridad 1 ---");

        System.out.println("Cola Con Proridad 2 ---");

        System.out.println("Ejercicio 9.a");
        colaprioridadTDA a = combinarColaConPrioridad(colaP1,colaP2);
        imprimirCola(a);

        System.out.println("Ejercicio 9.b");
        colaprioridadTDA cola = new impl1ColaConPrioridad();
        cola.inicializarColaPrioridad();
        cola.acolarPrioridad(1, 1);
        cola.acolarPrioridad(2, 2);
        cola.acolarPrioridad(3, 3);
        colaprioridadTDA b = invertirColaConColaPrioridad(cola);
        System.out.println(b);
        System.out.println("Ejercicio 9.c");
        int suma = sumaDeValoresDePrioridadPar(colaP2);
        System.out.println("La suma de los valores con prioridad par de la cola es :" + suma);




    }

    public static void imprimirCola(colaprioridadTDA cola) {
        while (!cola.colaPrioridadVacia()) {
            int elemento = cola.primero();
            int prioridad = cola.prioridad();
            System.out.println("Elemento: " + elemento + " - Prioridad: " + prioridad);
            cola.desacolar();
        }
        System.out.println();
    }

    public static colaprioridadTDA combinarColaConPrioridad(colaprioridadTDA CP1, colaprioridadTDA CP2){
        colaprioridadTDA resp = new impl1ColaConPrioridad();
        resp.inicializarColaPrioridad();
        //chequeo que no esten vacías
        while(!CP1.colaPrioridadVacia() && !CP2.colaPrioridadVacia()){
            int prioCP1 = CP1.prioridad();
            int prioCP2 = CP2.prioridad();

            if(prioCP1 >= prioCP2){
                resp.acolarPrioridad(CP1.primero(), CP1.prioridad());
                CP1.desacolar();
            }else{
                resp.acolarPrioridad(CP2.primero(), CP2.prioridad());
                CP2.desacolar();
            }
        }
        return resp;
    }

    public static colaprioridadTDA invertirColaConColaPrioridad(colaprioridadTDA cola) {
        colaprioridadTDA aux = new impl1ColaConPrioridad();
        aux.inicializarColaPrioridad();

        // Copiamos los elementos de 'cola' a 'aux' invirtiendo su orden
        int pos = 0;
        while (!cola.colaPrioridadVacia()) {
            int elem = cola.primero();
            aux.acolarPrioridad(elem, pos);
            cola.desacolar();
            pos++;
        }

        // Copiamos los elementos de 'aux' de vuelta a 'cola'
        while (!aux.colaPrioridadVacia()) {
            int elem = aux.primero();
            int prio = aux.prioridad();
            cola.acolarPrioridad(elem, prio);
            aux.desacolar();
        }


        return cola;
    }


    public static int sumaDeValoresDePrioridadPar(colaprioridadTDA c1){
        int suma = 0;
        while(!c1.colaPrioridadVacia()){
            if(c1.prioridad() % 2 == 0) {
                suma += c1.primero();
            }
            c1.desacolar();
        }
        return suma;
    }
}
