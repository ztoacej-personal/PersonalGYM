package www.dream.com.framework.dataType;

import java.io.Serializable;

public class DreamPair<F, S> implements Serializable {
	private F first;
	private S second;
	
	public DreamPair(F first, S second) {
		this.first = first;
		this.second = second;
	}
	
	public F getFirst() {
		return first;
	}
	public S getSecond() {
		return second;
	}
}
