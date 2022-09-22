<%-- 

# ATTRIBUTOS QUE PRECISA LA PÁGINA

- List<String> departamentos
- List<DTActividadTuristica> actividades (ya deben estar filtradas)
- List<DTPaquete> paquetes (ya deben estar filtradas)

 --%>


<%@page import="logica.datatypes.DTPaquete"%>
<%@page import="logica.datatypes.DTActividadTuristica"%>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilosComun.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/footer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fontawesome-free-6.2.0-web/css/all.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/fontawesome-free-6.2.0-web/js/all.js">

    <title>Turismo UY</title>
</head>
<body>
    <nav class="navbar navbar-dark navbar-expand-lg bg-dark">

        <div class="container-fluid">

            <a class="navbar-brand" href="index.html">Turismo UY</a>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">



                <ul class="navbar-nav d-flex">
                    <form class="d-flex buscar" role="search" id="buscador">
                        <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Search">
                        <button class="btn" ><i class="fas fa-search"></i></button>
                    </form>
                    <div class="dropdown">

                        <a class="nav-link dropdown-toggle nickname_usuario  dropdown-toggle" data-bs-toggle="dropdown" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Washington Rocha
                            <img  class="imagen_perfil " src="${pageContext.request.contextPath}/img/washington.png">
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="perfil_usuario_proveedor_interno.html">Ver Perfil</a></li>
                            <li><a class="dropdown-item" href="index.html">Cerrar Sesión</a></li>
                        </ul>
                    </div>
                </ul>
            </div>
        </div>

    </nav>


    <section id="contenedor">

		<% 
			String idCategoriaMarcada = (String) request.getAttribute("idCategoria");
			String idDepartamentoMarcada = (String) request.getAttribute("idDepartamento");
		%>
		
		

        <div id="menu-lateral">
        
            <!--Acciones generales-->
            <div class="card list-group" id="opciones">
                <h5 class="card-title">Acciones</h5>
                <a href="consulta_de_usuario.html" class="list-group-item">Ver usuarios</a>
                <a href="alta_de_actividad_turistica.html" class="list-group-item">Crear Actividad turistica</a>
            </div>

            <!--Categoroias-->
            <div class="card list-group" id="filtro-categoria">
                <h5 class="card-title">Categorias</h5>
                <%
                	List<String> categoiras = (List<String>) request.getAttribute("categorias"); 
                    for(String cat : categoiras){
                    	if( idCategoriaMarcada != null && idCategoriaMarcada.equals(cat) ){   	
                %>
                			<a href="index?idCategoria=<%= cat %>" class="list-group-item active"><%= cat %></a>	
                
                <% 		} else { %>
                			<a href="index?idCategoria=<%= cat %>" class="list-group-item"><%= cat %></a>	
                
                <% 		}
                    } %>
            </div>

            <!--Departametos-->
            <div class="card list-group" id="filtro-departamentos">
                <h5 class="card-title">Departamentos</h5>
               
					<% 
					List<String> departamentos = (List<String>) request.getAttribute("departamentos");
					
					for(String dep: departamentos){
						if( idDepartamentoMarcada != null && idDepartamentoMarcada.equals(dep) ){ 
						%>
							<a href="index?idDepartamento=<%= dep %>" class="list-group-item active"><%= dep %></a>	
					  <%} else {%>
					  		<a href="index?idDepartamento=<%= dep %>" class="list-group-item"><%= dep %></a>	
				<%		}
					}	%>              
                
            </div>
        </div>

        <div id="contenedor-items">

            <!--Actividades-->

            <div class="card" id="contenedor-actividades-turisticas">
                <h2 class="card-title">Actividades</h2>
                
                	<% 
					List<DTActividadTuristica> actividades = (List<DTActividadTuristica>) request.getAttribute("actividades");
					
					for(DTActividadTuristica actividad: actividades){
						%>
							<div class="card mb-3" style="max-width: 800px;">
			                    <div class="row g-0">
			                        <div class="col-md-4 img-contain">
			                            <img src="${pageContext.request.contextPath}/img/noFoto.png" class="img-fluid rounded-start">
			                            <!-- Falta el manejo de foto de la verdadera actividad -->
			                        </div>
			                        <div class="col-md-8">
			                            <div class="card-body">
			                                <h5 class="card-title"><%= actividad.getNombre() %></h5>
			                                <p class="card-text descripcion-actividad"><%= actividad.getDescripcion() %></p>
			                                <div class="botonera">
			                                    <a href="ConsultaActividadServlet?id=<%=actividad.getNombre()%>" class="btn btn-primary">Ver mas</a>
			                                </div>
			                            </div>
			                        </div>
			                    </div>
			                </div>
						
					<% } %>
                

            </div>


            <!--Paquetes-->

            <div class="card" id="contenedor-paquetes">
                <h2 class="card-title">Paquetes</h2>

			<% 
				List<DTPaquete> paquetes = (List<DTPaquete>) request.getAttribute("paquetes");
					
				for(DTPaquete pack: paquetes){
			%>


                <div class="card mb-3" style="max-width: 800px;">
                    <div class="row g-0">
                        <div class="col-md-4 img-contain">
                            <img src="${pageContext.request.contextPath}/img/noFoto.png" class="img-fluid rounded-start">
                            <!-- Falta el manejo de foto de la verdadero paquete-->
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h5 class="card-title"><%= pack.getNombre()%> </h5>
                                <p class="card-text descripcion-paquete"><%= pack.getDescrpicion()%> </p>
                                <div class="botonera">
                                    <a href="consulta_de_paquete.html" class="btn btn-primary">Ver mas</a>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                
           <% } %>

            </div>
        </div>



    </section>

    <footer id="sticky-footer" class="py-4 bg-dark text-white-50">
        <div class="container text-center">
        <span class="" style="font-size: 25px; color: Grey;">
          <i class="fas fa-route"></i>
        </span>
            <small>Copyright &copy; Grupo 16: Valentina Alaniz, Facundo Diaz, Agustín Martí­nez, Daniel Padrón y Agustí­n Recoba</small>
        </div>
    </footer>


    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.slim.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</body>
</html>