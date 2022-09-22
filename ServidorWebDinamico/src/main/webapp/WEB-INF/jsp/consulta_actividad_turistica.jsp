<%-- 

# ATRIBUTOS QUE PRECISA LA PÁGINA



 --%>
<%@page import="logica.datatypes.DTActividadTuristica"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	
    
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/consulta_actividad_turistica.css">

    
</head>
<body>
<main>
    <nav class="navbar navbar-dark navbar-expand-lg bg-dark">

        <div class="container-fluid">

            <a class="navbar-brand" href="index.html">Turismo UY</a>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">



                <ul class="navbar-nav d-flex">
                    <form class="d-flex buscar" role="search">
                        <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Search">
                        <button class="btn" ><i class="fas fa-search"></i></button>
                    </form>
                    <li class="alta_de_usuario">
                        <a class="nav-link active" aria-current="page" href="alta_de_usuario.html">Registrarse</a>
                    </li>
                    <li class="iniciar_sesion">
                        <a class="nav-link active" href="iniciar_sesion.html">Iniciar Sesión</a>
                    </li>
                </ul>
            </div>
        </div>

    </nav>

    <section id="contenedor">

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
                <a href="index.html" class="list-group-item">Gastronomí­a</a>
            </div>

            <!--Departametos-->
            <div class="card list-group" id="filtro-departamentos">
                <h5 class="card-title">Departamentos</h5>
                <a href="index.html" class="list-group-item">Rocha</a>
            </div>
        </div>

        <div id="titulo">
            <h1>Consulta de actividad</h1>
        </div>


        <div id="info-actividad">



            <div id="info-general-imagen">
                <img src="${pageContext.request.contextPath}/img/actividad1.png" alt="">
            </div>

            <div id="info">
                <h2>Degusta</h2>
                <h6>Creado el 20/7/2022</h6>
                <h5 id="label-acciones-relacionadas">Acciones relacionadas:</h5>
                <ul>
                    <li><a href="alta_de_salida_turistica.html">Crear una salida turistica</a></li>
                </ul>
            </div>

            <div id="resto-de-la-info-actividad">
                <div id="descripcion">
                    <h5 class="">Descripcion</h5>
                    <p>Festival gastronÃ³mico de productos locales en Rocha</p>
                </div>



                <div class="div-doble" id="Duracion">
                    <h5 class="">Duracion: </h5>
                    <p>3 horas</p>
                </div>
                <div class="div-doble" id="Costo">
                    <h5 class="">Costo: </h5>
                    <p>800$</p>
                </div>
                <div class="div-doble" id="Cuidad">
                    <h5 class="">Cuidad: </h5>
                    <p>Rocha</p>
                </div>
                <div class="div-doble" id="Departamento">
                    <h5 class="">Departamento: </h5>
                    <p>Rocha</p>
                </div>

                <div id="categorias">
                    <h5 class="">Categorias:</h5>
                    <ul>
                        <li> GastronomÃ­a</li>
                    </ul>
                </div>
            </div>

        </div>

        <div id="contenedor-salidas-paquetes">
            <div id="contenedor-items">
                <div class="card" id="contenedor-salidas-turisticas">
                    <h2 class="card-title">Salidas Turisticas:</h2>

                    <div class="card mb-3" style="max-width: 800px;">
                        <div class="row g-0">
                            <div class="col-md-4 img-contain">
                                <img src="${pageContext.request.contextPath}/img/salida1.png" class="img-fluid rounded-start"  style="margin: 10px">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <div class="salidaInfo">
                                        <h5 class="card-title">Degusta Agosto</h5>
                                        <div><strong>Lugar salida: </strong>Sociedad Agropecuaria de Rocha </div>
                                        <div><strong>Fecha y hora de partida: </strong>20/08/2022 17:00 </div>
                                        <div><strong>Capacidad de turistas: </strong>20 </div>
                                        <div><strong>Fecha de creacion: </strong>21/07/2022 </div>

                                    </div>


                                    <div class="botonera">
                                        <a href="consulta_de_salida_turistica.html" class="btn btn-primary">Ver mas</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card mb-3" style="max-width: 800px;">
                        <div class="row g-0">
                            <div class="col-md-4 img-contain">
                                <img src="${pageContext.request.contextPath}/img/salida2.png" class="img-fluid rounded-start"  style="margin: 10px">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <div class="salidaInfo">
                                        <h5 class="card-title">Degusta Setiembre</h5>
                                        <div><strong>Lugar salida: </strong>Sociedad Agropecuaria de Rocha </div>
                                        <div><strong>Fecha y hora de partida: </strong>03/09/2022 17:00 </div>
                                        <div><strong>Capacidad de turistas: </strong>20 </div>
                                        <div><strong>Fecha de creacion: </strong>22/07/2022 </div>

                                    </div>
                                    <div class="botonera">
                                        <a href="consulta_de_salida_turistica.html" class="btn btn-primary">Ver mas</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="card" id="contenedor-paquetes">
                    <h2 class="card-title">Paquetes:</h2>

                    <div class="card mb-3" style="max-width: 800px; margin-right: 20px; margin-top: 15px">
                        <div class="row g-0">
                            <div class="col-md-4 img-contain">
                                <img src="${pageContext.request.contextPath}/img/pack1.png" class="img-fluid rounded-start paquetes" style="margin: 10px">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body cards">
                                    <h5 class="card-title">Disfrutar Rocha</h5>
                                    <p>Actividades para hacer en familia y disfrutar arte y gastronomÃ­a</p>
                                    <div class="botonera">
                                        <a href="consulta_de_paquete.html" class="btn btn-primary">Ver mas</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </section>

    <footer id="sticky-footer" class="py-4 bg-dark text-white-50">
        <div class="container text-center">
            <span class="" style="font-size: 25px; color: Grey;">
                <i class="fas fa-route"></i>
            </span>
            <small>Copyright &copy; Grupo 16: Valentina Alaniz, Facundo Diaz, Agustín MartÃ­nez, Daniel Padrón y Agustín Recoba</small>
        </div>
    </footer>

</main>





<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.slim.min.js"></script>
<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</body>
</html>