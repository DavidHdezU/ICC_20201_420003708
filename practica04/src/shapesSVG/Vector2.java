/**
 * Clase que modela un vector con coordenadas (x, y)
 * @author David Hernández Uriostegui
 */
package shapesSVG;
public class Vector2{
        /** 
     * Parametros de la clase Vector2
     * @param y Es el punto y que se utilizará en el vector
     * @param x Es el punto x que se utilizará en el vector
     * @param magnitud Es la magnitud del vector
     * */

    private double x;
    private double y;
    private double magnitud;
    
    /**
     * Constructor común, que pide como parametros los valores para las coordenadas x, y
     * @param x - Coordenada en el x
     * @param y - Coordenada en el y
     */
    public Vector2(double x, double y){
        this.x = x;
        this.y = y;
    }
    /**
     * Constructor vació que no recibe parametros y coloca el vector en (0, 0)
     */
    public Vector2(){
        this.x = 0.0;
        this.y = 0.0;
    }
     /**
      * Creación de setters
      */
    public void setX(double x){
        this.x = x; 
    }
    public void setY(double y){
        this.y = y;
    }
    public void setMagnitud(double magnitud){
        this.magnitud = magnitud; 
    }
    /**
     * Creación de getters
     */
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getMagnitud(){
        return this.magnitud;
    }
    /**
     *  Metodo que calculo la magnitud del vector, es decir, la distancia del Vector el punto (0, 0)
     * @return double - La magnitud del vector
     */
    public double Magnitud(){
        double newX = (this.x-0.0);
        double newY = (this.y-0.0);
        this.magnitud = Math.sqrt((newX * newX) + (newY * newY));
        return this.magnitud;
    }
    /**
     * Metodo que calcula la distancia de un vector a otro vector
     * @param v - Otro vector respecto al cual se calcurá su distancia a nuestro vector inical
     * @return double - La distancia de nuestro Vector inical al Vector v
     */
    public double distancia(Vector2 v){
        double newX = (this.x-v.x);
        double newY = (this.y-v.y);
        double dist = Math.sqrt((newX * newX) + (newY * newY));
        return dist;
    
    }
    /**
     * Metodo que permite que nuestro vector sea representado gráficamente, regresa una cadena que representa al represetación del Vector en SVG
     * @return String - La representación del vector en SVG
     */
    public String toSVG(){
        String vec = "<circle cx='"+Double.toString(this.x)+"' cy='"+Double.toString(this.y)+"' r='"+"5.0"+"' fill='"+"blue"+"' stroke='"+"red"+"' stroke-width='"+"1.0"+"'/>";
        return vec;
    }

    /**
     * Metodo para convertir un vector a una cadena de caracteres
     * @return String - Un vector en forma de cadena
     */
    @Override
    public String toString(){
        String vec = "(" + Double.toString(x) + ", " + Double.toString(y) + ")"; 
        return vec;
    }
    /**
     * Metodo que compara si 2 vectores son iguales, si son asi regresa true, en otro caso false
     * @param v - Vector con el cual se va a comparar
     * @return boolean - true si 2 vectores son iguales, false si no
     */
    @Override
    public boolean equals(Object v) {
    Vector2 z = (Vector2)v;
    return x == z.getX() && y == z.getY(); 
}

    
    
}
