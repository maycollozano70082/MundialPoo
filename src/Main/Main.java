package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Model.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Seleccion> selecciones = new ArrayList<>();
        ArrayList<Grupo> grupos = new ArrayList<>();
        ArrayList<Partido> partidos = new ArrayList<>();

        int opcion;

        do {
            System.out.println("\n=== MUNDIAL POO ===");
            System.out.println("1. Crear selección");
            System.out.println("2. Agregar jugador");
            System.out.println("3. Crear grupo");
            System.out.println("4. Asignar selección a grupo");
            System.out.println("5. Crear partido");
            System.out.println("6. Registrar resultado");
            System.out.println("7. Mostrar información");
            System.out.println("8. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("Crear selección");
                    sc.nextLine();

                    System.out.print("Nombre de la selección: ");
                    String nombreSeleccion = sc.nextLine();

                    System.out.print("Confederación: ");
                    String confederacion = sc.nextLine();

                    System.out.print("Nombre del técnico: ");
                    String nombreTecnico = sc.nextLine();

                    System.out.print("Edad del técnico: ");
                    int edadTecnico = sc.nextInt();

                    DirectorTecnico tecnico = new DirectorTecnico(nombreTecnico, edadTecnico);

                    Seleccion seleccion = new Seleccion(nombreSeleccion, confederacion, tecnico);

                    selecciones.add(seleccion);

                    System.out.println("Selección creada correctamente.");
                    break;

                case 2:
                    if (selecciones.isEmpty()) {
                        System.out.println("No hay selecciones registradas.");
                        break;
                    }

                    System.out.println("Seleccione una selección:");

                    for (int i = 0; i < selecciones.size(); i++) {
                        System.out.println((i + 1) + ". " + selecciones.get(i).getNombre());
                    }

                    int indice = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre del jugador: ");
                    String nombreJugador = sc.nextLine();

                    System.out.print("Edad: ");
                    int edadJugador = sc.nextInt();

                    System.out.print("Dorsal: ");
                    int dorsal = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Posición: ");
                    String posicion = sc.nextLine();

                    Jugador jugador = new Jugador(nombreJugador, edadJugador, dorsal, posicion);

                    selecciones.get(indice - 1).agregarJugador(jugador);

                    System.out.println("Jugador agregado correctamente.");
                    break;

                case 3:
                    sc.nextLine();

                    System.out.print("Nombre del grupo: ");
                    String nombreGrupo = sc.nextLine();

                    Grupo grupo = new Grupo(nombreGrupo);

                    grupos.add(grupo);

                    System.out.println("Grupo creado correctamente.");
                    break;

                case 4:
                    if (grupos.isEmpty()) {
                        System.out.println("No hay grupos registrados.");
                        break;
                    }

                    if (selecciones.isEmpty()) {
                        System.out.println("No hay selecciones registradas.");
                        break;
                    }

                    System.out.println("Seleccione un grupo:");

                    for (int i = 0; i < grupos.size(); i++) {
                        System.out.println((i + 1) + ". " + grupos.get(i).getNombre());
                    }

                    int grupoElegido = sc.nextInt();

                    System.out.println("Seleccione una selección:");

                    for (int i = 0; i < selecciones.size(); i++) {
                        System.out.println((i + 1) + ". " + selecciones.get(i).getNombre());
                    }

                    int seleccionElegida = sc.nextInt();

                    grupos.get(grupoElegido - 1)
                            .agregarSeleccion(selecciones.get(seleccionElegida - 1));

                    System.out.println("Selección asignada correctamente.");
                    break;

                case 5:
                    if (selecciones.size() < 2) {
                        System.out.println("Debe haber al menos dos selecciones.");
                        break;
                    }

                    System.out.println("Seleccione el equipo local:");

                    for (int i = 0; i < selecciones.size(); i++) {
                        System.out.println((i + 1) + ". " + selecciones.get(i).getNombre());
                    }

                    int local = sc.nextInt();

                    System.out.println("Seleccione el equipo visitante:");

                    for (int i = 0; i < selecciones.size(); i++) {
                        System.out.println((i + 1) + ". " + selecciones.get(i).getNombre());
                    }

                    int visitante = sc.nextInt();

                    if (local == visitante) {
                        System.out.println("Una selección no puede jugar contra sí misma.");
                        break;
                    }

                    Partido partido = new Partido(
                            selecciones.get(local - 1),
                            selecciones.get(visitante - 1)
                    );

                    partidos.add(partido);

                    System.out.println("Partido creado correctamente.");
                    break;

                case 6:
                    if (partidos.isEmpty()) {
                        System.out.println("No hay partidos registrados.");
                        break;
                    }

                    System.out.println("Seleccione un partido:");

                    for (int i = 0; i < partidos.size(); i++) {

                        Partido p = partidos.get(i);

                        System.out.println(
                                (i + 1) + ". "
                                        + p.getLocal().getNombre()
                                        + " vs "
                                        + p.getVisitante().getNombre()
                        );
                    }

                    int partidoElegido = sc.nextInt();

                    System.out.print("Goles local: ");
                    int golesLocal = sc.nextInt();

                    System.out.print("Goles visitante: ");
                    int golesVisitante = sc.nextInt();

                    partidos.get(partidoElegido - 1)
                            .registrarResultado(golesVisitante, golesLocal);

                    System.out.println("Resultado registrado.");
                    break;

                case 7:
                    System.out.println("\n=== GRUPOS ===");

                    for (Grupo g : grupos) {
                        g.mostrarSeleccions();
                    }

                    System.out.println("\n=== PARTIDOS ===");

                    for (Partido p : partidos) {
                        p.mostrarResultado();
                    }
                    break;

                case 8:
                    System.out.println("Saliendo...");
                    break;

                 default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 8);

        sc.close();
    }
}