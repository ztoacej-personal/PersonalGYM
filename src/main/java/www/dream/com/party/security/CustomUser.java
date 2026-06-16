package www.dream.com.party.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import www.dream.com.party.model.PartyVO;

@Getter
public class CustomUser extends User {
	private static final long serialVersionUID = 2L;

	private PartyVO loginUser;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public CustomUser(PartyVO user) {
		//Lamda expression map : 목록에서 나오는 각 객체에 지정된 함수를 적용하여 나오는 결과를 다시 스트림으로 만들어 줍니다.
		super(user.getLoginId(), user.getPassword(), 
				user.getListAuthority().stream().map(
				auth -> new SimpleGrantedAuthority(auth.getAuthority()))
				.collect(Collectors.toList()));
		this.loginUser = user;
	}

}
