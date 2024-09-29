package Actividad4;
public class seleccionPaquetesDP 
{
    public static int seleccionPaquetes(int[] costos, int[] ganancia, int presupuesto)
    {
        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        for (int i = 1; i <= n; i++)
        {
            for (int j = 0; j <= presupuesto; j ++)
            {
                if (costos[i-1] <= j)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costos[i - 1]] + ganancia[i - 1]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][presupuesto];
    }

    public static void main(String[] args) 
    {
        int [] costos = {3,2,5};
        int [] ganancias = {30, 40, 60};
        int presupuesto = 8;
        
        System.out.println("el beneficio maximo con el presupuesto " + presupuesto + " es: " + seleccionPaquetes(costos, ganancias, presupuesto));
    }
    
}
