package intermedios.agendadecontactos;


import java.util.Scanner;

public class MainAgenda {
    public static void main(String[] args) {
        agenda agenda = new agenda();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n1. Agregar Contacto");
            System.out.println("2. Eliminar Contacto");
            System.out.println("3. Buscar Contacto");
            System.out.println("4. Listar Contactos");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingresa el teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Ingresa el email: ");
                    String email = scanner.nextLine();
                    agenda.agregarContacto(new contacto(nombre, telefono, email));
                    break;

                case 2:
                    System.out.print("Ingresa el nombre del contacto a eliminar: ");
                    nombre = scanner.nextLine();
                    agenda.eliminarContactoPorNombre(nombre);
                    break;

                case 3:
                    System.out.print("Ingresa el nombre del contacto a buscar: ");
                    nombre = scanner.nextLine();
                    contacto contacto = agenda.buscarContactoPorNombre(nombre);
                    if (contacto != null) {
                        System.out.println("Contacto encontrado: " + contacto);
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Lista de Contactos:");
                    agenda.listarContactos();
                    break;

                case 5:
                    System.out.println("Adiós!");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }
}
