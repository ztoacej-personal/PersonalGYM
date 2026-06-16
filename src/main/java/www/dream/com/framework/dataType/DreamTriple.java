package www.dream.com.framework.dataType;

import java.io.Serializable;

public class DreamTriple<F, S, T> implements Serializable {
	private F first;
	private S second;
	private T third;
	
	public DreamTriple(F first, S second, T third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}
	
	public F getFirst() {
		return first;
	}
	public S getSecond() {
		return second;
	}
	public T getThird() {
		return third;
	}
}
