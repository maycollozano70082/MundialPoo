package Model;

import java.util.ArrayList;

public class Torneo {

    private ArrayList<Grupo> grupos;
    private ArrayList<Partido> partidos;

    public Torneo(){
        grupos = new ArrayList<>();
        partidos = new ArrayList<>();
    }

    public  void agregarGrupo(Grupo grupo){
        grupos.add(grupo);
    }
    public void agregarPartido(Partido partido){
        partidos.add(partido);
    }
    public void mostrarGrupos (){
        for (Grupo grupo : grupos){grupo.mostrarSeleccions();
            System.out.println();
        }
    }

    public void mostrarPartidos(){
        for (Partido partido : partidos){
            partido.mostrarResultado();
        }
    }
    public  ArrayList<Grupo> getGrupos(){
        return grupos;
    }
    public ArrayList<Partido> getPartidos(){
        return partidos;
    }
}
