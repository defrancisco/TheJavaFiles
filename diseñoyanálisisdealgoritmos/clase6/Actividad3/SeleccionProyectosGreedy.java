package Actividad3;
import java.util.*;
/*
 * El algoritmo greedy es eficiente en términos de tiempo comparado con la fuerza bruta,
 * ya que evita probar todas las combinaciones posibles. 
 * Con una complejidad de O(n log n), puede manejar un número mayor de proyectos sin 
 * problemas significativos de rendimiento.
 * 
 * Este enfoque es útil cuando se busca una solución rápida que no necesariamente es la óptima, 
 * pero funciona bien en muchos casos.
 */
public class SeleccionProyectosGreedy {
    // Clase Proyecto que almacena el costo y el beneficio de cada proyecto
    static class Proyecto {
        int costo;
        int beneficio;

        // Constructor de la clase Proyecto
        public Proyecto(int costo, int beneficio) {
            this.costo = costo;
            this.beneficio = beneficio;
        }

        @Override
        public String toString() {
            return "costo: " + costo + " beneficio: " + beneficio;
        }
    }
    
    // Método que implementa el algoritmo greedy para seleccionar proyectos
    // Complejidad: O(n log n) debido a la ordenación
    public static int optimizarPresupuesto(int[] costos, int[] beneficios, int presupuesto) {
        // Inicializamos un array de proyectos
        Proyecto[] proyectos = new Proyecto[costos.length];

        // Complejidad de la inicialización del array: O(n)
        for (int i = 0; i < costos.length; i++) {
            proyectos[i] = new Proyecto(costos[i], beneficios[i]);
        }

        // Ordenamos los proyectos por beneficio en orden descendente
        // Complejidad de la ordenación: O(n log n), donde n es el número de proyectos
        Arrays.sort(proyectos, (a, b) -> Double.compare(b.beneficio, a.beneficio));

        int beneficioTotal = 0;  // Variable para almacenar el beneficio total
        int costoTotal = 0;      // Variable para almacenar el costo total

        // Iteramos sobre los proyectos ordenados por beneficio
        // Complejidad de iterar sobre los proyectos: O(n)
        for (Proyecto proyecto : proyectos) {
            // Si el proyecto cabe en el presupuesto, lo seleccionamos
            if (costoTotal + proyecto.costo <= presupuesto) {
                costoTotal += proyecto.costo;      // Actualizamos el costo total
                beneficioTotal += proyecto.beneficio;  // Actualizamos el beneficio total
            }
        }

        // Retornamos el beneficio total obtenido
        return beneficioTotal;
    }


        

    public static void main(String[] args) {

        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;

        int beneficiosMaximo = optimizarPresupuesto(costos, beneficios, presupuesto);


        System.out.println("Beneficio máximo con el presupuesto " + presupuesto + " es: " + beneficiosMaximo);
    }
    

}
