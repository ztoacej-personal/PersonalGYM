package www.dream.com.framework.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Criteria {
	public enum SortMethod {
		sortByDate, sortByAccuracy
	}
	/** 쪽 건너뛰기 버튼 전체 개수 */
	private static final long PAGING_AMOUNT = 10;
	/** 쪽당 몇 건 보여줄까? */
	public static final int DEFAULT_AMOUNT = 10;
	
	@Setter
	private String search;
	private long pageNum;	//전체 건수 나누기 쪽 당 나타낼 정보 건수 
	//private int amount;		//거대 모니터의 경우 사용자의 나이까지... 장애인 여부까지... 사용성을 고려한 개수 설정이 ....
	@Getter @Setter
	private SortMethod sortMethod = SortMethod.sortByDate;	//정렬 방식. {최신순, 정확도순}
	
	private long startPage, endPage;
	private long totalDataCount;
	private boolean hasPrev, hasNext;
	
	public Criteria() {
		this(1, 1241);
	}
	
	public Criteria(long pageNum, long totalDataCount) {
		this.totalDataCount = totalDataCount;
		setPageNum(pageNum);
	}
	
	public long getOffset() {
		return (pageNum - 1) * DEFAULT_AMOUNT;
	}
	
	public long getLimit() {
		return pageNum * DEFAULT_AMOUNT;
	}

	public void setPageNum(long pageNum) {
		this.pageNum = pageNum;
		
		//10, 20, 30 이런 식으로 페이징 처리하기
		//endPage = (int) Math.ceil(pageNum / (float) PAGING_AMOUNT) * PAGING_AMOUNT;
		endPage = pageNum + PAGING_AMOUNT / 2;	//구글 스타일
		endPage = endPage < PAGING_AMOUNT ? PAGING_AMOUNT : endPage;
		startPage = endPage - PAGING_AMOUNT + 1;
		int realEnd = (int) Math.ceil((float) totalDataCount / DEFAULT_AMOUNT);
		if (realEnd < endPage)
			endPage = realEnd;
		hasPrev = startPage > 1;
		hasNext = endPage < realEnd;
	}
	
	public String[] getSearchArr() {
		return (search != null && !search.isEmpty()) ? search.split(" ") : null;
	}

	public void setTotalDataCount(long totalDataCount) {
		this.totalDataCount = totalDataCount;

		int realEnd = (int) Math.ceil((float) totalDataCount / DEFAULT_AMOUNT);
		if (realEnd < endPage)
			endPage = realEnd;
		hasNext = endPage < realEnd;
	}
}
