package edu.ieu.ejemplorest.api;

public class Saludo {
	private String nombre;
	private String texto;
	
	public Saludo() {
		super();
	}

	public Saludo(String nombre, String texto) {
		super();
		this.nombre = nombre;
		this.texto = texto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
}
