/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            //p = new Pregunta(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("dni"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("password"), rs.getInt("grupo"));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return p;
    }
}
