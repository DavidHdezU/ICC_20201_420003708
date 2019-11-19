import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;
import processing.core.PApplet;
import processing.core.PImage;

public class Practica extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Practica");
    }

    /**
     * Establece el tamaño de la ventana
     */
    @Override
    public void settings() {
        size(600, 600);
    }

    /**
     * Establece el color y busca el archivo donde estan los numeros
     */
    @Override
    public void setup() {
        fill(125, 135, 143);
        String file = getClass().getResource("numeros.csv").getPath();
        draw2(file);
    }

    @Override
    public void draw() {
    }

    /**
     * Metodo que dibuja los circulos del archivo
     * 
     * @param archivo - Archivos numeros.csv
     */
    public void draw2(String file) {
        try {
            float radio = 15;
            List<String> lines = Files.readAllLines(Paths.get(file));
            for (String string : lines) {
                String row[] = string.split(",");
                ellipse(Float.parseFloat(row[0]), Float.parseFloat(row[1]), radio, radio);
                System.out.println("Coordenada X: " + row[0] + ", Coordenada Y: " + row[1]);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}