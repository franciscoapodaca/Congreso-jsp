<%-- 
    Document   : agregarParticipante
    Created on : 27/04/2015, 02:05:58 AM
    Author     : Kathya
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=utf-8>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Gesti&oacute;n Participantes - Datos Participante</title>
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
        <form action="AdmParticipantes">
            <div class="section primary-section" id="service">
                <div class="container">
                    <!-- Start title section -->
                    <div class="title">
                        <h1>Actulizaci&oacute;n de Participante</h1>
                        <!-- Section's title goes here -->
                        <p>Favor de ingresar la informaci&oacute;n solicitida</p>
                        <!--Simple description for section goes here. -->
                    </div>
                    <div>
                        <table >                      
                            <tbody>
                                <tr>
                                    <td>Clave:</td>
                                    <% String clave = request.getParameter("txtNomU");%>
                                    <td><input type="text" name="txtClave" value="<%=clave%>" readonly/></td>
                                </tr>
                                <tr>
                                    <%
                                        String nombre = null;
                                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                                        //Este lo genera automaticamente
                                        Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/congresoweb", "root", "volave2");
                                        Statement state = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                        String sql = "select nombre from Participante " + " where clave= '" + clave + "'";
                                        ResultSet tabla = state.executeQuery(sql);
                                        while (tabla.next()) {
                                            nombre = tabla.getString("nombre");
                                        }
                                    %>
                                    <td>Nombre:</td>
                                    <td><input type="text" name="txtNombre" value="<%=nombre%>" required/></td>
                                </tr>
                                <tr>
                                    <%
                                        String email = null;

                                        String sql1 = "select email from Participante " + " where clave= '" + clave + "'";
                                        ResultSet tabla1 = state.executeQuery(sql1);
                                        while (tabla1.next()) {
                                            email = tabla1.getString("email");
                                        }
                                    %> 
                                    <td>Correo Electr&oacute;nico:</td>
                                    <td><input type="email" name="txtEmail" value="<%=email%>"/></td>
                                </tr>
                                <tr>
                                    <%
                                        String tipoP = null;

                                        String sql2 = "select tipoParticipante from Participante " + " where clave= '" + clave + "'";
                                        ResultSet tabla2 = state.executeQuery(sql2);
                                        while (tabla2.next()) {
                                            tipoP = tabla2.getString("tipoParticipante");
                                        }
                                    %> 
                                    <td>Tipo Participante:</td>
                                    <td><select name="txtTipo">
                                            <%if (tipoP.equals("Alumno")) {%>
                                            <option selected>Alumno</option>
                                            <option>Profesionista</option>
                                            <%} else {%>
                                            <option>Alumno</option>
                                            <option selected>Profesionista</option>
                                            <%}%>
                                        </select></td>
                                </tr>
                               
                                    <%
                                            String carrera = null;
                                        if (tipoP.equals("Alumno")) {
                                            
                                            String sql3 = "select carrera from Participante " + " where clave= '" + clave + "'";
                                            ResultSet tabla3 = state.executeQuery(sql3);
                                            while (tabla3.next()) {
                                                carrera = tabla3.getString("carrera");
                                            }
                                        

                                    %> 
                                    
                                    <tr>
                                    <td>Carrera:</td>
                                    <td><input type="text" name="txtCarrera" value="<%=carrera%>" /></td>
                                </tr>
                                     <%
                                     }%>
                                     <%
                                        if(tipoP.equals("Profesionista")){
                                             String sql3 = "select puesto from Participante " + " where clave= '" + clave + "'";
                                            ResultSet tabla3 = state.executeQuery(sql3);
                                            while (tabla3.next()) {
                                                carrera = tabla3.getString("puesto");
                                            }
                                        
                                     %>
                                      <tr>
                                    <td>Puesto:</td>
                                    <td><input type="text" name="txtPuesto" value="<%=carrera%>" /></td>
                                </tr>
                                     <%}%>
                               
                            </tbody>
                        </table>

                    </div>
                    <div class="tablar">
                        <table>
                            <thead>
                                <tr>
                                    <th><input type="submit" value="Actualizar" name="btn" /></th>
                                    <th></th>
                                    <th><a href="http://localhost:8080/Congreso/actualizarParticipante.jsp"><input type="button" value="Cancelar"/></a></th>
                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
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
</html>
