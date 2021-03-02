package model;

import java.util.ArrayList;

public class Estudiante {
	private String nombre;
	private String codigo;
	private ArrayList<Clase> clases;
	
	
	
	
	public Estudiante() {
	
	}




	public Estudiante(String nombre, String codigo, ArrayList<Clase> clases) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.clases = clases;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getCodigo() {
		return codigo;
	}




	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}




	public ArrayList<Clase> getClases() {
		return clases;
	}




	public void setClases(ArrayList<Clase> clases) {
		this.clases = clases;
	}
	
	
	
	
}
