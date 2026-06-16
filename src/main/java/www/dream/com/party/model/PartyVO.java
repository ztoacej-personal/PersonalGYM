package www.dream.com.party.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import www.dream.com.framework.model.CommonMngInfoVO;

@Data
@NoArgsConstructor
public class PartyVO extends CommonMngInfoVO implements Serializable {
	@Getter @Setter
	private long id;
	@Getter @Setter
	private String name;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Getter @Setter
	private Date birthDate;
	
	@Getter @Setter
	private String loginId;
	@Getter @Setter
	private String password;
	@Getter @Setter
	private String nickname;
	
	/* 연관 정보 정의 부분 */
	private List<AuthorityVO> listAuthority;
	
	public PartyVO(long id) {
		this.id = id;
	}

	public void encodePassword(PasswordEncoder passwordEncoder) {
		password = passwordEncoder.encode(password);
	}
}
