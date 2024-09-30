package Actividad4;

public class sleccionPaquetesFB 
{
    static int mejorCombinacion(int[] costos, int[] beneficios, int presupuesto) 
    {
        int n = costos.length;
        int mejorBeneficio = 0;

        // Probar todas las combinaciones posibles (2^n combinaciones)
        for (int i = 0; i < (1 << n); i++) 
        {  // "1 << n" es 2^n
            int costoTotal = 0;
            int beneficioTotal = 0;

            // Recorremos cada bit de la combinación actual
            for (int j = 0; j < n; j++) 
            {
                if ((i & (1 << j)) != 0) 
                {  // Si el bit j está activado en i
                    costoTotal += costos[j];
                    beneficioTotal += beneficios[j];
                }
            }

            // Verificar si el costo total no excede el presupuesto y si el rendimiento es mejor
            if (costoTotal <= presupuesto && beneficioTotal > mejorBeneficio) 
                mejorBeneficio = beneficioTotal;
            
        }

        // Retornar el mejor resultado
        return mejorBeneficio;
    }



    public static void main(String[] args) 
    {
        int [] costos = {3,2,5};
        int [] ganancias = {30, 40, 60};
        int presupuesto = 8;
        
        System.out.println("el beneficio maximo con el presupuesto " + presupuesto + " es: " + mejorCombinacion(costos, ganancias, presupuesto));
    }

    
}
