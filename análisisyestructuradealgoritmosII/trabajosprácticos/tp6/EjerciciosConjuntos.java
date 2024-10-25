package tp6;

import tp5.parte2.interfaces.ConjuntoTDA;
import tp5.parte2.implementacionesdinamicas.ConjuntoDinamica;

public class EjerciciosConjuntos {
    
    public static void main(String[] args) {
        ConjuntoTDA A = new ConjuntoDinamica();
        A.inicializarConjunto();
        
        ConjuntoTDA B = new ConjuntoDinamica();
        B.inicializarConjunto();
        
        A.agregar(1);
        A.agregar(2);
        A.agregar(3);
        
        B.agregar(3);
        B.agregar(4);
        B.agregar(5);

        // Verificar si son iguales
        boolean sonIguales = conjuntosIguales(A, B);
        System.out.println("¿Son A y B iguales? " + sonIguales);

        // Unión de A y B
        ConjuntoTDA union = unionConjuntos(A, B);
        System.out.println("Unión de A y B: ");
        printConjunto(union);

        // Intersección de A y B
        ConjuntoTDA interseccion = interseccionConjuntos(A, B);
        System.out.println("Intersección de A y B: ");
        printConjunto(interseccion);
    }
    
    private static boolean conjuntosIguales(ConjuntoTDA a, ConjuntoTDA b) {
        ConjuntoTDA copiaA = copiarConjunto(a);
        ConjuntoTDA copiaB = copiarConjunto(b);
        while (!copiaA.conjuntoVacio()) {
            int elem = copiaA.elegir();
            if (!copiaB.pertenece(elem)) {
                return false;
            }
            copiaA.sacar(elem);
            copiaB.sacar(elem);
        }
        return copiaB.conjuntoVacio();
    }

    private static ConjuntoTDA unionConjuntos(ConjuntoTDA a, ConjuntoTDA b) {
        ConjuntoTDA C = new ConjuntoDinamica();
        C.inicializarConjunto();
        return unionRecursiva(copiarConjunto(a), copiarConjunto(b), C);
    }
    
    private static ConjuntoTDA unionRecursiva(ConjuntoTDA a, ConjuntoTDA b, ConjuntoTDA c) {
        if (!a.conjuntoVacio()) {
            int elem = a.elegir();
            if (!c.pertenece(elem)) {
                c.agregar(elem);
            }
            a.sacar(elem);
            unionRecursiva(a, b, c);
            a.agregar(elem);
        }
        
        if (!b.conjuntoVacio()) {
            int elemb = b.elegir();
            if (!c.pertenece(elemb)) {
                c.agregar(elemb);
            }
            b.sacar(elemb);
            unionRecursiva(a, b, c);
            b.agregar(elemb);
        }
        
        return c;
    }

    private static ConjuntoTDA interseccionConjuntos(ConjuntoTDA a, ConjuntoTDA b) {
        ConjuntoTDA c = new ConjuntoDinamica();
        c.inicializarConjunto();
        return interseccionRecursiva(copiarConjunto(a), copiarConjunto(b), c);
    }
    
    private static ConjuntoTDA interseccionRecursiva(ConjuntoTDA a, ConjuntoTDA b, ConjuntoTDA c) {
        if (!a.conjuntoVacio()) {
            int elem1 = a.elegir();
            if (b.pertenece(elem1)) {
                c.agregar(elem1);
            }
            a.sacar(elem1);
            interseccionRecursiva(a, b, c);
            a.agregar(elem1);
        }
        
        return c;
    }

    private static ConjuntoTDA copiarConjunto(ConjuntoTDA conjunto) {
        ConjuntoTDA copia = new ConjuntoDinamica();
        copia.inicializarConjunto();
        ConjuntoTDA aux = new ConjuntoDinamica();
        aux.inicializarConjunto();
        
        while (!conjunto.conjuntoVacio()) {
            int elem = conjunto.elegir();
            copia.agregar(elem);
            aux.agregar(elem);
            conjunto.sacar(elem);
        }

        while (!aux.conjuntoVacio()) {
            int elem = aux.elegir();
            conjunto.agregar(elem);
            aux.sacar(elem);
        }

        return copia;
    }

    private static void printConjunto(ConjuntoTDA conjunto) {
        ConjuntoTDA aux = copiarConjunto(conjunto);
        while (!aux.conjuntoVacio()) {
            int elem = aux.elegir();
            System.out.print(elem + " ");
            aux.sacar(elem);
        }
        System.out.println();
    }
}
