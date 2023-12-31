package excepciones;

/**
 * Excepcion utilizada para indicar que un Departamento ya existe en el sistema
 *
 * @author Equipo taller prog 16
 * 
 */
public class DeparamentoYaRegistradoException extends TurismoUyException {
	private static final long serialVersionUID = 1L;

	public DeparamentoYaRegistradoException(String texto) {
		super(texto);
	}
}
