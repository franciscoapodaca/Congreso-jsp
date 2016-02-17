<%-- 
    Document   : agregarParticipante
    Created on : 27/04/2015, 02:05:58 AM
    Author     : Kathya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta charset=utf-8>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Gesti&oacute;n Participantes - Eliminar Participante</title>
        <!-- Load Roboto font -->
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
        <!-- Load css styles -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link rel="stylesheet" type="text/css" href="css/pluton.css" />
        <!--[if IE 7]>
            <link rel="stylesheet" type="text/css" href="css/pluton-ie7.css" />
        <![endif]-->
        <link rel="stylesheet" type="text/css" href="css/jquery.cslider.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery.bxslider.css" />
        <link rel="stylesheet" type="text/css" href="css/animate.css" />
        <!-- Fav and touch icons -->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/apple-touch-icon-72.png">
        <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57.png">
        <link rel="shortcut icon" href="images/ico/favicon.ico">
        <!-- Iniciar sesión -->
        <script language="javascript" type="text/javascript" src="js/login.js"></script>
        <link rel="stylesheet" type="text/css" href="css/c.css" />
        <!-- Plus Información Congreso -->
        <script language="javascript" type="text/javascript" src="js/pCongreso.js"></script>
        <link rel="stylesheet" type="text/css" href="css/plusCongreso.css" />       
    </head>
    <body>
         <div class="navbar">
            <div class="navbar-inner">
                <div class="container">
                    <a href="#" class="brand">
                        <img src="images/logo.png" width="520" height="40" alt="Logo" />
                        <!-- logo de la página -->
                    </a>
                    <!-- Navegación -->
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <i class="icon-menu"></i>
                    </button>
                    <!-- Ménu de navegación -->
                    <div class="nav-collapse collapse pull-right">
                        <ul class="nav" id="top-navigation">
                            <li class="active"><a href="indexSistema.jsp">Inicio</a></li>
                            <li><a href="gestionPresentaciones.jsp">Gestion Presentaciones</a></li>
                            <li><a href="gestionParticipantes.jsp">Gestion Participantes</a></li>
                            <li><a href="gestionUsuarios.jsp">Gestion Usuarios</a></li>
                            <li><a href="NoImplementada">Cerrar Sesi&oacute;n</a></li>  
                        </ul>
                    </div>
                    <!-- Fin ménu navegación -->
                </div>
            </div>
        </div>
        <div class="section primary-section" id="service">
            <div class="container">
                <!-- Start title section -->
                <div class="title">
                    <h1>Eliminar Participante</h1>
                    <!-- Section's title goes here -->
                    <p>Favor de verificar la informaci&oacute;n</p>
                    <!--Simple description for section goes here. -->
                </div>
                <div>
                    <form action="participantes">
                        
                        <table >                      
                        <tbody>
                            <tr>
                                <td>Clave:</td>
                                <td><input type="text" name="txtClave" value="<%=(String)request.getAttribute("clave")%>" placeholder="CDE00?..." required maxlength="10" readonly="true"/></td>
                            </tr>
                            <tr>
                                <td>Nombre:</td>
                                <td><input type="text" name="txtNombre" value="<%=(String)request.getAttribute("nombre")%>" required readonly="true"/></td>
                            </tr>
                            <tr>
                                <td>Correo Electr&oacute;nico:</td>
                                <td><input type="email" name="txtEmail" value="<%=(String)request.getAttribute("email")%>" placeholder="Ingresa Email" required readonly="true"/></td>
                            </tr>
                            <tr>
                                <td>Tipo Participante:</td>
                                <td><select name="txtTipo" selected="<%=(String)request.getAttribute("tipo")%>" readonly="true">
                                        <option>Alumno</option>
                                        <option>Profesionista</option>
                                    </select></td>
                            </tr>
                            <tr>
                                <td>Carrera:</td>
                                <td><input type="text" name="txtCarrera" value="<%=(String)request.getAttribute("carrera")%>" readonly="true"/></td>
                            </tr>
                            <tr>
                                <td>Puesto:</td>
                                <td><input type="text" name="txtPuesto" value="<%=(String)request.getAttribute("puesto")%>" readonly="true"/></td>
                            </tr>
                        </tbody>
                    </table>

                </div>
                <div class="tablar">
                    <table>
                        <thead>
                            <tr>
                                <th><input type="submit" value="Eliminar" name="boton" /></th>
                                <th></th>
                                <th><a href="http://localhost:8080/Congreso/eliminarParticipante.jsp"><input type="button" value="Cancelar"/></a></th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                    </form>

                </div>
            </div>
        </div>
        
        
        
        <!-- Footer section start -->
        <div class="footer">
            <p>Congreso Internacional &copy; 2015 - Todos los Derechos Reservados</p>
        </div>
        <!-- Footer section end -->
        <!-- ScrollUp button start -->
        <div class="scrollup">
            <a href="#">
                <i class="icon-up-open"></i>
            </a>
        </div>
        <!-- ScrollUp button end -->
        <!-- Include javascript -->
        <script src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery.mixitup.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/modernizr.custom.js"></script>
        <script type="text/javascript" src="js/jquery.bxslider.js"></script>
        <script type="text/javascript" src="js/jquery.cslider.js"></script>
        <script type="text/javascript" src="js/jquery.placeholder.js"></script>
        <script type="text/javascript" src="js/jquery.inview.js"></script>
        <!-- Load google maps api and call initializeMap function defined in app.js -->
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false&amp;callback=initializeMap"></script>
        <!-- css3-mediaqueries.js for IE8 or older -->
        <!--[if lt IE 9]>
            <script src="js/respond.min.js"></script>
        <![endif]-->
        <script type="text/javascript" src="js/app.js"></script>
    </body>
</html>
