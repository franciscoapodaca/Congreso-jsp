<%-- 
    Document   : consultarPresentaciones
    Created on : 27/04/2015, 02:44:19 AM
    Author     : Kathya
--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Servicios.obtenerParticipantes"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=utf-8>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Gesti&oacute;n Participantes - Consultar Presentaci&oacute;nes Por Per&iacute;odo</title>
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
        <form name="frmConsultar" action="AdmPresentacion">
            <div class="section primary-section" id="service">
                <div class="container">
                    <!-- Start title section -->
                    <div class="title">
                        <h1>Consulta de Presentaciones por Estado</h1>
                        <!-- Section's title goes here -->
                        <!--Simple description for section goes here. -->
                    </div>
                    <div>
                        <center>
                            
                                Estado:<input type="text" name="txtEstado" value="" />
                                <input type="submit" name="consultaEstado" value="Consultar estado" />
                            
                            <br>
                            <br>
                            <table>

                                <tbody>


                                    <%

                                        String estado = request.getParameter("txtEstado");

                                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                                        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/congresoweb", "root", "volave2");
                                        Statement state = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                        String sql = " SELECT * FROM PRESENTACION where estado= '" + estado + "'";
                                        ResultSet tabla = state.executeQuery(sql);
                                        out.print("<table border=3 cellPadding=20><tr>");
                                        out.print("<th>Clave</th><th>Titulo</th><th>Fecha</th><th>Hora</th><th>Tipo de Presentación</th>"
                                                + "<th>Estado</th><th>Participante</th>");
                                        while (tabla.next()) {
                                            out.println("<tr>");
                                            out.println("<td>" + tabla.getString(1) + "</td>");
                                            out.println("<td>" + tabla.getString(2) + "</td>");
                                            out.println("<td>" + tabla.getString(3) + "</td>");
                                            out.println("<td>" + tabla.getString(4) + "</td>");
                                            out.println("<td>" + tabla.getString(5) + "</td>");
                                            out.println("<td>" + tabla.getString(6) + "</td>");
                                            out.println("<td>" + tabla.getString(7) + "</td>");
                                            out.println("</tr>");
                                        }
                                    %>
                                </tbody>
                                </tr>

                            </table>
                           
                        </center>

                    </div>
                    <div class="tablar">
                        <center>

                            <table>
                                <thead>
                                    <tr>
                                <br>       
                                <th><a href="http://localhost:8080/Congreso/gestionPresentaciones.jsp"><input type="button" value="Regresar" name="btn" /></a></th>
                                </br>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </center>

                    </div>
                </div>
            </div>

        </form>

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