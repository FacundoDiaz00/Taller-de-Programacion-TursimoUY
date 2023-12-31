<%-- 

# ATTRIBUTOS QUE PRECISA LA PÁGINA

- List<String> departamentos
- List<String> categorias
- List<DTActividadTuristica> actividades (ya deben estar filtradas)
- List<DTPaquete> paquetes (ya deben estar filtradas)[Falta filtrar por ambos criterios]

 --%>


<%@page import="utils.Utile"%>
<%@page import="publicar.paqueteturisticasservice.DtPaquete"%>

<%@page import="publicar.actividadesturisticasservice.DtActividadTuristica"%>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="publicar.usuarioturisticasservice.DtUsuario" %>
<%@ page import="publicar.usuarioturisticasservice.DtTurista" %>

<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>


<!doctype html>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/jsp/templates/commonHead.jsp"/>
    <link rel="stylesheet" href="css/index.css">

	
</head>
<body>

    <jsp:include page="/WEB-INF/jsp/templates/navBar.jsp"/>

    <section id="contenedor">
		
	<jsp:include page="/WEB-INF/jsp/templates/menuLateral.jsp"/>
        <div id="contenedor-items">
            <!--Actividades-->

            <div class="card" id="contenedor-actividades-turisticas">
                <h2 class="card-title">Actividades</h2>
                
                	<%
                                	DtUsuario usuario = (DtUsuario)session.getAttribute("usuarioLogeado");  
                                	                	List<DtActividadTuristica> actividades = (List<DtActividadTuristica>) request.getAttribute("actividades");
                                	                	Map<DtActividadTuristica, Boolean> actividadesFav = new HashMap<DtActividadTuristica, Boolean>();
                                	                	
                                	                	if(usuario != null && usuario instanceof DtTurista){
                                	                		actividadesFav = (Map<DtActividadTuristica, Boolean>) request.getAttribute("actividadFavorito");
                                	                	}
                                				
                                	                	if (actividades.isEmpty()) {
                                	%>
                		<span>No hay actividades para mostrar aquí.</span>
               		<%
               		} else {
               			               			for(DtActividadTuristica actividad: actividades){
               		%>
								<div class="card mb-3" style="max-width: 800px;">
				                    <div class="row g-0">
				                        <div class="col-md-4 img-contain">
				                            <img src="<%=Utile.obtenerUrlParaImagen(actividad.getImg())%>" class="img-fluid rounded-start">
				                            <!--  Falta el manejo de foto de la verdadera actividad -->
				                        </div>
				                        <div class="col-md-8">
				                            <div class="card-body">
				                            <div  style="justify-content: space-between; display: flex">
				                                  <h5 class="card-title"><%=actividad.getNombre()%></h5>
				                                   <%
				                                   if(session.getAttribute("usuarioLogeado") != null && session.getAttribute("usuarioLogeado") instanceof DtTurista ){ 
				                                   			                                	String idDepartamento = (String)request.getAttribute("idDepartamento");
													   											String idCategoria = (String)request.getAttribute("idCategoria");
				                                   			                                	if(actividadesFav.get(actividad)){
				                                   %>
						                                	<a href="index?marcarComoFav=<%=true%>&nomAct=<%=actividad.getNombre()%><%=idDepartamento == null ? "" : "&idDepartamento="+ idDepartamento%><%=idCategoria == null ? "" : "&idCategoria="+idCategoria%>" ><i class="fa-solid fa-star fa-2x" style="color: #ffc700"></i></a>
						                                
						                                <%
						                                						                                } else {
						                                						                                %>

															<a href="index?marcarComoFav=<%=true%>&nomAct=<%=actividad.getNombre()%><%=idDepartamento == null ? "" : "&idDepartamento="+ idDepartamento%><%=idCategoria == null ? "" : "&idCategoria="+idCategoria%>"><i class="fa-solid fa-star fa-2x" style="color: #CCD1D1"></i></a>
						                                	
						                                <%
						                                							                                } 
						                                							                                			                                	}
						                                							                                %>
					                                	
				                            </div>        	
				                                <p class="card-text descripcion-actividad"><%=actividad.getDescripcion()%></p>
				                               
				                                
				                                <div class="botonera">
				                                    <a href="ConsultaActividad?id=<%=actividad.getNombre()%>" class="btn btn-primary">Ver más</a>
				                                </div>
				                            </div>
				                        </div>
				                    </div>
				                </div>
							
						<%
													}
													                	}
													%>
                

            </div>


            <!--Paquetes-->

            <div class="card" id="contenedor-paquetes">
                <h2 class="card-title">Paquetes</h2>

			<%
			List<DtPaquete> paquetes = (List<DtPaquete>) request.getAttribute("paquetes");
						
					if (paquetes.isEmpty()) {
			%>
	    			<span>No hay paquetes para mostrar aquí.</span>
	   			<%
	   			} else {               	
	   						for(DtPaquete pack: paquetes) {
	   			%>
		                <div class="card mb-3" style="max-width: 800px;">
		                    <div class="row g-0">
		                        <div class="col-md-4 img-contain">

		                            <img src="<%=Utile.obtenerUrlParaImagen(pack.getImg())%>" class="img-fluid rounded-start">
		                            <!-- Falta el manejo de foto de la verdadero paquete-->
		                        </div>
		                        <div class="col-md-8">
		                            <div class="card-body">
		                                <h5 class="card-title"><%= pack.getNombre()%> </h5>
		                                <p class="card-text descripcion-paquete"><%= pack.getDescrpicion()%> </p>
		                                <div class="botonera">
		                                    <a href="ConsultaPaquete?id=<%=pack.getNombre()%>" class="btn btn-primary">Ver más</a>
		                                </div>
		
		                            </div>
		                        </div>
		                    </div>
		                </div>
           <% } }%>

            </div>
        </div>



    </section>

    <jsp:include page="/WEB-INF/jsp/templates/footer.jsp"/>
</body>
</html>