/*
 * 
 */
package Controller;

import Model.Pregunta;
import Model.PreguntaDAO;
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

@WebServlet(name = "preguntas", urlPatterns = {"/preguntas/*"})
public class Preguntas extends HttpServlet {

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
        if (action.equals("/listado")) { ///////////////////////////////////////
            
            List<Pregunta> questList = PreguntaDAO.buscaTodas();
            request.setAttribute("questList", questList);
            rd = request.getRequestDispatcher("/WEB-INF/admin/preguntas/listado.jsp");
            rd.forward(request, response);
            
        } else if (action.equals("/nueva")) { //////////////////////////////////
            
            if (request.getParameter("crear") != null) {
                if (nuevaPregunta(request, response)) {
                    response.sendRedirect("listado");
                } else {
                    request.setAttribute("noCreada", true);
                    rd = request.getRequestDispatcher("/WEB-INF/admin/preguntas/nueva.jsp");
                    rd.forward(request, response);
                }
            } else {
                rd = request.getRequestDispatcher("/WEB-INF/admin/preguntas/nueva.jsp");
                rd.forward(request, response);
            }
            
        } else {
            response.sendRedirect("preguntas/listado");
        }

    }

    private boolean nuevaPregunta(HttpServletRequest request, HttpServletResponse response) {

        String enunciado = request.getParameter("enunciado");
        String respuesta1 = request.getParameter("respuesta1");
        String respuesta2 = request.getParameter("respuesta2");
        String respuesta3 = request.getParameter("respuesta3");
        int respuestaCorrecta = Integer.parseInt(request.getParameter("radioRespuesta"));
        int tema = Integer.parseInt(request.getParameter("tema"));
        //String imagen = request.getParameter("nombre");
        //int id;

        Pregunta p = new Pregunta(enunciado, respuesta1, respuesta2, respuesta3, respuestaCorrecta, tema);

        if(PreguntaDAO.insertaPregunta(p)){
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
