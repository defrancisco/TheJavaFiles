package Actividad4;
import java.util.*;

public class seleccionPaquetesGreedy 
{
    static class paquete 
    {
        int costo;
        int ganancia;

        public paquete(int costo, int ganancia) 
        {
            this.costo = costo;
            this.ganancia = ganancia;
        }

        @Override
        public String toString() 
        {
            return "costo: " + costo + "ganancia: " + ganancia;
        }
    }
    
    public static int optimizarPresupuesto(int[] costos, int[] ganancias, int presupuesto) 
    {
        paquete[] paquetes = new paquete[costos.length];
        
        for (int i = 0; i < costos.length; i++) 
        {
            paquetes[i] = new paquete(costos[i], ganancias[i]);
        }

        Arrays.sort(paquetes, (a, b) -> Double.compare(b.ganancia, a.ganancia));

        int gananciaTotal = 0;
        int costoTotal = 0;

        for (paquete p : paquetes) 
        {
            if (costoTotal + p.costo <= presupuesto) 
            {
                costoTotal += p.costo;
                gananciaTotal += p.ganancia;
            }
        }
        return gananciaTotal;
    }
    

    public static void main(String[] args) 
    {

        int[] costos = {10, 15, 20, 25};
        int[] ganancias = {100, 200, 150, 300};
        int presupuesto = 40;

        int gananciaMaxima = optimizarPresupuesto(costos, ganancias, presupuesto);


        System.out.println("Beneficio máximo con el presupuesto " + presupuesto + " es: " + gananciaMaxima);
    }
}