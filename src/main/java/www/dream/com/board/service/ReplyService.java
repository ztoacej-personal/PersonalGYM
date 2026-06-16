package www.dream.com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.dream.com.board.model.ReplyVO;
import www.dream.com.board.model.mapper.ReplyMapper;
import www.dream.com.framework.dataType.DreamPair;
import www.dream.com.framework.hashTagAnalyzer.model.HashTagVO;
import www.dream.com.framework.hashTagAnalyzer.service.HashTagService;
import www.dream.com.framework.model.Criteria;
import www.dream.com.framework.util.BeanUtil;

@Service
public class ReplyService {
	@Autowired
	private ReplyMapper replyMapper;

	public long countTotalReplyWithPaging(long originalId) {
		return replyMapper.countTotalReplyWithPaging(originalId);
	}
	
	public List<ReplyVO> listReplyWithPaging(long originalId, Criteria criteria) {
		return replyMapper.listReplyWithPaging(originalId, criteria);
	}
	
	public ReplyVO findReplyById(long id) {
		return replyMapper.findReplyById(id);
	}
	
	/**
	 * 댓글 등록
	 * @param reply
	 * @return 원글에 달린 총 댓글 개수가 반환
	 */
	public long registerReply(ReplyVO reply) {
		long cnt = replyMapper.registerReply(reply);
		//원글에 댓글을 추가해 줄 때 댓글 개수를 파악하여 반환하자
		cnt = replyMapper.countTotalReplyWithPaging(reply.getOriginalId());
		return cnt;
	}
	
	public boolean updateReply(ReplyVO reply) {
		HashTagService hashTagService = BeanUtil.getBean(HashTagService.class);
		hashTagService.deleteRelWithReply(reply.getId());

		List<HashTagVO> listHashTag = identifyOldAndNew(reply, hashTagService);

		hashTagService.createRelWithReply(reply.getId(), listHashTag);

		return replyMapper.updateReply(reply);
	}
	
	public boolean removeReply(long id) {
		HashTagService hashTagService = BeanUtil.getBean(HashTagService.class);
		hashTagService.deleteRelWithReply(id);
		return replyMapper.removeReply(id);
	}

	protected static List<HashTagVO> identifyOldAndNew(ReplyVO reply, HashTagService hashTagService) {
		String hashTag = reply.getHashTag();
		String[] arrHashTag = {""};
		if (hashTag != null) {
			arrHashTag = hashTag.split(" ");
		}
		//교집합 되는 것들, 새것들
		DreamPair<List<HashTagVO>, List<HashTagVO>> pair = hashTagService.split(arrHashTag);
		/* 신규 단어 등록 */
		hashTagService.createHashTag(pair.getSecond());
		//전체 단어와 게시글 사이의 연결 고리를 만들어 줍니다.
		//이 기능을 만들곳이 HashTag에 있어야하나? 아니면 각 사용 주체에게 달려있어야 할까?
		pair.getFirst().addAll(pair.getSecond());
		return pair.getFirst();
	}
}
