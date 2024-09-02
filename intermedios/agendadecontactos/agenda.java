package intermedios.agendadecontactos;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class agenda {
    private List<contacto> contactos;

    public agenda() {
        this.contactos = new ArrayList<>();
    }

    public void agregarContacto(contacto contacto) {
        contactos.add(contacto);
    }

    public void eliminarContactoPorNombre(String nombre) {
        contactos.removeIf(contacto -> contacto.getNombre().equalsIgnoreCase(nombre));
    }

    public contacto buscarContactoPorNombre(String nombre) {
        for (contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null; // Devuelve null si no encuentra el contacto
    }

    public void listarContactos() {
        // Ordena los contactos por nombre
        Collections.sort(contactos, Comparator.comparing(contacto::getNombre));
        for (contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }
}
