package model;

public class Clase {
	private String profesor;
	private String name;
	
	public Clase() {
		
	}
	public Clase(String profesor, String name) {
		this.profesor = profesor;
		this.name = name;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
