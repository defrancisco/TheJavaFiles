package clase11.Actividad4;

import java.util.*;


public class RedSocial {
    // Mapa para almacenar usuarios con su ID como clave
    private Map<Integer, Usuario> usuarios;

    // Constructor que inicializa el mapa de usuarios
    public RedSocial() {
        this.usuarios = new HashMap<>();
    }

    // Método para agregar un usuario a la red social
    public void agregarUsuario(int id, String nombre) {
        // Verifica si el ID no existe en el mapa antes de agregar
        if (!usuarios.containsKey(id)) {
            usuarios.put(id, new Usuario(id, nombre));
        } else {
            System.out.println("Ya existe un usuario con el ID " + id);
        }
    }

    // Método para conectar dos usuarios como amigos
    public void conectarUsuarios(int id1, int id2) {
        // Obtiene los usuarios por sus IDs
        Usuario usuario1 = usuarios.get(id1);
        Usuario usuario2 = usuarios.get(id2);
        // Verifica que ambos usuarios existan
        if (usuario1 != null && usuario2 != null) {
            usuario1.agregarAmigo(usuario2);
        } else {
            System.out.println("Uno o ambos usuarios no existen");
        }
    }

    // Método recursivo de utilidad para DFS (Depth-First Search)
    private void DFSUtil(int v, boolean[] visitado) {
        // Marca el nodo actual como visitado
        visitado[v] = true;
        System.out.print(usuarios.get(v).getNombre() + " ");
        Usuario actual = usuarios.get(v);
        List<Integer> adyacentes = new ArrayList<>();
        // Agrega IDs de amigos del usuario actual a la lista de adyacentes
        for (Usuario amigo : actual.getAmigos()) {
            adyacentes.add(amigo.getId());
        }
        // Ordena los IDs para un recorrido ordenado
        Collections.sort(adyacentes);
        // Llama recursivamente a DFSUtil para los adyacentes no visitados
        for (int n : adyacentes) {
            if (!visitado[n]) {
                DFSUtil(n, visitado);
            }
        }
    }

    // Método para iniciar DFS desde un usuario específico
    public void DFS(int inicio) {
        Usuario inicioUsuario = usuarios.get(inicio);
        // Verifica que el usuario inicial exista
        if (inicioUsuario == null) {
            System.out.println("El usuario de inicio no existe");
            return;
        }
        // Inicializa el array de visitados
        boolean[] visitado = new boolean[usuarios.size()];
        System.out.println("Recorrido DFS desde " + inicioUsuario.getNombre() + ":");
        // Llama al método de utilidad DFSUtil
        DFSUtil(inicio, visitado);
        System.out.println();
    }

    // Método para realizar BFS (Breadth-First Search) desde un usuario específico
    public void BFS(int idInicio) {
        Usuario inicio = usuarios.get(idInicio);
        // Verifica que el usuario inicial exista
        if (inicio == null) {
            System.out.println("El usuario de inicio no existe");
            return;
        }
        // Inicializa el array de visitados
        boolean[] visitado = new boolean[usuarios.size() + 1]; // +1 porque los IDs empiezan en 1
        ArrayList<Usuario> cola = new ArrayList<>();
        visitado[idInicio] = true;
        cola.add(inicio);
        System.out.println("Recorrido BFS desde " + inicio.getNombre() + ":");
        // Bucle para recorrer la cola mientras no esté vacía
        while (!cola.isEmpty()) {
            Usuario actual = cola.remove(0);
            System.out.print(actual.getNombre() + " ");
            // Agrega a la cola los amigos no visitados del usuario actual
            for (Usuario amigo : actual.getAmigos()) {
                if (!visitado[amigo.getId()]) {
                    visitado[amigo.getId()] = true;
                    cola.add(amigo);
                }
            }
        }
        System.out.println();
    }
}
