/**
 * Clase que modela un circulo a partir de un punto y un radio
 * @author David Hernández Uriostegui
 */
package shapesSVG;

public class Circulo extends Shape {
    private Vector2 a;
    private double radio;

    /**
     * Parametros de la clase circulo
     * 
     * @param a - Punto a partir del cual se crea el circulo
     */

    /**
     * Constructor que pide el punto que será el centro de circulo y un radio
     * 
     * @param a     - Centro del circulo
     * @param radio - Radio del circulo
     */
    public Circulo(Vector2 a, double radio) {
        super();
        this.a = a;
        this.radio = radio;
        this.area = calculaArea();
        this.perimetro = calculaPerimetro();
    }

    /**
     * Constructor que recibe la coordenada en x y en y de un punto, y el radio
     * 
     * @param x     - Coordenada de en x del punto
     * @param y     - Coordenada de en y del punto
     * @param radio - Radio del circulo
     */
    public Circulo(double x, double y, double radio) {
        Vector2 v1 = new Vector2(x, y);
        this.a = v1;
        this.radio = radio;
        this.area = calculaArea();
        this.perimetro = calculaPerimetro();

    }

    /**
     * Constructor que no recibe nada y que pone el centro del circulo en (100, 100)
     * y asigna un radio = 50
     */
    public Circulo() {
        Vector2 v1 = new Vector2(100.0, 100.0);
        this.a = v1;
        this.radio = 50;
        this.area = calculaArea();
        this.perimetro = calculaPerimetro();
    }

    @Override
    public double calculaArea() {
        double area = (this.radio * this.radio) * Math.PI;
        return area;
    }

    @Override
    public double calculaPerimetro() {
        double per = (2 * this.radio) * Math.PI;
        return per;
    }

    /**
     * Creación de setters
     */
    public void setA(Vector2 a) {
        this.a = a;
    }

    public void setRadio(double radio) {
        this.radio = radio;
        this.area = calculaArea();
        this.perimetro = calculaPerimetro();
    }

    /**
     * Creación de getters
     */
    public Vector2 getA() {
        return this.a;
    }

    public double getRadio() {
        return this.radio;
    }

    /**
     * Metodo que permite que nuestro circulo sea representado gráficamente, regresa
     * una cadena que representa la represetación del circulo en SVG
     * 
     * @return String - La representación del circulo en SVG
     */
    @Override
    public String toSVG() {
        String circ = "<circle cx='" + Double.toString(this.a.getX()) + "' cy='" + Double.toString(this.a.getY())
                + "' r='" + Double.toString(this.radio) + "' fill='" + "pink" + "' stroke='" + "green"
                + "' stroke-width='" + "9.0" + "'/>";
        return circ;
    }

    /**
     * Metodo para convertir un circulo a una cadena de caracteres
     * 
     * @return String - Un circulo en forma de cadena
     */
    @Override
    public String toString() {
        String cir = "El circulo tiene centro en: " + this.a + " y tiene radio de: " + this.radio + "\n"
                + super.toString();
        return cir;
    }

    /**
     * Metodo que compara si 2 circulos son iguales, si son asi regresa true, en
     * otro caso false
     * 
     * @param v - Circulo con el cual se va a comparar
     * @return boolean - true si 2 circulo son iguales, false si no
     */
    @Override
    public boolean equals(Object v) {
        if (!(v instanceof Circulo))
            return false;
        Circulo z = (Circulo) v;
        return a.equals(z.getA()) && radio == z.getRadio();
    }
}