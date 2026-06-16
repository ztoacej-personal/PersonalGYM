package www.dream.com.party.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import www.dream.com.party.model.PartyVO;

public interface PartyMapper {
	
	public List<PartyVO> selectAllParty(String partyType);
	public List<PartyVO> selectAllPartyWithContactPoint(String partyType);

	public PartyVO findPersonByLoginId(@Param("loginId") String loginId);
	public boolean changePwd(PartyVO person);

	/* 중복체크 */
	public boolean chkIdDup(String newId);
	public boolean chkNickDup(String newNick);

	public void registerParty(PartyVO newbie);
	public void registerAuthority(long id, String authority);
}
