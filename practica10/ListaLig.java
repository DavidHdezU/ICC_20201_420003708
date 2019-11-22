package practica10;

import java.util.Iterator;
import practica10.Lista;


public class ListaLig<T>implements Lista<T>{
	@Override
	public Iterator<T> iterator(){}
	@Override
	public void agrega(T elemento){}
	@Override
	public void eliminar(T elemento){}
	@Override
	public boolean contiene(T elemento){}
	@Override
	public int longitud(){}
	@Override
	public T primerElemento(){}
}