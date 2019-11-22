Celula celula;

void setup() {
size(1280, 720);
frameRate(23);
celula = new Celula();
PImage pikachu;
pikachu = loadImage("pikachu.jpg");
}

void draw() {
background(133);

celula.generate();
PImage pikachu;
pikachu = loadImage("pikachu.jpg");
celula.display(pikachu);
}

// reset board when mouse is pressed
void mousePressed() {
celula.start();
}
