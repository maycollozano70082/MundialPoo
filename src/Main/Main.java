package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Model.*;
import Service.GestorArchivos;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Seleccion> selecciones = new ArrayList<>();
        ArrayList<Grupo> grupos = new ArrayList<>();
        ArrayList<Partido> partidos = new ArrayList<>();

        int opcion;

        do {
            System.out.println(" MUNDIAL POO ");
            System.out.println("1. Crear selección");
            System.out.println("2. Agregar jugador");
            System.out.println("3. Crear grupo");
            System.out.println("4. Asignar selección a grupo");
            System.out.println("5. Crear partido");
            System.out.println("6. Registrar resultado");
            System.out.println("7. Mostrar información");
            System.out.println("8. Tabla de posiciones");
            System.out.println("9. Guardar selecciones");
            System.out.println("10. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:

                    System.out.println("Crear selección");
                    sc.nextLine();

                    System.out.print("Nombre de la selección: ");
                    String nombreSeleccion = sc.nextLine();

                    if (nombreSeleccion.isEmpty()) {
                        System.out.println("El nombre de la selección no puede estar vacío");
                        break;
                    }

                    System.out.print("Confederación: ");
                    String confederacion = sc.nextLine();

                    if (confederacion.isEmpty()) {
                        System.out.println("El nombre de la confederación no puede estar vacía");
                        break;
                    }

                    System.out.print("Nombre del técnico: ");
                    String nombreTecnico = sc.nextLine();

                    if (nombreTecnico.isEmpty()) {
                        System.out.println("El nombre del técnico no puede estar vacío");
                        break;
                    }

                    System.out.print("Edad del técnico: ");
                    int edadTecnico = sc.nextInt();

                    if (edadTecnico <= 0) {
                        System.out.println("La edad debe ser mayor que 0");
                        break;
                    }

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

                    if (indice < 1 || indice > selecciones.size()) {
                        System.out.println("Selección inválida.");
                        break;
                    }

                    System.out.print("Nombre del jugador: ");
                    String nombreJugador = sc.nextLine();

                    if (nombreJugador.isEmpty()) {
                        System.out.println("Nombre inválido");
                        break;
                    }

                    System.out.print("Edad: ");
                    int edadJugador = sc.nextInt();

                    if (edadJugador <= 0) {
                        System.out.println("Edad inválida");
                        break;
                    }

                    System.out.print("Dorsal: ");
                    int dorsal = sc.nextInt();
                    sc.nextLine();

                    if (dorsal <= 0) {
                        System.out.println("Dorsal inválido");
                        break;
                    }

                    System.out.print("Posición: ");
                    String posicion = sc.nextLine();

                    if (posicion.isEmpty()) {
                        System.out.println("Posición inválida");
                        break;
                    }

                    Jugador jugador = new Jugador(nombreJugador, edadJugador, dorsal, posicion);

                    selecciones.get(indice - 1).agregarJugador(jugador);

                    System.out.println("Jugador agregado correctamente.");
                    break;

                case 3:
                    sc.nextLine();

                    System.out.print("Nombre del grupo: ");
                    String nombreGrupo = sc.nextLine();

                    if (nombreGrupo.isEmpty()) {
                        System.out.println("Nombre de grupo inválido");
                        break;
                    }

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

                    if (grupoElegido < 1 || grupoElegido > grupos.size()) {
                        System.out.println("Grupo inválido.");
                        break;
                    }

                    System.out.println("Seleccione una selección:");

                    for (int i = 0; i < selecciones.size(); i++) {
                        System.out.println((i + 1) + ". " + selecciones.get(i).getNombre());
                    }

                    int seleccionElegida = sc.nextInt();

                    if (seleccionElegida < 1 || seleccionElegida > selecciones.size()) {
                        System.out.println("Selección inválida.");
                        break;
                    }

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

                    if (local < 1 || local > selecciones.size()) {
                        System.out.println("Equipo local inválido.");
                        break;
                    }

                    System.out.println("Seleccione el equipo visitante:");

                    for (int i = 0; i < selecciones.size(); i++) {
                        System.out.println((i + 1) + ". " + selecciones.get(i).getNombre());
                    }

                    int visitante = sc.nextInt();

                    if (visitante < 1 || visitante > selecciones.size()) {
                        System.out.println("Equipo visitante inválido.");
                        break;
                    }

                    if (local == visitante) {
                        System.out.println("Una selección no puede jugar contra sí misma.");
                        break;
                    }

                    boolean existe = false;

                    Seleccion equipoLocal = selecciones.get(local - 1);
                    Seleccion equipoVisitante = selecciones.get(visitante - 1);

                    for (Partido p : partidos) {

                        if ((p.getLocal().equals(equipoLocal) && p.getVisitante().equals(equipoVisitante))
                                || (p.getLocal().equals(equipoVisitante) && p.getVisitante().equals(equipoLocal))) {

                            existe = true;
                            break;
                        }
                    }

                    if (existe) {
                        System.out.println("Ese partido ya fue programado.");
                        break;
                    }

                    Partido partido = new Partido(
                            equipoLocal,
                            equipoVisitante
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

                    if (partidoElegido < 1 || partidoElegido > partidos.size()) {
                        System.out.println("Partido inválido.");
                        break;
                    }

                    System.out.print("Goles local: ");
                    int golesLocal = sc.nextInt();

                    if (golesLocal < 0) {
                        System.out.println("Los goles no pueden ser negativos.");
                        break;
                    }

                    System.out.print("Goles visitante: ");
                    int golesVisitante = sc.nextInt();

                    if (golesVisitante < 0) {
                        System.out.println("Los goles no pueden ser negativos.");
                        break;
                    }

                    partidos.get(partidoElegido - 1)
                            .registrarResultado(golesLocal, golesVisitante);

                    System.out.println("Resultado registrado.");
                    break;

                case 7:
                    System.out.println(" GRUPOS ");

                    for (Grupo g : grupos) {
                        g.mostrarSeleccions();
                    }

                    System.out.println(" PARTIDOS ");

                    for (Partido p : partidos) {
                        p.mostrarResultado();
                    }
                    break;

                case 8:
                    System.out.println(" TABLA DE POSICIONES ");

                    ArrayList<Seleccion> tabla = new ArrayList<>(selecciones);

                    for (int i = 0; i < tabla.size() - 1; i++) {

                        for (int j = 0; j < tabla.size() - 1 - i; j++) {

                            if (tabla.get(j).getPuntos() < tabla.get(j + 1).getPuntos()) {

                                Seleccion aux = tabla.get(j);
                                tabla.set(j, tabla.get(j + 1));
                                tabla.set(j + 1, aux);
                            }
                        }
                    }

                    System.out.printf(
                            "%-15s %-5s %-5s %-5s %-5s %-5s %-5s %-5s %-5s%n",
                            "Equipo", "PTS", "PJ", "G", "E", "P", "GF", "GC", "DG"
                    );

                    for (Seleccion s : tabla) {

                        System.out.printf(
                                "%-15s %-5d %-5d %-5d %-5d %-5d %-5d %-5d %-5d%n",
                                s.getNombre(),
                                s.getPuntos(),
                                s.getPartidosJugados(),
                                s.getVictorias(),
                                s.getEmpates(),
                                s.getDerrotas(),
                                s.getGolesFavor(),
                                s.getGolesContra(),
                                s.getDiferenciaGoles()
                        );
                    }

                    break;

                case 9:

                    GestorArchivos.guardarSelecciones(selecciones);

                    break;

                    case 10:
                    System.out.println("Saliendo");
                    break;

                 default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 10);

        sc.close();
    }
}