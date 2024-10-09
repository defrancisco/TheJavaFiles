package clase10;

import java.util.ArrayList;
import java.util.List;

public class backtrackingEjemplo {

    // Método que genera todas las combinaciones posibles de un conjunto
    public static void generarCombinaciones(int[] conjunto, List<Integer> combinacionActual, int posicion) {
        // Caso base: si hemos llegado al final del conjunto (ya recorrimos todos los elementos)
        if (posicion == conjunto.length) {
            // Imprimimos la combinación actual
            System.out.println(combinacionActual);
            return; // Terminamos la recursión para esta rama
        }

        // Primera opción: incluir el elemento actual en la combinación 
        // Añadimos el elemento actual del conjunto a la combinación
        combinacionActual.add(conjunto[posicion]);

        // Llamamos recursivamente para generar combinaciones incluyendo este elemento
        generarCombinaciones(conjunto, combinacionActual, posicion + 1);

        // Backtracking: deshacemos la elección previa 
        // Quitamos el último elemento que añadimos (retrocedemos para explorar nuevas combinaciones)
        combinacionActual.remove(combinacionActual.size() - 1);

        // Segunda opción: no incluir el elemento actual en la combinación 
        // Llamamos recursivamente, pero sin añadir el elemento actual
        generarCombinaciones(conjunto, combinacionActual, posicion + 1);
    }

    public static void main(String[] args) {
        int[] conjunto = {1, 2, 3}; // conjunto de elementos posibles
        List<Integer> combinacionActual = new ArrayList<>();  // lista que almacenará las combinaciones
        generarCombinaciones(conjunto, combinacionActual, 0); // empezamos en la posición 0
    }
}