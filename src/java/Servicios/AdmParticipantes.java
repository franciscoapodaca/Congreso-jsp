/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DAO.participante;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kathya
 */
@WebServlet(name = "AdmParticipantes", urlPatterns = {"/AdmParticipantes"})
public class AdmParticipantes extends HttpServlet {

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
        String btnNom = request.getParameter("btn");
        try (PrintWriter out = response.getWriter()) {
            String nombreus = request.getParameter("txtNomU");
            if (btnNom.equals("Enviar")) {
                if (!participante.validaExistencia(nombreus)) {
                    out.print("<script type=\"text/javascript\"> alert(\"El Participante no existe con ese nombre, Favor de ingresar otro clave de participante \");\n" + "</script>");

                    RequestDispatcher rd = request.getRequestDispatcher("capturaClaveParticipante.jsp");
                    rd.include(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("actualizarParticipante.jsp");
                    rd.include(request, response);
                }
            }

            if (btnNom.equals("Registrar")) {
                String clave, nombre, email, tipo, carrera, puesto;
                clave = request.getParameter("txtClave");
                nombre = request.getParameter("txtNombre");
                email = request.getParameter("txtEmail");
                tipo = request.getParameter("txtTipo");
                carrera = request.getParameter("txtCarrera");
                puesto = request.getParameter("txtPuesto");

                if (carrera == null) {
                    carrera = "---";
                }
                if (puesto == null) {
                    puesto = "---";
                }
                if (participante.validaExistencia(clave)) {
                    out.print("<script type=\"text/javascript\"> alert(\"El Participante ya existe con ese nombre, Favor de ingresar de nuevo la clave \");\n" + "</script>");
                    RequestDispatcher rd = request.getRequestDispatcher("capturaClaveTParticipante.jsp");
                    rd.include(request, response);
                } else {
                    participante.agregarParticipante(clave, nombre, email, tipo, carrera, puesto);
                    out.print("<script type=\"text/javascript\"> alert(\"Se ha agregado el participante\");\n" + "</script>");
                    RequestDispatcher rd = request.getRequestDispatcher("ResultadoParticipantes.jsp");
                    rd.include(request, response);

                }
            }
            if (btnNom.equals("Actualizar")) {
                String clave, nombre, email, tipo, carrera, puesto;
                clave = request.getParameter("txtClave");
                nombre = request.getParameter("txtNombre");
                email = request.getParameter("txtEmail");
                tipo = request.getParameter("txtTipo");
                carrera = request.getParameter("txtCarrera");
                puesto = request.getParameter("txtPuesto");
                if (carrera == null) {
                    carrera = "---";
                }
                if (puesto == null) {
                    puesto = "---";
                }
                participante.actualizaParticipante(clave, nombre, email, tipo, carrera, puesto);
                out.print("<script type=\"text/javascript\"> alert(\"Se ha actualizado el participante\");\n" + "</script>");
                RequestDispatcher rd = request.getRequestDispatcher("ResultadoParticipantes.jsp");
                rd.include(request, response);
            }
            if (btnNom.equals("Eliminar")) {
                String nombre = request.getParameter("txtClave");
                
                if(!participante.verificarParticipantePresentaciones(nombre)){
                     out.print("<script type=\"text/javascript\"> alert(\"No se puede eliminar al participante, porque cuenta con presentaciones\");\n" + "</script>");
                RequestDispatcher rd = request.getRequestDispatcher("gestionParticipantes.jsp");
                rd.include(request, response);
                }else{
                participante.eliminaParticipante(nombre);
                out.print("<script type=\"text/javascript\"> alert(\"Se ha eliminado el participante\");\n" + "</script>");
                RequestDispatcher rd = request.getRequestDispatcher("ResultadoParticipantes.jsp");
                rd.include(request, response);
                }
            }
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
