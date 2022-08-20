package logica.controladores;

import excepciones.DeparamentoYaRegistradoException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Equipo taller prog 16
 */

public interface IControladorActividadTuristica {

    void altaDepartamento(String nom, String descr, String URL) throws DeparamentoYaRegistradoException;

    //Operaciones de CdeU: Alta de Actividad Turistica
	List<String> obtenerIdProveedores();
	List<String> obtenerIdDepartamentos();
	boolean altaActividadTuristica(String nombreProveedor, String departamento, String nombreActividad, String descripcion, int duracion, float costo, String ciudad, LocalDate fechaAlta);
	//fin operaciones AAT

}
