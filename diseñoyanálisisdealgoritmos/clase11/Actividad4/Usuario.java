package clase11.Actividad4;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    // Atributos de la clase Usuario: id, nombre, y lista de amigos
    private int id;
    private String nombre;
    private List<Usuario> amigos;

    // Constructor que inicializa los atributos de Usuario
    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.amigos = new ArrayList<>();
    }

    // Método para obtener el ID del usuario
    public int getId() {
        return id;
    }

    // Método para obtener el nombre del usuario
    public String getNombre() {
        return nombre;
    }

    // Método para obtener la lista de amigos del usuario
    public List<Usuario> getAmigos() {
        return amigos;
    }

    // Método para agregar un amigo a la lista de amigos
    public void agregarAmigo(Usuario amigo) {
        // Verifica si el amigo no está ya en la lista
        if (!amigos.contains(amigo)) {
            amigos.add(amigo);
            // También agrega a este usuario como amigo del amigo
            amigo.agregarAmigo(this);
        }
    }

    // Método toString para representar al usuario como una cadena
    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nombre='" + nombre + "'}";
    }
}
