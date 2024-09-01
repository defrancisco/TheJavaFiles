package iniciales;

import java.util.Random;
import java.util.Scanner;


public class JuegoDeAdivinanzas {

    public static void main(String[] args){
        Random random = new Random();
        int numeroAdivinar = random.nextInt(100) +1;
        int numeroIntentos = 0;
        Scanner scanner = new Scanner(System.in);
        int intento;
        boolean gana = false;

        System.out.println("---Adivina el Número---");
        while (!gana) {
            System.out.println("Adivina un número entre el 1 y el 100: ");
            intento = scanner.nextInt();
            numeroIntentos++;
            
            if(intento == numeroAdivinar){
                gana = true;
            }else if(intento < numeroAdivinar){
                System.out.println("Muy chico! Su intento es más grande que el número a adivinar");
            }else{
                System.out.println("Muy grande! Su intento es más chico que el número a adivinar");
            }
        }
    
        scanner.close();

        System.out.println("¡Felicidades ha encontrado el número!");
        System.out.println("Su número era: "+ numeroAdivinar + " | Ha tardado "+ numeroIntentos + " intentos.");
    }
}