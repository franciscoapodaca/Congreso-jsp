/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DAO.usuarios;
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
@WebServlet(name = "AdmUsuarios", urlPatterns = {"/AdmUsuarios"})
public class AdmUsuarios extends HttpServlet {

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


            if(btnNom.equals("Enviar")){
                if(!usuarios.validaExistencia(nombreus)){
                     out.print("<script type=\"text/javascript\"> alert(\"El Usuario no existe con ese nombre, Favor de ingresar otro nombre de usuario \");\n" + "</script>");              
                
                 RequestDispatcher rd = request.getRequestDispatcher("capturaNombreUsuario.jsp");
                rd.include(request, response);
                }else{
                    RequestDispatcher rd = request.getRequestDispatcher("actualizarUsuario.jsp");
                rd.include(request, response);
                }
            }
            
            if (btnNom.equals("Registrar")) {
                String nomU, contra, tipo;
                nomU = request.getParameter("txtnomU");
                contra = request.getParameter("txtContra");
                tipo = request.getParameter("txttu");

                if(usuarios.validaExistencia(nomU)){
                    out.print("<script type=\"text/javascript\"> alert(\"El Usuario ya existe con ese nombre, Favor de ingresar otro nombre de usuario \");\n" + "</script>");
                   RequestDispatcher rd = request.getRequestDispatcher("agregarUsuario.jsp");
                rd.include(request, response);
                }else{
                usuarios.agregarUsuario(nomU, contra, tipo);

                out.print("<script type=\"text/javascript\"> alert(\"Se ha agregado el usuario\");\n" + "</script>");
                RequestDispatcher rd = request.getRequestDispatcher("ResultadoUsuarios.jsp");
                rd.include(request, response);
                }
            }

            if (btnNom.equals("Actualizar")) {
                String nomU, contra, tipo;
                nomU = request.getParameter("txtnomU");
                contra = request.getParameter("txtContra");
                tipo = request.getParameter("txttu");

                usuarios.actualizaUsuario(nomU, contra, tipo);
                out.print("<script type=\"text/javascript\"> alert(\"Se ha actualizado el usuario\");\n" + "</script>");
                RequestDispatcher rd = request.getRequestDispatcher("ResultadoUsuarios.jsp");
                rd.include(request, response);
            }
            if (btnNom.equals("Eliminar")) {
                String nombre = request.getParameter("txtNomU");
                usuarios.eliminaUsuarios(nombre);
                out.print("<script type=\"text/javascript\"> alert(\"Se ha eliminado el usuario\");\n" + "</script>");
                RequestDispatcher rd = request.getRequestDispatcher("ResultadoUsuarios.jsp");
                rd.include(request, response);
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
