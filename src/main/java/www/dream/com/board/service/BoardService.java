package www.dream.com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.dream.com.board.model.BoardVO;
import www.dream.com.board.model.mapper.BoardMapper;

@Service
public class BoardService {
	@Autowired
	private BoardMapper boardMapper;

	public List<BoardVO> selectAllBoard() {
		return boardMapper.selectAllBoard();
	}
}
