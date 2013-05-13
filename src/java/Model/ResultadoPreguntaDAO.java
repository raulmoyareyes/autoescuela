/*
 * 
 */

package Model;

import static Model.ResultadoExamenDAO.closeConexion;
import static Model.ResultadoExamenDAO.openConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class ResultadoPreguntaDAO {

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
    
    public static ResultadoPregunta recuperaResultadoPregunta(ResultSet rs) {
        ResultadoPregunta p = null;
        try {
            p = new ResultadoPregunta(rs.getInt("examen"), rs.getInt("pregunta"), rs.getInt("resultado"));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return p;
    }

    public static ResultadoPregunta buscaID(int id) {
        ResultadoPregunta c = null;
        if (openConexion() != null) {
            try {
                String qry = "SELECT * FROM resultadospregunta WHERE id=?";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                stmn.setInt(1, id);
                ResultSet rs = stmn.executeQuery();
                rs.next();
                c = recuperaResultadoPregunta(rs);
                rs.close();
                stmn.close();
                closeConexion();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return c;
    }
    
    public static boolean insertaResultadoPregunta(ResultadoPregunta r) {
        boolean salida = false;
        if (openConexion() != null) {
            try {

                String qry = "INSERT INTO resultadospreguntas(examen, pregunta, resultado) VALUES(?, ?, ?)";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                stmn.setInt(1, r.getExamen());
                stmn.setInt(2, r.getPregunta());
                stmn.setInt(3, r.getResultado());

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
}
