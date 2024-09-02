package intermedios;

import java.util.Scanner;

/*
 * Ejercicio 1: Sistema de Gestión de Libros
Descripción: Implementa un sistema de gestión de libros que permita agregar, eliminar, y buscar libros en una biblioteca. Cada libro debe tener un título, autor, ISBN y año de publicación.

Requisitos:

Crea una clase Libro con los atributos titulo, autor, ISBN y año.
Implementa una clase Biblioteca que contenga una lista de libros.
La clase Biblioteca debe tener métodos para agregar un libro, eliminar un libro por su ISBN y buscar libros por título o autor.
Agrega un método para listar todos los libros ordenados por título.
 */


public class mainBiblioteca {
    public static void main(String[] args) {
        biblioteca biblioteca = new biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("n1. Agregar Libro");
            System.out.println("2. Eliminar Libro por ISBN");
            System.out.println("3. Buscar Libro por Título");
            System.out.println("4. Buscar Libro por Autor");
            System.out.println("5. Listar Libros Ordenados por Título");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

        switch (opcion) {
            case 1:
                System.out.print("Título: ");
                String titulo = scanner.nextLine();
                System.out.print("Autor: ");
                String autor = scanner.nextLine();
                System.out.print("ISBN: ");
                String ISBN = scanner.nextLine();
                System.out.print("Año: ");
                int año = scanner.nextInt();
                scanner.nextLine();
                biblioteca.agregarLibro(new libro(titulo, autor, ISBN, año));
                break;
            case 2:
                System.out.print("Ingrese el ISBN del libro a eliminar: ");
                ISBN = scanner.nextLine();
                biblioteca.eliminarLibroPorISBN(ISBN);
                break;  
            case 3:
                System.out.print("Ingrese el título del libro a buscar: ");
                titulo = scanner.nextLine();
                for (libro libro : biblioteca.buscarLibrosPorTitulo(titulo)) {
                    System.out.println(libro);
                }
                break;

            case 4:
                System.out.print("Ingrese el autor del libro a buscar: ");
                autor = scanner.nextLine();
                for (libro libro : biblioteca.buscarLibrosPorAutor(autor)) {
                    System.out.println(libro);
                }
                break;

            case 5:
                System.out.println("Libros ordenados por título:");
                biblioteca.listarLibrosOrdenadosPorTitulo();
                break;

            case 6:
                System.out.println("Adiós!");
                break;

            default:
                System.out.println("Opción no válida.");
                break;
    }
    } while (opcion != 6);
            
        scanner.close();
    }
    
}
