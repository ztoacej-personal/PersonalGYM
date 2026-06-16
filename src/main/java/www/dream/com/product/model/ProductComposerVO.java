package www.dream.com.product.model;

import java.util.List;

public class ProductComposerVO extends ProductVO {
	/* ------------   연관 정보 정의 영역   ----------- */
	private List<ProductVO> listBom;

	public ProductComposerVO(Long id) {
		super(id);
	}

	@Override
	public String toString() {
		return "ProductComposerVO [" + super.toString() + ", listBom=" + listBom + "]";
	}
}
