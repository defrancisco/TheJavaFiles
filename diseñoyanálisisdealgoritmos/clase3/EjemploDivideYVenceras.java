package Progra3.clase3;

public class EjemploDivideYVenceras {
    private static int sumaDV(int[] nums, int i, int f){
        // i -> inicio | f  -> final
        if(i == f){
            return nums[i];
        }

        int mitad = (f+i)/ 2;
        // la lista, desde el inicio hasta la mitad
        int izq = sumaDV(nums, i, mitad);
        // la lsita, desde la mitad hasta el final
        int der = sumaDV(nums, mitad, f);
        return izq + der;
    }
    

    private static int suma(int[] n){
        return sumaDV(n, 0, n.length);
    }

    public static void main(String[] args) {
        int[] num = {3,5,6,9,9};
        System.out.println(suma(num));
    }
}

/*
 * Ejecución Paso a Paso
 * Para el arreglo {3, 5, 6, 9, 9}:
 * 1. Divide en {3, 5} y {6, 9, 9}.
 * 2. {3, 5} se divide en {3} y {5}.
 * 3. {6, 9, 9} se divide en {6} y {9, 9}.
 * 4. {9, 9} se divide en {9} y {9}.
 * 5. Combina los resultados: 3 + 5 = 8, 6 + (9 + 9) = 24.
 * 6. Finalmente, 8 + 24 = 32.
 * 7. El resultado final es 32
 */