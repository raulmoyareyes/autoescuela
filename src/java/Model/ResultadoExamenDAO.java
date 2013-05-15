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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ResultadoExamenDAO {

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

    public static ResultadoExamen recuperaResultadoExamen(ResultSet rs) {
        ResultadoExamen p = null;
        try {
            //int _id, int _fechaHora, int _acertadas, int _falladas, int _blanco, String _usuario
            p = new ResultadoExamen(rs.getInt("id"), rs.getInt("fechahora"), rs.getInt("acertadas"), rs.getInt("falladas"), rs.getInt("blanco"), rs.getString("usuario"));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return p;
    }

    public static ResultadoExamen buscaID(int id) {
        ResultadoExamen c = null;
        if (openConexion() != null) {
            try {
                String qry = "SELECT * FROM resultadosexamen WHERE id=?";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                stmn.setInt(1, id);
                ResultSet rs = stmn.executeQuery();
                rs.next();
                c = recuperaResultadoExamen(rs);
                rs.close();
                stmn.close();
                closeConexion();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return c;
    }

    public static boolean insertaResultadoExamen(ResultadoExamen r) {
        boolean salida = false;
        if (openConexion() != null) {
            try {

                String qry = "INSERT INTO resultadosexamen (fechahora, acertadas, falladas, blanco, usuario) VALUES(CURRENT_TIMESTAMP,?, ?, ?, ?)";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                stmn.setInt(1, r.getAcertadas());
                stmn.setInt(2, r.getFalladas());
                stmn.setInt(3, r.getBlanco());
                stmn.setString(4, r.getUsuario());

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

    public static int ultimo() {
        int c = -1;
        if (openConexion() != null) {
            try {
                String qry = "SELECT id FROM resultadosexamen ORDER BY fechahora DESC";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                ResultSet rs = stmn.executeQuery();
                rs.next();
                c = rs.getInt("id");
                rs.close();
                stmn.close();
                closeConexion();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return c;
    }

    /**
     * Devuelve el progreso del alumno
     *
     * @param DNI DNI del alumno
     * @return Número entre 0 y 100 indicando del progreso del alumno
     */
    public static float getProgreso(String DNI) {
        int numAcertadas = 0;
        int maxRows = 30;
        if (openConexion() != null) {
            try {
                String qry = "SELECT * FROM resultadosexamen WHERE usuario=? ORDER BY fechahora DESC";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                stmn.setString(1, DNI);
                stmn.setMaxRows(maxRows);
                ResultSet rs = stmn.executeQuery();
                while (rs.next()) {
                    int acertadas = Integer.parseInt(rs.getString("acertadas"));
                    int falladas = Integer.parseInt(rs.getString("falladas"));
                    int blanco = Integer.parseInt(rs.getString("blanco"));
                    int total = acertadas + falladas + blanco;
                    int maxAprobar = (int) Math.floor(0.9 * (float) total);

                    if (acertadas >= maxAprobar) {
                        ++numAcertadas;
                    }
                }
                rs.close();
                stmn.close();
                closeConexion();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return (float) numAcertadas / (float) maxRows * (float) 100.0;
    }

    public static int numExamenes(String DNI) {
        int num = 0;
        if (openConexion() != null) {
            try {
                String qry = "SELECT COUNT(id) NUM FROM resultadosexamen WHERE usuario=?";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                stmn.setString(1, DNI);
                ResultSet rs = stmn.executeQuery();
                rs.next();
                num = rs.getInt("num");
                rs.close();
                stmn.close();
                closeConexion();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return num;
    }

    /**
     * Devuelve el progreso del alumno
     *
     * @param DNI DNI del alumno
     * @param tema Tema
     * @return Número entre 0 y 100 indicando del progreso del alumno
     */
    public static float getProgresoTema(String DNI, int tema) {
        int numAcertadas = 0;
        int maxRows = 30;
        if (openConexion() != null) {
            try {
                String qry = "select RESULTADOSEXAMEN.* "
                        + "    from RESULTADOSEXAMEN, RESULTADOSPREGUNTAS, PREGUNTAS "
                        + "    where RESULTADOSEXAMEN.ID = RESULTADOSPREGUNTAS.EXAMEN "
                        + "        and RESULTADOSPREGUNTAS.PREGUNTA = PREGUNTAS.ID "
                        + "        and RESULTADOSEXAMEN.USUARIO=? and PREGUNTAS.TEMA=? "
                        + "    order by RESULTADOSEXAMEN.FECHAHORA DESC;";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                stmn.setString(1, DNI);
                stmn.setInt(2, tema);
                stmn.setMaxRows(maxRows);
                ResultSet rs = stmn.executeQuery();
                while (rs.next()) {
                    int acertadas = Integer.parseInt(rs.getString("acertadas"));
                    int falladas = Integer.parseInt(rs.getString("falladas"));
                    int blanco = Integer.parseInt(rs.getString("blanco"));
                    int total = acertadas + falladas + blanco;
                    int maxAprobar = (int) Math.floor(0.9 * (float) total);

                    if (acertadas >= maxAprobar) {
                        ++numAcertadas;
                    }
                }
                rs.close();
                stmn.close();
                closeConexion();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return (float) numAcertadas / (float) maxRows * (float) 100.0;
    }
}
