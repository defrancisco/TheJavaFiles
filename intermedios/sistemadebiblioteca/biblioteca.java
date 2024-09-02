package intermedios.sistemadebiblioteca;


import java.util.ArrayList;
import java.util.List;
/*
 * Utilizando OOP
 */

public class biblioteca {
   private List<libro> libros;

   public biblioteca(){
    this.libros = new ArrayList<>();
   }

   public void agregarLibro(libro libronuevo){
        libros.add(libronuevo);
   }

   public void eliminarLibroPorISBN(String ISBNn){
    libros.removeIf(libro -> libro.getISBN().equals(ISBNn));
   }

   public List<libro> buscarLibrosPorTitulo(String titulo){
    List<libro> resultado = new ArrayList<>();
    for(libro libro : libros){
        if(libro.getTitulo().equalsIgnoreCase(titulo)){
            resultado.add(libro);
        }
    }

    return resultado;
   }

    public List<libro> buscarLibrosPorAutor(String autor){
        List<libro> resultado = new ArrayList<>();
        // de tipo clase libro, itero con libro : por cada libro en la lista de libros d ela biblioteca
        for(libro libro: libros){
            if(libro.getAutor().equalsIgnoreCase(autor)){
                resultado.add(libro);
            }
        }
        return resultado;
    }   

    public void listarLibrosOrdenadosPorTitulo(){
        libros.sort((l1,l2) -> l1.getTitulo().compareToIgnoreCase(l2.getTitulo()));
        for(libro libro: libros){
            System.out.println(libro);
        }
    }

    public void listarLibrosOrdenadosPorAutor(){
        libros.sort((l1,l2) -> l1.getAutor().compareToIgnoreCase(l2.getAutor()));
        for(libro libro: libros){
            System.out.println(libro);
        }
    }

    



}
