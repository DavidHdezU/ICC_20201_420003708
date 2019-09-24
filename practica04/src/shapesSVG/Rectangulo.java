package shapesSVG;

public class Rectangulo{
    private Vector2 a;
    private double ancho;
    private double alto;
    private double area;
    private double perimetro;

    public Rectangulo(Vector2 a, double ancho, double alto){
        this.a = a;
        this.ancho = ancho;
        this.alto = alto;
    }
    public void setA(Vector2 a){
        this.a = a;
    }
    public void setAncho(double ancho){
        this.ancho = ancho;
    }
    public void setAlto(double alto){
        this.alto = alto;
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
    public double getAncho(){
        return this.ancho;
    }
    public double getAlto(){
        return this.alto;
    }
    public double getPerimetro(){
        return this.perimetro;
    }
    public double getArea(){
        return this.area;
    }
    public Rectangulo(double x, double y, double ancho, double alto){
        x = this.a.getX();
        y = this.a.getY();
        ancho = getAlto();
        alto = getAlto();
     }
     public String toSVG(){
        String rec = "<rect x='"+Double.toString(this.a.getX())+"' y='"+Double.toString(this.a.getY())+"' width='"+Double.toString(ancho)+"' height='"+Double.toString(alto)+"' fill='"+"orange"+"' stroke='"+"green"+"' stroke-width='"+"2.0"+"'/>";
        return rec;
    }
    @Override
    public String toString() {
        String rect = "El rectangulo tiene su vector" + a + ", tienes un alto de: " + alto + " y tiene un ancho de: " + ancho;
        return rect;
    }
    @Override
    public boolean equals(Object v) {
        Rectangulo z = (Rectangulo)v;
        return a == z.getA() && alto == z.getAlto() && ancho == z.getAncho();
    }

}