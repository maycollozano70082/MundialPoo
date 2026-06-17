package Model;

public class Jugador extends Persona{
    private int dorsal;
    private String posicion;

    public Jugador(String nombre,int edad,int dorsal,String posicion) {

        super(nombre, edad);

        this.dorsal = dorsal;
        this.posicion = posicion;
    }

    public int getDorsal() {
        return dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
}
