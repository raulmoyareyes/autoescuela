/*
 * 
 */
package Controller;

import Model.Usuario;
import Model.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

        HttpSession session = request.getSession();
        Usuario cU = (Usuario) session.getAttribute("currentUser");
        if (session.getAttribute("currentUser") == null) {
            response.sendRedirect("/autoescuela/login");
            return;
        } else {

            if (cU.getGrupo() == 1) {

                if (action.equals("/nuevo")) { /////////////////////////////////////////

                    if (request.getParameter("crear") != null) {
                        if (nuevoUsuario(request, response)) {
                            response.sendRedirect("listado");
                        } else {
                            request.setAttribute("noCreado", true);
                            rd = request.getRequestDispatcher("/WEB-INF/admin/usuarios/nuevo.jsp");
                            rd.forward(request, response);
                        }
                    } else {
                        rd = request.getRequestDispatcher("/WEB-INF/admin/usuarios/nuevo.jsp");
                        rd.forward(request, response);
                    }

                } else if (action.equals("/listado")) { ////////////////////////////////

                    List<Usuario> userList = UsuarioDAO.buscaTodos();
                    request.setAttribute("userList", userList);
                    rd = request.getRequestDispatcher("/WEB-INF/admin/usuarios/listado.jsp");
                    rd.forward(request, response);

                } else if (action.equals("/preparados")) { /////////////////////////////

                    List<Usuario> userList = UsuarioDAO.preparados();
                    request.setAttribute("userList", userList);
                    rd = request.getRequestDispatcher("/WEB-INF/admin/usuarios/preparados.jsp");
                    rd.forward(request, response);

                } else if (action.equals("/modifica")) { ///////////////////////////////

                    String dni = (String) request.getParameter("id");
                    Usuario u = UsuarioDAO.buscaDNI(dni);
                    request.setAttribute("user", u);
                    if (request.getParameter("guardar") != null) {
                        if (modificaUsuario(request, response)) {
                            response.sendRedirect("listado");
                        } else {
                            request.setAttribute("noModificado", true);
                            rd = request.getRequestDispatcher("/WEB-INF/admin/usuarios/modifica.jsp");
                            rd.forward(request, response);
                        }
                    } else {
                        rd = request.getRequestDispatcher("/WEB-INF/admin/usuarios/modifica.jsp");
                        rd.forward(request, response);
                    }

                } else if (action.equals("/elimina")) { ////////////////////////////////

                    String dni = (String) request.getParameter("id");
                    Usuario u = UsuarioDAO.buscaDNI(dni);
                    request.setAttribute("user", u);

                    if (UsuarioDAO.eliminaUsuario(u)) {
                        response.sendRedirect("listado");
                    } else {
                        request.setAttribute("noEliminado", true);
                        rd = request.getRequestDispatcher("/WEB-INF/admin/usuarios/listado.jsp");
                        rd.forward(request, response);
                    }


                } else { ///////////////////////////////////////////////////////////////

                    response.sendRedirect("usuarios/listado");

                }
            } else {
                response.sendRedirect("/autoescuela/estadisticas/mostrar");
            }
        }


    }

    private boolean nuevoUsuario(HttpServletRequest request, HttpServletResponse response) {

        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String dni = request.getParameter("dni");
        String direccion = request.getParameter("direccion");
        String tlf = request.getParameter("telefono");
        String password = request.getParameter("pass");
        String password2 = request.getParameter("pass2");

        int grupo;
        if (request.getParameter("tipo").equals("alumno")) {
            grupo = 0;
        } else {
            grupo = 1;
        }

        Usuario u = new Usuario(nombre, apellidos, dni, direccion, tlf, password, grupo);

        if (password.equals(password2) && !nombre.equals("") && !apellidos.equals("") && !dni.equals("")) {
            UsuarioDAO.insertaUsuario(u);
            return true;
        }
        return false;
    }

    private boolean modificaUsuario(HttpServletRequest request, HttpServletResponse response) {
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String dni = request.getParameter("dni");
        String direccion = request.getParameter("direccion");
        String tlf = request.getParameter("telefono");
        String password = request.getParameter("pass");
        String password2 = request.getParameter("pass2");

        int grupo;
        if (request.getParameter("tipo").equals("Alumno")) {
            grupo = 0;
        } else {
            grupo = 1;
        }

        Usuario u = new Usuario(nombre, apellidos, dni, direccion, tlf, password, grupo);

        if (password.equals(password2) && !nombre.equals("") && !apellidos.equals("") && !dni.equals("")) {
            String oldDNI = (String) request.getParameter("id");
            UsuarioDAO.modificaUsuario(u, oldDNI);
            return true;
        }
        return false;
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
        request.setCharacterEncoding("UTF-8");
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
        request.setCharacterEncoding("UTF-8");
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
