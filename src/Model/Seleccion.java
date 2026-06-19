package Model;

import java.util.ArrayList;

public class Seleccion {

    private String nombre;
  private String confederacion;
  private DirectorTecnico tecnico;
  private  ArrayList<Jugador> jugadors;

  public  Seleccion(String nombre,String confederacion, DirectorTecnico tecnico){
      this.nombre = nombre;
      this.confederacion = confederacion;
      this.tecnico = tecnico;
      this.jugadors = new ArrayList<>();
  }
public void agregarJugador(Jugador jugador){
      jugadors.add(jugador);
}
public void mostrarJugadores(){
      for (Jugador jugador : jugadors){
          System.out.println(
                  jugador.getNombre() +
                          "- Dorsal: " + jugador.getDorsal() +
                          "- posición " + jugador.getPosicion()
          );
      }
}
public  String getNombre(){
      return nombre;
}
public  String getConfederacion (){
      return confederacion;
}
public DirectorTecnico getTecnico(){
      return tecnico;
}
public ArrayList<Jugador> getJugadors(){
      return jugadors;
}
}
