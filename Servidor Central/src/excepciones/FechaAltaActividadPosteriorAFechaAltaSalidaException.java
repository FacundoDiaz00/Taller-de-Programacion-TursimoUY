package excepciones;

/**
 * Excepcion utilizada para indicar que la fecha ingresada es invalida
 *
 * @author Equipo taller prog 16
 * 
 */
public class FechaAltaActividadPosteriorAFechaAltaSalidaException extends TurismoUyException {
	private static final long serialVersionUID = 1L;
	
	public FechaAltaActividadPosteriorAFechaAltaSalidaException(String message) {
		super(message);
	}

}
