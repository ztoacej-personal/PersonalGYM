package www.dream.com.party.model.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import www.dream.com.party.model.PartyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml",
	"file:src\\main\\webapp\\WEB-INF\\spring\\security-context.xml"})
public class PartyMapperTest {
	@Autowired
	private PartyMapper partyMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	//@Test
	public void testPerson() {
		try { 
		assertNotNull(partyMapper);
		for (PartyVO party : partyMapper.selectAllParty("organization"))
			System.out.println(party);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//@Test
	public void testPersonWithCP() {
		try { 
		assertNotNull(partyMapper);
		for (PartyVO party : partyMapper.selectAllPartyWithContactPoint("organization"))
			System.out.println(party);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testChgPwd() {
		try {
			/*
			PartyVO creator = partyMapper.findPersonByLoginId("creator");
			creator.setPassword(passwordEncoder.encode("creator"));
			partyMapper.changePwd(creator);

			PartyVO hongkildong = partyMapper.findPersonByLoginId("hong");
			hongkildong.setPassword(passwordEncoder.encode("hong"));
			partyMapper.changePwd(hongkildong);
			 */
			
			PartyVO Aaron = partyMapper.findPersonByLoginId("a");
			Aaron.setPassword(passwordEncoder.encode("a"));
			partyMapper.changePwd(Aaron);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testPwd() {
		try {
			PartyVO creator = partyMapper.findPersonByLoginId("creator");
			System.out.println(creator);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
