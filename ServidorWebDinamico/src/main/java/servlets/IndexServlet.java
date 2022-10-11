package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import excepciones.ObjetoNoExisteEnTurismoUy;
import logica.controladores.Fabrica;
import logica.controladores.IControladorActividadTuristica;
import logica.controladores.IControladorPaquete;
import logica.datatypes.DTActividadTuristica;
import logica.datatypes.DTPaquete;
import utils.Utiles;

/**
 * Servlet implementation class IndexServlet
 * 
 * 
 * 
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IControladorActividadTuristica contrAct;
	private IControladorPaquete contrPack;

	public IndexServlet() {
		super();
		contrAct = Fabrica.getInstancia().getIControladorActividadTuristica();
		contrPack = Fabrica.getInstancia().getIControladorPaquete();
	}

	
	/**
	 * parametros posibles:
	 * 	- idDepartamento : codigo del departamento
	 * 	- idCategoria : codigo de la categoria a buscar
	 * 
	 * 
	 * Observacion: 
	 * 	- En caso de no haber idDepartamento ni idCategoria, se toma como idDepartamento = nombre del primer departamento
	 * 	- No se pueden pasar en simultanio el idDepartamento ni el idCategoria
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var departamentos = contrAct.obtenerIdDepartamentos();
		var categorias = contrAct.obtenerIdCategorias();
		
		
		String departamentoElegido = (String) req.getParameter("idDepartamento");
		String categoriaElegida = (String) req.getParameter("idCategoria");
		
		
		if (departamentoElegido == null && categoriaElegida == null){
			req.setAttribute("idDepartamento", departamentos.get(0));
		} else if (departamentoElegido != null && categoriaElegida != null){
			req.setAttribute("motivoDeError", "No se puede ingresar el parametro idDepartamento y idCategoria a la vez");
			req.getRequestDispatcher("/WEB-INF/jsp/errores/400.jsp").forward(req, resp);
			return;
		} else {
			req.setAttribute("idDepartamento", req.getParameter("idDepartamento"));
			req.setAttribute("idCategoria", req.getParameter("idCategoria"));
		}
		
		departamentoElegido = (String) req.getAttribute("idDepartamento");
		categoriaElegida = (String) req.getAttribute("idCategoria");
		
		List<DTActividadTuristica> actividades;
		
		
		try {
			if (departamentoElegido != null){
				actividades = contrAct.obtenerDTActividadesTuristicasConfirmadasPorDepartamento(departamentoElegido);
			} else {
				actividades = contrAct.obtenerDTActividadesTuristicasConfirmadasPorCategoria(categoriaElegida);
			}
		} catch (ObjetoNoExisteEnTurismoUy e){
			req.setAttribute("motivoDeError", "El nombre de la categoria/departamento no existe en el sistema");
			req.getRequestDispatcher("/WEB-INF/jsp/errores/400.jsp").forward(req, resp);
			return;
		}
		
		List<DTPaquete> paquetes = contrPack.obtenerDTPaquetes();

		

		req.setAttribute("departamentos", departamentos);
		req.setAttribute("categorias", categorias);
		req.setAttribute("actividades", actividades);
		req.setAttribute("paquetes", paquetes);
		

		req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
	}

}
