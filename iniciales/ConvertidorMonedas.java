package Iniciales;

import java.util.Scanner;

public class ConvertidorMonedas {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("---Conversión de Monedas---");
        System.out.println("Entre la cantidad en USD: ");
        double usd = scanner.nextDouble();

        System.out.println("Elige la conversión (1: EUR, 2: JPY, 3: GBP, 4: ARG)");
        int conversion = scanner.nextInt();

        double convertido;

        scanner.close();

        switch (conversion) {
            case 1:
                convertido = usd * 0.85;
                System.out.println(usd + " USD = " + convertido + " EUR");
                break;
            case 2:
                convertido = usd * 110.53;
                System.out.println(usd + " USD = " + convertido + " JPY");
                break;
            case 3:
                convertido = usd * 0.75;
                System.out.println(usd + " USD = " + convertido + " GBP");
                break;
            case 4:
                convertido = usd * 939.41;
                System.out.println(usd + " USD = " + convertido + " ARG");
                break;
            default:
                System.out.println("ERROR! Elección incorrecta.");
                break;
        }
    }
}
