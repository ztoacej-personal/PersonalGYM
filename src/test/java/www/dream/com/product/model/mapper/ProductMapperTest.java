package www.dream.com.product.model.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import www.dream.com.party.model.PartyVO;
import www.dream.com.product.model.ProductVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml")
public class ProductMapperTest {
	@Autowired
	private ProductMapper productMapper;

//	@Test
	public void testProduct() {
		try {
			ProductVO productVO = productMapper.selectProduct(2L);
			System.out.println(productVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Test
	public void testProductWithSeller() {
		try {
			ProductVO productVO = productMapper.selectProductWithSeller(2L);
			System.out.println(productVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testProductWithSellerAndBom() {
		try {
			ProductVO productVO = productMapper.selectProductWithSellerAndBom(1L);
			System.out.println(productVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
