package practica10;

public interface Lista<T> extends Iterable<T>{
	public void agrega(T elemento);
	public void eliminar(T elemento);
	public boolean contiene(T elemento);
	public int longitud();
	public T primerElemento();
}