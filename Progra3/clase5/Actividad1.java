package Progra3.clase5;

/*Objetivo:
Modelar un sistema de seguidores donde cada usuario puede seguir a otros usuarios. Usaremos una lista de adyacencia para representar estas relaciones.

Especificaciones:
Agregar usuario: Permitir añadir un nuevo usuario al sistema.
Seguir: Un usuario puede seguir a otro.
Dejar de seguir: Un usuario puede dejar de seguir a otro.
Lista de seguidores: Ver quién sigue a quién.
 * 
 * 
 */
import java.util.*;
public class Actividad1 {
    // Mapa para representar la lista de adyacencia.
    private Map<String, List<String>> grafo;
    public Actividad1(){
        grafo = new HashMap<>(); // Inicialzo el grafo vacío
    }
    // Método para agregar un nuevo usuario al grafo.
    public void agregarUsuario(String usuario) {
        if (!grafo.containsKey(usuario)) { // O(n)
            grafo.put(usuario, new ArrayList<>()); // O(1) // Creamos una lista vacía de seguidores.
            System.out.println("Usuario " + usuario + " agregado."); // O(1)
        } else { // O(1)
            System.out.println("El usuario ya existe."); // O(1)
        } 
    }// Complejidad de O(n) ---> por el largo del usuario que buscamos

    // Método para que un usuario siga a otro.
    public void seguir(String usuarioA, String usuarioB) {
        if (grafo.containsKey(usuarioA) && grafo.containsKey(usuarioB)) { // O(n) + // O(n)
            List<String> seguidores = grafo.get(usuarioA); // O(1)
            if (!seguidores.contains(usuarioB)) { // O(n)
                seguidores.add(usuarioB);  // Añadimos usuarioB a la lista de usuarioA.
                System.out.println(usuarioA + " ahora sigue a " + usuarioB);// O(1)
            } else {// O(1)
                System.out.println(usuarioA + " ya sigue a " + usuarioB);// O(1)
            }
        } else {// O(1)
            System.out.println("Uno o ambos usuarios no existen.");// O(1)
        }
    } // Complejidad de 3 O(n) ---> debido a las búrquedas en el grafo

    // Método para que un usuario deje de seguir a otro.
    public void dejarDeSeguir(String usuarioA, String usuarioB) {
        if (grafo.containsKey(usuarioA)) {// O(n)
            List<String> seguidores = grafo.get(usuarioA); // O(1)
            if (seguidores.contains(usuarioB)) {// O(n)
                seguidores.remove(usuarioB);  // O(n)// Removemos usuarioB de la lista de usuarioA.
                System.out.println(usuarioA + " dejó de seguir a " + usuarioB);// O(1)
            } else {// O(1)
                System.out.println(usuarioA + " no sigue a " + usuarioB);// O(1)
            }
        } else {// O(1)
            System.out.println("El usuario no existe.");// O(1)
        }
    } // Complejidad de 3 O(n) ---> debido a las búsquedas y eliminación en la lista de seguidores

    // Método para obtener la lista de seguidores de un usuario.
    public void obtenerSeguidores(String usuario) {
        System.out.println("Seguidores de " + usuario + ":");
        for (Map.Entry<String, List<String>> entry : grafo.entrySet()) {  // 1 + 2n + 2n = O(n)
            if (entry.getValue().contains(usuario)) {  // O(n)
                System.out.println(entry.getKey()); // O(1) // Mostramos quién sigue al usuario.
            }
        }
    } // Complejidad de O(n ** 2 ) ---> debido al bucle anidado

    public static void main(String[] args) {
        // Creamos la red social y agregamos algunos usuarios.
        Actividad1 red = new Actividad1(); // Esta es la red social en teoría.
        red.agregarUsuario("Alice");
        red.agregarUsuario("Bob");
        red.agregarUsuario("Charlie");

        // Alice sigue a Bob y a Charlie.
        red.seguir("Alice", "Bob");
        red.seguir("Alice", "Charlie");

        // Obtenemos los seguidores de Bob.
        red.obtenerSeguidores("Bob");

        // Alice deja de seguir a Bob.
        red.dejarDeSeguir("Alice", "Bob");

        // Verificamos los seguidores nuevamente.
        red.obtenerSeguidores("Bob");
    }
}
