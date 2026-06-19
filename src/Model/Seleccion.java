package Model;

import java.util.ArrayList;

public class Seleccion {

    private String nombre;
  private String confederacion;
  private DirectorTecnico tecnico;
  private  ArrayList<Jugador> jugadors;

    private int puntos;
    private int partidosJugados;
    private int victorias;
    private int empates;
    private int derrotas;
    private int golesFavor;
    private int golesContra;

    public Seleccion(String nombre, String confederacion, DirectorTecnico tecnico) {

        this.nombre = nombre;
        this.confederacion = confederacion;
        this.tecnico = tecnico;
        this.jugadors = new ArrayList<>();

        this.puntos = 0;
        this.partidosJugados = 0;
        this.victorias = 0;
        this.empates = 0;
        this.derrotas = 0;
        this.golesFavor = 0;
        this.golesContra = 0;
    }

    public void agregarJugador(Jugador jugador) {
        for (Jugador j : jugadors) {

            if (j.getDorsal() == jugador.getDorsal()) {
                System.out.println("Ya existe un jugador con ese dorsal.");
                return;
            }
        }
        jugadors.add(jugador);
    }

    public void mostrarJugadores() {

        for (Jugador jugador : jugadors) {

            System.out.println(
                    jugador.getNombre()
                            + "- Dorsal: " + jugador.getDorsal()
                            + "- Posición: " + jugador.getPosicion()
            );
        }
    }

    public void actualizarEstadisticas(int golesMarcados, int golesRecibidos) {

        partidosJugados++;

        golesFavor += golesMarcados;
        golesContra += golesRecibidos;

        if (golesMarcados > golesRecibidos) {

            victorias++;
            puntos += 3;

        } else if (golesMarcados == golesRecibidos) {

            empates++;
            puntos++;

        } else {

            derrotas++;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getConfederacion() {
        return confederacion;
    }

    public DirectorTecnico getTecnico() {
        return tecnico;
    }

    public ArrayList<Jugador> getJugadors() {
        return jugadors;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public int getVictorias() {
        return victorias;
    }

    public int getEmpates() {
        return empates;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }
    public int getDiferenciaGoles() {
        return golesFavor - golesContra;
    }

    }