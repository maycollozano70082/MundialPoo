package Model;

public class Partido {
    private Seleccion local;
    private Seleccion visitante;
    private  int goleslocal;
    private int golesvisitante;

    public Partido(Seleccion local, Seleccion visitante){
        this.local = local;
        this.visitante = visitante;
        this.goleslocal = 0;
        this.golesvisitante = 0;
    }

    public void  registrarResultado(int golesvisitante, int goleslocal) {
        this.goleslocal = goleslocal;
        this.golesvisitante = golesvisitante;
    }

    public  void mostrarResultado(){
        System.out.println(local.getNombre() + "" + goleslocal + "-" + golesvisitante + " " + visitante.getNombre());
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
