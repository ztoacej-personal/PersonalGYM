package www.dream.com.product.model.mapper;

import www.dream.com.product.model.ProductVO;

public interface ProductMapper {
	public ProductVO selectProduct(long id);
	public ProductVO selectProductWithSeller(long id);
	public ProductVO selectProductWithSellerAndBom(long id);
}
