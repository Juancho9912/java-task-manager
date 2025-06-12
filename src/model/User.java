package model;

public class User {
	private int id;
	private String nombre;
	private String email;

	public User(int id, String nombre, String email) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String toString() {
		return "Usuario{id=" + id + ", nombre='" + nombre + "', email='" + email + "'}";
	}
}
