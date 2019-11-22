package practica10;


public class Box<T>{
	private T contenido;
	public void setContenido(T elemento){
		this.contenido=elemento;
	}
	public T getContenido(){
		return this.contenido;
	}
	@Override
	public String toString(){
		return "La caja contiene "+this.contenido.toString();
	}
	public static void main(String[] args){
		Box<Integer> caja=new Box<>();
		caja.setContenido(1111);
		System.out.println(caja);
	}
}