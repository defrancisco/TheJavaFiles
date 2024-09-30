package clase7.Actividad1;

public class FloydWarshall {
    final static int INF = 99999;  // Usamos un valor grande para representar el infinito (ausencia de camino)

    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();
        
        // Matriz de adyacencia que representa el grafo
        int graph[][] = { 
                            {0, 2, INF, 5},    // Nodo 0 conectado a 1 (2) y a 3 (5)
                            {INF, 0, INF, 4},  // Nodo 1 conectado a 3 (4)
                            {INF, INF, 0, INF},// Nodo 2 no tiene conexiones directas
                            {INF, INF, 2, 0}   // Nodo 3 conectado a 2 (2)
                        };
        int V = graph.length;  // Número de vértices
        fw.floydWarshall(graph, V);  // Llamada al algoritmo
    }

    // Método que implementa el algoritmo de Floyd-Warshall
    // Complejidad: O(V^3), donde V es el número de vértices
    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];  // Matriz de distancias mínimas

        // Inicialización de la matriz de distancias
        // Complejidad: O(V^2), ya que se recorren todos los pares de vértices
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];  // Copiamos los valores de la matriz de adyacencia
            }
        }

        // Bucle triple para calcular las distancias más cortas entre todos los pares de nodos
        // Complejidad: O(V^3), ya que hay 3 bucles anidados sobre los vértices
        for (int k = 0; k < V; k++) {      // Consideramos cada vértice k como intermedio
            for (int i = 0; i < V; i++) {  // Recorremos todos los vértices de origen i
                for (int j = 0; j < V; j++) {  // Recorremos todos los vértices de destino j
                    // Si pasar por k mejora la distancia de i a j, actualizamos la distancia
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];  // Actualizamos la distancia mínima
                    }
                }
            }
        }

        // Llamamos a la función que imprime la matriz final de distancias más cortas
        printSolution(dist, V);
    }

    // Método para imprimir la matriz de distancias
    // Complejidad: O(V^2), ya que recorremos la matriz de distancias completa
    void printSolution(int dist[][], int V) {
        System.out.println("Matriz de distancias más cortas entre cada par de vértices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                // Si no hay camino entre i y j, imprimimos "INF"
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    // Imprimimos la distancia mínima
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
