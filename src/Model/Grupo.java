package Model;

import java.util.ArrayList;

public class Grupo {

    private String nombre;
    private ArrayList<Seleccion> seleccions;

    public Grupo(String nombre) {
        this.nombre = nombre;
        this.seleccions = new ArrayList<>();
    }

    public void agregarSeleccion(Seleccion seleccion) {

        if (seleccions.contains(seleccion)) {
            System.out.println("La selección ya pertenece al grupo.");
            return;
        }

        if (seleccions.size() >= 4) {
            System.out.println("El grupo ya está completo.");
            return;
        }

        seleccions.add(seleccion);
    }

    public void mostrarSeleccions() {
        System.out.println("Grupo " + nombre);

        for (Seleccion seleccion : seleccions) {
            System.out.println("- " + seleccion.getNombre());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Seleccion> getSeleccions() {
        return seleccions;
    }
}
