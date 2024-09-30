package Actividad3;

/*
 * El enfoque de fuerza bruta es útil para asegurar que se prueban todas las 
 * combinaciones posibles y encontrar la solución óptima, pero su complejidad 
 * O(2^n * n) lo hace ineficiente para un número grande de proyectos. 
 * 
 * Este tipo de algoritmos es adecuado para problemas pequeños debido 
 * al crecimiento exponencial de las combinaciones.
 */

public class SeleccionProyectosFuerzaBruta {
    // Clase Proyecto que almacena el costo y el beneficio de cada proyecto
    static class Proyecto {
        int costo;
        int beneficio;

        // Constructor del Proyecto
        public Proyecto(int costo, int beneficio) {
            this.costo = costo;
            this.beneficio = beneficio;
        }

        public int getCosto(){
            return costo;
        }

        public int getBeneficio(){
            return beneficio;
        }

        // Sobrescribir toString para mostrar el proyecto
        @Override
        public String toString() {
            return "costo: " + costo + " beneficio: " + beneficio;
        }
    }

    // Clase Resultado para almacenar el beneficio máximo y el costo total de la mejor combinación
    static class Resultado{
        int beneficioMaximo;
        int costoTotal;

        // Constructor de Resultado
        public Resultado(int beneficioMaximo, int costoTotal){
            this.beneficioMaximo = beneficioMaximo;
            this.costoTotal = costoTotal;
        }

        public int getBeneficioMaximo(){
            return beneficioMaximo;
        }
    }

    // Función para encontrar la mejor combinación de proyectos
    // Complejidad: O(2^n * n), donde n es el número de proyectos. Existe un doble ciclo anidado de for
    // Se generan 2^n combinaciones, y por cada combinación se itera sobre n proyectos
    static Resultado mejorCombinacion(Proyecto[] proyectos, int presupuesto) {
        int n = proyectos.length;  // Número de proyectos
        int mejorBeneficio = 0;    // Almacena el mejor beneficio encontrado
        int mejorCosto = 0;        // Almacena el costo total asociado al mejor beneficio

        // Probar todas las combinaciones posibles de proyectos (2^n combinaciones)
        for (int i = 0; i < (1 << n); i++) {  
            // "1 << n" es equivalente a 2^n, ya que cada bit de i representa un proyecto
            int costoTotal = 0;     // Almacena el costo total de la combinación actual
            int beneficioTotal = 0; // Almacena el beneficio total de la combinación actual

            // Recorremos cada bit de la combinación actual (i) para verificar qué proyectos están seleccionados
            for (int j = 0; j < n; j++) {
                // Si el bit j está activado en i, significa que el proyecto j está incluido en la combinación
                if ((i & (1 << j)) != 0) {  
                    costoTotal += proyectos[j].getCosto();  // Sumamos el costo del proyecto j
                    beneficioTotal += proyectos[j].getBeneficio();  // Sumamos el beneficio del proyecto j
                }
            }

            // Verificamos si el costo total de la combinación no excede el presupuesto
            // y si el beneficio obtenido es mayor al mejor beneficio encontrado hasta ahora
            if (costoTotal <= presupuesto && beneficioTotal > mejorBeneficio) {
                mejorBeneficio = beneficioTotal;  // Actualizamos el mejor beneficio
                mejorCosto = costoTotal;          // Actualizamos el mejor costo total
            }
        }

        // Retornamos el resultado con el beneficio máximo y el costo total asociado
        return new Resultado(mejorBeneficio, mejorCosto);
    }

    
    public static void main(String[] args) {
        Proyecto [] proyectos = {
            new Proyecto(10, 100),
            new Proyecto(15, 200),
            new Proyecto(20, 150),
            new Proyecto(25, 300)
        };
        int presupuesto = 40;

        Resultado resultado = mejorCombinacion(proyectos, presupuesto);

        System.out.println("Beneficio máximo con el presupuesto " + presupuesto + " es: " + resultado.getBeneficioMaximo());
    }
    
}
