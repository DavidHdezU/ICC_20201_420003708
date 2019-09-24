/**
 * Clase que modela un rectángulo a partir de un punto, un ancho y un alto
 * @author David Hernández Uriostegui
 */
package shapesSVG;
public class Rectangulo{
    private Vector2 a;
    private double ancho;
    private double alto;
    private double area;
    private double perimetro;
    /**
     * Parametros de la clase Rectangulo
     * @param a - El punto a partir del cual se crea el rectángulo
     * @param ancho - El valor del ancho del rectángulo
     * @param alto - El valor del alto del rectángulo
     * @param area - El area del rectangulo
     * @param perimetro - El perimetro del rectangulo
     */

     /**
      * Constructor que nos pide un punto con coordenadas (x, y) y un respectivo valor para el alto y ancho
      * @param a - Punto del cual se crea el rectángulo
      * @param ancho - Ancho del rectangulo
      * @param alto - Alto del rectangulo   
      */
    public Rectangulo(Vector2 a, double ancho, double alto){
        this.a = a;
        this.ancho = ancho;
        this.alto = alto;
        this.perimetro = ((this.alto * 2) + (this.ancho * 2));
        this.area = (this.alto * this.ancho);
    }
    /**
     * Constructor que nos pide que ingresemos la coordenada en x y en y del punto, y un valor para el alto y ancho
     * @param x - Coordenada x del punto
     * @param y - Coordenada y del punto
     * @param ancho - Amcho del rectangulo
     * @param alto - Alto del rectangulo
     */
    public Rectangulo(double x, double y, double ancho, double alto){
        Vector2 v1 = new Vector2(x, y);
        this.a = v1;
        this.ancho = ancho;
        this.alto = alto;
        this.perimetro = ((this.alto * 2) + (this.ancho * 2));
        this.area = (this.alto * this.ancho);
    }
    /**
     * Metodo que no recibe valores y pone el punto en (0, 0), el ancho = 10 y el alto = 20
     */
    public Rectangulo(){
        Vector2 v1 = new Vector2();
        this.a = v1;
        this.ancho = 10.0;
        this.alto = 20;
        this.perimetro = ((this.alto * 2) + (this.ancho * 2));
        this.area = (this.alto * this.ancho);
    }
    /**
     * Creación de setters
     */
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
    /**
     * Creación de getters
     */
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
    /**
     * Metodo que permite que nuestro rectángulo sea representado gráficamente, regresa una cadena que representa la represetación del rectángulo en SVG
     * @return String - La representación del rectángulo en SVG
     */
     public String toSVG(){
        String rec = "<rect x='"+Double.toString(this.a.getX())+"' y='"+Double.toString(this.a.getY())+"' width='"+Double.toString(ancho)+"' height='"+Double.toString(alto)+"' fill='"+"orange"+"' stroke='"+"green"+"' stroke-width='"+"2.0"+"'/>";
        return rec;
    }
    /**
     * Metodo para convertir un rectángulo a una cadena de caracteres
     * @return String - Un rectángulo en forma de cadena
     */
    @Override
    public String toString() {
        String rect = "El rectangulo tiene su vector" + a + ", tienes un alto de: " + alto + " y tiene un ancho de: " + ancho;
        return rect;
    }
     /**
     * Metodo que compara si 2 rectángulos son iguales, si son asi regresa true, en otro caso false
     * @param v - Rectángulo con el cual se va a comparar
     * @return boolean - true si 2 rectángulos son iguales, false si no
     */
    @Override
    public boolean equals(Object v) {
        Rectangulo z = (Rectangulo)v;
        return a == z.getA() && alto == z.getAlto() && ancho == z.getAncho();
    }

}