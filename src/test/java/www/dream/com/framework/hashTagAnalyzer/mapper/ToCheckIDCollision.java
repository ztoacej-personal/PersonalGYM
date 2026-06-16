package www.dream.com.framework.hashTagAnalyzer.mapper;

import java.util.ArrayList;
import java.util.List;

import www.dream.com.framework.hashTagAnalyzer.model.HashTagVO;
import www.dream.com.framework.hashTagAnalyzer.service.HashTagService;
import www.dream.com.framework.util.BeanUtil;

public class ToCheckIDCollision extends Thread {
	public ToCheckIDCollision() {
	}

	/**
	 * 에러 투성이...
	 */
	@Override
	public void run() {
		try {
			List<HashTagVO> listNewTag = new ArrayList<>();
			HashTagVO ddd = new HashTagVO();
			ddd.setWord("AAAA");
			listNewTag.add(ddd);
			ddd = new HashTagVO();
			ddd.setWord("BBBBB");
			listNewTag.add(ddd);
			
			HashTagService hashTagService = BeanUtil.getBean(HashTagService.class);
			System.out.println(hashTagService.hashCode());
			hashTagService.createHashTag(listNewTag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
