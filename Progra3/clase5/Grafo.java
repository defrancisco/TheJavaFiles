package Progra3.clase5;
import java.util.*;

public class Grafo 
{
    static class arista
    {
        int destino;
        int tiempo;

        arista(int destino, int tiempo)
        {
            this.destino = destino;
            this.tiempo = tiempo;
        }
    }
    
    static class grafo
    {
        private List<List<arista>> matriz;
        private int numVertices;

        grafo(int numVertices)
        {
            this.numVertices = numVertices;
            matriz = new ArrayList<>();
            for (int i = 0; i < numVertices; i ++)
            {
                matriz.add(new ArrayList<>());
            }
        }

        public void agregarArista(int o, int d, int tiempo)
        {
            matriz.get(o).add(new arista(d, tiempo));
            matriz.get(d).add(new arista(o, tiempo));
        }

        public List<List<arista>> getMatriz()
        {
            return matriz;
        }

        public int getNumVertices()
        {
            return numVertices;
        }
    }
    
}
