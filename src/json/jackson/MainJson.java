package json.jackson;


import java.io.StringReader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainJson {
	public static void main(String[] args) throws JsonProcessingException {
		
		ObjectMapper om = new ObjectMapper();
		User user = new User(1,"Tom", "Jonh", 35);
		String json = om.writeValueAsString(user);
		System.out.println(json);
		User user2 = om.readValue(json, User.class);
		System.out.println(user2.toString());
		System.out.println(user.equals(user2));
		
		
		String json2 = new ObjectMapper().writeValueAsString(User.Jobs.BOSS);
		System.out.println(json2);
		
		/*
		SerializationJson serial = new SerializationJson("Tom", 1);
		String json = new ObjectMapper().writeValueAsString(serial);
		System.out.println(json);*/
	
	}

}
