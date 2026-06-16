package www.dream.com.framework.model;

import java.util.List;

import www.dream.com.framework.attachFile.model.AttachVO;
/**
 * 첨부 파일을 달 수 있는 객체들은 본 인터페이스를 구현하여 AttachMapper에서 정의한 함수를 통하시오.
 * 공통 컴포넌트 설계 구현하는 능력을 면접관에게 보여주세요!!!
 */
public interface IAttacher {
	public long getId();
	public String getOwnerType();
	public List<AttachVO> getListAttach();
}
