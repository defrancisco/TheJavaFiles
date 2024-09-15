package intermedios.agendadecontactos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Agenda {
    private List<Contacto> contactos;

    public Agenda() {
        this.contactos = new ArrayList<>();
    }

    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
    }

    public void eliminarContactoPorNombre(String nombre) {
        contactos.removeIf(contacto -> contacto.getNombre().equalsIgnoreCase(nombre));
    }

    public Contacto buscarContactoPorNombre(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null; // Devuelve null si no encuentra el contacto
    }

    public void listarContactos() {
        // Ordena los contactos por nombre
        Collections.sort(contactos, Comparator.comparing(Contacto::getNombre));
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }
}
