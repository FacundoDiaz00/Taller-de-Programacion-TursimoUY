<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="logica.datatypes.DTActividadTuristicaDetalle"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Turismo UY</title>

<!--    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">-->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilosComun.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/alta_de_actividad_turistica.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fontawesome-free-6.2.0-web/css/all.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sweetalert2.min.css">




</head>
<body>
    
	<jsp:include page="/WEB-INF/jsp/templates/navBar.jsp"/>
	
	<%! public String getTextWithoutNull(String value){
			return value == null ? "" : value;
		}
	%>
	
	<%! public <E> List<E> getListWithoutNull(List<E> value){
			return value == null ? new ArrayList<E>() : value;
		}
	%>


    <section id="contenedor">
    
    	<jsp:include page="/WEB-INF/jsp/templates/menuLateral.jsp"/>
        
        <div id="contenedorForm">
            <form class="card" id="form-alta-salida" name="altaSalidaForm" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/AltaDeSalida">
                <div class="card-body">
                    <h5 class="card-title">Alta de Salida Turistica</h5>
                    
                    <% DTActividadTuristicaDetalle datosActividad = (DTActividadTuristicaDetalle) request.getAttribute("datosActividad"); %>

                    <div class="contenedorinput mb-3">
                    	<% String departamento = datosActividad.getDepartamento(); %>
                        <span class="input-label" id="labelDepartamento">Departamento:<span class="obligatorio"> *</span></span>
                        <select 
                        	id="departamento"
                       	   	name="departamento" 
                        	required 
                        	class="form-select" 
                        	aria-label="Departamentos">		
                        </select>
                    </div>

                    <div class="contenedorinput mb-3">
                    	<% String nombre = getTextWithoutNull((String)request.getAttribute("nombre")); %>
                        <span class="input-label">Nombre:<span class="obligatorio"> *</span></span>
                        <input  id="nombre"
                        	   	name="nombre" 
                        		type="text" 
                        		required 
                        		class="form-control" 
                        		placeholder="Ingrese un nombre" 
                        		aria-label="Nombre" 
                        		aria-describedby="basic-addon1"
                        	   	value="<%= nombre %>">
                    </div>

                    <div class="contenedorinput mb-3">
                    	<% String actividad = getTextWithoutNull((String)request.getAttribute("actividad")); %>
                        <span class="input-label" id="labelDepartamento">Departamento:<span class="obligatorio"> *</span></span>
                        <select 
                        	id="actividad"
                       	   	name="actividad" 
                        	required 
                        	class="form-select" 
                        	aria-label="Actividades">
                        
                        <%for (String act: (List<String>) request.getAttribute("actividades")) { 
                        	if (act.equals(actividad)) { %>
                        		<option selected value="<%=act%>"><%=act%></option>
                        	<%} else {%>
                            	<option value="<%=act%>"><%=act%></option>
                        	<%}%>
						<%}%>
						
                        </select>
                    </div>

                    <div class="contenedorinput mb-3">
                    	<% String duracion = getTextWithoutNull((String)request.getAttribute("duracion")); %>
                        <span class="input-label">Duracion:<span class="obligatorio"> *</span></span>
                        <div class="input-group">
                            <input 	type="number" 
                            		min="0" 
                            		id="duracion"
                        	   		name="duracion" 
                        	   	 	value="<%= duracion %>"
                            		required 
                            		class="form-control" 
                            		placeholder="Ingrese una duracion " 
                            		aria-label="Duracion" 
                            		aria-describedby="basic-addon1">
                            <span class="input-group-text" id="basic-addon1">Horas</span>
                        </div>
                    </div>

                    <div class="contenedorinput mb-3 hideArrows" >
                    	<% String costo = getTextWithoutNull((String)request.getAttribute("costo")); %>
                        <span class="input-label">Costo:<span class="obligatorio"> *</span></span>
                        <div class="input-group">
                            <input 	type="number"
                            		step="0.01"
                            		min="0" 
                            		id="costo"
                        	   		name="costo" 
                        	   	 	value="<%= costo %>"
                            		required 
                            		class="form-control" 
                            		placeholder="Ingrese un costo " 
                            		aria-label="Costo" 
                            		aria-describedby="basic-addon1">
                            <span class="input-group-text" id="basic-addon2">$</span>
                        </div>
                    </div>

                    <div class="contenedorinput mb-3">
                    	<% String ciudad = getTextWithoutNull((String)request.getAttribute("ciudad")); %>
                        <span class="input-label">Cuidad:<span class="obligatorio"> *</span></span>
                        <input 	type="text"
                           		id="ciudad"
                       	   		name="ciudad" 
                       	   	 	value="<%= ciudad %>"
                        		required 
                        		class="form-control" 
                        		placeholder="Ingrese una cuidad" 
                        		aria-label="Cuidad" 
                        		aria-describedby="basic-addon1">
                    </div>

                    <div class="contenedorinput mb-3">
                        <span class="input-label">Imagen:</span>
                        <input id="input-imagen" 
                        	   type="file" 
                        	   accept="image/*" 
                        	   name="img" 
                        	   class="form-control" 
                        	   placeholder="Imagen" 
                        	   aria-label="Imagen" 
                        	   aria-describedby="basic-addon1">
                    </div>
                    
                    <div class="contenedorinput mb-3">
                        <span class="input-label">Categorias:</span>
                        <div id="contenedorCategorias">
                                <% 	int i = 0;
                                	for (String cat: getListWithoutNull((List<String>) request.getAttribute("categorias"))) { %>
		                            <div class="form-check">
	                                	<input 	class="form-check-input" 
			                                	id="categoria_<%=i %>"
		                        	   			name="categorias" 
	                                			type="checkbox" 
	                                			value="<%= cat %>" 
	                                			id="flexCheckDefault">
		                                	<label class="form-check-label" for="flexCheckDefault">
		                                    	<%= cat %>
		                                	</label>
		                            </div>
                                <%
                                	i++;
                                } %>
                         </div>
                    </div>


                    <div id="botonera">
                        <a href="index.html" class="btn btn-danger">Cancelar</a>
                        <input type="submit" id="aceptar-boton" class="btn btn-success" value="Aceptar">
                    </div>

                </div>
            </form>
        </div>
        <div></div>


    </section>

   	<jsp:include page="/WEB-INF/jsp/templates/footer.jsp"/>
	<script src="${pageContext.request.contextPath}/js/alta_de_actividad_turistica.js"></script>
    
    <%if(request.getAttribute("motivoDeError") != null){ %>
    
    <script>
    	const mensajeError = "<%= (String) request.getAttribute("motivoDeError")%>"
    	generarMensaje('error', "Error al crear la actividad turística" , mensajeError , 200);
    </script>
    <%} %>
    
    <%if(request.getAttribute("exito") != null){ %>
    
    <script>
    	const mensajeError = "<%= (String) request.getAttribute("motivoDeError")%>"
    	generarMensaje('Exito', "Operacion completada" , "Se ha realizado un alta de actividad satisfactoriamente" , 500);
    </script>
    <%} %>
    
</body>
</html>