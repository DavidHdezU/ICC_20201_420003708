package shapesSVG;

import javax.print.DocFlavor.STRING;

public class Linea{
    private Vector2 a;
    private Vector2 b;
    private double longitud;

    public Linea(Vector2 a, Vector2 b){
        this.a = a;
        this.b = b;
    }
    public Linea(double x1, double y1, double x2, double y2){
        Vector2 v1 = new Vector2(x1, y1);
        Vector2 v2 = new Vector2(x2, y2);
        this.a = v1;
        this.b = v2;
     }
     public Linea(){
         Vector2 v1 = new Vector2();
         Vector2 v2 = new Vector2();
         this.a = v1;
         this.b = v2;
     }
    public void setA(Vector2 a){
        this.a = a;
    }
    public void setB(Vector2 b){
        this.b = b;
    }
    public void setLongitud(double longitud){
        this.longitud = longitud;
    }
    public Vector2 getA(){
        return this.a;
    }
    public Vector2 getB(){
        return this.b;
    }
    public double getLongitud(){
        return this.longitud;
    }
    public String toSVG(){
        String line = "<line x1='"+Double.toString(this.a.getX())+"' y1='"+Double.toString(this.a.getY())+"' x2='"+Double.toString(this.b.getX())+"' y2='"+Double.toString(this.b.getY())+"' stroke='"+"yellow"+"' stroke-width='"+"5.0"+"' />";
        return line;
    }
    @Override
    public String toString() {
        String line = "La linea va del vector " + a + " a el vector " + b;
        return line;
    }
    @Override
    public boolean equals(Object v) {
        Linea z = (Linea)v;
        return a == z.getA() && b == z.getB() && longitud == z.getLongitud();
    }



    

}