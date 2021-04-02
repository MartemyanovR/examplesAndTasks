package json.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class User {	

	private int id;
	@JsonProperty(value = "name")
	private String name;
	private String lastname;
	private int age;
	
	public User() {	}
		
	public User(int id, String name, String lastname, int age) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.age = age;
	}	
	
	public int getId() {
		return id;
	}
	
	//@JsonProperty(value = "firstName")
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastname=" + lastname + ", age=" + age + "]";
	}	
	

	public enum Jobs {
		DEVELOPER(55),
		MANAGER(35),
		BOSS(75);
		
		private int salary;
		
		Jobs(int salary) {
			this.salary = salary;
		}
		
		@JsonValue
		public int getSalary(){
			return salary;
		}
	}
}
