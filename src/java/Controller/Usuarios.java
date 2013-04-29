/*
 * 
 */
package Controller;

import Model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "usuarios", urlPatterns = {"/usuarios/*"})
public class Usuarios extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String action = (request.getPathInfo() != null ? request.getPathInfo() : "");
        String srvUrl = request.getContextPath() + request.getServletPath();
        RequestDispatcher rd;

        request.setAttribute("srvUrl", srvUrl);

        if (action.equals("/nuevo")) {
            rd = request.getRequestDispatcher("/WEB-INF/admin/usuarios/nuevo.jsp");
        } else if (action.equals("/listado")) {
            rd = request.getRequestDispatcher("/WEB-INF/admin/usuarios/listado.jsp");
        } else if (action.equals("/preparados")) {
            rd = request.getRequestDispatcher("/WEB-INF/admin/usuarios/preparados.jsp");
        } else if (action.equals("/modifica")) {
            rd = request.getRequestDispatcher("/WEB-INF/admin/usuarios/modifica.jsp");
        } else if (action.equals("/elimina")) {
            rd = request.getRequestDispatcher("/WEB-INF/admin/usuarios/listado.jsp");
        }else {
            rd = request.getRequestDispatcher("/WEB-INF/admin/usuarios/nuevo.jsp");
        }
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
