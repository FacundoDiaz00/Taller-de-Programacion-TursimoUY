
<%@page import="utils.Utile"%>
<%@page import="publicar.usuarioturisticasservice.DtTurista"%>
<%@page import="publicar.actividadesturisticasservice.DtSalidaTuristicaDetalle"%>
<%@page import="publicar.usuarioturisticasservice.DtUsuario"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>

	<jsp:include page="/WEB-INF/jsp/templates/commonHead.jsp"/>  	    
    <link rel="stylesheet" href="css/consulta_de_salida_turistica.css">
    
</head>
<body>
<main>

    <jsp:include page="/WEB-INF/jsp/templates/navBar.jsp"/>

    <section id="contenedor">
        <jsp:include page="/WEB-INF/jsp/templates/menuLateral.jsp"/>

		<%
		DtSalidaTuristicaDetalle infoSalida = (DtSalidaTuristicaDetalle)request.getAttribute("datosSalida");
		%>

        <div id="titulo">
            <h1>Consulta de Salida turística</h1>
        </div>

        <div id="info-salida">


            <div id="info-general-imagen">                             
			    <img src="<%=Utile.obtenerUrlParaImagen(infoSalida.getImg())%>" class="img-fluid rounded-start paquetes"  style="margin: 10px" alt="">
            </div>

            <div id="info">
                <h2><%=infoSalida.getNombre()%></h2>
                <h6>Creado el <%=infoSalida.getFechaAltaStr()%></h6>
                <%
                boolean turistaLogueado = false;
                        		try {
                	        		DtTurista tur = (DtTurista) session.getAttribute("usuarioLogeado");
                	        		turistaLogueado = tur != null;
                        		} catch (Exception e) {
                        			// nada
                        		}
                        		// Muestro el boton si soy turista
                        		if (turistaLogueado) {
                %>		            
	                <h5 id="label-acciones-relacionadas">Acciones relacionadas:</h5>
	                <ul>
	                    <li><a href="InscribiseASalida?id=<%=infoSalida.getNombre()%>">Inscribirse a la salida</a></li>
	                </ul>
        		<%
        		}
        		%>
            </div>

            <div id="resto-de-la-info-actividad">


                <div class="div-doble" id="FechaYhoraSalida">
                    <h5 class="label">Fecha y hora de partida: </h5>
                    <p><%=infoSalida.getFechaHoraSalidaStr()%> </p>
                </div>
                <div class="div-doble" id="Costo">
                    <h5 class="label">Capacidad de turistas: </h5>
                    <p><%=infoSalida.getCantMaxTuristas()%></p>
                </div>
                <div class="div-doble" id="Cuidad">
                    <h5 class="label">Lugar: </h5>
                    <p><%=infoSalida.getLugarSalida()%></p>
                </div>

            </div>

        </div>
        
        <div id="contenedor-actividades">
        
        	<div class="card" id="contenedor-actividad" style="max-width: 800px;">
	        	<h2 class="card-title">Actividad</h2>
	        	<div class="card mb-3 card-actividad" style="max-width: 800px;">
	                    <div class="row g-0">
	                        <div class="col-md-4 img-contain">

	                            <img src="<%=Utile.obtenerUrlParaImagen(infoSalida.getDtActividad().getImg())%>" class="img-fluid rounded-start">
	                            <!-- Falta el manejo de foto de la verdadero paquete-->
	                        </div>
	                        <div class="col-md-8">
	                            <div class="card-body card-actividad">
	                            	<div>
	                            	<div style="display: flex; justify-content: space-between;">
	                            		<h5 class="card-title"><%= infoSalida.getDtActividad().getNombre()%> </h5>
	                            		
	                            		 <% 
		                                if(session.getAttribute("usuarioLogeado") != null && session.getAttribute("usuarioLogeado") instanceof DtTurista ){ 
		                                	boolean esActividadFavorita = (boolean) request.getAttribute("esFavoritaActividad");
		                                	if(esActividadFavorita){
		                    
			                                %>
			                                	<a href="ConsultaSalida?marcarComoFav=<%=true%>&id=<%=infoSalida.getNombre()%>" ><i class="fa-solid fa-star fa-2x" style="color: #ffc700"></i></a>
			                                
			                                <%} else { %>
			                                
			                                	<a href="ConsultaSalida?marcarComoFav=<%=true%>&id=<%=infoSalida.getNombre()%>"><i class="fa-solid fa-star fa-2x" style="color: #CCD1D1"></i></a>
			                                	
			                                <% } 
		                                	}%>
	                            	</div>	
	                                <p class="card-text descripcion-paquete"><%= infoSalida.getDtActividad().getDescripcion() %> </p>
	                            	</div>                            
	                                <div>
	                                    <a href="ConsultaActividad?id=<%=infoSalida.getDtActividad().getNombre()%>" class="btn btn-primary">Ver mas</a>
	                                </div>
	
	                            </div>
	                        </div>
	                    </div>
	                </div>
        	</div>
        </div>
        

    </section>
</main>


 <jsp:include page="/WEB-INF/jsp/templates/footer.jsp"/>

</body>
</html>