/**
 * Clase que modela un triángulo a partir de 3 puntos
 * @author David Hernández Uriostegui
 */
package shapesSVG;
public class Triangulo{
    private Vector2 a;
    private Vector2 b;
    private Vector2 c;
    private double perimetro;
    private double area;
     /**
     * Parametros de la clase Triángulo
     * @param a - El punto a partir del cual se crea el triángulo
     * @param b - El punto b partir del cual se crea el triángulo
     * @param a - El punto c partir del cual se crea el triángulo
     * @param area - El area del rectangulo
     * @param perimetro - El perimetro del rectangulo
     */

     /**
      * Constructor que pide 3 puntos a partir de los cuales se va a crear el triangulo
      * @param a - Punto a
      * @param b - Punto b
      * @param c - Punto c
      */
    public Triangulo(Vector2 a, Vector2 b, Vector2 c){
        this.a = a;
        this.b = b;
        this.c = c;
        double base = a.distancia(b);
        Vector2 pMedio = new Vector2((a.getX() + b.getX())/2, (a.getY() + b.getY())/2);
        double altura = pMedio.distancia(c);
        this.perimetro = a.distancia(b) + b.distancia(c) + c.distancia(a);
        this.area = ((base * altura)/2);
    }
    /**
     * Constructor que pide la coordenada en x y en y de cada punto
     * @param x1 - Coordenada en x del punto a
     * @param y1 - Coordenada en y del punto a
     * @param x2 - Coordenada en x del punto b
     * @param y2 - Coordenada en y del punto b
     * @param x3 - Coordenada en x del punto c
     * @param y3 - Coordenada en y del punto b
     */
    public Triangulo(double x1, double y1, double x2, double y2, double x3, double y3){
        Vector2 v1 = new Vector2(x1, y1);
        Vector2 v2 = new Vector2(x2, y2);
        Vector2 v3 = new Vector2(x3, y3);
        this.a = v1;
        this.b = v2;
        this.c = v3;  
        double base = a.distancia(b);
        Vector2 pMedio = new Vector2((x1 + x2)/2, (y1 + y2)/2);
        double altura = pMedio.distancia(c);
        this.perimetro = a.distancia(b) + b.distancia(c) + c.distancia(a);
        this.area = ((base * altura)/2);
     }
     /**
      * Constructor que no recibe valores, y asigna al punto a en (100, 100), al punto b en (200, 100) y al punto c en (150, 50)
      */
     public Triangulo(){
         Vector2 v1 = new Vector2(100.0, 100.0);
         Vector2 v2 = new Vector2(200.0, 100.0);
         Vector2 v3 = new Vector2(150.0, 50.0);
         this.a = v1;
         this.b = v2;
         this.c = v3;
        double base = a.distancia(b);
        Vector2 pMedio = new Vector2((100 + 200)/2, (100 + 100)/2);
        double altura = pMedio.distancia(c);
        this.perimetro = a.distancia(b) + b.distancia(c) + c.distancia(a);
        this.area = ((base * altura)/2);
     }
     /**
      * Creación de setters
      */
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
    /**
     * Creación de getters
     */
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
    /**
     * Metodo que permite que nuestro triángulo sea representado gráficamente, regresa una cadena que representa la represetación del triángulo en SVG
     * @return String - La representación del triángulo en SVG
     */
    public String toSVG(){
        String aux = "<polyline points= '"+Double.toString(this.a.getX())+" "+Double.toString(this.a.getY())+" "+Double.toString(this.b.getX())+" "+Double.toString(this.b.getY())+" "+Double.toString(c.getX())+" "+Double.toString(c.getY())+"' stroke='"+"red"+"' fill='"+"orange"+"' stroke-width='"+"5.0"+"' />";
        return aux;
    }
     /**
     * Metodo para convertir un triángulo a una cadena de caracteres
     * @return String - Un triángulo en forma de cadena
     */
    @Override
    public String toString() {
        String trian = "El triangulo tienes su punto a en: " + a + " , tiene su punto b en: " + b + " y su punto c en: " + c;
        return trian;
    }
    /**
     * Metodo que compara si 2 triángulos son iguales, si son asi regresa true, en otro caso false
     * @param v - Triángulo con el cual se va a comparar
     * @return boolean - true si 2 triángulos son iguales, false si no
     */
    @Override
    public boolean equals(Object v) {
    Triangulo z = (Triangulo)v;
    return a.equals(z.getA()) && b.equals(z.getB()) && c.equals(z.getC()); 
}

}

