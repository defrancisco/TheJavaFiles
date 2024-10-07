package clase3;
/*
 * Buscar el mayor elem en una lista
 */
public class EjemploRecursivo {
    private static int suma(int[] nums, int i){
        if(i == nums.length -1){ // si i es igual al úlitmo indice del arreglo
            return nums[nums.length-1]; // devuelvo ese último elem
        }else{
            return nums[i] + suma(nums, i+1); // sumamos el elem actual + más el resultado de la llamada recursiv aque calcula la suma de los elems restantes
        }
    }
    private static int suma1(int[] nums){
        return suma(nums, 0); // paso indice inicial 0
    }

    
    public static void main(String[] args) {
        int[] num = {3,4,5,6};
        System.out.println(suma1(num));
    }

}
/*
 * - Primera llamada: suma(numeros, 0) numeros[0] es 3. Llama a suma(numeros, 1).
 * - Segunda llamada: suma(numeros, 1) numeros[1] es 4. Llama a suma(numeros, 2)-
 * - Tercera llamada: suma(numeros, 2) numeros[2] es 5. Llama a suma(numeros, 3).
 * - Cuarta llamada: suma(numeros, 3) numeros[3] es 6. 
 * Como i es igual a numeros.length - 1, retorna 6.
 * 
 * Ahora, las llamadas recursivas empiezan a resolverse:
 * Resolviendo la tercera llamada: numeros[2] (5) + suma(numeros, 3) (6) = 11.
 * Retorna 11.
 * Resolviendo la segunda llamada: numeros[1] (4) + suma(numeros, 2) (11) = 15. 
 * Retorna 15.
 * Resolviendo la primera llamada: numeros[0] (3) + suma(numeros, 1) (15) = 18.
 * Retorna 18.
 */
