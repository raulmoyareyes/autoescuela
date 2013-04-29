/*
 * 
 */
package Controller;

import Model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "admin", urlPatterns = {"/admin"})
public class _NA_Admin extends HttpServlet {

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

        if (action.equals("/usuarios")) {
            rd = request.getRequestDispatcher("/WEB-INF/admin/usuarios/nuevoUsuario.jsp");
            rd.forward(request, response);
        } else if (action.equals("/preguntas")) {
            rd = request.getRequestDispatcher("");
            rd.forward(request, response);
        } else {
            if (request.getParameter("crear") != null) {
                Usuario u = gestUsuarios(request, response);
            }
            rd = request.getRequestDispatcher("/WEB-INF/admin/usuarios/nuevoUsuario.jsp");
            rd.forward(request, response);
            //response.sendRedirect("admin/usuarios");
        }


    }

    private Usuario gestUsuarios(HttpServletRequest request, HttpServletResponse response) {
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String dni = request.getParameter("dni");
        String direccion = request.getParameter("direccion");
        String tlf = request.getParameter("telefono");
        String password = request.getParameter("pass");
        String password2 = request.getParameter("pass2");
        int grupo;
        //f(request.getParameter("tipo").equals("alumno")){
        grupo = 0;
        //}else{
        //  grupo=1;
        //}

        Usuario u;
        //debemos comprobar que las contraseñas coinciden password y password2
        u = new Usuario(nombre, apellidos, dni, direccion, tlf, password, grupo);
        
        return u;
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
