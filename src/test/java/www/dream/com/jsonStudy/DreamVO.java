package www.dream.com.jsonStudy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DreamVO {
	private int id;
	private String name;
	
	public static void main(String[] args) throws JsonProcessingException {
		DreamVO obj = new DreamVO(1, "홍길동");
		
		ObjectMapper om = new ObjectMapper();
		System.out.println(om.writeValueAsString(obj));
		
	}

}
