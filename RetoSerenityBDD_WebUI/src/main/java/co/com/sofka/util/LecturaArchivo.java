package co.com.sofka.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LecturaArchivo {

    public static List<String> leerArchivo(String ruta) {

        List<String> lines = new ArrayList<>();
        try {
            lines = new ArrayList<>(Files.readAllLines(Paths.get(ruta)));
        } catch (IOException e) {
        }
        return lines;
    }
}
