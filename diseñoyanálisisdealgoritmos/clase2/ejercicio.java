package Progra3.clase2;

public class ejercicio {
    public static void main(String[] args) {
        int[][] mat =  {{4, 5, 6}, {7, 8, 9}, {5, 6, 7}};
        int suma = 0;
        for(int i = 0; i < mat.length; i++ ){ //1 + 2(n+1) +n = 3 + 2n
            for(int j = 0; j < mat[i].length; j++){ //1 + 2(n+1) + n = 3 + 3n
                suma += mat[i][j]; //2n
            }

        }
        double promedio =  (double) suma / (mat.length * mat[0].length); // 2
        System.out.println("Promedio: "+ promedio);
        
    }
    
}
