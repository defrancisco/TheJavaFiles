package clase11.Actividad2;

import java.util.LinkedList;
import java.util.Queue;

public class Actividad2 {
    // Método para realizar el recorrido BFS
    public static void BFS(int[][] grafo, int nodoInicial) {
        // Crear una cola para almacenar los nodos a visitar
        Queue<Integer> cola = new LinkedList<>();
        // Crear un arreglo para marcar los nodos visitados
        boolean[] visitado = new boolean[grafo.length];

        // Agregar el nodo inicial a la cola y marcarlo como visitado
        cola.add(nodoInicial);
        visitado[nodoInicial] = true;

        // Mientras la cola no esté vacía
        while (!cola.isEmpty()) {
            // Desencolar el primer nodo de la cola
            int nodoActual = cola.poll();
            // Imprimir el nodo actual
            System.out.print(nodoActual + " ");

            // Explorar cada vecino del nodo actual
            for (int i = 0; i < grafo[nodoActual].length; i++) {
                // Si hay una conexión y el vecino no ha sido visitado
                if (grafo[nodoActual][i] == 1 && !visitado[i]) {
                    // Agregar el vecino a la cola
                    cola.add(i);
                    // Marcar el vecino como visitado
                    visitado[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Definir el grafo como una matriz de adyacencia
        int[][] grafo = {
            {0, 1, 1, 0, 0, 0, 0, 0, 0}, // Conexiones del nodo 0
            {1, 0, 0, 1, 0, 0, 0, 0, 0}, // Conexiones del nodo 1
            {1, 0, 0, 0, 0, 1, 0, 0, 0}, // Conexiones del nodo 2
            {0, 1, 0, 0, 1, 0, 0, 0, 0}, // Conexiones del nodo 3
            {0, 0, 0, 1, 0, 0, 0, 1, 0}, // Conexiones del nodo 4
            {0, 0, 1, 0, 0, 0, 0, 0, 0}, // Conexiones del nodo 5
            {0, 0, 0, 0, 0, 0, 0, 0, 1}, // Conexiones del nodo 6
            {0, 0, 0, 0, 1, 0, 0, 0, 0}, // Conexiones del nodo 7
            {0, 0, 0, 0, 0, 0, 1, 0, 0}  // Conexiones del nodo 8
        };
        // Llamar al método BFS empezando desde el nodo 0
        BFS(grafo, 0);
        
    }

}