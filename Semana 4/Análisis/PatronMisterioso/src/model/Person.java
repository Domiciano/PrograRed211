package model;

public class Person extends ModelBase{
	
	private String id;
	private String name;
	
	public Person() {
		
	}
	
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}



	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		notifyDatasetChanged();
	}
	
	public void setId(String id) {
		this.id = id;
		notifyDatasetChanged();
	}
	
	

}
