package tp1;

import java.util.Scanner;

public class operadores {
    public static void main(String[] args) {
        System.out.println("Ejercicios Operadores");
        System.out.println("Ejercicio 7");
        eje7();
        System.out.println("-----------");
        System.out.println("Ejercicio 8");
        eje8();
        System.out.println("-----------");
        System.out.println("Ejercicio 9");
        eje9();
        System.out.println("-----------");
        System.out.println("Ejercicio 10");
        eje10();
        System.out.println("-----------");
        System.out.println("Ejercicio 11");
        eje11();
        System.out.println("-----------");
        System.out.println("Ejercicio 12");
        eje12();

    }

    public static void eje7(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el primer nro1: ");
        int n1 = scanner.nextInt();
        System.out.println("Ingrese el primer nro2: ");
        int n2 = scanner.nextInt();
        System.out.println("Ingrese el primer nro3: ");
        int n3 = scanner.nextInt();

        double resultado = (n1 / n2) - n3;
        // Mostrar el resultado por pantalla
        System.out.println("El resultado es: " + resultado);

        // Cerrar el scanner para liberar recursos
        scanner.close();

    }

    public static void eje8(){
        System.out.println("Tabla de Verdad OR");
        System.out.println("false or true es: "+(false || true));
        System.out.println("false or false es: "+(false || false));
        //System.out.println("true or true es: "+(true || true));
        //System.out.println("true or false es: "+(true || false));
        System.out.println();
        System.out.println("Tabla de Verdad AND");
        //System.out.println("false and true es: "+(false && true));
        //System.out.println("false and false es: "+(false && false));
        System.out.println("true and true es: "+(true && true));
        System.out.println("true and false es: "+(true && false));
    }

    public static void eje9(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un número entero");
        int nro = scanner.nextInt();

        int r1 = nro/2;
        int r2 = nro/3;
        int r3 = nro/4;
        //print primera parte
        System.out.println("Resultado del nro ingresado divido por 2 es : " + r1);
        System.out.println("Resultado del nro ingresado divido por 3 es : " + r2);
        System.out.println("Resultado del nro ingresado divido por 4 es : " + r3);
        //análisis de los resultados
        if (nro % 2 == 0) {
            System.out.println("El número es divisible por 2 correctamente.");
        } else {
            System.out.println("El número NO es divisible por 2 correctamente.");
        }

        if (nro % 3 == 0) {
            System.out.println("El número es divisible por 3 correctamente.");
        } else {
            System.out.println("El número NO es divisible por 3 correctamente.");
        }

        if (nro % 4 == 0) {
            System.out.println("El número es divisible por 4 correctamente.");
        } else {
            System.out.println("El número NO es divisible por 4 correctamente.");
        }
        scanner.close();

    }

    public static void eje10(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su primer nro entero:");
        int n1 = scanner.nextInt();
        System.out.println("Ingrese su segundo nro entero:");
        int n2 = scanner.nextInt();

        if(n1 > n2){
            System.out.println("El primer nro es mayor al segundo.");
        } else if (n1 < n2) {
            System.out.println("El primer nro es menor que el segundo nro.");
        } else{
            System.out.println("El primero nro no es mayor al segundo.");
        }

        if(n1 % 2 == 0 && n2 % 2 == 0){
            System.out.println("Ambos nros son múltiplos de 2.");
        }else{
            System.out.println("Ambos nros no son múltiplos de 2.");
        }
        scanner.close();
    }

    public static void eje11(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un nro entero: ");
        int numero = scanner.nextInt();
        // a. Verificar si el número es múltiplo de 6 y de 7
        boolean esMultiploDe6Y7 = numero % 6 == 0 && numero % 7 == 0;
        System.out.println("a. ¿El número es múltiplo de 6 y de 7? " + esMultiploDe6Y7);

        // b. Verificar si el número es mayor a 30 y múltiplo de 2, o es menor igual a 30
        boolean mayorA30YMultiploDe2 = numero > 30 && numero % 2 == 0;
        boolean menorIgualA30 = numero <= 30;
        System.out.println("b. ¿El número es mayor a 30 y múltiplo de 2, o es menor igual a 30? " +
                (mayorA30YMultiploDe2 || menorIgualA30));

        // c. Verificar si el cociente de la división por 5 es mayor que 10
        int cocienteDivisionPor5 = numero / 5;
        boolean cocienteMayorQue10 = cocienteDivisionPor5 > 10;
        System.out.println("c. ¿El cociente de la división por 5 es mayor que 10? " + cocienteMayorQue10);
        scanner.close();


    }

    public static void eje12(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el primer nro entero para incrementar");
        int nro1 = scanner.nextInt();
        System.out.println("Ingrese el segundo nro entero para decrementar");
        int nro2 = scanner.nextInt();

        System.out.println("El primer nro original es "+ nro1 + " | El primer nro luego de ser incrementado: "+ (++nro1));
        System.out.println("El segundo nro original es "+ nro2 + " | El segundo nro luego de ser decrementado: "+ (--nro2));
        
        scanner.close();
    }
}
