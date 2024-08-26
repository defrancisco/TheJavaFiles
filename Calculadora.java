package Iniciales;

import java.util.Scanner;

public class Calculadora{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //acá podemos ingresar por teclado

        System.out.println("---CALCULADORA---");
        System.out.println("Entrar el primer número: ");
        double num1 = scanner.nextDouble(); //capturo ese nro


        System.out.println("Entrar el segundo número: ");
        double num2 = scanner.nextDouble(); //capturo ese nro

        System.out.println("Elegir la operación a realizar (+,-,*,/)");
        char operación = scanner.next().charAt(0);

        double resultado = 0;

        scanner.close();

      

        switch (operación) {
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '*':
                resultado = num1 * num2;
                break;
            case '/':
                if(num2 != 0){
                    resultado = num1 / num2;
                }else{
                    System.out.println("SYSTEM ERROR: No es posible dividir por cero.");
                }
                break;
            default:
            System.out.println("Operación no válida");
                break;
        }

        System.out.println("El resultado es: " + resultado);
    
    }
}