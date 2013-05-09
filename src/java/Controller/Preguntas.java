/*
 * 
 */
package Controller;

import Model.Pregunta;
import Model.PreguntaDAO;
//import Model.Usuario;
//import Model.UsuarioDAO;
//import com.oreilly.servlet.multipart.FilePart;
//import com.oreilly.servlet.multipart.MultipartParser;
//import com.oreilly.servlet.multipart.Part;
//import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        
        List<String> temas = PreguntaDAO.numTemas();
        request.setAttribute("unitList", temas);
        

        HttpSession session = request.getSession();
        if (session.getAttribute("currentUser") == null) {
            response.sendRedirect("/autoescuela/login");
            return;
        }

        RequestDispatcher rd;
        request.setAttribute("srvUrl", srvUrl);
        if (action.equals("/listado")) { ///////////////////////////////////////

            List<Pregunta> questList = PreguntaDAO.buscaTodas();
            request.setAttribute("questList", questList);
            rd = request.getRequestDispatcher("/WEB-INF/admin/preguntas/listado.jsp");
            rd.forward(request, response);

        } else if (action.equals("/modifica")) { ///////////////////////////////

            int id = Integer.parseInt(request.getParameter("id"));
            Pregunta p = PreguntaDAO.buscaID(id);
            request.setAttribute("quest", p);
            if (request.getParameter("guardar") != null) {
                if (modificaPregunta(request, response)) {
                    response.sendRedirect("listado");
                } else {
                    request.setAttribute("noModificada", true);
                    rd = request.getRequestDispatcher("/WEB-INF/admin/preguntas/modifica.jsp");
                    rd.forward(request, response);
                }
            } else {
                rd = request.getRequestDispatcher("/WEB-INF/admin/preguntas/modifica.jsp");
                rd.forward(request, response);
            }

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

        } else if (action.equals("/elimina")) { ////////////////////////////////

            int id = Integer.parseInt(request.getParameter("id"));
            Pregunta p = PreguntaDAO.buscaID(id);
            request.setAttribute("quets", p);

            if (PreguntaDAO.eliminaPregunta(p)) {
                response.sendRedirect("listado");
            } else {
                request.setAttribute("noEliminada", true);
                rd = request.getRequestDispatcher("/WEB-INF/admin/preguntas/listado.jsp");
                rd.forward(request, response);
            }

        } else if (action.equals("/test")) { ////////////////////////////////
            
            List<Pregunta> questList;
            if(request.getParameter("tema").equals("global")){
                questList = PreguntaDAO.buscaTemaGlobal(30);
            }else{
                int tema = Integer.parseInt(request.getParameter("tema"));
                questList = PreguntaDAO.buscaTema(tema, 30);
            }
            
            request.setAttribute("questList", questList);
            rd = request.getRequestDispatcher("/WEB-INF/user/preguntas/test.jsp");
            rd.forward(request, response);

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
        String imagen = "no_image.png";

        Pregunta p = new Pregunta(enunciado, respuesta1, respuesta2, respuesta3, respuestaCorrecta, tema, imagen);

        if (PreguntaDAO.insertaPregunta(p)) {
            return true;
        }

        return false;
    }

    private boolean modificaPregunta(HttpServletRequest request, HttpServletResponse response) {
        String enunciado = request.getParameter("enunciado");
        String respuesta1 = request.getParameter("respuesta1");
        String respuesta2 = request.getParameter("respuesta2");
        String respuesta3 = request.getParameter("respuesta3");
        int respuestaCorrecta = Integer.parseInt(request.getParameter("radioRespuesta"));
        int tema = Integer.parseInt(request.getParameter("tema"));
        String imagen = "no_image.png";

        int id = Integer.parseInt(request.getParameter("id"));
        Pregunta p = new Pregunta(enunciado, respuesta1, respuesta2, respuesta3, respuestaCorrecta, tema, imagen, id);
        if (!enunciado.equals("") && !respuesta1.equals("") && !respuesta2.equals("") && !respuesta3.equals("")) {
            PreguntaDAO.modificaPregunta(p);
            return true;
        }
        return false;
    }

    private void subirImagen(HttpServletRequest request) {
//        try {
//            
//            String imagen = request.getParameter("archivo");
//            
//            File dir = new File("/img");
//            MultipartParser mp = new MultipartParser(request, 1024 * 10);
//            Part part;
//            while((part=mp.readNextPart()) != null){
//                if(part.isFile()){
//                    FilePart filepart = (FilePart) part;
//                    filepart.writeTo(dir);
//                }
//            }
//        
//        } catch(IOException e) {}
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
