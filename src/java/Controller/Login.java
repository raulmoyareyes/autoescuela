/*
 * 
 */
package Controller;

import Model.Usuario;
import Model.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

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
        
        //String action = (request.getPathInfo()!=null?request.getPathInfo():"");
        String srvUrl = request.getContextPath()+request.getServletPath();
        RequestDispatcher rd;
        
        request.setAttribute("srvUrl", srvUrl);
        Usuario u;
        if(request.getParameter("enviar")!=null){
            String dni=request.getParameter("usuario");
            String password=request.getParameter("pass");
            u = UsuarioDAO.compruebaLogin(dni,password);
            request.setAttribute("user",u);
            
            if(u!=null){
                if(u.getGrupo()==0){
                    
                    response.sendRedirect("user");
                }else{
                    response.sendRedirect("admin");
                }
            }else{
                rd=request.getRequestDispatcher("/WEB-INF/login/index.jsp");
                rd.forward(request, response);
            }
        }else{
            u = new Usuario();
            request.setAttribute("user",u);
            rd=request.getRequestDispatcher("/WEB-INF/login/index.jsp");
            rd.forward(request, response);
        }

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
