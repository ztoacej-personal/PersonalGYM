package www.dream.com.board.controller;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import www.dream.com.board.model.ReplyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src\\main\\webapp\\WEB-INF\\spring\\appServlet\\servlet-context.xml",
	"file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml"})
public class PostControllerTest {
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;	//Browser 흉내기
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testListPost() {
		try {
			MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/post/list?boardId=1");
			ResultActions resultActions = mockMvc.perform(requestBuilder);
			MvcResult mvcResult = resultActions.andReturn();
			ModelAndView mav = mvcResult.getModelAndView();
			ModelMap mm = mav.getModelMap();
			List<ReplyVO> list = (List<ReplyVO>) mm.getAttribute("listPost");
			for (ReplyVO post : list) {
				System.out.println(post);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
