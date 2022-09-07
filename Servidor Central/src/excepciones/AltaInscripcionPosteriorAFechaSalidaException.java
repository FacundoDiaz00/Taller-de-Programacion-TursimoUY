package excepciones;

/**
 * Excepcion utilizada para indicar que se intento realizar una isncripcion en una fecha posterior a la de la salida.
 *
 *   @author Equipo taller prog 16

 */
public class AltaInscripcionPosteriorAFechaSalidaException extends Exception{
    public AltaInscripcionPosteriorAFechaSalidaException(String texto){
        super(texto);
    }

}
