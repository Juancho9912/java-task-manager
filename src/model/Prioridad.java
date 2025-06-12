package model;

public enum Prioridad {
	Baja, Media, Alta;

	@Override
	public String toString() {
		return name().toLowerCase();
	}
}
