package pojos.gmibank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
@JsonIgnoreProperties
public class StatesPojo implements Serializable {
	private int id;
	private String name;


	public StatesPojo(int id) {
		this.id = id;
	}

	public StatesPojo(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"StatesPojo{" + 
			"id = '" + id + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}