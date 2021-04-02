package json.jackson;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class SerializationJson {
	private String name;
	public int id;
	
	public SerializationJson(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	@JsonGetter(value = "firstName")
	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return "Jackson";
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
