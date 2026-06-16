package www.dream.com.framework.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import www.dream.com.framework.display.Caption;
import www.dream.com.framework.display.Caption.WhenUse;

/**
 * 모든 테이블에 있는 관리 정보를 각 VO에 중복적으로 개발해 놓기 보다는
 * 상속 구조를 활용하여 공통화 시킴
 * FrameworkMapper.xml 참조
 */
public abstract class CommonMngInfoVO {
	@Getter @Setter
	@Caption(whenUse=WhenUse.all, caption="등록일")
	protected Date regDate;
	@Getter @Setter
	@Caption(whenUse=WhenUse.all, caption="수정일")
	protected Date updateDate;
}
