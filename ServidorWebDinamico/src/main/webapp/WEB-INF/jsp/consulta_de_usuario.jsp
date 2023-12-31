<%@page import="utils.Utile"%>
<%@page import="publicar.usuarioturisticasservice.DtProveedor"%>
<%@page import="publicar.usuarioturisticasservice.DtUsuario"%>

<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<jsp:include page="/WEB-INF/jsp/templates/commonHead.jsp"/>
    <link rel="stylesheet" href="css/consulta_de_usuario.css">
    <title>Turismo UY</title>
</head>

<body>
	<jsp:include page="/WEB-INF/jsp/templates/navBar.jsp"/>
	<section id="contenedor">
		<jsp:include page="/WEB-INF/jsp/templates/menuLateral.jsp"/>
		<div id="contenedor-items">
			
            <!--Actividades-->

            <div class="card" id="contenedor-actividades-turisticas">
                <div class="header-card-with-button" style="margin-left: 30px">
                	<h2 class="card-title header_usuarios">Usuarios</h2>
            	</div>
                
                	<%
                                	List<DtUsuario> usuarios = (List<DtUsuario>) request.getAttribute("usuarios");
                                					for(DtUsuario usr: usuarios){
                                	%>
							<div class="card mb-3" style="max-width: 800px; margin-left: 15px">
				                <div class="row g-0">
				                    <div class="col-md-4 img-contain">
				                        <img src="<%=Utile.obtenerUrlParaImagen(usr.getImg())%>" class="img-fluid rounded-start">
				                    </div>
				                    <div class="col-md-8">
				                        <div class="card-body">
				                            <div class="card-body">
				                                <h5 class="card-title"><%=usr.getNombre()%> <%=usr.getApellido()%></h5>
				                                <p class="card-text"><b>Nombre:</b> <%=usr.getNombre()%></p>
				                                <p class="card-text"><b>Apellido:</b> <%= usr.getApellido()%></p>
				                                <p class="card-text"><b>Nickname:</b> <%= usr.getNickname()%></p>
				                                <p class="card-text"><b>Tipo usuario:</b> <%= usr instanceof DtProveedor ? "Proveedor" : "Turista"%></p>
				                                <div class="botonera">
				                                    <a href="ConsultaDeUsuario?id=<%=usr.getNickname()%>&listar=false" class="btn btn-primary">Ver más</a>
				                                </div>
				                            </div>
				                        </div>
				                    </div>
				                </div>
				            </div>
						
					<% } %>
                

            </div>


    </section>
	<jsp:include page="/WEB-INF/jsp/templates/footer.jsp"/>
	
</body>
</html>