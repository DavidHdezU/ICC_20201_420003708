
import shapesSVG.Circulo;
import shapesSVG.Linea;
import shapesSVG.Rectangulo;
import shapesSVG.Triangulo;
import shapesSVG.Vector2;
import shapesSVG.Transform;

/**
 * Clase Main que sirve para probar todas nuestras clases de fuguras
 * 
 * @author David Hernández Uriostegui
 */
public class Main {
    public static void main(String[] args) {
        /**
         * Se declara el canvas en donde se va trabajar
         */
        String inicio = "<svg heigth='700' width='700'>";
        String cierre = "</svg>";
        /**
         * Se declaran todos los objetos que se van a crear a partir del constructor que
         * elijamos
         */
        Vector2 o = new Vector2(250, 30);
        Linea y = new Linea(new Vector2(10, 20), new Vector2(220, 20));
        Triangulo x = new Triangulo(new Vector2(230, 100), new Vector2(330, 100), new Vector2(280, 50));
        Triangulo z = new Triangulo(new Vector2(230, 100), new Vector2(330, 100), new Vector2(280, 50));
        Rectangulo g = new Rectangulo(new Vector2(400, 100), 200.0, 50.0);
        Rectangulo f = new Rectangulo(new Vector2(400, 100), 100.0, 50.0);
        Circulo h = new Circulo(new Vector2(50, 100), 40.0);
        Circulo m = new Circulo(new Vector2(50, 100), 30.0);
        /**
         * Se imprime primero el inicio del canvas
         */
        System.out.println(inicio);
        /**
         * Se imprimen todos los objetos llamando al metodo toSVG de cada uno
         */
        System.out.println(h.toSVG());
        System.out.println(x.toSVG());
        System.out.println(y.toSVG());
        System.out.println(o.toSVG());
        System.out.println(g.toSVG());
        /**
         * Se imprime el cierre del canvas para cerrar el codigo
         */
        System.out.println(cierre);
        System.out.println(
                "-------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("Aplicando transform al triangulo x...");
        System.out.println(x + "\n Después de aplicar la función transform: ");
        x.transform((Vector2 v) -> (new Vector2(v.getX() + 30, v.getY() + 20)));
        System.out.println(x + "\n");

        System.out.println("Comparando todas las figuras: ");
        System.out.println(h.compareTo(m)); // Circulos
        System.out.println(g.compareTo(f)); // Rectangulos
        System.out.println(x.compareTo(z)); // Triangulos
    }

}
