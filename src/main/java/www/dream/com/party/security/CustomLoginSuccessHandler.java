package www.dream.com.party.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	//인증 성공. id, pwd가 맞아 떨어짐. 권한 관리는 아님
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		List<String> listRoleName = new ArrayList<>();
		
		authentication.getAuthorities().forEach(auth->{
			listRoleName.add(auth.getAuthority());
		});
		
		if (listRoleName.contains("ROLE_ADMIN")) {
			response.sendRedirect("/post/listPost?boardId=1");
		} else if (listRoleName.contains("ROLE_MEMBER")) {
			response.sendRedirect("/post/listPost?boardId=2");
		} else {
			response.sendRedirect("/post/listPost?boardId=3");
		}
	}

}
