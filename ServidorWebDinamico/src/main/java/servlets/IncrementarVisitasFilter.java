package servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import publicar.actividadesturisticasservice.EstadoActividadTuristica;
import publicar.actividadesturisticasservice.ObjetoNoExisteEnTurismoUy_Exception;
import publicar.actividadesturisticasservice.WebServiceActividades;
import publicar.actividadesturisticasservice.WebServiceActividadesService;
import publicar.actividadesturisticasservice.DtActividadTuristica;
import publicar.actividadesturisticasservice.DtMapActividadSalidaTuristicaCollection;
import publicar.actividadesturisticasservice.DtSalidaTuristica;
/**
 * Servlet Filter implementation class IncrementarVisitasFilter
 */
@WebFilter({"/ConsultaActividad", "/ConsultaSalida"})
public class IncrementarVisitasFilter extends HttpFilter implements Filter {
	private WebServiceActividades wbActi;
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public IncrementarVisitasFilter() {
        super();
        wbActi = new WebServiceActividadesService().getWebServiceActividadesPort();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		if (request.getCharacterEncoding() == null) {
			request.setCharacterEncoding("UTF-8");
		}

		String xTuristica = request.getParameter("id");
		HttpServletRequest httpReq = (HttpServletRequest) request;
		String uri = httpReq.getRequestURI();
		if (uri.contains("ConsultaActividad"))
			wbActi.incrementarContadorActividad(xTuristica);
		else if (uri.contains("ConsultaSalida"))
			wbActi.incrementarContadorSalida(xTuristica);
		else System.out.println(uri);
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
