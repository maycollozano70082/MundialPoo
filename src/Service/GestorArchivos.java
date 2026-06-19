package Service;
import Model.Seleccion;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestorArchivos {
    public static void guardarSelecciones(ArrayList<Seleccion> selecciones) {

        try {

            FileWriter archivo = new FileWriter("selecciones.txt");

            for (Seleccion s : selecciones) {

                archivo.write(
                        s.getNombre() + ";" +
                                s.getConfederacion() + "\n"
                );
            }

            archivo.close();

            System.out.println("Datos guardados correctamente.");

        } catch (IOException e) {

            System.out.println("Error al guardar archivo.");
        }
    }
}

