package www.dream.com.product.model;

import java.io.Serializable;

import www.dream.com.framework.model.CommonMngInfoVO;
import www.dream.com.party.model.PartyVO;

public abstract class ProductVO extends CommonMngInfoVO implements Serializable {
	private long id;
	private String name;
	private long value;
	private String descript;
	
	/* ------------   연관 정보 정의 영역   ----------- */
	private long sellerId;
	private PartyVO seller;

	public ProductVO(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", value=" + value + ", descript=" + descript + ", seller="
				+ seller;
	}
}
