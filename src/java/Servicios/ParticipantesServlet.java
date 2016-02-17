/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DAO.Participantes;
import Entidades.Participante;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ulrick
 */
public class ParticipantesServlet extends HttpServlet {

    Participantes participantes = new Participantes();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("boton");
        try {
            if (accion.equals("Cancelar")) {
                RequestDispatcher rd = request.getRequestDispatcher("gestionParticipantes.jsp");
                rd.forward(request, response);
            }

            if (accion.equals("Registrar")) {
                String clave = request.getParameter("txtClave");
                String nombre = request.getParameter("txtNombre");
                String email = request.getParameter("txtEmail");
                String tipo = request.getParameter("txtTipo");
                String carrera = null;
                String puesto = null;

                if(tipo.equals("Alumno")){
                    carrera = request.getParameter("txtCarrera");
                }
                if(tipo.equals("Profesionista")){
                    puesto = request.getParameter("txtPuesto");
                }
                if (participantes.registraParticipante(clave, nombre, email, tipo, carrera, puesto)) {
                    RequestDispatcher rd = request.getRequestDispatcher("errorParticipante.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("successParticipante.jsp");
                    rd.forward(request, response);
                    
                }
            }

            if (accion.equals("Buscar")) {
                String clave = request.getParameter("txtClave");

                Participante participante = participantes.obtenParticipante(clave);

                if (participante.getClave()==null || participante.getClave().equals("")) {
                    RequestDispatcher rd = request.getRequestDispatcher("errorParticipante.jsp");
                    rd.forward(request, response);
                } else {
                    request.setAttribute("clave", participante.getClave());
                    request.setAttribute("nombre", participante.getNombre());
                    request.setAttribute("email", participante.getEmail());
                    request.setAttribute("tipo", participante.getTipo());
                    request.setAttribute("carrera", participante.getCarrera());
                    request.setAttribute("puesto", participante.getPuesto());
                    
                    RequestDispatcher rd = request.getRequestDispatcher("datosParticipante.jsp");
                    rd.forward(request, response);
                }

            }
            
            if (accion.equals("Consultar")) {
                String clave = request.getParameter("txtClave");

                Participante participante = participantes.obtenParticipante(clave);

                if (participante.getClave()==null || participante.getClave().equals("")) {
                    RequestDispatcher rd = request.getRequestDispatcher("errorParticipante.jsp");
                    rd.forward(request, response);
                } else {
                    request.setAttribute("clave", participante.getClave());
                    request.setAttribute("nombre", participante.getNombre());
                    request.setAttribute("email", participante.getEmail());
                    request.setAttribute("tipo", participante.getTipo());
                    request.setAttribute("carrera", participante.getCarrera());
                    request.setAttribute("puesto", participante.getPuesto());
                    RequestDispatcher rd = request.getRequestDispatcher("participanteConsultado.jsp");
                    rd.forward(request, response);
                }

            }
            
            if(accion.equals("Actualizar")){
                String clave = request.getParameter("txtClave");
                String nombre = request.getParameter("txtNombre");
                String email = request.getParameter("txtEmail");
                String tipo = request.getParameter("txtTipo");
                String carrera = request.getParameter("txtCarrera");
                String puesto = request.getParameter("txtPuesto");
                
                if (participantes.actualizaParticipante(clave, nombre, email, tipo, carrera, puesto)==0) {
                    RequestDispatcher rd = request.getRequestDispatcher("successParticipante.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("errorParticipante.jsp");
                    rd.forward(request, response);
                }
            }
            
            if (accion.equals("Buscar Participante")) {
                String clave = request.getParameter("txtClave");

                Participante participante = participantes.obtenParticipante(clave);

                if (participante.getClave()==null || participante.getClave().equals("")) {
                    RequestDispatcher rd = request.getRequestDispatcher("errorParticipante.jsp");
                    rd.forward(request, response);
                } else {
                    request.setAttribute("clave", participante.getClave());
                    request.setAttribute("nombre", participante.getNombre());
                    request.setAttribute("email", participante.getEmail());
                    request.setAttribute("tipo", participante.getTipo());
                    request.setAttribute("carrera", participante.getCarrera());
                    request.setAttribute("puesto", participante.getPuesto());
                    RequestDispatcher rd = request.getRequestDispatcher("datosParticipanteEliminar.jsp");
                    rd.forward(request, response);
                }

            }
            
            if(accion.equals("Eliminar")){
                String clave = request.getParameter("txtClave");
                
                
                if (participantes.eliminarParticipante(clave)) {
                    
                    RequestDispatcher rd = request.getRequestDispatcher("errorParticipante.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("successParticipante.jsp");
                    rd.forward(request, response);
                }
            }

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("gestionParticipantes.jsp");
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
