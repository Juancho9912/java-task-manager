package model;
import model.Prioridad;

public class Task {
	private int id;
	private String titulo;
	private String descripcion;
	private boolean completada;
	private Prioridad prioridad;

	public Task(int id, String titulo, String descripcion, String prioridad) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.completada = false;
		try {
			this.prioridad = Prioridad.valueOf(prioridad);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Prioridad no válida: " + prioridad);
		}
	}
	public int getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public boolean isCompletada() {
		return completada;
	}
	public Prioridad getPrioridad() {
		return prioridad;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void completar() {
		this.completada = true;
	}
	public void descompletar() {
		this.completada = false;
	}
	public String toString() {
		return "Tarea{id=" + id + ", titulo='" + titulo + "', descripcion='" + descripcion + "', prioridad=" + prioridad + ", completada=" + completada + "}";
	}
	public String getPrioridadString() {
		return prioridad.name();
	}

	public void setPrioridad(String prioridad) {
		try {
			this.prioridad = Prioridad.valueOf(prioridad);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Prioridad no válida: " + prioridad);
		}
	}
}