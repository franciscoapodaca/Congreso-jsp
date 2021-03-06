/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

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
@WebServlet(name = "AdmPresentacion", urlPatterns = {"/AdmPresentacion"})
public class AdmPresentacion extends HttpServlet {

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
        String estado= request.getParameter("consultaEstado");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if(estado.equals("Consultar estado")){
                String valor=request.getParameter("txtEstado");
                RequestDispatcher rd = request.getRequestDispatcher("consultarPresentacionesPorEstado.jsp");
                request.setAttribute("txtEstado", valor);
                rd.forward(request, response);
            }
            
            if(estado.equals("Consultar Fecha")){
                String valor=request.getParameter("txtFecha");
                RequestDispatcher rd = request.getRequestDispatcher("consultarPresentacionesPorPeriodo.jsp");
                request.setAttribute("txtFecha", valor);
                rd.forward(request, response);
            }
            
            if(estado.equals("Consultar ponente")){
                String valor=request.getParameter("txtPonente");
                RequestDispatcher rd = request.getRequestDispatcher("consultarPresentacionesPorPonente.jsp");
                request.setAttribute("txtPonente", valor);
                rd.forward(request, response);
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
