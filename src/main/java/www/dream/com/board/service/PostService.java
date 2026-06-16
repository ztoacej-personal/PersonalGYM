package www.dream.com.board.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.executor.CachingExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import www.dream.com.board.model.PostVO;
import www.dream.com.board.model.ReplyVO;
import www.dream.com.board.model.mapper.ReplyMapper;
import www.dream.com.framework.attachFile.model.mapper.AttachMapper;
import www.dream.com.framework.hashTagAnalyzer.model.HashTagVO;
import www.dream.com.framework.hashTagAnalyzer.service.HashTagService;
import www.dream.com.framework.model.Criteria;
import www.dream.com.framework.util.BeanUtil;

@Service
public class PostService {
	@Autowired
	private ReplyMapper replyMapper;
	@Autowired
	private AttachMapper attachMapper;
	
	public long countTotalPostWithPaging(long boardId, Criteria criteria) {
		long cnt = replyMapper.countTotalPostWithPaging(boardId, criteria);
		return cnt;
	}

	public List<ReplyVO> listPostWithPaging(long boardId, Criteria criteria) {
		CachingExecutor ss;
		switch(criteria.getSortMethod()) {
		case sortByDate:
			return replyMapper.listPostByDateWithPaging(boardId, criteria);
		case sortByAccuracy:
			return replyMapper.listPostByAccuracyWithPaging(boardId, criteria);
		}
		return new ArrayList<>();
	}

	public ReplyVO findPostById(long id) {
		//조회수
		replyMapper.incViewCnt(id);
		PostVO post = (PostVO) replyMapper.findReplyById(id);
		return post;
	}

	@Transactional
	public void registerPost(PostVO post) {
		HashTagService hashTagService = BeanUtil.getBean(HashTagService.class);

		List<HashTagVO> listHashTag = ReplyService.identifyOldAndNew(post, hashTagService);

		replyMapper.registerPost(post);
		hashTagService.createRelWithReply(post.getId(), listHashTag);
		if (post.hasAttach())
			attachMapper.createAttach(post);
	}

	@Transactional
	public boolean updatePost(PostVO post) {
		HashTagService hashTagService = BeanUtil.getBean(HashTagService.class);
		hashTagService.deleteRelWithReply(post.getId());

		List<HashTagVO> listHashTag = ReplyService.identifyOldAndNew(post, hashTagService);

		hashTagService.createRelWithReply(post.getId(), listHashTag);

		attachMapper.deleteAttach(post);
		if (post.hasAttach()) {
			attachMapper.createAttach(post);
		}

		return replyMapper.updatePost(post);
	}

	@Transactional
	public boolean removePost(PostVO post) {
		HashTagService hashTagService = BeanUtil.getBean(HashTagService.class);
		hashTagService.deleteRelWithReply(post.getId());
		if (post.hasAttach()) {
			attachMapper.deleteAttach(post);
		}
		return replyMapper.removeReply(post.getId());
	}

	public int likePost(long postId, int likeToggle) {
		replyMapper.likePost(postId, likeToggle);
		return replyMapper.readLikeCount(postId);
	}

	public int dislikePost(long postId, int dislikeToggle) {
		replyMapper.dislikePost(postId, dislikeToggle);
		return replyMapper.readDislikeCount(postId);
	}

}
