package clase7.Actividad3;

import java.util.Scanner;

public class FloydWarshall {
    final static int INF = 99999;  // Valor grande para representar infinito.

    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();
        
        // Matriz de adyacencia que representa el grafo
        int graph[][] = { 
                            {0, 8, INF, 5},    // Nodo 0 conectado a 1 (8) y a 3 (5)
                            {INF, 0, -3, INF}, // Nodo 1 conectado a 2 (-3)
                            {INF, INF, 0, 2},  // Nodo 2 conectado a 3 (2)
                            {INF, INF, INF, 0} // Nodo 3 no tiene conexiones directas
                        };

        int V = graph.length;  // Número de vértices
        fw.floydWarshall(graph, V);  // Ejecutamos el algoritmo

        // Pedimos al usuario el vértice de origen y destino
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el vértice de origen (0 a " + (V-1) + "): ");
        int origen = scanner.nextInt();
        System.out.println("Ingrese el vértice de destino (0 a " + (V-1) + "): ");
        int destino = scanner.nextInt();

        // Imprimimos el camino más corto entre el origen y el destino
        System.out.println("El camino más corto desde " + origen + " hasta " + destino + " es: ");
        fw.imprimirCamino(origen, destino);  // Se utiliza la matriz P para reconstruir el camino

        scanner.close();
    }

    int dist[][];  // Matriz de distancias
    int P[][];     // Matriz de reconstrucción de caminos

    // Algoritmo de Floyd-Warshall
    // Complejidad: O(V^3), donde V es el número de vértices
    void floydWarshall(int graph[][], int V) {
        dist = new int[V][V];  // Inicializamos la matriz de distancias
        P = new int[V][V];     // Inicializamos la matriz de reconstrucción de caminos

        // Inicialización de las matrices de distancia y reconstrucción de caminos
        // Complejidad: O(V^2), ya que recorremos todos los pares de nodos
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];  // Inicializamos la matriz de distancias
                if (i != j && graph[i][j] != INF) {
                    P[i][j] = i;  // Si hay un camino directo, inicializamos con el nodo de origen
                } else {
                    P[i][j] = -1; // Si no hay camino, lo inicializamos como -1
                }
            }
        }

        // Aplicamos el algoritmo de Floyd-Warshall
        // Complejidad: O(V^3), debido a los tres bucles anidados
        for (int k = 0; k < V; k++) {  // Vértice intermedio
            for (int i = 0; i < V; i++) {  // Vértice de origen
                for (int j = 0; j < V; j++) {  // Vértice de destino
                    // Si pasar por el nodo k mejora la distancia entre i y j
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];  // Actualizamos la distancia
                        P[i][j] = P[i][k];  // Actualizamos el siguiente nodo en el camino más corto
                    }
                }
            }
        }

        // Verificamos si hay ciclos negativos
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                System.out.println("Existe un ciclo negativo en el grafo");
                return;
            }
        }
    }

    // Función para imprimir el camino más corto entre dos nodos
    // Complejidad: O(V) en el peor caso, ya que se recorre el camino
    void imprimirCamino(int origen, int destino) {
        if (P[origen][destino] == -1) {  // Si no hay camino entre los nodos
            System.out.println("No hay camino entre " + origen + " y " + destino);
            return;
        }
        imprimirCaminoRecursivo(origen, destino);  // Reconstruimos el camino recursivamente
        System.out.println(destino);  // Finalmente, imprimimos el destino
    }

    // Método recursivo para reconstruir el camino desde origen hasta destino
    // Complejidad: O(V) en el peor caso
    void imprimirCaminoRecursivo(int origen, int destino) {
        if (P[origen][destino] == origen) {  // Si hemos llegado al origen del camino
            System.out.print(origen + " -> ");
            return;
        }
        imprimirCaminoRecursivo(origen, P[origen][destino]);  // Llamada recursiva para continuar el camino
        System.out.print(P[origen][destino] + " -> ");  // Imprimimos el nodo intermedio
    }
}
