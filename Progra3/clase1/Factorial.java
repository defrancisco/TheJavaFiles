package Progra3.clase1;

class Factorial {
    public static int factorial(int n){
        if (n== 0 || n == 1){
            return 1;
        }else{
            return n * factorial(n-1);
        }
    }

    public static void main(String[] args) {
        int num = 5;
        int resultado = factorial(num);
        System.out.println("El factorial de "+ num+ " es : "+ resultado);
    }
    
}