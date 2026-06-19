package Model;

public class Partido {
    private Seleccion local;
    private Seleccion visitante;
    private  int goleslocal;
    private int golesvisitante;
    private boolean jugado;

    public Partido(Seleccion local, Seleccion visitante){
        this.local = local;
        this.visitante = visitante;
        this.jugado = false;
        this.goleslocal = 0;
        this.golesvisitante = 0;
    }

    public void registrarResultado(int goleslocal, int golesvisitante) {

        if (jugado) {
            System.out.println("Este partido ya fue jugado.");
            return;
        }

        this.goleslocal = goleslocal;
        this.golesvisitante = golesvisitante;
        jugado = true;

        local.actualizarEstadisticas(goleslocal, golesvisitante);
        visitante.actualizarEstadisticas(golesvisitante, goleslocal);
    }

    public void mostrarResultado() {

        System.out.println(
                local.getNombre()
                        + " "
                        + goleslocal
                        + " - "
                        + golesvisitante
                        + " "
                        + visitante.getNombre()
        );

        if (goleslocal > golesvisitante) {
            System.out.println("Ganador: " + local.getNombre());
        } else if (golesvisitante > goleslocal) {
            System.out.println("Ganador: " + visitante.getNombre());
        } else {
            System.out.println("Empate");
        }
    }

    public Seleccion getLocal() {
        return local;
    }
    public  Seleccion getVisitante(){
        return visitante;
    }

    public int getGoleslocal(){
        return goleslocal;
    }

    public int getGolesvisitante(){
        return golesvisitante;
    }
}
