package logica.datatypes;

import java.time.LocalDate;

public class DTInscripcion {
	private LocalDate fechaInscripcion;
	private int cantidadTuristas;
	private float costo;
	private DTSalidaTuristica salida;
	private String turista;

	public DTInscripcion(LocalDate fechaInscripcion, int cantidadTuristas, float costo, DTSalidaTuristica salida, String turista) {
		this.fechaInscripcion = fechaInscripcion;
		this.cantidadTuristas = cantidadTuristas;
		this.costo = costo;
		this.salida = salida;
		this.turista = turista;
	}

	public LocalDate getFechaInscripcion() {
		return this.fechaInscripcion;
	}

	public int getCantidadTuristas() {
		return this.cantidadTuristas;
	}

	public DTSalidaTuristica getSalidaTuristica() {
		return this.salida;
	}

	public String getTurista() {
		return this.turista;
	}

	public float getCosto() {
		return costo;
	}
}
