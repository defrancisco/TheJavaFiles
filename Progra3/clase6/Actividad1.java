package Progra3.clase6;
/*
 * ESTRATEGIA:
 * podemos descomponerlo en subproblemas más pequeños
 * y reutilizar soluciones de subproblemas ya resueltos
 * 
 * La idea es construir una tabla donde cada celda representa
 * el valor máx que se peude obtener con capacidad de 
 * mochila y un conjunto de objetos
 */


public class Actividad1 {
    public static void main(String[] args) {
        int[] pesos = {3,4,2}; // pesos de los objetos
        int[] valores = {4,5,6}; // valores de los objetos
        int capacidad = 6; // capacidad de la mochila max

        // llamamos a la función que resuelve el problema
        int maxValor = mochila(pesos, valores, capacidad);
        System.out.println("El valor máximo que se puede obtener es: " + maxValor);

    }

    /**
     * @param pesos
     * @param valores
     * @param capacidad
     * @return
     */
    public static int mochila(int[] pesos, int[] valores, int[] capacidad){
        int n = pesos.length; // nro de objetos
        int[][] dp = new int[n+1][capacidad +1]; // tabla DP
        //fila : objeto columnas : capacidad que va aumentando 
        
        //relleno la tabla DP
        for(int i = 1; i <= n; i++){
            for(int j = 1; j<= capacidad; j++){
                if(pesos[i-1] <= j){
                    // Si el peso del objeto i-ésimo es menor o igual a la capacidad w
                    dp[i][j] = Math.max(valores[i - 1] + dp[i - 1][w - pesos[i - 1]], dp[i - 1][w]);
                } else{
                    // Si el peso del objeto i-ésimo es mayor que la capacidad w
                    dp[i][j] = d´[i-1][j];
                }
            }
        }
        // El valor máximo que se puede obtener con la capacidad dada[^2^][2]
        return dp[n][capacidad];
    
    }

    
}