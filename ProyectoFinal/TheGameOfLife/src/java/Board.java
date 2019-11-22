package interfaz;
import processing.core.PApplet;
import processing.core.PImage;
import clases.Celula;

public class Board extends PApplet{

    Celula celula;

    void setup() {
    size(640, 360);
    frameRate(24);
    celula = new Celula();
    }

    void draw() {
    background(255);

    celula.generate();
    celula.display();
    }

    // reset board when mouse is pressed
    void mousePressed() {
    celula.init();
    }
}