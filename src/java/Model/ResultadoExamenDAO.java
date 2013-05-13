/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.PreguntaDAO.closeConexion;
import static Model.PreguntaDAO.openConexion;
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
            p = new ResultadoExamen(rs.getInt("id"),rs.getInt("fechahora"),rs.getInt("acertadas"),rs.getInt("falladas"),rs.getInt("blanco"),rs.getString("usuario"));
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
}
