package clase1;

public class Combinaciones {
    public static boolean existeCombinacion(int[] arr, int objetivo){
        int n = arr.length;
        int totalCombinaciones = (int) Math.pow(2, n);  //total de combinaciones posibles

        //iterar sobre todas las combinaciones posibles
        for(int i = 0; i<totalCombinaciones; i++){
            int suma = 0; //comienzo mi variable suma

            //vertifico cada bit de la combinación
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) >0){ // si el bit j esta encendido
                    if((i & (1 << j)) > 0){ //si ese bit j esta encendido
                        suma += arr[j]; // suamamos el elemento correspondiente
                    }
                }
                //verifico cada bit de la cominación
                if(suma == objetivo){
                    return true;
                }
            }
        }
        // si ninguna combinación suma el objetivo retornar false
        return false;
    } 
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int objetivo = 10;
        boolean resultado = existeCombinacion(arr, objetivo);
        System.out.println("¿Existe una combinación que sume " + objetivo + "? " + resultado);
    }
    

}
