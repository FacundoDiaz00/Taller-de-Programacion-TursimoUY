package logica.controladores;

import logica.datatypes.DTPaqueteDetalles;

import java.util.List;

import excepciones.PaqueteYaRegistradoException;

/**
 * @author Equipo taller prog 16
 */


public interface IControladorPaquete {
    public void altaPaquete(String nombre, String descripcion, int periodovalidez, float descuento) throws PaqueteYaRegistradoException;
    public List<String> obtenerIdPaquetes();
    public List<String> obtenerIdDepartamentos();
    public List<String> obtenerIdActividadesDeDepartamentoQueNoEstanEnPaquete(String nombreDep, String nombrePaq);
    public void agregarActividadAPaquete(String nombreAct, String nombrePaq);

    /**
     * Devuelve todos los DTPaqueteDetalles de todos los paquetes registrados en el sistema.
     * La misma consiste de todos los datos basicos del paquete y de sus actividades asociadas
     * @return
     */
    List<DTPaqueteDetalles> obtenerDetallesPaquetes();

}
