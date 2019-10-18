public class Sketch extends PApplet {
public int ancho = 30;
    public static void main (String[] args ){
        PApplet.main("Sketch");
    }

    public void settings(){
        size (300,300);
    }
    public void setup(){
        fill(120,50,240);
    }
    public void draw(){
        for(int i=0; i<8;i++){
            for(int j = 0; j<8; j++){
                //if (color==0){
                    //fill(0,0,0);
                    //color=1;
                }
                rect(i*ancho, j*ancho, ancho, ancho);
            }
        }
    }