public class Key<T,E>{
	private T key;
	private E value;

	public E get(T key){
		if(key.equals(this.key))
			return value;
		return null;
	}
}