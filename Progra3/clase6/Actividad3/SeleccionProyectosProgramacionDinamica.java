package Actividad3;


/*
 * Este enfoque de programación dinámica garantiza encontrar la solución óptima, 
 * pero tiene un costo computacional mayor que el enfoque greedy. 
 * 
 * Sin embargo, es más eficiente que la fuerza bruta, especialmente en 
 * problemas con muchos proyectos y un presupuesto grande.
 */

public class SeleccionProyectosProgramacionDinamica 
{
    // Método que implementa la programación dinámica para seleccionar proyectos
    // Complejidad: O(n * P), donde n es el número de proyectos y P es el presupuesto
    public static int optimizarPresupuesto(int[] costos, int[] beneficios, int presupuesto) 
    {
        int n = costos.length;  // Número de proyectos
        // Matriz dp donde dp[i][j] representa el beneficio máximo usando los primeros i proyectos con un presupuesto j
        int[][] dp = new int[n + 1][presupuesto + 1];

        // Llenamos la tabla dp usando programación dinámica
        // Complejidad: O(n * P), ya que recorremos n proyectos y cada presupuesto de 0 a P
        for (int i = 1; i <= n; i++) 
        {
            for (int j = 0; j <= presupuesto; j++) 
            {
                // Si el proyecto i-1 cabe en el presupuesto j
                if (costos[i - 1] <= j) 
                    // Tomamos el máximo entre no incluir el proyecto y sí incluirlo
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costos[i - 1]] + beneficios[i - 1]);
                else 
                    // Si no cabe en el presupuesto, no lo incluimos
                    dp[i][j] = dp[i - 1][j];
            }
        }

        // Retornamos el beneficio máximo que se puede obtener con el presupuesto dado
        return dp[n][presupuesto];
    }
    /*
     * Resumen de la Complejidadc on Notación Big O:
     * 
     * Complejidad Temporal: O(n * P), donde n es el número de proyectos 
     * y P es el presupuesto disponible.
     * 
     * Complejidad Espacial: O(n * P), debido a la tabla dp[][] que almacena 
     * los resultados intermedios para cada combinación de proyectos y presupuestos.
     */

    public static void main(String[] args) 
    {
        int[] costos = {5, 3, 4};
        int[] beneficios = {60,50,70};
        int presupuesto = 8;

        int beneficiosMaximo = optimizarPresupuesto(costos, beneficios, presupuesto);
        System.out.println("Beneficio máximo con el presupuesto " + presupuesto + " es: " + beneficiosMaximo);
    }
}
