package www.dream.com.framework.attachFile.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import www.dream.com.board.model.PostVO;
import www.dream.com.framework.attachFile.model.AttachVO;
import www.dream.com.framework.model.IAttacher;

public interface AttachMapper {
	public List<AttachVO> listAttach(AttachVO attachVO);
	public void createAttach(IAttacher owner);
	public void deleteAttach(IAttacher owner);
}
