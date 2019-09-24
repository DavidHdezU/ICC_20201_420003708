/**
 * Clase que modela un circulo a partir de un punto y un radio
 * @author David Hernández Uriostegui
 */
package shapesSVG;
public class Circulo{
    private Vector2 a;
    private double radio;
    private double diametro;
    private double area;
    /**
     * Parametros de la clase circulo
     * @param a - Punto a partir del cual se crea el circulo
     * @param radio - Radio del circulo
     * @param diametro - Diametro del circulo
     * @param area - Área del circulo
     */

     /**
      * Constructor que pide el punto que será el centro de circulo y un radio
      * @param a - Centro del circulo
      * @param radio - Radio del circulo
      */
    public Circulo(Vector2 a, double radio){
        this.a = a;
        this.radio = radio;
        this.diametro = (this.radio * 2);
        this.area = ((this.radio * this.radio) * 3.141592);
    }
    /**
     * Constructor que recibe la coordenada en x y en y de un punto, y el radio
     * @param x - Coordenada de en x del punto
     * @param y - Coordenada de en y del punto
     * @param radio - Radio del circulo
     */
    public Circulo(double x, double y, double radio){
        Vector2 v1 = new Vector2(x, y);
        this.a = v1;
        this.radio = radio;
        this.diametro = (this.radio * 2);
        this.area = ((this.radio * this.radio) * 3.141592);
    }
    /**
     * Constructor que no recibe nada y que pone el centro del circulo en (100, 100) y asigna un radio = 50
     */
    public Circulo(){
        Vector2 v1 = new Vector2(100.0, 100.0);
        this.a = v1;
        this.radio = 50;
        this.diametro = (this.radio * 2);
        this.area = ((this.radio * this.radio) * 3.141592);
    }
    /**
     * Creación de setters
     */
    public void setA(Vector2 a){
        this.a = a;
    }
    public void setRadio(double radio){
        this.radio = radio;
    }
    public void setDiametro(double diametro){
        this.diametro = diametro;
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
    public double getRadio(){
        return this.radio;
    }
    public double getDiametro(){
        return this.diametro;
    }
    public double getArea(){
        return this.area;
    }
    /**
     * Metodo que permite que nuestro circulo sea representado gráficamente, regresa una cadena que representa la represetación del circulo en SVG
     * @return String - La representación del circulo en SVG
     */
    public String toSVG(){
        String circ = "<circle cx='"+Double.toString(this.a.getX())+"' cy='"+Double.toString(this.a.getY())+"' r='"+Double.toString(this.radio)+"' fill='"+"pink"+"' stroke='"+"green"+"' stroke-width='"+"9.0"+"'/>";
        return circ;
    }
    /**
     * Metodo para convertir un circulo a una cadena de caracteres
     * @return String - Un circulo en forma de cadena
     */
    @Override
    public String toString() {
        String cir = "El circulo tiene centro en: "+ a + " y tiene radio de: "+ radio;
        return cir;
    }
    /**
     * Metodo que compara si 2 circulos son iguales, si son asi regresa true, en otro caso false
     * @param v - Circulo con el cual se va a comparar
     * @return boolean - true si 2 circulo son iguales, false si no
     */
    @Override
    public boolean equals(Object v) {
        Circulo z = (Circulo)v;
        return a == z.getA() && radio == z.getRadio();
    }
}