package shapesSVG;

/**
* Interfaz funcional que sirve para tranformar un triángulo.
* @author David Hernández Uriostegui
**/

@FunctionalInterface
public interface Transform{
  /**
  * Método que transforma un triángulo
  * @param : Vector2 p - el punto que se transformara
  * @return : Vector2 transform - el nuevo punto
  **/
  public Vector2 transform(Vector2 p);

}