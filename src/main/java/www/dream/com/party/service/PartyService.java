package www.dream.com.party.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import www.dream.com.party.model.PartyVO;
import www.dream.com.party.model.mapper.PartyMapper;

@Service
public class PartyService {
	@Autowired
	private PartyMapper partyMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public List<PartyVO> selectAllParty(String partyType) {
		return partyMapper.selectAllParty(partyType);
	}
	
	public List<PartyVO> selectAllPartyWithContactPoint(String partyType) {
		return partyMapper.selectAllPartyWithContactPoint(partyType);
	}

	public boolean chkIdDup(String newId) {
		return partyMapper.chkIdDup(newId);
	}
	
	public boolean chkNickDup(String newNick) {
		return partyMapper.chkNickDup(newNick);
	}

	public void registerParty(PartyVO newbie) {
		newbie.encodePassword(passwordEncoder);
		partyMapper.registerParty(newbie);
		partyMapper.registerAuthority(newbie.getId(), "ROLE_MEMBER");
	}

	
}
