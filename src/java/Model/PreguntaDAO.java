/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.UsuarioDAO.closeConexion;
import static Model.UsuarioDAO.openConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class PreguntaDAO {

    private static Connection cnx;
    private static String coonPoolName = "autoescuela";

    public static Connection openConexion() {
        cnx = null;
        try {

            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("jdbc/" + coonPoolName);
            cnx = ds.getConnection();

        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }

        return cnx;
    }

    public static void closeConexion() {
        try {
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public static Pregunta recuperaPregunta(ResultSet rs) {
        Pregunta p = null;
        try {
            //String _enunciado, String _respuesta1, String _respuesta2, String _respuesta3, int _respuestaCorrecta, int _tema, String _imagen, int _id
            p = new Pregunta(rs.getString("enunciado"), rs.getString("respuesta1"), rs.getString("respuesta2"), rs.getString("respuesta3"), rs.getInt("respuestaCorrecta"), rs.getInt("tema"), rs.getString("imagen"), rs.getInt("id"));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return p;
    }

    public static Pregunta buscaID(int id) {
        Pregunta c = null;
        if (openConexion() != null) {
            try {
                String qry = "SELECT * FROM preguntas WHERE id=?";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                stmn.setInt(1, id);
                ResultSet rs = stmn.executeQuery();
                rs.next();
                c = recuperaPregunta(rs);
                rs.close();
                stmn.close();
                closeConexion();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return c;
    }

    public static List<Pregunta> buscaTema(int tema, int numPreguntas) {
        /*
         * Habría que hacer una consulta aleatoria que sólo devuelva n líneas
         */
        List<Pregunta> c = null;
        if (openConexion() != null) {
            try {
                String qry = "SELECT * FROM preguntas WHERE tema=?";

                PreparedStatement stmn = cnx.prepareStatement(qry);
                stmn.setInt(1, tema);
                ResultSet rs = stmn.executeQuery();
                c = new ArrayList<Pregunta>();
                while (rs.next()) {
                    Pregunta aux = recuperaPregunta(rs);
                    c.add(aux);
                }
                rs.close();
                stmn.close();
                closeConexion();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        //Tenemos en c todas las preguntas del tema "tema"
        java.util.Date date = new java.util.Date();
        Collections.shuffle(c, new Random(date.getTime()));
        if (c == null || c.size() < numPreguntas) {
            return c;
        } else {
            return c.subList(0, numPreguntas);
        }
    }

    public static boolean insertaPregunta(Pregunta p) {
        boolean salida = false;
        if (openConexion() != null) {
            try {

                String qry = "INSERT INTO preguntas(enunciado, respuesta1, respuesta2, respuesta3, respuestacorrecta, tema, imagen) VALUES(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                stmn.setString(1, p.getEnunciado());
                stmn.setString(2, p.getRespuesta1());
                stmn.setString(3, p.getRespuesta2());
                stmn.setString(4, p.getRespuesta3());
                stmn.setInt(5, p.getRespuestaCorrecta());
                stmn.setInt(6, p.getTema());
                stmn.setString(7, p.getImagen());

                if (stmn.executeUpdate() > 0) {
                    salida = true;
                }

                stmn.close();
                closeConexion();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return salida;
    }

    public static List<Pregunta> buscaTodas() {
        List<Pregunta> c = null;
        if (openConexion() != null) {
            try {
                String qry = "SELECT * FROM preguntas";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                ResultSet rs = stmn.executeQuery();
                c = new ArrayList<Pregunta>();
                while (rs.next()) {
                    Pregunta aux = recuperaPregunta(rs);
                    c.add(aux);
                }
                rs.close();
                stmn.close();
                closeConexion();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return c;
    }

    public static boolean eliminaPregunta(Pregunta p) {

        boolean salida = false;
        if (openConexion() != null) {
            try {
                String qry = "DELETE FROM preguntas WHERE id=?";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                stmn.setInt(1, p.getId());

                if (stmn.executeUpdate() > 0) {
                    salida = true;
                }

                stmn.close();
                closeConexion();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                return salida;
            }
        }
        return salida;
    }

    public static boolean modificaPregunta(Pregunta p) {
        boolean salida = false;
        if (openConexion() != null) {
            try {
                String qry = "UPDATE preguntas SET enunciado=?, respuesta1=?, respuesta2=?, respuesta3=?, respuestaCorrecta=?, tema=?, imagen=? WHERE id=?";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                stmn.setString(1, p.getEnunciado());
                stmn.setString(2, p.getRespuesta1());
                stmn.setString(3, p.getRespuesta2());
                stmn.setString(4, p.getRespuesta3());
                stmn.setInt(5, p.getRespuestaCorrecta());
                stmn.setInt(6, p.getTema());
                stmn.setString(7, p.getImagen());
                stmn.setInt(8, p.getId());

                if (stmn.executeUpdate() > 0) {
                    salida = true;
                }

                stmn.close();
                closeConexion();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                return salida;
            }
        }
        return salida;
    }
}
