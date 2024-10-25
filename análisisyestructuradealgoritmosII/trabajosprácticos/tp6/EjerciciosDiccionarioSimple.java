package tp6;

import tp5.parte2.implementacionesdinamicas.*;
import tp5.parte2.interfaces.*;

public class EjerciciosDiccionarioSimple {
    
    public static void main(String[] args) {
        DiccionarioSimpleTDA d = new DiccionarioSimpleDinamica();
        d.inicializarDiccionario();
        
        d.agregar(1, 1);
        d.agregar(2, 2);
        d.agregar(3, 3);
        d.agregar(4, 4);
        
        System.out.println("Punto A:");
        ListaEnlazada listaPares = clavesPares(d);
        listaPares.imprimir();
        
        System.out.println("Punto B:");
        ListaEnlazada listaMayoresQueN = valoresMayoresQue(d, 2);
        listaMayoresQueN.imprimir();
    }
    
    public static ListaEnlazada clavesPares(DiccionarioSimpleTDA d) {
        ListaEnlazada listaPares = new ListaEnlazada();
        ConjuntoTDA claves = d.claves();
        
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            claves.sacar(clave);
            
            if (clave % 2 == 0) {
                listaPares.agregar(clave);
            }
        }
        
        return listaPares;
    }
    
    public static ListaEnlazada valoresMayoresQue(DiccionarioSimpleTDA d, int n) {
        ListaEnlazada listaMayoresQueN = new ListaEnlazada();
        ConjuntoTDA claves = d.claves();
        
        while (!claves.conjuntoVacio()) {
            int clave = claves.elegir();
            claves.sacar(clave);
            
            int valor = d.recuperar(clave);
            if (valor > n) {
                listaMayoresQueN.agregar(valor);
            }
        }
        
        return listaMayoresQueN;
    }
}

