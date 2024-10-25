package tp1;

import java.util.Scanner;

public class variablesyconstantes {



    public static void main(String[] args) {
        System.out.println("Ejercicios Variables y Constantes");
        System.out.println("Ejercicio 1");
        eje1(17, 20.5, 'D', true);
        System.out.println("----------------");
        System.out.println("Ejercicio 2");
        double resultado = eje2(5.0);
        System.out.println("Resultado:  " + resultado);
        System.out.println("----------------");
        System.out.println("Ejercicio 3");
        System.out.println("------ :(");
        System.out.println("Ejercicio 4");
        eje4();
        System.out.println("----------------");
        System.out.println("Ejercicio 5");
        eje5();
        System.out.println("----------------");
        System.out.println("Ejercicio 6");
        eje6();


    }

    public static void eje1(int n1, double n2, char l1, boolean t) {
        System.out.println("Int: " + n1);
        System.out.println("Double: "+n2);
        System.out.println("Char: "+l1);
        System.out.println("Boolean: "+ t);
    }

    public static double eje2(double var){
        double cnte= 1.0;
        System.out.println(var + cnte*2);
        System.out.println(cnte);
        return var + cnte * 2;
    }




    public static void eje4() {
        // crear un objeto Scanner para leer la entrada del usuario desde la consola
        Scanner scanner = new Scanner(System.in);
        //primero creo un arreglo para guardar mis nros
        // es con string ya que para imprimir de esta forma solo acepta ese tipo de objetos
        String[] numeros = new String[5];

        // solicito al usuario que ingrese 5 nros
        System.out.println("Ingrese 5 números:");

        //bucle for de costo lineal para solicitar nros
        //variable inicial ; condición, varibale/iteración
        for (int i = 0; i < 5; i++) {
            //llamo a mi arreglo y utilizo rebanadas para itera
            // la leo a la entrada del usuario y asigno a la posición correspondiente del arreglo
            numeros[i] = scanner.nextLine();
        }
        System.out.println("Los números ingresados en orden inverso son:");
        //bucle for de costo lineal para ordenarlos en orden inverso
        //variable inicial del último (es decir uno menos de lo que sabemos nosotros que es el total)
        // validamos de nuestro criterio que i (nro) debe ser positivo
        //vamos iterando de forma decreciente
        for (int i = 4; i >= 0; i--) {
            System.out.println("   " + numeros[i]);
            // Si no es el último número, imprimir una coma y un espacio
            if (i > 0) {
                System.out.print("");
            }

        }
        // Cerrar el scanner para liberar recursos
        scanner.close();

    }
    public static void eje5(){
        // Crear un objeto Scanner para leer la entrada del usuario desde la consola
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese su nombre
        System.out.println("Ingrese su nombre:");
        String nombre = scanner.nextLine();

        // Solicitar al usuario que ingrese su edad
        System.out.println("Ingrese su edad:");
        int edad = Integer.parseInt(scanner.nextLine());

        // Solicitar al usuario que ingrese su altura
        System.out.println("Ingrese su altura (en metros):");
        double altura = Double.parseDouble(scanner.nextLine());

        // Solicitar al usuario que ingrese su ocupación
        System.out.println("Ingrese su ocupación:");
        String ocupacion = scanner.nextLine();

        // Mostrar la información ingresada por el usuario
        System.out.println("---Su información---");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Altura: " + altura + " metros");
        System.out.println("Ocupación: " + ocupacion);
        
        scanner.close();
    }
    public static void eje6() {
        // Crear un objeto Scanner para leer la entrada del usuario desde la consola
        Scanner scanner = new Scanner(System.in);

        // Solicitar los datos necesarios para la factura
        System.out.println("Ingrese el tipo de factura (A o C): ");
        String tipoFactura = scanner.nextLine();

        System.out.println("Ingrese el número de factura: ");
        int numeroFactura = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();

        System.out.println("Ingrese el nombre del primer producto: ");
        String producto1 = scanner.nextLine();

        System.out.println("Ingrese el importe del primer producto: ");
        double importe1 = Double.parseDouble(scanner.nextLine());

        System.out.println("Ingrese el nombre del segundo producto: ");
        String producto2 = scanner.nextLine();

        System.out.println("Ingrese el importe del segundo producto: ");
        double importe2 = Double.parseDouble(scanner.nextLine());

        // Calcular el importe total
        double importeTotal = importe1 + importe2;

        // Imprimir la factura por pantalla
        System.out.println("Factura " + tipoFactura + " N " + numeroFactura);
        System.out.println("Nombre: " + nombreCliente);
        System.out.println("Producto\tImporte");
        System.out.println(producto1 + "\t\t" + importe1);
        System.out.println(producto2 + "\t\t" + importe2);
        System.out.println("Importe total\t" + importeTotal);

        // Cerrar el scanner para liberar recursos
        scanner.close();
    }

}
