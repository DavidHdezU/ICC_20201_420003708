/**
 * Clase que modela un triángulo a partir de 3 puntos
 * @author David Hernández Uriostegui
 */
package shapesSVG;
public class Triangulo extends Shape{
    private Vector2 a;
    private Vector2 b;
    private Vector2 c;
     /**
     * Parametros de la clase Triángulo
     * @param a - El punto a partir del cual se crea el triángulo
     * @param b - El punto b partir del cual se crea el triángulo
     * @param a - El punto c partir del cual se crea el triángulo
     */

     /**
      * Constructor que pide 3 puntos a partir de los cuales se va a crear el triangulo
      * @param a - Punto a
      * @param b - Punto b
      * @param c - Punto c
      */
    public Triangulo(Vector2 a, Vector2 b, Vector2 c){
        super();
        this.a = a;
        this.b = b;
        this.c = c;
        this.area = calculaArea();
        this.perimetro = calculaPerimetro();
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
        this.area = calculaArea();
        this.perimetro = calculaPerimetro();
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
         this.area = calculaArea();
         this.perimetro = calculaPerimetro();
        }

        @Override
        public double calculaArea(){
            double base = a.distancia(b);
            Vector2 pMedio = new Vector2(((a.getX() + b.getX())/2), ((a.getY() + b.getY())/2));
            double altura = pMedio.distancia(c);
            double area = ((base * altura)/2);
            return area;
        }

        @Override
        public double calculaPerimetro(){
            double per = a.distancia(b) + b.distancia(c) + c.distancia(a);
            return per;
        }
     /**
      * Creación de setters
      */
    public void setA(Vector2 a){
        this.a = a;
        this.perimetro = calculaPerimetro();

    }
    public void setB(Vector2 b){
        this.b = b;
        this.perimetro = calculaPerimetro();

    }
    public void setC(Vector2 c){
        this.c = c;
        this.perimetro = calculaPerimetro();

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
    /**
     * Metodo que permite que nuestro triángulo sea representado gráficamente, regresa una cadena que representa la represetación del triángulo en SVG
     * @return String - La representación del triángulo en SVG
     */
    @Override
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
        String trian = "El triangulo tienes su punto a en: " + a + " , tiene su punto b en: " + b + " y su punto c en: " + c + "\n" + super.toString();
        return trian;
    }
    /**
     * Metodo que compara si 2 triángulos son iguales, si son asi regresa true, en otro caso false
     * @param v - Triángulo con el cual se va a comparar
     * @return boolean - true si 2 triángulos son iguales, false si no
     */
    @Override
    public boolean equals(Object v) {
    if(!(v instanceof Triangulo))return false;
    Triangulo z = (Triangulo)v;
    return a.equals(z.getA()) && b.equals(z.getB()) && c.equals(z.getC()); 
    }
    /**
     * Metodo que transforma a traves de una interfaz funcional
     * @param x - Transformacion
     */
    public void transform(Transform x){
        this.a = x.transform(this.a);
        this.b = x.transform(this.b);
        this.c = x.transform(this.c);
  }

}

