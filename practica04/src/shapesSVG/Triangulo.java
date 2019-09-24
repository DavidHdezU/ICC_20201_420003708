package shapesSVG;
public class Triangulo{
    private Vector2 a;
    private Vector2 b;
    private Vector2 c;
    private double perimetro;
    private double area;

    public Triangulo(Vector2 a, Vector2 b, Vector2 c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public void setA(Vector2 a){
        this.a = a;
    }
    public void setB(Vector2 b){
        this.b = b;
    }
    public void setC(Vector2 c){
        this.c = c;
    }
    public void setPerimetro(double perimetro){
        this.perimetro = perimetro;
    }
    public void setArea(double area){
        this.area = area;
    }
    public Vector2 getA(){
        return this.a;
    }
    public Vector2 getB(){
        return this.b;
    }
    public Vector2 getC(){
        return this.c;
    }
    public double getPerimetro(){
        return this.perimetro;
    }
    public double getArea(){
        return this.area;
    }
    public String toSVG(){
        String aux = "<polyline points= '"+Double.toString(this.a.getX())+" "+Double.toString(this.a.getY())+" "+Double.toString(this.b.getX())+" "+Double.toString(this.b.getY())+" "+Double.toString(c.getX())+" "+Double.toString(c.getY())+"' stroke='"+"red"+"' fill='"+"orange"+"' stroke-width='"+"2.0"+"' />";
        return aux;
    }
    @Override
    public String toString() {
        String trian = "El triangulo tienes su punto a en: " + a + " , tiene su punto b en: " + b + " y su punto c en: " + c;
        return trian;
    }
    @Override
    public boolean equals(Object v) {
    Triangulo z = (Triangulo)v;
    return a == z.getA() && b == z.getB() && c == z.getC(); 
}

}

