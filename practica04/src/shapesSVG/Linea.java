/**
 * Clase que modela una linea a partir de 2 puntos
 * @author David Hernández Uriostegui
 */
package shapesSVG;
public class Linea{
    private Vector2 a;
    private Vector2 b;
    private double longitud;
    /**
     * Parametros de la clase Linea
     * @param a - Punto a con coordenadas (x1, y1)
     * @param b - Punto b con coordenadas (x2, y2)
     * @param longitud - La longitud de la linea
     */

     /**
      * Constructor que nos pide que ingresemos 2 puntos con coordenadas (x, y)
      * @param a - Punto a con coordenadas (x1, y1)
      * @param b - Punto b con coordenadas (x2, y2)
      */
    public Linea(Vector2 a, Vector2 b){
        this.a = a;
        this.b = b;
        this.longitud = a.distancia(b);
    }
    /**
     * Constructor que nos pide el valor de cada coordenada de los ejes de cada punto
     * @param x1 - Coordenada en el eje x del punto a
     * @param y1 - Coordenada en el eje y del punto a
     * @param x2 - Coordenada en el eje x del punto b
     * @param y2 - Coordenada en el eje y del punto b
     */
    public Linea(double x1, double y1, double x2, double y2){
        Vector2 v1 = new Vector2(x1, y1);
        Vector2 v2 = new Vector2(x2, y2);
        this.a = v1;
        this.b = v2;
        this.longitud = v1.distancia(v2);
     }
     /**
      * Constructor que no recibe valores y pone los 2 puntos en (0, 0)
      */
     public Linea(){
         Vector2 v1 = new Vector2();
         Vector2 v2 = new Vector2();
         this.a = v1;
         this.b = v2;
         this.longitud = v1.distancia(v2);
     }
     /**
      * Creación de Setters 
      */
    public void setA(Vector2 a){
        this.a = a;
    }
    public void setB(Vector2 b){
        this.b = b;
    }
    public void setLongitud(double longitud){
        this.longitud = longitud;
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
    public double getLongitud(){
        return this.longitud;
    }
    /**
     * Metodo que permite que nuestra linea sea representado gráficamente, regresa una cadena que representa al represetación de la linea en SVG
     * @return String - La representación de la linea en SVG
     */
    public String toSVG(){
        String line = "<line x1='"+Double.toString(this.a.getX())+"' y1='"+Double.toString(this.a.getY())+"' x2='"+Double.toString(this.b.getX())+"' y2='"+Double.toString(this.b.getY())+"' stroke='"+"yellow"+"' stroke-width='"+"5.0"+"' />";
        return line;
    }
    /**
     * Metodo para convertir una linea a una cadena de caracteres
     * @return String - Una linea en forma de cadena
     */
    @Override
    public String toString() {
        String line = "La linea va del vector " + a + " a el vector " + b;
        return line;
    }
    /**
     * Metodo que compara si 2 lineas son iguales, si son asi regresa true, en otro caso false
     * @param v - Linea con la cual se va a comparar
     * @return boolean - true si 2 lineas son iguales, false si no
     */
    @Override
    public boolean equals(Object v) {
        Linea z = (Linea)v;
        return a.equals(z.getA()) && b.equals(z.getB());
    }



    

}