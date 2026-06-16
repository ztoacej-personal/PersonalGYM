package www.dream.com.framework.hashTagAnalyzer.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class HashTagVO implements Serializable {
	private long id;
	private String word;
	private String descript;

	private HashTagVO superHashTag;
	private List<HashTagVO> childHashTag;

	public HashTagVO() {
	}
	
	public HashTagVO(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashTagVO other = (HashTagVO) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}
}
