<%-- 

# ATTRIBUTOS QUE PRECISA LA PÁGINA

- DTUsuario "usuarioLogeado" (opcional)

 --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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
                    
                    <% if(session.getAttribute("usuarioLogeado") == null){ %>
	                    <li class="alta_de_usuario">
	                        <a class="nav-link active" aria-current="page" href="alta_de_usuario.html">Registrarse</a>
	                    </li>
	                    <li class="iniciar_sesion">
	                        <a class="nav-link active" href="iniciar_sesion.html">Iniciar Sesión</a>
	                    </li>
                    
                    <% }else{ %>
                    
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
                    
                    <% } %>
                    
                </ul>
            </div>
        </div>

    </nav>



