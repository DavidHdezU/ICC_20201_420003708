package java;
import processing.core.PApplet;
import processing.core.PImage;
import java.Celula;

public class Board extends PApplet{

    Celula celula;

    void setup() {
    size(640, 360);
    frameRate(24);
    celula = new Celula();
    }

    void draw() {
    background(255);

    gol.generate();
    gol.display();
    }

    // reset board when mouse is pressed
    void mousePressed() {
    gol.init();
    }
}